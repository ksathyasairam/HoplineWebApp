package com.hopline.vendorServices.action;

import com.hopline.WebApp.model.vo.ShopVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.vendorServices.sevices.VorderService;

public class VendorLoginAction extends BaseRestAction {
	
	private ShopVo shop;
	
	public String execute() {
		shop = ServiceLocator.getInstance().getService(VorderService.class).loginVendor(shop);
		return SUCCESS;
	}

	public ShopVo getShop() {
		return shop;
	}

	public void setShop(ShopVo shop) {
		this.shop = shop;
	}

}
