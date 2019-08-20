package hibernate;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import models.mSchedule;

public class dSchedule {
	public static ArrayList<mSchedule> getListScheduleClassName(String className) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mSchedule> listSchedule = new ArrayList<mSchedule> ();
		try {
			String hql = "FROM mSchedule WHERE className = :className";
			Query query = session.createQuery(hql);
			query.setParameter("className", className);
			listSchedule = (ArrayList<mSchedule>)query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listSchedule;
	}
}
