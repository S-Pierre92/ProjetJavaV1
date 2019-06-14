package com.wheeludrive.entity.manager;


import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.AdresseUtilisateur;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.exception.PropertyException;

public class UtilisateurManager extends AbstractManager {
	
	private static final String PERSISTENCE_UNIT = "wheeludrive";
	private final static Logger log = Logger.getLogger(UtilisateurManager.class);
	
	
	public static void createUtilisateur(Utilisateur user) throws PropertyException {

		if(findUserId(user.getEmail())!=-1) {
			log.info("Cet utilisateur existe déjà");
			return;
		}
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
	
	public static int findUserId(String mail) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		
		TypedQuery<Integer> query = entitymanager.createQuery("SELECT u.id FROM Utilisateur u WHERE u.email = :email", Integer.class);
		
		query.setParameter("email", mail);
		
		List<Integer> results = query.getResultList();
		
		int id;
		
		if(results.isEmpty()) {
			id = -1;
		}
		else {
			id = results.get(0);
		}
		closeResources();
		return id;
	}
	public static String findUserPswd(String mail) throws PropertyException {
		
		prepareEntityManager(PERSISTENCE_UNIT);
		
		TypedQuery<String> query = entitymanager.createQuery("SELECT u.mdp FROM Utilisateur u WHERE u.email = :email", String.class);
		
		query.setParameter("email", mail);
		
		List<String> results = query.getResultList();
		
		String pswd ;
		
		if(results.isEmpty()) {
			pswd = "";
		}
		else {
			pswd = results.get(0);
		}
		closeResources();
		return pswd;  
	}
	
	public static void updateUtilisateur(Utilisateur user) throws PropertyException{
		prepareEntityManager(PERSISTENCE_UNIT);

		Utilisateur newUser = entitymanager.find(Utilisateur.class, user.getId());
		newUser = user;
		entitymanager.merge(newUser);
		closeResources();
	}
}
