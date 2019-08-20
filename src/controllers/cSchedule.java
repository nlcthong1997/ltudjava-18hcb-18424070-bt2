package controllers;

import java.util.ArrayList;

import hibernate.dSchedule;
import models.mSchedule;

public class cSchedule {
	public static ArrayList<mSchedule> getListScheduleClassName(String className) {
		ArrayList<mSchedule> listSchedule = dSchedule.getListScheduleClassName(className);
		return listSchedule;
	}
}
