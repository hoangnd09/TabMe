package com.nfc.inovation.tab.me.util;

public class TabMeUtil {

	public static boolean isEmailValid(String email) {
		return email.contains("@");
	}

	public static boolean isPasswordValid(String password) {
		return password.length() > 4;
	}

}
