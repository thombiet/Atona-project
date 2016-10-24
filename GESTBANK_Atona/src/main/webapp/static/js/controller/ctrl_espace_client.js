/**
 * Le controleur qui gère toutes les pages de l'espace Client
 */
function ClientController(uService, cService,  $scope, $routeParams) {

	
	if (sessionStorage.role != "Client") {
		$scope.mainCtrl.deconnexion();
	} else {
		var self = this;
		getCompteByClient(sessionStorage.idConnecte);
		getClientById(sessionStorage.idConnecte);
		getAllNotifications(sessionStorage.idConnecte);
		if ($routeParams.noCompte) {
			getCompteByNo($routeParams.noCompte);
			getTransactions($routeParams.noCompte);
		}
	}
	self.envoiRequete=envoiRequete;
	$scope.voirCompte = voirCompte;
	$scope.virement = virement;

	function getClientById(Id) {

		uService.getClientById(Id).then(
			function(value) {
			$scope.client = value;
			$scope.mainCtrl.user = value;
		}, function(reason) {
			console.log("Error: ConseillerController.getClientById - "+reason.status)
		})
	}

	function voirCompte(noCompte){
		sessionStorage.noCompte = noCompte;
		$scope.mainCtrl.redirection('/Client/GestionCompte/'+noCompte)
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
		var month = new Date().getMonth();
		cService.getTransactionsByCompteAndMonth(noCompte, month).then(
			function(value) {
				value.forEach(function(item, key) {
					if (item.typeTransaction=="debit")
						item.montant=-item.montant;
				})
				self.transactions= value;
				
		}, function(reason) {
				console.log("ClientController : getTransactions, erreur "+reason.status)
		})
	}
	
	function getAllNotifications(identifiant) {
		cService.getAllNotifications(identifiant).then(
				function(value) {
					self.notifications = value;
					$scope.mainCtrl.nbMess = value.length;
					console.log(value.length)
				},
				function(reason) {
					console.log("ClientController : getNotifications, erreur "
							+ reason.status)
				})
	}


	function virement() {
		
		
		if($scope.CompteDebit.noCompte != $scope.CompteCredit.noCompte){
						
		var transaction ={};
		transaction.montant = $scope.montant;
		transaction.libelle = $scope.libelle;
		transaction.date = $scope.date;
		transaction.typeTransaction = "debit";
		
		var noCompte = $scope.CompteDebit.noCompte;
		console.log(transaction) ;
		console.log(noCompte) ;
    	cService.ajoutTransaction(transaction, noCompte)
    	
    		.then(
    				function(value){
    					self.transaction = value;
    					self.noCompte = value;
    					alert("Votre virement a bien ete effectue!");
    				},
    				function(reason){
    					alert("Erreur pendant la transaction")
    				})
		
		
		var transaction2 ={};
		transaction2.montant = $scope.montant;
		transaction2.libelle = $scope.libelle;
		transaction2.date = $scope.date;
		transaction2.typeTransaction = "credit";
		
		var noCompte2 = $scope.CompteCredit.noCompte;
		console.log(transaction2) ;
		console.log(noCompte2) ;
    	cService.ajoutTransaction(transaction2, noCompte2)
    	
    		.then(
    				function(value){
    					self.transaction2 = value;
    					self.noCompte2 = value;
    					alert("Votre virement a bien ete effectue!");
    					
    				},
    				function(reason){
    					alert("Erreur pendant la transaction")
    				})
		
	}
		$scope.mainCtrl.redirection('/Client/GestionCompte/' + noCompte);
	}

		

	function envoiRequete(requete){
		console.log("coucou")
		var noCompte = sessionStorage.noCompte;
		cService.envoiRequete(noCompte, requete,$scope.client.conseiller.matricule).then(	
				function(value){
					self.requete=value;
					console.log(value)
				},
		function(reason) {
			console.log("ClientController : envoiRequete, erreur "+reason.status)
		})
	}

	 $scope.printToCart = function(printSectionId) {
	        var innerContents = document.getElementById(printSectionId).innerHTML;
	        var popupWinindow = window.open('', '_blank', 'width=600,height=700,scrollbars=no,menubar=no,toolbar=no,location=no,status=no,titlebar=no');
	        popupWinindow.document.open();
	        popupWinindow.document.write('<html><head><link rel="stylesheet" type="text/css" href="static/css/style_RIB.css" /></head><body onload="window.print()">' + innerContents + '</html>');
	        popupWinindow.document.close();
	      }
	
}

App.controller("ClientController", ClientController);

