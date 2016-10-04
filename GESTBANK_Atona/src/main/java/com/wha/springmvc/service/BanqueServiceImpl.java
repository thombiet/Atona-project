package com.wha.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wha.springmvc.dummy.DummyBDD;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;

@Service("compteService")
public class CompteServiceImpl implements CompteService {

	private static List<Compte> comptes;

	private static void getComptes() {
		if (comptes == null) {
			DummyBDD.CreateBDD();
			comptes = DummyBDD.getComptes();
		}
	}

	@Override
	public Compte getCompteByNo(Long noCompte) {
		getComptes();
		for (Compte compte : comptes) {
			if (compte.getNoCompte() == noCompte)
				return compte;
		}
		return null;
	}

	@Override
	public List<Compte> getComptesByClient(Long clientIdentifiant) {
		getComptes();
		Client c = null;
		for (Client client : DummyBDD.getClients()) {
			if (client.getIdentifiant() == clientIdentifiant) {
				c = client;
				break;
			}
		}
		if (c != null)
			return c.getListeComptes();
		return new ArrayList<Compte>();
	}

	@Override
	public void ajoutCompte(Compte compte, Long clientIdentifiant) {
		getComptes();
		Client c = null;
		for (Client client : DummyBDD.getClients()) {
			if (client.getIdentifiant() == clientIdentifiant) {
				c = client;
				break;
			}
		}
		if (c != null)
			c.ajoutCompte(compte);
	}

	@Override
	public void modificationCompte(Compte compte) {
		getComptes();
		int index = comptes.indexOf(compte);
		comptes.set(index, compte);
		DummyBDD.setComptes(comptes);
	}

	@Override
	public boolean isCompteExist(Compte compte) {
		for (Compte c : comptes) {
			if (c.equals(compte))
				return true;
		}
		return false;
	}

}
