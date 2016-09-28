package com.wha.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Conseiller;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<Client> clients;

	static {
		clients = populateDummyClients();
	}

	@Override
	public Client findById(Long identifiant) {
		for (Client client : clients) {
			if (client.getIdentifiant() == identifiant) {
				return client;
			}
		}
		return null;
	}

	@Override
	public Client findByCompte(Long noCompte) {
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
		client.setIdentifiant(counter.incrementAndGet());
		clients.add(client);
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Client> findAllClients(Long IdentConseiller) {
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
		for (Client c : clients) {
			if (c.equals(client)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isIdentifiantExist(String identifiant) {
		for (Client client : clients) {
			if (client.getIdentifiant().equals(identifiant)) {
				return true;
			}
		}
		return false;
	}

	private static List<Client> populateDummyClients() {
		List<Client> clients = new ArrayList<Client>();
		Conseiller conseiller1 = new Conseiller(1L, "Michel", "jeanne", "JMichel");
		clients.add(new Client(counter.incrementAndGet(), "Davis", "Mark", "MDavis", conseiller1));
		clients.add(new Client(counter.incrementAndGet(), "Davis", "Helen", "HDavis", conseiller1));
		clients.add(new Client(counter.incrementAndGet(), "Damon", "Barn", "BDamon", conseiller1));
		clients.add(new Client(counter.incrementAndGet(), "Thomas", "William", "WThomas", conseiller1));
		clients.add(new Client(counter.incrementAndGet(), "Wong", "Mickael", "MWong", conseiller1));
		Conseiller conseiller2 = new Conseiller(2L, "Rober", "frank", "FRober");
		clients.add(new Client(counter.incrementAndGet(), "Davis", "Chris", "CDavis", conseiller2));
		clients.add(new Client(counter.incrementAndGet(), "Gibbs", "Anthony", "AGibbs", conseiller2));
		clients.add(new Client(counter.incrementAndGet(), "Shepard", "John", "JSheperd", conseiller2));
		return clients;
	}

}
