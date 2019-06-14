package com.wheeludrive.entity.manager;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.persistence.TypedQuery;
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

	public static int createModel(Modele model) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(model);
		entitymanager.flush();
		int id = model.getId();
		closeResources();
		return id;
	}

	public static void createCouleur(Couleur couleur) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(couleur);
		closeResources();
	}

	public static int  createVoiture(Voiture voiture) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(voiture);
		entitymanager.flush();
		int id = voiture.getId();
		closeResources();
		return id;
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

	public static List<Marque> allMarque() throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Marque> query = entitymanager.createQuery("SELECT m FROM Marque m",
				Marque.class);
		
		List<Marque> results = query.getResultList();

		closeResources();
		return results;
	}

	public static List<Modele> allModeleForMarque(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Modele> query = entitymanager.createQuery("SELECT m FROM Modele m WHERE m.marque.id = :id",
				Modele.class);

		query.setParameter("id", id);

		List<Modele> results = query.getResultList();

		closeResources();
		return results;
	}

	public static int findMarqueId(String nom) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

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
		prepareEntityManager(PERSISTENCE_UNIT);

		@SuppressWarnings("unused")
		Voiture voitureInit = entitymanager.find(Voiture.class, voiture.getId());
		voitureInit = voiture;
		entitymanager.merge(voiture);
		closeResources();
	}

	public static List<Media> allMedias() throws PropertyException {
		prepareEntityManager(PERSISTENCE_UNIT);
		TypedQuery<Media> query = entitymanager.createQuery("SELECT m FROM Media m", Media.class);
		List<Media> results = query.getResultList();
		closeResources();
		return results;
	}

	public static void deleteMedia(Media media) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		Media mediaToRemove = entitymanager.find(Media.class, media.getId());
		entitymanager.remove(mediaToRemove);
		closeResources();
	}

	public static List<Voiture> allVoitures() throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Voiture> query = entitymanager.createQuery("SELECT v FROM Voiture v", Voiture.class);
		List<Voiture> results = query.getResultList();
		closeResources();

		return results;

	}
	
	public static List<Couleur> allCouleurs() throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Couleur> query = entitymanager.createQuery("SELECT c FROM Couleur c", Couleur.class);
		List<Couleur> results = query.getResultList();
		closeResources();

		return results;

	}

	public static <T> List<Voiture> queryVoitures(String requete, Map<String, T> parameters) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Voiture> query = entitymanager.createQuery(requete, Voiture.class);

		for (Entry<String, T> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		List<Voiture> results = query.getResultList();
		closeResources();

		return results;
	}

	public static List<Voiture> filterPrix(int min, int max, List<Voiture> voitures) {

		List<Voiture> voitureFiltres = voitures.stream().filter(p -> p.getAnnonces().size() > 0)
				.filter(p -> p.getAnnonces().get(0).getMontant() <= max && p.getAnnonces().get(0).getMontant() >= min)
				.collect(Collectors.toList());

		return voitureFiltres;
	}
}
