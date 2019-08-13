package hibernate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import models.mPoint;
import models.mSchedule;
import models.mStudent;

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
				mStudent student = new mStudent(0, arrayLine[1], arrayLine[2], arrayLine[3],
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
						Float.parseFloat(arrayLine[5]), Float.parseFloat(arrayLine[6]), Float.parseFloat(arrayLine[7]));
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
}
