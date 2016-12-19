
@import url('/customer/responsive/css/fonts/fonts.css');

html{
	overflow-y: scroll;
}
html, body{
	height: 100%;	
}

body{
	background: white;
	margin: 0;
	font : 16px "Proxima Nova", Arial, Helvetica, sans-serif;
	color: #333333;
	line-height: 1;
}
a{
	text-decoration: none;
	color: #333333;
	outline: none;
}
h1{
	font-size: 16px;
	margin: 0;
}
h2, h3, h4, h5{
	font-size: 14px;
	margin: 0;
}

p { margin: 0; padding: 0; }

img {
	border: 0; 
}
form{
	margin: 0px;
	padding: 0px;
}
input, select, textarea{
	vertical-align: middle;
}
label{
	vertical-align: middle;
}
hr{
	color: black;
	height: 1px;
	border: 0;
	margin: 25px 0;
	border-bottom: 1px solid black;
}
ul{
	list-style: none;
	margin: 0;
	padding: 0;
}
/*---------------Layout------------------------------*/
.main_center{	
	margin: 0 auto;	
	max-width: 700px;
 	position: relative;
 
}

.top_main_center{	
 
	 
}
 
 
.locationdata a{	
 color:#80ff80;
}

.default_error {
	color:#b00000;}

.responsive_error {
	background-color:#fda490;}
	
.agree_responsive_error {
	background-color:#fda490;padding:8px;}	
	
.responsive_noerror {
	background-color: transparent;}	
	
.topmain a{	
 color:#80ff80;
}


#top{
	background-color: #27AE60;
	color: white;
}
#center{
	padding: 60px 0;
	 
}
#bottom{
	background-color: #F7F7F7;
	padding: 50px 0 70px 0;
	text-align: center;
}
/*---------------Common------------------------------*/

.errormsg{
	line-height:28px;
	font-weight:bold;
	color:#ff0000;
	margin-bottom:10px;
}
.clear{
	clear: both;
	overflow: hidden;
	height: 0px;
	display: block;
}
.f-left{
	float: left !important;
}
.f-right{
	float: right !important;
}
.a-left{
	text-align: left !important;
}
.a-right{
	text-align: right !important;
}
.a-center{
	text-align: center !important;
}

.color_header{
	font-size: 20px;
	display: block;
	margin-bottom: 25px;
	color: #27ae60;
	font-weight: 600;
	text-transform: uppercase;
	line-height: 1;
}
/*---------------------------------------------------*/
.show_on_mobile{
	display: none!important;
}
.hide_on_mobile{
	display: block;
}
span.hide_on_mobile{
	display: inline;
}
/*---------------------------------------------------*/
.textcontent{
	font-size: 18px;
	line-height: 1.3;
}
.textcontent .header{
	font-size: 28px;
	display: block;
	margin-bottom: 25px;
}
.textcontent ul{
	margin: 25px 0;
}
.textcontent ul li{
	background: url(/customer/responsive/images/bg_li.png) no-repeat left center;
	padding-left: 20px;
	margin-bottom: 5px;
}
.textcontent ul li:last-child{
	margin-bottom: 0;
}
.textcontent p{	
	line-height: 1.3;
	margin-bottom: 25px;
}
.textcontent p:last-child{
	margin-bottom: 0;
}
.textcontent img.f-left{
	margin: 0 30px 30px 0;
}
/*---------------------------------------------------*/
.button1{
	background: #27AE60;
	color: white;
	text-decoration: none;
	text-align: center;
	border: none;
	height: 55px;
	line-height: 55px;
	font-size: 18px;
	cursor: pointer;
	font-weight: bold;
	border-radius: 8px;	
	padding: 0 20px;
	display: inline-block;
	
	 
}

.button1:focus, .button1:active {
 background-color: #666;
    -webkit-transition: background-color 10ms linear;
    -moz-transition: background-color 100ms linear;
    -o-transition: background-color 10ms linear;
    -ms-transition: background-color 10ms linear;
    transition: background-color 100ms linear; 
}
 


.button1.happy:active {
     background-color:red
}

.button1.disabled{
	background-color: #CCCCCC;
	cursor: default;
}
/*---------------------------------------------------*/

 .button2{
	background: #27AE60;
	color: white;
	text-decoration: none;
	text-align: left;
	border: none;
	height: auto;
	line-height: 28px;
	font-size: 18px;
	cursor: pointer;
	font-weight: bold;
	border-radius: 8px;	
	padding:  15px 20px;
	display: inline-block;
	overflow:visible;
	
	 
}

