package com.wheeludrive.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wheeludrive.beans.VoitureBean;
import com.wheeludrive.beans.converters.VoitureBeanConverter;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;

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
		if(null != session.getAttribute("isLogged")) {
			
			int isLogged = (int) session.getAttribute( "isLogged" );
			if(isLogged==1) {
			    request.setAttribute("navFormLog", HTML_LOGGED);

			    log.info("isloggedget");
			}else {
			    request.setAttribute("navFormLog", HTML_NOTLOGGED);


				  log.info("isnotloggedget");
			}
		}else {
		    request.setAttribute("navFormLog", HTML_NOTLOGGED);

		}

		if(request.getParameter("logout") != null) {  
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

}
