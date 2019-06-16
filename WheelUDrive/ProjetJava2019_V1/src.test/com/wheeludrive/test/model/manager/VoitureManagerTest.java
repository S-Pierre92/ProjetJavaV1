package com.wheeludrive.test.model.manager;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.Couleur;
import com.wheeludrive.entity.Marque;
import com.wheeludrive.entity.Media;
import com.wheeludrive.entity.Modele;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.AnnonceManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.enums.Carburant;
import com.wheeludrive.enums.Carrosserie;
import com.wheeludrive.enums.NormeEuro;
import com.wheeludrive.enums.Transmission;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.tools.DateUtils;
import com.wheeludrive.tools.VoitureFilterInstance;

public class VoitureManagerTest {
	
	private final static Logger log = Logger.getLogger(VoitureManagerTest.class);

	@Disabled
	@Test
	public void testCreateMarque() throws PropertyException {

		Marque marque = new Marque();
		marque.setNom("Opel");
		VoitureManager.createMarque(marque);
	}
	
	@Test
	public void testFindMarqueId() throws PropertyException {

		System.out.println(VoitureManager.findMarqueId("Opel"));
	}
	
	

	@Test
	public void testCreateModele() throws PropertyException {

		Modele modele = new Modele();
		modele.setNom("Astra");
		modele.setMarque(VoitureManager.findMarque(54));
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
	public void testCreateVoiture() throws PropertyException, WheelUDriveException {

		Voiture voiture = new Voiture();

		voiture.setCouleurExt(VoitureManager.findCouleur(1));
		voiture.setCouleurInt(VoitureManager.findCouleur(2));

		voiture.setDateAjout(new Date());
		voiture.setUtilisateur(UtilisateurManager.findUtilisateur(1));
		voiture.setModele(VoitureManager.findModele(2));
		voiture.setCarnetEntretien(true);
		voiture.setCarpassEstOk(true);
		voiture.setCarrosserie(Carrosserie.BREAK.name());
		voiture.setCv(1900);
		voiture.setCylindree(2);
		voiture.setDateAjout(new Date());
		voiture.setDateAjout(DateUtils.dateCreator(2009, 11, 4));
		voiture.setKilometre(25000);
		voiture.setKw(2500);
		voiture.setNombreClefs(3);
		voiture.setNombrePortes(5);
		voiture.setNormeEuropeene(NormeEuro.EURO_1.getValue());
		voiture.setTypeCarburant(Carburant.DIESEL.name());
		
		
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

		List<Media> medias = VoitureManager.allMedias();

		log.debug("" + medias.size());

	}

	@Test
	public void testUpdateVoiture() throws PropertyException, WheelUDriveException {

		Voiture voiture = VoitureManager.findVoiture(1);
		voiture.setNombreClefs(7);
		voiture.setNombrePortes(5);
		voiture.setKilometre(45000);
		voiture.setDatePremiereImmatriculation(DateUtils.dateCreator(2005, 10, 5));
		voiture.setTypeCarburant(Carburant.ESSENCE.name());
		voiture.setTransmission(Transmission.TRACTION.name());
		
		VoitureManager.updateVoiture(voiture);
	}

	@Disabled
	@Test
	public void testDeleteMedia() throws PropertyException {

		List<Media> medias = VoitureManager.allMedias();
		if (medias.size() == 0) {
			log.debug("No records found");
			return;
		}

		Media media = medias.get(medias.size() - 1);
		VoitureManager.deleteMedia(media);
	}

	@Test
	public void testAllVoitures() throws PropertyException {

		List<Voiture> voitures = VoitureManager.allVoitures();

		log.debug("" + voitures.size());
	}
	
	@Test
	public void testVoitureFilter() throws WheelUDriveException, PropertyException {
		
		VoitureFilterInstance filter = new VoitureFilterInstance();
		
		filter.addFilterMarqueModele("Opel", "Adam");
		filter.addFiltreCouleur(2, null);
		filter.addFiltreYear(2003, 2008);
		
		filter.createFilterQuery(); 
		log.debug(filter.getTotalQuery());
		
		List<Annonce> voitures = AnnonceManager.queryVoitures(filter.getTotalQuery(), filter.getAllParameters());
		log.debug(" " + voitures.size());
	}

}
