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
   					else if(data.orderStatus.length>0){
       				$.each(data.orderStatus, function(i, f) {
       					var rep="replaceStatus"+f.idorder;
       					var est=f.orderCompleteTime;
       					if(f.orderState=="TEMP_SUBMIT")
       						{
          					var tblRow = "<div id=" + rep + " style='text-align:center;font-size:14px;'>"+ "PROCESSING..." +"</div>"; 
          					$("#progress"+f.idorder).css({width:"0%"});
       						}
          				else if(f.orderState=="CANCELLED")
          					{
          					$("#progressBar"+f.idorder).css({display:'none'});
          					var tblRow = "<div id="+ rep + "><div style='font-size:40px;text-align:center;color:#cf3721;'>:(</div><div style='text-align:center;font-size:14px;padding-bottom:3%;font-family: 'Raleway', sans-serif;}'>"+" Looks like the restaurant cancelled your order. Sorry for the inconvenience.</br><i>'" + f.cancelReason + "'</i></div></div>";
          					
          					}
          				else if(f.orderState=="PREPARING")
          					{
              				var tblRow = "<div id="+ rep + "><div><img src='images/chef.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "The chefs are working their magic! Your food will be ready soon." +"</div></div>";
              				$("#progress"+f.idorder).css({width:"48%"});
              				$("#one"+f.idorder).css({border:'6px solid #46a060'})
              				$("#two"+f.idorder).css({border:'6px solid #46a060'});
          					}
              			else if(f.orderState=="COMPLETED")
              				{
              				$("#one"+f.idorder).css({border:'6px solid #46a060'})
              				$("#two"+f.idorder).css({border:'6px solid #46a060'});
                      		$("#three"+f.idorder).css({border:'6px solid #46a060'})
              				$("#progress"+f.idorder).css({width:"100%"});
          					var tblRow = "<div id="+ rep + "><div style='font-size:40px;text-align:center;color:#4fb66d;'>:)</div><div style='text-align:center;font-size:14px;padding-bottom:3%;font-family: 'Raleway', sans-serif;'>"+ " Your order is complete." +"</div></div>";
          					
              				}
              			else if(f.orderState=="DEFAULTER_CALL")
	          				{
	      					$("#info"+f.idorder).css({display:'none'});
	      					var tblRow = "<div id="+ rep + "><div><img src='images/defaulter.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='text-align:center;font-size:14px;padding-bottom:3%;font-family: 'Raleway', sans-serif;'>"+ "Your last order was not picked up by you. You will recieve a call shortly, to verify your order" +"</div></div>";
	      					
	          				}
                  		else if(f.orderState=="READY_FOR_PICKUP")
                  			{
                      		var tblRow = "<div id="+ rep + "><div><img src='images/ready.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='margin-top:1%;text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "Your food is ready for pick-up and awaits you!" +"</div></div>";
                      		$("#progress"+f.idorder).css({width:"73.5%"});
                      		$("#one"+f.idorder).css({border:'6px solid #46a060'})
              				$("#two"+f.idorder).css({border:'6px solid #46a060'});
                      		$("#three"+f.idorder).css({border:'6px solid #46a060'})
                  			}
                      	else if(f.orderState=="UNPICKED")
                      		{
                          	var tblRow = "<div id="+ rep + "><div><img src='images/unpicked.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-38px;' / ></div><div  style='text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "Looks like you forgot to pick your order" +"</div></div>";
                      		}
                         else if(f.orderState=="OK_ORDER")
                        	 {
                             var tblRow = "<div id="+ rep + "><div><img src='images/okorder2.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-22px;' / ></div><div style='text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "Your order has been successfully accepted.The chef will start preparing soon." +"</div></div>"; 	
                             $("#progress"+f.idorder).css({width:"24.3%"});
                             $("#one"+f.idorder).css({border:'6px solid #46a060'})
                        	 }
                         else if(f.orderState=="BIG_ORDER_PAY")
	               			{
	                   		var tblRow = "<div id="+ rep + "><div><img src='images/bigorder.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='margin-top:1%;text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "It seems your order amount exceeded Rs. 1500,kindly pay amount at the counter." +"</div></div>";
	               			}
                         else if(f.orderState=="BIG_ORDER_CALL")
	               			{
	                   		var tblRow = "<div id="+ rep + "><div><img src='images/bigorder.png' alt=' ' style='height:50px;position:relative;left:50%;margin-left:-30px;' / ></div><div style='margin-top:1%;text-align:center;font-size:14px;font-family: 'Raleway', sans-serif;'>"+ "Since your order has exceeded Rs. 1000, you will receive a call shortly to verify the order." +"</div></div>";
	               			}
          				$( "#replaceStatus"+f.idorder ).replaceWith( tblRow );
          				if(f.orderCompleteTime )
          					$("#estTime"+ f.idorder).text("Est Time: " + f.orderCompleteTime + " min");
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
		
	<a href="/shops">
		<div  class="bigBack">
			Back
		</div>
	</a>
		
	<a  class="addedtoast" style=" z-index:9;" >
		<b>
			Item Added
		</b>
	</a>	
	<s:form action="/feedbackOnLoad">
		<s:submit value="Feedback" style="color:white;position:fixed;right:0%;height:24px;top:18px; float:right; margin-right:15px;z-index:999999;border:1px solid #ffffff;border-radius:3px;padding-left:2px;padding-right:2px;font-size:14px;background:none" />
	</s:form>
		<!-- container -->
			<!-- header -->
			<div id="home" class="header" style="padding-bottom:50px;" >

				<!-- top-hedader -->
				<div class="top-header" style="margin-top:15px;" >
					<!-- /logo -->
					<!--top-nav---->

				<div class="top-nav" style="position:fixed; top:0;width:100% ;background: #be1e2d ; padding-top:1em; padding-bottom:1em;z-index: 10; ">
				<div class="navigation">
					<div class="logo" style="position:fixed;left:1em;">
						<a href="shops">
							<img src="images/hoplogo.png" alt=" " style="height:50px;margin-top:-10px;" / >
						</a>
							<div style="color:white;margin-top:-26px;margin-left:55px;font-size:18px;font-family: 'Asap', sans-serif;"><b>ORDERS</b></div>
						
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
<div style="margin-top:7px;margin-right:1%;float:right;display:inline-block;font-size:17px;min-width: 150px; height: 0; border-left: 0px solid transparent; border-left: 20px solid transparent; border-bottom: 30px solid #d15644;color:white;text-align:center;text-transform:uppercase">
	<strong style="margin-top:3px"><s:property value="shop.shopName"/></strong>
	<s:set name="avalue" value="paidYn" />
	<s:if test='%{#avalue.equals("N")}'>
		<img src='images/paidStamp.png' alt=''  style='height:30px;float:right'/>
	</s:if>
</div>
<div  style="margin-bottom:5%;margin-left:1%; margin-right:1%; padding-left:2%;padding-right:2%; box-shadow:0px 0px  6px #888888; background: rgba(253, 246, 246, 1); float:left; width:98%;">
	<div  style="float:left; width:100%">
		<div style="margin-left:-2%;display:inline-block;font-size:15px;width: 150px; height: 0; border-left: 0px solid transparent; border-right: 20px solid transparent; border-top: 30px solid #d15644;"></div>
		<div id='yoyo<s:property value="idorder"/>' style="margin-top:-27px" >
			<div style="color:white;width:48%;display:inline-block;font-size:15px;"><b>Order No: #<s:property value="customerOrderId"/></b></div>
			<div id='estTime<s:property value="idorder"/>' style="width:50%;display:inline-block;text-align:right;color:#7d7b79;font-size:14px;font-family: 'Roboto', sans-serif;"></div>
			
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
					<div id="one<s:property value="idorder"/>" style="border-radius:10px;width:20px;height:20px;border:6px solid #c8c3c3;position:relative;float:left;margin-left:22.5%;margin-top:-14px;">
					
					</div>
					<div id="two<s:property value="idorder"/>" style="border-radius:10px;width:20px;height:20px;border:6px solid #c8c3c3;position:relative;float:left;margin-left:18%;margin-top:-14px;">
						
					</div>
					<div id="three<s:property value="idorder"/>" style="border-radius:10px;width:20px;height:20px;border:6px solid #c8c3c3;position:relative;float:left;margin-left:18%;margin-top:-14px;">
						
					</div>
				
				</div>
				
			</div>
		</div>
		<div id="info<s:property value="idorder"/>"  style="padding-top:2%;font-size:14px;z-index:99999;font-family: 'Roboto', sans-serif;color:#7d7b79;">
			<a href="tel: <s:property value="shop.phone"/>" ><div style="border-radius:2px;width:30%;float:left;border:1px solid #388dad; color:#388dad; text-align:center;padding-top:1px;">Call <s:property value="shop.shopName"/></div></a>
		</div>
		<div style="float:right;margin-right:-2%;display:inline-block;font-size:15px;width: 150px; height: 0; border-left: 20px solid transparent; border-right: 0px solid transparent; border-bottom: 30px solid #388dad;color:white;font-size:14px;padding-left:10%;"><div style="margin-top:5px;">&#8377 <s:property value="totalPrice"/></div></div>	
	</div>
</div>

<div id="show<s:property value='idorder'/>" class="banner-info" style="margin-left:1%;margin-right:1%; display:none;">

				<div class=" header-right" style="color:#525a54; border-radius:0px 0px 3px 3px; border-left:1px solid #888888;border-right:1px solid #888888;border-bottom:1px solid #888888;margin-top:-5%">
					<div>
						<s:date name="orderTime" format="hh:mm a" />
					</div>
					<ul class="address" style="margin-top: 1em;">
						<s:iterator value="orderProducts">
						 <li  style="border-bottom: 1.5px dotted #AFAFAF; padding-bottom:3%;padding-top:2%;">
						 	
						 	<div class="order_summary_name">
						 		<s:property value="product.name"/>
						 	</div>
						 	
						 	<div style="color:#525a54;float:right;width:40px;display:inline-block;text-align:right">
						 		x <s:property value="count"/> 
						 		
						 		
						 	</div>
						 	<br>
						 	<s:iterator value="orderProductAddons">
						 		<div class="order_summary_addon">
						 			<div style="color:#525a54;float:left;">
						 				+ <s:property value="addOn.name"/> 
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
	$('#yoyo<s:property value="idorder"/>').click(function() {    
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
<script>
function goBack() {
    window.history.back();
}
</script>





	</body>
</html>