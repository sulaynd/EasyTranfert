package com.isi.metier;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Date;
import java.net.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.isi.dao.CompteRepository;
import com.isi.dao.GuichetRepository;
import com.isi.dao.OperationRepository;
import com.isi.dao.PrestataireRepository;
import com.isi.dao.RoleRepository;
import com.isi.dao.UserBackRepository;
import com.isi.dao.UserRepository;
import com.isi.entities.Compte;
import com.isi.entities.Guichet;
import com.isi.entities.Operation;
import com.isi.entities.Prestataire;
import com.isi.entities.RetraitIb;
import com.isi.entities.Role;
import com.isi.entities.Transfert;
import com.isi.entities.User;
import com.isi.entities.UserBack;
import com.isi.entities.Versement;

@Service
@Transactional
public class TransfertMetierImpl implements ItransfertMetier {
	
	@Autowired
	private PrestataireRepository prestataireRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private GuichetRepository guichetRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserBackRepository userBackRepository;
	
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public void addprestataire(Prestataire p) {
		prestataireRepository.save(p);
		
	}

	@Override
	public void addcompte(Compte c) {
		compteRepository.save(c);
		
		
	}

	@Override
	public void addguichet(Guichet g) {
		guichetRepository.save(g);
		
	}

	@Override
	public void addrole(Role r) {
		roleRepository.save(r);
		
	}

	@Override
	public void adduser(User u) {
		userRepository.save(u);
		
	}

	@Override
	public void deleterole(Role r) {
		roleRepository.delete(r);
		
	}

	@Override
	public void deleteprestatair(Prestataire p) {
		prestataireRepository.delete(p);
		
	}

	@Override
	public void deletecompte(Compte c) {
		compteRepository.delete(c);
		
	}

	@Override
	public void deleteguichet(Guichet g) {
		guichetRepository.delete(g);
		
		
	}

	@Override
	public void deleteuser(User u) {
		userRepository.delete(u);
		
	}

	@Override
	public Collection<Prestataire> listPrestataires() {
		// TODO Auto-generated method stub
		return prestataireRepository.findAll();
	}

	@Override
	public void deleteprestataire(Long idpres) {
		prestataireRepository.delete(idpres);
		
	}

	@Override
	public Prestataire consulterprestataire(Long idpres) {
		Prestataire p1=prestataireRepository.findOne(idpres);
		return p1;
	}

	@Override
	public Collection<Compte> listcompte(Prestataire p) {	
		
	 return compteRepository.findAll();
	}

	@Override
	public Collection<Role> listrole() {
		
		return roleRepository.findAll();
	}

	@Override
	public Role consulterrole(Long idrole) {
		
		return roleRepository.findOne(idrole);
	}

	@Override
	public Compte consultercompte(Long idcompte) {
		
		return compteRepository.findOne(idcompte);
	}

	@Override
	public Collection<User> listusercompte(Compte c) {
		
		return userRepository.findAll();
	}

	@Override
	public void versement(Long idcompte, double montant, UserBack userback) {
		
		Compte cp = consultercompte(idcompte);
		if(cp.getSolde()+montant<=cp.getPlafondcompte()){
		cp.setSolde(cp.getSolde()+montant);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		compteRepository.save(cp);
		} 
	}

	@Override
	public void retrait(Long idcompte, double montant, UserBack userback) {
		
		Compte cp = consultercompte(idcompte);
		if(cp.getSolde()>=montant)
		{
			if(cp.getSolde()-montant>=0){
			cp.setSolde(cp.getSolde()-montant);
			RetraitIb rib= new RetraitIb(new Date(),montant,cp);
			operationRepository.save(rib);
			compteRepository.save(cp);
			}
		}
		
		
		
	}

	@Override
	public Collection<Compte> listcomptetot() {
		
		return compteRepository.findAll();
	}

	@Override
	public Collection<User> listuser() {
		
		return userRepository.findAll();
	}

	@Override
	public void adduserback(UserBack u) {
		
		userBackRepository.save(u);
		
	}

	@Override
	public Collection<UserBack> listuserback() {
		
		return userBackRepository.findAll();
	}

	@Override
	public Collection<Guichet> listguichet() {
		
		return guichetRepository.findAll();
	}

	@Override
	public void envoi(Long idcompte, Transfert t) {
		    
		    Compte cp = consultercompte(idcompte);
		    double frais = 200;
		    if(t.getMontantoper()+frais<cp.getSolde()){
		    	cp.setSolde(cp.getSolde()-(t.getMontantoper()+frais));
		    	operationRepository.save(t);
				compteRepository.save(cp);
		    }
		    
			
		
	}

	@Override
	public Guichet consulterguichet(Long idguichet) {
		
		return guichetRepository.findOne(idguichet);
	}

	@Override
	public User consulteruser(Long idguichet) {
		
		return userRepository.findOne(idguichet);
	}

	@Override
	public Collection<Operation> listoperation(Long idcompte) {
		
		Compte c= compteRepository.findOne(idcompte);
		return c.getOperation();
	}

	@Override
	public void sendSMS(String numtel, String message) {

		try {
			String user = "tourearc";
			String password = "arctoure2013";
			String to = "+221"+numtel;
			String text = message;
			
			String requestUrl="http://secure.oceanic-sms.com/api/http/sendmsg.php?user="+ URLEncoder.encode(user, "UTF-8")+"&password="+URLEncoder.encode(password, "UTF-8")+"&from=EasyTransfert&to="+URLEncoder.encode(to,"UTF-8")+"&text="+URLEncoder.encode(text,"UTF-8")+"&api=1234";

			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection)url.openConnection();
			System.out.println(uc.getResponseMessage());
			uc.disconnect();
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			}
		
	}

	

	
	
		
	

}
