package com.wheeludrive.tools;

import java.util.HashMap;
import java.util.Map;

import com.wheeludrive.exception.WheelUDriveException;

public class VoitureFilterUtils {

	private Map<String, Map<String, Object>> filters;

	private static final String BASEQUERY = "SELECT v FROM Voiture v WHERE ";

	public VoitureFilterUtils() {
		this.filters = new HashMap<>();
	}

	public void addFilterMarqueModele(String marque, String modele) {
		if (marque != null) {
			String query = "v.modele.marque.nom = :marque"; // A
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("marque", marque); // Les paramètres doivent être cohérent avec la query A bien sur.
			this.filters.put(query, parameters);
		}

		if (modele != null) {

			String query = "v.modele.nom = :modele"; // A
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("modele", modele); // Les paramètres doivent être cohérent avec la query A bien sur.
			this.filters.put(query, parameters);

		}
	}

	public void addFiltreKm(int min, int max) {

		String query = "v.kilometre <= :max AND v.kilometre >= min"; // A
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("max", new Integer(max));
		parameters.put("min", new Integer(min));
		this.filters.put(query, parameters);

	}

	public void addFiltreYear(int min, int max) throws WheelUDriveException {

		String query = "v.datePremiereImmatriculation <= :max AND v.datePremiereImmatriculation >= min"; // A
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("max", DateUtils.dateCreator(max, 1, 1));
		parameters.put("min", DateUtils.dateCreator(min, 1, 1));
		this.filters.put(query, parameters);

	}
	
	public void addFiltreCouleur(String coulInt, String coulExt) {
		
		if (coulInt != null) {
			String query = "v.coulInt.nom = :coulInt"; // A
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("coulInt", coulInt); // Les paramètres doivent être cohérent avec la query A bien sur.
			this.filters.put(query, parameters);
		}

		if (coulExt != null) {

			String query = "v.coulExt.nom = :coulExt"; // A
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("coulExt", coulExt); // Les paramètres doivent être cohérent avec la query A bien sur.
			this.filters.put(query, parameters);

		}
		
	}

}
