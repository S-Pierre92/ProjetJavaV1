package com.wheeludrive.test;


import org.junit.Test;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.CodePostal;
import com.wheeludrive.entity.Pays;
import com.wheeludrive.entity.manager.PaysAdresseManager;
import com.wheeludrive.exception.PropertyException;

public class PaysAdresseManagerTest {
	
	@Test
	public void createPays() throws PropertyException {
		
		
		Pays pays = new Pays();
		pays.setTauxTVA(0.21f);
		pays.setNomComplet("Belgique");
		pays.setNomAbreviation("bel");
		pays.setIso("BE");
		
		PaysAdresseManager.createPays(pays);
	}
	
	@Test
	public void createCodePostal() throws PropertyException {
		
		
		CodePostal code = new CodePostal();
		code.setPays(PaysAdresseManager.findPays(1));
		code.setIntitule("Jumet");
		code.setCode("6040");
		
		PaysAdresseManager.createCodePostal(code);
	}
	
	@Test
	public void createAdresse() throws PropertyException {
		
		
		Adresse adresse = new Adresse();
		adresse.setVille("Charleroi");
		adresse.setCodePostal(PaysAdresseManager.findCodePostal(1));
		adresse.setBoite("1");
		adresse.setNumero("2");
		adresse.setRue("Place matteoti");
		
		PaysAdresseManager.createAddresse(adresse);
	}	
}
