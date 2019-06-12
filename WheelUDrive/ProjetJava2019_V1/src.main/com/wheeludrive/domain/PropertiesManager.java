package com.wheeludrive.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.wheeludrive.exception.PropertyException;

public class PropertiesManager {

	private Properties properties;

	public PropertiesManager() throws PropertyException {
		properties = new Properties();

		try (InputStream inputStream = new FileInputStream(
				System.getProperty("user.home") + File.separator + "dbManager.properties")) {
			properties.load(inputStream);
			System.out.println("Loaded dbManager Properties.");

		} catch (IOException e) {
			System.err.println("No dbManager properties found." + e.getMessage());
			throw new PropertyException(e.toString(), e);
		}
	}

	public String getServer() {

		return properties.getProperty("db.server");
	}

	public int getPort() {

		return Integer.parseInt(properties.getProperty("db.port"));
	}

	public String getUser() {

		return properties.getProperty("db.user");
	}

	public String getPassword() {

		return properties.getProperty("db.password");
	}

	public String getSSl() {

		return properties.getProperty("db.ssl");
	}

}
