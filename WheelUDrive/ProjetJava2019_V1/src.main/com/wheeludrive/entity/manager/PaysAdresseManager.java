package com.wheeludrive.entity.manager;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.CodePostal;
import com.wheeludrive.entity.Pays;
import com.wheeludrive.exception.PropertyException;

public class PaysAdresseManager extends AbstractManager{
	
	private static final String PERSISTENCE_UNIT = "wheeludrive";
	
	public static void createPays(Pays pays) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(pays);
		closeResources();
	}
	
	public static void createAddresse(Adresse adresse) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(adresse);
		closeResources();
	}
	
	public static void createCodePostal(CodePostal code) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(code);
		closeResources();
	}
	
	public static Pays findPays(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		Pays pays = entitymanager.find(Pays.class, id);
		closeResources();
		
		return pays;
	}
	
	public static CodePostal findCodePostal(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		CodePostal code = entitymanager.find(CodePostal.class, id);
		closeResources();
		
		return code;
	}
	
	public static Adresse findAdresse(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		Adresse adresse = entitymanager.find(Adresse.class, id);
		closeResources();
		
		return adresse;
	}
	
	

}
