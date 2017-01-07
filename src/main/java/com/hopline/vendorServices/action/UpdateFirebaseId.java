package com.hopline.vendorServices.action;

import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.vendorServices.sevices.VorderService;

public class UpdateFirebaseId extends BaseRestAction {
	private String firebaseId;	
	private Integer shopId; 
	private boolean success;


	public String execute() {
		success = ServiceLocator.getInstance().getService(VorderService.class).updateFirebaseId(firebaseId, shopId);
		return SUCCESS;
	}

	public String getFirebaseId() {
		return firebaseId;
	}

	public void setFirebaseId(String firebaseId) {
		this.firebaseId = firebaseId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}