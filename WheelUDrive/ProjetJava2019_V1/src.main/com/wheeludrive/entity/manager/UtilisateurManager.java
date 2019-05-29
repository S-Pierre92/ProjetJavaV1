package com.wheeludrive.entity.manager;


import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.AdresseUtilisateur;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.exception.PropertyException;

public class UtilisateurManager extends AbstractManager {
	
	private static final String PERSISTENCE_UNIT = "wheeludrive";
	
	public static void createUtilisateur(Utilisateur user) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(user);
		closeResources();
	}
	
	public static Utilisateur findUtilisateur(int id) throws PropertyException {
		prepareEntityManager(PERSISTENCE_UNIT);
		Utilisateur user = entitymanager.find(Utilisateur.class, id);
		closeResources();
		return user;
		
	}
	
	public static void createAdresseUtilisateur(Adresse adresse, Utilisateur utilisateur) throws PropertyException {
		prepareEntityManager(PERSISTENCE_UNIT);
		AdresseUtilisateur adressUser = new AdresseUtilisateur();
		adressUser.setAdresse(adresse);
		adressUser.setUtilisateur(utilisateur);
		
		entitymanager.persist(adressUser);
		closeResources();
	}
}
