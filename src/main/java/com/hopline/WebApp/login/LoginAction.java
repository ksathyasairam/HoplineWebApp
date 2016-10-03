package com.hopline.WebApp.login;

import javax.servlet.http.Cookie;

import com.hopline.WebApp.BaseAction;
import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.opensymphony.xwork2.Action;

public class LoginAction extends BaseAction {

@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
//	getSession().put(SecurityInterceptor.SESSION_USER, new User())
	return super.execute();
}

}
