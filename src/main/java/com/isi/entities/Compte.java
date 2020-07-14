package com.isi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Compte implements Serializable {
	
	@Id @GeneratedValue
	private Long idcompte;
	
	private String numerocompte;
	private String nomcompte;
	private String regioncompte;
	private String adressecompte;
	private Date datecreacompte;
	private double tauxenvoi;
	private double tauxretrait;
	private double plafondcompte;
	private double solde;
	private String etat;
	
	public Compte() {
		super();
		this.etat = etat;
	}

	@ManyToOne
	@JoinColumn(name="codepres")
	private Prestataire prestataire;
	
	@OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
	private Collection<Operation> operation;
	
	@OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
	private Collection<Guichet> guichets;
	
	@OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
	private Collection<User> users;
	
	
	
	



	

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Compte(String s, Date date, int i, int i1, int i2, int i3, Prestataire p1) {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getNomcompte() {
		return nomcompte;
	}

	public void setNomcompte(String nomcompte) {
		this.nomcompte = nomcompte;
	}

	public String getRegioncompte() {
		return regioncompte;
	}

	public void setRegioncompte(String regioncompte) {
		this.regioncompte = regioncompte;
	}

	public String getAdressecompte() {
		return adressecompte;
	}

	public void setAdressecompte(String adressecompte) {
		this.adressecompte = adressecompte;
	}

	public Compte(String numerocompte, String nomcompte, String regioncompte, String adressecompte, Date datecreacompte,
			double tauxenvoi, double tauxretrait, double plafondcompte, double solde, String etat, Prestataire prestataire) {
		super();
		this.numerocompte = numerocompte;
		this.nomcompte = nomcompte;
		this.regioncompte = regioncompte;
		this.adressecompte = adressecompte;
		this.datecreacompte = datecreacompte;
		this.tauxenvoi = tauxenvoi;
		this.tauxretrait = tauxretrait;
		this.plafondcompte = plafondcompte;
		this.solde = solde;
		this.etat = etat;
		this.prestataire = prestataire;
	}

	public String getEtat() {
		return etat;
	}

	public Collection<Operation> getOperation() {
		return operation;
	}

	public void setOperation(Collection<Operation> operation) {
		this.operation = operation;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Long getIdcompte() {
		return idcompte;
	}

	public void setIdcompte(Long idcompte) {
		this.idcompte = idcompte;
	}

	public String getNumerocompte() {
		return numerocompte;
	}

	public void setNumerocompte(String numerocompte) {
		this.numerocompte = numerocompte;
	}

	public Date getDatecreacompte() {
		return datecreacompte;
	}

	public void setDatecreacompte(Date datecreacompte) {
		this.datecreacompte = datecreacompte;
	}

	public double getTauxenvoi() {
		return tauxenvoi;
	}

	public void setTauxenvoi(double tauxenvoi) {
		this.tauxenvoi = tauxenvoi;
	}

	public double getTauxretrait() {
		return tauxretrait;
	}

	public void setTauxretrait(double tauxretrait) {
		this.tauxretrait = tauxretrait;
	}

	public double getPlafondcompte() {
		return plafondcompte;
	}

	public void setPlafondcompte(double plafondcompte) {
		this.plafondcompte = plafondcompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

	public Collection<Guichet> getGuichets() {
		return guichets;
	}

	public void setGuichets(Collection<Guichet> guichets) {
		this.guichets = guichets;
	}

	

	

	
	

}
