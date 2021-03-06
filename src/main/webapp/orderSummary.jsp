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
    <body ng-app="mainApp" ng-controller="EventCtrl as event" style="background-image: url(../images/checks.png)";min-height:100vh;> 

    <a id="return-to-top" style="z-index:11;"><i> </i></a>
    
    <div id="clearCartPopUp" style="display:none;position:fixed;top:0%;left:0%;width:100vh;height:100vh;background:grey;z-index:9;opacity:0.5;">
                                        
    </div>
    <div id="clearCartPopUp2" style="padding:5px;border-radius:3px;font-size:20px;z-index:10;position:fixed;width:300px;height:170px;text-align:center;color:grey;background:white;top:50%;left:50%;margin-top:-100px;margin-left:-150px;display:none;">
        <div style="height:75%"> Please make sure to pickup your delicious food from the restaurant when it's ready!</div>
        <div style="height:20%"><div id="okClear" style="width:50%;float:left;color:#89c08d"  ng-click="event.clearCart();">Ok</div><div id="cancelClear" style="width:50%;float:right;color:#c22929;">Cancel</div></div>
    </div>
        
    <a  class="addedtoast" style=" z-index:9;" ><b>Item Added</b></a>
                
        <!-- container -->
            <!-- header -->
            <div id="home" class="header" >

                <!-- top-hedader -->
                <div class="top-header" style="margin-top:15px;" >
                    <!-- /logo -->
                    <!--top-nav---->

                <div class="top-nav" style="position:fixed; top:0;width:100% ;background: #be1e2d ; padding-top:1em; padding-bottom:1em;z-index: 10; ">
                <div class="navigation">
                    <div class="logo" style="position:fixed;left:1em;">
                        <!-- <h1 ><a href="#">HOPLINE</a></h1> -->
                        <a href="shops">
                            <img src="images/hoplogo.png" alt=" " style="height:50px;margin-top:-10px;" / >
                        </a>    
                            <div style="color:white;margin-top:-26px;margin-left:55px;font-size:18px;font-family: 'Asap', sans-serif;"><b><s:property value="order.shop.shopName"/></b></div>
                        
                    </div>
                    <div class="navigation-right" style="margin-right:1em;" >
                        <span class="menu"><img id="menubutton" src="images/menubutton.png" alt=" " / style="height:35px; width:35px; margin-top:-2px; float:right; margin-right:2px;" ></span>
                        
                    </div>

                </div>
                </div>
        
<s:form action="/orderSummaryNext" id = "submitButton">
 <div id="place" class="bigBack" style="border:none; background:#4fb66d;z-index:999999">
    Place Order
 </div>
<s:submit id="placeOrder" value="Place Order" class="bigBack" style="border:none; background:#4fb66d" onclick="clearLocalStorage(); deleteAllCookies()"  />
</s:form> 
<div style="padding-top:20px;">
</div>

<div class="banner-info" id="sideSpacing" >
                <%
	                if(request.getParameter("lastPaymentFailed")!=null)
	                {
		                if(request.getParameter("lastPaymentFailed").equals("true") ) {
		         %>    
		         	
		         		   	<div class="header-right"> 	
		                 		<div  style="text-align:center;color: red;font-size: 120%">
		                 			Sorry Payment Failed
		                		</div>
		                	</div>
		         
		         <%
		                } 
	                }
                %>  
                <div class=" header-right">
                	<h6  style="text-align:center;">Order Summary</h6>
                    <ul class="address">
                        <s:iterator value="order.orderProducts">
                         <li  id="cartItem-{{$index}}" style="border-bottom: 1.5px dotted #AFAFAF;margin-top:2%;padding-bottom:2%;">
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
    <div id="paymentOptions" style="box-shadow:0px 0px  6px #888888;border-radius:5px;color:#C7C7C7;background:rgba(253, 246, 246, 1);height:125px;width:96%;z-index:9;margin-left:2%;padding-left:3%;padding-right:3%;">
        <div style="text-align:center;font-size:1.3em;margin-top:16px;padding-bottom:8px;padding-top:8px;border-bottom: 1px solid #AFAFAF;letter-spacing: 3px;text-transform: uppercase;">
            Payment Options
        </div>

        <form action="">
            <div>
                <div    id="cashPay" 
                        style=" color:grey;
                                width:53%;
                                float:left;
                                margin-top:2.5%;
                                padding-left:2%;">
                Pay cash on pickup
                </div> 
                <input  id="pay" 
                        type="radio" 
                        name="paymentMethod" 
                        value="cash" 
                        style=" margin-left:2%;
                                margin-top:4%;
                                float:right;
                                margin-right:2%">
            </div>
            
