package com.wha.springmvc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="conseiller")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Conseiller")
public class Conseiller extends Utilisateur {
	// #region Attributs
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="mle")
	private Long matricule;
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<DemandeOuverture> listeDemandesOuverture;
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Requete> listeDemandesClient;
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Client> listeClients;
	// #endregion

	// #region Constructeurs
	public Conseiller() {
		listeClients = new ArrayList<Client>();
		listeDemandesClient = new ArrayList<Requete>();
		listeDemandesOuverture = new ArrayList<DemandeOuverture>();
	}

	public Conseiller(Long matricule, String nom, String prenom, String pseudo, String motdepasse, String email,
			String adresse, Integer codePostal, String ville, Integer telephone, Date dateNaissance) {
		super(nom, prenom, pseudo, motdepasse, email, adresse, codePostal, ville, telephone, dateNaissance);
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
