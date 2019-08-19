package controllers;

import java.util.ArrayList;
import hibernate.dPoint;
import hibernate.result;
import models.mPoint;

public class cPoint {
	public static ArrayList<mPoint> getListStudentClassSubjectPoint (String classSubject) {
		String [] className_subjectCode = classSubject.split("\\-");
		ArrayList<mPoint> listPoint = dPoint.getListPoint(className_subjectCode[0], className_subjectCode[1]);
		return listPoint;
	}
	
	public static result updatePointStudent(String [] infoEdit) {
		result rs = null;
		String idStudent = infoEdit[0];
		String [] className_subjectCode = infoEdit[5].split("\\-");
		Float diemGK = Float.parseFloat(infoEdit[1]);
		Float diemCK = Float.parseFloat(infoEdit[2]);
		Float diemKhac = Float.parseFloat(infoEdit[3]);
		Float diemTong = Float.parseFloat(infoEdit[4]);
		boolean check = dPoint.updatePoint(idStudent, className_subjectCode[0], className_subjectCode[1], diemGK, diemCK, diemKhac, diemTong);
		if (check) {
			rs = new result(true, "Chinh sua thanh cong.", "", 0, "");
		} else {
			rs = new result(false, "Chinh sua that bai.", "", 0, "");
		}
		return rs;
	}
	
	public static String[] loadPercent () {
		dPoint.getTotalPoint
	}
}
