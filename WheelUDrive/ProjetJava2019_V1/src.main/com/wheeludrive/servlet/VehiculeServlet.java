package com.wheeludrive.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wheeludrive.beans.VoitureBean;
import com.wheeludrive.beans.converters.VoitureBeanConverter;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;

@WebServlet(urlPatterns = { "/wheeludrive/vehicule" })
public class VehiculeServlet extends HttpServlet {
	

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
			log.info("info"+ mock.getUtilisateur());
			request.setAttribute(VENDEUR, mock.getUtilisateur().getPrenom());
			VoitureBean bean = VoitureBeanConverter.convert(this.mock);
			request.setAttribute("voiture", bean);

			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		} catch (PropertyException e) {
			log.error("Probleme: ",e);
		}
	}

}
