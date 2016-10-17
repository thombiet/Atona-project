/**
 * Le controleur qui gère toutes les pages de l'espace Client
 */
function ClientController(uService, cService,  $scope, $routeParams) {

	if (sessionStorage.role!="Client"){
		$scope.mainCtrl.deconnexion();
	}
	else {
		var self = this;
		getCompteByClient(sessionStorage.idConnecte);
		getClientById(sessionStorage.idConnecte);
		if (sessionStorage.noCompte){
			getCompteByNo(sessionStorage.noCompte);
			getTransactions(sessionStorage.noCompte);
		}
	}
	
	$scope.voirCompte = voirCompte;
	
	function getClientById(Id){
		uService.getClientById(Id).then(
			function(value) {
			$scope.client = value;
		}, function(reason) {
			console.log("Error: ConseillerController.getClientById - "+reason.status)
		})
	}
	
	function voirCompte(noCompte){
		sessionStorage.noCompte = noCompte;
		$scope.mainCtrl.redirection('/GestionCompte')
	}
	
	function getCompteByClient(identifiant){
    	cService.getCompteByClient(identifiant)
            .then(
            function(d) {
                self.comptes = d;
            },
            function(errResponse){
                console.error('Error while fetching comptes');
            }
        );
    }
	
	function getCompteByNo(noCompte) {
    	cService.getCompteByNo(noCompte)
    		.then(
            function(d){
            	self.compte= d;
            },
            function(errResponse){
                console.error('Error while fetching compte');
            }
        );
    }
	
	function getTransactions(noCompte){
		var month = new Date().getMonth() +1;
		cService.getTransactionsByCompteAndMonth(noCompte, month).then(
			function(value) {
				var tmp = value[1];
				tmp.forEach(function(value, key) {
					value.montant=-value.montant;
				})
				self.transactions= tmp.concat(value[0]);
				console.log(value)
				console.log(self.transactions);
		}, function(reason) {
				console.log("ClientController : getTransactions, erreur "+reason.status)
		})
	}

}

App.controller("ClientController", ClientController);