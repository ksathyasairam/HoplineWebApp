package com.hopline.vendorServices.action;

import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.rest.framework.Util;
import com.hopline.vendorServices.sevices.VorderService;

public class WalkInOrderAction extends BaseRestAction {

	private OrderVo order;

	public String execute() {
		if (!validateInput())
			throw new IllegalArgumentException();
		setOrder(ServiceLocator.getInstance().getService(VorderService.class).createWalkInOrder(getOrder()));
		return SUCCESS;
	}

	private boolean validateInput() {
		return Util.validateOrder(getOrder()) && !Util.isInvalidUserData(getOrder().getUser());
				
	}

	public OrderVo getOrder() {
		return order;
	}

	public void setOrder(OrderVo order) {
		this.order = order;
	}



}
