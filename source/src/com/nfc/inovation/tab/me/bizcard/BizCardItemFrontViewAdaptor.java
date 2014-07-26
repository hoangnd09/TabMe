package com.nfc.inovation.tab.me.bizcard;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nfc.inovation.tab.me.R;

public class BizCardItemFrontViewAdaptor extends ArrayAdapter<BizCardModel> {
	private int resource;

	public BizCardItemFrontViewAdaptor(Context context, int resource,
			List<BizCardModel> items) {
		super(context, resource, items);
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout itemView;
		BizCardModel item = getItem(position);

		if (convertView == null) {
			itemView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater layout = (LayoutInflater) getContext()
					.getSystemService(inflater);
			layout.inflate(resource, itemView, true);
		} else {
			itemView = (LinearLayout) convertView;
		}

		ImageView frontImage = (ImageView) itemView.findViewById(R.id.itemFrontImage);
		// TODO: display bizcard item information
		frontImage.setImageResource(R.drawable.ic_launcher);
		return itemView;
	}
}
