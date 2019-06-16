package com.wheeludrive.entity.manager;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

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

	public static int countAnnonces() throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Integer> query = entitymanager.createQuery("SELECT a.id FROM Annonce a", Integer.class);
		List<Integer> results = query.getResultList();
		closeResources();

		return results.size();
	}
	
	public static List<Annonce> allAnnonce() throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Annonce> query = entitymanager.createQuery("SELECT a FROM Annonce a", Annonce.class);
		query.setMaxResults(5);
		List<Annonce> results = query.getResultList();
		closeResources();

		return results;
	}
	
	public static List<Annonce> allAnnonceByUser(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Annonce> query = entitymanager.createQuery("SELECT a FROM Annonce a WHERE a.utilisateur.id = :id", Annonce.class);
		query.setParameter("id", id);
		List<Annonce> results = query.getResultList();
		closeResources();

		return results;
	}
	
	public static List<Annonce> allAnnonceMarqueLike(String like) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Annonce> query = entitymanager.createQuery(
				"SELECT a FROM Annonce a WHERE " + "lower (a.voiture.modele.marque.nom) like CONCAT(:like,'%')", Annonce.class);

		query.setParameter("like", like);

		List<Annonce> results = query.getResultList();

		closeResources();
		return results;

	}
	
	public static <T> List<Annonce> queryVoitures(String requete, Map<String, T> parameters) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Annonce> query = entitymanager.createQuery(requete, Annonce.class);

		for (Entry<String, T> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		List<Annonce> results = query.getResultList();
		closeResources();

		return results;
	}

	public static List<Annonce> filterPrix(int min, int max, List<Annonce> annonces) {

		List<Annonce> voitureFiltres = annonces.stream()
				.filter(p -> p.getMontant() <= max && p.getMontant() >= min)
				.collect(Collectors.toList());

		return voitureFiltres;
	}

}