.button2:focus, .button2:active {
 background-color: #666;
    -webkit-transition: background-color 10ms linear;
    -moz-transition: background-color 100ms linear;
    -o-transition: background-color 10ms linear;
    -ms-transition: background-color 10ms linear;
    transition: background-color 100ms linear; 
}
 
.buttontext{margin:0px;}

.button2.happy:active {
     background-color:red
}

.button2.disabled{
	background-color: #CCCCCC;
	cursor: default;
}

#sms_login
{display:none; margin-top:-20px;margin-bottom:25px;padding:0;}
/*---------------------------------------------------*/
#top{
	text-align: center;
	/*text-shadow: 1px 1px 1px rgba(0,0,0, 0.21);*/
	padding: 80px 0;
}

#topright{
	text-align: center;
	margin-top: 30px;
	margin-bottom:-30px;
	max-width:540px;
	padding-right:20px;
	padding-left:20px;
 	 
	
	
}
#topright img{
 width:100%;
}


#bottomleft{
	text-align: center;
	margin-top: 10px;
	margin-bottom:-20px;
	max-width:190px;
	padding-right:20px;
	padding-left:20px;
	padding-bottom:00px;
	
}
#bottomleft img{
 width:100%;
}



#top .logo{
	background: url(/customer/responsive/images/logo.png) no-repeat;
	width: 119px;	
	height: 119px;
	display: inline-block;
	text-indent: -10000px;
	 background-position:center;
 
	
}
@media all and (-webkit-min-device-pixel-ratio: 1.5) {
  #top .logo {
    background-image: url(/customer/responsive/images/logo@2x.png);
    background-size: 119px 119px;
  }
}
#top .logo a{
	display: block;
	 
}

#top .big_header{
	font-size: 68px;
	font-weight: 600;
	display: block;
	margin-top: 40px;
	margin-bottom: 30px;
	overflow:hidden;	
	/*text-shadow: 1px 1px 1px rgba(0,0,0, 0.21);*/
}
#top p{
	font-size: 26px;
	line-height: 1.3;
	margin-bottom: 10px;
}

 .ltop{
	padding-top: 50px !important; 
	padding-bottom:50px !important; 
}

.combinedtop {
	margin-top: -160px;
}

.voucher_error_responsive{
	color:#900;
}
 
/*---------------------------------------------------*/
.main_panels{
	width: 350px;
	margin: 0 auto;
}
.main_panels .panel_item{
	margin-bottom: 23px;
}
.main_panels .panel_item:last-child{
	margin-bottom: 0;
}
.main_panels a.openbutton{
	font-size: 17px;
	font-weight: 600;
	text-transform: uppercase;
	/*text-shadow: 1px 1px 1px rgba(0,0,0, 0.21);*/
	background: #333333;
	display: block;
	color: white;
	text-align: center;
	padding: 23px 10px 20px 10px;
	border-radius: 8px;
	line-height: 1.2;
	transition: all 0.2s;
	-moz-transition: all 0.2s;
	-webkit-transition: all 0.2s;
	-o-transition: all 0.2s;
}
.main_panels a.openbutton:hover{
	background-color: #555555;
}

#login_panel.panel_item a.openbutton{
	background: #27ae60 ;
}

#skip.panel_item a.openbutton{
	background: #27ae60 ;
}

#sms_login.panel_item a.openbutton{
	background: #27ae60 ;
}

#facebook_button.panel_item a.openbutton{
	background: #2f4b87 ;
    background-image:url(/images/facebook_logo.png);
	background-position:2px;
	background-repeat:no-repeat;
}

@media all and (-webkit-min-device-pixel-ratio: 1.5) {
	   
  #facebook_button.panel_item a.openbutton {
    background-image: url(/images/facebook_logo@2x.png);
    background-size: 59px 59px;
  }
}

#twitter_button.panel_item a.openbutton{
	background: #55acee ;
    background-image:url(/images/twitter_logo.png);
	background-position:2px;
	background-repeat:no-repeat;
}

@media all and (-webkit-min-device-pixel-ratio: 1.5) {
	   
  #twitter_button.panel_item a.openbutton {
    background-image: url(/images/twitter_logo@2x.png);
    background-size: 59px 59px;
  }
}

 
/*---------------------------------------------------*/
.langselect_container{
	width: 280px;
	margin: 0 auto 30px auto;
}

