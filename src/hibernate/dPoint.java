package hibernate;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import models.mPoint;

public class dPoint {
	public static ArrayList<mPoint> getListPoint (String className, String subjectCode) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mPoint> listPoint = new ArrayList<mPoint> ();
		try {
			String hql = "FROM mPoint WHERE className = :className AND subjectCode = :subjectCode";
			Query query = session.createQuery(hql);
			query.setParameter("className", className);
			query.setParameter("subjectCode", subjectCode);
			listPoint = (ArrayList<mPoint>)query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listPoint;
	}
	
	public static boolean updatePoint(String idStudent, String className, String subjectCode, 
			Float diemGK, Float diemCK, Float diemKhac, Float diemTong) {
		boolean flag = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "UPDATE mPoint SET midPoint = :diemGK, endPoint = :diemCK, otherPoint = :diemKhac, totalPoint = :diemTong";
				   hql += " WHERE idStudent = :idStudent AND subjectCode = :subjectCode AND className = :className";
			Query query = session.createQuery(hql);
			query.setParameter("diemGK", diemGK);
			query.setParameter("diemCK", diemCK);
			query.setParameter("diemKhac", diemKhac);
			query.setParameter("diemTong", diemTong);
			query.setParameter("idStudent", idStudent);
			query.setParameter("subjectCode", subjectCode);
			query.setParameter("className", className);
			if (query.executeUpdate() != 0) {
				flag = true;
			}
			transaction.commit();
		} catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return flag;
	}
}
