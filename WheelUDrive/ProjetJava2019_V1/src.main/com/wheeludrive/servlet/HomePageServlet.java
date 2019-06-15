package com.wheeludrive.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.CodePostal;
import com.wheeludrive.entity.Marque;
import com.wheeludrive.entity.Media;
import com.wheeludrive.entity.Modele;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.AnnonceManager;
import com.wheeludrive.entity.manager.PaysAdresseManager;
import com.wheeludrive.entity.manager.PermissionsAndRoleManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.tools.MediaManager;

@WebServlet(urlPatterns = { "/wheeludrive" })
public class HomePageServlet extends AbstractWheelUDriveServlet {

	private final static Logger log = Logger.getLogger(HomePageServlet.class);
	// public final String VUE = File.separator+
	// "WEB-INF"+File.separator+"wheeludrive"+File.separator+"index.jsp";

	
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("================================================GET================================================");
		log.info(HTML_LOGGED);
		log.info(HTML_NOTLOGGED);

		// include vers home.jsp
		request.setAttribute("page", "home");

		/******************** HOME COUNT & TITLE ANNONCES ****************************/

		int countAnnonces;

		try {
			countAnnonces = AnnonceManager.countAnnonces();
			if (countAnnonces == 0) {
				request.setAttribute("titleHomeCountAnnonce", "Les annonces arrivent bientôt!");
			} else {
				request.setAttribute("titleHomeCountAnnonce", countAnnonces + "annonces qui n'attendent que vous!");
			}

		} catch (PropertyException e1) {
			log.error("err countAnnonces:" + e1);
		}

		/********************* ./HOME COUNT & TITLE ANNONCES ****************************/

		
		
		
		request = this.checkSession(request, log);

		/******************** DECONNEXION *******************************/
		if (request.getParameter("logout") != null) {
			request.setAttribute("page", "home");
			
			request.setAttribute("navFormLog", HTML_NOTLOGGED);
			//session.invalidate();
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			return;
		}
		/******************** ./DECONNEXION *****************************/

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("================================================POST===========================================================");

