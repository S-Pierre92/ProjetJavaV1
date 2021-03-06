package com.wheeludrive.entity.manager;


import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.AdresseUtilisateur;
import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.exception.PropertyException;

public class UtilisateurManager extends AbstractManager {
	
	private final static Logger log = Logger.getLogger(UtilisateurManager.class);
	
	
	public static int createUtilisateur(Utilisateur user) throws PropertyException {

		if(findUserId(user.getEmail())!=-1) {
			log.info("Cet utilisateur existe deja�");
			return -1;
		}
		prepareEntityManager();
		entitymanager.persist(user);
		entitymanager.flush();
		int id = user.getId();
		closeResources();
		return id;
	}
	
	public static Utilisateur findUtilisateur(int id) throws PropertyException {
		prepareEntityManager();
		Utilisateur user = entitymanager.find(Utilisateur.class, id);
		entitymanager.refresh(user);   // Pour �tre sur que l'objet retourn� correspond bien � celui de la DB
		log.info("On refresh le user...");
		closeResources();
		return user;
		
	}
	
	public static void createAdresseUtilisateur(Adresse adresse, Utilisateur utilisateur) throws PropertyException {
		prepareEntityManager();
		AdresseUtilisateur adressUser = new AdresseUtilisateur();
		adressUser.setAdresse(adresse);
		adressUser.setUtilisateur(utilisateur);
		
		entitymanager.persist(adressUser);
		closeResources();
	}
	
	public static int findUserId(String mail) throws PropertyException {

		prepareEntityManager();
		
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
		
		prepareEntityManager();
		
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
	public static String findUserPswdID(int userId) throws PropertyException {
		
		prepareEntityManager();
		
		TypedQuery<String> query = entitymanager.createQuery("SELECT u.mdp FROM Utilisateur u WHERE u.id = :id", String.class);
		
		query.setParameter("id", userId);
		
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
	public static boolean checkLimitVentes(int userId) throws PropertyException {
		
		prepareEntityManager();
	
		TypedQuery<Annonce> query = entitymanager.createQuery("SELECT a FROM Annonce a WHERE a.utilisateur.id = :id ", Annonce.class);
		
		query.setParameter("id", userId);
		
		List<Annonce> results = query.getResultList();
		closeResources();
		Date dateActuel = new Date();
		int i = 0;
		for(Annonce annonce : results) {
			long diffInMillies = Math.abs(dateActuel.getTime() - annonce.getDatePublication().getTime());
			long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			//si diff < 30 i++
			if(diff<30) {
				i++;
			}
			
		}
		if(i==3) {
			return false;
		}
		return true; 
	}
	
	public static void updateUtilisateur(Utilisateur user) throws PropertyException{
		prepareEntityManager();

		Utilisateur newUser = entitymanager.find(Utilisateur.class, user.getId());
		newUser = user;
		entitymanager.merge(newUser);
		closeResources();
	}
}
