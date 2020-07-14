package com.isi.web;





import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.isi.dao.CompteRepository;
import com.isi.entities.Compte;
import com.isi.entities.Guichet;
import com.isi.entities.Operation;
import com.isi.entities.Prestataire;
import com.isi.entities.Role;
import com.isi.entities.Transfert;
import com.isi.entities.User;
import com.isi.entities.UserBack;
import com.isi.metier.ItransfertMetier;




@Controller
public class IsiTransfertController {
	
	@Autowired
	private ItransfertMetier tranfertMetier;
	
    
	@RequestMapping(value="administrateur", method=RequestMethod.GET)
	public String administrateur(Model model){
		Collection<Role> listrole=tranfertMetier.listrole();
		model.addAttribute("listroles",listrole);
		Collection<UserBack> u =tranfertMetier.listuserback();
		model.addAttribute("listusers",u);
			
		return "admin/administrateur";
	}
	
	@RequestMapping(value="addadmin", method=RequestMethod.GET)
	public String addadmin(Model model,String nomadmin, String prenomadmin, String teladmin, Long roleuser, String identifiantadmin, String passwordadmin ){
	
			Role r =tranfertMetier.consulterrole(roleuser);
			UserBack ub = new UserBack(nomadmin, prenomadmin, teladmin,"", identifiantadmin, passwordadmin, "1", r);
			tranfertMetier.adduserback(ub);
			
		return "redirect:administrateur";
		
	}
	
	@RequestMapping(value="controleur", method=RequestMethod.GET)
	public String controleur(Model model,String nomadmin, String prenomadmin, String teladmin, Long roleuser,String zone, String identifiantadmin, String passwordadmin ){
		
		
		Collection<Role> listrole=tranfertMetier.listrole();
		model.addAttribute("listroles",listrole);
		
		Collection<UserBack> u =tranfertMetier.listuserback();
		model.addAttribute("listusers",u);
		
		
		
		return "admin/controleur";
	}
	
	@RequestMapping(value="addcontroleur", method=RequestMethod.GET)
	public String addcontroleur(Model model,String nomadmin, String prenomadmin, String teladmin, Long roleuser, String identifiantadmin, String passwordadmin ){
		Role r =tranfertMetier.consulterrole(roleuser);
		UserBack ub = new UserBack(nomadmin, prenomadmin, teladmin,"", identifiantadmin, passwordadmin, "1", r);
		tranfertMetier.adduserback(ub);
		return "redirect:controleur";
	}
	
	@RequestMapping(value="superviseurzone", method=RequestMethod.GET)
	public String superviseurzone(Model model,String nomadmin, String prenomadmin, String teladmin, Long roleuser,String zone, String identifiantadmin, String passwordadmin){
		
		Collection<Role> listrole=tranfertMetier.listrole();
		model.addAttribute("listroles",listrole);
		
		Collection<UserBack> u =tranfertMetier.listuserback();
		model.addAttribute("listusers",u);
		
		return "admin/superviseurzone";
	}
	
	@RequestMapping(value="addsuperviseurzone", method=RequestMethod.GET)
	public String addsuperviseurzone(Model model,String nomadmin, String prenomadmin, String teladmin, String zone, Long roleuser, String identifiantadmin, String passwordadmin ){
		Role r =tranfertMetier.consulterrole(roleuser);
		UserBack ub = new UserBack(nomadmin, prenomadmin, teladmin, zone, identifiantadmin, passwordadmin, "1", r);
		tranfertMetier.adduserback(ub);
		return "redirect:superviseurzone";
	}
	
	
	@RequestMapping("administration")
	public String index(){
		return "admin/logina";
	}
	
	@RequestMapping(value="prestataire", method=RequestMethod.GET)
	public String prestataire(Model model, String action){
		
		try {
			Collection<Prestataire> listpres=tranfertMetier.listPrestataires();
			model.addAttribute("listprestataire", listpres);
			
		} catch (Exception e) {
			model.addAttribute("exception",e);
		}

		return "admin/prestataire"; 
	}
	
	
	@RequestMapping(value="addprestataire", method=RequestMethod.GET)
	public String addprestataire(Model model,String nompres,String prenompres, String cnipres, String telpres,String adresspres, String identifiant, String password, String password2){
		
		Prestataire p1= new Prestataire(nompres,prenompres,cnipres,adresspres,telpres,identifiant,password);
		tranfertMetier.addprestataire(p1);
	
		
		return "redirect:prestataire";
	}
	
