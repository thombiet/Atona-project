'use strict';

function compteService($http, $q){

    var COMPTE_URI = 'http://localhost:8080/SpringAngularStartProject/compte/';
   var NOTIF_URI = 'http://localhost:8080/SpringAngularStartProject/notification/';

    var factory = {
    //---------------------Compte----------------------
    	getCompteByClient: getCompteByClient,
    	getCompteByNo: getCompteByNo,
    	createCompte: createCompte,
    	updateCompte:updateCompte,
    	deleteCompte:deleteCompte,
    //---------------------Transaction-----------------
    	getTransactionsByCompteAndMonth:getTransactionsByCompteAndMonth,
    	getTransactionsByCompte:getTransactionsByCompte,
    	ajoutTransaction:ajoutTransaction,
    	 //---------------------Notification----------------
    	getAllNotifications:getAllNotifications,
     	
    //---------------------Requete----------------------
    	envoiRequete:envoiRequete,
    };

    return factory;
    
    /* recherche de tous les Comptes */
    function getCompteByClient(idClient) {
        var deferred = $q.defer();
        $http.get(COMPTE_URI, {params:{client:idClient}})
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching all comptes');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* recherche d'un compte de noCompte NoCompte */
    function getCompteByNo(NoCompte) {
        var deferred = $q.defer();
        $http.get(COMPTE_URI+NoCompte)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching compte no:'+NoCompte);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* Creation d'un compte */
    function createCompte(compte) {
        var deferred = $q.defer();
        $http.post(COMPTE_URI, compte)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating comptes');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /* update un compte*/
    function updateCompte(compte, numero) {
        var deferred = $q.defer();
        $http.put(COMPTE_URI+numero, compte)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating compte');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* supprime un compte*/
    function deleteCompte(numero) {
        var deferred = $q.defer();
        $http.delete(COMPTE_URI+numero)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting compte');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    //--------------------------------------Transaction--------------
    /* recupere les transaction d'un compte pour un mois donné */
    function getTransactionsByCompteAndMonth(noCompte, month){
    	var deferred = $q.defer();
        $http.get(COMPTE_URI+noCompte+"/transaction/"+month)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching transaction');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* recupere toutes les transaction d'un compte*/
    function getTransactionsByCompte(NoCompte){
    	var deferred = $q.defer();
        $http.get(COMPTE_URI+NoCompte+"/transaction/")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching transaction');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

       function getAllNotifications(identifiant){
    	var deferred = $q.defer();
    	console.log(identifiant);
        $http.get(NOTIF_URI, {params:{id:identifiant}})
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching notification');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    } 
<<<<<<< HEAD
    
    function ajoutTransaction(transaction, noCompte)  {
    	var deferred = $q.defer();
    	$http.post(COMPTE_URI+noCompte+"/transaction/", transaction)
    	.then(
    			function (response){
    				deferred.resolve(response.data);
    			},
    			function (errResponse){
    				console.error('erreur pendant ajoutTransaction');
    				deferred.reject(errResponse);
    			})
    			return deferred.promise;
}
function envoiRequete(noCompte, requete, matricule){

    	var deferred = $q.defer();
        $http.post(COMPTE_URI+"requete/"+noCompte+"&"+requete+"&"+matricule)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while sending requete');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}

App.factory("cService", compteService)