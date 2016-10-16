package com.hopline.vendorServices.action;

import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.vendorServices.model.OrderStatusTo;
import com.hopline.vendorServices.sevices.VorderService;

public class UpdateOrderStatusAction extends BaseRestAction{
	
	private OrderStatusTo orderStatus;
	
	
	
	public String execute() {
		if (invalidInput()) throw new IllegalArgumentException();
		orderStatus = ServiceLocator .getInstance().getService(VorderService.class).udpateOrderStatus(orderStatus);
		
		return SUCCESS;
	}
	
	private boolean invalidInput() {
		return orderStatus != null && orderStatus.getOrderId() == null;
	}

	public OrderStatusTo getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusTo orderStatus) {
		this.orderStatus = orderStatus;
	}

}
