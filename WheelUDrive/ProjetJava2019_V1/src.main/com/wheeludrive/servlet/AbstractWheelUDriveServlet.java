package com.wheeludrive.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wheeludrive.beans.AnnonceBean;
import com.wheeludrive.beans.converters.AnnonceBeanConverter;
import com.wheeludrive.domain.PropertiesManager;
import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.CodePostal;
import com.wheeludrive.entity.manager.PaysAdresseManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.enums.BoiteVitesse;
import com.wheeludrive.enums.Carburant;
import com.wheeludrive.enums.Carrosserie;
import com.wheeludrive.enums.NormeEuro;
import com.wheeludrive.enums.Transmission;
import com.wheeludrive.enums.TypePeinture;
import com.wheeludrive.enums.TypeSiege;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.tools.MediaManager;

public abstract class AbstractWheelUDriveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final String VUE = "/WEB-INF/wheeludrive/index.jsp";
	protected final String HTML_LOGGED = "logged";
	protected final String HTML_NOTLOGGED = "not_logged";
	protected final String MODAL_SHOW = "show";
	protected final String STYLE_DISPLAY_BLOCK = "style=\"display:block;\"";
	protected final String STYLE_DISPLAY_BLOCK_MODAL = "style=\"display:block;background: rgba(0, 0, 0, 0.7);\"";
	protected final String noPhoto = "/assets/images/noPhoto.jpg";
	protected final String b64prefix = "data:image/jpeg;base64,";

	/******************** CHECK LOG OUT ****************************/

	protected void checkLogout(HttpServletRequest request, HttpSession session, HttpServletResponse response ) throws ServletException, IOException {
		
		if (request.getParameter("logout") != null) {
			request.setAttribute("page", "home");

			request.setAttribute("navFormLog", HTML_NOTLOGGED);
			session.invalidate();
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			return;
		}
	}
	
	/******************** ./CHECK LOG OUT ****************************/


	/******************** CHECK SESSION ****************************/

	protected HttpServletRequest checkSession(HttpServletRequest request, Logger log) {

		HttpSession session = request.getSession();
		
		log.info("================================================CHECK SESSION ================================================");

		
		// si l'attribut userId existe	
		if (null != session.getAttribute("userId")) {
			try {
				request.setAttribute("venteLimitBtn", UtilisateurManager.checkLimitVentes((int)request.getSession().getAttribute("userId")) );
				log.info("try vente ok ");
			} catch (PropertyException e2) {
				log.error("!!!!!!!!!!!!!!!!!!!!!! ERROR VENTE LIMIT BTN => "+ e2+ " !!!!!!!!!!!!!!!!!!!!! ");
			}
		}else {
			request.setAttribute("venteLimitBtn", "1");
		}
		if (null != session.getAttribute("isLogged")) {
		log.info("=====GET-ISLOGGED-ATTRIBUT EXISTE EN SESSION====");
			
			// recup de la value de l'attribut isLogged
			
			int isLogged = (int) session.getAttribute("isLogged");
			if (isLogged == 1) {// s'il est logg, on affiche le menu nav avec "mon compte"
				request.setAttribute("navFormLog", HTML_LOGGED);
				log.info("AFFICHAGE MENU CONNECTE");
			} else {// sinon on affiche le menu nav avec "se connecter"
				request.setAttribute("navFormLog", HTML_NOTLOGGED);
				log.info("AFFICHAGE MENU NON CONNECTE");

			}
		}else{ // si pas d'attribut de session on affiche le menu nav avec "se connecter"
			request.setAttribute("navFormLog", HTML_NOTLOGGED);
			log.info("=====GET-ISLOGGED-ATTRIBUT N'EXISTE PAS EN SESSION=====");


		}

		return request;
	}
	
	/******************** ./ CHECK SESSION ****************************/

	
	/******************** LISTE CP VILLES ****************************/
	
	protected HttpServletRequest getListCPVilles(HttpServletRequest request, Logger log) {
		
		// ajoute liste CP villes à la request

		try {
			List<CodePostal> listCP = PaysAdresseManager.allCodePostal();
			request.setAttribute("CpVilles", listCP);
			
		} catch (PropertyException e) {

			log.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ERREUR LISTE CP : " + e + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		return request;

	}
	
	/******************** ./LISTE CP VILLES **************************/

	
	/******************** PARAMETRES SET ATTRIBUTE MODAL ANNONCES **************************/
	
	protected HttpServletRequest setAttributeAnnonce(HttpServletRequest request, Logger log) {

		try {
			request.setAttribute("boites", BoiteVitesse.properties());
			request.setAttribute("carrosseries", Carrosserie.properties());
			request.setAttribute("carburants", Carburant.properties());
			request.setAttribute("transmissions", Transmission.properties());
			request.setAttribute("normes", Arrays.asList(NormeEuro.values()));
			request.setAttribute("sieges", TypeSiege.properties());
			request.setAttribute("peintures", TypePeinture.properties());
			request.setAttribute("modeles", VoitureManager.allModele());
			request.setAttribute("marques", VoitureManager.allMarque());
			request.setAttribute("couleurs", VoitureManager.allCouleurs());
		} catch (PropertyException e) {
			log.error("!!!!!!!!!!!!!!!!!!!!!!!!!ERREUR ANNONCE ATTRUBUT : " + e + " !!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
		}
		return request;
	}
	/******************** ./PARAMETRES SET ATTRIBUTE MODAL ANNONCES 
	 * @throws IOException 
	 * @throws PropertyException **************************/
	
	
	protected HttpServletRequest setAttributeFicheAnnonce(HttpServletRequest request, List<Annonce> annonces, Logger log) throws IOException, PropertyException {
		
		List<AnnonceBean> beans = new ArrayList<>();
		for (Annonce annonce : annonces) {
			AnnonceBean bean = AnnonceBeanConverter.convert(annonce);

			PropertiesManager prop = new PropertiesManager();
			if (bean.getImage() != null) {

				File file = new File(prop.getFolderMedia() + "/" + bean.getImage());
				String b64File = MediaManager.encodeFileToBase64Binary(file);
				log.info("b64: " + b64File);

				bean.setImage(b64prefix + b64File);
			} else {
				bean.setImage(request.getContextPath() + noPhoto);
			}

			log.info("b64: " + bean.getImage());
			beans.add(bean);
		}

		request.setAttribute("annonces", beans);
		
		return request;
		
	}
}
