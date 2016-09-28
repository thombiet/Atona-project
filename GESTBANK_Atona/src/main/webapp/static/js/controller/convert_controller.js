'use strict';

angular.module('myApp').controller('convertCtrl', ['$scope', 'UserService', function($scope, UserService) {
	 var REST_SERVICE_URI = 'http://api.fixer.io/latest?';
	    $scope.devises = ["AUD","BGN","BRL","CAD","CHF","CNY","CZK","DKK","EUR","GBP","HKD",
		                  "HRK","HUF","IDR","ILS","INR","JPY","KRW","MXN","MYR","NOK","NZD",
		                  "PHP","PLN","RON","RUB","SEK","SGD","THB","TRY","USD","ZAR"];
		
		$scope.montant;
		$scope.base;
		$scope.symbols;
		$scope.rate;
		$scope.change;
		
		$scope.conversion = function(){
			
			if($scope.base==$scope.symbols){
				$scope.change=$scope.montant;
			}
			else
			{
				$http.get("http://api.fixer.io/latest", {params:{base:$scope.base, symbols:$scope.symbols}})
				.then(
						function (response){
							$scope.rate=response.data.rates[$scope.symbols];
							$scope.change=$scope.montant*$scope.rate;
						}
						,
						function (error){
							console.log("error "+error)
						}		
				)
			}
		}
}]);
