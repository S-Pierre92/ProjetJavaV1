package com.wheeludrive.entity.manager;

import com.wheeludrive.entity.Permission;
import com.wheeludrive.entity.PermissionsRole;
import com.wheeludrive.entity.Role;
import com.wheeludrive.exception.PropertyException;

public class PermissionsAndRoleManager extends AbstractManager {


	public static void createPermission(Permission perm) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(perm);
		closeResources();
	}
	
	public static Permission findPermission(int id) throws PropertyException {

		prepareEntityManager();
		Permission perm = entitymanager.find(Permission.class, id);
		closeResources();
		return perm;
	}
	
	public static Role findRole(int id) throws PropertyException {

		prepareEntityManager();
		Role role = entitymanager.find(Role.class, id);
		closeResources();
		return role;
	}

	public static void createRole(Role role) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(role);
		closeResources();
	}
	
	public static void createPermissionRole(PermissionsRole permRole) throws PropertyException {

		prepareEntityManager();
		entitymanager.persist(permRole);
		closeResources();
	}

}
