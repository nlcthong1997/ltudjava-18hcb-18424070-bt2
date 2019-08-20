package controllers;

import java.util.ArrayList;

import hibernate.dStudentClassName;
import hibernate.result;
import models.mStudent;

public class cStudentClassName {
	public static ArrayList<mStudent> getListStudentClassName (String className) {
		ArrayList<mStudent> listStudent = dStudentClassName.getStudentClassName(className);
		return listStudent;
	}
	
	/**
	 * info [] = { idStudent, nameStudent, identityCard, sex, className }
	 */
	public static result addStudent (String [] info) {
		result rs = null;
		String idStudent = info[0];
		String nameStudent = info[1];
		String identityCard = info[2];
		String sex = info[3];
		String className = info[4];
		mStudent student = new mStudent(0, className, idStudent, nameStudent, sex, identityCard);
		if (dStudentClassName.insertStudent(student)) {
			rs = new result(true, "Them thanh cong", "", 0 , "");
		} else {
			rs = new result(false, "Them that bai", "", 0 , "");
		}
		return rs;
	}
}
