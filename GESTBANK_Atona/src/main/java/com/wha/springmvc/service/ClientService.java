package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Client;

public interface ClientService {

	Client findById(Long identifiant);

	Client findByCompte(Long noCompte);

	void saveClient(Client client);

	void updateClient(Client client);

	List<Client> findAllClients(Long mle);

	public boolean isClientExist(Client client);

	public boolean isIdentifiantExist(String identifiant);

	// void deleteAllClients();

	// void deleteClientById(String identifiant);

}
