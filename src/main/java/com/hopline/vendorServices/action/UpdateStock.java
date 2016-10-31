package com.hopline.vendorServices.action;

import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.vendorServices.model.OrderStatusTo;
import com.hopline.vendorServices.model.Stock;
import com.hopline.vendorServices.sevices.VorderService;

public class UpdateStock extends BaseRestAction{
	
	private Stock stock;
	
	
	
	public Stock getStock() {
		return stock;
	}



	public void setStock(Stock stock) {
		this.stock = stock;
	}



	public String execute() {
		stock = ServiceLocator .getInstance().getService(VorderService.class).udpateStock(stock);
		return SUCCESS;
	}
	
	
}
