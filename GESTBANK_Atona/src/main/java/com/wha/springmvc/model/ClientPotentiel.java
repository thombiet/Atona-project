package com.wha.springmvc.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
@Table (name="clientPotentiel")
public class ClientPotentiel {
	// #region Attributs
	@Id
	@Column (name="identifiant")
	private String identifiant;
	@Column (name="nom")
	private String nom;
	@Column (name="prenom")
	private String prenom;
	@Column (name="email")
	private String email;
	@Column (name="adresse")
	private String adresse;
	@Column (name="codePostal")
	private Integer codePostal;
	@Column (name="ville")
	private String ville;
	@Column (name="telephone")
	private Integer telephone;
	@Column (name="revenuMens")
	private Integer revenuMens;
	@Column (name="dateNaissance")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Transient
	private List<File> piecesJutificatives;
	// #endregion

	// #region Constructeurs
	public ClientPotentiel() {
		this.piecesJutificatives = new ArrayList<File>();
	}

	public ClientPotentiel(String nom, String prenom, String identifiant, String email, String adresse,
			Integer codePostal, String ville, Integer telephone, Integer revenuMens, Date dateNaissance) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.revenuMens = revenuMens;
		this.dateNaissance = dateNaissance;
	}
	
	// #endregion


	// #region Accesseurs
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String pseudo) {
		this.identifiant = pseudo;
	}

	public Integer getRevenuMens() {
		return revenuMens;
	}

	public void setRevenuMens(Integer revenuMens) {
		this.revenuMens = revenuMens;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public List<File> getPiecesJutificatives() {
		return piecesJutificatives;
	}

	public void setPiecesJutificatives(List<File> piecesJutificatives) {
		this.piecesJutificatives = piecesJutificatives;
	}
	// #endregion

}
