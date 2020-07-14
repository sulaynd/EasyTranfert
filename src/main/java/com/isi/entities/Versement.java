package com.isi.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("VERS")
public class Versement extends Operation{
	
	@ManyToOne
	@JoinColumn(name="iduserback")
	private UserBack userback;
	

	
	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Versement(Date dateoper, double montantoper, Compte compte) {
		super(dateoper, montantoper, compte);
		// TODO Auto-generated constructor stub
	}



	


	



	

	

}
