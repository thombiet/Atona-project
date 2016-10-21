/**
 * Le controleur qui gère toutes les pages de l'espace Administrateur
 */
function AdministrateurController($scope, $routeParams, uService) {

	var self = this;

	self.conseillers;
	self.demandes;
	
	$scope.mainCtrl.user=null;

	$scope.conseiller = new ConseillerProto();

	self.createConseiller = createConseiller;
	self.getDemande = getDemande;
	
	$scope.modifConseiller = updateConseiller;
	self.affectDemandeConseiller = affectDemandeConseiller;

	if (sessionStorage.role != "Administrateur") {
		$scope.mainCtrl.deconnexion();
	} else {
		getAllConseillers();
		
		getAllDemandes();
		if ($routeParams.matricule) {
			getConseillerByMle($routeParams.matricule);
		}
		if ($routeParams.numDemande) {
			getDemande($routeParams.numDemande);
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
	
	function getDemande(numDemande){
		uService.getAllDemandes().then(function(d) {
			d.forEach(function(value, key) {
				if (value.numDemande == numDemande){
					$scope.demande = value;
				}
			})
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

	function createConseiller() {
		console.log("AdminCtrl.createConseiller()")
		$scope.conseiller.mdp = $scope.conseiller.pseudo;
		uService.createConseiller($scope.conseiller).then(function(value) {
			$scope.mainCtrl.redirection('/Admin/GestionConseillers')
		}, function(errResponse) {
			console.error('Error while creating Conseiller');
		});
	}

	function updateConseiller() {
		console.log("AdminCtrl.updateConseiller()")
		var Mle = $scope.conseiller.matricule;
		uService.updateConseiller($scope.conseiller, Mle).then(function(value) {
			$scope.mainCtrl.redirection('/Admin/GestionConseillers')
		}, function(errResponse) {
			console.error('Error while updating Conseiller');
		});
	}

	function deleteConseiller(Mle) {
		uService.deleteConseiller(Mle).then(fetchAllConseillers,
				function(errResponse) {
					console.error('Error while deleting Conseiller');
				});
	}

	function affectDemandeConseiller(matricule) {
		$scope.demande.dateAffectation = new Date();
		uService.affectationDemande($scope.demande, matricule).then(
			function(value) {
			alert("la demande a été affectée");
			$scope.mainCtrl.redirection('/Admin/GestionDemandes');
		}, function(reason) {
			console.log("erreur : AdminCtrl.affectDemandeConseiller() :");
			console.log(reason);
		})
	}

	// --------------------------------------------Proto-----------
	function ConseillerProto(matricule, nom, prenom, pseudo, mdp, email,
			adresse, codePostal, ville, telephone, dateNaissance) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
	}

}

App.controller("AdministrateurController", AdministrateurController)
