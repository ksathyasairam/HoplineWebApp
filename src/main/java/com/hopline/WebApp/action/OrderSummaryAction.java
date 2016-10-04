package com.hopline.WebApp.action;

import com.hopline.WebApp.model.vo.OrderVo;
import com.opensymphony.xwork2.Action;

public class OrderSummaryAction extends BaseAction {
	
	private OrderVo orderVO;
	
	@Override
	public boolean loginRequired() {
		return true;
	}
	
	public String executeOrderSummaryOnLoad() {
		return Action.SUCCESS;
	}
	
	public OrderVo getOrderVO() {
		return orderVO;
	}

	public void setOrderVO(OrderVo orderVO) {
		this.orderVO = orderVO;
	}

}
