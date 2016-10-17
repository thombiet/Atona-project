package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table (name="credit")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Credit")
public class Credit extends Transaction {
	
	public Credit(){
		
	}

	public Credit(Integer montant, String libelle, Date date) {
		super(montant, libelle, date);
		// TODO Auto-generated constructor stub
	}

}
