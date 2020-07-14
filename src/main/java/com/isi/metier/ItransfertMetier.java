package com.isi.metier;

import java.util.Collection;


import com.isi.entities.Compte;
import com.isi.entities.Guichet;
import com.isi.entities.Operation;
import com.isi.entities.Prestataire;
import com.isi.entities.Role;
import com.isi.entities.Transfert;
import com.isi.entities.User;
import com.isi.entities.UserBack;

public interface ItransfertMetier {
	public void addprestataire(Prestataire p);
	public void addcompte(Compte c);
	public void addguichet(Guichet g);
	public void addrole(Role r);
	public void adduser(User u);
	public void adduserback(UserBack u);
	
	public void deleterole(Role r);
	public void deleteprestatair(Prestataire p);
	public void deletecompte(Compte c);
	public void deleteguichet(Guichet g);
	public void deleteuser(User u);
	

	public Collection<Prestataire> listPrestataires();
	public void deleteprestataire(Long idpres);
	public Prestataire consulterprestataire(Long idpres);
	
	public Collection<Compte> listcompte(Prestataire p);
	public Collection<Compte> listcomptetot();
	public Collection<Guichet> listguichet();
	
	
	public Collection<Role> listrole();
	public Role consulterrole(Long idrole);
	
	public Collection<Operation> listoperation(Long idcompte);
	
	public Compte consultercompte(Long idcompte);
	public Guichet consulterguichet(Long idguichet);
	public User consulteruser(Long idguichet);
	
	public Collection<User> listusercompte(Compte c);
	public Collection<User> listuser();
	public Collection<UserBack> listuserback();
	
	public void versement (Long idcompte, double montant, UserBack userback);
	public void retrait (Long idcompte, double montant, UserBack userback);
	public void envoi (Long idcompte, Transfert t);
	
	public void sendSMS(String numtel, String message);
	
}