.langselect{
	position: relative;
	background: #222222; 
	border: 1px solid #444444; 
	color: white; 
	font-size: 14px; 
	padding: 0 9px 0 7px;
	line-height: 40px;
	cursor: pointer;
	border-radius: 4px;
	text-align: left;
	overflow: hidden;
}


.langselect::before {
    border-color: #27ae60 transparent transparent;
    border-style: solid;
    border-width: 6px;
    content: "";
    height: 0; 
    pointer-events: none;
    position: absolute;
    right: 20px;
    top: 18px; 
    width: 0;
}

.langselect_container .title{
	font-size: 16px;
	font-weight: bold;
	display: block;
	margin-bottom: 20px;
}

.langselect a{
	color: white;
	display: block;
}
.langselect a:hover{
	color: #cacaca;
}
.langselect .lang{
	background: no-repeat left center;
	padding-left: 23px;
	min-height: 29px;
	display: block;
}
.langselect .lang.hu{ background-image: url(/customer/responsive/images/flag_hu.gif); }
.langselect .lang.en{ background-image: url(/customer/responsive/images/flag_en.gif); }
.langselect .lang.de{ background-image: url(/customer/responsive/images/flag_de.gif); }
.langselect .lang.ro{ background-image: url(/customer/responsive/images/flag_ro.gif); }
.langselect .lang.pt{ background-image: url(/customer/responsive/images/flag_pt.gif); }
.langselect .lang.it{ background-image: url(/customer/responsive/images/flag_it.gif); }
.langselect .lang.sk{ background-image: url(/customer/responsive/images/flag_sk.gif); }
.langselect .lang.fr{ background-image: url(/customer/responsive/images/flag_fr.gif); }
.langselect .lang.nl{ background-image: url(/customer/responsive/images/flag_nl.gif); }
.langselect .lang.no{ background-image: url(/customer/responsive/images/flag_no.gif); }
.langselect .lang.da{ background-image: url(/customer/responsive/images/flag_da.gif); }
.langselect .lang.et{ background-image: url(/customer/responsive/images/flag_et.gif); }
.langselect .lang.ru{ background-image: url(/customer/responsive/images/flag_ru.gif); }
.langselect .lang.gr{ background-image: url(/customer/responsive/images/flag_gr.gif); }
.langselect .lang.pl{ background-image: url(/customer/responsive/images/flag_pl.gif); }
.langselect .lang.se{ background-image: url(/customer/responsive/images/flag_se.gif); }
.langselect .lang.tr{ background-image: url(/customer/responsive/images/flag_tr.gif); }
.langselect .lang.fi{ background-image: url(/customer/responsive/images/flag_fi.gif); }
.langselect .lang.si{ background-image: url(/customer/responsive/images/flag_si.gif); }
.langselect .lang.ms{ background-image: url(/customer/responsive/images/flag_ms.gif); }
.langselect .lang.es{ background-image: url(/customer/responsive/images/flag_es.gif); }
.langselect .lang.ca{ background-image: url(/customer/responsive/images/flag_ca.gif); }
.langselect .lang.hr{ background-image: url(/customer/responsive/images/flag_hr.gif); }



.langselect ul.select{
	display: none;
}
.langselect.opened ul.select{
	display: block;
}
.langselect.opened ul li{
	
}
/*---------------------------------------------------*/
#bottom .links{
	font-size: 16px;
	line-height: 2;
	margin-bottom: 10px;
}
#bottom .links a{
	font-weight: bold;
	color: #27ae60;
}
#bottom .copyright{
	font-size: 16px;
	line-height: 1.5;
}
/*---------------------------------------------------*/
.over_panel{
	background: white;
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	min-height: 100%;
	z-index: 10;
	top:-10000px; /*panel flashing prevent*/
}
.over_panel.opened{
	/*display: block;*/
}
.over_panel header{
	background-color: #27ae61;
	font-size: 32px;	
	color: #ffffff;
	padding: 40px 0;

	border-bottom: 1px solid #E4E4E4;
	position: relative;
	overflow: hidden;
}
/*.over_panel header .main_center{
	width: 700px;
}*/
.over_panel header strong{
	font-weight: normal;
	display: block;
}
.over_panel header a.close{
	background: url(/customer/responsive/images/bg_close.png) no-repeat center;
	display: block;
	width: 23px;
	height: 23px;
	border: 1px solid #ffffff;
	text-decoration: none;
	position: absolute;
	right: 0;
	top: 4px;
}
.over_panel header a.close:hover{

}
@media all and (-webkit-min-device-pixel-ratio: 1.5) {
  .over_panel header a.close {
    background-image: url(/customer/responsive/images/bg_close@2x.png);
    background-size: 23px 23px;
  }
}

