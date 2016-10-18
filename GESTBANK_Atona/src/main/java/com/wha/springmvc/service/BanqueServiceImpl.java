package com.wha.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.BanqueDAO;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.Notification;
import com.wha.springmvc.model.Transaction;

@Service("banqueService")
@Transactional
public class BanqueServiceImpl implements BanqueService {

	/*// #region Compte
	private static List<Compte> comptes;

	private static void getComptes() {
		if (comptes == null) {
			DummyBDD.CreateBDD();
			comptes = DummyBDD.getComptes();
		}
	}*/
	
	@Autowired
	private BanqueDAO dao;
	
	@Override
	public Compte getCompteByNo(Long noCompte) {
		/*getComptes();
		for (Compte compte : comptes) {
			if (compte.getNoCompte() == noCompte)
				return compte;
		}
		return null;*/
		return dao.getCompteByNo(noCompte);
	}

	@Override
	public List<Compte> getComptesByClient(Long clientIdentifiant) {
		/*getComptes();
		Client c = null;
		for (Client client : DummyBDD.getClients()) {
			if (client.getIdentifiant() == clientIdentifiant) {
				c = client;
				break;
			}
		}
		if (c != null)
			return c.getListeComptes();
		return new ArrayList<Compte>();*/
		return dao.getComptesByClient(clientIdentifiant);
	}

	@Override
	public void ajoutCompte(Compte compte, Long clientIdentifiant) {
		/*getComptes();
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
		}*/
		dao.ajoutCompte(compte, clientIdentifiant);
	}

	@Override
	public void modificationCompte(Compte compte) {
		/*getComptes();
		int index = comptes.indexOf(compte);
		comptes.set(index, compte);
		DummyBDD.setComptes(comptes);*/
		Compte entity=dao.getCompteByNo(compte.getNoCompte());
		if(entity!=null){
			entity.setSolde(compte.getSolde());
			entity.setDecouvert(compte.getDecouvert());
			entity.setMontantRemuneration(compte.getMontantRemuneration());
			entity.setMontantAgios(compte.getMontantAgios());
			entity.setSeuilRemuneration(compte.getSeuilRemuneration());
			entity.setRIB(compte.getRIB());
			entity.setListeTransactions(compte.getListeTransactions());
			entity.setListeNotification(compte.getListeNotification());
		}
	}

	@Override
	public boolean isCompteExist(Compte compte) {
		/*for (Compte c : comptes) {
			if (c.equals(compte))
				return true;
		}
		return false;*/
		return dao.isCompteExist(compte);

	}

	// #endregion

	// #region Transaction

	/*private static List<Transaction> transactions;

	private static void getTransactions() {
		if (transactions == null) {
			DummyBDD.CreateBDD();
			transactions = DummyBDD.getTransactions();
		}
	}*/

	@Override
	public List<Transaction> getAllTransactionsByCompte(Long noCompte) {
		/*getComptes();
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
		return liste;*/
		return dao.getAllTransactionsByCompte(noCompte);
	}

	@Override
	public List<Transaction> getThatMonthTransactionsByCompte(Long noCompte, int thatMonth) {
		/*getComptes();
		List<List<Transaction>> liste = new ArrayList<>();
		Compte c = getCompteByNo(noCompte);
		List<Transaction> debits = new ArrayList<Transaction>();
		List<Transaction> credits = new ArrayList<Transaction>();
		for (Transaction t : c.getListeTransactions()) {
			LocalDate ld = t.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (ld.getMonthValue() == thatMonth) {
				if (t instanceof Credit) {
					credits.add(t);
				} else {
					debits.add(t);
				}
			}
		}
		liste.add(credits);
		liste.add(debits);
		return liste;*/
		return dao.getThatMonthTransactionsByCompte(noCompte, thatMonth);
	}

	@Override
	public boolean ajoutDebit(Debit debit, Long noCompte) {
		/*getComptes();
		getTransactions();
		Compte c = getCompteByNo(noCompte);
		if (c.ajoutTransaction(debit)) {
			transactions.add(debit);
			return true;
		}
		return false;*/
		return dao.ajoutDebit(debit, noCompte);
	}

	@Override
	public void ajoutCredit(Credit credit, Long noCompte) {
		/*getComptes();
		getTransactions();
		Compte c = getCompteByNo(noCompte);
		c.ajoutTransaction(credit);
		transactions.add(credit);*/
		dao.ajoutCredit(credit, noCompte);
	}

	@Override
	public List<Notification> getAllNotificationsByCompte(Long noCompte) {
		return dao.getAllNotificationsByCompte(noCompte);
	}

	@Override
	public List<Notification> getThatMonthNotificationsByCompte(Long noCompte, int thatMonth) {
		return dao.getThatMonthNotificationsByCompte(noCompte, thatMonth);
	}

	// #endregion
}