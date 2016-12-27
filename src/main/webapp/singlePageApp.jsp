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
	<body ng-app="mainApp" ng-controller="EventCtrl as event" style="background-image: url(../images/checks.png);min-height:100vh;" ng-init="event.switchRestaurantClearCart()"> 
	
	<div id="switchRestaurantClearCart" style="position:fixed;width:100vh;height:100vh;background:grey;z-index:9998;display:none;opacity:0.7;">

	</div>
	<div id="switchRestaurantClearCart2" style="padding:5px;border-radius:3px;font-size:20px;z-index:9999;position:fixed;width:300px;height:200px;text-align:center;color:grey;background:white;top:50%;left:50%;margin-top:-100px;margin-left:-150px;display:none;">
		<div style="height:80%">You already have items in your cart from a different restaurant.Do you want to clear your cart?</div>
		<div style="height:20%"><div id="okC" style="width:50%;float:left;color:#89c08d" ng-click="event.clearCart(); event.setShopId()">Ok</div><div style="width:50%;float:right;color:#c22929;"><a href="/shops">Go Back</a></div></div>
	</div>

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
						<a href="/shops">
							<img src="images/hoplogo.png" alt=" " style="height:50px;margin-top:-10px;" / >
						</a>
							<div style="color:white;margin-top:-26px;margin-left:55px;font-size:18px;font-family: 'Asap', sans-serif;"><b id="head">HOPLINE</b></div>
						
					</div>
					<div class="navigation-right" style="margin-right:1em;" >
						<span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" " / style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px; opacity:0;" ></span>
						<nav class="link-effect-3" id="link-effect-3" >
							<ul class="nav1 nav nav-wil" style="background:#a79e9d; padding:1% 1% 1% 1%;  box-shadow:0px 0px  6px #888888;"  >
								<li class="active" ng-repeat="item in event.category" ng-click="event.takeMeTo(item.name)" style=" background:#be1e2d;width:48%;margin:1% 1% 1% 1%;  height: 100px; float:left; border-radius:3px 3px 3px 3px; "><img src="{{item.imgUrl}}" style="position:absolute; 
								left:50%;height:60px;margin-left:-30px;"><br><br><a>{{item.name}}</a></li>

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

			
			<ui-view></ui-view>
		</div>
	</div>

<script src="./app/angular.min.js"></script>
<script src="./app/angular-route.js"></script>
<script src="./app/mainApp.js"></script>
<script src="./app/ui.router.js"></script>
<script src="./app/angular-cookies.js"></script>
<script src="./js/store.min.js"></script>
 <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular-cookies.js"></script>
<script>

