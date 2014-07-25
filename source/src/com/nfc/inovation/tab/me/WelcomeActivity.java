package com.nfc.inovation.tab.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.nfc.inovation.tab.me.authenticate.TabMeAuthorizedActivity;
import com.nfc.inovation.tab.me.personal.PersonalUltilityActivity;

public class WelcomeActivity extends TabMeAuthorizedActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		LinearLayout linkToPersonalUltilities = (LinearLayout) findViewById(R.id.linkToPersonalUltilities);
		linkToPersonalUltilities.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intentPersonalUltilities = new Intent(getApplicationContext(), PersonalUltilityActivity.class);
		        startActivity(intentPersonalUltilities);
			}
		});
		
	}
}
