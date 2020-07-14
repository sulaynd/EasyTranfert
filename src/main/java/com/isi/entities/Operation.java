package com.isi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="typeOper", discriminatorType=DiscriminatorType.STRING,length=20)
public abstract class Operation implements Serializable {
	
	@Id @GeneratedValue
	private Long idoper;
	private Date dateoper;
	private double montantoper;
	
	@ManyToOne
	@JoinColumn(name="idcompte")
	private Compte compte;
	
	

	
	public Operation(Date dateoper, double montantoper, Compte compte) {
		super();
		this.dateoper = dateoper;
		this.montantoper = montantoper;
		this.compte = compte;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Long getIdoper() {
		return idoper;
	}

	public void setIdoper(Long idoper) {
		this.idoper = idoper;
	}

	public Date getDateoper() {
		return dateoper;
	}

	public void setDateoper(Date dateoper) {
		this.dateoper = dateoper;
	}

	public double getMontantoper() {
		return montantoper;
	}

	public void setMontantoper(double montantoper) {
		this.montantoper = montantoper;
	}

	



	
	
	
	

}
