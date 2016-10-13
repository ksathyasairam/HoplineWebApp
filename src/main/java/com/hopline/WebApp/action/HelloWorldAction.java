package com.hopline.WebApp.action;

import java.util.List;

import com.hopline.WebApp.model.dao.Category;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.CategoryServiceImpl;

public class HelloWorldAction extends BaseAction {

	private static final String HELLO_COUNT = "hc";

	private String name;
	private List<Category> categories;
	private String tmp;
	
	private Integer helloCount;

	public String execute() throws Exception {
		super.execute();
		// categories =
		 ServiceLocator.getInstance().getService(CategoryServiceImpl.class).retrieveAllCategoryJson();

//		setHelloCount((Integer) getSession().get(HELLO_COUNT));
//
//		if (getHelloCount() == null) {
//
//			setHelloCount(1);
//
//		} else {
//
//			setHelloCount(getHelloCount() + 1);
//
//		}
//
//		getSession().put(HELLO_COUNT, getHelloCount());

		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getTmp() {
		return tmp;
	}

	public void setTmp(String tmp) {
		this.tmp = tmp;
	}

	

	public Integer getHelloCount() {
		return helloCount;
	}

	public void setHelloCount(Integer helloCount) {
		this.helloCount = helloCount;
	}

	@Override
	public boolean loginRequired() {
		// TODO Auto-generated method stub
		return false;
	}
}
