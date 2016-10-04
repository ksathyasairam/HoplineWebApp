package com.hopline.WebApp.interceptors;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.hopline.WebApp.action.BaseAction;
import com.hopline.WebApp.model.dao.SecurityToken;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.SecurityService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SecurityInterceptor implements Interceptor {

	public static final String SESSION_USER = "user";
	public static final String REMEMBER_ME = "rememberMe";

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();

		Cookie rememberMeCookie = getRememberMeCookie();
		UserVo sessionUser = (UserVo) session.get(SESSION_USER);
		
		if (rememberMeCookie == null &&  sessionUser != null) {
			SecurityToken securityToken  = ServiceLocator.getInstance().getService(SecurityService.class).createSecurityToken(sessionUser.getUserId());
			
			Cookie div = new Cookie(SecurityInterceptor.REMEMBER_ME, securityToken.getSecurityToken());
			div.setMaxAge(60 * 60 * 24 * 365); // Make the cookie last a year
			ServletActionContext.getResponse().addCookie(div);

			return invocation.invoke();
		}
				
		
		if (rememberMeCookie != null && sessionUser == null) {
			UserVo user = getUserFromDb(rememberMeCookie.getValue());
			if (user == null)
				deleteCookie(rememberMeCookie);
			else {
				session.put(SESSION_USER, user);
				sessionUser = user;
			}
		}

		BaseAction action = (BaseAction) invocation.getAction();
		
		if (sessionUser == null && action.loginRequired())
			return "login";
		
		return invocation.invoke();
	}

	private void deleteCookie(Cookie cookie) {
		cookie.setValue(null);
		cookie.setMaxAge(0);
		ServletActionContext.getResponse().addCookie(cookie);
	}
	

	private UserVo getUserFromDb(String securityToken) {
		UserVo user  = ServiceLocator.getInstance().getService(SecurityService.class).retrieveUserFromToken(securityToken);
		return user;
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

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}