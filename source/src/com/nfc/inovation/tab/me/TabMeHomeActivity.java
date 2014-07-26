package com.nfc.inovation.tab.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;


public class TabMeHomeActivity extends TabMeAuthorizedActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabme_home);
		
		LinearLayout linkToPersonalUltilities = (LinearLayout) findViewById(R.id.linkToPersonalUltilities);
		linkToPersonalUltilities.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intentPersonalUltilities = new Intent(getApplicationContext(), TabMePersonalUltilityActivity.class);
		        startActivity(intentPersonalUltilities);
			}
		});
		
	}
}
