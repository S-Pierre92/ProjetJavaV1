package com.wheeludrive.entity.manager;


import javax.persistence.EntityManager;

import com.wheeludrive.entity.manager.factory.EMF;
import com.wheeludrive.exception.PropertyException;

public class AbstractManager {
	

	protected static EntityManager entitymanager;
	
	protected static void prepareEntityManager() throws PropertyException {

		entitymanager = EMF.getEM();
		entitymanager.getTransaction().begin();
	}

	protected static void closeResources() {

		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
}
