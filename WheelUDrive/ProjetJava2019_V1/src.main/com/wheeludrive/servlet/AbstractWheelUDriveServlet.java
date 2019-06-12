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
	

	protected final String HTML_LOGGED = "<div class=\"widgets-wrap float-right\"><a href=\"#\" class=\"widget-header mr-3\"><div class=\"icontext\"><div class=\"icon-wrap\"><i class=\"icon-sm round border fa fa-heart\"></i></div><div class=\"text-wrap\"><span class=\"small badge badge-danger\">0</span><small style=\"color:#000;\">Favoris</small></div></div></a><div class=\"widget-header dropdown\"><a href=\"#\" data-toggle=\"dropdown\" data-offset=\"20,10\"><div class=\"icontext\"><div class=\"icon-wrap\"><i class=\"icon-sm round border fa fa-user\"></i></div><div class=\"text-wrap\"><div style=\"color:#000;\">Mon compte <i class=\"fa fa-caret-down\"></i> </div></div></a><div class=\"dropdown-menu dropdown-menu-right\"><form class=\"px-4 py-3\"><a class=\"dropdown-item\" href=\"wheeludrive/compte\" >Mes informations</a><hr class=\"dropdown-divider\"><a class=\"dropdown-item\" href=\"?logout=1\">Se déconnecter</a><hr class=\"dropdown-divider\"><a class=\"dropdown-item btn btn-primary btn-block\" href=\"#\" data-toggle=\"modal\" data-target=\"#modal-annonce\">Vendre</a></div></div></div>";

	protected final String HTML_NOTLOGGED = "<div class=\"widgets-wrap float-right\" id=\"connectForm\">\r\n"
			+ "								<div class=\"widget-header dropdown\" >\r\n"
			+ "									<a href=\"#\" data-toggle=\"dropdown\" data-offset=\"20,10\">\r\n"
			+ "										<div class=\"icontext\">\r\n"
			+ "											<div class=\"icon-wrap\"><i class=\"icon-sm round border fa fa-user\"></i></div>\r\n"
			+ "											<div class=\"text-wrap\">\r\n"
			+ "												<small style=\"color:#000;\">Se connecter | S'incrire</small>\r\n"
			+ "											</div>\r\n" + "										</div>\r\n"
			+ "									</a>\r\n"
			+ "									<div class=\"dropdown-menu dropdown-menu-right px-4 py-3\">\r\n"
			+ "										<form class=\"\" action=\"wheeludrive\" method=\"post\">\r\n"
			+ "											<div class=\"form-group\">\r\n"
			+ "												<label>Email</label>\r\n"
			+ "												<input name=\"emailConnexion\" type=\"email\" class=\"form-control\" placeholder=\"email@exemple.com\" required>\r\n"
			+ "											</div>\r\n"
			+ "											<div class=\"form-group\">\r\n"
			+ "												<label>Mot de passe</label>\r\n"
			+ "												<input type=\"password\" name=\"pswdConnexion\" class=\"form-control\" placeholder=\"Mot de passe\" required>\r\n"
			+ "											</div>\r\n"
			+ "											<input type=\"submit\" class=\"btn btn-primary\" value=\"Se connecter\">\r\n"
			+ "											</form>\r\n"
			+ "											<hr class=\"dropdown-divider\">\r\n"
			+ "											<a class=\"dropdown-item\"  data-toggle=\"modal\" data-target=\"#modal-sign\">S'inscrire</a>\r\n"
			+ "											<a class=\"dropdown-item\"  data-toggle=\"modal\" data-target=\"#modal-pswd-lost\">Mot de passe oublié?</a>\r\n"
			+ "									</div> <!--  dropdown-menu .// -->\r\n"
			+ "								</div>  <!-- widget-header .// -->\r\n"
			+ "							</div> <!-- widgets-wrap.// -->";

	protected String getHtmlNotLoggedContext(String context) {

		return "<div class=\"widgets-wrap float-right\" id=\"connectForm\">\r\n"
				+ "								<div class=\"widget-header dropdown\" >\r\n"
				+ "									<a href=\"#\" data-toggle=\"dropdown\" data-offset=\"20,10\">\r\n"
				+ "										<div class=\"icontext\">\r\n"
				+ "											<div class=\"icon-wrap\"><i class=\"icon-sm round border fa fa-user\"></i></div>\r\n"
				+ "											<div class=\"text-wrap\">\r\n"
				+ "												<small style=\"color:#000;\">Se connecter | S'incrire</small>\r\n"
				+ "											</div>\r\n"
				+ "										</div>\r\n" + "									</a>\r\n"
				+ "									<div class=\"dropdown-menu dropdown-menu-right px-4 py-3\">\r\n"
				+ "										<form class=\"\" action=\"" + context
				+ "/wheeludrive\" method=\"post\">\r\n"
				+ "											<div class=\"form-group\">\r\n"
				+ "												<label>Email</label>\r\n"
				+ "												<input name=\"emailConnexion\" type=\"email\" class=\"form-control\" placeholder=\"email@exemple.com\" required>\r\n"
				+ "											</div>\r\n"
				+ "											<div class=\"form-group\">\r\n"
				+ "												<label>Mot de passe</label>\r\n"
				+ "												<input type=\"password\" name=\"pswdConnexion\" class=\"form-control\" placeholder=\"Mot de passe\" required>\r\n"
				+ "											</div>\r\n"
				+ "											<input type=\"submit\" class=\"btn btn-primary\" value=\"Se connecter\">\r\n"
				+ "											</form>\r\n"
				+ "											<hr class=\"dropdown-divider\">\r\n"
				+ "											<a class=\"dropdown-item\"  data-toggle=\"modal\" data-target=\"#modal-sign\">S'inscrire</a>\r\n"
				+ "											<a class=\"dropdown-item\"  data-toggle=\"modal\" data-target=\"#modal-pswd-lost\">Mot de passe oublié?</a>\r\n"
				+ "									</div> <!--  dropdown-menu .// -->\r\n"
				+ "								</div>  <!-- widget-header .// -->\r\n"
				+ "							</div> <!-- widgets-wrap.// -->";

	}

	protected String getHtmlLoggedContext(String context) {

		return "<div class=\"widgets-wrap float-right\"><a href=\"#\" class=\"widget-header mr-3\"><div class=\"icontext\"><div class=\"icon-wrap\"><i class=\"icon-sm round border fa fa-heart\"></i></div><div class=\"text-wrap\"><span class=\"small badge badge-danger\">0</span><small style=\"color:#000;\">Favoris</small></div></div></a><div class=\"widget-header dropdown\"><a href=\"#\" data-toggle=\"dropdown\" data-offset=\"20,10\"><div class=\"icontext\"><div class=\"icon-wrap\"><i class=\"icon-sm round border fa fa-user\"></i></div><div class=\"text-wrap\"><div style=\"color:#000;\">Mon compte <i class=\"fa fa-caret-down\"></i> </div></div></a><div class=\"dropdown-menu dropdown-menu-right\"><form class=\"px-4 py-3\"><a class=\"dropdown-item\" href=\"wheeludrive/compte\" >Mes informations</a><hr class=\"dropdown-divider\"><a class=\"dropdown-item\" href=\"?logout=1\">Se déconnecter</a><hr class=\"dropdown-divider\"><a class=\"dropdown-item btn btn-primary btn-block\" href=\"#\" data-toggle=\"modal\" data-target=\"#modal-annonce\">Vendre</a></div></div></div>";
	}

	protected HttpServletRequest checkSession(HttpServletRequest request, Logger log) {

		HttpSession session = request.getSession();
		if (null != session.getAttribute("isLogged")) {

			int isLogged = (int) session.getAttribute("isLogged");
			if (isLogged == 1) {
				request.setAttribute("navFormLog", HTML_LOGGED);
				log.info("isloggedget");
			} else {
				request.setAttribute("navFormLog", this.getHtmlNotLoggedContext(request.getContextPath()));
				log.info("isnotloggedget");
			}
		} else {
			request.setAttribute("navFormLog", this.getHtmlNotLoggedContext(request.getContextPath()));
		}

		return request;
	}

}
