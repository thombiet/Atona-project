package com.wha.springmvc.model;

import java.io.File;
import java.util.List;

public class Client extends Utilisateur {

	private List<Compte> listeComptes;
	private File piecesJustificatives;
	private Integer revenuMensuel;
	private Conseiller conseiller;

	public Client() {
		super();
	}

	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

	public File getPiecesJustificatives() {
		return piecesJustificatives;
	}

	public void setPiecesJustificatives(File piecesJustificatives) {
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

}
