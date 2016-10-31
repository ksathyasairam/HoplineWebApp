package com.hopline.WebApp.endpoint;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.hopline.WebApp.action.BaseAction;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.OrderService;
	
public class OrderStatusAction extends BaseAction {
	private Integer orderId;
	
	
	
	public String execute() throws Exception {
		super.execute();
		
		String status = ServiceLocator.getInstance().getService(OrderService.class).retrieveSingleOrderStatus(getOrderId());
			
		Gson gson = new Gson();
		String jsonString = gson.toJson(status);
		
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType("application/json");
		response.getWriter().write(jsonString);

		return null;
	}

	@Override
	public boolean loginRequired() {
		return false;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


}
