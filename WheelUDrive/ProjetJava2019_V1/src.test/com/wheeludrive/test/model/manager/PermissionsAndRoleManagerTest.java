package com.wheeludrive.test.model.manager;

import org.junit.Test;

import com.wheeludrive.entity.Permission;
import com.wheeludrive.entity.PermissionsRole;
import com.wheeludrive.entity.Role;
import com.wheeludrive.entity.manager.PermissionsAndRoleManager;
import com.wheeludrive.exception.PropertyException;


public class PermissionsAndRoleManagerTest {
	
	@Test
	public void createPermissions() throws PropertyException {
		
		
		Permission perm = new Permission();
		
		perm.setDescription("Permet d'acheter, de vendre (achat direct) sur notre belle appli");
		perm.setIntitule("VendeurBase");
		
		PermissionsAndRoleManager.createPermission(perm);
	}
	
	@Test
	public void createRole() throws PropertyException {
		
		
		Role role = new Role();
		
		role.setIntitule("Client_niveau_1");
		
		PermissionsAndRoleManager.createRole(role);
	}
	
	@Test
	public void findPermission() throws PropertyException {
		
		Permission perm = PermissionsAndRoleManager.findPermission(1);
		
		System.out.println("Perm: "+ perm.getId());
		System.out.println("Perm: "+ perm.getDescription());
	}
	
	@Test
	public void createPermRole() throws PropertyException {
		
		
		PermissionsRole permRole = new PermissionsRole();
		
		permRole.setPermission(PermissionsAndRoleManager.findPermission(1));
		permRole.setRole(PermissionsAndRoleManager.findRole(1));
			
		
		PermissionsAndRoleManager.createPermissionRole(permRole);
	}

}
