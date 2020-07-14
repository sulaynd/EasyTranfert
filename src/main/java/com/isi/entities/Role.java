package com.isi.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role implements Serializable {
	
	@Id @GeneratedValue
	private Long idrole;
	private String libelerole;
	
	@OneToMany(mappedBy="role",fetch=FetchType.LAZY)
	private Collection<User> users;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String libelerole) {
		super();
		this.libelerole = libelerole;
	}

	public Long getIdrole() {
		return idrole;
	}

	public void setIdrole(Long idrole) {
		this.idrole = idrole;
	}

	public String getLibelerole() {
		return libelerole;
	}

	public void setLibelerole(String libelerole) {
		this.libelerole = libelerole;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	

}