		/******************** CREATION ANNONCE *****************************/

		
		if (request.getParameter("emailConnexion") == null && request.getParameter("typeAbo") == null) {

			request.setAttribute("page", "home");
			request = this.checkSession(request, log);

			try {
				request = MediaManager.storeMediaFromRequest(request);
				log.info(request.getAttribute("file"));
			} catch (Exception e1) {
				log.error(e1);
			}
			log.info("================================================RECUP DES VALUES ANNONCES ================================================");


			String marque = (String) request.getAttribute("marque");
			log.info(marque);
			// String modele = (String) request.getAttribute ("modele");
			// log.info(modele);
			String version = (String) request.getAttribute("version");
			log.info(version);
			String dateImmatriculation = (String) request.getAttribute("date");
			log.info(dateImmatriculation);
			String carburant = (String) request.getAttribute("carburant");
			log.info(carburant);
			String puissance = (String) request.getAttribute("puissance");
			log.info(puissance);
			String boit = (String) request.getAttribute("boite");
			log.info(boit);
			String couleurInt = (String) request.getAttribute("couleurInt");
			log.info(couleurInt);
			String couleurExt = (String) request.getAttribute("couleurExt");
			log.info(couleurExt);
			String peinture = (String) request.getAttribute("peinture");
			log.info(peinture);
			String siege = (String) request.getAttribute("siege");
			log.info(siege);
			String km = (String) request.getAttribute("km");
			log.info(km);
			String cylindree = (String) request.getAttribute("cylindree");
			log.info(cylindree);
			String cv = (String) request.getAttribute("cv");
			log.info(cv);
			String kw = (String) request.getAttribute("kw");
			log.info(kw);
			String carrosserie = (String) request.getAttribute("carrosserie");
			log.info(carrosserie);
			String transmission = (String) request.getAttribute("transmission");
			log.info(transmission);
			String portes = (String) request.getAttribute("portes");
			log.info(portes);
			String motorisation = (String) request.getAttribute("motorisation");
			log.info(motorisation);
			String co2 = (String) request.getAttribute("co2");
			log.info(co2);
			String carPass = (String) request.getAttribute("carpassEstOk");
			log.info(carPass);
			String norme = (String) request.getAttribute("norme");
			log.info(norme);
			String cle = (String) request.getAttribute("cle");
			log.info(cle);
			String numeroChassis = (String) request.getAttribute("numeroChassis");
			log.info(numeroChassis);
			String carnet = (String) request.getAttribute("carnet");
			log.info(carnet);
			String prix = (String) request.getAttribute("prix");
			log.info(prix);
			String titre = (String) request.getAttribute("titre");
			log.info(titre);
			String description = (String) request.getAttribute("description");
			log.info(description);
			String formulaire = (String) request.getAttribute("formulaire");
			log.info(formulaire);
			String save = (String) request.getAttribute("save");
			log.info(save);
			String publish = (String) request.getAttribute("publish");
			log.info(publish);
			
			log.info("==============================================================");
			try {
				Voiture voiture = new Voiture();

				voiture.setVersion(version);
				voiture.setDatePremiereImmatriculation(this.dateSeparator(dateImmatriculation));
				voiture.setTypeCarburant(carburant);
				voiture.setKw(Integer.parseInt(puissance));
				voiture.setModele(VoitureManager.findModele(1));
				voiture.setVitesse(boit);
				voiture.setCouleurExt(VoitureManager.findCouleur(Integer.parseInt(couleurExt)));
				voiture.setCouleurInt(VoitureManager.findCouleur(Integer.parseInt(couleurInt)));
				voiture.setTypePeinture(peinture);
				voiture.setCarrosserie(carrosserie);
				voiture.setTypeSiege(siege);
				voiture.setKilometre(Integer.parseInt(km));
				voiture.setTransmission(transmission);
				voiture.setNombrePortes(Integer.parseInt(portes));
				voiture.setMotorisation(motorisation);
				voiture.setEmissionCO2(Integer.parseInt(co2));
				voiture.setNormeEuropeene(Integer.parseInt(norme));
				voiture.setNombreClefs(Integer.parseInt(cle));
				voiture.setNumeroChassis(numeroChassis);
				voiture.setCarpassEstOk(Integer.parseInt(carPass) == 1);
				voiture.setCarnetEntretien(Integer.parseInt(carnet) == 1);

				Marque m = VoitureManager.findMarque(Integer.parseInt(marque));
				log.debug("Changer en Ajax si on a le temps");
				Modele me = this.creationModele(m);

				int idModele = VoitureManager.createModel(me);

				voiture.setModele(VoitureManager.findModele(idModele));

				voiture.setUtilisateur(UtilisateurManager.findUtilisateur(1));
				int idVoiture = VoitureManager.createVoiture(voiture);
				log.info("ID de la voiture créée: " + idVoiture);

				if (request.getAttribute("file") != null) {
					String nomMedia = (String) request.getAttribute("file");
					Media media = new Media();

					media.setFichier(nomMedia);
					media.setVoiture(VoitureManager.findVoiture(idVoiture));
					media.setType("Image");
					media.setNomMedia(nomMedia);
					VoitureManager.createMedia(media);

					log.info("Le media " + nomMedia + " a bien ete rajout�� la voiture");
				} else {
					log.warn("Pas de media rajoute a la bagnole");
				}

				Annonce annonce = new Annonce();

				annonce.setMontant(Float.parseFloat(prix));
				annonce.setActif( save  == null );
				annonce.setDatePublication(new Date());
				annonce.setDescription(description);
				annonce.setTitre(titre);
				annonce.setUtilisateur(UtilisateurManager.findUtilisateur(1));
				annonce.setVoiture(VoitureManager.findVoiture(idVoiture));

				AnnonceManager.createAnnonce(annonce);
				request = this.setAttributeAnnonce(request, log);
			} catch ( PropertyException | ParseException | WheelUDriveException e) {
//				log.error(e.getCause().getMessage(),e);
				e.printStackTrace();
			    
			}
			

			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			return;

		}
		
		/******************** ./CREATION ANNONCE FIN *****************************/

		// request.setAttribute("page", "home");
		
		log.info("================================================RECUP DES VALUES================================================");

