'use strict';

App.factory('CompteService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/Client';

    var factory = {
       fetchAllComptes: fetchAllComptes,
       createCompte: createCompte,
       updateCompte:updateCompte,
       deleteCompte:deleteCompte
    };

    return factory;
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

