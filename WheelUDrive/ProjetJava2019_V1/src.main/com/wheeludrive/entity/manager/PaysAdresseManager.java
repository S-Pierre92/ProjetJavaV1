package com.wheeludrive.entity.manager;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.CodePostal;
import com.wheeludrive.entity.Pays;
import com.wheeludrive.exception.PropertyException;

public class PaysAdresseManager extends AbstractManager{
	
	private final static Logger log = Logger.getLogger(PaysAdresseManager.class);

	
	public static void createPays(Pays pays) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(pays);
		closeResources();
	}
	
	public static void createAddresse(Adresse adresse) throws PropertyException {
		if(findAdresseId(adresse.getRue(),adresse.getNumero(), adresse.getCodePostal().getCode())!=-1) {
			log.info("Cette adresse existe deja ");
			return;
		}
		prepareEntityManager();
		entitymanager.persist(adresse);
		closeResources();
	}
	
	public static void createCodePostal(CodePostal code) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(code);
		closeResources();
	}
	
	public static Pays findPays(int id) throws PropertyException {

		prepareEntityManager();
		Pays pays = entitymanager.find(Pays.class, id);
		closeResources();
		
		return pays;
	}
	
	public static CodePostal findCodePostal(int id) throws PropertyException {

		prepareEntityManager();
		CodePostal code = entitymanager.find(CodePostal.class, id);
		closeResources();
		
		return code;
	}
	
	public static Adresse findAdresse(int id) throws PropertyException {

		prepareEntityManager();
		Adresse adresse = entitymanager.find(Adresse.class, id);
		closeResources();
		
		return adresse;
	}
	
	public static int findAdresseId(String rue, String numero, String codePostal) throws PropertyException {

		prepareEntityManager();
		
		TypedQuery<Integer> query = entitymanager.createQuery("SELECT a.id FROM Adresse a WHERE a.rue = :rue AND "
				+ "a.numero = :num AND a.codePostal.code = :code", Integer.class);
		
		query.setParameter("rue", rue);
		query.setParameter("code", codePostal);
		query.setParameter("num", numero);
		
		List<Integer> results = query.getResultList();
		
		int id;
		
		if(results.isEmpty()) {
			id = -1;
		}
		else {
			id = results.get(0);
		}
		closeResources();
		return id;
	}
	
	public static int findCodePostalID(String codePostal) throws PropertyException {
			
			prepareEntityManager();
			TypedQuery<Integer> query = entitymanager.createQuery("SELECT cp.id FROM CodePostal cp WHERE cp.code = :code", Integer.class);
			
			query.setParameter("code", codePostal);
			
			List<Integer> results = query.getResultList();
			
			int id;
			
			if(results.isEmpty()) {
				id = -1;
			}
			else {
				id = results.get(0);
			}
			
			closeResources();
			return id;
		}
	

	public static List<CodePostal> allCodePostal() throws PropertyException {
		
		prepareEntityManager();
		TypedQuery<CodePostal> query = entitymanager.createQuery("SELECT cp FROM CodePostal cp", CodePostal.class);
		List<CodePostal> results = query.getResultList();
		closeResources();
		
		return results;

	}

	public static void updateAdresse(Adresse adresse) throws PropertyException{
		prepareEntityManager();

		Adresse newAdress = entitymanager.find(Adresse.class, adresse.getId());
		newAdress = adresse;
		entitymanager.merge(newAdress);
		closeResources();
	}
	
	public static void updateCodePostal(CodePostal zip) throws PropertyException{
		prepareEntityManager();

		CodePostal newZip = entitymanager.find(CodePostal.class, zip.getId());
		newZip = zip;
		entitymanager.merge(newZip);
		closeResources();
	}
	
	public static void updatePays(Pays pays) throws PropertyException{
		prepareEntityManager();

		Pays newpays = entitymanager.find(Pays.class, pays.getId());
		newpays = pays;
		entitymanager.merge(newpays);
		closeResources();
	}

	public static void deleteAdresse(Adresse adresse) throws PropertyException {

		prepareEntityManager();
		Adresse adressToRemove = entitymanager.find(Adresse.class, adresse.getId());
		entitymanager.remove(adressToRemove);
		closeResources();
	}
	
	public static void deleteCodePostal(CodePostal zip) throws PropertyException {

		prepareEntityManager();
		CodePostal zipToRemove = entitymanager.find(CodePostal.class, zip.getId());
		entitymanager.remove(zipToRemove);
		closeResources();
	}
	
	public static void deletePays(Pays pays) throws PropertyException {

		prepareEntityManager();
		Pays paysToRemove = entitymanager.find(Pays.class, pays.getId());
		entitymanager.remove(paysToRemove);
		closeResources();
	}
}
