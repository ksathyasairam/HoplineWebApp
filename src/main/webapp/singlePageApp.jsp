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
	<body ng-app="mainApp" ng-controller="EventCtrl as event" style="background-image: url(../images/checks.png);min-height:100vh;"> 

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
						<img src="images/hoplogo.png" alt=" " style="height:50px;margin-top:-10px;" / >
						<div style="color:white;margin-top:-26px;margin-left:55px;font-size:18px;font-family: 'Asap', sans-serif;"><b id="head">HOPLINE</b></div>
					</div>
					<div class="navigation-right" style="margin-right:1em;" >
						<span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" " / style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px; opacity:0;" ></span>
						<nav class="link-effect-3" id="link-effect-3" >
							<ul class="nav1 nav nav-wil" style="background:#a79e9d; padding:1% 1% 1% 1%;  box-shadow:0px 0px  6px #888888;"  >
								<li class="active" ng-repeat="item in event.category" ng-click="event.takeMeTo(item.name)" style=" background:#be1e2d;width:48%;margin:1% 1% 1% 1%;  height: 100px; float:left; border-radius:3px 3px 3px 3px; "><img src="{{item.img}}" style="position:absolute; 
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
<script>

(function(){

	angular.module('eventModule', [])
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
	.controller('EventCtrl', ['$scope', 'MainTitle','$timeout','$http',function ($scope,mainTitle,$timeout,$http) {

	  this.title="All Food Items";
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || [];
	  this.totalCost=localStorage.getItem('totalCost')|| 0;
	  this.totalQuantity=localStorage.getItem('totalQuantity')|| 0;
	  this.master=[];
	  this.toast=false;
	  this.orderSummary=false;
	  $scope.min=1;
	  $scope.sec=60;
	  var mytimeout=null;
	  this.addOnTot=0;
	  this.addOnLength=1;

	  this.category=[
	  {
	      name:"Sandwiches",
	      img:"images/sandwich vector.png"
	  },
	  {
	      name:"Burgers",
	      img:"images/burger.png"
	  },
	  {
	      name:"Hoagie",
	      img:"images/hoagieee.png"
	  },
	  {
	      name:"Munchies",
	      img:"images/munchies.png"
	  },
	  {
	      name:"Salad",
	      img:"images/salad.png"
	  },
	  {
	      name:"Street Chineese ",
	      img:"images/streetchinese.png"
	  },
	  {
	      name:"Pasta",
	      img:"images/pasta.png"
	  },
	      
	  ]

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
	  this.favList=[];
	  
	this.checkMenuWithCart=function(){
		var check1 = JSON.parse(localStorage.getItem('checkList')) || [];
		
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
	    console.log(name);
	        var elementToShow = '#item-' + name + '-' + id;

	        $(elementToShow).slideToggle(500,'swing');
	        val.isExpanded=!val.isExpanded;
	        
	    };

	this.takeMeTo=function(name)
	  {
		name=name.split(' ').join('');
	    console.log(name);
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

	  console.log(value);
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
		console.log(this.addOnLength)
		var ab="-" + (((this.addOnLength-1)*50)/2 +115) + "px";
		console.log("#clearCartPopUp2-"+food.productId);
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
	  localStorage.setItem('totalCost',this.totalCost);
	  localStorage.setItem('totalQuantity',this.totalQuantity);
	};
	
	this.addCheckList=function(id,name,value)
	  {
	  var check = JSON.parse(localStorage.getItem('checkList')) || [];
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
		  		console.log(a);
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
	  	console.log(check);
	  }
	  obj.quantity=1;
	  localStorage.setItem('checkList', JSON.stringify(check));
	  this.checkList= JSON.parse(localStorage.getItem('checkList'));
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
	  var check = JSON.parse(localStorage.getItem('checkList')) || [];
	  obj = angular.copy(value);
	  var abc=0;
	  var ind=0;
	  for(var i=0;i<check.length;i++)
		  {
		  if(check[i].productId==obj.productId)
			  {
			  abc=abc+1;
			  ind=i;
			  console.log(abc);
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
	  localStorage.setItem('checkList', JSON.stringify(check));
	  this.checkList= JSON.parse(localStorage.getItem('checkList'));
	  this.totalOrder();
	};
	
	this.decItemFromCart=function(index)
	  {
	  var check = JSON.parse(localStorage.getItem('checkList')) || [];
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
	  localStorage.setItem('checkList', JSON.stringify(check));
	  this.checkList= JSON.parse(localStorage.getItem('checkList'));
	  this.totalOrder();
	};
	
	this.incItemFromCart=function(index)
	  {
	  var check = JSON.parse(localStorage.getItem('checkList')) || [];
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
	  localStorage.setItem('checkList', JSON.stringify(check));
	  this.checkList= JSON.parse(localStorage.getItem('checkList'));
	  this.totalOrder();
	};


	this.removeCartItem=function(index)
	{
	  var elementToRemove = '#cartItem-'+ index;
	  $(elementToRemove).hide();
	  var check1 = JSON.parse(localStorage.getItem('checkList')) || [];
	  console.log(check1[index].productId);
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
	  localStorage.setItem('checkList', JSON.stringify(check1));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || [];

	  this.totalOrder();
	};
	
	this.clearCart=function()
	{	
	  for(var i = 0; i < this.checkList.length; i++){
	  var elementToRemove = '#cartItem-'+ i;
	  $(elementToRemove).hide();
	  }
	  check1=[];
	  localStorage.setItem('checkList', JSON.stringify(check1));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || [];
	  this.totalOrder();
	  for(var i=0;i<this.foodItems.length;i++)
	  {
	  	for(var j=0;j<this.foodItems[i].products.length;j++)
	  		{
	  		
	  			this.foodItems[i].products[j].quantity=1;
	  			
	  		}
	  }
	};
	
	
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
	      if(this.checkList[i].addOns[j].selected==true)
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

