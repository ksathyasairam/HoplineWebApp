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
	
	private Map<String, Object> session;
	
	public abstract boolean loginRequired();

	@Override
	public void setSession(Map<String, Object> session) {
		//testing 9 eclipse base
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

		
	
}
