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
						<h1 ><a ui-sref='restaurant'>HOPLINE</a></h1>
					</div>
					<div class="navigation-right" style="margin-right:1em;" >
						<span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" " / style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px;" ></span>
						<nav class="link-effect-3" id="link-effect-3" >
							<ul class="nav1 nav nav-wil" style="background:#a79e9d; padding:1% 1% 1% 1%;  box-shadow:0px 0px  6px #888888;"  >
								<li class="active" ng-repeat="item in event.category" ng-click="event.takeMeTo(item.name)" style=" background:#b22e1b;width:48%;margin:1% 1% 1% 1%;  height: 100px; float:left; border-radius:3px 3px 3px 3px; "><img src="{{item.img}}" style="position:absolute; 
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
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular-route.js"></script>




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
	  this.totalCost1=0;
	  this.totalQuantity1=0;
	  this.master=[];
	  this.toast=false;
	  this.orderSummary=false;
	  $scope.min=1;
	  $scope.sec=60;
	  var mytimeout=null;

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
	{
	  name:'Thee Pot',
	  description:'Cafe',
	  address:'Shop 17, Godavari Market, Sector 37, Noida',
	  image:'images/theepot.png'

	},


	]

	  this.value="";

	  this.foodItems=  <s:property escape="false"  value="menuJsonString"/>	 

	this.showContent=function(id,name,val)
	  {
	    console.log(name);
	        var elementToShow = '#item-' + name + '-' + id;

	        $(elementToShow).slideToggle(500,'swing');
	        val.isExpanded=!val.isExpanded;
	        
	    };

	this.takeMeTo=function(name)
	  {
	    console.log(name);
	    var element='#' + name;
	      $("body, html").animate({ 
	        scrollTop: $( element ).offset().top - 105
	      }, 600);


	    };
	 this.decreaseItemCount = function(val) {

	  if(val.quantity>1)
	  {
	  val.quantity= val.quantity-1;

	  }
	  else if(val.quantity==1)
	  val.isExpanded=!val.isExpanded;

	  };

	this.addCheckList=function(id,name,value)
	  {
	  var check = JSON.parse(localStorage.getItem('checkList')) || [];
	  obj = angular.copy(value);
	  check.push(obj);
	  localStorage.setItem('checkList', JSON.stringify(check));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || [];
	  
	  console.log(this.checkList);
	  value.quantity=1;
	  
	  for(var i=0;i<value.addOns.length;i++){
	    value.addOns[i].selected=false;
	  }
	  
	  $('.addedtoast').animate({top: '80'},1000);
	  $('.addedtoast').fadeOut(1500);
	  $('.addedtoast').css({top: '4%'});
	  $('.addedtoast').show();    
	};

	this.cancelOrder=function(value)
	{
	  value.quantity=1;
	  for(var i = 0; i < value.addOns.length; i++){
	  value.addOns[i].selected=false;  
	  }

	  console.log(value);
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
	      tot= tot + (this.checkList[i].addOns[j].price*this.checkList[i].quantity*this.checkList[i].addOns[j].selected);
	      
	    }
	    this.totalCost= this.totalCost+tot;
	    
	  }
	  localStorage.setItem('totalCost',this.totalCost);
	  localStorage.setItem('totalQuantity',this.totalQuantity);
	};


	this.removeCartItem=function(index)
	{
	  var elementToRemove = '#cartItem-'+ index;
	  $(elementToRemove).hide();
	  var check1 = JSON.parse(localStorage.getItem('checkList')) || [];
	  check1.splice(index, 1);
	  localStorage.setItem('checkList', JSON.stringify(check1));
	  this.checkList= JSON.parse(localStorage.getItem('checkList')) || [];
	  this.totalOrder();
	};



	this.post1=function() {
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
	};



	}])



	})();

</script>

	</body>
</html>

