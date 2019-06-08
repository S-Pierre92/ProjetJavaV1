package com.wheeludrive.entity.manager;

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

}