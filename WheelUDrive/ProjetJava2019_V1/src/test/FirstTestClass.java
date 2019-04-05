package test;

import org.junit.Test;

import MyException.MyDBException;
import MyException.PropertyException;
import junit.framework.Assert;
import main.ConnexionDB;
import main.PropertiesManager;

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
	public void testSystemUser() {
		
		System.out.println("directory user:"+System.getProperty("user.home"));
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
