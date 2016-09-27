package com.wha.springmvc.model;

public class Utilisateur {

	// #region Attributs
	private String nom;
	private String prenom;
	private String identifiant;
	private String motdepasse;
	private String email;
	private String adresse;
	private Integer codePostal;
	private String ville;
	private Integer telephone;
	// #endregion

	// #region Constructeurs
	public Utilisateur() {

	}
	
	public Utilisateur(String nom, String prenom, String identifiant, String motdepasse, String email, String adresse,
			Integer codePostal, String ville, Integer telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.motdepasse = motdepasse;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
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

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	// #endregion

}
