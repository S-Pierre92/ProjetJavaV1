package com.wheeludrive.beans.converters;

import com.wheeludrive.beans.UtilisateurBean;
import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.Utilisateur;

public class UtilisateurBeanConverter {

	private UtilisateurBeanConverter() {
		// Utility class
	}

	public static UtilisateurBean convert(Utilisateur user) {

		UtilisateurBean bean = new UtilisateurBean();
		if (user.getAdressesUtilisateurs() != null) {

			Adresse adresse = user.getAdressesUtilisateurs().get(0).getAdresse();
			String adr = adresse.getNumero() + "," + adresse.getRue();
			String cp = adresse.getCodePostal().getCode();
			bean.setAdresse(adr);
			bean.setCodePostal(cp);
		}
		else {
			bean.setAdresse("non-défini");
			bean.setCodePostal("non-défini");
		}

		bean.setNom(user.getNom());
		bean.setPrenom(user.getPrenom());
		bean.setTel(user.getTelMobile());

		return bean;
	}

}
