package controllers;

import java.util.ArrayList;

import hibernate.dUser;
import hibernate.result;
import models.mUser;

public class cUser {
	public static result login (String username, String password) {
		ArrayList<mUser> user = dUser.login(username, password);
		if (user.size() > 0) {
			return new result(true, "Dang nhap thanh cong", user.get(0).getType(), user.get(0).getId(), user.get(0).getUsername()); 
		} else {
			return new result(false, "Tai khoan khong dung", "", 0, "");
		}
	}
	
	public static String getTypeUser (int idUser) {
		ArrayList<mUser> listUser = dUser.getTypeUser(idUser);
		mUser user = listUser.get(0);
		return user.getType();
	}
	
	public static result changePassword(int idUser, String passwordNew, String passwordCurrent) {
		result rs = null;
		Long count = dUser.confirmPasswordCurrent(idUser, passwordCurrent);
		if (count != 0) {
			if (dUser.changePassword(idUser, passwordNew)) {
				rs = new result (true, "Doi mat khau thanh cong", "", 0, "");
			} else {
				rs = new result (false, "Doi mat khau that bai", "", 0, "");
			}
		} else {
			rs = new result (false, "Mat khau hien tai khong dung.", "", 0, "");
		}
		return rs;
	}
}
