package com.wheeludrive.entity.manager;

import com.wheeludrive.entity.Facture;
import com.wheeludrive.exception.PropertyException;

public class FactureManager extends AbstractManager {

	private static final String PERSISTENCE_UNIT = "wheeludrive";

	public static void createFacture(Facture facture) throws PropertyException {
		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(facture);
		closeResources();
	}

	public static Facture findFacture(int id) throws PropertyException {
		prepareEntityManager(PERSISTENCE_UNIT);
		Facture facture = entitymanager.find(Facture.class, id);
		closeResources();
		return facture;
	}
}
