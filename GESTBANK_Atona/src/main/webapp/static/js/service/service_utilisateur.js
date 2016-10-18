/**
 * Service Utilisateurs : Conseillers, Clients, Connexion, Demandes
 */

function utilisateurService($http, $q) {

	var CONSEILLER_URI = 'http://localhost:8080/SpringAngularStartProject/conseiller/';
	var CLIENT_URI = 'http://localhost:8080/SpringAngularStartProject/client/';
	var CONNEXION_URI = 'http://localhost:8080/SpringAngularStartProject/connexion/';
	var DEMANDE_URI = 'http://localhost:8080/SpringAngularStartProject/demande/';

	var factory = {
		// -------------------------------------------Service_conseiller-----------------------------------------
		getAllConseillers : getAllConseillers,
		getConseillerByMle : getConseillerByMle,
		createConseiller : createConseiller,
		updateConseiller : updateConseiller,
		deleteConseiller : deleteConseiller,
		// -------------------------------------------Service_client---------------------------------------------
		getAllClientsByConseiller : getAllClientsByConseiller,
		getClientById : getClientById,
		createClient : createClient,
		updateClient : updateClient,
		//deleteClient : deleteClient,
		// -------------------------------------------Service_connexion------------------------------------------
		//connexion : connexion,
		// -------------------------------------------Service_demandeOuverture-----------------------------------
		getAllDemandes : getAllDemandes,
		getDemandesByMle : getDemandesByMle,
		createDemande : createDemande,
		updateDemande : updateDemande,

	};
	return factory;

	// --------------------------------------------------------Hoisting-------------------------------------------
	
	// -------------------------------------------Service_conseiller-----------------------------------------
	/* recherche de tous les Conseillers */
    function getAllConseillers() {
        var deferred = $q.defer();
        $http.get(CONSEILLER_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching conseillers');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* recherche de conseiller par Mle */
    function getConseillerByMle(matricule) {
        var deferred = $q.defer();
        $http.get(CONSEILLER_URI+matricule)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching conseiller');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* Ajout d'un nouveau conseiller */
    function createConseiller(conseiller) {
        var deferred = $q.defer();
        $http.post(CONSEILLER_URI, conseiller)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating conseiller');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /* update un conseiller */
    function updateConseiller(conseiller, mle) {
        var deferred = $q.defer();
        $http.put(CONSEILLER_URI+matricule, conseiller)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating conseiller');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /* supprime un conseiller */
    function deleteConseiller(mle) {
        var deferred = $q.defer();
        $http.delete(CONSEILLER_URI+mle)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting conseiller');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
	// -------------------------------------------Service_connexion------------------------------------------
    
    
    
	// -------------------------------------------Service_client---------------------------------------------    
    
    /* recherche de tous les Clients */
    function getAllClientsByConseiller(matricule) {
        var deferred = $q.defer();
        $http.get(CLIENT_URI, {params:{conseiller:matricule}})
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching clients');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /* recherche de client par Id */
    function getClientById(identifiant) {
        var deferred = $q.defer();
        $http.get(CLIENT_URI+identifiant)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching client');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
   
    /* Ajout d'un client */
    function createClient(client) {
        var deferred = $q.defer();
        $http.post(CLIENT_URI, client)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating clients');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /* update client */
    function updateClient(client) {
        var deferred = $q.defer();
        var identifiant = client.identifiant;
        $http.put(CLIENT_URI+identifiant, client)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating client');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* supprime client */
    function deleteClient(identifiant) {
        var deferred = $q.defer();
        $http.delete(CLIENT_URI+identifiant)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting client');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    
	// -------------------------------------------Service_demandeOuverture-----------------------------------
    /* recherche de toutes les demandes */
    function getAllDemandes() {
        var deferred = $q.defer();
        $http.get(DEMANDE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching demandes');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* recherche de demandes ouverture compte par conseiller */
    function getDemandesByMle(matricule) {
        var deferred = $q.defer();
        $http.get(DEMANDE_URI+matricule)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching demande');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* Ajout d'une nouvelle demande */
    function createDemande(demande) {
        var deferred = $q.defer();
        $http.post(DEMANDE_URI, demande)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating conseiller');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /* update une demande */
    function updateDemande(cp, mle) {
        var deferred = $q.defer();
        $http.put(DEMANDE_URI+matricule, cp)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating conseiller');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    
}

App.factory("uService", utilisateurService)