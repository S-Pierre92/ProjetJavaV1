package com.wheeludrive.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "" })
public class ControlerServlet extends HttpServlet{
	
	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";
	public final String VUE_VOITURE = "/WEB-INF/wheeludrive/vehicule.jsp";
	public final String VUE_HOME = "/WEB-INF/wheeludrive/home.jsp";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameterMap().size()==0) 
		{
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			
		}else if(request.getParameter("page").equals("home")) {
			
			this.getServletContext().getRequestDispatcher(VUE_HOME).forward(request, response);
		}else if(request.getParameter("page").equals("vehicule")) {
		
			this.getServletContext().getRequestDispatcher(VUE_VOITURE).forward(request, response);
		}

		
	}
	
	

}
