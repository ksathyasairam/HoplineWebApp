var mainApp = angular.module('mainApp', [ 'angular-web-notification' ]);

mainApp.controller('MainCtrl', [
		'$scope',
		'$http',
		'$timeout',
		'webNotification',
		function($scope, $http, $timeout, webNotification) {

			var timer;
			$scope.allOrders = null;
			
			$scope.notify=function(){
			
			webNotification.showNotification('Hopline Notification', {
				  body: 'You have new orders!!',
				  icon: 'img/hoplogo.png',
				  onClick: function onNotificationClicked() {
				    console.log('Notification clicked.');
				  },
				  //autoClose: 4000 //auto close the notification after 4 seconds (you can manually close it via hide function)
				}, function onShow(error, hide) {
				  if (error) {
				    window.alert('Unable to show notification: ' + error.message);
				  } else {
				    console.log('Notification Shown.');
				  }
				});
			
			}

			function fetchAllOrders() {
				// When the timeout is defined, it returns a
				// promise object.
				var data = {
					"fetchOrder" : {
						"orderStates" : [ "BIG_ORDER_PAY", "BIG_ORDER_CALL",
								"DEFAULTER_CALL", "OK_ORDER", "PREPARING",
								"READY_FOR_PICKUP" ],
						"shopId" : localStorage.getItem('shopId'),
						"success" : false
					}
				};
				var config = {
					headers : {
						'Content-Type' : 'application/json;'
					}
				};
				timer = $timeout(function() {
					// console.log("Timeout executed", Date.now());
				}, 3000);

				timer.then(function() {
					// console.log("Timer resolved!");

					$http.post("/rest/fetchOrdersWeb", data, config).then(
							function(response) {
								//console.log(response);
								var count=0;
								if($scope.allOrders!=null){
								for(var i=0;i<response.data.orders.length;i++){
									for(var j=0;j<$scope.allOrders.data.orders.length;j++){
										if(response.data.orders[i].idorder==$scope.allOrders.data.orders[j].idorder){
											count=count+1;
										}
									}									
								}
								if(count<response.data.orders.length){
									$scope.notify();
									
								}
								else if(count==response.data.orders.length){
									console.log(count);
								}
								else if(count>response.data.orders.length){
									console.log(count);
								}
								count=0;
								}
								$scope.allOrders = response
								fetchAllOrders();
							}, function(response) {
								console.log("failed response");
								fetchAllOrders();
							})
				});
			}
			fetchAllOrders();

			$scope.fetchAllOrdersWithoutInterval = function() {
				// When the timeout is defined, it returns a
				// promise object.
				var data = {
					"fetchOrder" : {
						"orderStates" : [ "BIG_ORDER_PAY", "BIG_ORDER_CALL",
								"DEFAULTER_CALL", "OK_ORDER", "PREPARING",
								"READY_FOR_PICKUP" ],
						"shopId" : localStorage.getItem('shopId'),
						"success" : false
					}
				};
				var config = {
					headers : {
						'Content-Type' : 'application/json;'
					}
				};
				$http.post("/rest/fetchOrders", data, config).then(
						function(response) {
							$scope.allOrders = response;
						}, function(response) {
							console.log("failed response");
						})
			}

			$scope.cancelOrder = function(orderId) {

				var data = {
					"orderStatus" : {
						"cancelReason" : "sdf",
						"orderId" : orderId,
						"orderStatus" : "CANCELLED",
						"success" : false,
						"updateOrderTime" : false
					}
				}
				var config = {
					headers : {
						'Content-Type' : 'application/json;'
					}
				};

				$http.post("/rest/udpateOrderStatus", data, config).then(
						function(response) {
							// console.log(response);
							$scope.fetchAllOrdersWithoutInterval();
						}, function(response) {
							console.log("failed to cancel");
						})
			}

			$scope.markPreparing = function(orderId) {

				var data = {
					"orderStatus" : {
						"orderCompletionTime" : 10,
						"orderId" : orderId,
						"orderStatus" : "PREPARING",
						"success" : false,
						"updateOrderTime" : false
					}
				}
				var config = {
					headers : {
						'Content-Type' : 'application/json;'
					}
				};

				$http.post("/rest/udpateOrderStatus", data, config).then(
						function(response) {
							// console.log(response);
							$scope.fetchAllOrdersWithoutInterval();
						}, function(response) {
							console.log("failed to cancel");
						})
			}

			$scope.readyForPickup = function(orderId) {

				var data = {
					"orderStatus" : {
						"orderId" : orderId,
						"orderStatus" : "READY_FOR_PICKUP",
						"success" : false,
						"updateOrderTime" : false
					}
				}
				var config = {
					headers : {
						'Content-Type' : 'application/json;'
					}
				};

				$http.post("/rest/udpateOrderStatus", data, config).then(
						function(response) {
							// console.log(response);
							$scope.fetchAllOrdersWithoutInterval();
						}, function(response) {
							console.log("failed to cancel");
						})
			}

			$scope.markCompleted = function(orderId) {

				var data = {
					"orderStatus" : {
						"orderId" : orderId,
						"orderStatus" : "COMPLETED",
						"paidYN" : "Y",
						"success" : false,
						"updateOrderTime" : false
					}
				}
				var config = {
					headers : {
						'Content-Type' : 'application/json;'
					}
				};

				$http.post("/rest/udpateOrderStatus", data, config).then(
						function(response) {
							// console.log(response);
							$scope.fetchAllOrdersWithoutInterval();
						}, function(response) {
							console.log("failed to cancel");
						})
			}

			$scope.markUnpicked = function(orderId) {

				var data = {
					"orderStatus" : {
						"orderId" : orderId,
						"orderStatus" : "UNPICKED",
						"success" : false,
						"updateOrderTime" : false
					}
				}
				var config = {
					headers : {
						'Content-Type' : 'application/json;'
					}
				};

				$http.post("/rest/udpateOrderStatus", data, config).then(
						function(response) {
							// console.log(response);
							$scope.fetchAllOrdersWithoutInterval();
						}, function(response) {
							console.log("failed to cancel");
						})
			}

			$scope.notifyUserPartialOrder = function(orderId) {

				var data = {
					"orderStatus" : {
						"action" : "notifyUserPartialOrder",
						"orderId" : orderId,
						"success" : false,
						"updateOrderTime" : false
					}
				}
				var config = {
					headers : {
						'Content-Type' : 'application/json;'
					}
				};

				$http.post("/rest/udpateOrderStatus", data, config).then(
						function(response) {
							// console.log(response);
							$scope.fetchAllOrdersWithoutInterval();
						}, function(response) {
							console.log("failed to cancel");
						})
			}

			$scope.login = function(username, password) {
				console.log(username, password)
				var data = {
					"shop" : {
						"username" : username,
						"password" : password
					}
				}
				var config = {
					headers : {
						'Content-Type' : 'application/json;'
					}
				};

				$http.post("/rest/vendorLogin", data, config).then(
						function(response) {
							//console.log(response);
							localStorage.setItem('shopId',response.data.idshop);
							window.location = '/webvendor/index.html';
						}, function(response) {
							console.log("failed to cancel");
						})
			}

		} ]);
