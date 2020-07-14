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
public class UserBack implements Serializable {
	
	@Id @GeneratedValue
	private Long iduser;
	
	private String nomuser;
	private String prenomuser;
	private String teluser;
	private String zone;
	private String loginuser;
	private String passworduser;
	private String statutuser;
	
	@ManyToOne
	@JoinColumn(name="roleuser")
	private Role role;
	
	@OneToMany(mappedBy="userback",fetch=FetchType.LAZY)
	private Collection<Versement> versements;
	
	@OneToMany(mappedBy="userback",fetch=FetchType.LAZY)
	private Collection<RetraitIb> retraitib;
	

	public Collection<Versement> getVersements() {
		return versements;
	}

	public Collection<RetraitIb> getRetraitib() {
		return retraitib;
	}

	public void setRetraitib(Collection<RetraitIb> retraitib) {
		this.retraitib = retraitib;
	}

	public void setVersements(Collection<Versement> versements) {
		this.versements = versements;
	}

	public UserBack() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserBack(String nomuser, String prenomuser, String teluser, String zone,String loginuser, String passworduser,
			String statutuser, Role role) {
		super();
		this.nomuser = nomuser;
		this.prenomuser = prenomuser;
		this.teluser = teluser;
		this.zone = zone;
		this.loginuser = loginuser;
		this.passworduser = passworduser;
		this.statutuser = statutuser;
		this.role = role;

	}



	public String getZone() {
		return zone;
	}


	public void setZone(String zone) {
		this.zone = zone;
	}






	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getNomuser() {
		return nomuser;
	}

	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}

	public String getPrenomuser() {
		return prenomuser;
	}

	public void setPrenomuser(String prenomuser) {
		this.prenomuser = prenomuser;
	}

	public String getTeluser() {
		return teluser;
	}

	public void setTeluser(String teluser) {
		this.teluser = teluser;
	}

	public String getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}

	public String getPassworduser() {
		return passworduser;
	}

	public void setPassworduser(String passworduser) {
		this.passworduser = passworduser;
	}

	public String getStatutuser() {
		return statutuser;
	}

	public void setStatutuser(String statutuser) {
		this.statutuser = statutuser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
