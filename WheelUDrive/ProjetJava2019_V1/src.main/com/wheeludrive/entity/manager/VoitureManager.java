package com.wheeludrive.entity.manager;

import java.util.List;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.Couleur;
import com.wheeludrive.entity.Marque;
import com.wheeludrive.entity.Media;
import com.wheeludrive.entity.Modele;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.exception.PropertyException;

public class VoitureManager extends AbstractManager {

	private final static Logger log = Logger.getLogger(VoitureManager.class);

	public static void createMarque(Marque marque) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(marque);
		closeResources();
	}

	public static int createModel(Modele model) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(model);
		entitymanager.flush();
		int id = model.getId();
		closeResources();
		return id;
	}

	public static void createCouleur(Couleur couleur) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(couleur);
		closeResources();
	}

	public static int createVoiture(Voiture voiture) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(voiture);
		entitymanager.flush();
		int id = voiture.getId();
		closeResources();
		return id;
	}

	public static Modele findModele(int id) throws PropertyException {

		prepareEntityManager();
		Modele modele = entitymanager.find(Modele.class, id);
		closeResources();
		return modele;
	}

	public static Marque findMarque(int id) throws PropertyException {

		prepareEntityManager();
		Marque marque = entitymanager.find(Marque.class, id);
		closeResources();
		return marque;
	}

	public static Couleur findCouleur(int id) throws PropertyException {

		prepareEntityManager();
		Couleur couleur = entitymanager.find(Couleur.class, id);
		closeResources();
		return couleur;
	}

	public static void createMedia(Media media) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(media);
		closeResources();
	}

	public static Media findMedia(int id) throws PropertyException {

		prepareEntityManager();
		Media media = entitymanager.find(Media.class, id);
		closeResources();
		return media;
	}

	public static Voiture findVoiture(int id) throws PropertyException {

		prepareEntityManager();
		Voiture voiture = entitymanager.find(Voiture.class, id);
		closeResources();
		return voiture;
	}

	

	public static List<Marque> allMarque() throws PropertyException {

		prepareEntityManager();

		TypedQuery<Marque> query = entitymanager.createQuery("SELECT m FROM Marque m", Marque.class);

		List<Marque> results = query.getResultList();

		closeResources();
		return results;
	}

	public static List<Modele> allModeleForMarque(int id) throws PropertyException {

		prepareEntityManager();

		TypedQuery<Modele> query = entitymanager.createQuery("SELECT m FROM Modele m WHERE m.marque.id = :id",
				Modele.class);

		query.setParameter("id", id);

		List<Modele> results = query.getResultList();

		closeResources();
		return results;
	}
	
	public static List<Modele> allModele() throws PropertyException {

		prepareEntityManager();

		TypedQuery<Modele> query = entitymanager.createQuery("SELECT m FROM Modele m",
				Modele.class);
		List<Modele> results = query.getResultList();
		log.info("listModle: "+results.size());

		closeResources();
		return results;
	}

	public static int findMarqueId(String nom) throws PropertyException {

		prepareEntityManager();

		TypedQuery<Integer> query = entitymanager.createQuery("SELECT m.id FROM Marque m WHERE m.nom = :marque",
				Integer.class);

		query.setParameter("marque", nom);

		List<Integer> results = query.getResultList();

		int id;

		if (results.isEmpty()) {
			id = -1;
		} else {
			id = results.get(0);
		}
		closeResources();
		return id;
	}

	public static void updateVoiture(Voiture voiture) throws PropertyException {
		prepareEntityManager();

		Voiture voitureInit = entitymanager.find(Voiture.class, voiture.getId());
		voitureInit = voiture;
		entitymanager.merge(voitureInit);
		closeResources();
	}

	public static List<Media> allMedias() throws PropertyException {
		prepareEntityManager();
		TypedQuery<Media> query = entitymanager.createQuery("SELECT m FROM Media m", Media.class);
		List<Media> results = query.getResultList();
		closeResources();
		return results;
	}

	public static void deleteMedia(Media media) throws PropertyException {

		prepareEntityManager();
		Media mediaToRemove = entitymanager.find(Media.class, media.getId());
		entitymanager.remove(mediaToRemove);
		closeResources();
	}

	public static List<Voiture> allVoitures() throws PropertyException {

		prepareEntityManager();

		TypedQuery<Voiture> query = entitymanager.createQuery("SELECT v FROM Voiture v", Voiture.class);
		List<Voiture> results = query.getResultList();
		closeResources();

		return results;

	}

	public static List<Couleur> allCouleurs() throws PropertyException {

		prepareEntityManager();

		TypedQuery<Couleur> query = entitymanager.createQuery("SELECT c FROM Couleur c", Couleur.class);
		List<Couleur> results = query.getResultList();
		closeResources();

		return results;

	}

}
