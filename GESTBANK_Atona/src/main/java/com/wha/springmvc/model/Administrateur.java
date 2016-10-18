package com.wha.springmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="administrateur")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Administrateur")
public class Administrateur extends Utilisateur {

	// #region
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Conseiller> listeConseillers;
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DemandeOuverture> listeDemandes;
	// #endregion

	// #region Constructeurs
	public Administrateur() {

	}
	// #endregion

	// #region Accesseurs
	public List<Conseiller> getListeConseillers() {
		return listeConseillers;
	}

	public void setListeConseillers(List<Conseiller> listeConseillers) {
		this.listeConseillers = listeConseillers;
	}

	public List<DemandeOuverture> getListeDemandes() {
		return listeDemandes;
	}

	public void setListeDemandes(List<DemandeOuverture> listeDemandes) {
		this.listeDemandes = listeDemandes;
	}
	// #endregion
}