.over_panel .content{
	padding: 40px 0;
}
/*.over_panel .content .main_center{
	width: 620px;
}*/
/*.over_panel .content .header{
	display: block;
	font-size: 24px;
	margin-bottom: 25px;
}*/
/*---------------------------------------------------*/
a.back{
	font-size: 18px;
	color: #27ae60;
	font-weight: bold;
	display: inline-block;
	margin-top: 30px;
	border: 1px solid #27AE60;
	text-align: center;
	border-radius: 6px;
	padding: 15px 20px;
}
a.back:hover{
	color: #333333;
	border-color: #333333;
}

/*---------------------------------------------------*/
.border_panel{
	border: 1px solid #E4E4E4;
	padding: 30px;
	border-radius: 4px;
	 
}
/*---------------------------------------------------*/
.dataform .field {
	margin-bottom: 30px;
}
.dataform .label{
	font-size: 18px;
	font-weight: bold;
	display: block;
	margin-bottom: 13px;
}
.dataform .col{

}
.dataform input[type=text],
.dataform input[type=password]{
	height: 50px;
	line-height: 50px;
	padding: 0 2%;
	width: 96%;
	border: 2px solid #e4e4e4;
	margin: -2px;
	font-size: 24px;
	border-radius: 5px;
	-webkit-appearance: none;
	color: #27ae60;
}
.dataform .field.error input[type=text],
.dataform .field.error input[type=password]{
	border-color: #b90000;
}

.dataform select{
	padding: 8px;
	width: auto;
	border: 2px solid #e4e4e4;
	margin: -2px;
	font-size: 24px;
	border-radius: 5px;
	color: #333333;
	max-width:100%;
}
.dataform .field.error select{
	border-color: #b90000;
}

.dataform textarea{
	border: 2px solid #e4e4e4;
	line-height: 1.3;
	padding: 2%;
	width: 96%;
	height: 150px;
	border-radius: 5px;		
	font : 16px "Proxima Nova", Arial, Helvetica, sans-serif;
	-webkit-appearance: none;

}
.dataform .field.error textarea{
	border-color: #b90000;
}
.dataform label span{
	font-size: 18px;
	vertical-align: middle;
	overflow: hidden;
}
.dataform .field .msg{
	color: #b90000;
	display: block;
	margin-top: 8px;
	font-weight: bold;
	 
}
.dataform .field.error .msg{
	display: block;
}
.dataform .field .txt{
	font-size: 20px;
	margin-right: 10px;
}
.dataform .field input.phone1{
	width: 33px;
	margin-right: 5px;
}
.dataform .field input.phone2{
	width: 102px;
	margin-right: 5px;
}
.dataform .field input.phone3{
	width: 147px;
}

.dataform .info{
	display: block;
	font-size: 16px;
	margin-top: 8px;
}
.dataform .info2{
	display: block;
	font-size: 18px;
	line-height: 1.3;
	margin-top:7px;
}
.dataform .info2 a{
	color: #27ae60;
}
.dataform .btn_container{
	margin: 30px 0;
	text-align: left;
}
.dataform .btn_container .button1{
	min-width: 300px;
	padding: 0;
}

a {
	color: #27ae60;
  }

/*---------------------------------------------------*/
.login_panel{

}
.login_panel .over_panel .content p{
	font-size: 18px;
	line-height: 1.2;
	margin-bottom: 25px;
}
/*---------------------------------------------------*/
.pay_panel{
 
	
}
.pay_panel .over_panel .content p{
	font-size: 18px;
	line-height: 1.2;
	margin-bottom: 25px;
}
.pay_panel .items{
	text-align: center;
	font-size: 0;
}
.pay_panel .items .item{
	background: #f3f3f3;
	width: 220px;
	height: auto;
	display: inline-block;
	margin: 0 20px 20px 0;
	font-size: 18px;
	vertical-align: top;
	 -webkit-border-radius: 5px;
	-moz-border-radius: 5px;
		border-radius: 5px;
	
}
.pay_panel .items .item:nth-of-type(3n){
	margin-right: 0;
}
.pay_panel .items .item .header{
	background: #333333;
	color: white;
	font-size: 18px;
	font-weight: normal;
	display: block;
	height: 52px;
	line-height: 52px;
	text-align: center;
	 -webkit-border-top-left-radius: 5px;
	-webkit-border-top-right-radius: 5px;
	-moz-border-radius-topleft: 5px;
	-moz-border-radius-topright: 5px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}
