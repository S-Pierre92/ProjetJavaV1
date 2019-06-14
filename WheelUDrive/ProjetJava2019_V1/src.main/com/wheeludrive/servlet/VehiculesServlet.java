package com.wheeludrive.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet(urlPatterns = { "/wheeludrive/vehicules" })
public class VehiculesServlet extends AbstractWheelUDriveServlet{
	
	private final static Logger log = Logger.getLogger(VehiculesServlet.class);
	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("page", "vehicules");
		request = this.checkSession(request, log);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}

