package com.nfc.inovation.tab.me.bizcard.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import oauth.signpost.exception.OAuthException;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.nfc.inovation.tab.me.R;
import com.nfc.inovation.tab.me.TabMeAuthorizedActivity;
import com.nfc.inovation.tab.me.TabMeHomeActivity;
import com.nfc.inovation.tab.me.bizcard.model.BizCardProductModel;
import com.nfc.inovation.tab.me.bizcard.service.BizCardService;
import com.nfc.inovation.tab.me.rest.model.TabMeProductImageModel;

public class BizCardsMyCardsActivity extends TabMeAuthorizedActivity {
	private BizCardItemFrontViewAdaptor cardListViewAdaptor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bizcards_my_cards);

		ListView cardListView = (ListView) findViewById(R.id.bizcard_my_card_list);
		cardListViewAdaptor =
				new BizCardItemFrontViewAdaptor(this, R.layout.activity_bizcards_card_item_front,
						new ArrayList<BizCardProductModel>());
		cardListView.setAdapter(cardListViewAdaptor);

		// setup list item click event.
		cardListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				BizCardProductModel bizCard = (BizCardProductModel) parent.getItemAtPosition(position);
				// Intent intent = new Intent(context,
				// BizCardDetailActivity.class);
				// intent.putExtra(BizCardDetailActivity.PARAM_CARD_ID,
				// bizCard.getId());
				// startActivity(intent);
			}
		});
		// initialize list view elements.
		BizCardProductUpdateTask updateListViewTask = new BizCardProductUpdateTask();
		updateListViewTask.execute((Void) null);
	}

	public void onBackButtonClick(View view) {
		Intent intentPersonalUltilities = new Intent(getApplicationContext(), TabMeHomeActivity.class);
		startActivity(intentPersonalUltilities);
	}

	class BizCardProductUpdateTask extends AsyncTask<Void, Void, Boolean> {
		List<BizCardProductModel> myBizCards;
		private ProgressDialog mDialog;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mDialog = ProgressDialog.show(BizCardsMyCardsActivity.this, "Loading", "Plz wait");
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			BizCardService service = new BizCardService();
			try {
				myBizCards = service.getMyBizCards();
				for (BizCardProductModel myBizCard : myBizCards) {
					List<TabMeProductImageModel> images = service.getBizCardImages(myBizCard.getEntityId());
					myBizCard.setImages(images);
				}
			} catch (OAuthException e) {
				Toast.makeText(BizCardsMyCardsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				Toast.makeText(BizCardsMyCardsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
				e.printStackTrace();
				return false;
			}
			return true;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			mDialog.dismiss();
			cardListViewAdaptor.clear();
			cardListViewAdaptor.addAll(myBizCards);
			cardListViewAdaptor.notifyDataSetChanged();
			super.onPostExecute(result);
		}
		
	}
}
