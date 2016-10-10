package com.wha.springmvc.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClientPotentiel {
	// #region Attributs
	private String nom;
	private String prenom;
	private String identifiant;
	private String email;
	private String adresse;
	private Integer codePostal;
	private String ville;
	private Integer telephone;
	private Integer revenuMens;
	private List<File> piecesJutificatives;
	// #endregion

	// #region Constructeurs
	public ClientPotentiel() {
		this.piecesJutificatives = new ArrayList<File>();
	}
	
	
	// #endregion

	public ClientPotentiel(String nom, String prenom, String identifiant, String email, String adresse,
			Integer codePostal, String ville, Integer telephone, Integer revenuMens) {
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
	}


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

	public List<File> getPiecesJutificatives() {
		return piecesJutificatives;
	}

	public void setPiecesJutificatives(List<File> piecesJutificatives) {
		this.piecesJutificatives = piecesJutificatives;
	}
	// #endregion

}
