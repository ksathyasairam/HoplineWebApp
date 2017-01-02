<%@page import="com.hopline.WebApp.rest.framework.Config"%>
<%@page import="com.hopline.WebApp.model.vo.OrderVo"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="java.io.PrintStream"%>
<%@page import="TrustManager.MyTrustManager"%>
<%@page import="java.security.cert.X509Certificate"%>
<%@page import="javax.net.ssl.X509TrustManager"%>
<%@page import="javax.net.ssl.SSLContext"%>
<%@page import="java.io.InputStream"%>
<%@page import="javax.net.ssl.HttpsURLConnection"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@ page import="java.util.*" %>
<%@ page import="java.security.*" %>

<%!

public boolean empty(String s)
	{
		if(s== null || s.trim().equals(""))
			return true;
		else
			return false;
	}
%>
<%!
	public String hashCal(String type,String str){
		byte[] hashseq=str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try{
		MessageDigest algorithm = MessageDigest.getInstance(type);
		algorithm.reset();
		algorithm.update(hashseq);
		byte messageDigest[] = algorithm.digest();
            
		

		for (int i=0;i<messageDigest.length;i++) {
			String hex=Integer.toHexString(0xFF & messageDigest[i]);
			if(hex.length()==1) hexString.append("0");
			hexString.append(hex);
		}
			
		}catch(NoSuchAlgorithmException nsae){ }
		return hexString.toString();
	}
%>
<% 	

	OrderVo order = (OrderVo)session.getAttribute("order"); 
	System.out.println(order.getOrderCreator());

	String merchant_key= Config.EZEBUZZ_MERCHANT_KEY;
	String salt= Config.EZEBUZZ_SALT;
	String action1 ="";
	String base_url= Config.EZEBUZZ_BASE_URL;
	int error=0;
	String hashString="";
	
	String amount = order.getTotalPrice()+"";
	String productinfo = order.getIdorder() + "";
	String firstname = order.getUser().getName();
	String email = "niks@Live.in";
	
	
	String surl = Config.EZEBUZZ_RESPONSE_URL + "/orderSummaryNext";
	String furl = Config.EZEBUZZ_RESPONSE_URL + "/orderSummaryNext";
	String phone = order.getUser().getPhone();
	
 
	
//	Enumeration paramNames = request.getParameterNames();
	Map<String,String> params= new HashMap<String,String>();
	params.put("amount",amount);
	params.put("key",merchant_key);
	params.put("firstname",firstname);
	params.put("email",email);
	params.put("phone",phone);
	params.put("productinfo",productinfo);
	params.put("surl",surl);
	params.put("furl",furl);
	
/*	while(paramNames.hasMoreElements()) 
	{
      		String paramName = (String)paramNames.nextElement();
      
      		String paramValue = ((String)request.getParameter(paramName)).trim();

		params.put(paramName,paramValue);
	}
*/
	String txnid ="";
	if(empty(params.get("txnid"))){
		Random rand = new Random();
		String rndm = Integer.toString(rand.nextInt())+(System.currentTimeMillis() / 1000L);
		txnid=hashCal("SHA-256",rndm).substring(0,20);
	}
    else{
		txnid=params.get("txnid");
    }
	params.put("txnid",txnid);
	String hash="";
	String hashSequence = "key|txnid|amount|productinfo|firstname|email|udf1|udf2|udf3|udf4|udf5|udf6|udf7|udf8|udf9|udf10";

	if(empty(params.get("hash")) && params.size()>0)
	{
		if( empty(params.get("key"))
			|| empty(params.get("txnid"))
			|| empty(params.get("amount"))
			|| empty(params.get("firstname"))
			|| empty(params.get("email"))
			|| empty(params.get("phone"))
			|| empty(params.get("productinfo"))
			|| empty(params.get("surl"))
			|| empty(params.get("furl"))	)
			error=1;
		else{
			String[] hashVarSeq=hashSequence.split("\\|");
			
			for(String part : hashVarSeq)
			{
				hashString= (empty(params.get(part)))?hashString.concat(""):hashString.concat(params.get(part));
				hashString=hashString.concat("|");
			}
			hashString=hashString.concat(salt);
			hash=hashCal("SHA-512",hashString);
                        params.put("hash",hash);
                        
                        
                        StringBuilder sb = new StringBuilder();
			for (Map.Entry<String,String> e : params.entrySet()) {
                            if(sb.length() > 0){
                                sb.append('&');
                            }
                            sb.append(URLEncoder.encode(e.getKey().trim(), "UTF-8")).append('=').append(URLEncoder.encode(e.getValue().trim(), "UTF-8"));
                        }
                        
                        
                        SSLContext sslctx = SSLContext.getInstance("SSL");
                        sslctx.init(null, new X509TrustManager[]{new MyTrustManager()}, null);

                        HttpsURLConnection.setDefaultSSLSocketFactory(sslctx.getSocketFactory());
                        URL url = new URL(base_url+"payment/initiateLink");
                        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.setDoOutput(true);
                        PrintStream ps = new PrintStream(con.getOutputStream());
                        ps.println(sb);
                        ps.close();
                        con.connect();
                        StringBuilder res = new StringBuilder();
                        if (con.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                            String line;
                            while ((line = br.readLine()) != null) {
                                res.append(line);
                            }
                            br.close();
                        }
                        con.disconnect();
                        out.print(res);
                        System.out.println(res);
                        JSONParser parser = new JSONParser();
                        JSONObject obj=(JSONObject) parser.parse(res.toString());
                        if(obj.get("status").toString().equals("1")){
                            response.sendRedirect(base_url+"pay/"+obj.get("data").toString());
                        }else{
                        	response.sendRedirect("/orderSummaryOnLoadGet?lastPaymentFailed=true");
                        }
		}
	}
	
		
        
%>
