/**
 * Service Utilisateurs : Conseillers, Clients, Connexion, Demandes
 */

function utilisateurService($http, $q) {

	var CONSEILLER_URI = 'http://localhost:8080/SpringAngularStartProject/conseiller/';
	var CLIENT_URI = 'http://localhost:8080/SpringAngularStartProject/client/';
	var CONNEXION_URI = 'http://localhost:8080/SpringAngularStartProject/connexion/';
	var DEMANDE_URI = 'http://localhost:8080/SpringAngularStartProject/demande/';
	var REQUETE_URI= 'http://localhost:8080/SpringAngularStartProject/requete/';

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
		getClientByCompte : getClientByCompte,
		createClient : createClient,
		updateClient : updateClient,
		//deleteClient : deleteClient,
		// -------------------------------------------Service_connexion------------------------------------------
		//connexion : connexion,
		// -------------------------------------------Service_demandeOuverture-----------------------------------
		getAllDemandes : getAllDemandes,
		getDemandesByMle : getDemandesByMle,
		getDemandeByNum : getDemandeByNum,
		createDemande : createDemande,
		affectationDemande : affectationDemande,
		validationDemande : validationDemande,
		//--------------------------------------Requetes---------------------------------------------------
		findRequeteByConseiller:findRequeteByConseiller,
		getRequeteByNum:getRequeteByNum,
		validationRequete:validationRequete,	
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
                console.error('erreur utilisateurService.getAllConseillers()');
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
                console.error('erreur utilisateurService.getConseillerByMle()');
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
                console.error('erreur utilisateurService.createConseiller()');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /* update un conseiller */
    function updateConseiller(conseiller, matricule) {
        var deferred = $q.defer();
        $http.put(CONSEILLER_URI+matricule, conseiller)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('erreur utilisateurService.updateConseiller()');
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
                console.error('erreur utilisateurService.deleteConseiller()');
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
                console.error('erreur utilisateurService.getAllClientsByConseiller()');
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
                console.error('erreur utilisateurService.getClientById()');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* recherche le client du compte */
    function getClientByCompte(noCompte) {
        var deferred = $q.defer();
        $http.get(CLIENT_URI+"compte"+noCompte)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('erreur utilisateurService.getClientByCompte()');
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
                console.error('erreur utilisateurService.createClient()');
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
                console.error('erreur utilisateurService.updateClient()');
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
                console.error('erreur utilisateurService.deleteClient()');
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
                console.error('erreur utilisateurService.getAllDemandes()');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* recherche de demandes ouverture compte par conseiller */
    function getDemandesByMle(matricule) {
        var deferred = $q.defer();
        $http.get(DEMANDE_URI+"Conseiller"+matricule)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('erreur utilisateurService.getDemandesByMle()');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function getDemandeByNum(numDemande){
    	 var deferred = $q.defer();
         $http.get(DEMANDE_URI+numDemande)
             .then(
             function (response) {
                 deferred.resolve(response.data);
             },
             function(errResponse){
                 console.error('erreur utilisateurService.getDemandeByNum()');
                 deferred.reject(errResponse);
             }
         );
         return deferred.promise;
    }
    
    function getDemandeByNum(numDemande){
    	 var deferred = $q.defer();
         $http.get(DEMANDE_URI+numDemande)
             .then(
             function (response) {
                 deferred.resolve(response.data);
             },
             function(errResponse){
                 console.error('erreur utilisateurService.getDemandeByNum()');
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
                console.error('erreur utilisateurService.createDemande()');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /* affectation d'une demande à un conseiller*/
    function affectationDemande(demande, matricule) {
        var deferred = $q.defer();
        $http.put(DEMANDE_URI+"?conseiller="+matricule, demande)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('erreur utilisateurService.affectationDemande()');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /* validation d'une demande*/
    function validationDemande(demande) {
        var deferred = $q.defer();
        $http.put(DEMANDE_URI+demande.numDemande, demande)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('erreur utilisateurService.validationDemande()');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    //--------------------------------Services Requetes-----------------------------------------------------
    function findRequeteByConseiller(matricule) {
        var deferred = $q.defer();
        $http.get(CONSEILLER_URI+matricule+"/requete")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('erreur utilisateurService.findRequeteByConseiller()');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
   function getRequeteByNum(numRequete){
    	 var deferred = $q.defer();
         $http.get(CONSEILLER_URI+matricule+"/requete/"+numRequete)
             .then(
             function (response) {
                 deferred.resolve(response.data);
             },
             function(errResponse){
                 console.error('erreur utilisateurService.getRequeteByNum()');
                 deferred.reject(errResponse);
             }
         );
         return deferred.promise;
    }
    
    function validationRequete(numRequete) {
        var deferred = $q.defer();
        $http.post(CONSEILLER_URI+"/requete/"+numRequete)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('erreur utilisateurService.validationRequete()');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
}

App.factory("uService", utilisateurService)