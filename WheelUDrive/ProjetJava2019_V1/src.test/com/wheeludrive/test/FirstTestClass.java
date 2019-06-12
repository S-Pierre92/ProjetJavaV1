package com.wheeludrive.test;


import org.junit.Assert;
import org.junit.Test;

import com.wheeludrive.domain.ConnexionDB;
import com.wheeludrive.domain.PropertiesManager;
import com.wheeludrive.exception.MyDBException;
import com.wheeludrive.exception.PropertyException;

public class FirstTestClass {
	
	@Test
	public void testDriver() {
		
	try {
		  Class.forName("com.mysql.jdbc.Driver");
		  System.out.println("It works");
		} catch(ClassNotFoundException e) {
		  Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testLocationProperty() {
		System.out.println(System.getProperty("user.home"));
	}
	
	
	
	@Test
	public void testProperty() {
		PropertiesManager prop = null;
		try {
			 prop = new PropertiesManager();
		} catch (PropertyException e) {
			Assert.fail(e.getMessage());
		}
		
		System.out.println("server: "+prop.getServer());
		System.out.println("port: "+prop.getPort());
		System.out.println("user: "+prop.getUser());
		System.out.println("password: "+prop.getPassword());
		System.out.println("ssl:" + prop.getSSl());
	}
	
	
	@Test
	public void testConnectionAndClose() throws PropertyException {
		
		ConnexionDB db = new ConnexionDB();
		
		try {
			db.connexionDB("test");
			System.out.println("Connexion bien établie ;-) ");
		} catch (MyDBException e) {
			Assert.fail(e.getMessage());
		}
		
		try {
			db.closeConnexionDB();
			System.out.println("Connexion bien fermée ;-) ");
		} catch (MyDBException e) {
			Assert.fail(e.getMessage());
		}
	}
}
