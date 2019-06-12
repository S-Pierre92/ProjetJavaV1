package com.wheeludrive.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.AdresseUtilisateur;
import com.wheeludrive.entity.CodePostal;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.manager.PaysAdresseManager;
import com.wheeludrive.entity.manager.PermissionsAndRoleManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.tools.DateUtils;


@WebServlet(urlPatterns = { "/wheeludrive" })
public class HomePageServlet extends AbstractWheelUDriveServlet{
	
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
	public final String CHAMP_BOITE = "boite";
	public final String CHAMP_CP_VILLE = "CPville";
	public final String CHAMP_PAYS = "pays";
	public final String CHAMP_DATE_NAISSANCE = "dateNaissance";
	public final String CHAMP_PROFESSIONNEL = "professionnel";
	public final String CHAMP_PROFESSIONNEL_TVA = "professionnelTVA";
	public final String CHAMP_PASS = "motdepasse";
	public final String CHAMP_CONF = "confirmation";
	public final String MODAL_SHOW = "show";
	public final String STYLE_DISPLAY_BLOCK = "style=\"display:block;\"";
	public final String STYLE_DISPLAY_BLOCK_MODAL = "style=\"display:block;background: rgba(0, 0, 0, 0.7);\"";
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 log.info("GET");

		
		//include vers home.jsp
		request.setAttribute("page", "home");
		
		
		/********************LISTE CP VILLES****************************/
		//ajoute liste CP villes à la request

		try{
			List <CodePostal> listCP = PaysAdresseManager.allCodePostal();
			request.setAttribute("CpVilles", listCP);
			
		}catch (PropertyException e){
			
			log.error("err cp:" +e);
		}
		
		/********************./LISTE CP VILLES**************************/


		
		
		
		/********************CHECK SI LOGGED***************************/

		//creation ou recup de la session
		HttpSession session = request.getSession();
		
		//si l'attribut isLogged existe
		if(null != session.getAttribute("isLogged")) {
			 log.info("GET-ISLOGGED-ATTRIBUT EXISTE EN SESSION");
			//recup de la value de l'attribut isLogged
			int isLogged = (int) session.getAttribute( "isLogged" );
			
			//s'il est logg, on affiche le menu nav avec "mon compte"
			if(isLogged==1) {
				
			    request.setAttribute("navFormLog", HTML_LOGGED);
			    log.info("isloggedSessionOK");
			    
			}else {//sinon on affiche le menu nav avec "se connecter"
				
			    request.setAttribute("navFormLog", HTML_NOTLOGGED);
				 log.info("isNotloggedSession");
			}
		}else {//si pas d'attribut de session on affiche le menu nav avec "se connecter"
		    request.setAttribute("navFormLog", HTML_NOTLOGGED);
			 log.info("GET-ISLOGGED-ATTRIBUT N EXISTE PAS EN SESSION");

		}
		/********************./CHECK SI LOGGED*************************/

		
		
		
		
		/********************DECONNEXION*******************************/
		if(request.getParameter("logout") != null) {  
			request.setAttribute("page", "home");
			
			request.setAttribute("navFormLog", HTML_NOTLOGGED);
		    session.invalidate();
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		    return; 
		}
		/********************./DECONNEXION*****************************/

		 
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("page", "home");
		
		/********************RECUP DES VALUES*****************************/

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
		String boite = request.getParameter(CHAMP_BOITE);
		log.info("Le adresse est:" + boite);
		String idCP = request.getParameter(CHAMP_CP_VILLE);
		log.info("La ville est:" + idCP);
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
		String emailConnexion = request.getParameter("emailConnexion");
		log.info("email connexion" + emailConnexion);
		String pswdConnexion = request.getParameter("pswdConnexion");
		log.info("pswd connexion " + pswdConnexion);
		
		/********************./RECUP DES VALUES*****************************/

	
		/********************LISTE CP VILLES****************************/
		//ajoute liste CP villes à la request

		try{
			List <CodePostal> listCP = PaysAdresseManager.allCodePostal();
			request.setAttribute("CpVilles", listCP);
			
		}catch (PropertyException e){
			
			log.error("err cp:" +e);
		}
		
		/********************./LISTE CP VILLES**************************/


		
		/********************CHECK CONNEXION*****************************/

