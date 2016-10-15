package com.hopline.WebApp.action;

import com.hopline.WebApp.constants.SessionConstants;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.Util;
import com.opensymphony.xwork2.Action;

public class LoginAction extends BaseAction {

	private UserVo user;
	private boolean OTPGeneratinFailed;
	
	public String executeLoginOnLoad() {
		return Action.SUCCESS;
	}

	public String executeLoginNext() throws Exception {
		if (!validateData()) return INPUT;
		
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
		if (Util.isInvalidUserData(user)){
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

}
