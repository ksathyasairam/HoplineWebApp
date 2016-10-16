
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
<!-- webfonts -->
	<link href='//fonts.googleapis.com/css?family=Asap:400,700,400italic' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
<!-- webfonts -->

</head>
	<body> 

	<a id="return-to-top" style="z-index:11; "><i><img src="images/up.png" alt=" " / ></i></a>
		
	<a  class="addedtoast" style=" z-index:9;" ><b>Item Added</b></a>
				
		<!-- container -->
			<!-- header -->
			<div id="home" class="header" >

				<!-- top-hedader -->
				<div class="top-header" style="margin-top:15px;" >
					<!-- /logo -->
					<!--top-nav---->

				<div class="top-nav" style="position:fixed; top:0;width:100% ;background: #cf3721 ; padding-top:1em; padding-bottom:1em;z-index: 10; ">
				<div class="navigation">
					<div class="logo" style="position:fixed;left:1em;">
						<h1 ><a href="index.html">HOPLINE</a></h1>
					</div>
					<div class="navigation-right" style="margin-right:1em;" >
						<span class="menu"><img src="images/menubutton.png" alt=" " / style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px;" ></span>
					</div>

				</div>
				</div>

			

<div style="position:fixed; top:25%; left:50%; background: #eeeeee; padding-top:18px; padding-bottom:18px; padding-left:10px; padding-right:10px; border-radius:  3px; margin-left:-129px;box-shadow:0px 0px  6px #888888; border: 1px solid #AFAFAF;">
	<form action="OTPVerifyOnNext">
  		<div style=" padding-bottom:5%; position:relative; left:50%; margin-left:-20px;" >
  			<img src="images/wait.png" style="width:40px;">
  		</div>

  		<div style="color:grey; text-align:center; padding-bottom:8%; ">
  			<p>Sit back and relax while we verify<br> your mobile number.<p>
  		</div>

  		<div style="padding-bottom:5%; position:relative; left:50%; margin-left:-100px;" >
     		<input type="text" name="enteredOTP" placeholder="Enter OTP" style=" text-align:center;width:200px; background: #d3d3d3; border:none ; border-radius:  2px; height:35px;" />

  		</div>
  		<div  style="padding-bottom:5%;position:relative; left:50%; margin-left:-100px;">
      		<input type="submit" value="Verify" ui-sref="order" style=" color:white;width:200px; background:#4fb66d; border:none ; border-radius:  2px; height:35px;"/>
  		</div>
  	</form>

     	<div  style="color:grey; text-align:center; padding-bottom:5%;font-size:12px;">
      		Did not receive an OTP ? <a id="resendotp" href="#" onclick="$(this).closest('form').submit(); return false;" style="color:#67baca;">Resend</a> OTP.
  	  	</div>
  	  	<s:if test="%{OTPMismatch}">
  	  		<div  style="color:grey; text-align:center; padding-bottom:5%;font-size:12px;color:#cf3721;">
  	  			The OTP you entered is incorrect.<br>Please enter again.
  	  		</div>
  	  	</s:if>
</div>


		</div>
	</div>
	<script>
		$(document).ready(function(){
			$("#resendotp").click(function(){
				  $.get("/resendOTP");
			});
		});
	</script>


	</body>
</html>
   <form action="OTPVerifyOnNext">
      <label for="name">Enter OTP</label><br/>
      <input type="text" name="enteredOTP"/>
      <input type="submit" value="Verify"/>
   </form>
   
    <form action="resendOTP">
      <input type="submit" value="Resend OTP"/>
   </form>