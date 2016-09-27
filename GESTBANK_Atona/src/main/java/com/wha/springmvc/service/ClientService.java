package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Conseiller;

public interface ClientService {
	
	Client findById(String identifiant);
	
	Client findByName(String name);
	
	Client findByCompte(Long noCompte);
	
	void saveClient(Client client);
	
	void updateClient(Client client, String identifiant);
	
//	void deleteClientById(String identifiant);

	List<Client> findAllClients(String IdentConseiller); 

	List<Client> findAllClientsByName(String debName, Conseiller conseiller); 
	
//	void deleteAllClients();
	
	public boolean isClientExist(Client client);
	
	public boolean isIdentifiantExist(String identifiant);

}
