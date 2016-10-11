'use strict';

App.controller('convertCtrl', ['$scope', '$location', '$http', function($scope, $location, $http) {
	
	$scope.devises = [ "AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK",
	   				"DKK", "EUR", "GBP", "HKD", "HRK", "HUF", "IDR", "ILS", "INR",
	   				"JPY", "KRW", "MXN", "MYR", "NOK", "NZD", "PHP", "PLN", "RON",
	   				"RUB", "SEK", "SGD", "THB", "TRY", "USD", "ZAR" ];

	   		$scope.conversion = function() {

	   			if ($scope.base == $scope.symbols) {
	   				$scope.change = $scope.montant;
	   			} else {
	   				$http.get("http://api.fixer.io/latest", {
	   					params : {
	   						base : $scope.base,
	   						symbols : $scope.symbols
	   					}
	   				}).then(function(response) {
	   					$scope.rate = response.data.rates[$scope.symbols];
	   					$scope.change = $scope.montant * $scope.rate;
	   				}, function(error) {
	   					console.log("error " + error)
	   				})
	   			}
	   		}
	   		
	   		var CONNEXION_URI = "http://localhost:8080/SpringAngularStartProject/connexion/";
	   		
	   		$scope.redirection = function(path) {
				$location.path(path);
			}

			$scope.connexion = function() {
				$http.get(CONNEXION_URI, {
					params : {
						'pseudo' : $scope.pseudo,
						'mdp' : $scope.mdp
					}
				}).then(
						function(response) {
							var resp = response.data;
							if (resp.startsWith("Client")) {
								//c'est un client
								var id = resp.slice("Client".length)
								console.log(id);
								sessionStorage.role = "Client";
								sessionStorage.idConnecte = id;
								$scope.redirection('/Client');
							} else if (resp.startsWith("Conseiller")) {
								//c'est un conseiller
								var id = resp.slice("Conseiller".length)
								console.log(id)
								sessionStorage.role = "Conseiller";
								sessionStorage.idConnecte = id;
								$scope.redirection('/Conseiller');
							} else {
								//c'est l'admistrateur
								sessionStorage.role = "Administrateur", $scope
										.redirection('/Admin');
							}
						}, function(error) {
							console.log("error")
							console.log(error)
						})
			}

}]);

