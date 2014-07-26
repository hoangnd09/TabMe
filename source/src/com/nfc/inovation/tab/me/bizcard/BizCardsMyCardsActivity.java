package com.nfc.inovation.tab.me.bizcard;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.nfc.inovation.tab.me.R;
import com.nfc.inovation.tab.me.TabMeAuthorizedActivity;
import com.nfc.inovation.tab.me.TabMeHomeActivity;

public class BizCardsMyCardsActivity extends TabMeAuthorizedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_bizcards_my_cards);

	ListView cardListView = (ListView) findViewById(R.id.bizcard_my_card_list);
	BizCardItemFrontViewAdaptor cardListViewAdaptor = new BizCardItemFrontViewAdaptor(this,
		R.layout.activity_bizcards_card_item_front, new ArrayList<BizCardModel>());
	cardListView.setAdapter(cardListViewAdaptor);

	// setup list item click event.
	cardListView.setOnItemClickListener(new OnItemClickListener() {
	    @Override
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		BizCardModel bizCard = (BizCardModel) parent.getItemAtPosition(position);
		// Intent intent = new Intent(context,
		// BizCardDetailActivity.class);
		// intent.putExtra(BizCardDetailActivity.PARAM_CARD_ID,
		// bizCard.getId());
		// startActivity(intent);
	    }
	});
	// initialize list view elements.

	cardListViewAdaptor.notifyDataSetChanged();
    }

    public void onBackButtonClick(View view) {
	Intent intentPersonalUltilities = new Intent(getApplicationContext(), TabMeHomeActivity.class);
	startActivity(intentPersonalUltilities);
    }
}
