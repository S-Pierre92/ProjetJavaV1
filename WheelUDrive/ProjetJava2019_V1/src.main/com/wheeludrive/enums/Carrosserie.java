package com.wheeludrive.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Carrosserie {
	
	BERLINE,BREAK,SUV,FOURGONETTE,CAMIONETTE,COUPE,COMPACT,CABRIOLET,LIMOUSINE,ROADSTER,SPIDER,PICK_UP;

	public static List<String> properties() {
		
		List<Carrosserie> list = Arrays.asList(Carrosserie.values());
		List<String> listString = new ArrayList<>();
		for(Carrosserie car : list) {
			listString.add(car.name().replace("_", " "));
		}
		
		return listString;
	}

}
