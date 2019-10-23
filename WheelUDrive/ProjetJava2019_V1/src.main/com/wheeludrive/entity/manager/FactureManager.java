package com.wheeludrive.entity.manager;

import com.wheeludrive.entity.Facture;
import com.wheeludrive.exception.PropertyException;

public class FactureManager extends AbstractManager {


	public static void createFacture(Facture facture) throws PropertyException {
		prepareEntityManager();
		entitymanager.persist(facture);
		closeResources();
	}

	public static Facture findFacture(int id) throws PropertyException {
		prepareEntityManager();
		Facture facture = entitymanager.find(Facture.class, id);
		closeResources();
		return facture;
	}
}
