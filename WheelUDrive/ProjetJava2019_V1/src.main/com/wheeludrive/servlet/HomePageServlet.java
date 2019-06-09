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
	public final String CHAMP_TYPE_ABO = "typeAbo";
	public final String CHAMP_NOM = "nom";
	public final String CHAMP_PRENOM = "prenom";
	public final String CHAMP_EMAIL = "email";
	public final String CHAMP_TEL = "tel";
	public final String CHAMP_ADRESSE = "adresse";
	public final String CHAMP_NUM = "num";
	public final String CHAMP_CP = "cp";
	public final String CHAMP_VILLE = "ville";
	public final String CHAMP_PAYS = "pays";
	public final String CHAMP_PROFESSIONNEL = "professionnel";
	public final String CHAMP_PROFESSIONNEL_TVA = "professionnelTVA";
	public final String CHAMP_PASS = "motdepasse";
	public final String CHAMP_CONF = "confirmation";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("page", "home");
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "home");
		String nom = request.getParameter(CHAMP_NOM);
		log.info("Le nom est:" + nom);
		String prenom = request.getParameter(CHAMP_PRENOM);
		log.info("Le nom est:" + prenom);
		String email = request.getParameter(CHAMP_EMAIL);
		log.info("Le nom est:" + email);
		String tel = request.getParameter(CHAMP_TEL);
		log.info("Le tel est:" + tel);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		log.info("Le adresse est:" + adresse);
		String cp = request.getParameter(CHAMP_CP);
		log.info("Le num est:" + cp);
		String ville = request.getParameter(CHAMP_VILLE);
		log.info("La ville est:" + ville);
		String pays = request.getParameter(CHAMP_PAYS);
		log.info("Le pays est:" + pays);
		String pro = request.getParameter(CHAMP_PROFESSIONNEL);
		log.info("Le client est un professionnel:" + pro);
		String proTVA = request.getParameter(CHAMP_PROFESSIONNEL_TVA);
		log.info("TVA Client:" + proTVA);
		String pswd = request.getParameter(CHAMP_PASS);
		log.info("TPassword:" + pswd);
		String pswdConf = request.getParameter(CHAMP_PASS);
		log.info("Password confirm:" + pswdConf); 
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	

}
