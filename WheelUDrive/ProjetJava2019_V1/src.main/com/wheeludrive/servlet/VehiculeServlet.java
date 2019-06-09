package com.wheeludrive.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.tools.DateUtils;

@WebServlet(urlPatterns = { "/wheeludrive/vehicule" })
public class VehiculeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Voiture mock;
	private final static Logger log = Logger.getLogger(VehiculeServlet.class);
	private final String VENDEUR = "vendeur";
	private final String MARQUE = "marque";
	private final String MODELE = "modele";
	private final String VERSION = "version";
	private final String CARROSSERIE = "carosserie";
	private final String DATE_IMMATRICULATION = "dateImma";

	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			this.mock = VoitureManager.findVoiture(2);
			request.setAttribute("page", "vehicule");
			request.setAttribute(VENDEUR, mock.getUtilisateur().getPrenom());
			request.setAttribute(MODELE, mock.getModele().getNom());
			request.setAttribute(MARQUE, mock.getModele().getMarque().getNom());
			request.setAttribute(VERSION, mock.getVersion() == null ? "non-défini" : mock.getVersion());
			request.setAttribute(CARROSSERIE, mock.getCarrosserie() == null ? "non-défini" : mock.getCarrosserie());
			request.setAttribute(DATE_IMMATRICULATION, DateUtils.getStringDateFormatOne(mock.getDatePremiereImmatriculation()));
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			log.error("Probleme: ",e);
		}
	}

}
