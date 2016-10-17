package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="debit")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Debit")
public class Debit extends Transaction {
	
	public Debit(){
		
	}

	public Debit(Integer montant, String libelle, Date date) {
		super(montant, libelle, date);
		// TODO Auto-generated constructor stub
	}
	
	

}
