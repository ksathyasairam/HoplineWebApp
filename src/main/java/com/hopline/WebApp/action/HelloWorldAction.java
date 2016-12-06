package com.hopline.WebApp.action;

public class HelloWorldAction extends BaseAction {


	public String execute() throws Exception {
		super.execute();
		return "success";
	}

	@Override
	public boolean loginRequired() {
		// TODO Auto-generated method stub
		return false;
	}
}
