package hibernate;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.mSchedule;
import models.mStudent;
import models.mSubject_student;

public class dStudentClassSubject {
	public static ArrayList<String> getListIdStudentFromSubjectStudent (String className, String subjectCode) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<String> listIdStudent = new ArrayList<String> ();
		try {
			String hql = "SELECT s.idStudent FROM mSubject_student s WHERE s.subjectCode = :subjectCode AND s.className = :className";
			Query query = session.createQuery(hql);
			query.setParameter("className", className);
			query.setParameter("subjectCode", subjectCode);
			listIdStudent = (ArrayList<String>)query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listIdStudent;
	} 
	
	public static ArrayList<mStudent> getListStudent (ArrayList<String> listIdStudent) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mStudent> listStudent = new ArrayList<mStudent> ();
		try {
			String hql = "FROM mStudent WHERE idStudent IN :listIDStudent";
			Query query = session.createQuery(hql);
			if (listIdStudent.size() == 0) {
				query.setParameter("listIDStudent", "");
			} else {
				query.setParameter("listIDStudent", listIdStudent);
			}
			listStudent = (ArrayList<mStudent>)query.list();
		}  catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listStudent;
	}
	
	public static ArrayList<mStudent> getStudent(String idStudent) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mStudent> listStudent = new ArrayList<mStudent> ();
		try {
			String hql = "FROM mStudent WHERE idStudent = :IdStudent";
			Query query = session.createQuery(hql);
			query.setParameter("IdStudent", idStudent);
			listStudent = (ArrayList<mStudent>)query.list();
		}  catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listStudent;
	}
	
	public static ArrayList<mSchedule> getSchedule(String className, String subjectCode) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mSchedule> listSchedule = new ArrayList<mSchedule> ();
		try {
			String hql = "FROM mSchedule WHERE className = :className AND subjectCode = :subjectCode";
			Query query = session.createQuery(hql);
			query.setParameter("className", className);
			query.setParameter("subjectCode", subjectCode);
			listSchedule = (ArrayList<mSchedule>)query.list();
		}  catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listSchedule;
	}
	
	public static ArrayList<mSubject_student> getSubject_student(String idStudent, String subjectCode) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<mSubject_student> listSub_stu = new ArrayList<mSubject_student> ();
		try {
			String hql = "FROM mSubject_student WHERE idStudent = :idStudent AND subjectCode = :subjectCode";
			Query query = session.createQuery(hql);
			query.setParameter("idStudent", idStudent);
			query.setParameter("subjectCode", subjectCode);
			listSub_stu = (ArrayList<mSubject_student>)query.list();
		}  catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listSub_stu;
	}
	
	public static boolean insertStudent_SubjectStudent(mSubject_student sub_stu) {
		boolean flag = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(sub_stu);
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