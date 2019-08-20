package hibernate;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.mStudent;

public class dStudentClassName {
	public static ArrayList<mStudent> getStudentClassName (String className) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mStudent> listStudent = new ArrayList<mStudent> ();
		try {
			String hql = "FROM mStudent WHERE className = :className";
			Query query = session.createQuery(hql);
			query.setParameter("className", className);
			listStudent = (ArrayList<mStudent>)query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listStudent;
	}
	
	public static boolean insertStudent(mStudent student) {
		boolean flag = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			flag = true;
		} catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return flag;
	}
}
