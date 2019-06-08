package com.wheeludrive.test.model.manager;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.wheeludrive.entity.Couleur;
import com.wheeludrive.entity.Marque;
import com.wheeludrive.entity.Media;
import com.wheeludrive.entity.Modele;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;

public class VoitureManagerTest {
	
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
	
	@Test
	public void testCreateVoiture() throws PropertyException {
		
		Voiture voiture = new Voiture();
		
		voiture.setCouleurExt(VoitureManager.findCouleur(1));
		voiture.setCouleurInt(VoitureManager.findCouleur(2));
		
		voiture.setDateAjout(new Date());
		voiture.setUtilisateur(UtilisateurManager.findUtilisateur(1));
		voiture.setModele(VoitureManager.findModele(1));
		
		VoitureManager.createVoiture(voiture);
	}
	
	@Test
	public void testCreateMedia() throws PropertyException {
		
		Media media = new Media();
		
		media.setFichier("Photo/photoVoitureTest.png");
		media.setNomMedia("Porte gauche Opel Astra");
		media.setType("Photo");
		media.setVoiture(VoitureManager.findVoiture(1));
		
		
		VoitureManager.createMedia(media);
	}
	
	@Test
	public void allMedias() throws PropertyException {
		
		List<Media> medias = VoitureManager.allVoitures();
		
		System.out.println(""+medias.size());
		
	}
	
	@Test
	public void testUpdateVoiture() throws PropertyException{
		
		Voiture voiture = VoitureManager.findVoiture(1);
		voiture.setNombreClefs(7);
		VoitureManager.updateVoiture(voiture);
	}
	
	@Disabled
	@Test
	public void testDeleteMedia() throws PropertyException {
		
		List<Media> medias = VoitureManager.allVoitures();
		if(medias.size() == 0) {
			System.out.println("No records found");
			return;
		}
		
		Media media = medias.get(medias.size()-1);
		VoitureManager.deleteMedia(media);
	}
	
	

}
