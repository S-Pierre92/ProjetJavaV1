package com.wheeludrive.entity.manager;

import java.util.List;

import javax.persistence.TypedQuery;

import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.CodePostal;
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
	public static int countAnnonces() throws PropertyException {
		
		prepareEntityManager(PERSISTENCE_UNIT);
		
		TypedQuery<Integer> query = entitymanager.createQuery("SELECT a.id FROM Annonce a", Integer.class);
		List<Integer> results = query.getResultList();
		closeResources();
		
		return results.size();
		}


}
