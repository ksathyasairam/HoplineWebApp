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
	<body style="background-image: url(../images/checks.png);min-height:100vh;"> 

		<script>

    		$(function worker() {
   				$.getJSON('/yourOrderStates', function(data) {
   					console.log(data);
   					if(data.orderStatus.length==0){
   						$("#emptyYourOrderPopup").css({display:'block'});
   					}
   					else{
       				$.each(data.orderStatus, function(i, f) {
       					var rep="replaceStatus"+f.idorder;
       					if(f.orderState=="TEMP_SUBMIT")
       						{
          					var tblRow = "<div id=" + rep + " style='text-align:center;font-size:14px;'>"+ "PROCESSING..." +"</div>"; 
          					$("#progress"+f.idorder).css({width:((f.currentProgress/f.numUnitInProgressBar)*100)+"%"});
       						}
          				else if(f.orderState=="CANCELLED")
          					{
          					$("#progressBar"+f.idorder).css({display:'none'});
          					$("#info"+f.idorder).css({display:'none'});
          					var tblRow = "<div id="+ rep + "><div style='font-size:40px;text-align:center;color:#cf3721;'>:(</div><div style='text-align:center;font-size:14px;padding-bottom:3%;font-family: 'Raleway', sans-serif;}'>"+" Looks like the restaurant cancelled your order. Sorry for the inconvenience.</br><i>'" + f.cancelReason + "'</i></div></div>";
          					
          					}
          				else if(f.orderState=="PREPARING")
          					{
              				var tblRow = "<div id="+ rep + "><div><img src='images/chef.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "The chefs are working their magic! Your food will be ready soon." +"</div></div>";
              				$("#progress"+f.idorder).css({width:((f.currentProgress/f.numUnitInProgressBar)*100)+"%"});
          					}
              			else if(f.orderState=="COMPLETED")
              				{
              				$("#progressBar"+f.idorder).css({display:'none'});
          					$("#info"+f.idorder).css({display:'none'});
          					var tblRow = "<div id="+ rep + "><div style='font-size:40px;text-align:center;color:#4fb66d;'>:)</div><div style='text-align:center;font-size:14px;padding-bottom:3%;font-family: 'Raleway', sans-serif;'>"+ " Your order is complete." +"</div></div>";
          					
              				}
              			else if(f.orderState=="DEFAULTER_CALL")
	          				{
	          				$("#progressBar"+f.idorder).css({display:'none'});
	      					$("#info"+f.idorder).css({display:'none'});
	      					var tblRow = "<div id="+ rep + "><div><img src='images/defaulter.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='text-align:center;font-size:14px;padding-bottom:3%;font-family: 'Raleway', sans-serif;'>"+ "Your last order was not picked up by you. You will recieve a call shortly, to verify your order" +"</div></div>";
	      					
	          				}
                  		else if(f.orderState=="READY_FOR_PICKUP")
                  			{
                      		var tblRow = "<div id="+ rep + "><div><img src='images/ready.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='margin-top:1%;text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "Your food is ready for pick-up and awaits you!" +"</div></div>";
                      		$("#progress"+f.idorder).css({width:((f.currentProgress/f.numUnitInProgressBar)*100)+"%"});
                  			}
                      	else if(f.orderState=="UNPICKED")
                      		{
                          	var tblRow = "<div id="+ rep + "><div><img src='images/unpicked.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-38px;' / ></div><div  style='text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "Looks like you forgot to pick your order" +"</div></div>";
                          	$("#progress"+f.idorder).css({width:((f.currentProgress/f.numUnitInProgressBar)*100)+"%"});
                      		}
                         else if(f.orderState=="OK_ORDER")
                        	 {
                             var tblRow = "<div id="+ rep + "><div><img src='images/okorder2.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "Your order has been successfully accepted.The chef will start preparing soon." +"</div></div>"; 	
                             $("#progress"+f.idorder).css({width:((f.currentProgress/f.numUnitInProgressBar)*100)+"%"});
                        	 }
                         else if(f.orderState=="BIG_ORDER_PAY")
	               			{
	                   		var tblRow = "<div id="+ rep + "><div><img src='images/bigorder.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='margin-top:1%;text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "It seems your order amount exceeded Rs.1000,kindly pay this amount at the counter." +"</div></div>";
	                   		$("#progress"+f.idorder).css({width:((f.currentProgress/f.numUnitInProgressBar)*100)+"%"});
	               			}
                         else if(f.orderState=="BIG_ORDER_CALL")
	               			{
	                   		var tblRow = "<div id="+ rep + "><div><img src='images/bigorder.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='margin-top:1%;text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "Since your order has exceeded Rs 500, you will receive a call shortly to verify the order." +"</div></div>";
	                   		$("#progress"+f.idorder).css({width:((f.currentProgress/f.numUnitInProgressBar)*100)+"%"});
	               			}
          				$( "#replaceStatus"+f.idorder ).replaceWith( tblRow );
          				console.log(f.idorder);
          				console.log(f.orderState);
     				});
   					}
   				}).complete(function() {
   			      // Schedule the next request when the current one's complete
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
		<div  class="bigBack">
			Back to Menu
		</div>
	</a>
		
	<a  class="addedtoast" style=" z-index:9;" >
		<b>
			Item Added
		</b>
	</a>	
	<div style="color:white;position:fixed;right:10%;height:24px;  top:18px; float:right; margin-right:15px;z-index:999999;border:1px solid #ffffff;border-radius:3px;padding-left:2px;padding-right:2px;font-size:14px;">
		<a href="/feedback.jsp" style="color:white;">Feedback</a>
	</div>
	<div style="color:white;position:fixed;right:0%;height:24px;  top:18px; float:right; margin-right:15px;z-index:999999;padding-left:2px;padding-right:2px;font-size:14px;">
		<a href="tel:9958675060">
			<img src="images/phone.png" style="height:22px;" alt=" " / >
		</a>
	</div>			
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
						<span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" " / style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px;" ></span>
						
					</div>

				</div>
				</div>

			
<div class="spacing">
</div>
<div id="emptyYourOrderPopup" style="font-family: 'Raleway', sans-serif;display:none;text-align:center;z-index:90;position:fixed;width:90%;top:50%;margin-top:-110px;font-size:20px;height:220px;margin-left:5%;margin-right:5%;border-radius:3px;box-shadow:0px 0px  6px #888888; background:#c22929;color:#ffffff;padding-top:4%;opacity:0.7;">
	<div>
		<img src="images/dish-cover.png" alt=" " style="height:80px;"/>
	</div>
	We haven't received any order from you yet. Go ahead and let your taste buds loose!
	
</div>
<s:iterator value="orders">
<div id="<s:property value="idorder"/>" style="margin-bottom:5%;margin-left:1%;margin-top:7px; margin-right:1%; padding-left:2%;padding-right:2%; box-shadow:0px 0px  6px #888888; background: rgba(253, 246, 246, 1); float:left; width:98%;">
	<div style="float:left; width:100%">
		<div style="margin-left:-2%;display:inline-block;font-size:15px;width: 150px; height: 0; border-left: 0px solid transparent; border-right: 20px solid transparent; border-top: 30px solid #d15644;"></div>
		<div style="margin-top:-27px" >
		<div style="color:white;width:48%;display:inline-block;font-size:15px;"><b>Order No: #<s:property value="customerOrderId"/></b></div>
		<div style="width:50%;display:inline-block;text-align:right;color:#7d7b79;font-size:14px;font-family: 'Roboto', sans-serif;"><s:date name="orderTime" format="hh:mm a" /></div>
		
		<div style="width:100%;display:inline-block;">
			<div id="replaceStatus<s:property value="idorder"/>" style="text-align:center;">
				<div style="padding-top:2%;">
					<img src='images/11.gif' alt=' ' style='' / >
				</div>
			</div>
		</div>
		<div style="width:100%;padding-top:3%;display:inline-block;padding-bottom:3%;">
			<div id="progressBar<s:property value="idorder"/>" style="height:8px;width:90%;position:relative;left:50%;margin-left:-45%;border-radius:4px;background:#e4e4e4;">
				<div id="progress<s:property value="idorder"/>" style="width:0%;background:#4fb66d;height:100%;border-radius:4px">
					
				</div>
			</div>
		</div>
		<div id="info<s:property value="idorder"/>"  style="padding-top:2%;font-size:14px;z-index:99999;font-family: 'Roboto', sans-serif;color:#7d7b79;">
			<div style="width:60%;float:left;">Estimated time : <s:property value="orderCompleteTime"/> min</div>
			<div style="z-index:99999;width:30%;;text-align:right;float:right;color:white;">&#8377 <s:property value="totalPrice"/></div>
		</div>
		<div style="float:right;margin-right:-2%;margin-top:-7%;display:inline-block;font-size:15px;width: 150px; height: 0; border-left: 20px solid transparent; border-right: 0px solid transparent; border-bottom: 30px solid #388dad;color:white;font-size:14px;padding-left:10%;"><div style="margin-top:5px;">&#8377 <s:property value="totalPrice"/></div></div>
		
	</div>
	</div>
</div>

<div id="show<s:property value='idorder'/>" class="banner-info" style="margin-left:1%;margin-right:1%; display:none;">

				<div class=" header-right" style=" border-radius:0px 0px 3px 3px; border-left:1px solid #888888;border-right:1px solid #888888;border-bottom:1px solid #888888;margin-top:-5%">

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
						 <div>
						 	<div style=" float:right; color:#525a54;  font-size:14px;">
						 		Total: &#8377 <s:property value="totalPrice"/>
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
				
</div>
<script>
	$('#<s:property value="idorder"/>').click(function() {    
    $('#show<s:property value="idorder"/>').toggle();
	});
</script>
</s:iterator>
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