		/******************** RECUP DES VALUES *****************************/
		log.info("===============================");
		log.info("n/ FORMULAIRE D'INSCRIPTION : ");
		log.info("===============================");

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
		String pro = request.getParameter(CHAMP_PROFESSIONNEL);
		log.info("1=Particulier 2=Professionnel : " + pro);
		String proTVA = request.getParameter(CHAMP_PROFESSIONNEL_TVA);
		log.info("TVA  : " + proTVA);
		String pswd = request.getParameter(CHAMP_PASS);
		log.info("PASSWORD : " + pswd);
		String pswdConf = request.getParameter(CHAMP_CONF);
		log.info("PASSWORD CONFIRM : " + pswdConf);
		String dateNaissance = request.getParameter(CHAMP_DATE_NAISSANCE);
		log.info("DATE DE NAISSANCE : " + dateNaissance);

		log.info("===============================");
		log.info("n/ FORMULAIRE DE CONNEXION : ");
		log.info("===============================");

		String emailConnexion = request.getParameter("emailConnexion");
		log.info("EMAIL INPUT CONNEXION : " + emailConnexion);
		String pswdConnexion = request.getParameter("pswdConnexion");
		log.info("PASSWORD INPUT CONNEXION " + pswdConnexion);

		/******************** ./RECUP DES VALUES *****************************/

		log.info("================================================ HOME COUNT & TITLE ANNONCES ================================================");

		/******************** HOME COUNT & TITLE ANNONCES ****************************/

		int countAnnonces;

		try {
			countAnnonces = AnnonceManager.countAnnonces();
			if (countAnnonces == 0) {
				request.setAttribute("titleHomeCountAnnonce", "Les annonces arrivent bientôt!");
			} else {
				request.setAttribute("titleHomeCountAnnonce", countAnnonces + "annonces qui n'attendent que vous!");
			}

		} catch (PropertyException e1) {
			log.error("err countAnnonces:" + e1);
		}

		/********************
		 * ./HOME COUNT & TITLE ANNONCES
		 ****************************/

		log.info("================================================ LISTE CP & VILLES ================================================");

		/******************** LISTE CP VILLES ****************************/
		// ajoute liste CP villes à la request

		try {
			List<CodePostal> listCP = PaysAdresseManager.allCodePostal();
			request.setAttribute("CpVilles", listCP);

		} catch (PropertyException e) {

			log.error("err cp:" + e);
		}

		/******************** ./LISTE CP VILLES **************************/

		/******************** CHECK CONNEXION *****************************/

