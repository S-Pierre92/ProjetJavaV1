package com.wheeludrive.entity.manager;

import java.util.List;


import com.wheeludrive.entity.Commande;
import com.wheeludrive.entity.Contrat;
import com.wheeludrive.entity.TypesContrat;
import com.wheeludrive.exception.PropertyException;

public class ContratCommandeManager extends AbstractManager {


	public static void createContrat(Contrat contrat) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(contrat);
		closeResources();
	}

	public static void createTypeContrat(TypesContrat typeContrat) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(typeContrat);
		closeResources();
	}

	public static void createCommande(Commande commande) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(commande);
		closeResources();
	}

	public static Contrat findContrat(int id) throws PropertyException {

		prepareEntityManager();
		Contrat contrat = entitymanager.find(Contrat.class, id);
		closeResources();
		return contrat;
	}

	public static TypesContrat findTypesContrat(int id) throws PropertyException {

		prepareEntityManager();
		TypesContrat typeContrat = entitymanager.find(TypesContrat.class, id);
		closeResources();
		return typeContrat;
	}

	public static Commande findCommande(int id) throws PropertyException {

		prepareEntityManager();
		Commande commande = entitymanager.find(Commande.class, id);
		closeResources();
		return commande;
	}
	
	public static void deleteCommande(int id) throws PropertyException {
		
		prepareEntityManager();
		Commande commande = entitymanager.find(Commande.class, id);		
		List<Contrat> cs = commande.getContrats();
		
		for(Contrat c : cs) {
			entitymanager.remove(c);
		}
		entitymanager.remove(commande);
		closeResources();
	}
}
