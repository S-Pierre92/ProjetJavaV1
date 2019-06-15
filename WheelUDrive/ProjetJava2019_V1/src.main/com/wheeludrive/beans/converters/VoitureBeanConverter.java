package com.wheeludrive.beans.converters;


import com.wheeludrive.beans.VoitureBean;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.tools.DateUtils;

public class VoitureBeanConverter {
	
	private VoitureBeanConverter() {
		// Utility class
	}
	
	public static VoitureBean convert(Voiture voiture) {
		
		VoitureBean bean = new VoitureBean();
		
		bean.setCouleurExt(voiture.getCouleurExt() == null ? "non-defini":voiture.getCouleurExt().getNom());
		bean.setCouleurInt(voiture.getCouleurInt() == null ? "non-defini":voiture.getCouleurInt().getNom());
		bean.setModele(voiture.getModele() == null ? "non-defini": voiture.getModele().getNom());
		bean.setMarque(voiture.getModele() == null ? "non - defini" : voiture.getModele().getMarque().getNom());
		bean.setKilometre(voiture.getKilometre() == 0 ? -1: voiture.getKilometre());
		bean.setCv(voiture.getCv() == 0 ? -1:voiture.getCv());
		bean.setKw(voiture.getKw() == 0 ? -1:voiture.getKw());
		bean.setCylindree(voiture.getCylindree() == 0 ? -1:voiture.getCylindree());
		bean.setTransmission(voiture.getTransmission() == null ? "non-defini":voiture.getTransmission());
		bean.setVitesse(voiture.getVitesse() == null? "non-defini":""+voiture.getVitesse());
		bean.setMotorisation(voiture.getMotorisation() == null ? "non-defini":voiture.getMotorisation());
		bean.setEmissionCO2(voiture.getEmissionCO2() == 0 ? -1:voiture.getEmissionCO2());
		bean.setNormeEuropeene(voiture.getNormeEuropeene() == 0 ? -1:voiture.getNormeEuropeene());
		bean.setDate(voiture.getDatePremiereImmatriculation() == null ? "non-defini":DateUtils.getStringDateFormatOne(voiture.getDatePremiereImmatriculation()));
		bean.setNombreClef(voiture.getNombreClefs() == 0 ? -1:voiture.getNombreClefs());
		bean.setNumeroChassis(voiture.getNumeroChassis() == null ? "non-defini":voiture.getNumeroChassis());
		bean.setTypeSiege(voiture.getTypeSiege() == null ? "non-defini":voiture.getTypeSiege());
		bean.setTypePeinture(voiture.getTypePeinture() == null ? "non-defini":voiture.getTypePeinture());
		bean.setNombrePortes(voiture.getNombrePortes() == 0 ? -1:voiture.getNombrePortes());
		bean.setCarrosserie(voiture.getCarrosserie() == null ? "non-defini":voiture.getCarrosserie());
		bean.setVersion(voiture.getVersion() == null ? "non-defini":voiture.getVersion());
		bean.setPrix(voiture.getAnnonces() == null ? "non-defini" : voiture.getAnnonces().get(0).getMontant() + "");
		bean.setCarnet(voiture.isCarnetEntretien() ? "OK" :"Manquant");
		bean.setCarpass(voiture.isCarpassEstOk() ? "OK" : "Manquant");
		bean.setDescription(voiture.getAnnonces() == null ? "non-defini" : 
			(voiture.getAnnonces().get(0).getDescription() == null ? "non-defini": voiture.getAnnonces().get(0).getDescription()));
		
		
		return bean;
		
	}

}
