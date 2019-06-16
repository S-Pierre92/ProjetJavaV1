package com.wheeludrive.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.CodePostal;
import com.wheeludrive.entity.Commande;
import com.wheeludrive.entity.Contrat;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.PaysAdresseManager;
import com.wheeludrive.entity.manager.PermissionsAndRoleManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.tools.DateUtils;

@WebServlet(urlPatterns = { "/wheeludrive/compte" })
public class CompteServlet extends AbstractWheelUDriveServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public final String CHAMP_NOM = "nom";
	public final String CHAMP_PRENOM = "prenom";
	public final String CHAMP_EMAIL = "email";
	public final String CHAMP_TEL_FIXE = "telFixe";
	public final String CHAMP_TEL_MOBILE = "telMobile";
	public final String CHAMP_ADRESSE = "rue";
	public final String CHAMP_NUM = "num";
	public final String CHAMP_BOITE = "boite";
	public final String CHAMP_CP_VILLE = "CPville";
	public final String CHAMP_PAYS = "pays";
	public final String CHAMP_DATE_NAISSANCE = "dateNaissance";
	public final String CHAMP_PASS = "motdepasse";
	public final String CHAMP_CONF = "confirmation";
	public final String CHAMP_PROFESSIONNEL = "professionnel";
	public final String CHAMP_PROFESSIONNEL_TVA = "professionnelTVA";
	
	private final static Logger log = Logger.getLogger(CompteServlet.class);


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("================================================GET COMPTE SERVLET================================================");

		Utilisateur user;
		try {
			user = UtilisateurManager.findUtilisateur((int)request.getSession().getAttribute("userId"));
			int role = user.getRole().getId();
			request.setAttribute("typeAbo", role);
		} catch (PropertyException e1) {
			log.error("!!!!!!!!!!!! ERROR FIND USER ID GET COMPTE " + e1);
		}

		request.setAttribute("page", "compte");
		
		request = this.getListCPVilles(request, log);
		
		try {
			initCommandValues(request);
			listAcheteursByAnnonce(request);
		}catch(PropertyException e){
			log.error("err annonce:" +e);
		}
	
		
		
		HttpSession session = request.getSession();
		request = this.checkSession(request, log);
		request = this.showInfosUser(request);
		checkLogout(request, session, response);
		
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("================================================POST COMPTE SERVLET================================================");
		
		request = this.getListCPVilles(request, log);
		try {
			Utilisateur user;
			user = UtilisateurManager.findUtilisateur((int)request.getSession().getAttribute("userId"));
			int role = user.getRole().getId();
			request.setAttribute("typeAbo", role);
		} catch (PropertyException e1) {
			log.error("!!!!!!!!!!!! ERROR FIND USER ID GET COMPTE " + e1);
		}
		request.setAttribute("page", "compte");
		request = this.checkSession(request, log);
		request = this.showInfosUser(request);
		HttpSession session = request.getSession();
		
		log.info("================================================RECUP VALUES UPDATE================================================");

		String nom = request.getParameter(CHAMP_NOM);
		log.info("NOM : " + nom);
		String prenom = request.getParameter(CHAMP_PRENOM);
		log.info("PRENOM : " + prenom);
		String role = request.getParameter(CHAMP_PROFESSIONNEL);
		log.info("ROLE : " + role);
		String email = request.getParameter(CHAMP_EMAIL);
		log.info("EMAIL : " + email);
		String telFixe = request.getParameter(CHAMP_TEL_FIXE);
		log.info("TEL FIXE : " + telFixe);
		String telMobile = request.getParameter(CHAMP_TEL_MOBILE);
		log.info("TEL MOBILE : " + telMobile);
		String rue = request.getParameter(CHAMP_ADRESSE);
		log.info("RUE : " + rue);
		String num = request.getParameter(CHAMP_NUM);
		log.info("NUMERO : " + num);
		String boite = request.getParameter(CHAMP_BOITE);
		log.info("BOITE : " + boite);
		String idCP = request.getParameter(CHAMP_CP_VILLE);
		log.info("ID CODE POSTAl : " + idCP);
		String pays = request.getParameter(CHAMP_PAYS);
		log.info("PAYS : " + pays);
		String pswd = request.getParameter(CHAMP_PASS);
		log.info("PASSWORD : " + pswd);
		String pswdConf = request.getParameter(CHAMP_CONF);
		log.info("PASSWORD CONFIRM : " + pswdConf); 
		String dateNaissance = request.getParameter(CHAMP_DATE_NAISSANCE);
		log.info("DATE DE NAISSANCE : " + dateNaissance);
		String proTVA = request.getParameter(CHAMP_PROFESSIONNEL_TVA);
		log.info("TVA  : " + proTVA);
		String formType = request.getParameter("formType");
		log.info("formType  : " + formType);
		

		try {
			
			int userId = (int)session.getAttribute("userId");
			Utilisateur user = UtilisateurManager.findUtilisateur(userId);
			
			if(request.getParameter("formType")!=null) {
				log.info("================================================ FORM TYPE != NULL => " + request.getParameter("formType") + " ================================================");

				if(pswd.equals(UtilisateurManager.findUserPswdID(userId))) {
					log.info("================================================ UPDATE ABO - PSWD OK ================================================");
					if(role.equals("1")) {
						user.setNumeroTVA(null);
					}else {
						user.setNumeroTVA(proTVA);
					}
					user.setRole(PermissionsAndRoleManager.findRole(Integer.parseInt(role)));
					//update user
					UtilisateurManager.updateUtilisateur(user);	
				}else {
					log.info("================================================ UPDATE ABO - PSWD NON OK -> PSWD INPUT : "+ pswd +" / PSWD DB : "+UtilisateurManager.findUserPswd(email)+" ================================================");

					request = this.getListCPVilles(request, log);
					request = this.showInfosUser(request);
					
					//request = this.checkSession(request, log);

					request.setAttribute("showModalPswdIncorrectD", STYLE_DISPLAY_BLOCK_MODAL);
					request.setAttribute("showModalPswdIncorrect", MODAL_SHOW);
					request.setAttribute("page", "compte");
				
					
					this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
				}

			}else {
				
				log.info("================================================ FORM TYPE == NULL => " + request.getParameter("formType") + " ================================================");


				if(pswd.equals(UtilisateurManager.findUserPswdID(userId))) {
					
					log.info("================================================ UPDATE USER - PSWD OK ================================================");
	
				
					///////////////update infos user//////////////////////
					//user.setMdp(pswdConf);
					user.setNom(nom);
					user.setPrenom(prenom);
					user.setEmail(email);
					//user.setDateNaissance(DateUtils.dateSeparator(dateNaissance));
					user.setDateNaissance(dateSeparator(dateNaissance));
					user.setTelFixe(telFixe);
					user.setTelMobile(telMobile);
					user.setDateDerniereModification(new Date());
					//request.setAttribute("role", user.getRole().getId());
					if(role.equals("1")) {
						user.setNumeroTVA(null);
					}else {
						user.setNumeroTVA(proTVA);
					}
				
	
					//insert des infos cp adress 
					Adresse adresse = user.getAdressesUtilisateurs().get(0).getAdresse();
					adresse.setCodePostal(PaysAdresseManager.findCodePostal(Integer.parseInt(idCP)));
					adresse.setRue(rue);
					adresse.setNumero(num);
					adresse.setBoite(boite);
					
					//updateAddress
					PaysAdresseManager.updateAdresse(adresse);
					
					//update user
					UtilisateurManager.updateUtilisateur(user);	
					
				}else {
					log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! PSWD INCORRECT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					request = this.checkSession(request, log);
	
					request.setAttribute("showModalPswdIncorrectD", STYLE_DISPLAY_BLOCK_MODAL);
					request.setAttribute("page", "compte");
					request.setAttribute("showModalPswdIncorrect", MODAL_SHOW);
					this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	
					return;
				}	
			}

		}catch (PropertyException | WheelUDriveException | ParseException e) {
			//request = this.checkSession(request, log);
			//request.setAttribute("page", "compte");
			log.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ERROR UPDATE USER : "+ e +" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			return;
			
		}
		
		request = this.getListCPVilles(request, log);
		request = this.showInfosUser(request);
		
		//request = this.checkSession(request, log);

		request.setAttribute("showModalSuccessUpdateUserD", STYLE_DISPLAY_BLOCK_MODAL);
		request.setAttribute("showModalSuccessUpdateUser", MODAL_SHOW);
	
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	public void initCommandValues(HttpServletRequest request) throws NumberFormatException, PropertyException {
		List<Map<String, String>> values = new ArrayList<Map<String, String>>();

		Utilisateur user = UtilisateurManager.findUtilisateur((int)request.getSession().getAttribute("userId"));
		List<Commande> commandes = user.getCommandes();
		
		log.debug("nbre de commandes client" + Integer.toString(commandes.size()));

		for (Commande commande : commandes) {
			if (!commande.getFactures().isEmpty()) {
				Map<String, String> row = new HashMap<String, String>();
				row.put("idCommande", Integer.toString(commande.getId()));
				Voiture v = commande.getContrats().get(0).getVoiture();
				String marqueModele = v.getModele().getMarque().getNom() + v.getModele().getNom();
				row.put("marqueModele", marqueModele);
				row.put("dateCommande", DateUtils.getStringDateFormatOne(commande.getDateCommande()));
				String idFacture = Integer.toString(commande.getFactures().get(0).getId());
				row.put("lienPdf", getBaseUrl(request) + "/wheeludrive/pdf?id_facture=" + idFacture);

				values.add(row);
			}
		}
		
		request.setAttribute("commandes", values);
	}
	
	public static String getBaseUrl(HttpServletRequest request) {
	    String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
	    return scheme + serverName + serverPort + contextPath;
	  }
	
	private void listAcheteursByAnnonce(HttpServletRequest request) throws NumberFormatException, PropertyException {

		Utilisateur usr = UtilisateurManager.findUtilisateur((int)request.getSession().getAttribute("userId"));
		List<Utilisateur> listUtilisateurs = new ArrayList<Utilisateur>();
		List<Annonce> annonces = usr.getAnnonces();
		

		//List<Map<String, String>> values = new ArrayList<Map<String, String>>();
		
		log.debug("nbre d'annonce : " + Integer.toString(annonces.size()));
		
		//Annonce annonce = AnnonceManager.findAnnonce(1);
		for(Annonce annonce : annonces) {
		
			//recupere tout le contrat avec le meme car id de l'annonce
			List<Contrat> contrats = annonce.getVoiture().getContrats();
			//ensuite recuperer tout les commande lie a ces contrat
			//puis liste les user de ces commande
			for(Contrat contrat : contrats) {
				//Map<String, String> row = new HashMap<String, String>();
				//row.put("annonce",Integer.toString(annonce.getId()));
				//row.put("acheteur", Integer.toString(contrat.getCommande().getUtilisateur().getId()));
				listUtilisateurs.add(contrat.getCommande().getUtilisateur());
				//values.add(row);
			}
		}
		//request.setAttribute("listancs", values);
		request.setAttribute("acheteurs", listUtilisateurs);
	}
	
	public Date dateSeparator(String dateString) throws WheelUDriveException, ParseException {
		

		Date dateFinal=new SimpleDateFormat("yyyy-MM-dd").parse(dateString); 
		log.info(dateFinal);
		
		return dateFinal;
		
	}
	
	public HttpServletRequest showInfosUser (HttpServletRequest request) {

		/******************** AFFICHAGE DES INFOS USERS **************************/

		Utilisateur user;
		try {
			user = UtilisateurManager.findUtilisateur((int)request.getSession().getAttribute("userId"));
			Map<String,String> usrValue = new HashMap<String, String>();
			
			usrValue.put("nom", user.getNom());
			usrValue.put("prenom", user.getPrenom());
			usrValue.put("tel", user.getTelFixe());
			usrValue.put("gsm",user.getTelMobile());
			usrValue.put("email",user.getEmail());
			usrValue.put("birth",DateUtils.getStringDateFormatCalendar(user.getDateNaissance()));
			
			Adresse usrAddress = user.getAdressesUtilisateurs().get(0).getAdresse();
			usrValue.put("rue", usrAddress.getRue());
			usrValue.put("numero", usrAddress.getNumero());
			usrValue.put("boite", usrAddress.getBoite());
			usrValue.put("ville", usrAddress.getVille());
			usrValue.put("zip", usrAddress.getCodePostal().getCode());
			request.setAttribute("idCPClientSession", usrAddress.getCodePostal().getId());
			request.setAttribute("role", user.getRole().getId());
			request.setAttribute("professionnelTVA", user.getNumeroTVA());
			usrValue.put("pays", usrAddress.getCodePostal().getPays().getNomComplet());	
			//usrValue.put("professionnel", usrAddress.getCodePostal().getPays().getNomComplet());	
			
			request.setAttribute("usrvalues", usrValue);
			return request;
			
		} catch (PropertyException e1) {
			log.error(e1);
			return request;
		}
		
		/********************./AFFICHAGE DES INFOS USERS **************************/
		
	}
}
