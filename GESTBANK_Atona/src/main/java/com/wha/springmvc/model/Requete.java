package com.wha.springmvc.model;

public class Requete {
	
	private TypeRequete type;
	private Compte compte;
	private Client client;
	private String message;

	public Requete() {

	}

	public TypeRequete getType() {
		return type;
	}

	public void setType(TypeRequete type) {
		this.type = type;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
