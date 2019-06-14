package com.wheeludrive.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/wheeludrive/voitures" })
public class VehiculesServlet extends HttpServlet{
	
	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setAttribute("page", "vehicules");

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	

}
