package com.wheeludrive.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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

import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.Commande;
import com.wheeludrive.entity.Contrat;
import com.wheeludrive.entity.Facture;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.manager.AnnonceManager;
import com.wheeludrive.entity.manager.ContratCommandeManager;
import com.wheeludrive.entity.manager.FactureManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.tools.Mail;

@WebServlet(urlPatterns = { "/wheeludrive/validatecommande" })
public class ValidateCommandeServlet extends AbstractWheelUDriveServlet {


	private static final long serialVersionUID = 1L;

	private final static Logger log = Logger.getLogger(ValidateCommandeServlet.class);

	private final String ID_ANNONCE = "annonce";
	private final String ID_ACHETEUR = "acheteur";	

	private final String VALIDATION_PROCESS_ERROR = "sendValidationError";
	private final String VALIDATION_PROCESS_SUCCESS = "sendValidationSuccess";
	public final String CONTACT_ACHETEUR_TEMPLATE = "/WEB-INF/wheeludrive/mail/contactAcheteur.jsp";

	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";

	/*public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request = this.checkSession(request, log);
		HttpSession session = request.getSession();
		request.setAttribute("page", "home");
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}*/

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.info("==========DANS LE POST DU VALIDATE COMMANDE========");

		request.setAttribute("page", "home");
		request = this.checkSession(request, log);

		/* Genere les valeurs pour la commande
		 * Genere les valeurs pour la facture
		 * Desactive l'annonce du vendeur
		 * Averti le client que son achat a ete valide
		 */

		try {
			log.info("======VALIDATION COMMANDE========");

			this.choseCommand(request, response);

			log.info("======ENVOI MAIL========");

			this.sendMailToCustomer(request, response);

		} catch (NumberFormatException | PropertyException e) {
			log.debug(e.getMessage());
		}
		//this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	private void choseCommand(HttpServletRequest request, HttpServletResponse response) throws IOException, NumberFormatException, PropertyException, ServletException {
		
		int acheteurId;
		try {
			acheteurId = Integer.parseInt(request.getParameter(ID_ACHETEUR));
		}
		catch (NumberFormatException e) {
			request.setAttribute(VALIDATION_PROCESS_ERROR, "Aucun utilisateur sélectionné!");
			e.printStackTrace();
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		}
		
		/*TODO need l'id annonce, un champ hidden par annonce peut-etre
		Annonce annonce = null;
		try {
			annonce = AnnonceManager.findAnnonce(Integer.parseInt(request.getParameter(ID_ANNONCE)));
		} catch (NumberFormatException e) {
			log.debug(e.getMessage());
			log.debug("Valeur passée en paramètre : " + request.getParameter("annonce"));
			e.printStackTrace();
			request.setAttribute(VALIDATION_PROCESS_ERROR,
					"Une erreur s'est produite lors de la validation. Veuillez réessayer plus tard.");
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		} catch (PropertyException e) {
			log.debug(e.getMessage());
			e.printStackTrace();
			request.setAttribute(VALIDATION_PROCESS_ERROR, "L'annonce choisie n'existe pas.");
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		}*/

		Annonce annonce = AnnonceManager.findAnnonce(1);

		
		log.info("===============================DESACTIVATION DE L'ANNONCE==================================");
		annonce.setActif(false);
		AnnonceManager.updateAnnonce(annonce);

		List<Contrat> contrats = annonce.getVoiture().getContrats();
		List<Commande> commandes = new ArrayList<Commande>();

		for(Contrat ctt : contrats) {
			commandes.add(ctt.getCommande());
		}

