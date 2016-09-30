'use strict';

angular.module('myApp').controller('ConsController', ['$scope', 'ConseillerService', function($scope, ConseillerService) {
    var self = this;
    self.conseillers=[];
    self.demandes=[];
    
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllConseillers();

    function fetchAllConseillers(){
        AdminService.fetchAllConseillers()
            .then(
            function(d) {
                self.conseillers = d;
            },
            function(errResponse){
                console.error('Error while fetching Conseillers');
            }
        );
    }

    function createConseiller(conseiller){
        AdminService.createConseiller(conseiller)
            .then(
            fetchAllConseillers,
            function(errResponse){
                console.error('Error while creating Conseiller');
            }
        );
    }

    function updateConseiller(conseiller, mle){
        AdminService.updateConseiller(Conseiller, mle)
            .then(
            fetchAllConseillers,
            function(errResponse){
                console.error('Error while updating Conseiller');
            }
        );
    }

    function deleteConseiller(mle){
        AdminService.deleteConseiller(mle)
            .then(
            fetchAllConseillers,
            function(errResponse){
                console.error('Error while deleting Conseiller');
            }
        );
    }

    function submit() {
        if(self.conseiller.mle===null){
            console.log('Saving New Conseiller', self.conseiller);
            createConseiller(self.conseiller);
        }else{
            updateConseiller(self.conseiller, self.conseiller.mle);
            console.log('Conseiller updated with mle ', self.conseiller.mle);
        }
        reset();
    }

    function edit(mle){
        console.log('mle to be edited', mle);
        for(var i = 0; i < self.conseillers.length; i++){
            if(self.conseillers[i].id === id) {
                self.conseiller = angular.copy(self.conseillers[i]);
                break;
            }
        }
    }

    function remove(mle){
        console.log('mle to be deleted', mle);
        if(self.conseiller.mle === mle) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteConseiller(mle);
    }


    function reset(){
        self.conseiller={mle:null,nom:'',email:'',telephone:''};
        $scope.myForm.$setPristine(); //reset Form
    }

    function fetchDemande(){
        AdminService.fetchDemande()
            .then(
            function(d) {
                self.conseillers = d;
            },
            function(errResponse){
                console.error('Error while fetching Conseillers');
            }
        );
    }
    
}]);
