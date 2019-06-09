package com.wheeludrive.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/wheeludrive/voitures" })
public class VoituresServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("page", "vehicules");

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	

}