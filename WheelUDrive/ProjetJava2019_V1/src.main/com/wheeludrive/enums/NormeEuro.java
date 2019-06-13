package com.wheeludrive.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum NormeEuro{
	
	EURO_0(0), EURO_1(1), EURO_2(2), EURO_3(3), EURO_4(4), EURO_5(5), EURO_6b(6);
	
	int value;
	
	 NormeEuro(int value) {
		 this.value = value;
	 }
	 
	 public int getValue() {
		 return this.value;
	 }
	 
	 public String getName() {
		 
		 return this.name().replace("_", " ");
	 }
	
	
	public static List<String> properties() {
		
		List<NormeEuro> list = Arrays.asList(NormeEuro.values());
		List<String> listString = new ArrayList<>();
		for(NormeEuro car : list) {
			listString.add(car.name().replace("_", " "));
		}
		
		return listString;
	}

}
