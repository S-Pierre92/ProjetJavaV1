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

	private static EntityManagerFactory factory;

	private static EntityManager entitymanager;

	private static void prepareEntityManager() throws PropertyException {

		Map<String, String> map = new HashMap<>();

		PropertiesManager prop = new PropertiesManager();

		map.put("DB_USER", prop.getUser());
		map.put("DB_PORT", "" + prop.getPort());
		map.put("DB_URL", prop.getServer());
		map.put("DB_PASSWORD", prop.getPassword());

		EnvironmentalEntityManagerFactory.setEnvironmentVariables(map);
		factory = EnvironmentalEntityManagerFactory.createEntityManagerFactory(PERSISTENCE_UNIT,
				Collections.emptyMap());

		entitymanager = factory.createEntityManager();
		entitymanager.getTransaction().begin();

	}

	private static void closeResources() {

		entitymanager.close();
		factory.close();
	}

	public static void createUser(String prenom, String nom, int age) throws PropertyException {

		prepareEntityManager();
		User user = new User();

		user.setPrenom(prenom);
		user.setAge(age);
		user.setNom(nom);

		entitymanager.persist(user);
		entitymanager.getTransaction().commit();

		closeResources();
	}

	public static void createUser(User user) throws PropertyException {
		
		prepareEntityManager();
		entitymanager.persist(user);
		entitymanager.getTransaction().commit();
		closeResources();
	}

	public static void updateUser(User userCopy) throws PropertyException {

		prepareEntityManager();
		User user = entitymanager.find(User.class, userCopy.getId());
		
		user.setAge(userCopy.getAge());
		user.setPrenom(userCopy.getPrenom());
		user.setNom(userCopy.getNom());
		
		entitymanager.persist(user);
		entitymanager.getTransaction().commit();
		closeResources();
	}

	public static User getUser(int id) throws PropertyException {

		prepareEntityManager();
		User user = entitymanager.find(User.class, id);
		closeResources();
		return user;
	}

}
