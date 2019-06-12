package com.wheeludrive.test.model.manager;


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
	
	@Test
	public void findAdresseId() throws PropertyException {
		
		System.out.println(PaysAdresseManager.findAdresseId("Place matteoti", "2", "6040"));
	}
	
	@Test
	public void updateAdresse() throws PropertyException{
		
		Adresse adresse = PaysAdresseManager.findAdresse(24);
		adresse.setVille("Nowhere");
		adresse.setCodePostal(PaysAdresseManager.findCodePostal(1005));
		adresse.setBoite("25");
		adresse.setNumero("278");
		adresse.setRue("void street");
		
		PaysAdresseManager.updateAdresse(adresse);
	}
	
	@Test
	public void updateZip() throws PropertyException{
		
		CodePostal zip = PaysAdresseManager.findCodePostal(9);
		zip.setCode("222562");
		
		PaysAdresseManager.updateCodePostal(zip);
	}
	
	@Test
	public void updatePays() throws PropertyException{
		
		Pays pays = PaysAdresseManager.findPays(1);
		pays.setIso("BE");
		pays.setNomAbreviation("BEL");
		pays.setNis("150");
		
		PaysAdresseManager.updatePays(pays);
	}
}