	@RequestMapping(value="addguichet", method=RequestMethod.GET)
	public String addguichet(Model model,Long idcompte,String respguichet, String telguichet, String typeguichet, String identifiantguichet,String passwdguichet,Long roleuser){
		Role r = tranfertMetier.consulterrole(roleuser);
		Compte c=tranfertMetier.consultercompte(idcompte);
		User u = new User(respguichet, "", telguichet, identifiantguichet, passwdguichet, "1", r, c);
		
		tranfertMetier.adduser(u);
		Guichet g1 = new Guichet(c, "1", u);
		tranfertMetier.addguichet(g1);
		
		return "redirect:prestataireSingleView?ida="+idcompte;
	}
	
	@RequestMapping(value="deleteprestataire", method=RequestMethod.GET)
	public String addprestataire(Model model,Long idp){
		
		Prestataire p1=tranfertMetier.consulterprestataire(idp);
		tranfertMetier.deleteprestatair(p1);
		
		
		
		return "redirect:prestataire";
	}
	
	@RequestMapping(value="editprestataire", method=RequestMethod.GET)
	public String editprestataire(Model model,Long idp){
		
		try {
			Collection<Prestataire> listpres=tranfertMetier.listPrestataires();
			model.addAttribute("listprestataire", listpres);
			
		} catch (Exception e) {
			model.addAttribute("exception",e);
		}
		
		model.addAttribute("idp", idp);
		Prestataire p1=tranfertMetier.consulterprestataire(idp);
		model.addAttribute("presta", p1);
		
		
		
		return "admin/prestataire";
	}
	
	
	
	@RequestMapping(value="prestataireSingle",method=RequestMethod.GET)
	public String prestataireSingle(Model model, Long idp){
		try {
			Prestataire p = tranfertMetier.consulterprestataire(idp);
			Collection<Compte> listcompte=p.getComptes();
			model.addAttribute("listcomptepres",listcompte);
		} catch (Exception e) {
			model.addAttribute("errorlist1",e);
		}
		
		try {
			Collection<Role> listrole=tranfertMetier.listrole();
			model.addAttribute("listroles",listrole);
		} catch (Exception e) {
			model.addAttribute("errorlist",e);
		}
		
		
		Prestataire p1=tranfertMetier.consulterprestataire(idp);
		model.addAttribute("presta", p1);
		
		return "admin/prestataireSingle";
	}
	
	@RequestMapping(value="versementcompte",method=RequestMethod.GET)
	public String versementcompte(Model model, Long ida,Double montant){
		
		try {
			Compte c=tranfertMetier.consultercompte(ida);
			UserBack ub =new UserBack();
			Collection<Role> listrole=tranfertMetier.listrole();
			Collection<User> lisu=c.getUsers();
			Collection<Guichet> listguichet=c.getGuichets();
			
			model.addAttribute("listroles",listrole);
			model.addAttribute("listguichets",listguichet);
			model.addAttribute("compte",c);
			model.addAttribute("users",lisu);
			model.addAttribute("vers",1);
			
			
			
			tranfertMetier.versement(ida, montant,ub);
			
		} catch (Exception e) {
			model.addAttribute("errorlistguichet",e);
		}
		
		return "admin/prestataireSingleView";
	}
	
