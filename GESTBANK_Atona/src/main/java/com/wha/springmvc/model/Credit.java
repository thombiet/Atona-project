package com.wha.springmvc.model;

import java.util.Date;

public class Credit extends Transaction {
	
	public Credit(){
		
	}

	public Credit(Integer montant, String libelle, Date date) {
		super(montant, libelle, date);
		// TODO Auto-generated constructor stub
	}

}
