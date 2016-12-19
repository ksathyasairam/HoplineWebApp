

//--------------------- fullbg lowres to hightres background switcher (when highres loaded) ---------

  var bgimage=$('html').css("background-image"); 
  bgimage=bgimage.replace (".jpg", "_t.jpg");
  $("html").attr('style', 'background-image: '+ bgimage+ ' !important');
  
   

$(window).load(function() {
	
   var bgimage=$('html').css("background-image"); 
   bgimage=bgimage.replace ("_t.jpg", ".jpg");
   $("html").attr('style', 'background-image: '+ bgimage + ' !important');

	});


//--------------------------------------------------


ua = navigator.userAgent.toLowerCase(); 
isIE = ((ua.indexOf("msie") != -1) );
isIE6 = ((ua.indexOf("msie 6.0") != -1) ); 
isIE7 = ((ua.indexOf("msie 7.0") != -1) );
isOPERA = ((ua.indexOf("opera") != -1) );
isFF = ((ua.indexOf("firefox") != -1) );
isSafari = ((ua.indexOf("safari") != -1) );

var obj_panel_handler;

$(document).ready(function(){

obj_panel_handler =new init_over_panel();

init_langselect();
init_submit_links();

});

//-----------------------------------------------
function debug(txt)
{
try {
	console.debug(txt);
	}
catch(e){}
}
//-----------------------------------------------
function init_langselect()
{
var mainelement2=$('#bottom .langselect');	

$(mainelement2).find('ul:first').on('touchstart mousedown', function(event)
	{
	event.stopPropagation();
	event.preventDefault();
	if(event.handled !== true) 
		{
		$(mainelement2).toggleClass('opened'); 
		event.handled = true;
		}
	else 
		{
		return false;
		}
	});


//END; 
}
//-----------------------------------------------
function init_over_panel()
{
var main_panels=$('#main_panels');		
var hide_items=$('#top, #bottom');
var duration=500;

//menu click
$(main_panels).find('.panel_item:has(.over_panel) a.openbutton').on('click', function(event)
	{
	event.preventDefault();	
	var target=$(this).parents('.panel_item').find('.over_panel');		
	open(target, duration);	
	});
	
//close button click
$('.over_panel a.close, .over_panel a.back').on('click', function(event)
	{
	event.preventDefault();		
	var target=$(this).parents('.panel_item').find('.over_panel');			
	close(target, duration);	
	});
	
	
$('.over_panel').each(function(index) 
	{
	var panel_height=$(this).height();	
  	$(this).css('top', (-1*panel_height)+'px');
  	$(this).css('display', 'none');
	});
 
	

if( $(main_panels).find('.panel_item.open').length>0 )
	{
	open( $(main_panels).find('.panel_item.open:first .over_panel') );	
	}
	
//open selected panel
function open(target, drt)
	{
	if( typeof(drt)=='undefined' ) drt=0;
	var panel_height=$(target).height();		
	$('body,html').animate({ scrollTop: 0 }, drt);	
	$(target).css('display', 'block');
	$(target).css('top', (-1*panel_height)+'px');	
	$(target).velocity({top : '0px' }, drt, 'easeInOutCirc', function() { $(hide_items).css('display', 'none');  });
	//$(hide_items).animate({opacity : 'hide' }, drt, 'easeInOutCirc');	
	//$(hide_items).css('display', 'none'); 
	}
this.open=open;


	
//close panels
function close(target, drt)
	{
	if( typeof(drt)=='undefined' ) drt=0;	
	var panel_height=$(target).height();		
	$(target).velocity({top : (-1*panel_height)+'px' }, drt, 'easeInOutCirc', function() { $(this).css('display', 'none');  } );
	$(hide_items).css('display', 'block');
	//$(hide_items).animate({opacity : 'show' }, drt, 'swing');
	//$('body,html').animate({ scrollTop: $('#center').offset().top }, drt);
	$('body,html').animate({ scrollTop: 0 }, 0);
	}	
this.close=close;	

//END; 
}
//-----------------------------------------------
function init_submit_links()
{
$('form a.submit').on('click', function(event)
	{
	event.preventDefault();	
	$(this).parents('form').submit();
	});

//END; 
}
//-----------------------------------------------
function init_tooltip(selector, options)
{
if(isIE6) return;
	
if( $('#tooltipbox').length==0 ) $('body').append('<div id="tooltipbox" class="tooltip"><div class="content"></div><div class="pointer"></div></div>');
			
var defaults={
	moveleft : 0,
	movetop : 0,
	min_page_width : 0
}

var opts = $.extend({}, defaults, options);
			
var mainelement=$(selector);
var box=$('#tooltipbox');
var timeout;

$(mainelement).each(function()
	{
	$(this).data('title', $(this).attr('title') );
	$(this).removeAttr('title');	
	});
	
$(mainelement).on('mouseenter', function(event)
	{
	$(box).find('.pointer').removeClass('left').removeClass('right');
	var title=$(this).data('title');
		
	if(!title) return;
	
	title=title.replace(/\[br\]/gi, '<br/>');
		
	$(box).find('.content').html(title);
		
	var offset=$(this).offset();	
	var width=$(this).outerWidth();
	var height=$(this).outerHeight();
		
	var doc_width=$(window).width();
	
	if( opts.min_page_width>doc_width) return;
	
	var boxwidth=$(box).outerWidth();
	var boxheight=$(box).outerHeight();
				
	var left_position=offset.left-((boxwidth-width)/2)+opts.moveleft;
	var top_position=offset.top+height/2-boxheight/2+opts.movetop;		
	
	
	if( left_position + boxwidth + 10 > doc_width )
		{
		left_position-=left_position + boxwidth + 10 - doc_width ;	
		$(box).find('.pointer').addClass('right');
		}
		
	if( left_position - 10 < 0 )
		{
		left_position=10;	
		$(box).find('.pointer').addClass('left');
		}
					
	clearTimeout(timeout);
	$(box).css('left', left_position+'px').css('top', top_position+'px').css('display', 'block');
	});
	
$(mainelement).on('mouseleave', function(event)
	{
	timeout=setTimeout( function(){ $(box).css('display', 'none'); }, 500 );
	
	});	
	
}

//--------- social responsivehez  ---------------

function openskip(target, drt)
	{
 
	 var main_panels=$('#main_panels');		
	var hide_items=$('#top, #bottom');

	if( typeof(drt)=='undefined' ) drt=500;
	var panel_height=$('#'+target).height();	 
	$('body,html').animate({ scrollTop: 0 }, drt);	
	$('#'+target).css('display', 'block');
	$('#'+target).css('top', (-1*panel_height)+'px');	
	$('#'+target).velocity({top : '0px' }, drt, 'easeInOutCirc', function() { $(hide_items).css('display', 'none');  });
	}
	this.open=open;
	
//close panels
function closeskip(target, drt)
	{
		var main_panels=$('#main_panels');		
		var hide_items=$('#top, #bottom');
	 
	if( typeof(drt)=='undefined' ) drt=500;	
	var panel_height=$('#'+target).height();		
	$('#'+target).velocity({top : (-1*panel_height)+'px' }, drt, 'easeInOutCirc', function() { $(this).css('display', 'none');  } );
	$('#'+target).css('display', 'block');
	$('body,html').animate({ scrollTop: 0 }, 0);

	}	
	this.close=close;	
	
	