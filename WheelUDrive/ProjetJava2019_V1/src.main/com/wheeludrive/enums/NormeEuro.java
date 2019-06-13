package com.wheeludrive.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum NormeEuro{
	
	EURO_0, EURO_1, EURO_2, EURO_3, EURO_4, EURO_5, EURO_6b, EURO_6c, EURO_6d_Temp , EURO_6d;
	
	
	public static List<String> properties() {
		
		List<NormeEuro> list = Arrays.asList(NormeEuro.values());
		List<String> listString = new ArrayList<>();
		for(NormeEuro car : list) {
			listString.add(car.name().replace("_", " "));
		}
		
		return listString;
	}

}
