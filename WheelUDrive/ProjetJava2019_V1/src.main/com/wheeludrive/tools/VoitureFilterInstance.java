package com.wheeludrive.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.wheeludrive.exception.WheelUDriveException;

public class VoitureFilterInstance {
	
	private final static Logger log = Logger.getLogger(VoitureFilterInstance.class);

	private Map<String, Map<String, Object>> filters;

	private static final String BASEQUERY = "SELECT v FROM Voiture v WHERE ";
	private static final String AND = " AND ";
	private String totalQuery;
	private Map<String, Object> allParameters;

	public VoitureFilterInstance() {
		this.filters = new HashMap<>();
	}
	
	
	public String getTotalQuery() {
		return totalQuery;
	}

	public Map<String, Object> getAllParameters() {
		return allParameters;
	}
	
	public void clear() {
		this.filters = new HashMap<>();
		this.totalQuery = null;
		this.allParameters = null;
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

	public void addFiltreKm(Integer min, Integer max) {

		String query = "v.kilometre <= :maxKm AND v.kilometre >= :minKm"; // A
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("maxKm", new Integer(max));
		parameters.put("minKm", new Integer(min));
		this.filters.put(query, parameters);

	}

	public void addFiltreYear(Integer min, Integer max) throws WheelUDriveException {

		String query = "v.datePremiereImmatriculation <= :maxDate AND v.datePremiereImmatriculation >= :minDate"; // A
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("maxDate", DateUtils.dateCreator(max, 1, 1));
		parameters.put("minDate", DateUtils.dateCreator(min, 1, 1));
		this.filters.put(query, parameters);

	}
	
	public void addFiltreCouleur(Integer coulInt, Integer coulExt) {
		
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
	
	public void  createFilterQuery() {
		
		this.totalQuery = BASEQUERY;
		boolean isFirst = true;
		this.allParameters = new HashMap<>();
		
		for(Entry<String, Map<String, Object>> entry : this.filters.entrySet()) {
			
			this.allParameters.putAll(entry.getValue());
			
			if(isFirst) {
				isFirst = false;
				this.totalQuery += entry.getKey();
			}
			else {
				this.totalQuery += AND + entry.getKey();
			}
		} 
		log.debug("Show query to be executed: "+ totalQuery);
	}

}
