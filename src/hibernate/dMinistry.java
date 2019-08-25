package hibernate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.mPoint;
import models.mReference;
import models.mSchedule;
import models.mStudent;
import models.mUser;
import models.mSubject_student;

public class dMinistry {
	
	public static ArrayList<mStudent> readCsvStudent(String path) throws IOException {
		ArrayList<mStudent> listStudent = new ArrayList<mStudent>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			String arrayLine[];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
				mStudent student = new mStudent(1, arrayLine[1], arrayLine[2], arrayLine[3],
						arrayLine[4], arrayLine[5]);
				listStudent.add(student);
			}
		} catch (IOException e) {
			listStudent = null;
			e.printStackTrace();
		}
		br.close();
		return listStudent;
	} 
	
	public static boolean writeCsvStudent(ArrayList<mStudent> listStudent) {
		boolean flag = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (mStudent student : listStudent) {
				session.save(student);
			}
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
	
	public static ArrayList<mSchedule> readCsvSchedule (String path) throws IOException {
		ArrayList<mSchedule> listSchedule = new ArrayList<mSchedule>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			String arrayLine[];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
				mSchedule schedule = new mSchedule(0, arrayLine[1], arrayLine[2], arrayLine[3], arrayLine[4]);
				listSchedule.add(schedule);
			}
		} catch (IOException e) {
			listSchedule = null;
			e.printStackTrace();
		}
		br.close();
		return listSchedule;
	}
	
	public static boolean writeCsvSchedule (ArrayList<mSchedule> listSchedule) {
		boolean flag = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (mSchedule schedule : listSchedule) {
				session.save(schedule);
			}
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
	
	public static ArrayList<mPoint> readCsvPoint (String path) throws IOException {
		ArrayList<mPoint> listPoint = new ArrayList<mPoint>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			String arrayLine[];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
				mPoint point = new mPoint(0, arrayLine[1], arrayLine[2], arrayLine[3], Float.parseFloat(arrayLine[4]),
						Float.parseFloat(arrayLine[5]), Float.parseFloat(arrayLine[6]), Float.parseFloat(arrayLine[7]), arrayLine[8]);
				listPoint.add(point);
			}
		} catch (IOException e) {
			listPoint = null;
			e.printStackTrace();
		}
		br.close();
		return listPoint;
	}
	
	public static boolean writeCsvPoint (ArrayList<mPoint> listPoint) {
		boolean flag = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (mPoint point : listPoint) {
				session.save(point);
			}
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
	
	public static ArrayList<String> getAllClassDistinct () {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<String> listStudent = new ArrayList<String> ();
		try {
			String hql = "SELECT DISTINCT(s.className) FROM mStudent s";
			Query query = session.createQuery(hql);
			listStudent = (ArrayList<String>)query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listStudent;
	}
	
	public static ArrayList<mStudent> getAllStudent () {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mStudent> listStudent = new ArrayList<mStudent> ();
		try {
			String hql = "FROM mStudent";
			Query query = session.createQuery(hql);
			listStudent = (ArrayList<mStudent>)query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listStudent;
	}
	
	public static ArrayList<mSchedule> getAllSchedule () {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mSchedule> listSchedule = new ArrayList<mSchedule> ();
		try {
			String hql = "FROM mSchedule";
			Query query = session.createQuery(hql);
			listSchedule = (ArrayList<mSchedule>)query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listSchedule;
	}
	
	public static void deleteAllSubject_student () {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "DELETE FROM mSubject_student s WHERE s.type IS NULL";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
	}
	
	public static boolean writeSubject_student(ArrayList<mSubject_student> listSubject_student) {
		boolean flag = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (mSubject_student sub_stu : listSubject_student) {
				session.save(sub_stu);
			}
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
	
	public static boolean createReferences (ArrayList<mReference> listReference) {
		boolean flag = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (mReference ref : listReference) {
				session.save(ref);
			}
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
