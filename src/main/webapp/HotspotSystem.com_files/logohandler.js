function logohandler (headerlogo)
{
 
if ( headerlogo.indexOf("customer_images/customer-logo") < 0 )
  {

  document.getElementById('hlogo').style.backgroundImage = "url('" + headerlogo + "')";
   
  var img = new Image();
  img.src = headerlogo; 
  
  img.onload = function() 
   {
 
   document.getElementById('hlogo').style.width = img.width + "px";
   width = document.getElementById("hlogo").clientWidth; 
  
	document.getElementById('hlogo').style.height = img.height * (width/img.width) + "px";
    document.getElementById('hlogo').style.backgroundSize="100%";
	//  document.getElementById('hlogo').style.backgroundColor="red";
	 document.getElementById('hlogo').style.paddingBottom = '0';
	  
	  
    }

   } 
   
 $(document).ready(function() {

$(window).on("resize",function() {
	
	if ( headerlogo.indexOf("customer_images/customer-logo") < 0 )
	{
		 
		 width = document.getElementById("hlogo").clientWidth;
		$("#hlogo").css("height", img.height * (width/img.width) + "px");
	 
	}

  });

});

}