package hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import models.mPoint;
import models.mSubject_student;

public class dStudent {
	public static ArrayList<studentSubjectPoint> getStudentSubjectPoint(String idStudent) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<studentSubjectPoint> listStudentPoint = new ArrayList<studentSubjectPoint>();
		try {
			String hql = "FROM mPoint p, mSubject_student s WHERE p.idStudent = s.idStudent AND p.subjectCode = s.subjectCode AND s.idStudent = :idStudent";
			Query query = session.createQuery(hql);
			query.setParameter("idStudent", idStudent);
			List result = (ArrayList<studentSubjectPoint>) query.list();

			for (int i = 0; i < result.size(); i++) {

				Object[] row = (Object[]) result.get(i);
				mPoint point = (mPoint) row[0];
				mSubject_student sub_stu = (mSubject_student) row[1];

				studentSubjectPoint studentPoint = new studentSubjectPoint(sub_stu.getIdStudent(), sub_stu.getSubjectCode(),
						sub_stu.getNameSubject(), sub_stu.getClassroom(), point.getMidPoint(), point.getEndPoint(),
						point.getOtherPoint(), point.getTotalPoint());
				listStudentPoint.add(studentPoint);
			}
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return listStudentPoint;
	}
}
