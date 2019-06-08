package com.wheeludrive.test.model.manager;


import java.util.Date;

import org.junit.jupiter.api.Test;

import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.manager.AnnonceManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.tools.DateUtils;

public class AnnonceManagerTest {
	
	@Test
	public void TestCreateAnnonce() throws PropertyException, WheelUDriveException {
		
		Annonce annonce = new Annonce();
		
		annonce.setActif(true);

		annonce.setDatePublication(new Date());
		annonce.setDescription("La meilleur voiture que vous ayez vu de vote vie, valid� par tous les experts");
		annonce.setMontant(4000);
		annonce.setUtilisateur(UtilisateurManager.findUtilisateur(1));
		annonce.setTag("Vente");
		annonce.setVoiture(VoitureManager.findVoiture(3));
		
		
		annonce.setDateValidite(DateUtils.dateCreator(2020, 9, 31));
		AnnonceManager.createAnnonce(annonce);	
	}

}
