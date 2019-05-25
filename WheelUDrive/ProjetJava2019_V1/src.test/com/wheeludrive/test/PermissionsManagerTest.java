package com.wheeludrive.test;

import org.junit.Test;

import com.wheeludrive.entity.Permission;
import com.wheeludrive.entity.manager.PermissionsManager;
import com.wheeludrive.exception.PropertyException;


public class PermissionsManagerTest {
	
	@Test
	public void createPermissionsTest() throws PropertyException {
		
		
		Permission perm = new Permission();
		
		perm.setDescription("Permet d'acheter, de vendre (achat direct) sur notre velle appli");
		perm.setIntitule("VendeurBase");
		
		PermissionsManager.createPermissions(perm);
	}

}
