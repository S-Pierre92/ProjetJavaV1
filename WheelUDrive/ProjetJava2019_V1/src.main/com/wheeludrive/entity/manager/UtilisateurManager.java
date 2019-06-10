package com.wheeludrive.entity.manager;


import java.util.List;

import javax.persistence.TypedQuery;

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
	
	public static int findUserId(String prenom, String nom) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		
		TypedQuery<Integer> query = entitymanager.createQuery("SELECT u.id FROM Utilisateur u WHERE u.nom = :nom AND "
				+ "u.prenom = :prenom", Integer.class);
		
		query.setParameter("nom", nom);
		query.setParameter("prenom", prenom);
		
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
}
