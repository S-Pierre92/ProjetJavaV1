package com.wheeludrive.model.manager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.wheeludrive.domain.PropertiesManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.model.Employee;

public class UpdateEmployee {
	
	private static final String PERSISTENCE_UNIT = "Eclipselink_JPA";
	public static void main(String[] args) throws PropertyException {
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
		// emfactory.getProperties().clear();
		String jdbcUrl = String.valueOf(factory.getProperties().get("javax.persistence.jdbc.url"));
		System.out.println("PULL UUUUUP: " + jdbcUrl);
		entitymanager.getTransaction().begin();
		Employee employee = entitymanager.find(Employee.class, 1201);

		// before update
		System.out.println(employee);
		employee.setSalary(46000);
		entitymanager.getTransaction().commit();

		// after update
		System.out.println(employee);
		entitymanager.close();
		factory.close();
	}
}
