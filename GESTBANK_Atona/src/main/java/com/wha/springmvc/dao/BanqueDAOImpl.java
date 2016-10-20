package com.wha.springmvc.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.AbstractDAO;
import com.wha.springmvc.dao.BanqueDAO;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.Notification;
import com.wha.springmvc.model.Transaction;

@Repository("BanqueDAO")
public class BanqueDAOImpl extends AbstractDAO<Long, Compte> implements BanqueDAO {

	@Override
	public Compte getCompteByNo(Long noCompte) {
		Compte compte=getByKey(noCompte);
		return compte;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getComptesByClient(Long idClient) {
		//List<Compte> comptes=getByKey(idClient);
		List<Compte> comptes=getEntityManager().createQuery("SELECT c.listeComptes FROM Client c WHERE identifiant= :idClient")
				.setParameter("idClient", idClient)
				.getResultList();
		return comptes;
	}

	@Override
	public void ajoutCompte(Compte compte, Long idClient) {
		persist(compte);
		//List<Compte> comptes=(List<Compte>) getByKey(idClient);
		getComptesByClient(idClient).add(compte);
	}

	@Override
	public void modificationCompte(Compte compte) {
		Compte compteup=getByKey(compte.getNoCompte());
		update(compteup);	
	}

	@Override
	public List<Transaction> getAllTransactionsByCompte(Long noCompte) {
		//Compte compte=getByKey(noCompte);
		//List<Transaction> lt=getCompteByNo(noCompte).getListeTransactions();
		List<Transaction> lt=getEntityManager().createQuery("SELECT c.listeTransactions FROM Compte c where c.noComtpe= :noCompte").getResultList();
		return lt;
	}

	@Override
	public List<Transaction> getThatMonthTransactionsByCompte(Long noCompte, int thatMonth) {
		//Compte compte=getByKey(noCompte);
		List<Transaction> ltm=new ArrayList<>();
		for (Transaction t : getCompteByNo(noCompte).getListeTransactions()) {
			LocalDate ld = t.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (ld.getMonthValue() == thatMonth) {
				ltm.add(t);
			}
		}
		return ltm;
	}

	@Override
	public boolean ajoutDebit(Debit debit, Long noCompte) {
		Compte compte=getByKey(noCompte);
		List<Transaction> lt=compte.getListeTransactions();
		if (compte.ajoutTransaction(debit)) {
			lt.add(debit);
			return true;
		}
		return false;
	}

	@Override
	public void ajoutCredit(Credit credit, Long noCompte) {
		Compte compte=getByKey(noCompte);
		List<Transaction> lt=compte.getListeTransactions();
		compte.ajoutTransaction(credit);
		lt.add(credit);
	}

	@Override
	public boolean isCompteExist(Compte compte) {
		for (Compte c : getAllComptes()) {
			if (c.equals(compte))
				return true;
		}
		return false;
	}

	@Override
	public List<Compte> getAllComptes() {
		List<Compte> comptes=getEntityManager().createQuery("SELECT com FROM Compte com").getResultList();
		return comptes;
	}

	@Override
	public List<Notification> getAllNotificationsByCompte(Long noCompte) {
		List<Notification> lt=getEntityManager().createQuery("SELECT c.listeNotifications FROM Compte c where c.noComtpe= :noCompte").getResultList();
		return lt;
	}

	@Override
	public List<Notification> getThatMonthNotificationsByCompte(Long noCompte, int thatMonth) {
		List<Notification> lnm=new ArrayList<>();
		for (Notification n : getCompteByNo(noCompte).getListeNotification()) {
			LocalDate ld = n.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (ld.getMonthValue() == thatMonth) {
				lnm.add(n);
			}
		}
		return lnm;
	}
}
