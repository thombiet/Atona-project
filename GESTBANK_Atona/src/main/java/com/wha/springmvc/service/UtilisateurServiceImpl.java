package com.wha.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wha.springmvc.dummy.DummyBDD;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.Utilisateur;

@Service("clientService")
public class UtilisateurServiceImpl implements UtilisateurService {

	// #region Client
	private static List<Client> clients;

	private static void getClients() {
		if (clients == null) {
			DummyBDD.CreateBDD();
			clients = DummyBDD.getClients();
		}
	}

	@Override
	public Client findById(Long identifiant) {
		getClients();
		for (Client client : clients) {
			if (client.getIdentifiant() == identifiant) {
				return client;
			}
		}
		return null;
	}

	@Override
	public Client findByCompte(Long noCompte) {
		getClients();
		for (Client client : clients) {
			for (Compte compte : client.getListeComptes()) {
				if (compte.getNoCompte() == noCompte) {
					return client;
				}
			}
		}
		return null;
	}

	@Override
	public void saveClient(Client client) {
		getClients();
		DummyBDD.ajoutClient(client);
		clients = DummyBDD.getClients();
	}

	@Override
	public void updateClient(Client client) {
		getClients();
		int index = clients.indexOf(client);
		clients.set(index, client);
		DummyBDD.setClients(clients);

	}

	@Override
	public List<Client> findAllClients(Long IdentConseiller) {
		getClients();
		List<Client> lClients = new ArrayList<Client>();
		for (Client client : clients) {
			if (client.getConseiller().getMatricule() == IdentConseiller) {
				lClients.add(client);
			}
		}
		return lClients;
	}

	@Override
	public boolean isClientExist(Client client) {
		getClients();
		for (Client c : clients) {
			if (c.equals(client)) {
				return true;
			}
		}
		return false;
	}

	// #endregion

	// #region Conseiller

	private static List<Conseiller> conseillers;

	private static void getConseillers() {
		if (conseillers == null) {
			DummyBDD.CreateBDD();
			conseillers = DummyBDD.getConseillers();
		}
	}

	@Override
	public Conseiller findByMle(Long matricule) {
		getConseillers();
		for (Conseiller c : conseillers) {
			if(c.getMatricule()==matricule)
				return c;
		}
		return null;
	}

	@Override
	public void saveConseiller(Conseiller conseiller) {
		getConseillers();
		DummyBDD.ajoutConseiller(conseiller);
		conseillers= DummyBDD.getConseillers();
	}

	@Override
	public void updateConseiller(Conseiller conseiller) {
		getConseillers();
		int index = conseillers.indexOf(conseiller);
		conseillers.set(index, conseiller);
		DummyBDD.setConseillers(conseillers);
	}

	@Override
	public List<Conseiller> findAllConseillers() {
		getConseillers();
		return conseillers;
	}

	@Override
	public boolean isConseillerExist(Conseiller conseiller) {
		getConseillers();
		for (Conseiller c : conseillers) {
			if (c==conseiller) return true;
		}
		return false;
	}

	// #endregion

	// #region Utilisateur

	private static List<Utilisateur> utilisateurs;

	private static void getUtilisateurs() {
		if (utilisateurs == null) {
			DummyBDD.CreateBDD();
			utilisateurs = DummyBDD.getUtilisateurs();
		}
	}

	@Override
	public boolean isPseudoExist(String pseudo) {
		getUtilisateurs();
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getPseudo().equals(pseudo)) {
				return true;
			}
		}
		return false;
	}
	// #endregion

}
