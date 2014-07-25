package com.nfc.inovation.tab.me.bizcard;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nfc.inovation.tab.me.R;
import com.nfc.inovation.tab.me.WelcomeActivity;
import com.nfc.inovation.tab.me.authenticate.TabMeAuthorizedActivity;

public class BizCardsMyCardsActivity extends TabMeAuthorizedActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bizcards_my_cards);
	}
	
	public void onBackButtonClick(View view) {
		Intent intentPersonalUltilities = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(intentPersonalUltilities);
	}
}

class BizCardListViewAdaptor extends ArrayAdapter<Object> {
	private int resource;
	
	public BizCardListViewAdaptor(Context context, int resource, List<Object> items) {
		super(context, resource, items);
		this.resource = resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout itemView;
		Object item = getItem(position);
		
		if (convertView == null) {
			itemView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater layout = (LayoutInflater)getContext().getSystemService(inflater);
            layout.inflate(resource, itemView, true);
		} else{
			itemView = (LinearLayout) convertView;
        }
		
		ImageView frontImage = (ImageView) itemView.findViewById(R.id.itemFrontImage);
		// TODO:
		// frontImage.setImageResource(R.drawable.ic_launcher);
		return itemView;
	}
}