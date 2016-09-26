package com.wha.springmvc.model;

import java.util.List;

public class Administrateur extends Utilisateur {
	
	private List<Conseiller> listeConseillers;
	private List<DemandeOuverture> listeDemandes;
	
	public Administrateur(){
		
	}

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

}
