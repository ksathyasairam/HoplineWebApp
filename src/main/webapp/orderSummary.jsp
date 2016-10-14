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
	<body ng-app="mainApp" ng-controller="EventCtrl as event"> 

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
						<span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" " / style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px;" ></span>
						
					</div>

				</div>
				</div>

			
<div style="padding-top:27px;">
</div>


<s:form action="HoplineWebApp/orderSummaryNext">
 
<s:submit value="Confirm Order" style="position:fixed; left:1%; bottom:10px; background:#4fb66d; oopacity:0.9; height:40px; text-align:center;width:98%;padding-top:2%;padding-bottom:3%;border-radius:3px 3px 3px 3px;color:white;border:none;"  />
</s:form> 
<div style="padding-top:20px;">
</div>

<div class="banner-info" style="margin-left:7px;margin-right:7px;" >
				<div class=" header-right">
					<h6  style="text-align:center;">Order Summary</h6>
					<p style="text-align:center; color:#525a54;">Order No.: #<s:property value="order.customerOrderId"/></p>
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
						 <div style="border-bottom: 1px double #AFAFAF;">
						 </div>
						 <br>
						 <div>
						 	<div style=" float:right; color:#525a54;  font-size:14px;">
						 		Total: &#8377.<s:property value="order.totalPrice"/>
						 	</div>
						 	<div style=" float:left; color:#525a54;  font-size:14px;">
						 		Quantity: <s:property value="order.totalItemCount"/>
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
$(document).ready(function(){
	
	$("#menubutton").css({"opacity":"0","pointer-events": "none","cursor": "default"});
})
</script>

<script src="./app/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular-route.js"></script>
<script src="./app/mainApp.js"></script>
<script src="./app/ui.router.js"></script>
<script src="./app/event/eventModule.js"></script>
<script type="text/javascript">
    console.log("angular object",angular);
</script>

	</body>
</html>