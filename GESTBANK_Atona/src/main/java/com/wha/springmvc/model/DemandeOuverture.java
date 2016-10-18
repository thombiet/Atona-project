package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table (name="demandeOuverture")
public class DemandeOuverture {
	// #region Attributs
	@Id
	@Column(name="numDemande")
	private int numDemande;
	@OneToOne(cascade=CascadeType.PERSIST)
	private ClientPotentiel cp;
	@Transient
	private boolean valide;
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conseiller_mle",referencedColumnName="mle")
	private Conseiller conseiller;*/
	
	@Column (name="dateCreation")
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Column (name="dateAffectation")
	@Temporal(TemporalType.DATE)
	private Date dateAffectation;
	// #endregion

	// #region Constructeurs
	public DemandeOuverture() {
		this.dateCreation = new Date();
	}
	
	public DemandeOuverture(ClientPotentiel cp, boolean valide, Conseiller conseiller, Date dateCreation,
			Date dateAffectation) {
		super();
		this.cp = cp;
		this.valide = valide;
		//this.conseiller = conseiller;
		this.dateCreation = dateCreation;
		this.dateAffectation = dateAffectation;
	}


	// #endregion

	// #region Accesseurs
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

	/*public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}*/

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
	// #endregion

	public int getNumDemande() {
		return numDemande;
	}

	public void setNumDemande(int numDemande) {
		this.numDemande = numDemande;
	}
}
