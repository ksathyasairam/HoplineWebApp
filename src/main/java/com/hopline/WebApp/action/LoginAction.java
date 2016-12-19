package com.hopline.WebApp.action;

import javax.servlet.Servlet;

import org.apache.struts2.ServletActionContext;

import com.hopline.WebApp.constants.SessionConstants;
import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.Config;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.rest.framework.Util;
import com.hopline.WebApp.service.LoginServiceImpl;
import com.opensymphony.xwork2.Action;

public class LoginAction extends BaseAction {

	private UserVo user;
	private boolean OTPGeneratinFailed;
	private String afterLoginURL;
	private String mac;

	public String executeLoginOnLoad() {

//		String clientAddress = ServletActionContext.getRequest().getRemoteAddr();
//
//		if (Config.GODWARI_IP.equals(clientAddress)) {
//
//			if (CaptivePortal.ACTION_NAME.equals(afterLoginURL)){
//				getSession().put(SessionConstants.AFTER_LOGIN_REDIRECT_URL, afterLoginURL);
//				return Action.SUCCESS;
//			}
//
//			if (mac == null) {
//				getSession().put(SessionConstants.AFTER_LOGIN_URL_FOR_LAN, afterLoginURL);
//				return "redirectMacLogin";
//			}
//			
//			UserVo user = ServiceLocator.getInstance().getService(LoginServiceImpl.class).retrieveUserByMacId(mac);
//			afterLoginURL = (String) getSession().get(SessionConstants.AFTER_LOGIN_URL_FOR_LAN);
//			if (user == null) {
//				getSession().put(SessionConstants.USER_MAC_ID, mac);
//				getSession().put(SessionConstants.AFTER_LOGIN_REDIRECT_URL, afterLoginURL);
//				return Action.SUCCESS;
//			} else {
//				getSession().put(SecurityInterceptor.SESSION_USER, user);
//				getSession().put(SessionConstants.TEMP_USER, null);
//				return "alreadyLoggedIn";
//			}
//
//		}

		getSession().put(SessionConstants.AFTER_LOGIN_REDIRECT_URL, afterLoginURL);
		return Action.SUCCESS;
	}

	public String executeLoginNext() throws Exception {
		if (!validateData())
			return INPUT;

		String generatedOTP = Util.sendOTP(user.getPhone());

		if (generatedOTP == null) {
			setOTPGeneratinFailed(true);
			return "input";
		}
		getSession().put(SessionConstants.GENERATED_OTP, generatedOTP);

		getSession().put(SessionConstants.TEMP_USER, user);

		return "success";

	}

	private boolean validateData() {
		if (Util.isInvalidUserData(user)) {
			setInvalidInput(true);
			return false;
		}
		setInvalidInput(false);
		return true;
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

	public boolean isOTPGeneratinFailed() {
		return OTPGeneratinFailed;
	}

	public void setOTPGeneratinFailed(boolean oTPGeneratinFailed) {
		OTPGeneratinFailed = oTPGeneratinFailed;
	}

	public String getAfterLoginURL() {
		return afterLoginURL;
	}

	public void setAfterLoginURL(String afterLoginURL) {
		this.afterLoginURL = afterLoginURL;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

}
