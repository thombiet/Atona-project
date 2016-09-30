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
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.User;
import com.wha.springmvc.service.UserService;
import com.wha.springmvc.service.UtilisateurService;

@RestController
public class HelloWorldRestController {

	@Autowired
	UserService userService; // Service which will do all data
								// retrieval/manipulation work
	@Autowired
	UtilisateurService uService;

	// #region Exemples
	// -------------------Retrieve All
	// Users--------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);// You
																			// many
																			// decide
																			// to
																			// return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// User--------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		User user = userService.findById(id);
		if (user == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// -------------------Create a
	// User--------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getUsername());

		if (userService.isUserExist(user)) {
			System.out.println("A User with name " + user.getUsername() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User
	// --------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		System.out.println("Updating User " + id);

		User currentUser = userService.findById(id);

		if (currentUser == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		currentUser.setUsername(user.getUsername());
		currentUser.setAddress(user.getAddress());
		currentUser.setEmail(user.getEmail());

		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User
	// --------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting User with id " + id);

		User user = userService.findById(id);
		if (user == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users
	// --------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		System.out.println("Deleting All Users");

		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	// #endregion

	// #region Utilisateurs

	// ---Recuperation des clients d'un conseiller de matricule {mle}
	@RequestMapping(value = "/client/", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> findAllClientsByConseiller(@RequestParam("conseiller") Long mle) {
		List<Client> clients = uService.findAllClients(mle);
		if (clients.isEmpty()) {
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}

	// ---Recuperation du client d'identifiant {identifiant}
	@RequestMapping(value = "/client/{identifiant}", method = RequestMethod.GET)
	public ResponseEntity<Client> findClientById(@PathVariable("identifiant") Long id) {
		Client client = uService.findById(id);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	// ---Creation d'un client
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public ResponseEntity<Void> creationClient(@RequestBody Client client, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Client " + client.getNom());

		if (uService.isClientExist(client)) {
			System.out.println("A Client with identifiant " + client.getIdentifiant() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		uService.saveClient(client);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getIdentifiant()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ---Modification du client d'identifiant {identifiant}
	@RequestMapping(value = "/client/{identifiant}", method = RequestMethod.PUT)
	public ResponseEntity<Client> modificationClient(@PathVariable("id") Long id, @RequestBody Client client) {
		System.out.println("Updating Client " + id);

		Client currentClient = uService.findById(id);

		if (currentClient == null) {
			System.out.println("Client with id " + id + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		currentClient.setNom(client.getNom());
		currentClient.setPrenom(client.getPrenom());

		uService.updateClient(currentClient);
		return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
	}

	// ---Recuperation du conseiller de matricule {matricule}
	@RequestMapping(value = "/conseiller/{matricule}", method = RequestMethod.GET)
	public ResponseEntity<Conseiller> findConseillerByMle(@PathVariable("matricule") Long mle) {
		Conseiller conseiller = uService.findByMle(mle);
		if (conseiller == null) {
			return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Conseiller>(conseiller, HttpStatus.OK);
	}

	// ---Recuperation de tous les conseillers
	@RequestMapping(value = "/conseiller/", method = RequestMethod.GET)
	public ResponseEntity<List<Conseiller>> findAllconseillers() {
		List<Conseiller> conseillers = uService.findAllConseillers();
		if (conseillers.isEmpty()) {
			return new ResponseEntity<List<Conseiller>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Conseiller>>(conseillers, HttpStatus.OK);
	}

	// ---Creation d'un conseiller
	@RequestMapping(value = "/conseiller/", method = RequestMethod.POST)
	public ResponseEntity<Void> creationConseiller(@RequestBody Conseiller conseiller, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Conseiller " + conseiller.getNom());

		if (uService.isConseillerExist(conseiller)) {
			System.out.println("A Conseiller with identifiant " + conseiller.getMatricule() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		System.out.println(conseiller);
		uService.saveConseiller(conseiller);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/conseiller/{id}").buildAndExpand(conseiller.getMatricule()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ---Modification du conseiller de matricule {matricule}
	@RequestMapping(value = "/conseiller/{matricule}", method = RequestMethod.PUT)
	public ResponseEntity<Conseiller> modificationConseiller(@PathVariable("matricule") Long mle,
			@RequestBody Conseiller conseiller) {
		System.out.println("Updating Conseiller " + mle);

		Conseiller currentConseiller = uService.findByMle(mle);

		if (currentConseiller == null) {
			System.out.println("Conseiller with id " + mle + " not found");
			return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
		}

		currentConseiller.setNom(conseiller.getNom());
		currentConseiller.setPrenom(conseiller.getPrenom());

		uService.updateConseiller(currentConseiller);
		return new ResponseEntity<Conseiller>(currentConseiller, HttpStatus.OK);

	}
	// #endregion

}