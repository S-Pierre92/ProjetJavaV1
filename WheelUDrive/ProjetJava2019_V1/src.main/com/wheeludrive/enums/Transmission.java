package com.wheeludrive.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Transmission{
	
	TRACTION,PROPULSION, QUATRE_X_QUATRE;

	
	public static List<String> properties() {
		
		List<Transmission> list = Arrays.asList(Transmission.values());
		List<String> listString = new ArrayList<>();
		for(Transmission car : list) {
			listString.add(car.name().replace("_", " "));
		}
		
		return listString;
	}

}
