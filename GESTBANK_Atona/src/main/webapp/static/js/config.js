App.config([ '$routeProvider', function($routeProvider) {
	$routeProvider
	// espace public
	.when('/', {
		templateUrl : 'static/views/AccueilGuest.html',
		controller : 'PublicController',
		controllerAs : 'PublicCtrl'
	}).when('/Inscription', {
		templateUrl : 'static/views/Formulaire_Inscription.html',
		controller : 'PublicController',
		controllerAs : 'PublicCtrl'
	})
	// espace client
	.when('/Client', {
		templateUrl : 'static/views/AccueilClient.html',
		controller : 'ClientController',
		controllerAs : 'ClientCtrl'
	}).when('/ClientMessagerie', {
		templateUrl : 'static/views/ClientMessagerie.html',
		controller : 'ClientController',
		controllerAs : 'ClientCtrl'
	}).when('/ClientNvRequete', {
		templateUrl : 'static/views/NouvelleRequete.html',
		controller : 'ClientController',
		controllerAs : 'ClientCtrl'
	}).when('/GestionCompte', {
		templateUrl : 'static/views/ClientGestionComptes.html',
		controller : 'ClientController',
		controllerAs : 'ClientCtrl'
	}).when('/GestionCompte/RIB', {
		templateUrl : 'static/views/RIB.html',
		controller : 'ClientController',
		controllerAs : 'ClientCtrl'
	}).when('/GestionCompte/Virement', {
		templateUrl : 'static/views/ClientVirement.html',
		controller : 'ClientController',
		controllerAs : 'ClientCtrl'
	}).when('/Client/Infos/:identifiant', {
		templateUrl : 'static/views/Fiche_Client.html',
		controller : 'ClientController',
		controllerAs : 'ClientCtrl'
	})
	// espace admin
	.when('/Admin', {
		templateUrl : 'static/views/AccueilAdmin.html',
		controller : 'AdministrateurController',
		controllerAs : 'AdminCtrl'
	}).when('/Admin/GestionConseillers', {
		templateUrl : 'static/views/AdminGestionConseillers.html',
		controller : 'AdministrateurController',
		controllerAs : 'AdminCtrl'
	}).when('/Admin/GestionDemandes', {
		templateUrl : 'static/views/AdminGestionDemandes.html',
		controller : 'AdministrateurController',
		controllerAs : 'AdminCtrl'
	}).when('/Admin/AjoutConseiller', {
		templateUrl : 'static/views/FormulaireNouveauConseiller.html',
		controller : 'AdministrateurController',
		controllerAs : 'AdminCtrl'
	}).when('/Admin/Fiche_Conseiller/:matricule', {
		templateUrl : 'static/views/Fiche_Conseiller.html',
		controller : 'AdministrateurController',
		controllerAs : 'AdminCtrl'
	}).when('/Admin/AffectCons', {
		templateUrl : 'static/views/AdminAffectCons.html',
		controller : 'AdministrateurController',
		controllerAs : 'AdminCtrl'
	})
	// espace conseiller
	.when('/Conseiller', {
		templateUrl : 'static/views/AccueilConseiller.html',
		controller : 'ConseillerController',
		controllerAs : 'ConsCtrl'
	}).when('/ConseillerMessagerie', {
		templateUrl : 'static/views/ConseillerMessagerie.html',
		controller : 'ConseillerController',
		controllerAs : 'ConsCtrl'
	}).when('/Conseiller/NvRequete', {
		templateUrl : 'static/views/NouvelleRequete.html',
		controller : 'ConseillerController',
		controllerAs : 'ConsCtrl'
	}).when('/Conseiller/Infos/:matricule', {
		templateUrl : 'static/views/Fiche_Conseiller.html',
		controller : 'ConseillerController',
		controllerAs : 'ConsCtrl'
	}).when('/Conseiller/ModifTypeCompte', {
		templateUrl : 'static/views/ConseillerModifTypeCompte.html',
		controller : 'ConseillerController',
		controllerAs : 'ConsCtrl'
	}).when('/Conseiller/GestionComptes/ModifFaciliteCaisse', {
		templateUrl : 'static/views/ConseillerModifFaciliteCaisse.html',
		controller : 'ConseillerController',
		controllerAs : 'ConsCtrl'
	}).when('/Conseiller/GestionCompte/:noCompte', {
		templateUrl : 'static/views/ConseillerGestionComptes.html',
		controller : 'ConseillerController',
		controllerAs : 'ConsCtrl'
	}).when('/Conseiller/GestionClients', {
		templateUrl : 'static/views/ConseillerGestionClients.html',
		controller : 'ConseillerController',
		controllerAs : 'ConsCtrl'
	}).when('/Conseiller/Fiche_Client/:identifiant', {
		templateUrl : 'static/views/Fiche_Client.html',
		controller : 'ConseillerController',
		controllerAs : 'ConsCtrl'
	}).when('/Conseiller/GestionDemandes', {
		templateUrl : 'static/views/ConseillerGestionDemandes.html',
		controller : 'ConseillerController',
		controllerAs : 'ConsCtrl'
	}).otherwise({
		redirectTo : '/'
	});

} ])