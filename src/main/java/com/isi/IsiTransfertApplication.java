package com.isi;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.isi.entities.Compte;
import com.isi.entities.Guichet;
import com.isi.entities.Prestataire;
import com.isi.entities.Role;
import com.isi.entities.Transfert;
import com.isi.entities.User;
import com.isi.metier.ItransfertMetier;


@SpringBootApplication
public class IsiTransfertApplication implements CommandLineRunner {
	

	@Autowired
	private ItransfertMetier transfertMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(IsiTransfertApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Role r1=new Role("Administrateur");
		transfertMetier.addrole(r1);
		Role r2=new Role("Controlleur");
		transfertMetier.addrole(r2);
		Role r3=new Role("Superviseurzone");
		transfertMetier.addrole(r3);
		Role r4=new Role("Prestataire");
		transfertMetier.addrole(r4);
		Role r5=new Role("Superviseur");
		transfertMetier.addrole(r5);
		Role r6=new Role("Guichetier");
		transfertMetier.addrole(r6);
		

	    
	   Prestataire p1= new Prestataire("DIOP","Abdou ","124563214521","Dakar","773134607","abdou","admin");
	    transfertMetier.addprestataire(p1);
	    
	    Compte c1= new Compte("3221", new Date(), 24, 26, 200000, 150000, p1);
	    transfertMetier.addcompte(c1);
	    
	    User u1= new User("TALL", "Ibrahima", "774243032", "ibou", "niassebaye", "1", r4, c1);
	    transfertMetier.adduser(u1);
	    
	    User u2=new User("Deme", "baba", "774245656", "baba", "123546", "1", r6, c1);
	    transfertMetier.adduser(u2);

		Guichet g1 = new Guichet(c1, u2);
		transfertMetier.addguichet(g1);
	    
	    Prestataire p2= new Prestataire("DIOP","Abdou salam","124563214521","Nioro","773134607","salam","admin");
	    transfertMetier.addprestataire(p2);
	  
	   
	   
	    
	    
	   
	    
	    

	}

	
}
