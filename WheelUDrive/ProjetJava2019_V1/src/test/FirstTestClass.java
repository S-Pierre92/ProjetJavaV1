package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import MyException.MyDBException;
import MyException.PropertyException;
import main.ConnexionDB;
import main.PropertiesManager;

public class FirstTestClass {
	
	@Test
	public void testDriver() {
		
	try {
		  Class.forName("com.mysql.jdbc.Driver");
		  System.out.println("It works");
		} catch(ClassNotFoundException e) {
		  Assertions.fail(e);
		}
	}
	
	@Test
	public void testSystemUser() {
		
		System.out.println("directory user:"+System.getProperty("user.home"));
	}
	
	@Test
	public void testProperty() {
		PropertiesManager prop = null;
		try {
			 prop = new PropertiesManager();
		} catch (PropertyException e) {
			Assertions.fail(e);
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
			System.out.println("Connexion bien �tablie ;-) ");
		} catch (MyDBException e) {
			Assertions.fail(e);
		}
		
		try {
			db.closeConnexionDB();
			System.out.println("Connexion bien ferm�e ;-) ");
		} catch (MyDBException e) {
			Assertions.fail(e);
		}
	}
}