			if(request.getParameter("emailConnexion")!=null) {//si emailConnexion est rempli
				//connexion
				int isLogged = 0;
				int err = 0;
				
				/* Création ou récupération de la session */
				HttpSession session = request.getSession();
				log.info("session: " + session);
				
				try {
					
					int userId = UtilisateurManager.findUserId(emailConnexion);
					
					if(userId!=-1) {//si email existe
						
						String testPswd = UtilisateurManager.findUserPswd(emailConnexion);
						log.info("userid est : " + userId);
						log.info("son pswd est : " + testPswd);
						log.info("Le pswd saisi est : " + pswdConnexion);
						
						if(testPswd.equals(pswdConnexion)) {//si pswd est indentique a celui lié à l'email
							
							log.info("pswd ok ! ");
							isLogged = 1;
							session.setAttribute( "emailConnexion", emailConnexion );
							session.setAttribute( "userId", userId );
							session.setAttribute( "isLogged", isLogged );
							request.setAttribute("page", "home");
							request.setAttribute("modalSucessLogin", MODAL_SHOW);
							request.setAttribute("modalSucessLoginD", STYLE_DISPLAY_BLOCK_MODAL);
						    request.setAttribute("navFormLog", HTML_LOGGED);
						    request.setAttribute("inscriptionForm", "");
						    
							log.info("log ok" + isLogged);
							
							this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
						}else{

							log.info("pswd inccorect");
							isLogged = 0;
							session.setAttribute( "isLogged", isLogged );
						    request.setAttribute("navFormLog", HTML_NOTLOGGED);
							request.setAttribute("page", "home");
							request.setAttribute("showModalPswdIncorrect", MODAL_SHOW);
							request.setAttribute("showModalPswdIncorrectD", STYLE_DISPLAY_BLOCK_MODAL);
							
							this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
						}

					}else {// email existe pas -> créer un compte ?
						isLogged = 0;
						session.setAttribute( "isLogged", isLogged );
						request.setAttribute("page", "home");
						request.setAttribute("navFormLog", HTML_NOTLOGGED);
						request.setAttribute("showModalConnexion", MODAL_SHOW);
						request.setAttribute("showModalConnexionD", STYLE_DISPLAY_BLOCK_MODAL);
						
						this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

					}
					
					
					
				} catch (PropertyException e) {
					// TODO Auto-generated catch block
					log.info("fail");
					e.printStackTrace();
				}
				
				
				/* Récupération de l'objet depuis la session */
				String emailConnexionStringRecup = (String) session.getAttribute( "emailConnexion" );
				log.info( "recup email session: " + emailConnexionStringRecup);
				
				/********************./CHECK CONNEXION*****************************/

				
			}else{
				
				/********************CHECK INSCRIPTION*****************************/

				try {
					
					//si email saisi existe déjà en db
					if(UtilisateurManager.findUserId(email)!=-1) {
						request.setAttribute("page", "home");
						request.setAttribute("errEmail", MODAL_SHOW);
						request.setAttribute("db", STYLE_DISPLAY_BLOCK_MODAL);
						log.info("Cet utilisateur existe déjà");
						this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
						return;
						
					}
					
					//insert des infos cp adress 
					Adresse adresse = new Adresse();
					adresse.setCodePostal(PaysAdresseManager.findCodePostal(Integer.parseInt(idCP)));
					adresse.setRue(rue);
					adresse.setNumero(num);
					adresse.setBoite(boite);
					PaysAdresseManager.createAddresse(adresse);
					
					//insert infos user
					Utilisateur user = new Utilisateur();
					user.setMdp(pswdConf);
					user.setNom(nom);
					user.setPrenom(prenom);
					user.setEmail(email);
					user.setDateNaissance(dateSeparator(dateNaissance));
					user.setTelFixe(telFixe);
					user.setTelMobile(telMobile);
					if(Integer.parseInt(pro)==2)
						user.setNumeroTVA(proTVA);
					user.setMdp(pswdConf);
					user.setActif(true);
					user.setSupprime(false);
					user.setDateInscription(new Date());
					user.setDateDerniereModification(new Date());
					user.setRole(PermissionsAndRoleManager.findRole(Integer.parseInt(pro)));
					
					//creation user
					UtilisateurManager.createUtilisateur(user);
					
					//recup ids pour table adresseUtilisateur
					int idAdresse = PaysAdresseManager.findAdresseId(rue, num, adresse.getCodePostal().getCode());
					int idUser = UtilisateurManager.findUserId(email);
					log.info("iduser : "+idUser);
					//creation de adresseUtilistaeur
					UtilisateurManager.createAdresseUtilisateur(PaysAdresseManager.findAdresse(idAdresse), UtilisateurManager.findUtilisateur(idUser));
					

				}catch (PropertyException | WheelUDriveException | ParseException e) {
					// TODO Auto-generated catch block
					log.info("err" + e);
				}
			request.setAttribute("page", "home");

			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
		
		
		
	}
	
	
	public Date dateSeparator(String dateString) throws WheelUDriveException, ParseException {
		

		
		Date dateFinal=new SimpleDateFormat("yyyy-MM-dd").parse(dateString); 
		log.info(dateFinal);
		
		return dateFinal;
		
	}
}
