package com.wha.springmvc.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Client extends Utilisateur {
	// #region Attributs
	private List<Compte> listeComptes;
	private List<File> piecesJustificatives;
	private Integer revenuMensuel;
	private Conseiller conseiller;
	// #endregion

	// #region Constructeurs
	public Client() {
		super();
		listeComptes = new ArrayList<Compte>();
		piecesJustificatives = new ArrayList<File>();
	}
	
	
	// #endregion

	public Client(String nom, String prenom, String identifiant, String motdepasse, String email, String adresse,
			Integer codePostal, String ville, Integer telephone, Conseiller conseiller) {
		super(nom, prenom, identifiant, motdepasse, email, adresse, codePostal, ville, telephone);
		this.conseiller=conseiller;
	}
	
	public Client(String nom, String prenom, String identifiant, Conseiller conseiller) {
		super(nom, prenom, identifiant, null, null, null, null, null, null);
		this.conseiller=conseiller;
	}


	// #region Accesseurs
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

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	// #endregion
	
	// #region Utilitaire
	

	@Override
	public String toString() {
		return "Client [getConseiller()=" + getConseiller() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getIdentifiant()=" + getIdentifiant() + "]";
	}
	
	//	#endregion
	
	public boolean hasCompte(Long noCompte){
		if (!this.getListeComptes().isEmpty()){
			for (Compte compte : listeComptes) {
				if (compte.getNoCompte()==noCompte){
					return true;
				}
			}
		}
		return false;
	}


	
	
}
