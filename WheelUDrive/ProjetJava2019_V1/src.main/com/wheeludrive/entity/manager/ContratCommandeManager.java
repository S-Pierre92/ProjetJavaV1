package com.wheeludrive.entity.manager;

import java.util.List;

import javax.persistence.TypedQuery;

import com.wheeludrive.entity.Commande;
import com.wheeludrive.entity.Contrat;
import com.wheeludrive.entity.TypesContrat;
import com.wheeludrive.exception.PropertyException;

public class ContratCommandeManager extends AbstractManager {

	private static final String PERSISTENCE_UNIT = "wheeludrive";

	public static void createContrat(Contrat contrat) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(contrat);
		closeResources();
	}

	public static void createTypeContrat(TypesContrat typeContrat) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(typeContrat);
		closeResources();
	}

	public static void createCommande(Commande commande) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(commande);
		closeResources();
	}

	public static Contrat findContrat(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		Contrat contrat = entitymanager.find(Contrat.class, id);
		closeResources();
		return contrat;
	}

	public static TypesContrat findTypesContrat(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		TypesContrat typeContrat = entitymanager.find(TypesContrat.class, id);
		closeResources();
		return typeContrat;
	}

	public static Commande findCommande(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		Commande commande = entitymanager.find(Commande.class, id);
		closeResources();
		return commande;
	}
	
	public static List<Contrat> findAllContratForSpecificCar(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);

		TypedQuery<Contrat> query = entitymanager.createQuery("SELECT c FROM Contrat c WHERE c.voiture.id = :id",
				Contrat.class);

		query.setParameter("id", id);

		List<Contrat> results = query.getResultList();

		closeResources();
		return results;
	}
	
}
