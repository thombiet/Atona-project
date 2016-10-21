/**
 * Le controleur qui gère toutes les pages de l'espace Client
 */
function ClientController(uService, cService, $scope, $routeParams) {

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

	$scope.voirCompte = voirCompte;

	function getClientById(Id) {
		uService.getClientById(Id).then(
				function(value) {
					$scope.client = value;
					$scope.mainCtrl.user = value;
				},
				function(reason) {
					console.log("Error: ConseillerController.getClientById - "
							+ reason.status)
				})
	}

	function voirCompte(noCompte) {
		sessionStorage.noCompte = noCompte;
		$scope.mainCtrl.redirection('/Client/GestionCompte/' + noCompte)
	}

	function getCompteByClient(identifiant) {
		cService.getCompteByClient(identifiant).then(function(d) {
			self.comptes = d;
		}, function(errResponse) {
			console.error('Error while fetching comptes');
		});
	}

	function getCompteByNo(noCompte) {
		cService.getCompteByNo(noCompte).then(function(d) {
			self.compte = d;
		}, function(errResponse) {
			console.error('Error while fetching compte');
		});
	}

	function getTransactions(noCompte) {
		var month = new Date().getMonth();
		cService.getTransactionsByCompteAndMonth(noCompte, month).then(
				function(value) {
					value.forEach(function(item, key) {
						if (item.typeTransaction == "debit")
							item.montant = -item.montant;
					})
					self.transactions = value;

				},
				function(reason) {
					console.log("ClientController : getTransactions, erreur "
							+ reason.status)
				})
	}


	function getAllNotifications(identifiant) {
		cService.getAllNotifications(identifiant).then(
				function(value) {
					self.notifications = value;
				},
				function(reason) {
					console.log("ClientController : getNotifications, erreur "
							+ reason.status)
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
