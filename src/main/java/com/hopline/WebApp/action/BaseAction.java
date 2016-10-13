package com.hopline.WebApp.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements SessionAware {
	public static final String INPUT = "input";
	public static final String INVALID_INPUT = "invalidInput";
	private Map<String, Object> session;
	private boolean invalidInput;
	
	public abstract boolean loginRequired();

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public boolean isInvalidInput() {
		return invalidInput;
	}

	public void setInvalidInput(boolean invalidInput) {
		this.invalidInput = invalidInput;
	}

		
	
}
