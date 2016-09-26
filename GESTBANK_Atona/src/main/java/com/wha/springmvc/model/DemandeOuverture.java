package com.wha.springmvc.model;

import java.util.Date;

public class DemandeOuverture {

	private ClientPotentiel cp;
	private boolean valide;
	private Conseiller conseiller;
	private Date dateCreation;
	private Date dateAffectation;

	public DemandeOuverture() {
		this.dateCreation = new Date();
	}

	public ClientPotentiel getCp() {
		return cp;
	}

	public void setCp(ClientPotentiel cp) {
		this.cp = cp;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

}
