package com.isi.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("ENVO")
public class Transfert extends Operation{
	
	private String paysender;
	private String nomsender;
	private String prenomsender;
	private String telsender;
	private String typepiece;
	
	private String paysrecep;
	private String nomrecep;
	private String prenomrecep;
	private String telrecep;
	private String adresserecep;
	private String codesret;
	
	private String codetrans;
	
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="idguichet")
	private Guichet guichet;
	
	
	
	
	public Transfert(Date dateoper, Double montantoper, Compte compte, String paysender, String nomsender,
			String prenomsender, String telsender, String typepiece, String paysrecep, String nomrecep,
			String prenomrecep, String telrecep, String adresserecep, String codesret, String codetrans, User user,
			Guichet guichet) {
		super(dateoper, montantoper, compte);
		this.paysender = paysender;
		this.nomsender = nomsender;
		this.prenomsender = prenomsender;
		this.telsender = telsender;
		this.typepiece = typepiece;
		this.paysrecep = paysrecep;
		this.nomrecep = nomrecep;
		this.prenomrecep = prenomrecep;
		this.telrecep = telrecep;
		this.adresserecep = adresserecep;
		this.codesret = codesret;
		this.codetrans = codetrans;
		this.user = user;
		this.guichet = guichet;
	}


	


	public Transfert() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public String getPaysender() {
		return paysender;
	}


	public void setPaysender(String paysender) {
		this.paysender = paysender;
	}


	public String getNomsender() {
		return nomsender;
	}


	public void setNomsender(String nomsender) {
		this.nomsender = nomsender;
	}


	public String getPrenomsender() {
		return prenomsender;
	}


	public void setPrenomsender(String prenomsender) {
		this.prenomsender = prenomsender;
	}


	public String getTelsender() {
		return telsender;
	}


	public void setTelsender(String telsender) {
		this.telsender = telsender;
	}


	public String getTypepiece() {
		return typepiece;
	}


	public void setTypepiece(String typepiece) {
		this.typepiece = typepiece;
	}


	public String getPaysrecep() {
		return paysrecep;
	}


	public void setPaysrecep(String paysrecep) {
		this.paysrecep = paysrecep;
	}


	public String getNomrecep() {
		return nomrecep;
	}


	public void setNomrecep(String nomrecep) {
		this.nomrecep = nomrecep;
	}


	public String getPrenomrecep() {
		return prenomrecep;
	}


	public void setPrenomrecep(String prenomrecep) {
		this.prenomrecep = prenomrecep;
	}


	public String getTelrecep() {
		return telrecep;
	}


	public void setTelrecep(String telrecep) {
		this.telrecep = telrecep;
	}


	public String getAdresserecep() {
		return adresserecep;
	}


	public void setAdresserecep(String adresserecep) {
		this.adresserecep = adresserecep;
	}


	public String getCodesret() {
		return codesret;
	}


	public void setCodesret(String codesret) {
		this.codesret = codesret;
	}


	public String getCodetrans() {
		return codetrans;
	}


	public void setCodetrans(String codetrans) {
		this.codetrans = codetrans;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Guichet getGuichet() {
		return guichet;
	}


	public void setGuichet(Guichet guichet) {
		this.guichet = guichet;
	}
	

	
	







	


	



	

	

}
