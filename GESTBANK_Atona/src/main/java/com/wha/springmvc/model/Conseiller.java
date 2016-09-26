package com.wha.springmvc.model;

import java.util.List;

import com.wha.springmvc.model.Utilisateur;

public class Conseiller extends Utilisateur {
	// #region Attributs
	private String matricule;
	private List<DemandeOuverture> listeDemandesOuverture;
	private List<Requete> listeDemandesClient;
	private List<Client> listeClients;
	// #endregion

	// #region Constructeurs
	public Conseiller() {

	}
	// #endregion

	// #region Accesseurs
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
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

}
