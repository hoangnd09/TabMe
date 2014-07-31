package com.nfc.inovation.tab.me.bizcard.activity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.nfc.inovation.tab.me.R;
import com.nfc.inovation.tab.me.bizcard.model.BizCardProductModel;
import com.nfc.inovation.tab.me.util.TabMeImageLoader;

public class BizCardItemFrontViewAdaptor extends ArrayAdapter<BizCardProductModel> {
	private int resource;
	private Context context;

	public BizCardItemFrontViewAdaptor(Context context, int resource,
			List<BizCardProductModel> items) {
		super(context, resource, items);
		this.context = context;
		this.resource = resource;
	}

	class ViewHolder {
		NetworkImageView img;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater layout =
					(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layout.inflate(resource, null);
			holder.img = (NetworkImageView) convertView.findViewById(R.id.itemFrontImage);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		BizCardProductModel bizCardProduct = getItem(position);
		if (holder != null) {
			ImageLoader mImageLoader = TabMeImageLoader.getInstance(context).getImageLoader();
			holder.img.setImageUrl(bizCardProduct.getImages().get(0).getUrl(), mImageLoader);
		}
		return convertView;
	}
}
