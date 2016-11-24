package com.hopline.WebApp.interceptors;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.hopline.WebApp.action.BaseAction;
import com.hopline.WebApp.model.dao.SecurityToken;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.SecurityService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class SecurityInterceptor implements Interceptor {

	public static final String SESSION_ORDER_STORE = "orderStore";
	public static final String SESSION_USER = "user";
	public static final String REMEMBER_ME = "rememberMe";
	
	private String requestAction;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();

		
		if (invocation.getProxy().getMethod().equals("executeOrderSummaryOnLoad")) orderSummaryRedirectDataStore(invocation, session);
		
		Cookie rememberMeCookie = getRememberMeCookie();
		UserVo sessionUser = (UserVo) session.get(SESSION_USER);
		
		if (rememberMeCookie == null &&  sessionUser != null) {
			SecurityToken securityToken  = ServiceLocator.getInstance().getService(SecurityService.class).createSecurityToken(sessionUser.getIduser());
			
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
		
		if (sessionUser == null && action.loginRequired()){
			
			ValueStack stack = ActionContext.getContext().getValueStack();
			stack.push(new Object() {public String getRequestAction(){return requestAction;}});
			
			requestAction = invocation.getProxy().getActionName();
			return "login";
		}
		
		return invocation.invoke();
	}

	private void orderSummaryRedirectDataStore(ActionInvocation invocation, Map<String, Object> session) {
		Map<String, Object> currOrder = ActionContext.getContext().getParameters();
		Map<String, Object> storedOrder = (Map<String, Object>) session.get(SESSION_ORDER_STORE);

		if (currOrder != null && currOrder.size() > 0) {
			session.put(SESSION_ORDER_STORE, currOrder);
		} else if (storedOrder != null) {
			ActionContext.getContext().setParameters(storedOrder);
			session.put(SESSION_ORDER_STORE, null);
		}

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

	public String getRequestAction() {
		return requestAction;
	}

	public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}
}