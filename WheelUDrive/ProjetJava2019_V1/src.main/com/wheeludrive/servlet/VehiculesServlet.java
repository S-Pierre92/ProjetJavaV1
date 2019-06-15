package com.wheeludrive.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.wheeludrive.tools.MediaManager;


@WebServlet(urlPatterns = { "/wheeludrive/vehicules" })
public class VehiculesServlet extends AbstractWheelUDriveServlet{
	
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
		
		
		if(request.getParameter("search") != null) {
			
			try {
				log.info("Param = "+request.getParameter("search"));
				List<Annonce> annonces =  AnnonceManager.allAnnonceMarqueLike(request.getParameter("search"));
				log.info("nombre d'annonces :" +annonces.size());
				List<AnnonceBean> beans = new ArrayList<>();
				
				for(Annonce annonce : annonces) {
					AnnonceBean bean = AnnonceBeanConverter.convert(annonce);
					
					PropertiesManager prop = new PropertiesManager();
					if (bean.getImage() != null ) {

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
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}

