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

	<body ng-app="mainApp" ng-controller="EventCtrl as event" > 

				
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
						<h1 ><a href="/singlePageApp#/restaurant">HOPLINE</a></h1>
					</div>
					<div class="navigation-right" style="margin-right:1em;" >
						<span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" " / style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px;" ></span>
					</div>

				</div>
				</div>

			
			

<div style="position:absolute; top:25%; left:50%; background: #eeeeee; padding-top:18px; padding-bottom:18px; padding-left:10px; padding-right:10px; border-radius:  3px; margin-left:-160px; box-shadow:0px 0px  6px #888888; border: 1px solid #AFAFAF;">
    <div style=" position:absolute;left:50%;height:90px; width:90px; -webkit-border-radius: 60px;-moz-border-radius: 60px; border-radius: 60px; background: #b2301d; margin-top:-60px; margin-left:-45px;box-shadow:0px -1px  2px #888888;">
      
    </div>
    <br>
    <br>
    <form action="/loginNext.action">
         <s:if test="%{afterLoginURL.equalsIgnoreCase('yourOrders')}">
			<div id="loginPopUp" style="font-family: 'Raleway', sans-serif;text-align:center;bottom:3%;font-size:14px; background:none;color:grey;padding-top:3%;">
			
				<strong>Hey there, you have login </br>before you can view your orders.</strong>
				
			</div>
		 </s:if>
		 <s:if test="%{afterLoginURL.equalsIgnoreCase('orderSummaryOnLoad')}">
			<div id="loginPopUp" style="font-family: 'Raleway', sans-serif;text-align:center;bottom:3%;font-size:14px; background:none;color:grey;padding-top:3%;">
			
				Hey there, you have login </br>before you can place orders.
				
			</div>
		</s:if>
    	<div style="text-align:center;">
      		<h3>Hopline Register</h3>
    	</div>
    	<div  style="padding-bottom:5%;">
      		<img src="images/user.png" style=" z-index:20; margin-left:-99%;height:31px;padding-top:3px;">
      		<input name="user.name"  type="text" placeholder="Your Name" style="float:left;width:100%; background: #d3d3d3; border:none ; padding-left:25px; border-radius:  2px; height:35px;" required/>

    	</div>
    	<div style="padding-bottom:5%;" >
      		<img src="images/mobile.png" style=" z-index:20; margin-left:-99%;height:31px;padding-top:3px;">
      		<input id="userphone" name="user.phone" type="text" placeholder="Phone No." pattern="[0-9]{10}"  required     style="float:left; width:100%; background:#d3d3d3; border:none ; padding-left: 25px; border-radius:  2px; height:35px;" />
			
    	</div>
    	<div >
      		<input id="yoyo" type="submit" value="Login"  style=" color:white;width:300px; background:#4fb66d; border:none ; border-radius:  2px; height:35px;"/>
			<script>
				$("#yoyo").click(function(){
				var input = document.getElementById('userphone');
				  if(input.validity.patternMismatch){  
				        input.setCustomValidity("Please enter a valid Phone No.");  
				    }  
				    else {  
				        input.setCustomValidity("");  
				    } 
				});
			</script>
    	</div>

    </form>
</div>

		</div>
	</div>
<script>
	$(document).ready(function(){
	
	$("#menubutton").css({"opacity":"0","pointer-events": "none","cursor": "default"});
	})
</script>
<script>
	$('body').click(function(){
		$('#loginPopUp').css({display:'none'});
	})
</script>
<script src="./app/angular.min.js"></script>
<script src="./app/angular-route.js"></script>
<script src="./app/mainApp.js"></script>
<script src="./app/ui.router.js"></script>
<script src="./app/event/eventModule.js"></script>
<script type="text/javascript">
    console.log("angular object",angular);
</script>


	</body>
</html>
