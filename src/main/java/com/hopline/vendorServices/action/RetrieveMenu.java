package com.hopline.vendorServices.action;

import java.util.List;

import com.hopline.WebApp.model.vo.CategoryVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.CategoryServiceImpl;

public class RetrieveMenu extends BaseRestAction{
	//TODO : only implemented for sngle shop;
	private List<CategoryVo> categoryVos;
	
	
    public String execute()
    {
		setCategoryVos(ServiceLocator.getInstance().getService(CategoryServiceImpl.class).retrieveAllCategory());
		return SUCCESS;
    }


	public List<CategoryVo> getCategoryVos() {
		return categoryVos;
	}


	public void setCategoryVos(List<CategoryVo> categoryVos) {
		this.categoryVos = categoryVos;
	}

}
