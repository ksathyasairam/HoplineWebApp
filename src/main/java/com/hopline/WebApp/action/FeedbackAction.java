package com.hopline.WebApp.action;

import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.hopline.WebApp.model.vo.FeedbackVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.OrderService;
import com.opensymphony.xwork2.Action;

public class FeedbackAction extends BaseAction {

	private FeedbackVo feedback;

	public String executeOnLoad() {
		return Action.SUCCESS;
	}

	public String executeOnNext() throws Exception {
		UserVo user = (UserVo) getSession().get(SecurityInterceptor.SESSION_USER);
		feedback.setUserId(user.getIduser());
		
		ServiceLocator.getInstance().getService(OrderService.class).createFeedback(feedback);
		return "success";
	}

	@Override
	public boolean loginRequired() {
		return true;
	}

	public FeedbackVo getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedbackVo feedback) {
		this.feedback = feedback;
	}

}
