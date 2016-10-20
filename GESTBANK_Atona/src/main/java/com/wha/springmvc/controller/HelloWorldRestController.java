package com.wha.springmvc.controller;

import java.util.ArrayList;
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
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.DemandeOuverture;
import com.wha.springmvc.model.Notification;
import com.wha.springmvc.model.Transaction;
import com.wha.springmvc.model.User;
import com.wha.springmvc.model.Utilisateur;
import com.wha.springmvc.service.BanqueService;
import com.wha.springmvc.service.UserService;
import com.wha.springmvc.service.UtilisateurService;

@RestController
public class HelloWorldRestController {

	@Autowired
	UserService userService; // Service which will do all data
								// retrieval/manipulation work
	@Autowired
	UtilisateurService utilService;

	@Autowired
	BanqueService banqueService;

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

	// #region Utilisateur

	// #region Client

	// ---Recuperation des clients d'un conseiller de matricule {mle}
	@RequestMapping(value = "/client/", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> findAllClientsByConseiller(@RequestParam("conseiller") Long mle) {
		List<Client> clients = utilService.findAllClients(mle);
		if (clients.isEmpty()) {
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}

	// ---Recuperation du client d'identifiant {identifiant}
	@RequestMapping(value = "/client/{identifiant}", method = RequestMethod.GET)
	public ResponseEntity<Client> findClientById(@PathVariable("identifiant") Long id) {
		Client client = utilService.findById(id);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	// ---Creation d'un client
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public ResponseEntity<Void> creationClient(@RequestBody Client client, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Client " + client.getNom());

		if (utilService.isClientExist(client)) {
			System.out.println("A Client with identifiant " + client.getIdentifiant() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		utilService.saveClient(client);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getIdentifiant()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ---Modification du client d'identifiant {identifiant}
	@RequestMapping(value = "/client/{identifiant}", method = RequestMethod.PUT)
	public ResponseEntity<Client> modificationClient(@PathVariable("identifiant") Long id, @RequestBody Client client) {
		System.out.println("Updating Client " + id);

		Client currentClient = utilService.findById(id);

		if (currentClient == null) {
			System.out.println("Client with id " + id + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		utilService.updateClient(client);
		return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
	}

	// #endregion

	// #region Conseiller

	// ---Recuperation de tous les conseillers
	@RequestMapping(value = "/conseiller/", method = RequestMethod.GET)
	public ResponseEntity<List<Conseiller>> findAllconseillers() {
		List<Conseiller> conseillers = utilService.findAllConseillers();
		if (conseillers.isEmpty()) {
			return new ResponseEntity<List<Conseiller>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Conseiller>>(conseillers, HttpStatus.OK);
	}

	// ---Recuperation du conseiller de matricule {matricule}
	@RequestMapping(value = "/conseiller/{matricule}", method = RequestMethod.GET)
	public ResponseEntity<Conseiller> findConseillerByMle(@PathVariable("matricule") Long mle) {
		Conseiller conseiller = utilService.findByMle(mle);
		if (conseiller == null) {
			return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Conseiller>(conseiller, HttpStatus.OK);
	}

	// ---Creation d'un conseiller
	@RequestMapping(value = "/conseiller/", method = RequestMethod.POST)
	public ResponseEntity<Void> creationConseiller(@RequestBody Conseiller conseiller, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Conseiller " + conseiller.getNom());

		if (utilService.isConseillerExist(conseiller)) {
			System.out.println("A Conseiller with identifiant " + conseiller.getMatricule() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		System.out.println(conseiller);
		utilService.saveConseiller(conseiller);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/conseiller/{id}").buildAndExpand(conseiller.getMatricule()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ---Modification du conseiller de matricule {matricule}
	@RequestMapping(value = "/conseiller/{matricule}", method = RequestMethod.PUT)
	public ResponseEntity<Conseiller> modificationConseiller(@PathVariable("matricule") Long mle,
			@RequestBody Conseiller conseiller) {
		System.out.println("Updating Conseiller " + mle);

		Conseiller currentConseiller = utilService.findByMle(mle);

		if (currentConseiller == null) {
			System.out.println("Conseiller with id " + mle + " not found");
			return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
		}
		utilService.updateConseiller(conseiller);
		return new ResponseEntity<Conseiller>(currentConseiller, HttpStatus.OK);

	}
	// #endregion

	// #region Connexion

	@RequestMapping(value = "/connexion/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> connexion(@RequestParam("pseudo") String pseudo,
			@RequestParam("mdp") String motDePasse) {
		if (!pseudo.equals(motDePasse)) {
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		}
		if (!utilService.isPseudoExist(pseudo) && !pseudo.equals("admin")) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		String jSon = "";
		Utilisateur u = utilService.getUtilisateurByPseudo(pseudo);
		if (u instanceof Client) {
			Client c = (Client) u;
			jSon += "Client" + c.getIdentifiant() + "";
		} else if (u instanceof Conseiller) {
			Conseiller c = (Conseiller) u;
			jSon += "Conseiller" + c.getMatricule() + "";
		} else {
			jSon += "Administrateur";
		}
		return new ResponseEntity<String>(jSon, HttpStatus.OK);
	}

	// #endregion

	//	#region Demande
	
	//-- recuperation de toutes les demandes
	@RequestMapping(value="/demande/", method=RequestMethod.GET)
	public ResponseEntity<List<DemandeOuverture>> listAllDemandes(){
		List<DemandeOuverture> liste = utilService.findAllDemandes();
		if (liste.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DemandeOuverture>>(liste, HttpStatus.OK);
	}
	
	//---- recuperation de toutes les demandes affectees à un conseiller
	@RequestMapping(value="/demande/{matricule}", method=RequestMethod.GET)
	public ResponseEntity<List<DemandeOuverture>> listDemandesByConseiller(@PathVariable Long matricule){
		if (utilService.findByMle(matricule)==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<DemandeOuverture> liste = utilService.findDemandeByConseiller(matricule);
		if (liste.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DemandeOuverture>>(liste, HttpStatus.OK);
	}
	
	//----- affectation d'un conseiller à une demande
	@RequestMapping(value="/demande/", method=RequestMethod.PUT)
	public ResponseEntity<Void> affectDemande(@RequestParam("conseiller") Long matricule, @RequestBody DemandeOuverture demande){
		if (!utilService.isDemandeExist(demande)){
			System.out.println(demande.getNumDemande());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		utilService.affectionOuverture(demande, matricule);
		return new ResponseEntity<Void>( HttpStatus.OK);
	}
	
	//----- validation d'une demande
		@RequestMapping(value="/demande/{numDemande}", method=RequestMethod.PUT)
		public ResponseEntity<Void> valideDemande(@PathVariable("numDemande") int numDemande, @RequestBody DemandeOuverture demande){
			DemandeOuverture demandeOuverture = utilService.getDemandeByNum(numDemande);
			if (demandeOuverture==null){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			utilService.validationDemande(demande);
			return null;
		}
	
	//----- creation d'une demande
	@RequestMapping(value="/demande/", method=RequestMethod.POST)
	public ResponseEntity<Void> saveDemande(@RequestBody DemandeOuverture demande){
		if (utilService.isDemandeExist(demande)){
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		utilService.saveDemande(demande);
		return new ResponseEntity<Void>( HttpStatus.OK);
	}
	
	
	// #endregion
	
	// #endregion

	// #region Banque

	// #region Compte

	// ---Recuperation du compte n° noCompte
	@RequestMapping(value = "/compte/{noCompte}", method = RequestMethod.GET)
	public ResponseEntity<Compte> findCompteByNo(@PathVariable("noCompte") Long noCompte) {
		Compte compte = banqueService.getCompteByNo(noCompte);
		if (compte == null)
			return new ResponseEntity<Compte>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Compte>(compte, HttpStatus.OK);
	}

	// ---Recuperation des compte du client d'identifiant {identifiant}
	@RequestMapping(value = "/compte/", method = RequestMethod.GET)
	public ResponseEntity<List<Compte>> findCompteByClient(@RequestParam("client") Long identifiant) {
		List<Compte> liste = banqueService.getComptesByClient(identifiant);
		if (liste.isEmpty())
			return new ResponseEntity<List<Compte>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Compte>>(liste, HttpStatus.OK);
	}

	// ---Ajout d'un compte à un client d'identifiant {identifiant}
	@RequestMapping(value = "/compte/", method = RequestMethod.POST)
	public ResponseEntity<Void> ajoutCompte(@RequestParam("client") Long identifiant, @RequestBody Compte compte,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Compte " + compte.getNoCompte());

		if (banqueService.isCompteExist(compte)) {
			System.out.println("A Compte with identifiant " + compte.getNoCompte() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		banqueService.ajoutCompte(compte, identifiant);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/compte/{noCompte}").buildAndExpand(compte.getNoCompte()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ---Modification du compte de n° noCompte
	@RequestMapping(value = "/compte/{noCompte}", method = RequestMethod.PUT)
	public ResponseEntity<Compte> modifCompte(@PathVariable("noCompte") Long noCompte, @RequestBody Compte compte) {
		System.out.println("Updating Compte " + noCompte);

		if (banqueService.getCompteByNo(noCompte) == null) {
			System.out.println("Compte with noCompte " + noCompte + " not found");
			return new ResponseEntity<Compte>(HttpStatus.NOT_FOUND);
		}

		banqueService.modificationCompte(compte);

		return new ResponseEntity<Compte>(compte, HttpStatus.OK);
	}
	// #endregion

	// #region Transaction

	// ---Récuperation de tous les transactions d'un compte
		@RequestMapping(value = "/compte/{noCompte}/transaction", method = RequestMethod.GET)
		public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable("noCompte") Long noCompte) {
			if (banqueService.getCompteByNo(noCompte)==null){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			List<Transaction> liste = new ArrayList<>();
			liste = banqueService.getAllTransactionsByCompte(noCompte);
			return new ResponseEntity<List<Transaction>>(liste, HttpStatus.OK);
		}
	
	// ---Récuperation des transactions d'un mois donné d'un compte
	@RequestMapping(value = "/compte/{noCompte}/transaction/{mois}", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getThatMonthTransactions(@PathVariable("mois") int month, @PathVariable("noCompte") Long noCompte) {
		if (banqueService.getCompteByNo(noCompte)==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<Transaction> liste = new ArrayList<>();
		liste = banqueService.getThatMonthTransactionsByCompte(noCompte, month);
		return new ResponseEntity<List<Transaction>>(liste, HttpStatus.OK);
	}

	// ---Récuperation de tous les notifications d'un compte
			@RequestMapping(value = "/compte/{noCompte}/notification", method = RequestMethod.GET)
			public ResponseEntity<List<Notification>> getAllNotifications(@PathVariable("noCompte") Long noCompte) {
				if (banqueService.getCompteByNo(noCompte)==null){
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				List<Notification> liste = new ArrayList<>();
				liste = banqueService.getAllNotificationsByCompte(noCompte);
				return new ResponseEntity<List<Notification>>(liste, HttpStatus.OK);
			}
			
	// ---Récuperation des notifications d'un mois donné d'un compte
		@RequestMapping(value = "/compte/{noCompte}/notification/{mois}", method = RequestMethod.GET)
		public ResponseEntity<List<Notification>> getThatMonthNotifications(@PathVariable("mois") int month, @PathVariable("noCompte") Long noCompte) {
			if (banqueService.getCompteByNo(noCompte)==null){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			List<Notification> liste = new ArrayList<>();
			liste = banqueService.getThatMonthNotificationsByCompte(noCompte, month);
			return new ResponseEntity<List<Notification>>(liste, HttpStatus.OK);
		}
	
	// ---Ajout d'un débit dans un compte de n° noCompte
	@RequestMapping(value = "/compte/{noCompte}/transaction/debit/", method = RequestMethod.POST)
	public ResponseEntity<Void> ajoutDebit(@RequestBody Debit debit, @PathVariable("noCompte") Long noCompte) {
		if (banqueService.getCompteByNo(noCompte)==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (banqueService.ajoutDebit(debit, noCompte)){
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	// ---Ajout d'un crédit dans un compte de n° noCompte
	@RequestMapping(value = "/compte/{noCompte}/transaction/credit/", method = RequestMethod.POST)
	public ResponseEntity<Void> ajoutCredit(@RequestBody Credit credit, @PathVariable("noCompte") Long noCompte) {
		if (banqueService.getCompteByNo(noCompte)==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		banqueService.ajoutCredit(credit, noCompte);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// #endregion

	// #endregion

}