.pay_panel .items .item .itemcontent{
	padding: 20px;
}
.pay_panel .items .item .limit{
	font-size: 34px;
	display: inline-block;
	width: 62px;
	height: 62px;
	line-height: 64px;
	text-align: center;
	border: 2px solid black;
	border-radius: 31px;
	margin-bottom: 8px;
	
}
.pay_panel .items .item .hour{	
	display: block;
	text-transform: uppercase;
	font-weight: bold;
	margin-bottom: 15px;
}
.pay_panel .items .item p{
	margin-bottom: 5px;
	min-height: 43px;
}
.pay_panel .items .item .price{
	font-weight: 600;
	text-transform: uppercase;
}
.pay_panel .items .item .button1{
	display: block;
	height: 45px;
	line-height: 45px;
	margin-top: 20px;
	border-radius: 5px;
}
.pay_panel .accept{
	text-align: center;
}
.pay_panel .accept p{
	font-weight: bold;
}
.pay_panel .accept img{
	border: 1px solid #E4E4E4;
	vertical-align: middle;
	margin: 0 5px 5px 0;
}
.pay_panel .currency_select{
	background-color: #F7F7F7;
	text-align: center;
	padding: 12px 0;
	margin: 25px 0 15px 0;
	font-size: 18px;
	font-weight: bold;
}
.pay_panel .currency_select select{
	margin-left: 10px;
}
/*---------------------------------------------------*/
.user_login{
	background: #F7F7F7;
	padding: 30px;
	width: 640px;
	margin: 0 auto 40px auto;
}
.user_login .header{
	font-size: 24px;
	display: block;
	margin-bottom: 25px;
}
.user_login .btn_container{
	margin-bottom: 0;
}
.user_login .btn_container a.forgot_password{
	font-size: 18px;
	font-weight: bold;
	color: #27ae60;
	margin: 0 0 0 30px;
}
/*---------------------------------------------------*/
.new_customer{
	
}
.new_customer .header{
	font-size: 24px;
	display: block;
	margin-bottom: 25px;
}
.new_customer .dataform select{
	width: 364px;
}
.new_customer p{
	font-size: 18px;
	line-height: 1.2;
	margin-bottom: 25px;
}
.new_customer .field_newsletter,
.new_customer .field_accept{
	overflow: hidden;  -webkit-border-radius: 4px; border-radius: 4px;
}

.field_accept_error{
	 padding:4px;
}

.new_customer .field_newsletter{
	margin-bottom: 15px;
}
.new_customer .field label input[type=checkbox]{
	float: left;
	display: block;
	margin-top: 3px;
	margin-right: 10px;
}
.new_customer .field label span{		
	display: block;
	line-height: 1.2;
}
.new_customer .btn_container{
	margin-bottom: 0;
}
.new_customer .dataitems{
	font-size: 18px;
	margin-bottom: 30px;
	line-height: 1.2;
}
.new_customer .dataitems .item{
	border-bottom: 1px solid #E4E4E4;
	padding: 15px 0;
	overflow: hidden;
}
.new_customer .dataitems .item .col1{
	float: left;
	font-weight: bold;
	width: 24%;
	padding-right: 1%;
}
.new_customer .dataitems .item .col2{
	float: left;
	width: 75%;
}

.new_customer .payment{
	text-align: center;
	overflow: hidden;
}
.new_customer .payment .header{
	font-size: 18px;
	margin-bottom: 30px;
}
.new_customer .payment img{
	border: 1px solid #E4E4E4;
	vertical-align: middle;
	margin: 0 5px 5px 0;
}
.new_customer .payment .col1{
	float: left;
	width: 43%;
}
.new_customer .payment .col0{
	 
	float: none;
	width: 60%;
}

