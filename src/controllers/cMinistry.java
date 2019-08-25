package controllers;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import hibernate.dMinistry;
import models.mStudent;
import models.mSubject_student;
import hibernate.result;
import models.mPoint;
import models.mReference;
import models.mSchedule;

public class cMinistry {
	
	public static result importCSV (String type) {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		if (type.equals("dslop")) {
			jfc.setDialogTitle("Import danh sach lop");
		}
		if (type.equals("tkb")) {
			jfc.setDialogTitle("Import thoi khoa bieu");
		}
		if (type.equals("bangdiem")) {
			jfc.setDialogTitle("Import bang diem");
		}
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose file *.csv or *.txt", "csv", "txt");
		jfc.addChoosableFileFilter(filter);
		
		boolean flag = false;
		String progess = "pending";
		
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			String path = jfc.getSelectedFile().getPath();
			try {
				if (type.equals("dslop")) {
					ArrayList<mStudent> listStudent = dMinistry.readCsvStudent(path);
					flag = dMinistry.writeCsvStudent(listStudent);
					mappingSubjectAndStudent();
				}
				if (type.equals("tkb")) {
					ArrayList<mSchedule> listSchedule = dMinistry.readCsvSchedule(path);
					flag = dMinistry.writeCsvSchedule(listSchedule);
					mappingSubjectAndStudent();
				}
				if (type.equals("bangdiem")) {
					ArrayList<mPoint> listPoint = dMinistry.readCsvPoint(path);
					flag = dMinistry.writeCsvPoint(listPoint);
				}
				
				progess = flag ? "success" : "fail";
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return returnResult(progess);
	}
	
	public static result returnResult (String progess) {
		result rs = null;
		switch (progess) {
			case "fail":
				rs = new result(true, "Import that bai.", "", 0, "");
				break;
			case "pending":
				rs = new result(false, "", "", 0, "");
				break;
			case "success":
				rs = new result(true, "Import thanh cong.", "", 0, "");
				break;
		}
		return rs;
	}
	
	public static void mappingSubjectAndStudent () {
		ArrayList<mStudent> listStudent = dMinistry.getAllStudent();
		ArrayList<mSchedule> listSchedule = dMinistry.getAllSchedule();
		if (listStudent.size() > 0 && listSchedule.size() > 0) {
			dMinistry.deleteAllSubject_student(); // delete all
			ArrayList<mSubject_student> listSubject_student = new ArrayList<mSubject_student>();
			for (mStudent student : listStudent) {
				for (mSchedule schedule : listSchedule) {
					if (student.getClassName().equals(schedule.getClassName())) {
						mSubject_student sub_stu = new mSubject_student(0, student.getIdStudent(), schedule.getSubjectCode(), schedule.getSubjectName(), schedule.getClassroom(), schedule.getClassName(), null);
						listSubject_student.add(sub_stu);
					}
				}
			}
			dMinistry.writeSubject_student(listSubject_student); // add all
		}
	}
	
	public static ArrayList<String> getListClassName () {
		return dMinistry.getAllClassDistinct();
	}
	
	public static ArrayList<String> getListClassSubjects () {
		ArrayList<mSchedule> listSchedule = dMinistry.getAllSchedule();
		ArrayList<String> listClassSubject = new  ArrayList<String> ();
		for (mSchedule schedule : listSchedule) {
			if(!listClassSubject.contains(schedule.getClassName() + "-" + schedule.getSubjectCode())) {
				listClassSubject.add(schedule.getClassName() + "-" + schedule.getSubjectCode());
			}
		}
		Collections.sort(listClassSubject);
		return listClassSubject;
	}
	
	public static result createReferences(String fromDate, String toDate) {
		result rs = null;
		try {
			Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
			Date fromdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
			ArrayList<mSchedule> listSchedule = dMinistry.getAllSchedule();
			ArrayList<mReference> listReference = new ArrayList<mReference> ();
			for (mSchedule schedule : listSchedule) {
				mReference reference = new mReference (1, fromdate, schedule.getSubjectCode(), schedule.getSubjectName(), todate);
				listReference.add(reference);
			}
			boolean created = dMinistry.createReferences(listReference);
			if (created) {
				rs = new result (true, "Tao phuc khao thanh cong", "", 0, "");
			} else {
				rs = new result (false, "Tao phuc khao that bai", "", 0, "");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
