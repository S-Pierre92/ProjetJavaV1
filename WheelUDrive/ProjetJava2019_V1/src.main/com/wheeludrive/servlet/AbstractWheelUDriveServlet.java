package com.wheeludrive.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public abstract class AbstractWheelUDriveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	protected final String HTML_LOGGED = "logged";
	protected final String HTML_NOTLOGGED = "not_logged";



	protected HttpServletRequest checkSession(HttpServletRequest request, Logger log) {

		HttpSession session = request.getSession();
		if (null != session.getAttribute("isLogged")) {

			int isLogged = (int) session.getAttribute("isLogged");
			if (isLogged == 1) {
				request.setAttribute("navFormLog", HTML_LOGGED);
				log.info("isloggedget");
			} else {
				request.setAttribute("navFormLog", HTML_NOTLOGGED);
				log.info("isnotloggedget");
			}
		} else {
			request.setAttribute("navFormLog", HTML_NOTLOGGED);
		}

		return request;
	}

}
