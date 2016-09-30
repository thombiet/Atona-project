package com.wha.springmvc.model;

import java.util.Date;

public class Transaction {
	// #region Attributs
	private Integer montant;
	private String libelle;
	private Date date;
	// #endregion

	// #region Constructeurs
	public Transaction() {

	}
	
	
	public Transaction(Integer montant, String libelle, Date date) {
		this.montant = montant;
		this.libelle = libelle;
		this.date = date;
	}


	// #endregion

	// #region Accesseurs
	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	// #endregion
}
