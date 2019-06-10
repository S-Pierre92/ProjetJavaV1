package com.wheeludrive.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.AdresseUtilisateur;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.manager.PaysAdresseManager;
import com.wheeludrive.entity.manager.PermissionsAndRoleManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.tools.DateUtils;


@WebServlet(urlPatterns = { "/wheeludrive" })
public class HomePageServlet extends HttpServlet{
	
	private final static Logger log = Logger.getLogger(HomePageServlet.class);
	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";
	public final String CHAMP_TYPE_ABO = "typeAbo";
	public final String CHAMP_NOM = "nom";
	public final String CHAMP_PRENOM = "prenom";
	public final String CHAMP_EMAIL = "email";
	public final String CHAMP_TEL_FIXE = "telFixe";
	public final String CHAMP_TEL_MOBILE = "telMobile";
	public final String CHAMP_ADRESSE = "rue";
	public final String CHAMP_NUM = "num";
	public final String CHAMP_CP = "cp";
	public final String CHAMP_VILLE = "ville";
	public final String CHAMP_PAYS = "pays";
	public final String CHAMP_DATE_NAISSANCE = "dateNaissance";
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
		String telFixe = request.getParameter(CHAMP_TEL_FIXE);
		log.info("Le tel est:" + telFixe);
		String telMobile = request.getParameter(CHAMP_TEL_MOBILE);
		log.info("Le tel est:" + telMobile);
		String rue = request.getParameter(CHAMP_ADRESSE);
		log.info("Le adresse est:" + rue);
		String num = request.getParameter(CHAMP_NUM);
		log.info("Le adresse est:" + num);
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
		String dateNaissance = request.getParameter(CHAMP_DATE_NAISSANCE);
		log.info("date de naissabce:" + dateNaissance);
		
		//TODO check si pswd correct
		
		
	
		
		try {
			
			
			Adresse adresse = new Adresse();
			int idCP =PaysAdresseManager.findCodePostalID(cp);
			adresse.setCodePostal(PaysAdresseManager.findCodePostal(idCP));
			adresse.setRue(rue);
			adresse.setNumero(num);
			PaysAdresseManager.createAddresse(adresse);

			Utilisateur user = new Utilisateur();
			user.setMdp(pswdConf);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setDateNaissance(dateSeparator(dateNaissance));
			user.setEmail(email);	
			user.setTelFixe(telFixe);
			user.setTelMobile(telMobile);
			if(Integer.parseInt(pro)==1)
				user.setNumeroTVA(proTVA);
			user.setMdp(pswdConf);
			user.setActif(true);
			user.setSupprime(false);
			user.setDateInscription(new Date());
			user.setDateDerniereModification(new Date());
			UtilisateurManager.createUtilisateur(user);
			
			int idAdresse = PaysAdresseManager.findAdresseId(rue, num, cp);
			int idUser = UtilisateurManager.findUserId(email);
			
			AdresseUtilisateur adressUser = new AdresseUtilisateur();
			adressUser.setAdresse(PaysAdresseManager.findAdresse(idAdresse));
			adressUser.setUtilisateur(UtilisateurManager.findUtilisateur(idUser));
			UtilisateurManager.createAdresseUtilisateur(adresse, user);
			
		} catch (PropertyException | WheelUDriveException e) {
			// TODO Auto-generated catch block
			log.info("err" + e);
		}
		
			
		
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	
	public Date dateSeparator(String dateString) throws WheelUDriveException {
		
		int year = Integer.parseInt(dateString.substring(0, 4));
		int month = Integer.parseInt(dateString.substring(6, 7));
		int day = Integer.parseInt(dateString.substring(9, 10));
		log.info("annee" + year + " month" + month + "day" + day );
		
		Date dateFinal = DateUtils.dateCreator(year, month, day);
		
		return dateFinal;
		
	}
}
