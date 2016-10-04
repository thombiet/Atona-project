'use strict';

App.controller('ClientController', ['$scope', 'ClientService', function($scope, ClientService) {
    var self = this;
   //self.client={identifiant:'',nom:'',prenom:'',pseudo:'',conseiller:''};
   //self.fetchIdClient= 2;
   /*self.clients=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;*/
    
    self.conseiller = {matricule:'2', nom:'', prenom:'',pseudo:'FRober'};
    //self.client={identifiant:'2',nom:'',prenom:'',pseudo:'',conseiller:''};


    fetchAllClients(self.conseiller.matricule);
    //fetchClientById(self.client.identifiant);
    
    function fetchAllClients(matricule){
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
    
	function afficheClient(client){
		console.log(client);
	}
    
    function fetchClientById(identifiant) {
    	console.log(identifiant);
    	alert("YES");
    	ClientService.fetchClientById(identifiant)
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
    
    function fetchCompteById(noCompte) {
    	ClientService.fetchCompteById(noCompte)
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
            console.log('Client updated with identifiant ', self.client.identifiant);
        }
        reset();
    }

    function edit(identifiant){
        console.log('identifiant to be edited', identifiant);
        for(var i = 0; i < self.clients.length; i++){
            if(self.clients[i].identifiant === identifiant) {
                self.client = angular.copy(self.clients[i]);
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
