package com.nfc.inovation.tab.me.bizcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nfc.inovation.tab.me.R;
import com.nfc.inovation.tab.me.WelcomeActivity;
import com.nfc.inovation.tab.me.authenticate.TabMeAuthorizedActivity;

public class BizCardsCategoryActivity extends TabMeAuthorizedActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bizcards_category);
	}
	
	public void onBackButtonClick(View view) {
		Intent intentPersonalUltilities = new Intent(getApplicationContext(), WelcomeActivity.class);
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
