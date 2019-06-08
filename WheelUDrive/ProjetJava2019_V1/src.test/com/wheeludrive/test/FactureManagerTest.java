package com.wheeludrive.test;

import java.sql.Date;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.junit.Test;

import com.wheeludrive.entity.Commande;
import com.wheeludrive.entity.Facture;
import com.wheeludrive.entity.manager.ContratCommandeManager;
import com.wheeludrive.entity.manager.FactureManager;
import com.wheeludrive.exception.PropertyException;

public class FactureManagerTest {
	@Test
	public void testCreateFacture() throws PropertyException {
		Facture facture = new Facture();
		facture.setDateFacture(new Date(0));
		facture.setCommande(ContratCommandeManager.findCommande(1));
		FactureManager.createFacture(facture);
	}
}
