package com.wheeludrive.beans.converters;

import com.wheeludrive.beans.AnnonceBean;
import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.Annonce;

public class AnnonceBeanConverter {
	
	
	private AnnonceBeanConverter() {
		// Utility class
	}
	
	@SuppressWarnings("deprecation")
	public static AnnonceBean convert(Annonce annonce) {
		
		AnnonceBean bean = new AnnonceBean();
		
		bean.setVersion(annonce.getVoiture().getVersion() == null ? "non - defini" : annonce.getVoiture().getVersion() ); 
		bean.setImage(annonce.getVoiture().getMedias() == null || annonce.getVoiture().getMedias().isEmpty() ? null :annonce.getVoiture().getMedias().get(0).getFichier());
		bean.setAnnee(""+(annonce.getVoiture().getDatePremiereImmatriculation().getYear()+1900));
		bean.setBoite(annonce.getVoiture().getVitesse() == null ? "non - defini" :annonce.getVoiture().getVitesse() );
		bean.setCarburant(annonce.getVoiture().getTypeCarburant() == null ? "non - defini" :annonce.getVoiture().getTypeCarburant());
		bean.setKm(""+annonce.getVoiture().getKilometre());
		bean.setModele(annonce.getVoiture().getModele().getNom());
		bean.setMarque(annonce.getVoiture().getModele().getMarque().getNom());
		bean.setNom(annonce.getUtilisateur().getNom());
		bean.setPrenom(annonce.getUtilisateur().getPrenom());
		bean.setPrix(""+annonce.getMontant());
		bean.setId(""+annonce.getVoiture().getId());
				
		Adresse adresse = annonce.getUtilisateur().getAdressesUtilisateurs().get(0).getAdresse();
		String adr = adresse.getNumero() + ", " + adresse.getRue() + " "+adresse.getCodePostal().getCode();
		bean.setAdresse(adr);
		
		return bean;
	}
}
