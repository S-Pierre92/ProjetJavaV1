package com.wheeludrive.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BoiteVitesse {
	
	AUTOMATIQUE, MANUELLE, SEMI_AUTOMATIQUE;
	
	
	public static List<String> properties() {
		
		List<BoiteVitesse> list = Arrays.asList(BoiteVitesse.values());
		List<String> listString = new ArrayList<>();
		for(BoiteVitesse car : list) {
			listString.add(car.name().replace("_", " "));
		}
		
		return listString;
	}

}
