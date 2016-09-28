package com.wha.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.service.ClientService;

@RestController
public class ClientServiceRestController {

	@Autowired
    ClientService clientService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Clients Of A Conseiller--------------------------------------------------------
     
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> listAllClients(@RequestParam("conseiller") Long mle) {
    	System.out.println(mle);
        List<Client> clients = clientService.findAllClients(mle);
        System.out.println(clients);
        if(clients.isEmpty()){
            return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Client--------------------------------------------------------
     
    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        System.out.println("Fetching Client with id " + id);
        Client client = clientService.findById(id);
        if (client == null) {
            System.out.println("Client with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Client--------------------------------------------------------
     
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public ResponseEntity<Void> createClient(@RequestBody Client client, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Client " + client.getNom());
 
        if (clientService.isClientExist(client)) {
            System.out.println("A Client with identifiant " + client.getIdentifiant() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        System.out.println(client);
        clientService.saveClient(client);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getIdentifiant()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Client --------------------------------------------------------
     
    @RequestMapping(value = "/client/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
        System.out.println("Updating Client " + id);
         
        Client currentClient = clientService.findById(id);
         
        if (currentClient==null) {
            System.out.println("Client with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
 
        currentClient.setNom(client.getNom());
        currentClient.setPrenom(client.getPrenom());
         
        clientService.updateClient(currentClient);
        return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Client --------------------------------------------------------
    /* 
    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Client with id " + id);
 
        Client Client = clientService.findById(id);
        if (Client == null) {
            System.out.println("Unable to delete. Client with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
 
        clientService.deleteClientById(id);
        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Clients --------------------------------------------------------
     
    @RequestMapping(value = "/client/", method = RequestMethod.DELETE)
    public ResponseEntity<Client> deleteAllClients() {
        System.out.println("Deleting All Clients");
 
        clientService.deleteAllClients();
        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
    }
    */
}
