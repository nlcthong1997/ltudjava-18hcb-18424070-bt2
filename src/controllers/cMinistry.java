package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import hibernate.dMinistry;
import models.mStudent;
import models.mPoint;
import models.mSchedule;

public class cMinistry {
	public static void importListStudent (String type) {
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
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			String path = jfc.getSelectedFile().getPath();
			try {
				if (type.equals("dslop")) {
					ArrayList<mStudent> listStudent = dMinistry.readCsvStudent(path);
					flag = dMinistry.writeCsvStudent(listStudent);
				}
				if (type.equals("tkb")) {
					ArrayList<mSchedule> listSchedule = dMinistry.readCsvSchedule(path);
					flag = dMinistry.writeCsvSchedule(listSchedule);
				}
				if (type.equals("bangdiem")) {
					ArrayList<mPoint> listPoint = dMinistry.readCsvPoint(path);
					flag = dMinistry.writeCsvPoint(listPoint);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
