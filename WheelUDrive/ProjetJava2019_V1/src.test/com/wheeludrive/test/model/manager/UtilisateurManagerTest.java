package com.wheeludrive.test.model.manager;

import java.util.Date;

import org.junit.Test;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.AdresseUtilisateur;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.manager.PaysAdresseManager;
import com.wheeludrive.entity.manager.PermissionsAndRoleManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.exception.PropertyException;

public class UtilisateurManagerTest {
	
	@Test
	public void createUtilisateur() throws PropertyException {
		
		
		Utilisateur user = new Utilisateur();
		
		user.setActif(true);
		user.setDateInscription(new Date());
		user.setDateDerniereModification(new Date());
		user.setMdp("pikachu");
		user.setNom("Cesar");
		user.setPrenom("Jules");
		user.setEmail("Jules.Cesar@mail.com");
		user.setSupprime(false);
		user.setRole(PermissionsAndRoleManager.findRole(1));
		
		UtilisateurManager.createUtilisateur(user);
		
	}
	
	@Test
	public void findUtilisateur() throws PropertyException {
		
		Utilisateur user = UtilisateurManager.findUtilisateur(1);
		
		System.out.println(user.getId() + " " +user.getPrenom() + " " + user.getNom());
		
		
	}
	
	@Test
	public void createAdresseUtilisateur() throws PropertyException {
		
		Adresse adresse = PaysAdresseManager.findAdresse(1);
		Utilisateur user = UtilisateurManager.findUtilisateur(1);
		
		UtilisateurManager.createAdresseUtilisateur(adresse, user);
	}

	@Test
	public void findAdressesUtilisateur() throws PropertyException {
		
		Utilisateur user = UtilisateurManager.findUtilisateur(1);
		
		for(AdresseUtilisateur adrUser : user.getAdressesUtilisateurs()) {
			
			Adresse adresse = adrUser.getAdresse();
			System.out.println(adresse.getNumero() + ", "+ adresse.getRue() + " " + adresse.getVille());
		}
	}

}
