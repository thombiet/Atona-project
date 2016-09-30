App.config(['$routeProvider', function($routeProvider){
	$routeProvider
	
	.when('/', {
		templateUrl: 'static/views/AccueilGuest.html',
		controller: 'MyController'
	})
	.when('/Inscription', {
		templateUrl: 'static/views/Formulaire_Inscription.html',
		controller: 'MyController'
	})
		.when('/Client', {
		templateUrl: 'static/views/AccueilClient.html',
		controller: 'MyController'
	})
	.when('/ClientMessagerie', {
		templateUrl: 'static/views/ClientMessagerie.html',
		controller: 'MyController'
	})
	.when('/Mes Informations', {
		templateUrl: 'static/views/Fiche_Client.html',
		controller: 'MyController'
	})

		.when('/Admin', {
		templateUrl: 'static/views/AccueilAdmin.html',
		controller: 'MyController'
	})
	.when('/Conseiller', {
		templateUrl: 'static/views/AccueilConseiller.html',
		controller: 'MyController'
	})
}])