package com.wha.springmvc.model;

import java.util.List;

public class Compte {

	private Long noCompte;
	private String RIB;
	private Integer solde;
	private List<Transaction> listeTransactions;
	private Integer decouvert;
	private Integer montantAgios;
	private Integer seuilRemuneration;
	private Integer montantRemuneration;
	private List<Notification> listeNotification;

	public Compte() {

	}

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

}
