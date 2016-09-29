'use strict';

angular.module('myApp').controller('AccueilGuestController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.user={pseudo: '',motdepasse:''};
    self.users=[];
    self.role;
    self.connexion = connexion;
   
     
    function connexion(user, id){
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

  

    function connexion(pseudo, motdepasse) {
        if(self.pseudo!=null && self.motdepasse!=null){
            console.log('Connexion valide', self.user);
            createUser(self.user);
              }
         console.error("Erreur d'identification");
    }

   

}]);
