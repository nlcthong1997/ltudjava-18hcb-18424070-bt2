package hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory =  configuration.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
