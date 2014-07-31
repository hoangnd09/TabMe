package com.nfc.inovation.tab.me;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.nfc.inovation.tab.me.R;
import com.nfc.inovation.tab.me.authenticate.activity.TabMeLoginActivity;
import com.nfc.inovation.tab.me.util.TabMeConstant;

public abstract class TabMeAuthorizedActivity extends TabMeGeneralActivity {
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
	// editor.putBoolean(TabMeConstant.PREF_IS_LOGIN, false);
	editor.commit();
	Intent intentLogin = new Intent(this, TabMeLoginActivity.class);
	startActivity(intentLogin);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	MenuInflater inflater = getMenuInflater();
	inflater.inflate(R.menu.menu_tabme, menu);
	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case R.id.menu_item_logout:
	    doLogOut();
	    return true;
	default:
	    return super.onOptionsItemSelected(item);
	}
    }
}
