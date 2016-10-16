package com.hoplineVendorServices.action;

import com.hoplineVendorServices.model.OrderTo;

public class PreparingOrdersAction extends BaseRestAction{
	
	private OrderTo order;
	
	
    public String create()
    {
            order.setCancelReason("serer");
            return SUCCESS;
    }
	
	public OrderTo getOrder() {
		return order;
	}

	public void setOrder(OrderTo order) {
		this.order = order;
	}



}
