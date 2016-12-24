package com.hopline.WebApp.action;

import java.util.List;

import com.google.gson.Gson;
import com.hopline.WebApp.model.vo.ShopVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.CategoryServiceImpl;

public class ShopAction extends BaseAction {
	private String shopListJson;
	
	public String execute() throws Exception {
		List<ShopVo> shops = ServiceLocator.getInstance().getService(CategoryServiceImpl.class).retrieveAllShops();
		
		Gson gson = new Gson();
		shopListJson = gson.toJson(shops);
		
		return "success";
	}

	@Override
	public boolean loginRequired() {
		return false;
	}

	public String getShopListJson() {
		return shopListJson;
	}

	public void setShopListJson(String shopListJson) {
		this.shopListJson = shopListJson;
	}



}
