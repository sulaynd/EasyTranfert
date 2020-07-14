package com.isi.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RTIB")
public class RetraitIb extends Operation{
	
	@ManyToOne
	@JoinColumn(name="iduserback")
	private UserBack userback;
	

	
	public RetraitIb() {
		super();
		// TODO Auto-generated constructor stub
	}



	public RetraitIb(Date dateoper, double montantoper, Compte compte) {
		super(dateoper, montantoper, compte);
		// TODO Auto-generated constructor stub
	}



	


	



	

	

}
