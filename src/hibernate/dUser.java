package hibernate;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.mStudent;
import models.mUser;

public class dUser {
	public static ArrayList<mUser> login (String username, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mUser> listUser = new ArrayList<mUser> ();
		try {
			String hql = "FROM mUser WHERE username = :username AND password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("username", username);
			query.setParameter("password", password);
			listUser = (ArrayList<mUser>)query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listUser;
	}
	
	public static ArrayList<mUser> getTypeUser (int idUser) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mUser> user = new ArrayList<mUser> ();
		try {
			String hql = "FROM mUser WHERE id = :idUser";
			Query query = session.createQuery(hql);
			query.setParameter("idUser", idUser);
			user = (ArrayList<mUser>)query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return user;
	}
	
	public static Long confirmPasswordCurrent (int idUser, String passwordCurrent) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long count = null;
		try {
			String hql = "SELECT count(*) FROM mUser u WHERE u.id = :idUser AND u.password = :passwordCurrent";
			Query query = session.createQuery(hql);
			query.setParameter("idUser", idUser);
			query.setParameter("passwordCurrent", passwordCurrent);
			count = (Long)query.uniqueResult();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return count;
	}
	
	public static boolean changePassword(int idUser, String passwordNew) {
		boolean flag = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "UPDATE mUser SET password = :passwordNew WHERE id = :idUser";
			Query query = session.createQuery(hql);
			query.setParameter("passwordNew", passwordNew);
			query.setParameter("idUser", idUser);
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
