package com.isi.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Prestataire implements Serializable {
	
	@Id @GeneratedValue
	private Long idpres;
	
	private String nompres;
	private String prenompres;
	private String cnipres;
	private String adresspres;
	private String telpres;
	private String loginpres;
	private String passwordpres;
	
	@OneToMany(mappedBy="prestataire",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;

	public Prestataire() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Prestataire(String nompres, String prenompres, String cnipres, String adresspres, String telpres,
			String loginpres, String passwordpres) {
		super();
		this.nompres = nompres;
		this.prenompres = prenompres;
		this.cnipres = cnipres;
		this.adresspres = adresspres;
		this.telpres = telpres;
		this.loginpres = loginpres;
		this.passwordpres = passwordpres;
	}



	public String getTelpres() {
		return telpres;
	}



	public void setTelpres(String telpres) {
		this.telpres = telpres;
	}



	public String getLoginpres() {
		return loginpres;
	}



	public void setLoginpres(String loginpres) {
		this.loginpres = loginpres;
	}



	public String getPasswordpres() {
		return passwordpres;
	}



	public void setPasswordpres(String passwordpres) {
		this.passwordpres = passwordpres;
	}



	public Long getIdpres() {
		return idpres;
	}

	public void setIdpres(Long idpres) {
		this.idpres = idpres;
	}

	public String getNompres() {
		return nompres;
	}

	public void setNompres(String nompres) {
		this.nompres = nompres;
	}

	public String getPrenompres() {
		return prenompres;
	}

	public void setPrenompres(String prenompres) {
		this.prenompres = prenompres;
	}

	public String getCnipres() {
		return cnipres;
	}

	public void setCnipres(String cnipres) {
		this.cnipres = cnipres;
	}

	public String getAdresspres() {
		return adresspres;
	}

	public void setAdresspres(String adresspres) {
		this.adresspres = adresspres;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	

	
}
