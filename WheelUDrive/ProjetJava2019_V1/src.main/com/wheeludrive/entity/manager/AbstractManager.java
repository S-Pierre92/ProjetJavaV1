package com.wheeludrive.entity.manager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.wheeludrive.domain.PropertiesManager;
import com.wheeludrive.exception.PropertyException;

public class AbstractManager {
	
	protected static EntityManagerFactory factory;

	protected static EntityManager entitymanager;
	
	protected static void prepareEntityManager(String persistanceUnit) throws PropertyException {

		Map<String, String> map = new HashMap<>();

		PropertiesManager prop = new PropertiesManager();

		map.put("DB_USER", prop.getUser());
		map.put("DB_PORT", "" + prop.getPort());
		map.put("DB_URL", prop.getServer());
		map.put("DB_PASSWORD", prop.getPassword());

		EnvironmentalEntityManagerFactory.setEnvironmentVariables(map);
		factory = EnvironmentalEntityManagerFactory.createEntityManagerFactory(persistanceUnit,
				Collections.emptyMap());

		entitymanager = factory.createEntityManager();
		entitymanager.getTransaction().begin();

	}

	protected static void closeResources() {

		entitymanager.close();
		factory.close();
	}
}
