'use strict';

App.factory('AdminService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/conseiller/';
    var DEMANDES_URI = 'http://localhost:8080/SpringAngularStartProject/demande/';

    var factory = {
    	fetchConseillerByMle: fetchConseillerByMle,
    	fetchAllConseillers: fetchAllConseillers,
        createConseiller: createConseiller,
        updateConseiller: updateConseiller,
        deleteConseiller: deleteConseiller,
        fetchAllDemandes: fetchAllDemandes,
        fetchDemandesByConseiller: fetchDemandesByConseiller
    };

    return factory;
    
    
    
    /*recherche de tous les Conseillers */
    function fetchAllConseillers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
                console.log(response.status);
            },
            function(errResponse){
                console.error('Error while fetching conseillers');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /*recherche de conseiller par Mle */
    function fetchConseillerByMle(matricule) {
        var deferred = $q.defer();
        console.log(matricule)
        $http.get(REST_SERVICE_URI+matricule)
            .then(
            function (response) {
                deferred.resolve(response.data);
                
                console.log(response.status);
            },
            function(errResponse){
                console.error('Error while fetching conseiller');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* Ajout d'un nouveau conseiller*/
    function createConseiller(conseiller) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, conseiller)
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
        $http.put(REST_SERVICE_URI+matricule, conseiller)
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
    
    /* supprime un user puis refresh de la liste des clients */
    function deleteConseiller(mle) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+mle)
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
    
    
    
    
    
    function fetchAllDemandes() {
        var deferred = $q.defer();
        $http.get(DEMANDES_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
                console.log(response.status);
            },
            function(errResponse){
                console.error('Error while fetching conseillers');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /*recherche de demandes ouverture compte par conseiller */
    function fetchDemandesByConseiller(matricule) {
        var deferred = $q.defer();
        console.log(identifiant)
        $http.get(DEMANDES_URI, {params:{conseiller:matricule}})
            .then(
            function (response) {
                deferred.resolve(response.data);
                
                console.log(response.status);
            },
            function(errResponse){
                console.error('Error while fetching demande');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
