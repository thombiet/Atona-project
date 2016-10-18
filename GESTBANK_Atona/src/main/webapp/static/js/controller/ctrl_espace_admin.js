/**
 * Le controleur qui gère toutes les pages de l'espace Administrateur
 */
function AdministrateurController($scope, $routeParams, uService) {

	var self = this;
	
	self.conseillers=[];
	self.demandes=[];
	
	if (sessionStorage.role!="Administrateur"){
		$scope.mainCtrl.deconnexion();
	}
	else {
		getAllConseillers();
		getAllDemandes();
		if ($routeParams.matricule){
			getConseillerByMle($routeParams.matricule);
		}
	}
	
	
	function getAllConseillers() {
		uService.getAllConseillers().then(function(d) {
			self.conseillers = d;
		}, function(errResponse) {
			console.error('Error while fetching Conseillers');
		});
	}

	function getAllDemandes() {
		uService.getAllDemandes().then(function(d) {
			self.demandes = d;
		}, function(errResponse) {
			console.error('Error while fetching Demandes');
		});
	}

	function getConseillerByMle(Mle) {
		uService.getConseillerByMle(Mle).then(function(d) {
			$scope.conseiller = d;
		}, function(errResponse) {
			console.error('Error while fetching Conseiller');
		});
	}

	function createConseiller(conseiller) {
		uService.createConseiller(conseiller).then(fetchAllConseillers,
				function(errResponse) {
					console.error('Error while creating Conseiller');
				});
	}

	function updateConseiller(conseiller, Mle) {
		uService.updateConseiller(Conseiller, Mle).then(
				fetchAllConseillers, function(errResponse) {
					console.error('Error while updating Conseiller');
				});
	}

	function deleteConseiller(Mle) {
		uService.deleteConseiller(Mle).then(fetchAllConseillers,
				function(errResponse) {
					console.error('Error while deleting Conseiller');
				});
	}

	function affectation() {
	}

}

App.controller("AdministrateurController", AdministrateurController)
