package com.hopline.WebApp.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements SessionAware {
	public static final String INPUT = "input";
	public static final String INVALID_INPUT = "invalidInput";
	public static final String REDIRECT_HOME = "redirectHome";
	
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
	
	public void disableBrowserCache(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, max-age=0");
		response.setHeader("Expires", "0, Tue, 01 Jan 1980 1:00:00 GMT");
		
	}

		
	
}
