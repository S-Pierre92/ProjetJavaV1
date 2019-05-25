package com.wheeludrive.entity.manager;

import com.wheeludrive.entity.Permission;
import com.wheeludrive.exception.PropertyException;

public class PermissionsManager extends AbstractManager {
	
	private static final String PERSISTENCE_UNIT = "wheeludrive";
	
public static void createPermissions (Permission perm) throws PropertyException {
		
		prepareEntityManager(PERSISTENCE_UNIT);
		entitymanager.persist(perm);
		closeResources();
	}

}
