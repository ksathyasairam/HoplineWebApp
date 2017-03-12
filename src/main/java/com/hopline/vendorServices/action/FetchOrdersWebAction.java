package com.hopline.vendorServices.action;

import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.vendorServices.model.FetchOrderTo;
import com.hopline.vendorServices.model.FetchOrderWebTo;
import com.hopline.vendorServices.sevices.VorderService;

public class FetchOrdersWebAction extends BaseRestAction{
	
	private FetchOrderWebTo fetchOrder;
	
	
    public String execute()
    {
    	if (invalidInput()) throw new IllegalArgumentException();
		fetchOrder = ServiceLocator .getInstance().getService(VorderService.class).retrieveOrdersAndFinishedOrders(fetchOrder);
		
		return SUCCESS;
    }


	private boolean invalidInput() {
		if (fetchOrder == null || fetchOrder.getShopId() == null || fetchOrder.getOrderStates() == null || fetchOrder.getOrderStates().size() == 0) throw new IllegalArgumentException();
		return false;
	}


	public FetchOrderWebTo getFetchOrder() {
		return fetchOrder;
	}


	public void setFetchOrder(FetchOrderWebTo fetchOrder) {
		this.fetchOrder = fetchOrder;
	}




}
