package com.wheeludrive.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;

import com.wheeludrive.domain.PropertiesManager;
import com.wheeludrive.entity.manager.EnvironmentalEntityManagerFactory;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.test.model.User;
import com.wheeludrive.test.model.manager.UserManager;

public class EnvironmentalEntityManagerTest {
	
	private static final String PERSISTENCE_UNIT = "test_JPA";
	
	
	@Test
	public void testParameterCorrect() throws PropertyException {
		
		Map<String, String> map = new HashMap<>();
		
		PropertiesManager prop = new PropertiesManager();
		
		map.put("DB_USER", prop.getUser());
		map.put("DB_PORT", ""+prop.getPort());
		map.put("DB_URL", prop.getServer());
		map.put("DB_PASSWORD", prop.getPassword());
		
		EnvironmentalEntityManagerFactory.setEnvironmentVariables(map);
		EntityManagerFactory factory = EnvironmentalEntityManagerFactory
				.createEntityManagerFactory(PERSISTENCE_UNIT,Collections.emptyMap());
		
		EntityManager entitymanager = factory.createEntityManager();
		
		String jdbcUser = String.valueOf(factory.getProperties().get("javax.persistence.jdbc.user"));
		String jdbcUrl = String.valueOf(factory.getProperties().get("javax.persistence.jdbc.url"));
		String jdbcPasswd = String.valueOf(factory.getProperties().get("javax.persistence.jdbc.password"));
		System.out.println("user: "+jdbcUser);
		System.out.println("url: "+jdbcUrl);
		System.out.println("pwd: "+jdbcPasswd);
		
		entitymanager.close();
		factory.close();

	}
	
	@Test
	public void createUserTest() throws PropertyException {
		
		// D'abord, faut exécuter la query qui est dans test resources dans votre mySql dans votre table test
		// si ce n'est pas déjà fait bien sur
		
		User user = new User();

		user.setPrenom("Nicolas");
		user.setAge(24);
		user.setNom("Flamel");
		
		UserManager.createUser(user);
	}
	
	@Test
	public void updateUserTest() throws PropertyException {
		
		// D'abord, faut exécuter la query qui est dans test resources dans votre mySql dans votre table test
		// si ce n'est pas déjà fait bien sur
		User user = UserManager.getUser(2);
		
		user.setPrenom("Eddard");
		user.setNom("Stark");
		
		UserManager.updateUser(user);
	}
	
}
