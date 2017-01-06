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
	<body ng-app="mainApp" ng-controller="restaurantCtrl as event" style="background-image: url(../images/checks.png);min-height:100vh;"> 

	<a  class="addedtoast" style=" z-index:9;" ><b>Item Added</b></a>
				
		<!-- container -->
			<!-- header -->
			<div id="home" class="header" >

				<!-- top-hedader -->
				<div class="top-header" style="margin-top:15px;" >
					<!-- /logo -->
					<!--top-nav---->

				<div class="top-nav" style="position:fixed; top:0;width:100% ;background: #be1e2d ; padding-top:1em; padding-bottom:1em;z-index: 99999; ">
				<div class="navigation">
					<div class="logo" style="position:fixed;left:1em;">
						<!-- <h1 id="head">HOPLINE</h1> -->
						<a >
							<img src="images/hoplogo.png" alt=" " style="height:50px;margin-top:-10px;" / >
						</a>
							<div style="color:white;margin-top:-26px;margin-left:55px;font-size:18px;font-family: 'Asap', sans-serif;"><b id="head">HOPLINE</b></div>
						
					</div>
					<div class="navigation-right" style="margin-right:1em;" >
						<span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" " / style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px; opacity:0;" ></span>
						<nav class="link-effect-3" id="link-effect-3" >
							<ul class="nav1 nav nav-wil" style="background:#a79e9d; padding:1% 1% 1% 1%;  box-shadow:0px 0px  6px #888888;"  >
							</ul>
						</nav>
							<!-- script-for-menu -->
								<script>
								   $( "span.menu" ).click(function() {
									 $( "ul.nav1" ).slideToggle( 500, function() {
									 // Animation complete.
									  });
									 });
									 $( "ul.nav1" ).click(function() {
									 $( "ul.nav1" ).animate({display:"none"});
									 });
								</script>
							<!-- /script-for-menu -->
					</div>

				</div>
				</div>

			
			<!-- <ui-view></ui-view> -->
				<a href="/yourOrders"><img  src="images/invoice-4.png" alt=" " / style="position:fixed;right:0%;height:32px;  top:18px; float:right; margin-right:15px;z-index:999999;" ></a>			
			
			<a id="return-to-top" style="z-index:11; ">
				<i>
					<img src="images/up.png" alt=" " / >
				</i>
			</a>
			
			
			<div class="spacing" >
			</div>
			<a  ng-repeat="restaurant in event.restaurants" ng-href="/singlePageApp?shopId={{restaurant.idshop}}" >
				<div style="opacity:0.9;margin-left:2%;margin-top:7px; margin-right:2%; padding-left:2%; box-shadow:0px 0px  5px #888888; background:#ffffff;color:#c24747; float:left; width:96%;border-radius:3px;" >
					<div style="float:left; width:35%;">
						<img class=restaurant_page_image src={{restaurant.imgUrl}} alt=" " /  >
					</div>
					<div style="float:right;width:60%;">
						<h3  class="restaurant_page_heading">{{restaurant.shopName}}</h3>
						<p style="font-size:12px;margin-top:-9px">{{restaurant.description}}</p>
						<p style="font-size:10px;margin-top:-7px;color:#f47442" ng-show="restaurant.onlinePayYn=='N'">THIS RESTAURANT ACCEPTS ONLY CASH</p>
						<div class="clickClass" style="">Show Menu</div>
					<!--  	<div  class="restaurant_page_card_img">
							<img src="images/spoonplate.png" alt=" " class="restaurant_page_spoonplate"/>
						</div>	
					-->
					</div>
							
				</div>
			</a>
			<div style="width:100%;height:20px;padding-top:20px">
			
			</div>
	<!--  		<div style="position:fixed;bottom:1%;text-align:center;margin-top:7px; margin-right:2%;border:none; float:left; width:100%;height:70px;padding-top:8px;color:#c22929;border-radius:3px;">
				<div style="float:left;">
					<img src="images/knife2.png" alt=" " style="height:60px;margin-top"/>
				</div>	
				
				<div style="float:right;">
					<img src="images/fork2.png" alt=" " style="height:60px;"/>
				</div>
				<div style="margin-top:8px;font-size:17px;">
					More restaurants to be added soon!
				</div>	
			</div>
	-->		
		</div>
	</div>

<script src="./app/angular.min.js"></script>
<script src="./app/angular-route.js"></script>
<script src="./app/mainApp.js"></script>
<script src="./app/ui.router.js"></script>
<script>

(function(){

	angular.module('eventModule', [])
	.controller('restaurantCtrl', ['$scope','$timeout','$http',function ($scope,$timeout,$http) {

	  this.restaurants=  <s:property escape="false"  value="shopListJson"/>	
	  console.log(this.restaurants);
	  
	  this.isRestaurantClosed=false;
	  
	  var date = new Date();
	    if(date.getHours() >= 22 || date.getHours() < 11){ 
	    	this.isRestaurantClosed=false;
	    }	 
	}]);
})();

</script>
</body>
</html>

