package com.wheeludrive.test.model.manager;


import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.manager.AnnonceManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.tools.DateUtils;

public class AnnonceManagerTest {
	private final static Logger log = Logger.getLogger(AnnonceManager.class);
	
	@Test
	public void TestCreateAnnonce() throws PropertyException, WheelUDriveException {
		
		Annonce annonce = new Annonce();
		
		annonce.setActif(true);

		annonce.setDatePublication(new Date());
		annonce.setDescription("La meilleur voiture que vous ayez vu de vote vie");
		annonce.setMontant(4000);
		annonce.setUtilisateur(UtilisateurManager.findUtilisateur(13));
		annonce.setTag("Vente");
		annonce.setVoiture(VoitureManager.findVoiture(2));
		
		
		annonce.setDateValidite(DateUtils.dateCreator(2020, 9, 30));
		AnnonceManager.createAnnonce(annonce);	
	}
		@Test
		public void TestfindAnnonce() throws PropertyException, WheelUDriveException {

			Annonce annonce = AnnonceManager.findAnnonce(1);
			log.debug(annonce.getDescription());
		
		}

}
