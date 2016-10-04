package com.hopline.WebApp.action;

import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.LoginServiceImpl;
import com.opensymphony.xwork2.Action;

public class LoginAction extends BaseAction {

	private UserVo user;
	private boolean invalidInput;

	public String executeLoginOnLoad() {
		return Action.SUCCESS;
	}

	public String executeLoginNext() throws Exception {
		if (!validateData()) return "input";
	
		user = ServiceLocator.getInstance().getService(LoginServiceImpl.class).login(user);
	

		getSession().put(SecurityInterceptor.SESSION_USER, user);
		return "success";

	}

	private boolean validateData() {
		if (user == null || user.getPhone() == null || user.getUserName() == null){
			setInvalidInput(true);
			return false;
		}
		setInvalidInput(false);
		return true;
//		user.getPhone().matches("^[789]\\d{9}$");
		
	}

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

	@Override
	public boolean loginRequired() {
		return false;
	}

	public boolean isInvalidInput() {
		return invalidInput;
	}

	public void setInvalidInput(boolean invalidInput) {
		this.invalidInput = invalidInput;
	}

}
