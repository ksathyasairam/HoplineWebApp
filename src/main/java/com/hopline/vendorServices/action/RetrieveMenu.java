package com.hopline.vendorServices.action;

import java.util.List;

import com.hopline.WebApp.model.vo.CategoryVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.CategoryServiceImpl;

public class RetrieveMenu extends BaseRestAction{
	private List<CategoryVo> categoryVos;
	private Integer shopId; 
	
    public String execute()
    {
		setCategoryVos(ServiceLocator.getInstance().getService(CategoryServiceImpl.class).retrieveAllCategory(getShopId()));
		return SUCCESS;
    }


	public List<CategoryVo> getCategoryVos() {
		return categoryVos;
	}


	public void setCategoryVos(List<CategoryVo> categoryVos) {
		this.categoryVos = categoryVos;
	}


	public Integer getShopId() {
		return shopId;
	}


	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

}
