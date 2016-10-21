package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Compte;

import com.wha.springmvc.model.Notification;
import com.wha.springmvc.model.Transaction;

public interface BanqueService {
	
	// #region Compte
	
	Compte getCompteByNo(Long noCompte);
	
	List<Compte> getComptesByClient(Long clientIdentifiant);
	
	void ajoutCompte(Compte compte, Long clientIdentifiant);
	
	void modificationCompte(Compte compte);
	
	boolean isCompteExist(Compte compte);
	
	// #endregion
	
	// #region Transaction

	List<Transaction> getAllTransactionsByCompte(Long noCompte);
	
	List<Transaction> getThatMonthTransactionsByCompte(Long noCompte, int thatMonth);
	
	boolean ajoutTransaction(Transaction transaction, Long noCompte);

	List<Notification> getAllNotificationsByClient(Long identifiant);
	
		
	// #endregion

}