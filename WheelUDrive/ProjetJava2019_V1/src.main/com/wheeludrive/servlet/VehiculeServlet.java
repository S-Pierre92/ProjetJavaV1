package com.wheeludrive.servlet;

import java.io.IOException;

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
import com.wheeludrive.exception.PropertyException;

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
			this.mock = VoitureManager.findVoiture(2);
			request.setAttribute("page", "vehicule");
			
			// A propager dans les autres servlet
			request = this.checkSession(request, log);
						
			UtilisateurBean userBean = UtilisateurBeanConverter.convert(mock.getUtilisateur());
			request.setAttribute(VENDEUR, userBean);
			VoitureBean bean = VoitureBeanConverter.convert(this.mock);
			request.setAttribute("voiture", bean);

			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		} catch (PropertyException e) {
			log.error("Probleme: ",e);
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
		String puissance= request.getParameter("puissance");
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
		
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
