package hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import models.mPoint;
import models.mSchedule;

public class dStudent {
	public static ArrayList<studentSubjectPoint> getStudentSubjectPoint(String idStudent) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<studentSubjectPoint> listStudentPoint = new ArrayList<studentSubjectPoint>();
		try {
			String hql = "FROM mPoint p, mSchedule s WHERE p.subjectCode = s.subjectCode AND p.idStudent = :idStudent";
			Query query = session.createQuery(hql);
			query.setParameter("idStudent", idStudent);
			List result = (ArrayList<studentSubjectPoint>) query.list();

			for (int i = 0; i < result.size(); i++) {

				Object[] row = (Object[]) result.get(i);
				mPoint point = (mPoint) row[0];
				mSchedule schedule = (mSchedule) row[1];

				studentSubjectPoint studentPoint = new studentSubjectPoint(point.getIdStudent(), point.getSubjectCode(),
						schedule.getSubjectName(), schedule.getClassroom(), point.getMidPoint(), point.getEndPoint(),
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
