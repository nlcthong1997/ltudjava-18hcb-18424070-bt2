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
	
	/**
	 * return [totalStudentPointPass, totalStudentPointMiss, percentStudentPass, persentStudentMiss] 
	 */
	public static ArrayList<Long> loadQuantityAndPercentPoint (String classSubject) {
		String [] className_subjectCode = classSubject.split("\\-");
		ArrayList<Long> listResult = new ArrayList<Long>();
		Long totalStudentPoints = (long) 0, totalStudentPointPass, totalStudentPointMiss, percentStudentPass = (long) 0, persentStudentMiss = (long) 0;
		
		totalStudentPoints = dPoint.getTotalNumberStudentPoint(className_subjectCode[0], className_subjectCode[1], (float) 0);
		totalStudentPointPass = dPoint.getTotalNumberStudentPoint(className_subjectCode[0], className_subjectCode[1], (float) 5);
		totalStudentPointMiss = totalStudentPoints - totalStudentPointPass;
		if (totalStudentPoints != 0) {
			percentStudentPass =  (totalStudentPointPass * 100) / totalStudentPoints;
			persentStudentMiss = 100 - percentStudentPass;
		}
		
		listResult.add(totalStudentPointPass);
		listResult.add(totalStudentPointMiss);
		listResult.add(percentStudentPass);
		listResult.add(persentStudentMiss);
		
		return listResult;
	}
}
