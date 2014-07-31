package com.nfc.inovation.tab.me.bizcard.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nfc.inovation.tab.me.rest.model.TabMeProductImageModel;
import com.nfc.inovation.tab.me.rest.model.TabMeProductModel;

public class BizCardProductModel extends TabMeProductModel {
	@SerializedName("biz_card_email")
	private String bizCardEmail;

	@SerializedName("biz_card_fullname")
	private String bizCardFullName;

	@Expose
	private List<TabMeProductImageModel> images;
	
	public String getBizCardEmail() {
		return bizCardEmail;
	}

	public void setBizCardEmail(String bizCardEmail) {
		this.bizCardEmail = bizCardEmail;
	}

	public String getBizCardFullName() {
		return bizCardFullName;
	}

	public void setBizCardFullName(String bizCardFullName) {
		this.bizCardFullName = bizCardFullName;
	}

	public List<TabMeProductImageModel> getImages() {
		return images;
	}

	public void setImages(List<TabMeProductImageModel> images) {
		this.images = images;
	}
	
	
}
