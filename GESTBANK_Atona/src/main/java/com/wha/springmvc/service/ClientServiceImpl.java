package com.wha.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Conseiller;

@Service("clientService")
public class ClientServiceImpl implements ClientService {
	
	private static List<Client> clients;
	
	static{
		clients= populateDummyClients();
	}
	
	@Override
	public Client findById(String identifiant) {
		for (Client client : clients) {
			if (client.getIdentifiant().equals(identifiant)){
				return client;
			}
		}
		return null;
	}

	@Override
	public Client findByName(String name) {
		for (Client client : clients) {
			if (client.getNom().equals(name)){
				return client;
			}
		}
		return null;
	}

	@Override
	public Client findByCompte(Long noCompte) {
		for (Client client : clients) {
			if (client.hasCompte(noCompte)){
				return client;
			}
		}
		return null;
	}

	@Override
	public void saveClient(Client client) {
		clients.add(client);

	}

	@Override
	public void updateClient(Client client, String identifiant) {
		Client client2 = this.findById(identifiant);
		int index = clients.indexOf(client2);
		clients.set(index, client);

	}

	@Override
	public List<Client> findAllClients(String identConseiller) {
		List<Client> listClients = new ArrayList<Client>();
		for (Client client : clients) {
			if (client.getConseiller().getIdentifiant().equals(identConseiller)){
				listClients.add(client);
			}
		}
		return listClients;
	}

	@Override
	public List<Client> findAllClientsByName(String debName, Conseiller conseiller) {
		List<Client> listClients = new ArrayList<Client>();
		for (Client client : clients) {
			if (client.getConseiller()==conseiller && client.getNom().startsWith(debName)){
				listClients.add(client);
			}
		}
		return listClients;
	}

	@Override
	public boolean isClientExist(Client client) {
		for (Client c  : clients) {
			if (c.equals(client)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isIdentifiantExist(String identifiant) {
		for (Client client : clients) {
			if (client.getIdentifiant().equals(identifiant)){
				return true;
			}
		}
		return false;
	}
	
	private static List<Client> populateDummyClients(){
		List<Client> clients = new ArrayList<Client>();
		Conseiller conseiller1 = new Conseiller("Michel", "jeanne", "JMichel");
		clients.add(new Client("Davis", "Mark", "MDavis", conseiller1));
		clients.add(new Client("Davis", "Helen", "HDavis", conseiller1));
		clients.add(new Client("Damon", "Barn", "BDamon", conseiller1));
		clients.add(new Client("Thomas", "William", "WThomas", conseiller1));
		clients.add(new Client("Wong", "Mickael", "MWong", conseiller1));
		Conseiller conseiller2 = new Conseiller("Rober", "frank", "FRober");
		clients.add(new Client("Davis", "Chris", "CDavis", conseiller2));
		clients.add(new Client("Gibbs", "Anthony", "AGibbs", conseiller2));
		clients.add(new Client("Shepard", "John", "JSheperd", conseiller2));
		return clients;
	}

}
