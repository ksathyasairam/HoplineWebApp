package com.hopline.WebApp.action;

import java.util.List;

import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.OrderService;
import com.opensymphony.xwork2.Action;

public class ClearMacOnLan extends BaseAction {

	private List<OrderVo> orders;
	
	@Override
	public boolean loginRequired() {
		return true;
	}
	
	public String execute() {
		orders = ServiceLocator.getInstance().getService(OrderService.class).
				retrieveActiveOrders((UserVo) getSession().get(SecurityInterceptor.SESSION_USER));
		
		return Action.SUCCESS;
		
	}

	public List<OrderVo> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderVo> orders) {
		this.orders = orders;
	}

}