<!-- Payment Start -->
		<s:set name="avalue" value="order.shop.onlinePayYn" />
		<s:if test='%{#avalue.equals("Y")}'>
            <div>
                <div id="onlinePay"
                     style="color:grey;
                            width:53%;
                            float:left;
                            margin-top:2.5%;
                            padding-left:2%;">
                     Pay Online
                </div> 
                <input  id="onlinePayInput" 
                        type="radio" 
                        name="paymentMethod" 
                        value="online" 
                        style=" margin-left:2%;
                                margin-top:4%;
                                float:right;
                                margin-right:2%">
            </div>
        </s:if>

<!-- Payment End -->
        </form>
    </div>
	
    	<div id="paymentOptionsPopUp2" style="display:none;margin-left:20px;width: 20px; height: 0; border-left: 10px solid transparent; border-right: 10px solid transparent; border-bottom: 10px solid #c22929;opacity:0.8"></div>
    	<div id="paymentOptionsPopUp" style="display:none;padding-top:7px;opacity:0.8;text-align:center;border-radius:5px;color:white;background:#c22929;height:40px;width:96%;z-index:9;margin-left:2%">
        Please select a method of payment.
    
    </div>
    
                 <%
	                if(request.getParameter("lastPaymentFailed")!=null)
	                {
		                if(request.getParameter("lastPaymentFailed").equals("true") ) {
		         %> 
    		<div id="paymentOptions" style="box-shadow:0px 0px  6px #888888;border-radius:5px;color:#C7C7C7;background:rgba(253, 246, 246, 1);height:120px;width:96%;z-index:9;margin-left:2%;padding-left:3%;padding-right:3%;">
       		<div style="letter-spacing: 1px;font-weight: bold;color:black;text-align:center;font-size:1em;margin-top:16px;padding-bottom:8px;padding-top:8px;border-bottom: 1px solid #AFAFAF;">
           			
           			We regret for inconvenience caused, in case your money has been deducted by bank please write to us with your details(Mobile No) at mail.hopline@gmail.com
				
    		</div>
    		         <%
		                } 
	                }
                %> 
    	<div style="height:80px;">
    
    </div>
	
        </div>
    </div>
    

<script>
    function clearLocalStorage() {
        localStorage.clear();   
    }
</script>

<script>
function deleteAllCookies() {
    /*var cookies = document.cookie.split(";");

    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        console.log(name);
        if(name=="checkList" || name=="totalQuantity" || name=="totalCost" || name=="shopId")
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }*/
     document.cookie = 'shopId' + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
     document.cookie = 'totalQuantity' + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
     document.cookie = 'totalCost' + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
     document.cookie = 'checkList' + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}
</script>

<script>
$(document).ready(function(){
    
    $("#menubutton").css({"opacity":"0","pointer-events": "none","cursor": "default"});
    
})
</script>
<script>
$("#place").click(function(){
        if($('#pay').is(':checked')){
            $("#clearCartPopUp").css({display:'block'});
            $("#clearCartPopUp2").css({display:'block'});
        }
        else if($('#onlinePayInput').is(':checked')){
            $("#clearCartPopUp").css({display:'block'});
            $("#clearCartPopUp2").css({display:'block'});
        }
        else{
            
            $("html, body").animate({ scrollTop: $(document).height() },0);
            $("#cashPay").css({color:'red'})
            $("#onlinePay").css({color:'red'})
            $("#paymentOptionsPopUp").css({display:'block'});
            $("#paymentOptionsPopUp2").css({display:'block'});
        }
});
$("#okClear").click(function(){ 
      if($('#pay').is(':checked')){
            $("#clearCartPopUp").css({display:'none'});
            $("#clearCartPopUp2").css({display:'none'});
            $("#place").css({display:'none'});
            $('#placeOrder').trigger('click');
        }
        else if($('#onlinePayInput').is(':checked')){
            $("#clearCartPopUp").css({display:'none'});
            $("#clearCartPopUp2").css({display:'none'});
            $("#place").css({display:'none'});
            $("#submitButton").attr("action","/onlinePayment");
            $('#placeOrder').trigger('click');
        }
});
$("#cancelClear").click(function(){
    $("#clearCartPopUp").css({display:'none'});
    $("#clearCartPopUp2").css({display:'none'});
});
    $("#pay").click(function(){
        if($('#pay').is(':checked')){
            $("#paymentOptionsPopUp").css({display:'none'});
            $("#paymentOptionsPopUp2").css({display:'none'});
            $("#cashPay").css({color:'grey'});
            $("#onlinePay").css({color:'grey'});
        }
    });
    $("#onlinePayInput").click(function(){
        if($('#onlinePayInput').is(':checked')){
            $("#paymentOptionsPopUp").css({display:'none'});
            $("#paymentOptionsPopUp2").css({display:'none'});
            $("#cashPay").css({color:'grey'});
            $("#onlinePay").css({color:'grey'});
        }
    });
</script>
<script src="./app/angular.min.js"></script>
<script src="./app/angular-route.js"></script>
<script src="./app/mainApp.js"></script>
<script src="./app/ui.router.js"></script>

    </body>
</html>