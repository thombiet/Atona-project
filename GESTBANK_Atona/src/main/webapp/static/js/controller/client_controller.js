'use strict';

App.controller('ClientController', ['$scope', 'ClientService','$location','$routeParams', function($scope, ClientService, $location,$routeParams) {
    var self = this;
    self.client={identifiant:null,nom:'',prenom:'',pseudo:''};
//    self.clients=[];
    
    self.conseiller = {matricule:'1', nom:'', prenom:'',pseudo:''};
    fetchAllClients(self.conseiller.matricule);
    

//    self.edit = edit;
    
    function fetchAllClients(matricule){
    	//alert("YES");
    	ClientService.fetchAllClients(matricule)
            .then(
            function(d) {
                self.clients = d;
                console.log(d);
            },
            function(errResponse){
                console.error('Error while fetching clients');
            }
        );
    }
    
    function affiche(){
    	console.log("testeur");
    }
    
    if($routeParams.identifiant){
    	ClientService.fetchClientById($routeParams.identifiant)
    		.then(
            function(d){
            	self.client= d;
            	console.log(d);
            },
            function(errResponse){
                console.error('Error while fetching client');
            }
        );
    }
    
    function fetchClientByNom(nom) {
    	//console.log(nom);
    	//alert("YES");
    	ClientService.fetchClientByNom(nom)
    		.then(
            function(d){
            	self.client= d;
              
            },
            function(errResponse){
                console.error('Error while fetching client');
            }
        );
    }
    
    function fetchCompteByNum(noCompte) {
    	alert("YES");
    	ClientService.fetchCompteById(noCompte)
    		.then(
            function(d){
            	self.compte= d;
               
            },
            function(errResponse){
                console.error('Error while fetching compte');
            }
        );
    }
    
    function createClient(client){
        ClientService.createClient(client)
            .then(
            fetchAllClients,
            function(errResponse){
                console.error('Error while creating Client');
            }
        );
    }

    function updateClient(client, identifiant){
        ClientService.updateClient(client, identifiant)
            .then(
            fetchAllClients,
            function(errResponse){
                console.error('Error while updating Client');
            }
        );
    }

    function deleteClient(identifiant){
        ClientService.deleteClient(identifiant)
            .then(
            fetchAllClients,
            function(errResponse){
                console.error('Error while deleting Client');
            }
        );
    }

    function submit() {
        if(self.client.identifiant===null){
            console.log('Saving New Client', self.client);
            createClient(self.client);
        }else{
            updateClient(self.client, self.client.identifiant);
            
        }
        reset();
    }

    function edit(identifiant){
    	//alert("OK");
        console.log('identifiant to be edited', identifiant);
        for(var i = 0; i < self.clients.length; i++){
            if(self.clients[i].identifiant === identifiant) {
                self.client = angular.copy(self.clients[i]);
                console.log(self.client.nom);
            	$location.url('/client/:identifiant');
                break;
            }
        }
    }

    function remove(identifiant){
        console.log('identifiant to be deleted', identifiant);
        if(self.client.identifiant === identifiant) {//clean form if the client to be deleted is shown there.
            reset();
        }
        deleteClient(identifiant);
    }

    function reset(){
        self.client={identifiant:null,clientname:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }
}]);
