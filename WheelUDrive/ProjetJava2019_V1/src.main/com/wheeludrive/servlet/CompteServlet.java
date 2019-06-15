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
import com.wheeludrive.entity.manager.ContratCommandeManager;
import com.wheeludrive.entity.manager.PaysAdresseManager;
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
	
	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";
	
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
	public final String MODAL_SHOW = "show";
	public final String STYLE_DISPLAY_BLOCK = "style=\"display:block;\"";
	public final String STYLE_DISPLAY_BLOCK_MODAL = "style=\"display:block;background: rgba(0, 0, 0, 0.7);\"";
	
	private final static Logger log = Logger.getLogger(CompteServlet.class);


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("page", "compte");
		
		/********************LISTE CP VILLES****************************/
		//ajoute liste CP villes à la request
		try{
			List <CodePostal> listCP = PaysAdresseManager.allCodePostal();
			request.setAttribute("CpVilles", listCP);
		}catch (PropertyException e){
			log.error("err cp:" +e);
		}
		/********************./LISTE CP VILLES**************************/
		
		try {
			listAcheteursByAnnonce(request);
		}catch(PropertyException e){
			log.error("err annonce:" +e);
		}
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
			usrValue.put("zipId", Integer.toString(usrAddress.getCodePostal().getId()));
			usrValue.put("pays", usrAddress.getCodePostal().getPays().getNomComplet());	
			//usrValue.put("professionnel", usrAddress.getCodePostal().getPays().getNomComplet());	
			
			request.setAttribute("usrvalues", usrValue);
			
			
		} catch (PropertyException e1) {
			log.error(e1);
		}
		
		/********************./AFFICHAGE DES INFOS USERS **************************/
		
		

		HttpSession session = request.getSession();
		
		if (null != session.getAttribute("isLogged")) {

			int isLogged = (int) session.getAttribute("isLogged");
			if (isLogged == 1) {
				request.setAttribute("navFormLog", HTML_LOGGED);

				// initialise les values pour la partie commande
				try {
					initCommandValues(request);
				} catch (NumberFormatException | PropertyException e) {
					e.printStackTrace();
					log.debug(e.getMessage());
				}

				log.info("isloggedget");
			} else {
				request.setAttribute("navFormLog", HTML_NOTLOGGED);

				log.info("isnotloggedget");
			}

		} else {
			request.setAttribute("navFormLog", HTML_NOTLOGGED);
		}
		
		

		if (request.getParameter("logout") != null) {
			request.setAttribute("page", "home");

			request.setAttribute("navFormLog", HTML_NOTLOGGED);
			session.invalidate();
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			return;
		}
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "compte");
		
		
		String nom = request.getParameter(CHAMP_NOM);
		log.info("NOM : " + nom);
		String prenom = request.getParameter(CHAMP_PRENOM);
		log.info("PRENOM : " + prenom);
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
		
		try {
			
			//si email saisi existe déjà en db
			if(UtilisateurManager.findUserId(email)!=-1) {
				request.setAttribute("page", "home");
				request.setAttribute("errEmail", MODAL_SHOW);
				request.setAttribute("db", STYLE_DISPLAY_BLOCK_MODAL);
				log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Cet utilisateur existe déjà !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
				return;
			}
			
			if(pswd.equals(pswdConf)) {
				log.info("Les 2 pswd sont identiques");
				
				//insert des infos cp adress 
				Adresse adresse = new Adresse();
				adresse.setCodePostal(PaysAdresseManager.findCodePostal(Integer.parseInt(idCP)));
				adresse.setRue(rue);
				adresse.setNumero(num);
				adresse.setBoite(boite);
				
				//updateAddress
				PaysAdresseManager.updateAdresse(adresse);
				
				//insert infos user
				Utilisateur user = new Utilisateur();
				
				user.setMdp(pswdConf);
				user.setNom(nom);
				user.setPrenom(prenom);
				user.setEmail(email);
				//user.setDateNaissance(DateUtils.dateSeparator(dateNaissance));
				user.setDateNaissance(dateSeparator(dateNaissance));
				user.setTelFixe(telFixe);
				user.setTelMobile(telMobile);
				user.setDateDerniereModification(new Date());
				
				//update user
				UtilisateurManager.updateUtilisateur(user);	
			}else {
				log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 2 PSWD PAS IDENTIQUES !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				request.setAttribute("errPswdNotIdentic", "style=\"display:block\"");
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

			}			

		}catch (PropertyException | WheelUDriveException | ParseException e) {
			log.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ERROR INSCRIPTION : "+e+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

		}
		
	request.setAttribute("page", "home");
	request.setAttribute("showModalSuccessCreateUser", MODAL_SHOW);
	request.setAttribute("emailInscription", email);
	request.setAttribute("showModalSuccessCreateUserD", STYLE_DISPLAY_BLOCK_MODAL);
	request.setAttribute("navFormLog", HTML_NOTLOGGED);
	
	this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
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
		
		log.debug("nbre d'annonce : " + Integer.toString(annonces.size()));
		
		//Annonce annonce = AnnonceManager.findAnnonce(1);
		for(Annonce annonce : annonces) {
		
			//recupere tout le contrat avec le meme car id de l'annonce
			List<Contrat> contrats = annonce.getVoiture().getContrats();
			
			//ensuite recuperer tout les commande lie a ces contrat
			//puis liste les user de ces commande
			for(Contrat contrat : contrats) {
				listUtilisateurs.add(contrat.getCommande().getUtilisateur());
			}
		}
		request.setAttribute("acheteurs", listUtilisateurs);
	}
	
	public Date dateSeparator(String dateString) throws WheelUDriveException, ParseException {
		

		Date dateFinal=new SimpleDateFormat("yyyy-MM-dd").parse(dateString); 
		log.info(dateFinal);
		
		return dateFinal;
		
	}
}
