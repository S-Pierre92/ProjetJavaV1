package com.wheeludrive.entity.manager;

import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.exception.PropertyException;

public class UtilisateurManager extends AbstractManager {
	
	private static final String PERSISTENCE_UNIT = "wheeludrive";
	
	public static void createUtilisateur(Utilisateur user) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(user);
		closeResources();
	}

}
