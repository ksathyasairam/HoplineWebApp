package com.hopline.WebApp.rest.framework;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.hopline.WebApp.model.vo.UserVo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;




public class Util {
	public static Date getUserSessionStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -5);
		Date date = cal.getTime();
		return date;
	}
	
	public static String sendOTP(String mobileNumber){
		
		String countryCode ="91";

		
		try {
		      Client client = Client.create();
		      String Url  = Constants.SMS_BASE_URL + "/generateOTP";
		      WebResource webResource = client.resource(Url);

		      HashMap<String, String> requestBodyMap = new HashMap();
		      requestBodyMap.put("countryCode",countryCode);
		      requestBodyMap.put("mobileNumber",mobileNumber);
		      requestBodyMap.put("getGeneratedOTP","true");
		      JSONObject requestBodyJsonObject = new JSONObject(requestBodyMap);
		      String input = requestBodyJsonObject.toString();

		      ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
		        .header("application-Key", Constants.SMS_API_KEY)
		        .post(ClientResponse.class, input);

		      String jsonString = response.getEntity(String.class);
		      if (jsonString == null) return null;
		      JSONObject jsonObject = new JSONObject(jsonString);
		      if (jsonObject == null) return null;
		      JSONObject newJSON = jsonObject.getJSONObject("response");
		      if (newJSON == null) return null;
		      return newJSON.getString("oneTimePassword");

		    } catch (Exception e) {
		      e.printStackTrace();
		}

		return null;
	}

	public static boolean isInvalidUserData(UserVo user) {
		return user == null || user.getPhone() == null || user.getName() == null || user.getPhone().isEmpty() || user.getName().isEmpty();
	}
}
