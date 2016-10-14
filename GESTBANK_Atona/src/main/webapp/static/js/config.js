App.config(['$routeProvider', function($routeProvider){
	$routeProvider
	.when('/', {
		templateUrl: 'static/views/AccueilGuest.html',
		controller: 'convertCtrl'
	})
	.when('/Inscription', {
		templateUrl: 'static/views/Formulaire_Inscription.html',
		controller: 'MyController'
	})
		.when('/Client', {
		templateUrl: 'static/views/AccueilClient.html',
		controller: 'ClientController'
	})
	.when('/ClientMessagerie', {
		templateUrl: 'static/views/ClientMessagerie.html',
		controller: 'ClientController'
	})
	.when('/GestionCompte', {
		templateUrl: 'static/views/ClientGestionComptes.html',
		controller: 'ClientController'
	})
	.when('/GestionCompte/RIB', {
		templateUrl: 'static/views/RIB.html',
		controller: 'ClientController'
	})
	.when('/Client/:identifiant', {
		templateUrl: 'static/views/Fiche_Client.html',
		controller: 'ClientController'
	})
	.when('/Admin', {
		templateUrl: 'static/views/AccueilAdmin.html',
		controller: 'AdminController as actrl'
	})
	.when('/Admin/AffectCons', {
		templateUrl: 'static/views/AdminAffectCons.html',
		controller: 'AdminController'
	})
	.when('/Conseiller', {
		templateUrl: 'static/views/AccueilConseiller.html',
		controller: 'ClientController'
	})
}])