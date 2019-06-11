package com.wheeludrive.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	private final String HTML_LOGGED="<div class=\"widgets-wrap float-right\"><a href=\"#\" class=\"widget-header mr-3\"><div class=\"icontext\"><div class=\"icon-wrap\"><i class=\"icon-sm round border fa fa-heart\"></i></div><div class=\"text-wrap\"><span class=\"small badge badge-danger\">0</span><small style=\"color:#000;\">Favoris</small></div></div></a><div class=\"widget-header dropdown\"><a href=\"#\" data-toggle=\"dropdown\" data-offset=\"20,10\"><div class=\"icontext\"><div class=\"icon-wrap\"><i class=\"icon-sm round border fa fa-user\"></i></div><div class=\"text-wrap\"><div style=\"color:#000;\">Mon compte <i class=\"fa fa-caret-down\"></i> </div></div></a><div class=\"dropdown-menu dropdown-menu-right\"><form class=\"px-4 py-3\"><a class=\"dropdown-item\" href=\"#\" >Mes informations</a><hr class=\"dropdown-divider\"><a href=\"wheeludrive?logout=1\">Se déconnecter</a><hr class=\"dropdown-divider\"><a class=\"dropdown-item btn btn-primary btn-block\" href=\"#\" data-toggle=\"modal\" data-target=\"#modal-annonce\">Vendre</a></div></div></div>";
	private final String HTML_NOTLOGGED="<div class=\"widgets-wrap float-right\" id=\"connectForm\">\r\n" + 
			"								<div class=\"widget-header dropdown\" >\r\n" + 
			"									<a href=\"#\" data-toggle=\"dropdown\" data-offset=\"20,10\">\r\n" + 
			"										<div class=\"icontext\">\r\n" + 
			"											<div class=\"icon-wrap\"><i class=\"icon-sm round border fa fa-user\"></i></div>\r\n" + 
			"											<div class=\"text-wrap\">\r\n" + 
			"												<small style=\"color:#000;\">Se connecter | S'incrire</small>\r\n" + 
			"											</div>\r\n" + 
			"										</div>\r\n" + 
			"									</a>\r\n" + 
			"									<div class=\"dropdown-menu dropdown-menu-right px-4 py-3\">\r\n" + 
			"										<form class=\"\" action=\"wheeludrive\" method=\"post\">\r\n" + 
			"											<div class=\"form-group\">\r\n" + 
			"												<label>Email</label>\r\n" + 
			"												<input name=\"emailConnexion\" type=\"email\" class=\"form-control\" placeholder=\"email@exemple.com\" required>\r\n" + 
			"											</div>\r\n" + 
			"											<div class=\"form-group\">\r\n" + 
			"												<label>Mot de passe</label>\r\n" + 
			"												<input type=\"password\" name=\"pswdConnexion\" class=\"form-control\" placeholder=\"Mot de passe\" required>\r\n" + 
			"											</div>\r\n" + 
			"											<input type=\"submit\" class=\"btn btn-primary\" value=\"Se connecter\">\r\n" + 
			"											</form>\r\n" + 
			"											<hr class=\"dropdown-divider\">\r\n" + 
			"											<a class=\"dropdown-item\"  data-toggle=\"modal\" data-target=\"#modal-sign\">S'inscrire</a>\r\n" + 
			"											<a class=\"dropdown-item\"  data-toggle=\"modal\" data-target=\"#modal-pswd-lost\">Mot de passe oublié?</a>\r\n" + 
			"									</div> <!--  dropdown-menu .// -->\r\n" + 
			"								</div>  <!-- widget-header .// -->\r\n" + 
			"							</div> <!-- widgets-wrap.// -->";
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("page", "home");
		
		HttpSession session = request.getSession();
		if(null != session.getAttribute("isLogged")) {
			
			int isLogged = (int) session.getAttribute( "isLogged" );
			if(isLogged==1) {
			    request.setAttribute("navFormLog", HTML_LOGGED);

			    log.info("isloggedget");
			}else {
			    request.setAttribute("navFormLog", HTML_NOTLOGGED);


				  log.info("isnotloggedget");
			}
		}else {
		    request.setAttribute("navFormLog", HTML_NOTLOGGED);

		}

		if(request.getParameter("logout") != null) {  
			request.setAttribute("page", "home");
			
			request.setAttribute("navFormLog", HTML_NOTLOGGED);
		    session.invalidate();
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		    return; 
		}
		 
		 
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("page", "home");
		
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
		String emailConnexion = request.getParameter("emailConnexion");
		log.info("email connexion" + emailConnexion);
		String pswdConnexion = request.getParameter("pswdConnexion");
		log.info("pswd connexion " + pswdConnexion);
		
	
		
			//si emailConnexion est rempli
			if(request.getParameter("emailConnexion")!=null) {
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
							
							session.setAttribute( "emailConnexion", emailConnexion );
							isLogged = 1;
							log.info("pswd ok ! ");
							request.setAttribute("page", "home");
							session.setAttribute( "isLogged", isLogged );
						    request.setAttribute("navFormLog", HTML_LOGGED);
						    request.setAttribute("inscriptionForm", "");


							log.info("log ok" + isLogged);
							
							//request.setAttribute("dnJS", "1");//masque le menu se connecter
							this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
						}else{
						    request.setAttribute("navFormLog", HTML_NOTLOGGED);
						    request.setAttribute("moncompteFrom", "");

							log.info("pswd inccorect");
							log.info(err);
							if(err>3) {
								//TODO pswd
								isLogged = 0;
								session.setAttribute( "isLogged", isLogged );
							}else {
								//TODO afficher "encore X essai"
								err++;
							}
						
							//TODO pswd incorrect
							//TODO increment err max 3 essai
						}

					}else {
						//TODO email existe pas -> créer un compte ?
					}
					
					
					
				} catch (PropertyException e) {
					// TODO Auto-generated catch block
					log.info("fail");
					e.printStackTrace();
				}
				
				
				/* Récupération de l'objet depuis la session */
				String emailConnexionStringRecup = (String) session.getAttribute( "emailConnexion" );
				log.info( "recup session: " + emailConnexionStringRecup);
			}else{
				
				
				//sinon 
				//inscription
				try {

					if(UtilisateurManager.findUserId(email)!=-1) {
						request.setAttribute("page", "home");
						request.setAttribute("errEmail", "show");
						request.setAttribute("db", "style=\"display: block;background: rgba(0, 0, 0, 0.7);\"");
						log.info("Cet utilisateur existe déjà");
						this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
						return;
						
					}
				
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
					
					UtilisateurManager.createUtilisateur(user);
					
					int idAdresse = PaysAdresseManager.findAdresseId(rue, num, cp);
					int idUser = UtilisateurManager.findUserId(email);
					
					UtilisateurManager.createAdresseUtilisateur(PaysAdresseManager.findAdresse(idAdresse), UtilisateurManager.findUtilisateur(idUser));
				
					
				}catch (PropertyException | WheelUDriveException | ParseException e) {
					// TODO Auto-generated catch block
					log.info("err" + e);
				}
				
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
		
		
		
	}
	
	
	public Date dateSeparator(String dateString) throws WheelUDriveException, ParseException {
		

		
		Date dateFinal=new SimpleDateFormat("yyyy-MM-dd").parse(dateString); 
		log.info(dateFinal);
		
		return dateFinal;
		
	}
}
