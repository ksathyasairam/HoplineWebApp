package com.hopline.WebApp;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hopline.WebApp.model.dao.Category;

public class HelloWorldAction implements SessionAware {

	private static final String HELLO_COUNT = "hc";

	private Map<String, Object> userSession;

	private String name;
	private List<Category> categories;
	private String tmp;
	
	private Integer helloCount;

	public String execute() throws Exception {
		// categories =
		// ServiceLocator.getInstance().getService(CategoryServiceImpl.class).retrieveAllCategory();

		setHelloCount((Integer) userSession.get(HELLO_COUNT));

		if (getHelloCount() == null) {

			setHelloCount(1);

		} else {

			setHelloCount(getHelloCount() + 1);

		}

		userSession.put(HELLO_COUNT, getHelloCount());

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

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

	public Integer getHelloCount() {
		return helloCount;
	}

	public void setHelloCount(Integer helloCount) {
		this.helloCount = helloCount;
	}
}