.new_customer .payment .col2{
	float: right;
	width: 43%;
}
.new_customer .payment .button1{
	display: block;
	margin-top: 20px;
}
/*---------------------------------------------------*/
.customer_support{
	
}
.customer_support .header{
	font-size: 24px;
	display: block;
	margin-bottom: 25px;
}
.customer_support p{
	font-size: 18px;
	line-height: 1.2;
	margin-bottom: 25px;
}
.customer_support .border_panel{
	margin-top: 25px;
}
.customer_support .btn_container{
	margin-bottom: 0;
}
/*---------------------------------------------------*/
.login{
	
}
.login p{
	font-size: 18px;
	line-height: 1.2;
	margin-bottom: 25px;
}
.login p:last-child{
	margin-bottom: 0;
}
/*---------------------------------------------------*/
.voucher_panel{
	
}
.voucher_panel .header{
	font-size: 24px;
	display: block;
	margin-bottom: 25px;
}
/*---------------------------------------------------*/
.sms_panel{
	margin-top:-20px;margin-bottom:-40px;
}
.sms_panel .header{
	font-size: 24px;
	display: block;
	margin-bottom: 25px;
}
.sms_panel .dataform select{
	width: 364px;
	margin-bottom: 30px;
}
.sms_panel .progress{
	font-size: 18px;
	margin-bottom: 25px;
	line-height: 1.3;
}
.sms_panel .progress .loader{
	margin-bottom: 20px;
	width: 300px;
	text-align: center;
}
.sms_panel p{
	font-size: 18px;
	line-height: 1.2;
	margin-bottom: 25px;
}
.sms_panel p a{
	color: #27ae60;
}
.sms_panel p.info2{
	margin-bottom: 0;
}
/*---------------------------------------------------*/
.tooltip{
	background-color: black;
	width: 300px;
	display: block;
	padding: 10px;
	position: absolute;
	left: 20px;
	top: 20px;
	font-size: 12px;
	color: white;
	font-weight: normal;
	line-height: 1.3;
	z-index: 12;
	box-shadow:  1px 1px 5px 0 rgba(0, 0, 0, 0.59);
	display: none;
	border-radius: 5px;
}
.tooltip .pointer{
	background: url(/customer/responsive/images/tooltip_pointer.png) no-repeat;
	width: 12px;
	height: 7px;
	display: block;
	position: absolute;
	left: 50%;
	margin-left: -6px;
	bottom: -7px;
}
.tooltip .pointer.right{
	left: auto;
	right: 5px;
	margin-left: 0;
}
.tooltip .pointer.left{
	left: 5px;
	margin-left: 0;
}
/*---------------------------bala--------------------------- */
.hsubmit{
	position: absolute; left: -9999px; width: 1px; height: 1px;
	}
	
.topmain{
	margin-top:-10em;
	}

#socialbutton_container{
	margin-top:10px;margin-bottom:0px
	}
	
.autologin_error{
	margin-top:-40px;
	}

#guidelink {
	margin-top:40px; 
	}

.enable_popup {
	font-size:15px;
	}
	
.autologin_center {
	margin-bottom:20px;
	}

.fb-like-box{  
 
	float:none !important; 
	padding:0px !important; 
	margin:0px !important; 
	overflow:hidden !important;   
	border: 2px solid #ddd;
	-webkit-border-radius: 7px;
	border-radius: 7px;
	text-align:center !important;

	padding:10px !important;
	padding-bottom:20px !important; 
	 
	margin-right:0px !important;  
 	width:85% !important;
	display:block !important; 
	
 }
 
 .pagefbook { 
 overflow:hidden; 
 padding:0px;
 margin:0px;
 margin-left:-10px;
 margin-bottom:10px !important; ;

 }



.social_topright{
	margin-top:20px !important;
	margin-bottom:-60px !important;
}

a.back_prelogin{
	font-size: 18px;
	color: #27ae60;
	font-weight: bold;
	display: inline-block;
	margin-top: 30px;
	border: 1px solid #27AE60;
	text-align: center;
	border-radius: 6px;
	padding: 15px 20px;
}
a.back_prelogin:hover{
	color: #333333;
	border-color: #333333;
}

.over_panel header a.close_prelogin{
	background: url(/customer/responsive/images/bg_close.png) no-repeat center;
	display: block;
	width: 23px;
	height: 23px;
	border: 1px solid #ffffff;
	text-decoration: none;
	position: absolute;
	right: 0;
	top: 4px;
}
.over_panel header a.close_prelogin:hover{

}
@media all and (-webkit-min-device-pixel-ratio: 1.5) {
  .over_panel header a.close_prelogin {
    background-image: url(/customer/responsive/images/bg_close@2x.png);
    background-size: 23px 23px;
  }
}


  
