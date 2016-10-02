package com.hopline.WebApp;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public abstract class BaseAction implements SessionAware{
	public static String ORDER = "order";
	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public abstract String execute() throws Exception;

}
