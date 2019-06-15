package com.wheeludrive.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.log4j.Logger;

import com.wheeludrive.beans.UtilisateurBean;
import com.wheeludrive.beans.VoitureBean;
import com.wheeludrive.beans.converters.UtilisateurBeanConverter;
import com.wheeludrive.beans.converters.VoitureBeanConverter;
import com.wheeludrive.domain.PropertiesManager;
import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.Marque;
import com.wheeludrive.entity.Media;
import com.wheeludrive.entity.Modele;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.AnnonceManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.entity.manager.VoitureManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.tools.Mail;
import com.wheeludrive.tools.MediaManager;

@WebServlet(urlPatterns = { "/wheeludrive/vehicule" })
public class VehiculeServlet extends AbstractWheelUDriveServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Voiture car;
	private final static Logger log = Logger.getLogger(VehiculeServlet.class);
	private final String VENDEUR = "vendeur";
	

	private final String ID_VOITURE = "id_voiture";

	// mail part
	private final String EMAIL_PROCESS_ERROR = "sendMailError";
	private final String EMAIL_PROCESS_SUCCESS = "sendMailSuccess";
	public final String CONTACT_VENDEUR_TEMPLATE = "/WEB-INF/wheeludrive/mail/contactVendeur.jsp";

	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idCar = Integer.parseInt(request.getParameter("id"));
			log.info("id de la voiture concernée: "+ idCar );
			this.car = VoitureManager.findVoiture(idCar);
			request.setAttribute("page", "vehicule");

			// TODO A propager dans les autres servlet
			request = this.checkSession(request, log);

			PropertiesManager prop = new PropertiesManager();
			if (!car.getMedias().isEmpty()) {

				File file = new File(prop.getFolderMedia() + "/" + this.car.getMedias().get(0).getFichier());
				String b64File = MediaManager.encodeFileToBase64Binary(file);
				log.info("b64: " + b64File);

				request.setAttribute("photo", b64prefix + b64File);
			} else {
				request.setAttribute("photo", request.getContextPath() + noPhoto);
			}

			UtilisateurBean userBean = UtilisateurBeanConverter.convert(car.getUtilisateur());

			request.setAttribute(VENDEUR, userBean);
			VoitureBean bean = VoitureBeanConverter.convert(this.car);

			// j'ai besoin de l'id voiture donc je rajotue ce champ car dans bean on ne le
			// retrouve pas
			request.setAttribute("id_voiture", this.car.getId());
			request.setAttribute("id_vendeur", car.getUtilisateur().getId());

			request.setAttribute("voiture", bean);

			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		} catch (PropertyException e) {
			log.error("Probleme: ", e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "vehicule");
		request = this.checkSession(request, log);

		// check if sendMail was submitted
		String sendMail = request.getParameter("sendMail");

		if (sendMail != null) {
			// get email sender
			Utilisateur sender = null;
			try {
				if (request.getSession().getAttribute("userId") == null) {
					request.setAttribute(EMAIL_PROCESS_ERROR,
							"Vous devez Ãªtre connecte pour pouvoir contacter un vendeur.");
					request.getRequestDispatcher(VUE).forward(request, response);
					return;
				}
				sender = UtilisateurManager.findUtilisateur((int) request.getSession().getAttribute("userId"));
			} catch (PropertyException e) {
				request.setAttribute(EMAIL_PROCESS_ERROR,
						"Le compte utilise pour envoyer le mail est invalide. Aucun utilisateur associe.");
				e.printStackTrace();
				request.getRequestDispatcher(VUE).forward(request, response);
				return;
			}

			String message = (String) request.getParameter("email_message");

			if (message.matches("^[<>={}]*$")) {
				request.setAttribute(EMAIL_PROCESS_ERROR,
						"Contenu du message non valide. N'utilisez pas de caracteres speciaux. (Les caracteres <, >, =, {, }) sont interdit");
				log.debug("Contenu du mail invalide");
				request.getRequestDispatcher(VUE).forward(request, response);
				return;
			}

			Voiture voiture = null;
			try {
				voiture = VoitureManager.findVoiture(Integer.parseInt(request.getParameter(ID_VOITURE)));
			} catch (NumberFormatException e) {
				log.debug(e.getMessage());
				log.debug("Valeur passee en parametre : " + request.getParameter("id_voiture"));
				e.printStackTrace();
				request.setAttribute(EMAIL_PROCESS_ERROR,
						"Une erreur s'est produite lors de l'envoi de l'email. Veuillez reessayer plus tard.");
				request.getRequestDispatcher(VUE).forward(request, response);
				return;
			} catch (PropertyException e) {
				log.debug(e.getMessage());
				e.printStackTrace();
				request.setAttribute(EMAIL_PROCESS_ERROR, "La voiture choisie n'existe pas.");
				request.getRequestDispatcher(VUE).forward(request, response);
				return;
			}

			Utilisateur dest = null;
			try {
				dest = UtilisateurManager.findUtilisateur(Integer.parseInt(request.getParameter("id_vendeur")));
			} catch (NumberFormatException e) {
				log.debug(e.getMessage());
				log.debug("Valeur passee en parametre : " + request.getParameter("id_vendeur"));
				e.printStackTrace();
				request.setAttribute(EMAIL_PROCESS_ERROR,
						"Une erreur s'est produite lors de l'envoi de l'email. Veuillez reessayer plus tard.");
				request.getRequestDispatcher(VUE).forward(request, response);
				return;
			} catch (PropertyException e) {
				request.setAttribute(EMAIL_PROCESS_ERROR,
						"Le proprietaire de la voiture n'est plus un utilisateur du site.");
				e.printStackTrace();
				request.getRequestDispatcher(VUE).forward(request, response);
				return;
			}

			List<String> email = new ArrayList<String>();
			// pour avoir plus facile lors des tests
			email.add("projetjava2019@gmail.com");
			email.add(dest.getEmail());

			try {
				// pour pouvoir rï¿½cupï¿½rer l'html gï¿½nï¿½rï¿½ depuis du jsp ,et le convertir en pdf
				HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response) {
					private final StringWriter sw = new StringWriter();

					@Override
					public PrintWriter getWriter() throws IOException {
						return new PrintWriter(sw);
					}

					@Override
					public String toString() {
						return sw.toString();
					}
				};

				// init template values
				request.setAttribute("mail_content", message.replaceAll("(\r\n|\n)", "<br />"));
				request.setAttribute("sender_name", sender.getPrenom() + " " + sender.getNom());
				request.setAttribute("sender_email", sender.getEmail());

				// generate mail tempate
				request.getRequestDispatcher(CONTACT_VENDEUR_TEMPLATE).include(request, responseWrapper);
				String content = responseWrapper.toString();

				// objet du mail
				String objet = "Demande de contact de " + sender.getPrenom() + " " + sender.getNom() + " - Vehicule : "
						+ voiture.getModele().getNom() + " " + voiture.getModele().getMarque().getNom();

				Mail.getInstance().sendEmail(email, objet, content);
				request.setAttribute(EMAIL_PROCESS_SUCCESS, "L'email a bien ete envoye.");
				request.getRequestDispatcher(VUE).forward(request, response);
				return;
			} catch (AddressException e) {
				log.debug(e.getMessage());
				e.printStackTrace();
				request.setAttribute(EMAIL_PROCESS_ERROR, "L'adresse email liee a votre compte est invalide");
				request.getRequestDispatcher(VUE).forward(request, response);
				return;
			} catch (MessagingException e) {
				log.debug(e.getMessage());
				e.printStackTrace();
				request.setAttribute(EMAIL_PROCESS_ERROR,
						"Une erreur s'est produite lors de l'envoie de l'email. Veuillez reessayer plus tard.");
				request.getRequestDispatcher(VUE).forward(request, response);
				return;
			}
		} else {
			try {
				request = MediaManager.storeMediaFromRequest(request);
				log.info(request.getAttribute("file"));
			} catch (Exception e1) {
				log.error(e1);
			}

			String marque = (String) request.getAttribute("marque");
			log.info(marque);
//			String modele = (String) request.getAttribute ("modele");
//			log.info(modele);
			String version = (String) request.getAttribute("version");
			log.info(version);
			String dateImmatriculation = (String) request.getAttribute("date");
			log.info(dateImmatriculation);
			String carburant = (String) request.getAttribute("carburant");
			log.info(carburant);
			String puissance = (String) request.getAttribute("puissance");
			log.info(puissance);
			String boite = (String) request.getAttribute("boite");
			log.info(boite);
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

			if (request.getAttribute("formulaire").equals("annonce")) {

				try {
					Voiture voiture = new Voiture();

					voiture.setVersion(version);
					voiture.setDatePremiereImmatriculation(this.dateSeparator(dateImmatriculation));
					voiture.setTypeCarburant(carburant);
					voiture.setKw(Integer.parseInt(puissance));
					voiture.setModele(VoitureManager.findModele(1));
					voiture.setVitesse(boite);
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
					log.info("ID de la voiture creee: " + idVoiture);

					if (request.getAttribute("file") != null) {
						String nomMedia = (String) request.getAttribute("file");
						Media media = new Media();

						media.setFichier(nomMedia);
						media.setVoiture(VoitureManager.findVoiture(idVoiture));
						media.setType("Image");
						media.setNomMedia(nomMedia);
						VoitureManager.createMedia(media);

						log.info("Le media " + nomMedia + "a bien ete ajoute a  la voiture");
					} else {
						log.warn("Pas de media rajoute a  la bagnole");
					}

					Annonce annonce = new Annonce();

					annonce.setMontant(Float.parseFloat(prix));
					annonce.setActif(true);
					annonce.setDatePublication(new Date());
					annonce.setDescription(description);
					annonce.setTitre(titre);
					annonce.setUtilisateur(UtilisateurManager.findUtilisateur(1));
					annonce.setVoiture(VoitureManager.findVoiture(idVoiture));

					AnnonceManager.createAnnonce(annonce);
				} catch (Exception e) {
					log.error(e);
				}
			}
		}

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
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
