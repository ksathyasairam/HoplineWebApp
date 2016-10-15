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
		<script>
			$.ajax({
			url: 'http://localhost:8080/yourOrderStates',
			type: "GET",
			dataType: "json",
			success: function (data) {
 			console.log(data);
			}
			});
		</script>
	<a id="return-to-top" style="z-index:11; ">
		<i>
			<img src="images/up.png" alt=" " / >
		</i>
	</a>
	<a   href="http://localhost:8080/singlePageApp#/home">
		<div style="position:fixed; left:1%; bottom:5px; background:#67baca; opacity:0.9; height:40px; text-align:center;padding-top:2%;padding-bottom:3%;border-radius:3px 3px 3px 3px;color:white;width:98%;z-index:11" >
			Back to Menu
		</div>
	</a>
		
	<a  class="addedtoast" style=" z-index:9;" >
		<b>
			Item Added
		</b>
	</a>
				
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
<s:iterator value="orders">
<div id="<s:property value="customerOrderId"/>" style="margin-left:7px;margin-top:7px; margin-right:7px; padding-left:2%;padding-right:2%; box-shadow:0px 0px  6px #888888; background: rgba(253, 246, 246, 1); float:left; width:96%;">
	<div style="float:left; width:55%; ">
		<h4>Order No: #<s:property value="customerOrderId"/></h4>
		<p style="font-size:12px;">1 Jan 2016<br> 2:30 PM</p>
	</div>

					
</div>

<div id="show<s:property value="customerOrderId"/>" class="banner-info" style="margin-left:7px;margin-right:7px; display:none"  >

				<div class=" header-right">

					<ul class="address">
						<s:iterator value="orderProducts">
						 <li  style="border-bottom: 1.5px dotted #AFAFAF; padding-bottom:3%;padding-top:2%;">
						 	
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
						 		Total: &#8377.<s:property value="totalPrice"/>
						 	</div>
						 	<div style=" float:left; color:#525a54;  font-size:14px;">
						 		Quantity: <s:property value="totalItemCount"/>
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
<script>
$('#<s:property value="customerOrderId"/>').click(function() {    
    $('#show<s:property value="customerOrderId"/>').toggle();
});
	
</script>
</s:iterator>
		</div>
	</div>

<script>
$(document).ready(function(){
	
	$("#menubutton").css({"opacity":"0","pointer-events": "none","cursor": "default"});
})
</script>





	</body>
</html>