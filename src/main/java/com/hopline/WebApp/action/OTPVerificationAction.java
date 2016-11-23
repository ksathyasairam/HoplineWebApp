package com.hopline.WebApp.action;

import com.hopline.WebApp.constants.SessionConstants;
import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.rest.framework.Util;
import com.hopline.WebApp.service.LoginServiceImpl;
import com.opensymphony.xwork2.Action;

public class OTPVerificationAction extends BaseAction {

	private String enteredOTP;
	private boolean OTPMismatch;
	private String afterLoginURL;
	
	public String executeVerificationOnload() {
		return Action.SUCCESS;
	}

	public String executeVerificationOnNext() throws Exception {
		
		String sessionOTP = (String) getSession().get(SessionConstants.GENERATED_OTP);
		
		afterLoginURL = (String) getSession().get(SessionConstants.AFTER_LOGIN_REDIRECT_URL);
		if (afterLoginURL == null){
			afterLoginURL = "singlePageApp";
		}
		
		
		if (enteredOTP != null && sessionOTP != null && enteredOTP.equals(sessionOTP)) {
			
			UserVo user = (UserVo) getSession().get(SessionConstants.TEMP_USER);
			if (Util.isInvalidUserData(user)) return "login";
			
			user = ServiceLocator.getInstance().getService(LoginServiceImpl.class).login(user);
			getSession().put(SecurityInterceptor.SESSION_USER, user);
			getSession().put(SessionConstants.TEMP_USER, null);
			
			return "success";
		
		} else {
			OTPMismatch  = true;
			return "input";
		}
	

	}
	
	
	public String resendOTP() throws Exception {

		UserVo user = (UserVo) getSession().get(SessionConstants.TEMP_USER);
		if (Util.isInvalidUserData(user)) return "login";

		
		String generatedOTP = Util.sendOTP(user.getPhone());
		getSession().put(SessionConstants.GENERATED_OTP, generatedOTP);

		return null;
	}



	@Override
	public boolean loginRequired() {
		return false;
	}

	public String getEnteredOTP() {
		return enteredOTP;
	}

	public void setEnteredOTP(String enteredOTP) {
		this.enteredOTP = enteredOTP;
	}

	public boolean isOTPMismatch() {
		return OTPMismatch;
	}

	public void setOTPMismatch(boolean oTPMismatch) {
		OTPMismatch = oTPMismatch;
	}

	public String getAfterLoginURL() {
		return afterLoginURL;
	}

	public void setAfterLoginURL(String afterLoginURL) {
		this.afterLoginURL = afterLoginURL;
	}




}
