package com.wheeludrive.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TypeSiege {

	ALCANTARA, CUIR, SEMI_CUIR, TISSU, VELOURS, SKAI;

	public static List<String> properties() {

		List<TypeSiege> list = Arrays.asList(TypeSiege.values());
		List<String> listString = new ArrayList<>();
		for (TypeSiege car : list) {
			listString.add(car.name().replace("_", " "));
		}

		return listString;
	}

}