(function(){

	angular.module('eventModule', ['ngCookies'])
	.factory('MainTitle', [function () {
	  

	  return {
	    title:""
	  };
	}])
	.config([function () {
	  console.log("Event Module:: config");
	}])
	.run([function () {
	  console.log("Event Module::running");
	}])
	.controller('EventCtrl', ['$scope', 'MainTitle','$timeout','$http','$cookies','$cookieStore',function ($scope,mainTitle,$timeout,$http,$cookies,$cookieStore) {

	  this.title="All Food Items";
	  
	  function lsTest(){
		    var test = 'test';
		    try {
		        localStorage.setItem(test, test);
		        localStorage.removeItem(test);
		        return true;
		    } catch(e) {
		        return false;
		    }
		}

		if(lsTest() === true){
		    this.localStorageAvailability=true;
		}else{
			this.localStorageAvailability=false;
		}
	  
	  if($cookieStore.get("checkList")){
		  console.log("gege")
	  }
	  else{
		  $cookieStore.put("checkList",null); 
	  }
	  console.log("svve",$cookieStore.get("checkList"));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList")) || [];
	  this.totalCost=localStorage.getItem('totalCost')|| ($cookieStore.get("totalCost")) || 0;
	  this.totalQuantity=localStorage.getItem('totalQuantity')||($cookieStore.get("totalQuantity")) || 0;
	  this.shopId=localStorage.getItem('shopId')|| ($cookieStore.get("shopId")) || 0;
	  this.master=[];
	  this.toast=false;
	  this.orderSummary=false;
	  $scope.min=1;
	  $scope.sec=60;
	  var mytimeout=null;
	  this.addOnTot=0;
	  this.addOnLength=1;	  

	this.restaurants=[
	{
	  name:'Bistro 37',
	  description:'Italian Deli',
	  address:'Shop No. 11, Godavari Complex, Arun Vihar, Sector 37, Noida',
	  image:'images/bistro37.png'

	},

	]

	  this.value="";

	  this.foodIt=  <s:property escape="false"  value="menuJsonString"/>	
	  this.foodItems=this.foodIt.categories;
	  this.favourites=this.foodIt.favourites;
	  this.shopDetails=this.foodIt.shop;
	  this.favList=[];
	  
	  this.category=this.foodIt.categoryDropdown;
	  
	  this.isRestaurantClosed=false;
	  
	  var date = new Date();
	    if(date.getHours() >= 22 || date.getHours() < 11){ 
	    	this.isRestaurantClosed=false;
	    }

	  
	this.checkMenuWithCart=function(){
		var check1 = JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList")) ||  [];
		
			for(var j=0;j<this.foodItems.length;j++)
			  {
			  	for(var k=0;k<this.foodItems[j].products.length;k++)
			  		{
			  		this.foodItems[j].products[k].quantity=1;
			  		for(var i=0;i<check1.length;i++){
				  			
				  		if(this.foodItems[j].products[k].productId==check1[i].productId)
				  			{	
				  				this.foodItems[j].products[k].quantity=this.foodItems[j].products[k].quantity+check1[i].quantity;
				  				
				  			}
				  		}
			  		}
			  }
		
		/*for(var i=0;i<this.favourites.length;i++){
			for(var j=0;j<this.foodItems.length;j++)
			  {
			  	for(var k=0;k<this.foodItems[j].products.length;k++)
			  		{
			  		if(this.foodItems[j].products[k].productId==this.favourites[i])
			  			{	
			  				this.favList.push(this.foodItems[j].products[k]);
			  				
			  			}
			  		}
			  }
		}*/
	}  
	this.showContent=function(id,name,val)
	  {
	        var elementToShow = '#item-' + name + '-' + id;

	        $(elementToShow).slideToggle(500,'swing');
	        val.isExpanded=!val.isExpanded;
	        
	    };

	this.takeMeTo=function(name)
	  {
		name=name.split(' ').join('');
	    var element='#' + name;
	      $("body, html").animate({ 
	        scrollTop: $( element ).offset().top - 105
	      }, 600);


	    };
	 this.decreaseItemCount = function(val) {

	  if(val.quantity>=1)
	  {
	  val.quantity= val.quantity-1;
	  //$("#checkcartNotify").css({display:'block'});
	  //$("#checkcartNotify").animate({opacity:0}, 1500, function() {
		  //$("#checkcartNotify").css({display:'none'});
		  //$("#checkcartNotify").css({opacity:1});
	  //});
	  //$("#qty").css({color:"#79d75f"});
	  //$("#qty").css({'font-size':"15px"});		  
	 // $("#qty").animate({'font-size':"12px"}, 1000, function() {
	  	//$("#qty").css({'color':"#ffffff"});
	  //});
	  
	  

	  }


	  };


	this.cancelOrder=function(value)
	{
	  value.quantity=1;
	  for(var i = 0; i < value.addOns.length; i++){
	  value.addOns[i].selected=false;  
	  }
	};

	this.changeOnRadio = function(food,id) {
		
		  // iterate over your whole list
		  for(var i=0;i<food.addOns.length;i++){
			  if(food.addOns[i].idaddOn!=id && food.addOns[i].price==0){
				  food.addOns[i].selected=false;
			  }
		  }
		};
	this.addOnTotal = function(food) {
		  this.addOnTot=0;			
		  // iterate over your whole list
		  for(var i=0;i<food.addOns.length;i++){
			  if(food.addOns[i].selected==true){
				  this.addOnTot=this.addOnTot + food.addOns[i].price;
			  }
		  }
		};
	this.addOnLen=function(food){
		this.addOnLength=food.addOns.length;
		var ab="-" + (((this.addOnLength-1)*50)/2 +115) + "px";
		$("#clearCartPopUp2-"+food.productId).css({'margin-top':ab});
	};
	this.totalOrder=function()
	{
	  this.totalQuantity=0;
	  this.totalCost=0;

	  for(var i = 0; i < this.checkList.length; i++){ 
	    this.totalCost= this.totalCost+(this.checkList[i].quantity*this.checkList[i].price);
	    var tot=0;
	    this.totalQuantity= this.totalQuantity+this.checkList[i].quantity;
	    for(var j = 0; j < this.checkList[i].addOns.length; j++)
	    {
	    	if(this.checkList[i].addOns[j].price>0)
	      		tot= tot + (this.checkList[i].addOns[j].price*this.checkList[i].quantity*this.checkList[i].addOns[j].selected);
	      
	    }
	    this.totalCost= this.totalCost+tot;
	    
	  }
	  if(this.localStorageAvailability){
		  localStorage.setItem('totalCost',this.totalCost);
		  localStorage.setItem('totalQuantity',this.totalQuantity);
	  }
	  else{
	  $cookieStore.put("totalCost", this.totalCost);
	  $cookieStore.put("totalQuantity", this.totalQuantity);
	  }
	};
	
	this.addCheckList=function(id,name,value)
	  {
	  var check = JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList")) || [];
	  obj = angular.copy(value);
	  var alreadyInList=0;
	  for(var i=0;i<check.length;i++)
		  {
			var a=0;
		  	if(check[i].productId==obj.productId){
		  		
		  		for(var j=0;j<obj.addOns.length;j++){
		  			if(obj.addOns[j].selected==check[i].addOns[j].selected){
		  				a=a+1;
		  			}
		  		}
		  		if(obj.addOns.length==a)
		  			{
			  		check[i].quantity=check[i].quantity+1;
			  		alreadyInList=1;
			  		break;
		  			}
		  	}
		  }
	  if(alreadyInList==0){
	  	check.push(obj);
	  }
	  obj.quantity=1;
	  if(this.localStorageAvailability)
	  	localStorage.setItem('checkList', JSON.stringify(check));
	  else
	  	$cookieStore.put("checkList", JSON.stringify(check));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList"));

	  //value.quantity=1;
	  
	  for(var i=0;i<value.addOns.length;i++){
	    value.addOns[i].selected=false;
	  }
	  //$("#checkcartNotify").css({display:'block'});
	  //$("#checkcartNotify").animate({opacity:0}, 1500, function() {
	  //$("#checkcartNotify").css({display:'none'});
	  //$("#checkcartNotify").css({opacity:1});
	  //});	  
	 // $("#qty").css({color:"#79d75f"});
	  //$("#qty").css({'font-size':"15px"});		  
	  //$("#qty").animate({'font-size':"12px"}, 800, function() {
	  	//$("#qty").css({'color':"#ffffff"});
	  //});	  
	  //$('.addedtoast').animate({top: '85'},1000);
	  //$('.addedtoast').fadeOut(1500);
	  //$('.addedtoast').css({top: '4%'});
	  //$('.addedtoast').show();   
	  this.totalOrder();
	};
	
	this.removeCheckList=function(id,name,value)
	  {
	  var check = JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList")) || [];
	  obj = angular.copy(value);
	  var abc=0;
	  var ind=0;
	  for(var i=0;i<check.length;i++)
		  {
		  if(check[i].productId==obj.productId)
			  {
			  abc=abc+1;
			  ind=i;
			  }
		  }
	  if(abc>1)
		  {
		  $("#clearCartPopUp").css({display:'block'});
			$("#clearCartPopUp2").css({display:'block'});
		  }
	  else if(abc==1){
		  if(check[ind].quantity>1){
			  check[ind].quantity=check[ind].quantity-1;
			  this.decreaseItemCount(value);
		  }
		  else if(check[ind].quantity==1){
			  check.splice(ind, 1);
			  this.decreaseItemCount(value);
		  }
	  }
	  if(this.localStorageAvailability)
	  	localStorage.setItem('checkList', JSON.stringify(check));
	  else
	  	$cookieStore.put("checkList", JSON.stringify(check));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList"));
	  this.totalOrder();
	};
	
	this.decItemFromCart=function(index)
	  {
	  var check = JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList")) || [];
	  if(check[index].quantity>0)
		  {
		  check[index].quantity=check[index].quantity-1;
		  }
	  for(var i=0;i<this.foodItems.length;i++)
	  {
	  	for(var j=0;j<this.foodItems[i].products.length;j++)
	  		{
	  		if(this.foodItems[i].products[j].productId==check[index].productId)
	  			{	
	  				this.foodItems[i].products[j].quantity=check[index].quantity+1;
	  				break;
	  			}
	  		}
	  }
	  if(check[index].quantity==0)
		  {
		  var elementToRemove = '#cartItem-'+ index;
		  $(elementToRemove).hide();
		  check.splice(index, 1);
		  }
	  if(this.localStorageAvailability)
	  	localStorage.setItem('checkList', JSON.stringify(check));
	  else
	  	$cookieStore.put("checkList", JSON.stringify(check));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList"));
	  this.totalOrder();
	};
	
	this.incItemFromCart=function(index)
	  {
	  var check = JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList")) || [];
	  check[index].quantity=check[index].quantity+1; 
	  for(var i=0;i<this.foodItems.length;i++)
	  {
	  	for(var j=0;j<this.foodItems[i].products.length;j++)
	  		{
	  		if(this.foodItems[i].products[j].productId==check[index].productId)
	  			{	
	  				this.foodItems[i].products[j].quantity=check[index].quantity+1;
	  				break;
	  			}
	  		}
	  }
	  if(this.localStorageAvailability)
	  	localStorage.setItem('checkList', JSON.stringify(check));
	  else
	  	$cookieStore.put("checkList", JSON.stringify(check));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList"));
	  this.totalOrder();
	};


	this.removeCartItem=function(index)
	{
	  var elementToRemove = '#cartItem-'+ index;
	  $(elementToRemove).hide();
	  var check1 = JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList")) || [];
	  for(var i=0;i<this.foodItems.length;i++)
	  {
	  	for(var j=0;j<this.foodItems[i].products.length;j++)
	  		{
	  		if(this.foodItems[i].products[j].productId==check1[index].productId)
	  			{	
	  				this.foodItems[i].products[j].quantity=this.foodItems[i].products[j].quantity-check1[index].quantity;
	  				break;
	  			}
	  		}
	  }
	  check1.splice(index, 1);
	  if(this.localStorageAvailability)
	  	localStorage.setItem('checkList', JSON.stringify(check1));
	  else
	  	$cookieStore.put("checkList", JSON.stringify(check1));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList")) || [];

	  this.totalOrder();
	};
	
	this.clearCart=function()
	{	
	  for(var i = 0; i < this.checkList.length; i++){
	  var elementToRemove = '#cartItem-'+ i;
	  $(elementToRemove).hide();
	  }
	  check1=[];
	  if(this.localStorageAvailability)
	  	localStorage.setItem('checkList', JSON.stringify(check1));
	  else
	  	$cookieStore.put("checkList", JSON.stringify(check1));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || JSON.parse($cookieStore.get("checkList")) || [];
	  this.totalOrder();
	  for(var i=0;i<this.foodItems.length;i++)
	  {
	  	for(var j=0;j<this.foodItems[i].products.length;j++)
	  		{
	  		
	  			this.foodItems[i].products[j].quantity=1;
	  			
	  		}
	  }
	};
	
	this.switchRestaurantClearCart=function(){
		if(this.shopId!=0){
			if(this.shopId!=this.shopDetails.idshop && this.checkList.length>0){
				$("#switchRestaurantClearCart").css({display:'block'});
				$("#switchRestaurantClearCart2").css({display:'block'});
				
			}
			else if(this.shopId!=this.shopDetails.idshop && this.checkList.length==0){
				if(this.localStorageAvailability)
					localStorage.setItem('shopId',this.shopDetails.idshop);
				else
					$cookieStore.put("shopId", this.shopDetails.idshop);
				 this.shopId=this.shopDetails.idshop;
			}
			
		}
		else{
			if(this.localStorageAvailability)
			 	localStorage.setItem('shopId',this.shopDetails.idshop);
			else
			 	$cookieStore.put("shopId", this.shopDetails.idshop);
		    this.shopId=this.shopDetails.idshop;
		}
			
	};
	
	this.setShopId=function(){
		if(this.localStorageAvailability)
			localStorage.setItem('shopId',this.shopDetails.idshop);
		else
			$cookieStore.put("shopId", this.shopDetails.idshop);
		 this.shopId=this.shopDetails.idshop;
		 $("#switchRestaurantClearCart").css({display:'none'});
		 $("#switchRestaurantClearCart2").css({display:'none'});
		 
	}
	
	this.addOnsPrice=function(checkListItem){
		var count=0;
		for(var i=0;i<checkListItem.addOns.length;i++){
			if(checkListItem.addOns[i].selected==true)
				count=count+checkListItem.addOns[i].price;
		}
		checkListItem.price=checkListItem.price + count;
	}
	
	this.hide=function(){
		
		$( "ul.nav1" ).slideUp( 500, function() {
			 // Animation complete.
			  });
		$("#instantCheckPopUp2").css({display:'none'});
		$("#instantCheckPopUp").css({display:'none'});
	};
	
	this.instantCheckPopUp=function(){
		$('#instantCheckPopUp').css({display:'block'});
		$('#fullcart').css({display:'none'});
		$('#fullcart2').css({display:'block'});
		
	};
	
	this.changeHeading=function(){
		$("#head").text(this.shopDetails.shopName);		
	};

	this.post1=function() {
		if(this.checkList.length==0)
			{
			$("#instantCheckPopUp2").css({display:'block'});
			}
		else{
	  var path="/orderSummaryOnLoad";
	    method = "post"; 

	    var form = document.createElement("form");
	    form.setAttribute("method", method);
	    form.setAttribute("action", path);

	var hiddenField = document.createElement("input");
	            hiddenField.setAttribute("type", "hidden");
	            hiddenField.setAttribute("name", "order.shop.idshop");
	            hiddenField.setAttribute("value", 1);

	            form.appendChild(hiddenField);

	var hiddenField2 = document.createElement("input");
	            hiddenField2.setAttribute("type", "hidden");
	            hiddenField2.setAttribute("name", "order.user.iduser");
	            hiddenField2.setAttribute("value", 2);

	            form.appendChild(hiddenField2);



	for(var i = 0; i < this.checkList.length; i++){ 

	   var hiddenField = document.createElement("input");
	            hiddenField.setAttribute("type", "hidden");
	            hiddenField.setAttribute("name", "order.orderProducts["+i+"].product.productId");
	            hiddenField.setAttribute("value",this.checkList[i].productId);

	            form.appendChild(hiddenField);

	            var hiddenField1 = document.createElement("input");
	            hiddenField1.setAttribute("type", "hidden");
	            hiddenField1.setAttribute("name", "order.orderProducts["+i+"].count");
	            hiddenField1.setAttribute("value",this.checkList[i].quantity);

	            form.appendChild(hiddenField1);

	            var k=0;
	    for(var j = 0; j < this.checkList[i].addOns.length; j++)
	    { 
	      if(this.checkList[i].addOns[j].selected==true || this.checkList[i].addOns[j].selected=="true")
	        {
	            var hiddenField1 = document.createElement("input");
	            hiddenField1.setAttribute("type", "hidden");
	            hiddenField1.setAttribute("name", "order.orderProducts["+i+"].orderProductAddons["+k+"].addOn.idaddOn");
	            hiddenField1.setAttribute("value",this.checkList[i].addOns[j].idaddOn);

	            form.appendChild(hiddenField1);
	            k=k+1;
	        }
	    }


	}
	    document.body.appendChild(form);
	    form.submit();
		}
	};

	
	}])



	})();

</script>

	</body>
</html>