	@RequestMapping(value="retraitcompte",method=RequestMethod.GET)
	public String retraitcompte(Model model, Long ida,Double montant){
		
		try {
			Compte c=tranfertMetier.consultercompte(ida);
			UserBack ub =new UserBack();
			Role r = new Role();
			long id=6;
			r.setIdrole(id);
			r.setLibelerole("Guichetier");
			
			Collection<Role> listrole=tranfertMetier.listrole();
			Collection<User> lisu=c.getUsers();
			Collection<Guichet> listguichet=c.getGuichets();
			
			model.addAttribute("listroles",listrole);
			model.addAttribute("listguichets",listguichet);
			model.addAttribute("compte",c);
			model.addAttribute("users",lisu);
			model.addAttribute("retrait",1);
			
			try {
				tranfertMetier.retrait(ida, montant, ub);
			} catch (Exception e) {
				model.addAttribute("error",e);
				
			}
			
			
		} catch (Exception e) {
			model.addAttribute("errorlistguichet",e);
		}
		
		return "admin/prestataireSingleView";
	}
	
	
	@RequestMapping(value="listoperations",method=RequestMethod.GET)
	public String listoperations(Model model, Long ida,Double montant){
		double somme;
		somme=0;
		try {
			Compte c=tranfertMetier.consultercompte(ida);
			UserBack ub =new UserBack();
			Role r = new Role();
			long id=6;
			r.setIdrole(id);
			r.setLibelerole("Guichetier");
			
			Collection<Role> listrole=tranfertMetier.listrole();
			Collection<User> lisu=c.getUsers();
			Collection<Guichet> listguichet=c.getGuichets();
			Collection<Operation> mesoperation=c.getOperation();
			
			model.addAttribute("listroles",listrole);
			model.addAttribute("somm",somme);
			model.addAttribute("listguichets",listguichet);
			model.addAttribute("compte",c);
			model.addAttribute("users",lisu);
			model.addAttribute("listopera",1);
			model.addAttribute("mesoper",mesoperation);
			
			try {
				tranfertMetier.retrait(ida, montant, ub);
			} catch (Exception e) {
				model.addAttribute("error",e);
				
			}
			
			
		} catch (Exception e) {
			model.addAttribute("errorlistguichet",e);
		}
		
		return "admin/prestataireSingleView";
	}
	
	
	
	
	@RequestMapping(value="prestataireSingleView",method=RequestMethod.GET)
	public String prestataireSingleView(Model model, Long ida){
		try {
			Compte c=tranfertMetier.consultercompte(ida);
			Role r = new Role();
			long id=6;
			r.setIdrole(id);
			r.setLibelerole("Guichetier");
			
			Collection<User> lisu=c.getUsers();
		
			Collection<Guichet> listguichet=c.getGuichets();
			
			model.addAttribute("listguichets",listguichet);
			model.addAttribute("compte",c);
			model.addAttribute("users",lisu);
			
		} catch (Exception e) {
			model.addAttribute("errorlistguichet",e);
		}
		
		try {
			Collection<Role> listrole=tranfertMetier.listrole();
			model.addAttribute("listroles",listrole);
		} catch (Exception e) {
			model.addAttribute("errorlist",e);
		}
		
		return "admin/prestataireSingleView";
	}
	
	@RequestMapping(value="addcompte", method=RequestMethod.GET)
	public String addcompte(Model model,Long idp,String nomcompte,String regioncompte, String adressecompte, Long tauxenvoicompte, Long tauxpaycompte, Long plafondcompte,String nomcompletuser,String teluser,Long roleuser,String identifiantuser, String passworduser, String passworduser2){
		
		try {
			Prestataire p=tranfertMetier.consulterprestataire(idp);
			Compte c = new Compte("CD1254", nomcompte, regioncompte, adressecompte, new Date(), tauxenvoicompte, tauxpaycompte, plafondcompte, 0,"1", p);
			Role r = tranfertMetier.consulterrole(roleuser);
			User u = new User(nomcompletuser, "", teluser, identifiantuser, passworduser, "1", r, c);
			
			tranfertMetier.addcompte(c);
			tranfertMetier.adduser(u);;
		} catch (Exception e) {
			model.addAttribute("erroraddcompte",e);
		}
		
		return "redirect:prestataireSingle?idp="+idp;
	}
	
	@RequestMapping("listeagences")
	public String listeagences(Model model){
		
		Collection<Compte> c=tranfertMetier.listcomptetot();
		model.addAttribute("compte",c);
		return "admin/listeagences";
	}
	
