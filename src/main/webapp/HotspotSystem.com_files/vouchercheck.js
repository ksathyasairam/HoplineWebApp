 
   response="";
	 
// Check availability from user database

function vouchercheck(operator, code) {


 
	if (window.XMLHttpRequest) {
	
		http = new XMLHttpRequest();
	
	} else if (window.ActiveXObject) {
	
		http = new ActiveXObject("Microsoft.XMLHTTP");
	
	}
	
	
	handle = $.trim(code);
	
	 
	
	var url = '/customer/checkvoucher.php?'; 
	
	 
	 

		// Timestamp for preventing IE caching the GET request
				
		fetch_unix_timestamp = function()
		
			{
			
			return parseInt(new Date().getTime().toString().substring(0, 10))
			
			}
		
		var timestamp = fetch_unix_timestamp();
		
		var fullurl = url + 'operator=' + operator + '&value=' + encodeURIComponent(handle);
		
		 
		
		http.open("GET", fullurl, true);
		
		 
		 
		http.send(null);
		
	 
		
	 http.onreadystatechange = function() { 
	  
	 statechange_field('code');
 
	
	  };
	

 

}


// Show availability

function statechange_field(divid) {

	if (http.readyState == 4) {
	
		response= http.responseText;
		
	
		 
		if (response== '1') {
			
		 document.getElementById("prepaidform").submit();
			
		}  
		
		else if (response== '2') 
		{
			     document.getElementById('prepaiderror').innerHTML= prepaiderr_2 ;
			    document.getElementById('code').className = "responsive_error";
				$('html, body').animate({scrollTop: ($('.responsive_error').first().offset().top-50)},500);	
		 }
	 
	 
		else if (response== '3')
		{
			   document.getElementById('prepaiderror').innerHTML= prepaiderr_3 ;
			    document.getElementById('code').className = "responsive_error";
				$('html, body').animate({scrollTop: ($('.responsive_error').first().offset().top-50)},500);	
			}
			
		else  
		{
			 document.getElementById("prepaidform").submit();
			}	
	 
	}
	 
}
 
 
 
 

  