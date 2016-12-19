package com.hopline.WebApp.action;

import com.hopline.WebApp.constants.SessionConstants;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.LoginServiceImpl;

public class CaptivePortal extends BaseAction {

	public static final String ACTION_NAME = "captive/form";
	private String mac;


	
	public String execute() throws Exception {
		super.execute();
		
		if (mac == null) return "message";
		
		if (macRegistered(mac)) {
			return "message";
		} else{
			getSession().put(SessionConstants.USER_MAC_ID, mac);
			return "login";
		}
	}

	private boolean macRegistered(String mac2) {
		UserVo user = ServiceLocator.getInstance().getService(LoginServiceImpl.class).retrieveUserByMacId(mac2);
		return user!=null;
	}

	@Override
	public boolean loginRequired() {
		return false;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getRequestAction() {
		return ACTION_NAME;
	}

}
