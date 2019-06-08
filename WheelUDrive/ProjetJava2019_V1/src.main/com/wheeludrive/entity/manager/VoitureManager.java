package com.wheeludrive.entity.manager;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	
	public static void updateVoiture(Voiture voiture) throws PropertyException {
		prepareEntityManager(PERSISTENCE_UNIT);
		
		@SuppressWarnings("unused")
		Voiture voitureInit = entitymanager.find(Voiture.class, voiture.getId());
		voitureInit = voiture;
		entitymanager.merge(voiture);
		closeResources();
	}
	
	public static  List<Media> allVoitures() throws PropertyException {
		prepareEntityManager(PERSISTENCE_UNIT);
        CriteriaBuilder cb = entitymanager.getCriteriaBuilder();
        CriteriaQuery<Media> cq = cb.createQuery(Media.class);
        Root<Media> rootEntry = cq.from(Media.class);
        CriteriaQuery<Media> all = cq.select(rootEntry);
        TypedQuery<Media> allQuery = entitymanager.createQuery(all);
        List<Media> media = allQuery.getResultList();
        closeResources();
        return media;
 }
	
	public static void deleteMedia(Media media) throws PropertyException {
		
		prepareEntityManager(PERSISTENCE_UNIT);
		Media mediaToRemove = entitymanager.find(Media.class, media.getId());
		entitymanager.remove(mediaToRemove);
		closeResources();
	}

}
