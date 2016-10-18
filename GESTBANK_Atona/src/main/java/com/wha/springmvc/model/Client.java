package com.wha.springmvc.model;

import java.io.File;
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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="client")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Client")
public class Client extends Utilisateur {

	// #region Attributs
	
	@Column (name="identifiant")
	private Long identifiant;
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Compte> listeComptes;
	@Transient
	private List<File> piecesJustificatives;
	@Column (name="revenuMens")
	private Integer revenuMensuel;
	/*@ManyToOne
	@JoinColumn(name="conseiller_mle",referencedColumnName="mle")
	private Conseiller conseiller;*/

	// #endregion

	// #region Constructeurs
	public Client() {
		super();
		this.listeComptes = new ArrayList<Compte>();
		this.piecesJustificatives = new ArrayList<File>();
	}

	

	public Client(Long identifiant, String nom, String prenom, String pseudo, String motdepasse, String email, String adresse,
			Integer codePostal, String ville, Integer telephone, Date dateNaissance) {
		super(nom, prenom, pseudo, motdepasse, email, adresse, codePostal, ville, telephone, dateNaissance);
		this.identifiant = identifiant;
		this.listeComptes = new ArrayList<Compte>();
		this.piecesJustificatives = new ArrayList<File>();
	}

	// #endregion

	// #region Accesseurs
	
	public Long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}
	
	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

	public List<File> getPiecesJustificatives() {
		return piecesJustificatives;
	}

	public void setPiecesJustificatives(List<File> piecesJustificatives) {
		this.piecesJustificatives = piecesJustificatives;
	}

	public Integer getRevenuMensuel() {
		return revenuMensuel;
	}

	public void setRevenuMensuel(Integer revenuMensuel) {
		this.revenuMensuel = revenuMensuel;
	}

	/*public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
*/
	// #endregion

	// #region Utilitaire
	@Override
	public String toString() {
		return "Client [ getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getIdentifiant()=" + getPseudo() + "]";
	}

	// #endregion

	// #region Metier
	
	public boolean hasCompte(Long noCompte) {
		if (!this.getListeComptes().isEmpty()) {
			for (Compte compte : listeComptes) {
				if (compte.getNoCompte() == noCompte) {
					return true;
				}
			}
		}
		return false;
	}

	public void ajoutCompte(Compte compte) {
		if (compte != null) {
			this.listeComptes.add(compte);
		}
	}
	
	// #endregion

}
