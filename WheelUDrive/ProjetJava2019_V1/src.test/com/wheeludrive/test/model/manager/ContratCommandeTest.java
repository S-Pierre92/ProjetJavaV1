package com.wheeludrive.test.model.manager;


import org.apache.log4j.Logger;
import org.junit.Test;

import com.wheeludrive.entity.Commande;
import com.wheeludrive.entity.Contrat;
import com.wheeludrive.entity.TypesContrat;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.ContratCommandeManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;

public class ContratCommandeTest {	
	private final static Logger log = Logger.getLogger(ContratCommandeManager.class);
	
	@Test
	public void testCreateTypeContrat() throws PropertyException{
		TypesContrat tc = new TypesContrat();
		tc.setIntitule("Basic");
		Utilisateur u = UtilisateurManager.findUtilisateur(1);
		tc.setUtilisateur(u);
		ContratCommandeManager.createTypeContrat(tc);
	}
	
	@Test
	public void testCreateCommande() throws PropertyException {
		Commande c = new Commande();
		c.setUtilisateur(UtilisateurManager.findUtilisateur(1));
		ContratCommandeManager.createCommande(c);
	}
	
	
	@Test
	public void testCreateContrat() throws PropertyException{
		Contrat c = new Contrat();
		Voiture voiture = VoitureManager.findVoiture(1);
		c.setVoiture(voiture);
		TypesContrat tc = ContratCommandeManager.findTypesContrat(1);
		c.setTypesContrat(tc);
		c.setCommande(ContratCommandeManager.findCommande(1));
		ContratCommandeManager.createContrat(c);
	}
	
	@Test
	public void testdeletecommand()throws PropertyException{
		ContratCommandeManager.deleteCommande(2);
	}
}