	@RequestMapping("homeadmin")
	public String homeadmin(Model model){
		Collection<Prestataire> p=tranfertMetier.listPrestataires();
		model.addAttribute("nbpres",p.size());
		model.addAttribute("listprestataire",p);
		
		Collection<Compte> c=tranfertMetier.listcomptetot();
		model.addAttribute("nbcp",c.size());
		model.addAttribute("compte",c);
		
		Collection<Guichet> g=tranfertMetier.listguichet();
		model.addAttribute("nbgui",g.size());
		
	
		return "admin/homeadmin";
	}
	

	@RequestMapping(value="client",method = RequestMethod.GET)
	public String client(){
		return "client/loginc";
	}
	
	@RequestMapping(value="homeclient",method = RequestMethod.GET)
	public String homeclient(Model model,Long login){
		Compte c =tranfertMetier.consultercompte(login);
		model.addAttribute("compte",c);
		//Compte c = tranfertMetier.consultercompte(g.getCompte().getIdcompte());
		
		
		return "client/homeclient";
	}
	
	@RequestMapping(value="envoi",method = RequestMethod.GET)
	public String envoi(Model model,Long idcompte){		
		Compte c =tranfertMetier.consultercompte(idcompte);
		String recu="0";
		model.addAttribute("compte",c);	
		model.addAttribute("recu",recu);	
		return "client/envoi";
	}
	
	@RequestMapping(value="envoitrans",method = RequestMethod.GET)
	public String envoitrans(Model model,Long idcompte,String paysender, String nomsender, String prenomsender, String telsender, Double montant,String piece, String paysrecep, String nomrecep, String prenomrecep, String telrecep, String adresserecep, String codesecret){		
		Compte c =tranfertMetier.consultercompte(idcompte);
		model.addAttribute("compte",c);	
		
		Guichet g = tranfertMetier.consulterguichet(idcompte);
		User u = g.getUser();
		
		//generarion du code
		Random rand = new Random();
		int num = rand.nextInt(900000000) + 100000000;
		String code =Integer.toString(num);
		
		Transfert t = new Transfert(new Date(), montant, c, paysender, nomsender, prenomsender, telsender, piece, paysrecep, nomrecep, prenomrecep, telrecep, adresserecep, codesecret, code, u, g);
		tranfertMetier.envoi(idcompte, t);
		String sms="Bienvenue chez Easy transfert "+prenomsender+" "+nomsender+" vous a envoye "+montant+" FCFA disponible dans toutes nos agences code: "+code;
		// envoi message
		tranfertMetier.sendSMS(telrecep, sms);
		
		return "redirect:envoi?idcompte="+idcompte;
	}
	
	@RequestMapping(value="recuenvoi", method = RequestMethod.GET)
	public String recuenvoi(Model model,Long idcompte){		
		Compte c =tranfertMetier.consultercompte(idcompte);
		model.addAttribute("compte",c);	

		return "client/recuenvoi";
	}
	
	
	@RequestMapping(value="retrait",method = RequestMethod.GET)
	public String retrait(Model model,Long idcompte){
		Compte c =tranfertMetier.consultercompte(idcompte);
		model.addAttribute("compte",c);
		return "client/retrait";
	}
	
	@RequestMapping(value="facture",method = RequestMethod.GET)
	public String facture(Model model,Long idcompte){
		Compte c =tranfertMetier.consultercompte(idcompte);
		model.addAttribute("compte",c);
		return "client/facture";
	}
	
	@RequestMapping(value="achat",method = RequestMethod.GET)
	public String achat(Model model,Long idcompte){
		Compte c =tranfertMetier.consultercompte(idcompte);
		model.addAttribute("compte",c);
		return "client/achat";
	}
	
	@RequestMapping(value="ewallet",method = RequestMethod.GET)
	public String ewallet(Model model,Long idcompte){
		Compte c =tranfertMetier.consultercompte(idcompte);
		model.addAttribute("compte",c);
		return "client/ewallet";
	}
	
	@RequestMapping(value="rapport",method = RequestMethod.GET)
	public String rapport(Model model,Long idcompte){
		Compte c =tranfertMetier.consultercompte(idcompte);
		model.addAttribute("compte",c);
		Collection<Operation> op =tranfertMetier.listoperation(idcompte);
		model.addAttribute("op",op);
		return "client/rapport";
	}
	
	

}
