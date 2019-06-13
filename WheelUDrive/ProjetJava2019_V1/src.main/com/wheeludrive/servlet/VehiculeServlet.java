package com.wheeludrive.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wheeludrive.beans.UtilisateurBean;
import com.wheeludrive.beans.VoitureBean;
import com.wheeludrive.beans.converters.UtilisateurBeanConverter;
import com.wheeludrive.beans.converters.VoitureBeanConverter;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.enums.BoiteVitesse;
import com.wheeludrive.enums.Carburant;
import com.wheeludrive.enums.Carrosserie;
import com.wheeludrive.enums.NormeEuro;
import com.wheeludrive.enums.Transmission;
import com.wheeludrive.enums.TypePeinture;
import com.wheeludrive.enums.TypeSiege;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;

@WebServlet(urlPatterns = { "/wheeludrive/vehicule" })
public class VehiculeServlet extends AbstractWheelUDriveServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Voiture mock;
	private final static Logger log = Logger.getLogger(VehiculeServlet.class);
	private final String VENDEUR = "vendeur";

	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.mock = VoitureManager.findVoiture(1);
			request.setAttribute("page", "vehicule");

			// TODO A propager dans les autres servlet
			request = this.checkSession(request, log);

			request.setAttribute("boites", BoiteVitesse.properties());
			request.setAttribute("carrosseries", Carrosserie.properties());
			request.setAttribute("carburants", Carburant.properties());
			request.setAttribute("transmissions", Transmission.properties());
			request.setAttribute("normes", Arrays.asList(NormeEuro.values()));
			request.setAttribute("sieges", TypeSiege.properties());
			request.setAttribute("peintures", TypePeinture.properties());
			request.setAttribute("modeles", Arrays.asList("Standard", "Bourgeois", "Grand-Luxe"));
			request.setAttribute("marques", VoitureManager.allMarque());
			request.setAttribute("couleurs", VoitureManager.allCouleurs());

			UtilisateurBean userBean = UtilisateurBeanConverter.convert(mock.getUtilisateur());
			request.setAttribute(VENDEUR, userBean);
			VoitureBean bean = VoitureBeanConverter.convert(this.mock);
			request.setAttribute("voiture", bean);

			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		} catch (PropertyException e) {
			log.error("Probleme: ", e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("page", "vehicule");
		request = this.checkSession(request, log);

		String marque = request.getParameter("marque");
		log.info(marque);
		String modele = request.getParameter("modele");
		log.info(modele);
		String version = request.getParameter("version");
		log.info(version);
		String dateImmatriculation = request.getParameter("date");
		log.info(dateImmatriculation);
		String carburant = request.getParameter("carburant");
		log.info(carburant);
		String puissance = request.getParameter("puissance");
		log.info(puissance);
		String boite = request.getParameter("boite");
		log.info(boite);
		String couleurInt = request.getParameter("couleurInt");
		log.info(couleurInt);
		String couleurExt = request.getParameter("couleurExt");
		log.info(couleurExt);
		String peinture = request.getParameter("peinture");
		log.info(peinture);
		String siege = request.getParameter("siege");
		log.info(siege);
		String km = request.getParameter("km");
		log.info(km);
		String cylindree = request.getParameter("cylindree");
		log.info(cylindree);
		String cv = request.getParameter("cv");
		log.info(cv);
		String kw = request.getParameter("kw");
		log.info(kw);
		String carrosserie = request.getParameter("carrosserie");
		log.info(carrosserie);
		String transmission = request.getParameter("transmission");
		log.info(transmission);
		String portes = request.getParameter("portes");
		log.info(portes);
		String motorisation = request.getParameter("motorisation");
		log.info(motorisation);
		String co2 = request.getParameter("co2");
		log.info(co2);
		String carPass = request.getParameter("carpassEstOk");
		log.info(carPass);
		String norme = request.getParameter("norme");
		log.info(norme);
		String cle = request.getParameter("cle");
		log.info(cle);
		String numeroChassis = request.getParameter("numeroChassis");
		log.info(numeroChassis);
		String carnet = request.getParameter("carnet");
		log.info(carnet);
		String prix = request.getParameter("prix");
		log.info(prix);
		String titre = request.getParameter("titre");
		log.info(titre);
		String description = request.getParameter("description");
		log.info(description);
		String formulaire = request.getParameter("formulaire");
		log.info(formulaire);
		String save = request.getParameter("save");
		log.info(save);
		String publish = request.getParameter("publish");
		log.info(publish);

		if (request.getParameter("formulaire").equals("annonce")) {
			
			try {
				Voiture voiture = new Voiture();

				voiture.setVersion(version);
				voiture.setDatePremiereImmatriculation(this.dateSeparator(dateImmatriculation));
				voiture.setTypeCarburant(carburant);
				voiture.setKw(Integer.parseInt(puissance));
				voiture.setModele(VoitureManager.findModele(1));
				voiture.setVitesse(boite);
				voiture.setCouleurExt(VoitureManager.findCouleur(Integer.parseInt(couleurExt)));
				voiture.setCouleurInt(VoitureManager.findCouleur(Integer.parseInt(couleurInt)));
				voiture.setTypePeinture(peinture);
				voiture.setCarrosserie(carrosserie);
				voiture.setTypeSiege(siege);
				voiture.setKilometre(Integer.parseInt(km));
				voiture.setTransmission(transmission);
				voiture.setNombrePortes(Integer.parseInt(portes));
				voiture.setMotorisation(motorisation);
				voiture.setEmissionCO2(Integer.parseInt(co2));
				voiture.setNormeEuropeene(Integer.parseInt(norme));
				voiture.setNombreClefs(Integer.parseInt(cle));
				voiture.setNumeroChassis(numeroChassis);
				voiture.setCarpassEstOk(Integer.parseInt(carPass) == 1);
				voiture.setCarnetEntretien(Integer.parseInt(carnet) == 1);
				
//				voiture.se
//TODO boite de vitess !!				voiture.setBoite(Boite);
//				voiture.setCouleurExt(couleurExt);
			} catch (WheelUDriveException | ParseException | PropertyException e) {
				log.error(e);
			}

		}

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public Date dateSeparator(String dateString) throws WheelUDriveException, ParseException {

		Date dateFinal = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		log.info(dateFinal);

		return dateFinal;

	}

}
