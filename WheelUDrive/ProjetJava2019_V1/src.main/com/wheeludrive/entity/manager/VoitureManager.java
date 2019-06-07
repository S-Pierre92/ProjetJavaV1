package com.wheeludrive.entity.manager;

import com.wheeludrive.entity.Couleur;
import com.wheeludrive.entity.Marque;
import com.wheeludrive.entity.Media;
import com.wheeludrive.entity.Modele;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.exception.PropertyException;

public class VoitureManager extends AbstractManager {

	private static final String PERSISTENCE_UNIT = "wheeludrive";

	public static void createMarque(Marque marque) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(marque);
		closeResources();
	}

	public static void createModel(Modele model) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(model);
		closeResources();
	}

	public static void createCouleur(Couleur couleur) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(couleur);
		closeResources();
	}

	public static void createVoiture(Voiture voiture) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(voiture);
		closeResources();
	}

	public static Modele findModele(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		Modele modele = entitymanager.find(Modele.class, id);
		closeResources();
		return modele;
	}

	public static Marque findMarque(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		Marque marque = entitymanager.find(Marque.class, id);
		closeResources();
		return marque;
	}

	public static Couleur findCouleur(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		Couleur couleur = entitymanager.find(Couleur.class, id);
		closeResources();
		return couleur;
	}

	public static void createMedia(Media media) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(media);
		closeResources();
	}

	public static Media findMedia(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		Media media = entitymanager.find(Media.class, id);
		closeResources();
		return media;
	}
	
	public static Voiture findVoiture(int id) throws PropertyException {
		
		prepareEntityManager(PERSISTENCE_UNIT);
		Voiture voiture = entitymanager.find(Voiture.class, id);
		closeResources();
		return voiture;
	}

}
