package com.hopline.WebApp.action;

import com.hopline.WebApp.model.vo.OrderVo;
import com.opensymphony.xwork2.Action;

public class OrderSummaryAction extends BaseAction {
	
	private OrderVo orderVo;
	
	@Override
	public boolean loginRequired() {
		return true;
	}
	
	public String executeOrderSummaryOnLoad() {
		return Action.SUCCESS;
	}

	public OrderVo getOrderVo() {
		return orderVo;
	}

	public void setOrderVo(OrderVo orderVo) {
		this.orderVo = orderVo;
	}
	


}
