package com.wheeludrive.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



@WebServlet(urlPatterns = { "/wheeludrive" })
public class HomePageServlet extends HttpServlet{
	
	private final static Logger log = Logger.getLogger(HomePageServlet.class);
	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("page", "home");
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("je mets de la merde jm'en balec");

		//request.setAttribute("page", "home");
		String nom = request.getParameter("nom");
		log.info("Le nom est:" + nom);
		request.setAttribute("page", "home");
		String prenom = request.getParameter("prenom");
		log.info("Le nom est:" + prenom);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	

}
