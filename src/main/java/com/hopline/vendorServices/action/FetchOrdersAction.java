package com.hopline.vendorServices.action;

import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.vendorServices.model.FetchOrderTo;
import com.hopline.vendorServices.sevices.VorderService;

public class FetchOrdersAction extends BaseRestAction{
	
	private FetchOrderTo fetchOrder;
	
	
    public String execute()
    {
    	if (invalidInput()) throw new IllegalArgumentException();
		fetchOrder = ServiceLocator .getInstance().getService(VorderService.class).retrieveOrders(fetchOrder);
		
		return SUCCESS;
    }


	private boolean invalidInput() {
		if (fetchOrder == null || fetchOrder.getShopId() == null || fetchOrder.getOrderStates() == null || fetchOrder.getOrderStates().size() == 0) throw new IllegalArgumentException();
		return false;
	}


	public FetchOrderTo getFetchOrder() {
		return fetchOrder;
	}


	public void setFetchOrder(FetchOrderTo fetchOrder) {
		this.fetchOrder = fetchOrder;
	}
	




}
