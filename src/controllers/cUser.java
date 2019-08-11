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
			return new result(false, "Tai khoan khong dung", "", "", "");
		}
	}
}
