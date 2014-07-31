package com.nfc.inovation.tab.me.bizcard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nfc.inovation.tab.me.R;
import com.nfc.inovation.tab.me.TabMeAuthorizedActivity;
import com.nfc.inovation.tab.me.TabMeHomeActivity;

public class BizCardsCategoryActivity extends TabMeAuthorizedActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bizcards_category);
	}
	
	public void onBackButtonClick(View view) {
		Intent intentPersonalUltilities = new Intent(getApplicationContext(), TabMeHomeActivity.class);
        startActivity(intentPersonalUltilities);
	}
	
	public void goToMyBizCards(View view) {
		Intent intentPersonalUltilities = new Intent(getApplicationContext(), BizCardsMyCardsActivity.class);
        startActivity(intentPersonalUltilities);
	}
	
	public void goToMyContacts(View view) {
//		Intent intentPersonalUltilities = new Intent(getApplicationContext(), WelcomeActivity.class);
//        startActivity(intentPersonalUltilities);
	}
}
