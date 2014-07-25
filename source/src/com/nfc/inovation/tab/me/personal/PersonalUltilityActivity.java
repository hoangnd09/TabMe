package com.nfc.inovation.tab.me.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nfc.inovation.tab.me.R;
import com.nfc.inovation.tab.me.WelcomeActivity;
import com.nfc.inovation.tab.me.authenticate.TabMeAuthorizedActivity;
import com.nfc.inovation.tab.me.bizcard.BizCardsCategoryActivity;

public class PersonalUltilityActivity extends TabMeAuthorizedActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_ultility);
	}
	
	public void onBackButtonClick(View view) {
		Intent intentPersonalUltilities = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(intentPersonalUltilities);
	}
	
	public void goToBizCard(View view) {
		Intent intentPersonalUltilities = new Intent(getApplicationContext(), BizCardsCategoryActivity.class);
        startActivity(intentPersonalUltilities);
	}
}
