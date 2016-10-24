package com.wha.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="requete")
public class Requete {
	// #region Attributs
	
	@Id
	@Column (name="type")
	private TypeRequete type;
	@ManyToOne
	@JoinColumn(name="no_compte",referencedColumnName="noCompte")
	private Compte compte;
	/*@ManyToOne
	@JoinColumn(name="id_client",referencedColumnName="identifiant")
	private Client client;*/
	
	@Column (name="message")
	private String message;
	// #endregion

	// #region Constructeurs
	public Requete() {

	}
	// #endregion

	// #region Accesseurs
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

	/*public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}*/

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	// #endregion

	// #region Utilitaire
	
		@Override
		public String toString() {
			return "Requete [type=" + type + ", compte=" + compte + ", message=" + message + "]";
		}
		
		// #endregion
}
