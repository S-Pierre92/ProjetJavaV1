package com.wheeludrive.entity.manager;

import java.util.List;

import javax.persistence.TypedQuery;

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
	
	public static int findAdresseId(String rue, String numero, String codePostal) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		
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
			
			prepareEntityManager(PERSISTENCE_UNIT);
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

}
