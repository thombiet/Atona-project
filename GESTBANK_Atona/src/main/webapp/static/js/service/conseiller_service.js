'use strict';

angular.module('myApp').factory('ConseillerService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/conseiller/';

    var factory = {
        fetchAllConseillers: fetchAllConseillers,
        createConseiller: createConseiller,
        updateConseiller:updateConseiller,
        deleteConseiller:deleteConseiller,
        fetchDemande: fetchDemande,
        affectConseiller:affectConseiller
    };
    return factory;
    
    /*recherche de tous les conseillers */
    function fetchAllConseillers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Conseillers');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* Ajout d'un conseiller puis refresh de la liste des conseillers */
    function createConseiller(conseiller) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, conseiller)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Conseiller');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /* update un conseiller puis refresh de la liste des conseillers */
    function updateConseiller(conseiller, matricule) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+matricule, conseiller)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Conseiller');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* supprime un conseiller puis refresh de la liste desconseilers */
    function deleteConseiller(matricule) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+mle)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Conseiller');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /*recherche d'une demande d'ouvertures de compte */
    function fetchDemande(nom) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+nom)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Demande');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /*affectation conseiller demande d'ouverture de compte */
    function affectConseiller(matricule,nom) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+matricule,nom)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while affect conseiller-demande');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
}]);
