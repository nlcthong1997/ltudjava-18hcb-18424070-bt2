package controllers;

import java.util.ArrayList;

import hibernate.dStudentClassSubject;
import hibernate.result;
import models.mSchedule;
import models.mStudent;
import models.mSubject_student;

public class cStudentClassSubject {
	public static ArrayList<mStudent> getListStudentClassSubject(String classSubject) {
		String [] className_SubjectCode = classSubject.split("\\-");
		ArrayList<String> listIdStudent = dStudentClassSubject.getListIdStudentFromSubjectStudent(className_SubjectCode[0], className_SubjectCode[1]);
		ArrayList<mStudent> listStudent = dStudentClassSubject.getListStudent(listIdStudent);
		return listStudent;
	}
	
	public static result insertStudentOfClassSubject(String idStudent, String classSubject) {
		result rs = null;
		String [] className_subjectCode = classSubject.split("\\-");
		ArrayList<mStudent> listStudent = dStudentClassSubject.getStudent(idStudent);
		ArrayList<mSchedule> listSchedule = dStudentClassSubject.getSchedule(className_subjectCode[0], className_subjectCode[1]);
		ArrayList<mSubject_student> listSub_stu = dStudentClassSubject.getSubject_student(idStudent, className_subjectCode[1]);
		if (listStudent.size() == 1 ) { // check exists
			mStudent student = listStudent.get(0);
			mSchedule schedule = listSchedule.get(0);
			if (listSub_stu.size() == 1) { // check registed
				rs = new result(false, "Sinh vien da dang ky mon nay truoc day !", "", 0, "");
			} else {
				mSubject_student sub_stu = null;
				if ( idStudent.substring(0, 2).equals(classSubject.subSequence(0, 2)) ) { // ex: compare "18"HCB vs "17"424070
					sub_stu = new mSubject_student(0, student.getIdStudent(), className_subjectCode[1], schedule.getSubjectName(), schedule.getClassroom(), className_subjectCode[0], null);
				} else {
					sub_stu = new mSubject_student(0, student.getIdStudent(), className_subjectCode[1], schedule.getSubjectName(), schedule.getClassroom(), className_subjectCode[0], student.getClassName());
				}
				
				if (dStudentClassSubject.insertStudent_SubjectStudent(sub_stu)) {
					rs = new result(true, "Them thanh cong", "", 0, "");
				} else {
					rs = new result(true, "Them that bai", "", 0, "");
				}
			}
		} else {
			rs = new result(false, "Ma sinh vien khong ton tai !", "", 0, "");
		}
		return rs;
	}
	
	public static result deleteStudentOfClassSubject(String idStudent, String classSubject) {
		result rs = null;
		String [] className_subjectCode = classSubject.split("\\-");
		if (dStudentClassSubject.deleteStudent_SubjectStudent(idStudent, className_subjectCode[1])) {
			rs = new result(true, "Xoa thanh cong", "", 0, "");
		} else {
			rs = new result(false, "Xoa that bai", "", 0, "");
		}
		return rs;
	}
}
