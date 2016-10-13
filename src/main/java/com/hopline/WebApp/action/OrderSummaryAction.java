package com.hopline.WebApp.action;

import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.hopline.WebApp.model.vo.OrderProductVo;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.OrderService;
import com.opensymphony.xwork2.Action;

public class OrderSummaryAction extends BaseAction {
	//arnav when you want to set or read addons, always use orderProductAddons inside orderProduct. Never use addons inside product.
	private OrderVo order;
	
	@Override
	public boolean loginRequired() {
		return true;
	}
	
	public String executeOrderSummaryOnLoad() {
		if (!validateOnLoad()) return INVALID_INPUT;
		UserVo user = (UserVo) getSession().get(SecurityInterceptor.SESSION_USER);
		order.setUser(user);
		//TODO : use user from session add.
		setOrder(ServiceLocator.getInstance().getService(OrderService.class).createTempOrder(getOrder()));
		getSession().put("order", getOrder());
		return Action.SUCCESS;
	}
	
	public String executeOrderSummaryNext() {
		if (getSession().get("order") == null) return INVALID_INPUT;
		OrderService service = ServiceLocator.getInstance().getService(OrderService.class);
		setOrder(service.submitOrder((OrderVo)getSession().get("order")));
		getSession().put("order", getOrder());
		
		return service.getReturnPage();
	}

	private boolean validateOnLoad() {
		boolean valid =  getOrder() != null 
				&& getOrder().getShop() != null && getOrder().getShop().getIdshop() != null && getOrder().getOrderProducts() != null && getOrder().getOrderProducts().size() > 0 ; 
				
		if (valid) {
			for (OrderProductVo orderProductVo : getOrder().getOrderProducts()) {
				valid = valid && orderProductVo.getProduct() != null && orderProductVo.getProduct().getProductId() != null && orderProductVo.getCount() != null && orderProductVo.getCount() > 0;
			}
		}
		//TODO : add Addon Validation
		setInvalidInput(!valid);
		return valid;
	}

	public OrderVo getOrder() {
		return order;
	}

	public void setOrder(OrderVo order) {
		this.order = order;
	}

	


}
