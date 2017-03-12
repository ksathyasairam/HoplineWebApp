package com.hopline.vendorServices.model;

import java.util.List;

import com.hopline.WebApp.model.vo.OrderVo;

public class FetchOrderWebTo extends FetchOrderTo {
	
	private List<OrderVo> finishedOrders;
	
	public List<OrderVo> getFinishedOrders() {
		return finishedOrders;
	}
	public void setFinishedOrders(List<OrderVo> orderHistory) {
		this.finishedOrders = orderHistory;
	}

}
