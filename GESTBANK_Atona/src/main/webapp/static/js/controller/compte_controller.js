'use strict';

App.controller('CompteController', ['$scope', '$location', 'CompteService', function($scope, $location, CompteService) {
	var self = this;
    self.compte={noCompte:'',solde:''};

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    
    fetchAllComptes(sessionStorage.idConnecte)
    
    function fetchAllComptes(identifiant){
    	CompteService.fetchAllComptes(identifiant)
            .then(
            function(d) {
                self.comptes = d;
                console.log(d);
            },
            function(errResponse){
                console.error('Error while fetching comptes');
            }
        );
    }
     
    function fetchCompteByNumero(noCompte) {
    	console.log(noCompte);
    	CompteService.fetchcompteById(noCompte)
    		.then(
            function(d){
            	self.compte= d;
                console.log(d);
            },
            function(errResponse){
                console.error('Error while fetching compte');
            }
        );
    }
  
    function createCompte(compte){
        CompteService.createCompte(compte)
            .then(
            fetchAllComptes,
            function(errResponse){
                console.error('Error while creating Compte');
            }
        );
    }

    function updateCompte(compte, noCompte){
        CompteService.updatecompte(compte, noCompte)
            .then(
            fetchAllComptes,
            function(errResponse){
                console.error('Error while updating Compte');
            }
        );
    }

    function deleteCompte(noCompte){
        CompteService.deleteCompte(noCompte)
            .then(
            fetchAllComptes,
            function(errResponse){
                console.error('Error while deleting Compte');
            }
        );
    }

    function submit() {
        if(self.compte.noCompte===null){
            console.log('Saving New compte', self.compte);
            createCompte(self.compte);
        }else{
            updateCompte(self.compte, self.compte.noCompte);
            console.log('Compte updated with noCompte ', self.compte.noCompte);
        }
        reset();
    }

    function edit(noCompte){
        console.log('noCompte to be edited', noCompte);
        for(var i = 0; i < self.comptes.length; i++){
            if(self.comptes[i].noCompte === noCompte) {
                self.compte = angular.copy(self.comptes[i]);
                break;
            }
        }
    }

    function remove(noCompte){
        console.log('noCompte to be deleted', noCompte);
        if(self.compte.noCompte === noCompte) {
            reset();
        }
        deleteCompte(noCompte);
    }


    function reset(){
        self.compte={noCompte:null,solde:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 }]);