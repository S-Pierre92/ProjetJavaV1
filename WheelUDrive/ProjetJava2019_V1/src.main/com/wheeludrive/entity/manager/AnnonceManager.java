package com.wheeludrive.entity.manager;

import com.wheeludrive.entity.Annonce;
import com.wheeludrive.exception.PropertyException;

public class AnnonceManager extends AbstractManager {

	private static final String PERSISTENCE_UNIT = "wheeludrive";

	public static void createAnnonce(Annonce annonce) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(annonce);
		closeResources();
	}

	public static void updateAnnonce(Annonce annonce) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		@SuppressWarnings("unused")
		Annonce annonceInit = entitymanager.find(Annonce.class, annonce.getId());
		annonceInit = annonce;
		entitymanager.merge(annonce);
		closeResources();
	}
	
	public static Annonce findAnnonce(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		Annonce annonce = entitymanager.find(Annonce.class, id);
		closeResources();
		return annonce;
	}

}
