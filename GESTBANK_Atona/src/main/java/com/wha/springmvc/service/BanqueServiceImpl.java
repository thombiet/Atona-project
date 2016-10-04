package com.wha.springmvc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wha.springmvc.dummy.DummyBDD;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.Transaction;

@Service("banqueService")
public class BanqueServiceImpl implements BanqueService {

	// #region Compte
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
		if (c != null) {
			Compte compteComplet = DummyBDD.ajoutCompte(compte);
			comptes = DummyBDD.getComptes();
			c.ajoutCompte(compteComplet);
		}
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

	// #endregion

	// #region Transaction

	private static List<Transaction> transactions;
	private static void getTransactions(){
		if (transactions == null) {
			DummyBDD.CreateBDD();
			transactions = DummyBDD.getTransactions();
		}
	}
	
	@Override
	public List<List<Transaction>> getAllTransactionsByCompte(Long noCompte) {
		getComptes();
		List<List<Transaction>> liste = new ArrayList<>();
		Compte c = null;
		for (Compte compte : comptes) {
			if (compte.getNoCompte() == noCompte) {
				c = compte;
			}
		}
		if (c != null) {
			List<Transaction> debits = new ArrayList<Transaction>();
			List<Transaction> credits = new ArrayList<Transaction>();
			for (Transaction t : c.getListeTransactions()) {
				if (t instanceof Credit) {
					credits.add(t);
				} else {
					debits.add(t);
				}
			}
			liste.add(credits);
			liste.add(debits);
		}
		return liste;
	}

	@Override
	public List<List<Transaction>> getThatMonthTransactionsByCompte(Long noCompte, int thatMonth) {
		getComptes();
		List<List<Transaction>> liste = new ArrayList<>();
		Compte c = null;
		for (Compte compte : comptes) {
			if (compte.getNoCompte() == noCompte) {
				c = compte;
			}
		}
		if (c != null) {
			List<Transaction> debits = new ArrayList<Transaction>();
			List<Transaction> credits = new ArrayList<Transaction>();
			for (Transaction t : c.getListeTransactions()) {
				if (t.getDate().getMonth() == (thatMonth - 1)) {
					if (t instanceof Credit) {
						credits.add(t);
					} else {
						debits.add(t);
					}
				}
			}
			liste.add(credits);
			liste.add(debits);
		}
		return liste;
	}

	@Override
	public boolean ajoutDebit(Debit debit, Long noCompte) {
		getComptes();
		getTransactions();
		for (Compte compte : comptes) {
			if (compte.getNoCompte()==noCompte){
				if (compte.ajoutTransaction(debit)){
					transactions.add(debit);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void ajoutCredit(Credit credit, Long noCompte) {
		getComptes();
		getTransactions();
		for (Compte compte : comptes) {
			if (compte.getNoCompte()==noCompte){
				compte.ajoutTransaction(credit);
				transactions.add(credit);
			}
		}
	}

	// #endregion
}
