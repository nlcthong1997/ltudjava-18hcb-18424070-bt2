package controllers;

import java.util.ArrayList;

import hibernate.studentSubjectPoint;
import hibernate.dStudent;

public class cStudent {
	public static ArrayList<studentSubjectPoint> getListStudentPoint (String idStudent) {
		ArrayList<studentSubjectPoint> listStudentPoint = dStudent.getStudentSubjectPoint(idStudent);
		return listStudentPoint;
	}
}