		for(Commande commande : commandes) {
			if(commande.getUtilisateur().getId() == acheteurId) {
				log.info("==========L'UTILISATEUR CHOISIS A ETE TROUVE============");
				this.generateFacture(commande.getId());
			}
			else {
				ContratCommandeManager.deleteCommande(commande.getId());
			}
		}		
	}

	private void generateFacture(int idCommande) throws NumberFormatException, PropertyException {

		Facture facture = new Facture();
		Commande commande = ContratCommandeManager.findCommande(idCommande);

		log.info("===============================GENERATION DE LA FACTURE==================================");
		// on remplis le champ de la facture
		facture.setDateFacture(new Date());
		facture.setCommande(commande);
		FactureManager.createFacture(facture);
	}

	private void sendMailToCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		Utilisateur sender = null;
		try {
			if (request.getSession().getAttribute("userId") == null) {
				request.setAttribute(VALIDATION_PROCESS_ERROR,
						"Vous devez être connecté pour pouvoir contacter un vendeur.");
				request.getRequestDispatcher(VUE).forward(request, response);
				return;
			}
			sender = UtilisateurManager.findUtilisateur((int) request.getSession().getAttribute("userId"));
		} catch (PropertyException e) {
			request.setAttribute(VALIDATION_PROCESS_ERROR,
					"Le compte utilisé pour envoyer le mail est invalide. Aucun utilisateur associé.");
			e.printStackTrace();
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		}

		String message = (String) request.getParameter("email_message");

		if (message.matches("^[<>={}]*$")) {
			request.setAttribute(VALIDATION_PROCESS_ERROR,
					"Contenu du message non valide. N'utilisez pas de caractères spéciaux. (Les caractères <, >, =, {, }) sont interdit");
			log.debug("Contenu du mail invalide");
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		}

		Annonce annonce = null;
		try {
			// TODO same as first
			//annonce = AnnonceManager.findAnnonce(Integer.parseInt(request.getParameter(ID_ANNONCE)));
			annonce = AnnonceManager.findAnnonce(1);
		} catch (NumberFormatException e) {
			log.debug(e.getMessage());
			log.debug("Valeur passée en paramètre : " + request.getParameter("annonce"));
			e.printStackTrace();
			request.setAttribute(VALIDATION_PROCESS_ERROR,
					"Une erreur s'est produite lors de l'envoi de l'email. Veuillez réessayer plus tard.");
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		} catch (PropertyException e) {
			log.debug(e.getMessage());
			e.printStackTrace();
			request.setAttribute(VALIDATION_PROCESS_ERROR, "L'annonce choisie n'existe pas.");
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		}

		Utilisateur dest = null;
		try {
			dest = UtilisateurManager.findUtilisateur(Integer.parseInt(request.getParameter("acheteur")));
		} catch (NumberFormatException e) {
			log.debug(e.getMessage());
			log.debug("Valeur passée en paramètre : " + request.getParameter("acheteur"));
			e.printStackTrace();
			request.setAttribute(VALIDATION_PROCESS_ERROR,
					"Une erreur s'est produite lors de l'envoi de l'email. Veuillez réessayer plus tard.");
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		} catch (PropertyException e) {
			request.setAttribute(VALIDATION_PROCESS_ERROR,
					"L'acheteur que vous essaye de contacter n'est plus un utilisateur du site.");
			e.printStackTrace();
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		}

		List<String> email = new ArrayList<String>();
		// pour avoir plus facile lors des tests
		email.add("projetjava2019@gmail.com");
		email.add(dest.getEmail());

		try {
			// pour pouvoir récupérer l'html généré depuis du jsp ,et le convertir en pdf
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
			request.getRequestDispatcher(CONTACT_ACHETEUR_TEMPLATE).include(request, responseWrapper);
			String content = responseWrapper.toString();

			// objet du mail
			String objet = "Le vendeur " + sender.getPrenom() + " " + sender.getNom() + " - Annonce : "
					+ annonce.getTitre() + " - " + annonce.getDescription() + "Vous trouverez votre facture dans la partie "
							+ "\"mes commandes\" de votre compte.";

			//Mail.getInstance().sendEmail(email, objet, content);
			request.setAttribute(VALIDATION_PROCESS_SUCCESS, "La validation de la vente a bien été effectuée."+
			" La facture générée et l'acheteur prévenu par email.");
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		} catch (Exception e) {
			log.debug(e.getMessage());
			e.printStackTrace();
			request.setAttribute(VALIDATION_PROCESS_ERROR, "L'adresse email liée a votre compte est invalide");
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		} /*catch (MessagingException e) {
			log.debug(e.getMessage());
			e.printStackTrace();
			request.setAttribute(VALIDATION_PROCESS_ERROR,
					"Une erreur s'est produite lors de l'envoie de l'email. Veuillez réessayer plus tard.");
			request.getRequestDispatcher(VUE).forward(request, response);
			return;
		}*/
	}

}
