package com.hopline.WebApp.rest.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hopline.WebApp.model.vo.OrderProductVo;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Util {
	public static Date getUserSessionStartTime() {
		Calendar cSchedStartCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		long gmtTime = cSchedStartCal.getTime().getTime();

		long timezoneAlteredTime = gmtTime + TimeZone.getTimeZone("Asia/Calcutta").getRawOffset();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cal.setTimeInMillis(timezoneAlteredTime);

		cal.add(Calendar.HOUR, -5);
		Date date = cal.getTime();
		return date;
	}

	public static Date getCurrentDateTimeIndia() {
		Calendar cSchedStartCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		long gmtTime = cSchedStartCal.getTime().getTime();

		long timezoneAlteredTime = gmtTime + TimeZone.getTimeZone("Asia/Calcutta").getRawOffset();
		Calendar cSchedStartCal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cSchedStartCal1.setTimeInMillis(timezoneAlteredTime);
		return cSchedStartCal1.getTime();
	}

	public static String sendOTP(String mobileNumber) {

		String countryCode = "91";

		try {
			Client client = Client.create();
			String Url = Constants.SMS_BASE_URL + "/generateOTP";
			WebResource webResource = client.resource(Url);

			HashMap<String, String> requestBodyMap = new HashMap();
			requestBodyMap.put("countryCode", countryCode);
			requestBodyMap.put("mobileNumber", mobileNumber);
			requestBodyMap.put("getGeneratedOTP", "true");
			JSONObject requestBodyJsonObject = new JSONObject(requestBodyMap);
			String input = requestBodyJsonObject.toString();

			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
					.header("application-Key", Constants.SMS_API_KEY).post(ClientResponse.class, input);

			String jsonString = response.getEntity(String.class);
			if (jsonString == null)
				return null;
			JSONObject jsonObject = new JSONObject(jsonString);
			if (jsonObject == null)
				return null;
			JSONObject newJSON = jsonObject.getJSONObject("response");
			if (newJSON == null)
				return null;
			return newJSON.getString("oneTimePassword");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// TODO : NO Response check and error handling in this method. FIX.
	public static void sendSMS(String phone, String message) {
		if (Config.DISABLE_SMS)
			return;
		// define route
		String route = "4";

		// Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		// encoding message
		String encoded_message = URLEncoder.encode(message);

		// Send SMS API
		String mainUrl = "http://api.msg91.com/api/sendhttp.php?";

		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + Constants.SMS_AUTH_KEY);
		sbPostData.append("&mobiles=" + phone);
		sbPostData.append("&message=" + encoded_message);
		sbPostData.append("&route=" + route);
		sbPostData.append("&sender=" + Constants.SENDER_ID);

		// final string
		mainUrl = sbPostData.toString();

		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
				// print response
				System.out.println(response);

			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static boolean isInvalidUserData(UserVo user) {
		return user == null || user.getPhone() == null || user.getName() == null || user.getPhone().isEmpty()
				|| user.getName().isEmpty();
	}

	public static void printObjectWithNull(Object object) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		System.out.println(gson.toJson(object));

	}

	public static boolean validateOrder(OrderVo order) {

		boolean valid = order != null && order.getShop() != null && order.getShop().getIdshop() != null
				&& order.getOrderProducts() != null && order.getOrderProducts().size() > 0;

		if (valid) {
			for (OrderProductVo orderProductVo : order.getOrderProducts()) {
				valid = valid && orderProductVo.getProduct() != null
						&& orderProductVo.getProduct().getProductId() != null && orderProductVo.getCount() != null
						&& orderProductVo.getCount() > 0;
			}
		}
		// TODO : add Addon Validation
		return valid;

	}

	public static int safeLongToInt(long l) {
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
		}
		return (int) l;
	}
}