		if (request.getParameter("emailConnexion") != null) {// si emailConnexion est rempli

			log.info("================================================ CHECK CONNEXION ================================================");

			// connexion
			int isLogged = 0;
			// int err = 0;

			/* Création ou récupération de la session */
			HttpSession session = request.getSession();

			try {

				int userId = UtilisateurManager.findUserId(emailConnexion);

				if (userId != -1) {// si email existe

					String testPswd = UtilisateurManager.findUserPswd(emailConnexion);
					log.info("userid est : " + userId);
					log.info("son pswd est : " + testPswd);
					log.info("Le pswd saisi est : " + pswdConnexion);

					if (testPswd.equals(pswdConnexion)) {// si pswd est indentique a celui lié à l'email

						log.info("pswd ok ! ");
						isLogged = 1;
						session.setAttribute("emailConnexion", emailConnexion);
						session.setAttribute("userId", userId);
						session.setAttribute("isLogged", isLogged);
						request.setAttribute("page", "home");
						request.setAttribute("modalSucessLogin", MODAL_SHOW);
						request.setAttribute("modalSucessLoginD", STYLE_DISPLAY_BLOCK_MODAL);
						request.setAttribute("navFormLog", HTML_LOGGED);
						request.setAttribute("inscriptionForm", "");

						log.info("log ok" + isLogged);
						request = this.setAttributeAnnonce(request, log);

						this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
					} else {

						log.info("pswd inccorect");
						isLogged = 0;
						session.setAttribute("isLogged", isLogged);
						request.setAttribute("navFormLog", HTML_NOTLOGGED);
						request.setAttribute("page", "home");
						request.setAttribute("showModalPswdIncorrect", MODAL_SHOW);
						request.setAttribute("showModalPswdIncorrectD", STYLE_DISPLAY_BLOCK_MODAL);

						this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
					}

				} else {// email existe pas -> créer un compte ?
					isLogged = 0;
					session.setAttribute("isLogged", isLogged);
					request.setAttribute("page", "home");
					request.setAttribute("navFormLog", HTML_NOTLOGGED);
					request.setAttribute("showModalConnexion", MODAL_SHOW);
					request.setAttribute("showModalConnexionD", STYLE_DISPLAY_BLOCK_MODAL);

					this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

				}

			} catch (PropertyException e) {
				log.info("fail");
				log.error(e);
			}

			/* Récupération de l'objet depuis la session */
			String emailConnexionStringRecup = (String) session.getAttribute("emailConnexion");
			log.info("recup email session: " + emailConnexionStringRecup);

			/******************** ./CHECK CONNEXION *****************************/

		} else {

			log.info("================================================ CHECK INSCRIPTION ================================================");

			/******************** CHECK INSCRIPTION *****************************/

			try {

				// si email saisi existe déjà en db
				if (UtilisateurManager.findUserId(email) != -1) {
					request = this.checkSession(request, log);
					request.setAttribute("page", "home");
					request.setAttribute("errEmail", MODAL_SHOW);
					request.setAttribute("db", STYLE_DISPLAY_BLOCK_MODAL);
					log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Cet utilisateur existe d�j� !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
					return;
				}

				if (pswd.equals(pswdConf)) {
					log.info("Les 2 pswd sont identiques");
					request = this.checkSession(request, log);
					// insert des infos cp adress
					Adresse adresse = new Adresse();
					adresse.setCodePostal(PaysAdresseManager.findCodePostal(Integer.parseInt(idCP)));
					adresse.setRue(rue);
					adresse.setNumero(num);
					adresse.setBoite(boite);
					PaysAdresseManager.createAddresse(adresse);

					// insert infos user
					Utilisateur user = new Utilisateur();

					user.setMdp(pswdConf);
					user.setNom(nom);
					user.setPrenom(prenom);
					user.setEmail(email);
					user.setDateNaissance(dateSeparator(dateNaissance));
					user.setTelFixe(telFixe);
					user.setTelMobile(telMobile);
					if (Integer.parseInt(pro) == 2)
						user.setNumeroTVA(proTVA);
					user.setActif(true);
					user.setSupprime(false);
					user.setDateInscription(new Date());
					user.setDateDerniereModification(new Date());
					user.setRole(PermissionsAndRoleManager.findRole(Integer.parseInt(pro)));

					// creation user
					UtilisateurManager.createUtilisateur(user);

					// recup ids pour table adresseUtilisateur
					int idAdresse = PaysAdresseManager.findAdresseId(rue, num, adresse.getCodePostal().getCode());
					log.info("idAdresse : " + idAdresse);
					int idUser = UtilisateurManager.findUserId(email);
					log.info("iduser : " + idUser);
					// creation de adresseUtilistaeur
					UtilisateurManager.createAdresseUtilisateur(PaysAdresseManager.findAdresse(idAdresse),
							UtilisateurManager.findUtilisateur(idUser));

				} else {
					log.info(
							"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 2 PSWD PAS IDENTIQUES !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					request.setAttribute("errPswdNotIdentic", "style=\"display:block\"");
					this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

				}

			} catch (PropertyException | WheelUDriveException | ParseException e) {
				log.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ERROR INSCRIPTION : " + e
						+ "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				this.checkSession(request, log);
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

			}

			request.setAttribute("page", "home");
			request.setAttribute("showModalSuccessCreateUser", MODAL_SHOW);
			request.setAttribute("emailInscription", email);
			request.setAttribute("showModalSuccessCreateUserD", STYLE_DISPLAY_BLOCK_MODAL);
			request.setAttribute("navFormLog", HTML_NOTLOGGED);

			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}

	}

	public Date dateSeparator(String dateString) throws WheelUDriveException, ParseException {

		log.info("input: " + dateString);
		Date dateFinal = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		log.info(dateFinal);

		return dateFinal;

	}

	private Modele creationModele(Marque marque) {

		Modele modele = new Modele();

		modele.setMarque(marque);
		modele.setNom(marque.getNom() + " - " + this.generateString(6));
		return modele;

	}

	private String generateString(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String pass = "";
		for (int x = 0; x < length; x++) {
			int i = (int) Math.floor(Math.random() * 62);
			pass += chars.charAt(i);
		}
		log.debug(pass);
		return pass;
	}
}
