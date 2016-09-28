package com.wha.springmvc.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.wha.springmvc.dummy.DummyBDD;
import com.wha.springmvc.model.Compte;

@Service("compteService")
public class CompteServiceImpl implements CompteService {


	private static List<Compte> comptes;

	static {
		comptes = DummyBDD.getComptes();
	}
	
	@Override
	public Compte getCompteByNo(Long noCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> getComptesByClient(Long clientIdentifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajoutCompte(Compte compte, Long clientIdentifiant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificationCompte(Compte compte) {
		// TODO Auto-generated method stub
		
	}

	
}
