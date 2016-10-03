package com.hopline.WebApp.interceptors;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.springframework.remoting.RemoteConnectFailureException;

import com.hopline.WebApp.BaseAction;
import com.hopline.WebApp.model.dao.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecurityInterceptor extends AbstractInterceptor {

	public static final String SESSION_USER = "user";
	public static final String REMEMBER_ME = "rememberMe";

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();

		Cookie rememberMeCookie = getRememberMeCookie();
		if (session.get(SESSION_USER) == null && rememberMeCookie != null) {
			User user = getUserFromDb(rememberMeCookie.getValue());
			if (user == null)
				deleteCookie(rememberMeCookie);
			else
				session.put(SESSION_USER, user);
		}

		BaseAction action = (BaseAction) invocation.getAction();
		
		if (session.get(SESSION_USER) == null && action.loginRequired())
			return "login";
		
		
//		System.out.println(action.loginRequired());
//
//		Cookie div = new Cookie(action.REMEMBER_ME, "akki");
//		div.setMaxAge(60 * 60 * 24 * 365); // Make the cookie last a year
//		ServletActionContext.getResponse().addCookie(div);

		return invocation.invoke();

	}

	private void deleteCookie(Cookie cookie) {
		cookie.setValue(null);
		cookie.setMaxAge(0);
		ServletActionContext.getResponse().addCookie(cookie);
	}
	

	private User getUserFromDb(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	private Cookie getRememberMeCookie() {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();

		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(REMEMBER_ME))
					return c;
			}
		}

		return null;
	}
}