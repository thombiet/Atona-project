/**
 * Le controleur qui gère toutes les pages de l'espace Conseiller
 */
function ConseillerController(uService, cService, $scope, $routeParams, $route) {

	var self = this;
	self.validationDemande = validationDemande;
	self.toggle = toggle;
	self.modifDecouvert=modifCompte;
	self.modifRemuneration=modifCompte;

	if (sessionStorage.role != "Conseiller") {
		$scope.mainCtrl.deconnexion();
	} else {
		getConseillerByMle(sessionStorage.idConnecte);
		getAllClientsByConseiller(sessionStorage.idConnecte)
		getDemandesByMle(sessionStorage.idConnecte);
		findRequeteByConseiller(sessionStorage.idConnecte);
		validationRequete();
		$scope.mainCtrl.nbMess = 0;
		if ($routeParams.identifiant) {
			getClientById($routeParams.identifiant);
		}
		if ($routeParams.noCompte) {
			getCompteByNo($routeParams.noCompte);
			getTransactionsByCompte($routeParams.noCompte);
		}
	}

	self.voirClient = function(id) {
		$scope.mainCtrl.redirection('/Conseiller/Fiche_Client/' + id);
	}

	$scope.modifClient = modifClient;

	function getConseillerByMle(matricule) {
		uService.getConseillerByMle(matricule).then(function(value) {
			$scope.conseiller = value;
			$scope.mainCtrl.user = value;
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
			//console.log(value)
		}, function(reason) {
			console.error('Error while fetching Clients: ' + reason);
		})
	}

	function getClientById(Id) {
		uService.getClientById(Id).then(
				function(value) {
					$scope.client = value;
				},
				function(reason) {
					console.log("Error: ConseillerController.getClientById - "
							+ reason.status)
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
			uService.getClientByCompte(noCompte).then(
				function(value) {
					self.maxDecouvert=value.revenuMensuel*0.40;
			}, function(reason) {
				
			})
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

	function modifClient() {
		console.log($scope.client);
		uService.updateClient($scope.client).then(function(value) {
			console.log("success : ConseillerController.modifClient")
		}, function(reason) {
			console.log("fail : ConseillerController.modifClient")

		})
	}
	
	function validationDemande(demande){
		console.log(demande);
		uService.validationDemande(demande).then(
			function(value) {
			alert("la demande a été validée");
			$route.reload();
		}, function(reason) {
			console.log("erreur ConsCtrl.validationDemande() :");
			console.log(reason);
		})
	}
	
	function getTransactionsByCompte(noCompte){
		cService.getTransactionsByCompte(noCompte).then(
			function(value) {
			self.transactions = value;
			console.log(value);
		}, function(reason) {
			
		})
	}
	
	function toggle(){
		console.log("ConsCtrl.toggle()")
		self.option = !self.option
	}
	
	function modifCompte(){
		cService.updateCompte(self.compte, self.compte.noCompte).then(
			function(value) {
				$route.reload();
		}, function(reason) {
			console.log("erreur : ConsCtrl.modifDecouvert()")
		})
	}
	
	function findRequeteByConseiller(matricule) {
		uService.findRequeteByConseiller(matricule).then(function(value) {
			self.requetes = value;
		}, function(reason) {
			console.error('Error while fetching Demandes: ' + reason);
		});
	}
	
	function validationRequete(requete){
		console.log(requete);
		uService.validationRequete(requete).then(
			function(value) {
			alert("la requete a été validée");
			//$route.reload();
		}, function(reason) {
			console.log("erreur ConsCtrl.validationRequete() :");
			console.log(reason);
		})
	}

}

App.controller("ConseillerController", ConseillerController)