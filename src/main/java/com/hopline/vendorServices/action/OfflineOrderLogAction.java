package com.hopline.vendorServices.action;

import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.vendorServices.model.OfflineOrderLogTo;
import com.hopline.vendorServices.sevices.VorderService;

public class OfflineOrderLogAction extends BaseRestAction {

	private OfflineOrderLogTo offlineOrderLogTo;

	public String execute() {
		offlineOrderLogTo = ServiceLocator.getInstance().getService(VorderService.class)
				.createOfflineOrderLog(offlineOrderLogTo);
		return SUCCESS;
	}

	public OfflineOrderLogTo getOfflineOrderLogTo() {
		return offlineOrderLogTo;
	}

	public void setOfflineOrderLogTo(OfflineOrderLogTo offlineOrderLogTo) {
		this.offlineOrderLogTo = offlineOrderLogTo;
	}
}
