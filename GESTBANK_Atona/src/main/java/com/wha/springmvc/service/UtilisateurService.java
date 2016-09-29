package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Conseiller;

public interface UtilisateurService {
	
	//#region client

	Client findById(Long identifiant);

	Client findByCompte(Long noCompte);

	void saveClient(Client client);

	void updateClient(Client client);

	List<Client> findAllClients(Long mle);

	public boolean isClientExist(Client client);

	// void deleteAllClients();

	// void deleteClientById(String identifiant);
	
	//#endregion
	
	//#region Conseiller
	Conseiller findByMle(Long matricule);

	void saveConseiller(Conseiller conseiller);

	void updateConseiller(Conseiller conseiller);

	List<Conseiller> findAllConseillers();

	public boolean isConseillerExist(Conseiller conseiller);
	
	//#endregion 

	
	//#region Utilisateur
	public boolean isPseudoExist(String peudo);
	
	//#endregion

}
