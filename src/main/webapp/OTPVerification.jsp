<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Verify OTP</title>
</head>
<body>
	OTP mismatch<s:property value="OTPMismatch"/>
	
   <form action="OTPVerifyOnNext">
      <label for="name">Enter OTP</label><br/>
      <input type="text" name="enteredOTP"/>
      <input type="submit" value="Verify"/>
   </form>
   
    <form action="resendOTP">
      <input type="submit" value="Resend OTP"/>
   </form>
</body>
</html>