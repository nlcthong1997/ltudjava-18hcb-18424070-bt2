package hibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

import models.mUser;

public class dUser {
	public static void getUsers () {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from mUser");
		ArrayList<mUser> listUser = (ArrayList<mUser>)query.list();
		for (mUser user : listUser) {
			System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getType() );
		}
	}
}
