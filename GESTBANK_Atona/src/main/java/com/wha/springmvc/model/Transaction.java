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
