package com.wheeludrive.tools;

import com.wheeludrive.entity.Facture;

public class PDF {
	private static PDF _instance = null;

	private PDF() {

	}

	public static PDF getInstance() {
		if (PDF._instance == null) {
			PDF._instance = new PDF();
		}

		return PDF._instance;
	}

	public void generateInvoicePDF(Facture facture) {

	}
}
