package hibernate;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import models.mUser;

public class dUser {
	public static ArrayList<mUser> login (String username, String password) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "FROM mUser WHERE username = :username AND password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		ArrayList<mUser> listUser = (ArrayList<mUser>)query.list();
		return listUser;
	}
}
