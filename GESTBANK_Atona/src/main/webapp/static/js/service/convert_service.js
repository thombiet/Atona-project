'use strict';

App.convert('ConvertService', ['$http', '$q', function($http, $q){

      
        var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/';

     
        /*conversion de devises */
       
        function conversion() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI)
                .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Erreur');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        }
