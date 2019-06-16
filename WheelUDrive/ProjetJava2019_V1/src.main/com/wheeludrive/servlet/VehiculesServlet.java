package com.wheeludrive.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wheeludrive.beans.AnnonceBean;
import com.wheeludrive.beans.converters.AnnonceBeanConverter;
import com.wheeludrive.domain.PropertiesManager;
import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.manager.AnnonceManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.tools.MediaManager;
import com.wheeludrive.tools.VoitureFilterInstance;

@WebServlet(urlPatterns = { "/wheeludrive/vehicules" })
public class VehiculesServlet extends AbstractWheelUDriveServlet {

	private final static Logger log = Logger.getLogger(VehiculesServlet.class);

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "vehicules");
		request = this.checkSession(request, log);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "vehicules");
		request = this.checkSession(request, log);

		if (request.getParameter("search") != null) {

			try {
				log.info("Param = " + request.getParameter("search"));
				List<Annonce> annonces = AnnonceManager.allAnnonceMarqueLike(request.getParameter("search"));
				log.info("nombre d'annonces :" + annonces.size());
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

			} catch (PropertyException e) {
				log.error(e.getCause().getMessage(), e);
			}
		}

		if (request.getParameter("btnFilter") != null) {

			log.info("Recherche sur base de filtre ...");

			
			try {
				VoitureFilterInstance filter = new VoitureFilterInstance();
				
				filter.addFiltreKm(Integer.parseInt(request.getParameter("kilMin")), Integer.parseInt(request.getParameter("kilMax")));
				filter.addFiltreYear(Integer.parseInt(request.getParameter("anneeMin")), Integer.parseInt(request.getParameter("anneeMax")));
				
				if (request.getParameter("marque") != "-1") {
					filter.addFilterMarqueModele(request.getParameter("marque"), null);
				}
				
				if (request.getParameter("carburant") != "-1") {
					filter.addFiltreCarburantTransmission(request.getParameter("carburant"), null);
				}
				
				if (request.getParameter("transmission") != "-1") {
					filter.addFiltreCarburantTransmission(null, request.getParameter("transmission"));
				}
				
				if(request.getParameter("porte") != "-1") {
					filter.addFiltrePortes(Integer.parseInt(request.getParameter("porte")));
				}
				
				if(request.getParameter("couleurInt") != "-1") {
					filter.addFiltreCouleur(Integer.parseInt(request.getParameter("couleurInt")), null);
				}
				
				if(request.getParameter("couleurExt") != "-1") {
					filter.addFiltreCouleur(null, Integer.parseInt(request.getParameter("couleurExt")));
				}
				
				filter.createFilterQuery();
				String totalQuery = filter.getTotalQuery();
				Map<String, Object> params =  filter.getAllParameters();
				
				List<Annonce> listAnnonce = AnnonceManager.queryVoitures(totalQuery, params);
				List<Annonce> finalListAnnonce = AnnonceManager.filterPrix(Integer.parseInt(request.getParameter("prixMin")),
						Integer.parseInt(request.getParameter("prixMax")), listAnnonce);
				
				log.info("nombre d'annonces :" + finalListAnnonce.size());
				List<AnnonceBean> beans = new ArrayList<>();

				for (Annonce annonce : finalListAnnonce) {
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
				
			} catch (NumberFormatException | WheelUDriveException | PropertyException e) {
				log.error(e.getCause().getMessage(), e);
			}
		}

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
