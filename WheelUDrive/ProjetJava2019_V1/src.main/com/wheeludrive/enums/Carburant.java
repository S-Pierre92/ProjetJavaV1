package com.wheeludrive.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Carburant {
	
	ESSENCE,DIESEL,ELECTRIQUE,HYBRIDE;

	
	public static List<String> properties() {
		
		List<Carburant> list = Arrays.asList(Carburant.values());
		List<String> listString = new ArrayList<>();
		for(Carburant car : list) {
			listString.add(car.name().replace("_", " "));
		}
		
		return listString;
	}

}
