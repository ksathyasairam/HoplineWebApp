package com.hopline.WebApp.endpoint;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.hopline.WebApp.action.BaseAction;
import com.hopline.WebApp.endpoint.model.OrderStatusList;
import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.OrderService;

public class YourOrderStatesAction extends BaseAction {


	public String execute() throws Exception {
		super.execute();
		
		OrderStatusList orderStatusList = ServiceLocator.getInstance().getService(OrderService.class).
				retrieveOrdersStatus(((UserVo) getSession().get(SecurityInterceptor.SESSION_USER)).getIduser());
			

		Gson gson = new Gson();
		String jsonString = gson.toJson(orderStatusList);
		
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType("application/json");
		response.getWriter().write(jsonString);

		return null;
	}

	@Override
	public boolean loginRequired() {
		return true;
	}

}
