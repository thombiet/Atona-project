package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table (name="transaction")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TRANSACTION_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Transaction {
	// #region Attributs
	@Id
	@Column(name="noTransaction")
	private Integer noTransaction;
	@Column(name="montant")
	private Integer montant;
	@Column(name="libelle")
	private String libelle;
	@Column (name="dateAffectation")
	@Temporal(TemporalType.DATE)
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



	// #region Utilitaire

	@Override
	public String toString() {
		return "Transaction [noTransaction=" + noTransaction + ", montant=" + montant + ", libelle=" + libelle
				+ ", date=" + date + "]";
	}

	// #endregion
}
