/**
 * Le controleur qui gère toutes les pages de l'espace Public
 */
function PublicController($http, $scope) {

	$scope.init = function(){
		if(sessionStorage.idConnecte!==null){
			sessionStorage.idConnecte=null;
			sessionStorage.role="Guest";
		}
	}
	
	$scope.devises = [ "AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK", "DKK",
			"EUR", "GBP", "HKD", "HRK", "HUF", "IDR", "ILS", "INR", "JPY",
			"KRW", "MXN", "MYR", "NOK", "NZD", "PHP", "PLN", "RON", "RUB",
			"SEK", "SGD", "THB", "TRY", "USD", "ZAR" ];

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

	$scope.redirection = $scope.mainCtrl.redirection;

	$scope.connexion = function() {
		$http.get(CONNEXION_URI, {
			params : {
				'pseudo' : $scope.pseudo,
				'mdp' : $scope.mdp
			}
		}).then(function(response) {
			var resp = response.data;
			if (resp.startsWith("Client")) {
				// c'est un client
				var id = resp.slice("Client".length);
				sessionStorage.role = "Client";
				sessionStorage.idConnecte = id;
				$scope.redirection('/Client');
			} else if (resp.startsWith("Conseiller")) {
				// c'est un conseiller
				var id = resp.slice("Conseiller".length);
				sessionStorage.role = "Conseiller";
				sessionStorage.idConnecte = id;
				$scope.redirection('/Conseiller');
			} else {// c'est l'admistrateur
				
				sessionStorage.role = "Administrateur";
				$scope.redirection('/Admin');
			}
		}, function(reason) {
			console.log("error : "+reason)
		})
	}

}

App.controller("PublicController", PublicController);