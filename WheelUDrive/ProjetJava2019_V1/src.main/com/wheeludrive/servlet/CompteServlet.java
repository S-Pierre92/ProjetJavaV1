package com.wheeludrive.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wheeludrive.beans.VoitureBean;
import com.wheeludrive.beans.converters.VoitureBeanConverter;
import com.wheeludrive.entity.Commande;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.tools.DateUtils;

@WebServlet(urlPatterns = { "/wheeludrive/compte" })
public class CompteServlet extends AbstractWheelUDriveServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(CompteServlet.class);

	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("page", "compte");

		HttpSession session = request.getSession();
		if (null != session.getAttribute("isLogged")) {

			int isLogged = (int) session.getAttribute("isLogged");
			if (isLogged == 1) {
				request.setAttribute("navFormLog", HTML_LOGGED);

				// initialise les values pour la partie commande
				try {
					initCommandValues(request);
				} catch (NumberFormatException | PropertyException e) {
					log.debug(e.getMessage());
				}

				log.info("isloggedget");
			} else {
				request.setAttribute("navFormLog", HTML_NOTLOGGED);

				log.info("isnotloggedget");
			}

		} else {
			request.setAttribute("navFormLog", HTML_NOTLOGGED);

		}

		if (request.getParameter("logout") != null) {
			request.setAttribute("page", "home");

			request.setAttribute("navFormLog", HTML_NOTLOGGED);
			session.invalidate();
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			return;
		}
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("page", "compte");
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	public void initCommandValues(HttpServletRequest request) throws NumberFormatException, PropertyException {
		List<Map<String, String>> values = new ArrayList<Map<String, String>>();
		
		Utilisateur user = UtilisateurManager.findUtilisateur(Integer.parseInt((String) request.getAttribute("userId")));
		List<Commande> commandes = user.getCommandes();
		
		log.debug("nbre de commandes client" + Integer.toString(commandes.size()));

		for (Commande commande : commandes) {
			Map<String, String> row = new HashMap<String, String>();
			
			row.put("idCommande", Integer.toString(commande.getId()));
			Voiture v = commande.getContrats().get(0).getVoiture();
			String marqueModele = v.getModele().getMarque().getNom() + v.getModele().getNom();
			row.put("marqueModele", marqueModele);
			row.put("dateCommande", DateUtils.getStringDateFormatOne(commande.getDateCommande()));
			String idFacture = Integer.toString(commande.getFactures().get(0).getId());
			row.put("lienPdf", getBaseUrl(request) + "/pdf?id_facture=" + idFacture);
			
			values.add(row);
		}
		
		request.setAttribute("commandes", commandes);
	}
	
	public static String getBaseUrl(HttpServletRequest request) {
	    String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
	    return scheme + serverName + serverPort + contextPath;
	  }
}
