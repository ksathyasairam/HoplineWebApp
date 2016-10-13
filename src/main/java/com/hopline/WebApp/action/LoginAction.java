package com.hopline.WebApp.action;

import com.hopline.WebApp.interceptors.SecurityInterceptor;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;



import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.service.LoginServiceImpl;
import com.opensymphony.xwork2.Action;

public class LoginAction extends BaseAction {

	private UserVo user;

	 //Base URL
	  public static String baseUrl = "https://sendotp.msg91.com/api";

	  // Your application key
	public static String applicationKey = "yumgrrIQZwiP1OV-m4V1LOibqeLR6STRtf7Yxp1ecE1HepiF2N7_tbfgDJM7wET4drJgAayr_UVXFKTCxT7eR1TBhZ6yjwlhDQ5L24o01KLUNdyHn-E0ACegF5WsmEe3qdkZg5Gl5cncfKmfoTQIZQ==";
	
	
	
	public String executeLoginOnLoad() {
		
//		String countryCode ="91";
//		String mobileNumber="9560558203";
//
//		
//		try {
//		      Client client = Client.create();
//		      String Url  = baseUrl+"/generateOTP";
//		      WebResource webResource = client.resource(Url);
//
//		      HashMap<String, String> requestBodyMap = new HashMap();
//		      requestBodyMap.put("countryCode",countryCode);
//		      requestBodyMap.put("mobileNumber",mobileNumber);
//		      requestBodyMap.put("getGeneratedOTP","true");
//		      JSONObject requestBodyJsonObject = new JSONObject(requestBodyMap);
//		      String input = requestBodyJsonObject.toString();
//
//		      ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
//		        .header("application-Key", applicationKey)
//		        .post(ClientResponse.class, input);
//
//		      String output = response.getEntity(String.class);
//		      String jsonString = output;
//		      JSONObject jsonObject = new JSONObject(jsonString);
//		      JSONObject newJSON = jsonObject.getJSONObject("response");
//		      System.out.println(newJSON.getString("oneTimePassword"));
//
//		    } catch (Exception e) {
//		      e.printStackTrace();
//		}
//		
		
		
//		
//	    //Your authentication key
//        String authkey = "127476A79wH6TQYos57f60529";
//        //Multiple mobiles numbers separated by comma
//        String mobiles = "9560558203";
//        //Sender ID,While using route4 sender id should be 6 characters long.
//        String senderId = "Hoplin";
//        //Your message to send, Add URL encoding here.
//        String message = " i love you.... Ho ho ho  your food is waitng";
//        //define route
//        String route="4";
//
//        //Prepare Url
//        URLConnection myURLConnection=null;
//        URL myURL=null;
//        BufferedReader reader=null;
//		
//
//        //encoding message
//        String encoded_message=URLEncoder.encode(message);
//
//        //Send SMS API
//        String mainUrl="http://api.msg91.com/api/sendhttp.php?";
//        
//
//        //Prepare parameter string
//        StringBuilder sbPostData= new StringBuilder(mainUrl);
//        sbPostData.append("authkey="+authkey);
//        sbPostData.append("&mobiles="+mobiles);
//        sbPostData.append("&message="+encoded_message);
//        sbPostData.append("&route="+route);
//        sbPostData.append("&sender="+senderId);
//
//        //final string
//        mainUrl = sbPostData.toString();
//        
//        try
//        {
//            //prepare connection
//            myURL = new URL(mainUrl);
//            myURLConnection = myURL.openConnection();
//            myURLConnection.connect();
//            reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
//            //reading response
//            String response;
//            while ((response = reader.readLine()) != null)
//            //print response
//            System.out.println(response);
//
//            //finally close connection
//            reader.close();
//        }
//        catch (IOException e)
//        {
//                e.printStackTrace();
//        }
//		
		
		
		return Action.SUCCESS;
	}

	public String executeLoginNext() throws Exception {
		if (!validateData()) return INPUT;
	
		user = ServiceLocator.getInstance().getService(LoginServiceImpl.class).login(user);
	

		getSession().put(SecurityInterceptor.SESSION_USER, user);
		

		return "success";

	}

	private boolean validateData() {
		if (user == null || user.getPhone() == null || user.getName() == null){
			setInvalidInput(true);
			return false;
		}
		setInvalidInput(false);
		return true;
//		user.getPhone().matches("^[789]\\d{9}$");
		
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

}
