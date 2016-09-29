package com.wha.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wha.springmvc.dummy.DummyBDD;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	private static List<Client> clients;

	private static void getClients() {
		if (clients==null){
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
		clients=DummyBDD.getClients();
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

	@Override
	public boolean isIdentifiantExist(String identifiant) {
		getClients();
		for (Client client : clients) {
			if (client.getIdentifiant().equals(identifiant)) {
				return true;
			}
		}
		return false;
	}

}
