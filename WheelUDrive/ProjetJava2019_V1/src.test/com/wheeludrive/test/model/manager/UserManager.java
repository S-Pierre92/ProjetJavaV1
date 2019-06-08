package com.wheeludrive.test.model.manager;


import com.wheeludrive.entity.manager.AbstractManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.test.model.User;


// Classe qui n'a rien a voir avec le projet je pr�cise les enfants, c'�tait pour tester avant 
public class UserManager extends AbstractManager {

	private static final String PERSISTENCE_UNIT = "test_JPA";

	public static void createUser(String prenom, String nom, int age) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		User user = new User();

		user.setPrenom(prenom);
		user.setAge(age);
		user.setNom(nom);

		entitymanager.persist(user);
		closeResources();
	}

	public static void createUser(User user) throws PropertyException {
		
		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(user);
		closeResources();
	}

	public static void updateUser(User userCopy) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		User user = entitymanager.find(User.class, userCopy.getId());
		
		user.setAge(userCopy.getAge());
		user.setPrenom(userCopy.getPrenom());
		user.setNom(userCopy.getNom());
		
//		entitymanager.persist(user);
		closeResources();
	}

	public static User getUser(int id) throws PropertyException {

		prepareEntityManager(PERSISTENCE_UNIT);
		User user = entitymanager.find(User.class, id);
		
		closeResources();
		return user;
	}

}
