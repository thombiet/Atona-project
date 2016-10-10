'use strict';

App.factory('ClientService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/Conseiller';

    var factory = {
        fetchAllClients: fetchAllClients,
        fetchClientById: fetchClientById,
        createClient: createClient,
        updateClient:updateClient,
        deleteClient:deleteClient,
        fetchAllComptes: fetchAllComptes,
        createCompte: createCompte,
        updateCompte:updateCompte,
        deleteCompte:deleteCompte
    };

    return factory;
    /*recherche de tous les Clients */
    function fetchAllClients(matricule) {
        var deferred = $q.defer();
        console.log(matricule)
        $http.get(REST_SERVICE_URI, {params:{conseiller:matricule}})
            .then(
            function (response) {
                deferred.resolve(response.data);
                console.log(response.status);
            },
            function(errResponse){
                console.error('Error while fetching clients');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /*recherche de client par Id */
    function fetchClientById(identifiant) {
        var deferred = $q.defer();
        console.log(identifiant)
        $http.get(REST_SERVICE_URI+identifiant)
            .then(
            function (response) {
                deferred.resolve(response.data);
                console.log(response.status);
            },
            function(errResponse){
                console.error('Error while fetching client');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* Ajout d'un user puis refresh de la liste des clients */
    function createClient(client) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, client)
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

    /* update un user puis refresh de la liste des clients */
    function updateClient(client, identifiant) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+identifiant, client)
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
    
    /* supprime un user puis refresh de la liste des clients */
    function deleteClient(identifiant) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+identifiant)
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
    
    /*recherche de tous les Comptes */
    function fetchAllComptes() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching compte');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    /* Ajout d'un compte puis refresh de la liste des comptes */
    function createCompte(compte) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, compte)
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

    /* update un compte puis refresh de la liste des comptes */
    function updateCompte(compte, numero) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+numero, compte)
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
    
    /* supprime un compte puis refresh de la liste des comptes */
    function deleteCompte(numero) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+numero)
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

}]);
