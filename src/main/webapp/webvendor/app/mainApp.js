var mainApp = angular.module('mainApp', [ 'ngRoute' ]);

mainApp.controller('MainCtrl', [
		'$scope',
		'$http',
		'$timeout',
		function($scope, $http, $timeout) {

			var timer;
			$scope.allOrders={};

			function fetchAllOrders() {
				// When the timeout is defined, it returns a
				// promise object.
				var data = {
					"fetchOrder" : {
						"orderStates" : [ "BIG_ORDER_PAY", "BIG_ORDER_CALL",
								"DEFAULTER_CALL", "OK_ORDER", "PREPARING",
								"READY_FOR_PICKUP" ],
						"shopId" : 6,
						"success" : false
					}
				};
				var config = {
					headers : {
						'Content-Type' : 'application/json;'
					}
				};

				timer = $timeout(function() {
					//console.log("Timeout executed", Date.now());
				}, 3000);

				timer.then(function() {
					//console.log("Timer resolved!");

					$http.post("/rest/fetchOrders", data, config).then(
							function(response) {
								console.log(response);
								$scope.allOrders=response
								fetchAllOrders();
							}, function(response) {
								console.log("failed response");
								fetchAllOrders();
							})
				});
			}
			fetchAllOrders();
			
			$scope.fetchAllOrdersWithoutInterval=function() {
				// When the timeout is defined, it returns a
				// promise object.
				var data = {
					"fetchOrder" : {
						"orderStates" : [ "BIG_ORDER_PAY", "BIG_ORDER_CALL",
								"DEFAULTER_CALL", "OK_ORDER", "PREPARING",
								"READY_FOR_PICKUP" ],
						"shopId" : 6,
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
								$scope.allOrders=response;
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
							//console.log(response);
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
							//console.log(response);
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
							//console.log(response);
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
							//console.log(response);
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
							//console.log(response);
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
							//console.log(response);
							$scope.fetchAllOrdersWithoutInterval();
						}, function(response) {
							console.log("failed to cancel");
						})
			}

		} ]);