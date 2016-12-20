<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hopline</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
 <!-- Custom Theme files -->
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <meta name="keywords" content="" />

</head>
	<body> 
		
	<a  class="addedtoast" style=" z-index:9;" >
		<b>
			Item Added
		</b>
	</a>
		<div style="color:white;position:fixed;right:0%;height:24px;  top:28px; float:right; margin-right:15px;z-index:999999;border:1px solid #ffffff;border-radius:3px;padding-left:8px;padding-right:8px;font-size:14px;padding-top:2px;">
			<a href="/singlePageApp#/home" style="color:white;">Back</a>
		</div>		
		<!-- container -->
			<!-- header -->
			<div id="home" class="header" style="padding-bottom:50px;" >

				<!-- top-hedader -->
				<div class="top-header" style="margin-top:15px;" >
					<!-- /logo -->
					<!--top-nav---->

				<div class="top-nav" style="position:fixed; top:0;width:100% ;background: #be1e2d ; padding-top:1em; padding-bottom:1em;z-index: 10; ">
					<div class="navigation">
						<div class="logo" style="position:fixed;left:1em;">
							<!-- <h1 ><a href="#" >FEEDBACK</a></h1> -->
							<img src="images/hoplogo.png" alt=" " style="height:50px;margin-top:-10px;" / >
							<div style="color:white;margin-top:-26px;margin-left:55px;font-size:18px;font-family: 'Asap', sans-serif;"><b>FEEDBACK</b></div>
						</div>
						<div class="navigation-right" style="margin-right:1em;" >
							<span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" "  style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px;" /></span>
							
						</div>	
					</div>
				</div>

			
<div class="spacing">
</div>
<div id="clearCartPopUp2" style="padding:5px;border-radius:3px;font-size:20px;z-index:10;position:fixed;width:300px;height:150px;text-align:center;color:white;background:#c22929;;top:50%;left:50%;margin-top:-100px;margin-left:-150px;opacity:0.8;">
	<div style="height:100%">Thank you for your response.We appreciate your time.</div>
</div>
<script>
$(document).ready(function(){
	
	$("#menubutton").css({"opacity":"0","pointer-events": "none","cursor": "default"});
})
</script>

</body>
</html>