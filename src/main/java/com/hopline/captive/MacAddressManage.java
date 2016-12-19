package com.hopline.captive;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hopline.WebApp.action.BaseAction;

public class MacAddressManage extends BaseAction {
	private static final long MS_IN_MIN = 60000;
	private String mac;

	private static HashMap<String, Date> macsOnLan = new HashMap<String, Date>();

	
	public String clearAll() throws IOException {
		macsOnLan.clear();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain");
		response.getWriter().write(macsOnLan.size() + "");

		
		return null;
	}
	
	public String execute() throws Exception {
		if (getMac() == null)
			throw new IllegalArgumentException();

		boolean res = solve();

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain");
		response.getWriter().write(res + "");

		return null;
	}

	private boolean solve() {

		if (!macsOnLan.containsKey(getMac())) {
			macsOnLan.put(getMac(), new Date());
			return false;
		}

		long currTime = new Date().getTime();
		if (currTime - macsOnLan.get(getMac()).getTime() < 3 * MS_IN_MIN)
			return false;

		if (currTime - macsOnLan.get(getMac()).getTime() > 60 * MS_IN_MIN) {
			macsOnLan.put(getMac(), new Date());
			return false;
		}

		return true;

	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public boolean loginRequired() {
		// TODO Auto-generated method stub
		return false;
	}

}
