package com.wheeludrive.test;

import org.junit.jupiter.api.Test;

import com.wheeludrive.entity.Couleur;
import com.wheeludrive.entity.Marque;
import com.wheeludrive.entity.Modele;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;

public class MarqueManagerTest {
	
	@Test
	public void testCreateMarque() throws PropertyException {
		
		Marque marque = new Marque();
		marque.setNom("Opel");
		VoitureManager.createMarque(marque);
	}
	
	@Test
	public void testCreateModele() throws PropertyException {
		
		Modele modele = new Modele();
		modele.setNom("Astra");
		modele.setMarqueVoiture(VoitureManager.findMarque(1));
		VoitureManager.createModel(modele);
	}
	
	@Test
	public void testCreateCouleur() throws PropertyException {
		
		Couleur rouge = new Couleur();
		Couleur bleu = new Couleur();
		rouge.setNom("Rouge");
		bleu.setNom("Bleu");
		
		VoitureManager.createCouleur(bleu);
		VoitureManager.createCouleur(rouge);
	}

}
