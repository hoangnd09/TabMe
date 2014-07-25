package com.nfc.inovation.tab.me.authenticate;

import android.content.Intent;
import android.content.SharedPreferences;

import com.nfc.inovation.tab.me.util.TabMeConstant;


public abstract class TabMeAuthorizedActivity extends TabMeActivity {
	@Override
	protected void onStart() {
		super.onStart();
		SharedPreferences settings = getSharedPreferences(TabMeConstant.PREF_NAME, 0);
		boolean isloggedIn = settings.getBoolean(TabMeConstant.PREF_IS_LOGIN, false);
		if (!isloggedIn) {
			Intent intentLogin = new Intent(this, TabMeLoginActivity.class);
			startActivity(intentLogin);
		}
	}
	
	private void doLogOut() {
		SharedPreferences settings = getSharedPreferences(TabMeConstant.PREF_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.remove(TabMeConstant.PREF_IS_LOGIN);
		//editor.putBoolean(TabMeConstant.PREF_IS_LOGIN, false);
		editor.commit();
		Intent intentLogin = new Intent(this, TabMeLoginActivity.class);
		startActivity(intentLogin);
	}
}
