package com.wheeludrive.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TypePeinture {

	OPAQUE, METALISEE, PERLEE, AUTRES;

	public static List<String> properties() {

		List<TypePeinture> list = Arrays.asList(TypePeinture.values());
		List<String> listString = new ArrayList<>();
		for (TypePeinture car : list) {
			listString.add(car.name().replace("_", " "));
		}

		return listString;
	}

}
