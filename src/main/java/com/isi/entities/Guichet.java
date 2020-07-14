package com.isi.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Guichet implements Serializable {
	
	@Id @GeneratedValue
	private Long numguichet;
	
	@ManyToOne
	@JoinColumn(name="numcompte")
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;
	
	@OneToMany(mappedBy="guichet",fetch=FetchType.LAZY)
	private Collection<Transfert> transfert;
	
	public Collection<Transfert> getTransfert() {
		return transfert;
	}



	public void setTransfert(Collection<Transfert> transfert) {
		this.transfert = transfert;
	}

	private String etatguichet;

	public Guichet(Compte c1, User u2) {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User getUser() {
		return user;
	}



	public String getEtatguichet() {
		return etatguichet;
	}



	public void setEtatguichet(String etatguichet) {
		this.etatguichet = etatguichet;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Guichet(Compte compte, String etatguichet, User user) {
		super();
		this.compte = compte;
		this.etatguichet= etatguichet;
		this.user = user;
	}



	public Long getNumguichet() {
		return numguichet;
	}

	public void setNumguichet(Long numguichet) {
		this.numguichet = numguichet;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	

}
