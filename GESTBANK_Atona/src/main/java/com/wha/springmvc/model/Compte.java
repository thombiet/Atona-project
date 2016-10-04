package com.wha.springmvc.model;

import java.util.ArrayList;
import java.util.List;

public class Compte {
	// #region Attributs
	private Long noCompte;
	private String RIB;
	private Integer solde;
	private List<Transaction> listeTransactions;
	private Integer decouvert;
	private Integer montantAgios;
	private Integer seuilRemuneration;
	private Integer montantRemuneration;
	private List<Notification> listeNotification;
	// #endregion

	// #region Constructeurs
	public Compte() {
		listeTransactions = new ArrayList<Transaction>();
		listeNotification = new ArrayList<Notification>();
	}

	public Compte(Long noCompte, Integer decouvert, Integer seuilRemuneration) {
		this();
		this.solde = 0;
		this.noCompte = noCompte;
		this.decouvert = decouvert;
		this.seuilRemuneration = seuilRemuneration;
	}

	// #endregion

	// #region Accesseurs
	public Long getNoCompte() {
		return noCompte;
	}

	public void setNoCompte(Long noCompte) {
		this.noCompte = noCompte;
	}

	public String getRIB() {
		return RIB;
	}

	public void setRIB(String rIB) {
		RIB = rIB;
	}

	public Integer getSolde() {
		return solde;
	}

	public void setSolde(Integer solde) {
		this.solde = solde;
	}

	public List<Transaction> getListeTransactions() {
		return listeTransactions;
	}

	public void setListeTransactions(List<Transaction> listeTransactions) {
		this.listeTransactions = listeTransactions;
	}

	public boolean ajoutTransaction(Transaction transaction) {
		if (transaction instanceof Debit) {
			if (this.isDebitAuthorize(transaction.getMontant())) {
				this.setSolde(this.getSolde() - transaction.getMontant());
			} else {
				return false;
			}
		} else {
			this.setSolde(this.getSolde() + transaction.getMontant());
		}
		List<Transaction> liste = this.getListeTransactions();
		liste.add(transaction);
		this.setListeTransactions(liste);
		return true;
	}

	public Integer getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(Integer decouvert) {
		this.decouvert = decouvert;
	}

	public Integer getMontantAgios() {
		return montantAgios;
	}

	public void setMontantAgios(Integer montantAgios) {
		this.montantAgios = montantAgios;
	}

	public Integer getSeuilRemuneration() {
		return seuilRemuneration;
	}

	public void setSeuilRemuneration(Integer seuilRemuneration) {
		this.seuilRemuneration = seuilRemuneration;
	}

	public Integer getMontantRemuneration() {
		return montantRemuneration;
	}

	public void setMontantRemuneration(Integer montantRemuneration) {
		this.montantRemuneration = montantRemuneration;
	}

	public List<Notification> getListeNotification() {
		return listeNotification;
	}

	public void setListeNotification(List<Notification> listeNotification) {
		this.listeNotification = listeNotification;
	}
	// #endregion

	// #region Utilitaire
	@Override
	public String toString() {
		return "Compte [getNoCompte()=" + getNoCompte() + ", getSolde()=" + getSolde() + ", getDecouvert()="
				+ getDecouvert() + ", getSeuilRemuneration()=" + getSeuilRemuneration() + "]";
	}

	private boolean isDebitAuthorize(int montant) {
		return (this.getSolde() + this.getDecouvert() - montant > 0);
	}

	// #endregion
}
