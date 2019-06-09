package com.wheeludrive.test.model.manager;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.wheeludrive.entity.Couleur;
import com.wheeludrive.entity.Marque;
import com.wheeludrive.entity.Media;
import com.wheeludrive.entity.Modele;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.enums.Carburant;
import com.wheeludrive.enums.Transmission;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.tools.DateUtils;
import com.wheeludrive.tools.VoitureFilterInstance;

public class VoitureManagerTest {
	
	private final static Logger log = Logger.getLogger(VoitureManagerTest.class);

	@Test
	public void testCreateMarque() throws PropertyException {

		Marque marque = new Marque();
		marque.setNom("Opel");
		VoitureManager.createMarque(marque);
	}

	@Test
	public void testCreateModele() throws PropertyException {

		Modele modele = new Modele();
		modele.setNom("Crossland X");
		modele.setMarque(VoitureManager.findMarque(1));
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
		voiture.setModele(VoitureManager.findModele(4));

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

		Voiture voiture = VoitureManager.findVoiture(2);
		voiture.setNombreClefs(7);
		voiture.setNombrePortes(5);
		voiture.setKw(45000);
		voiture.setDatePremiereImmatriculation(DateUtils.dateCreator(2005, 10, 5));
		voiture.setTypeCarburant(Carburant.ESSENCE.name());
		voiture.setTransmission(Transmission.MANUEL.name());
		
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
	public void testQueryVoitureMarque() throws PropertyException {

		String query = "SELECT v FROM Voiture v WHERE v.modele.marque.nom = :Opel "; // A

		Map<String, String> parameters = new HashMap<>();
		parameters.put("Opel", "Opel"); // Les paramètres doivent être cohérent avec la query A bien sur.
		List<Voiture> voitures = VoitureManager.queryVoitures(query, parameters);
		log.debug("" + voitures.size());
	}

	@Test
	public void testQueryVoitureModele() throws PropertyException {

		String query = "SELECT v FROM Voiture v WHERE v.modele.nom = :Cross "; // A

		Map<String, String> parameters = new HashMap<>();
		parameters.put("Cross", "Crossland X"); // Les paramètres doivent être cohérent avec la query A bien sur.
		List<Voiture> voitures = VoitureManager.queryVoitures(query, parameters);
		log.debug("" + voitures.size());
	}
	
	@Test  // Tester uniquement avec une voiture qui est relié à une annonce. Sinon il passe pas le filtre
	public void testQueryVoitureModelePrice() throws PropertyException {

		String query = "SELECT v FROM Voiture v WHERE v.modele.nom = :astra "; // A

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("astra", "Astra"); // Les paramètres doivent être cohérent avec la query A bien sur.
		List<Voiture> voitures = VoitureManager.queryVoitures(query, parameters);
		log.debug("Avant filtre: " + voitures.size());
		List<Voiture> voitureFiltrees = VoitureManager.filterPrix(1300, 2600, voitures); 
		log.debug("Après filtre: " + voitureFiltrees.size());
	}
	
	
	public void testQueryVoitureYear() throws PropertyException, WheelUDriveException {

		String query = "SELECT v FROM Voiture v WHERE v.datePremiereImmatriculation > :date "; // A

		Date date = DateUtils.dateCreator(2006, 1,1);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("date", date); // Les paramètres doivent être cohérent avec la query A bien sur.
		List<Voiture> voitures = VoitureManager.queryVoitures(query, parameters);
		log.debug(" " + voitures.size());
	}
	
	
	@Test
	public void testVoitureFilter() throws WheelUDriveException {
		
		VoitureFilterInstance filter = new VoitureFilterInstance();
		
		filter.addFilterMarqueModele("Opel", "Astra");
		filter.addFiltreCouleur(1, null);
		filter.addFiltreYear(2003, 2008);
		
		filter.createFilterQuery(); 
		log.debug(filter.getTotalQuery());
	}

}
