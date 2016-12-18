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

	<script>

    		$(function worker() {
    			 var path="/orderState";
    			    method = "post"; 
					var count=0;
    			    var form = document.createElement("form");
    			    form.setAttribute("method", method);
    			    form.setAttribute("action", path);

    			var hiddenField = document.createElement("input");
    			            hiddenField.setAttribute("type", "hidden");
    			            hiddenField.setAttribute("name", "orderId");
    			            hiddenField.setAttribute("value",'<s:property value="order.customerOrderId"/>');

    			            form.appendChild(hiddenField);
    			            document.body.appendChild(form);
    			            console.log('<s:property value="order.customerOrderId"/>');
    			            
    			            $.ajax({
    			            	   url: '/orderState',                           
    			            	   data: $('form').serialize(),                 
    			            	   success: function (data) {                       
    			            	      console.log(data);
    			            	      if(data!="BIG_ORDER_PAY")
    			            	    	  {
    			            	    	  window.location.replace('/yourOrders');
    			            	      	  count=1;
    			            	    	  }
    			            	      	  
    			            	      
    			            	   },
    			            	   error: function (xhr, text, error) {              
    			            	      console.log('Error: ' + error);
    			            	   }
    			            	}).complete(function() {
    			            		$("form").remove();
    				   			      // Schedule the next request when the current one's complete
    				   			      if(count==0)
    				   			      setTimeout(worker, 5000);
    				   			    });			    	    
			});
    	
		</script>
	<a id="return-to-top" style="z-index:11; ">
		<i>
			<img src="images/up.png" alt=" " / >
		</i>
	</a>
	<a   href="/singlePageApp#/home">
		<div class="bigBack" style="border:none;">
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
			<div id="home" class="header" style="padding-bottom:50px;" >

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
							<span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" "  style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px;" /></span>
							
						</div>	
					</div>
				</div>

			
<div class="spacing">
</div>
<div id="sideSpacing">
	
	<div style="border-radius:3px;box-shadow:0px 0px  6px #888888; background:#ffffff;color:#6d6c6c;padding-top:4%;opacity:0.7;padding-bottom:7%;height:81vh;">
		<div style="color:#c22929;font-size:27px;text-align:center;margin-top:-10px">
			Order No.
		</div>
		<div style="position:relative;margin-left:-50px;left:50%;margin-top:2%;height:100px;width:100px;border-radius:50px;box-shadow:0px 0px  0px #888888; background:none;color:#c22929;border:2px solid #c22929;">
			<div style="text-align:center;position:relative;top:50%;margin-top:-27px;font-size:38px;vertical-align:middle;">
				<s:property value="order.customerOrderId"/>
			</div>
		</div>
		<div style="margin-left:2%;position:relative;margin-top:8%;height:50px;width:96%;box-shadow:0px 0px  0px #888888; background:none;color:#6d6c6c;border:2px solid #c22929; border-radius:4px">
			<div style="position:relative;top:50%;margin-top:-14px;font-size:16px;vertical-align:middle;float:left;margin-left:2%;">
				Qty:<s:property value="order.totalItemCount"/>
			</div>
			<div style="position:relative;top:50%;margin-top:-14px;font-size:16px;vertical-align:middle;text-align:right;margin-right:2%;">
				&#8377:<s:property value="order.totalPrice"/>
			</div>
		</div>
		<div style="position:absolute;bottom:11%;">
			<div style="text-align:center; margin-left:1%; padding-left:2%;padding-right:2%;padding-top:2%;padding-bottom:6%; box-shadow:0px 0px  0px #888888; background:#c22929;opacity:1; width:96%;height:80px;color:#ffffff;border-radius:3px;">
				<div style="float:left;">
					<img src="images/spoon.png" alt=" " style="height:60px;margin-top"/>
				</div>	
			
				<div style="float:right;">
					<img src="images/fork1.png" alt=" " style="height:60px;"/>
				</div>
				<div >
					It seems your order amount exceeded Rs.1000,kindly pay this amount at the counter.
				</div>
			</div>
			<div>
				<img src="images/bg2.png" alt=" " style="height:95px;margin-top:1%;"/>
			</div>
		</div>
	</div>
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