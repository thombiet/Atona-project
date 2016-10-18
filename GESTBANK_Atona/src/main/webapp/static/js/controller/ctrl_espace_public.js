/**
 * Le controleur qui gère toutes les pages de l'espace Public
 */
function PublicController($http, $scope, uService) {

	var self = this;
	self.client = new ClientPotentiel();
	
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
			}).then(
			function(response) {
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
	
	self.creationClient = function (){
		console.log(self.client);
		var demande={
			numDemande: null,
			cp:self.client,
			valide: null,
			dateCreation:null,
			dateAffectation : null,
		}
		uService.createDemande(demande).then(
			function(value) {
			
		}, function(reason) {
			
		})
	}
	
	function ClientPotentiel(identifiant, adresse, codePostal, dateNaissance, email, nom, prenom, revenuMens, telephone, ville){
		this.identifiant = identifiant;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.revenuMens = revenuMens;
		this.telephone = telephone;
		this.ville = ville;
	}

}

App.controller("PublicController", PublicController);