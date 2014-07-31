package com.nfc.inovation.tab.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nfc.inovation.tab.me.R;
import com.nfc.inovation.tab.me.bizcard.activity.BizCardsCategoryActivity;

public class TabMePersonalUltilityActivity extends TabMeAuthorizedActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabme_personal_ultility);
	}
	
	public void onBackButtonClick(View view) {
		Intent intentPersonalUltilities = new Intent(getApplicationContext(), TabMeHomeActivity.class);
        startActivity(intentPersonalUltilities);
	}
	
	public void goToBizCard(View view) {
		Intent intentPersonalUltilities = new Intent(getApplicationContext(), BizCardsCategoryActivity.class);
        startActivity(intentPersonalUltilities);
	}
}
