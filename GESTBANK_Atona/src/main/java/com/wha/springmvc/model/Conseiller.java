package com.wha.springmvc.model;

import java.util.ArrayList;
import java.util.List;

public class Conseiller extends Utilisateur {
	// #region Attributs
	private Long matricule;
	private List<DemandeOuverture> listeDemandesOuverture;
	private List<Requete> listeDemandesClient;
	private List<Client> listeClients;
	// #endregion

	// #region Constructeurs
	public Conseiller() {
		listeClients = new ArrayList<Client>();
		listeDemandesClient = new ArrayList<Requete>();
		listeDemandesOuverture = new ArrayList<DemandeOuverture>();
	}

	public Conseiller(Long mle, String nom, String prenom, String identifiant) {
		super(nom, prenom, identifiant, identifiant, null, null, null, null, null);
		this.matricule = mle;
		listeClients = new ArrayList<Client>();
		listeDemandesClient = new ArrayList<Requete>();
		listeDemandesOuverture = new ArrayList<DemandeOuverture>();
	}

	public Conseiller(Long matricule, String nom, String prenom, String pseudo, String motdepasse, String email,
			String adresse, Integer codePostal, String ville, Integer telephone) {
		super(nom, prenom, pseudo, motdepasse, email, adresse, codePostal, ville, telephone);
		this.matricule = matricule;
		listeClients = new ArrayList<Client>();
		listeDemandesClient = new ArrayList<Requete>();
		listeDemandesOuverture = new ArrayList<DemandeOuverture>();
	}

	// #endregion

	// #region Accesseurs
	public Long getMatricule() {
		return matricule;
	}

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}

	public List<DemandeOuverture> getListeDemandesOuverture() {
		return listeDemandesOuverture;
	}

	public void setListeDemandesOuverture(List<DemandeOuverture> listeDemandesOuverture) {
		this.listeDemandesOuverture = listeDemandesOuverture;
	}

	public List<Requete> getListeDemandesClient() {
		return listeDemandesClient;
	}

	public void setListeDemandesClient(List<Requete> listeDemandesClient) {
		this.listeDemandesClient = listeDemandesClient;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	// #endregion

	// #region Utilitaire
	@Override
	public String toString() {
		return "Conseiller [getMatricule()=" + getMatricule() + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getIdentifiant()=" + getPseudo() + "]";
	}

	public void ajoutClient(Client client) {
		List<Client> l = this.getListeClients();
		l.add(client);
		this.setListeClients(l);
	}

	// #endregion

}
