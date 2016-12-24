
angular.module('mainApp', ['eventModule','ngRoute','ui.router'])
.config(['$urlRouterProvider','$stateProvider',
  function($urlRouterProvider,$stateProvider) {

    $stateProvider
	    //.state("restaurant", {
	
	        // Use a url of "/" to set a states as the "index".
	       // url: "/restaurant",
	        //templateUrl: 'restaurant.html'
	
	      //})
    	.state("home", {

        // Use a url of "/" to set a states as the "index".
        url: "/home",
        templateUrl: 'home.html'

        })               
        .state("cart", {

          // Use a url of "/" to set a states as the "index".
          url: "/cart",
          templateUrl: 'cart.html'

        })
        .state("login", {

          // Use a url of "/" to set a states as the "index".
          url: "/login",
          templateUrl: 'login.html'

        })
        .state("otp", {

          // Use a url of "/" to set a states as the "index".
          url: "/otp",
          templateUrl: 'otp.html'

        })
        .state("order", {

          // Use a url of "/" to set a states as the "index".
          url: "/order",
          templateUrl: 'order.html'

        })
        .state("tracker", {

          // Use a url of "/" to set a states as the "index".
          url: "/tracker",
          templateUrl: 'tracker.html'

        })


        $urlRouterProvider.when('', '/home');
   
  }])
.run([function () {

	console.log("Run hook");
}])