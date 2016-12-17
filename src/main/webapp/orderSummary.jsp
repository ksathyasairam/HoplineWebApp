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
	<body ng-app="mainApp" ng-controller="EventCtrl as event" style="background-image: url(../images/checks.png);min-height:100vh;> 

	<a id="return-to-top" style="z-index:11; "><i><img src="images/up.png" alt=" " / ></i></a>
	
	<div id="paymentOptions" style="box-shadow:0px 0px  6px #888888;border-radius:3px;display:none;position:fixed;color:white;background:#c22929;height:120px;width:98%;top:99%;left:50%;margin-top:-120px;margin-left:-49%;z-index:9;opacity:0.8">
		<div style="text-align:center;font-size:20px">
			Payment Options
		</div>
		<form action="">
		  <input type="radio" name="paymentMethod" value="cash" style="margin-left:2%;margin-top:3%"> Pay cash on pickup <br>
		</form>
	</div>
		
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
						<h1 ><a href="/singlePageApp#/restaurant">HOPLINE</a></h1>
					</div>
					<div class="navigation-right" style="margin-right:1em;" >
						<span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" " / style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px;" ></span>
						
					</div>

				</div>
				</div>

			

<s:form action="/orderSummaryNext">
 <div id="place" class="bigBack" style="border:none; background:#4fb66d;z-index:999999">
 	Place order
 </div>
<s:submit value="Continue" class="bigBack" style="border:none; background:#4fb66d" onclick="clearLocalStorage()"  />
</s:form> 
<div style="padding-top:20px;">
</div>

<div class="banner-info" id="sideSpacing" >
				<div class=" header-right">
					<h6  style="text-align:center;">Order Summary</h6>
					<ul class="address">
						<s:iterator value="order.orderProducts">
						 <li  id="cartItem-{{$index}}" style="border-bottom: 1.5px dotted #AFAFAF;margin-top:2%;padding-bottom:2%;">
						 	<div style="color:#525a54;float:left;">
						 		<s:property value="product.name"/>
						 	</div>
						 	<div style="color:#525a54;float:right;">
						 		x <s:property value="count"/> 
						 		
						 		
						 	</div>
						 	<br>
						 	<s:iterator value="orderProductAddons">
						 		<div style="font-size: 13px;">
						 			<div style="color:#525a54;float:left;">
						 				<s:property value="addOn.name"/>
						 			</div>
						 			<br>
						 		</div>
						 	 </s:iterator>
						 </li>
						 </s:iterator>
						 <br>
						 <div>
						 	<div style=" float:right; color:#525a54;  font-size:15px;">
						 		<b>Total: &#8377 <s:property value="order.totalPrice"/></b>
						 	</div>
						 	<div style=" float:left; color:#525a54;  font-size:15px;">
						 		<b>Quantity: <s:property value="order.totalItemCount"/></b>
						 	</div>
						 	<br>
						 </div>
						 <br>
						 <div style="border-bottom: 1px double #AFAFAF;">
						 </div>
						 <br>

					</ul>
				</div>
				<div class="clearfix"> </div>
</div>
		</div>
	</div>

<script>
	function clearLocalStorage() {
		localStorage.clear();
	}
			
</script>

<script>
$(document).ready(function(){
	
	$("#menubutton").css({"opacity":"0","pointer-events": "none","cursor": "default"});
	
})
</script>
<script>
$("#place").click(function(){
	$("#paymentOptions").css({display:'block'});
	$("#place").css({display:'none'});
	console.log("hello");
});
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