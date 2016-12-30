package com.hopline.WebApp.action;

import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.rest.framework.Util;
import com.hopline.WebApp.service.OrderService;
import com.opensymphony.xwork2.Action;

public class OrderSummaryAction extends BaseAction {
	private OrderVo order;

	private String lastPaymentFailed;
	
	@Override
	public boolean loginRequired() {
		return true;
	}
	
	public String executeOrderSummaryOnLoadGetRequest() {
		disableBrowserCache();
		if (getSession().get("order") == null) return REDIRECT_HOME;
		order = (OrderVo) getSession().get("order");

		return Action.SUCCESS;
	}
	
	public String executeOrderSummaryOnLoad() {
		disableBrowserCache();
		if (!validateOnLoad()) return REDIRECT_HOME;
		UserVo user = (UserVo) getSession().get(SecurityInterceptor.SESSION_USER);
		order.setUser(user);
		//TODO : use user from session add.
		setOrder(ServiceLocator.getInstance().getService(OrderService.class).createTempOrder(getOrder()));
		getSession().put("order", getOrder());
		return Action.SUCCESS;
	}
	
	public String executeOrderSummaryNext() {
		if (getSession().get("order") == null) return REDIRECT_HOME;
		OrderService service = ServiceLocator.getInstance().getService(OrderService.class);
		setOrder(service.submitOrder((OrderVo)getSession().get("order")));
		getSession().put("order", null);
		
		return service.getReturnPage();
	}
	
	
	public String executeOnlinePaymentNext() {
		if (getSession().get("order") == null) return REDIRECT_HOME;
		order = (OrderVo) getSession().get("order");
		return SUCCESS;
	}

	private boolean validateOnLoad() {
		boolean valid = Util.validateOrder(order); 
		setInvalidInput(!valid);
		return valid;
			
	}

	public OrderVo getOrder() {
		return order;
	}

	public void setOrder(OrderVo order) {
		this.order = order;
	}

	public String getLastPaymentFailed() {
		return lastPaymentFailed;
	}

	public void setLastPaymentFailed(String lastPaymentFailed) {
		this.lastPaymentFailed = lastPaymentFailed;
	}

	


}
