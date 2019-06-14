package com.wheeludrive.servlet;

import java.util.Arrays;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.enums.BoiteVitesse;
import com.wheeludrive.enums.Carburant;
import com.wheeludrive.enums.Carrosserie;
import com.wheeludrive.enums.NormeEuro;
import com.wheeludrive.enums.Transmission;
import com.wheeludrive.enums.TypePeinture;
import com.wheeludrive.enums.TypeSiege;
import com.wheeludrive.exception.PropertyException;

public abstract class AbstractWheelUDriveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	protected final String HTML_LOGGED = "logged";
	protected final String HTML_NOTLOGGED = "not_logged";
	
	protected HttpServletRequest setAttributeAnnonce(HttpServletRequest request) throws PropertyException {
	
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
	
	return request;
	}



	protected HttpServletRequest checkSession(HttpServletRequest request, Logger log) {

		HttpSession session = request.getSession();
		if (null != session.getAttribute("isLogged")) {

			int isLogged = (int) session.getAttribute("isLogged");
			if (isLogged == 1) {
				request.setAttribute("navFormLog", HTML_LOGGED);
				log.info("isloggedget");
			} else {
				request.setAttribute("navFormLog", HTML_NOTLOGGED);
				log.info("isnotloggedget");
			}
		} else {
			request.setAttribute("navFormLog", HTML_NOTLOGGED);
		}

		return request;
	}

}
