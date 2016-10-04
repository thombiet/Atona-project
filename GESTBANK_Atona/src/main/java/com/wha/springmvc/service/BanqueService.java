package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
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

	List<List<Transaction>> getAllTransactionsByCompte(Long noCompte);
	
	List<List<Transaction>> getThatMonthTransactionsByCompte(Long noCompte, int thatMonth);
	
	boolean ajoutDebit(Debit debit, Long noCompte);
	
	void ajoutCredit(Credit credit, Long noCompte);
	
	// #endregion

}
