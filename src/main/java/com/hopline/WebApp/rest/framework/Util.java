package com.hopline.WebApp.rest.framework;

import java.util.Calendar;
import java.util.Date;

public class Util {
	public static Date getTime5HrAgo() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -5);
		Date date = cal.getTime();
		return date;
	}
}
