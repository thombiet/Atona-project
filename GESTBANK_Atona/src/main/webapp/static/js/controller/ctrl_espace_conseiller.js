/**
 * Le controleur qui gère toutes les pages de l'espace Conseiller
 */
function ConseillerController(uService, cService, $scope, $routeParams) {

	var self = this;

	//self.clients = [];
	//self.demandes = [];

	if (sessionStorage.role != "Conseiller") {
		$scope.mainCtrl.deconnexion();
	} else {
		getConseillerByMle(sessionStorage.idConnecte);
		getAllClientsByConseiller(sessionStorage.idConnecte)
		getDemandesByMle(sessionStorage.idConnecte);
		if ($routeParams.identifiant){
			getClientById($routeParams.identifiant);
		}
	}

	self.voirClient= function(id){
		$scope.mainCtrl.redirection('/Conseiller/Fiche_Client/'+id);
	}
	
	$scope.modifClient = modifClient;
	
	function getConseillerByMle(matricule) {
		uService.getConseillerByMle(matricule).then(function(value) {
			self.utilisateur = value;
		}, function(reason) {
			console.error('Error while fetching Conseiller: ' + reason);
		});
	}

	function getDemandesByMle(matricule) {
		uService.getDemandesByMle(matricule).then(function(value) {
			self.demandes = value;
		}, function(reason) {
			console.error('Error while fetching Demandes: ' + reason);
		});
	}

	function getAllClientsByConseiller(Mle) {
		uService.getAllClientsByConseiller(Mle).then(function(value) {
			self.clients = value;
		}, function(reason) {
			console.error('Error while fetching Clients: ' + reason);
		})
	}

	function getClientById(Id){
		uService.getClientById(Id).then(
			function(value) {
			$scope.client = value;
		}, function(reason) {
			console.log("Error: ConseillerController.getClientById - "+reason.status)
		})
	}
	
	function getCompteByClient(identifiant) {
		cService.getCompteByClient(identifiant).then(function(value) {
			self.comptes = value;
		}, function(reason) {
			console.error('Error while fetching comptes');
		});
	}

	function getCompteByNo(noCompte) {
		cService.getCompteByNo(noCompte).then(function(value) {
			self.compte = value;
		}, function(reason) {
			console.error('Error while fetching compte');
		});
	}

	function createCompte(compte) {
		cService.createCompte(compte).then(function(value) {

		}, function(reason) {
			console.error('Error while creating Compte');
		});
	}

	function updateCompte(compte, noCompte) {
		cService.updatecompte(compte, noCompte).then(function(value) {

		}, function(reason) {
			console.error('Error while updating Compte');
		});
	}

	function deleteCompte(noCompte) {
		cService.deleteCompte(noCompte).then(function(value) {
		}, function(reason) {
			console.error('Error while deleting Compte');
		});
	}
	
	function modifClient(){
		console.log($scope.client);
		uService.updateClient($scope.client).then(
			function(value) {
			console.log("success : ConseillerController.modifClient")
		}, function(reason) {
			console.log("fail : ConseillerController.modifClient")
			
		})
	}

}

App.controller("ConseillerController", ConseillerController)