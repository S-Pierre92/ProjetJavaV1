package com.wheeludrive.test.model.manager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.wheeludrive.domain.PropertiesManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.model.manager.EnvironmentalEntityManagerFactory;
import com.wheeludrive.test.model.User;

public class UserManager {

	private static final String PERSISTENCE_UNIT = "test_JPA";

	public static void createUser() throws PropertyException {

		Map<String, String> map = new HashMap<>();

		PropertiesManager prop = new PropertiesManager();

		map.put("DB_USER", prop.getUser());
		map.put("DB_PORT", "" + prop.getPort());
		map.put("DB_URL", prop.getServer());
		map.put("DB_PASSWORD", prop.getPassword());

		EnvironmentalEntityManagerFactory.setEnvironmentVariables(map);
		EntityManagerFactory factory = EnvironmentalEntityManagerFactory.createEntityManagerFactory(PERSISTENCE_UNIT,
				Collections.emptyMap());

		EntityManager entitymanager = factory.createEntityManager();
		entitymanager.getTransaction().begin();

		User user = new User();
//		employee.setEid(1201);
		user.setPrenom("Jean");
		user.setAge(34);
		user.setNom("LeCon");

		entitymanager.persist(user);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		factory.close();
	}

}
