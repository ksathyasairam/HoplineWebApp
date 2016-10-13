<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hopline Login</title>
</head>
<body>
   <h1>Hopline Login</h1>
  <!--  <form action="loginNext">
      <label for="name">Name</label><br/>
      <input type="text" name="user.userName"/>
      
      <label for="name">Phone : </label><br/>
      <input type="text" name="user.phone"/>

      <input type="submit" value="Submit"/>
   </form> -->
   
   <s:form action="loginNext">
 
      <s:textfield name="user.userName" label="Name" />
      <s:textfield  name="user.phone" label="Phone" />
       
      <s:submit/>
       
</s:form> 
</body>
</html>