package com.hopline.WebApp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hopline.WebApp.model.dao.Category;

public class HelloWorldAction extends BaseAction {

	private static final String HELLO_COUNT = "hc";

	private String name;
	private List<Category> categories;
	private String tmp;
	
	private Integer helloCount;

	public String execute() throws Exception {
		//testing 16 niks
		
		//testing 15 aksh

		//testing 14 aksh

		//testing 13 niks
		
		//testing 12 aksh
		
		//Testing 11 aksh

		//Testing 10 niks
		
		//Testing 9 aksh

		//Testing 9 eclipse

		
		//Testing 8 niks

		//Testing 8 aksh

		
		//Testing 7 niks
		
		//Testing 6 aksh
		
		//Testing 5 niks
		
		
		//Testing 3
		
		//Testing 4
		
		
		//Baby ko base pasand hai
		super.execute();
		// categories =
		// ServiceLocator.getInstance().getService(CategoryServiceImpl.class).retrieveAllCategory();

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
