package com.hopline.WebApp.action;

import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.CategoryServiceImpl;
import com.hopline.vendorServices.action.UpdateStock;

public class SinglePageAppAction extends BaseAction {

	
	private String menuJsonString = null;
	private boolean loggedIn;
	
	private Integer shopId;
	
	public String execute() throws Exception {
		UserVo user = (UserVo) getSession().get(SecurityInterceptor.SESSION_USER);
		setLoggedIn(user != null);
		
//		if (menuJsonString == null ||UpdateStock.getStockUpdatedFlag() == null || UpdateStock.getStockUpdatedFlag() ) {
			setMenuJsonString(ServiceLocator .getInstance().getService(CategoryServiceImpl.class).retrieveMenuPageJson(user,getShopId()));
//			UpdateStock.setStockUpdatedFlag(false);
//		}
		
		return "success";
	}


	@Override
	public boolean loginRequired() {
		return false;
	}


	public String getMenuJsonString() {
		return menuJsonString;
	}


	public synchronized void setMenuJsonString(String menuJsonString) {
		this.menuJsonString = menuJsonString;
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


	public Integer getShopId() {
		return shopId;
	}


	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}


	

}
