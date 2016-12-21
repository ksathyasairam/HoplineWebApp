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
<div id="sideSpacing">
	<form action="/feedbackOnNext">	
		<div style="border-radius:3px;box-shadow:0px 0px  6px #888888; background:#ffffff;color:#6d6c6c;padding-top:4%;opacity:0.7;padding-bottom:7%;height:95vh;">
			<div style="text-align:center;color:#c22929;padding-bottom:10px">
				<b style="margin-top:-15px">How do you feel about the app?</b>
			</div>
			<div class="rate" method="POST">
		        <input type="radio" id="star5" name="feedback.rating" value="5" /><label for="star5" title="text" style="margin-top:-30px">&#x02729;</label>
		        <input type="radio" id="star4" name="feedback.rating" value="4" /><label for="star4" title="text" style="margin-top:-30px">&#x02729;</label>
		        <input type="radio" id="star3" name="feedback.rating" value="3" /><label for="star3" title="text" style="margin-top:-30px">&#x02729;</label>
		        <input type="radio" id="star2" name="feedback.rating" value="2" /><label for="star2" title="text" style="margin-top:-30px">&#x02729;</label>
		        <input type="radio" id="star1" name="feedback.rating" value="1" /><label for="star1" title="text" style="margin-top:-30px">&#x02729;</label>
		    </div>
			<div style="margin-left:2%;position:relative;margin-top:8%;height:50px;width:96%; background:none;color:#6d6c6c; ">
				<label for="like" style="color:#c22929;">Share your ideas on how we can improve</label>
				<textarea rows="4" cols="40" placeholder="text here" name="feedback.fedText" style="border:1px solid #c22929;margin-top:-1%;width:100%">
				</textarea>
			</div>
			<div>
				<input type="submit" value="Submit" style="width:70px;background:#3e92d3;border-radius:3px;border:none;color:white;position:relative;margin-left:2%;margin-top:33%;text-align:center;padding:1%">
			<div>				
		</div>
	</form>
</div>
<div style="height:50px; width:100%; float:left;">
</div>


</div>
</div>

<script>
$(document).ready(function(){
	
	$("#menubutton").css({"opacity":"0","pointer-events": "none","cursor": "default"});
})
</script>

</body>
</html>