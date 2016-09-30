package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Compte;

public interface CompteService {
	
	Compte getCompteByNo(Long noCompte);
	
	List<Compte> getComptesByClient(Long clientIdentifiant);
	
	void ajoutCompte(Compte compte, Long clientIdentifiant);
	
	void modificationCompte(Compte compte);
	
	boolean isCompteExist(Compte compte);

}
