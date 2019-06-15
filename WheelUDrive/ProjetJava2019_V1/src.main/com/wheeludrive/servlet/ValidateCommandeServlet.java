package com.wheeludrive.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.itextpdf.text.xml.simpleparser.NewLineHandler;
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

@WebServlet(urlPatterns = { "/wheeludrive/validatecommande" })
public class ValidateCommandeServlet extends AbstractWheelUDriveServlet {


	private static final long serialVersionUID = 1L;

	private Commande commande = new Commande();
	private Contrat contrat = new Contrat();
	private Facture facture = new Facture();

	private final static Logger log = Logger.getLogger(CommandeServlet.class);

	private final String ID_ANNONCE = "id_annonce";
	private final String ID_ACHETEUR = "id_acheteur";

	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request = this.checkSession(request, log);
		HttpSession session = request.getSession();
		request.setAttribute("page", "home");
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.debug("==========DANS LE POST DU VALIDATE COMMANDE========");
		request = this.checkSession(request, log);
		HttpSession session = request.getSession();
		request.setAttribute("page", "home");
		if (null != session.getAttribute("isLogged")) {

			int isLogged = (int) session.getAttribute("isLogged");
			if (isLogged == 1) {
				request.setAttribute("navFormLog", HTML_LOGGED);

				/* Genere les valeurs pour la commande
				 * Genere les valeurs pour la facture
				 * Desactive l'annonce du vendeur
				 * Averti le client que son achat a ete valide
				 */
				try {
					this.choseCommand(request);
					this.generateFacture();

					//TODO methode fantome a faire pour plus tard
					this.sendMailToCustomer();

				} catch (NumberFormatException | PropertyException e) {
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

	private void choseCommand(HttpServletRequest request) throws NumberFormatException, PropertyException {

		Annonce annonce = AnnonceManager.findAnnonce(Integer.parseInt(request.getParameter(ID_ANNONCE)));
		//Utilisateur usr = UtilisateurManager.findUtilisateur((int)request.getSession().getAttribute("userId"));
		Utilisateur acheteur = UtilisateurManager.findUtilisateur(Integer.parseInt(request.getParameter(ID_ACHETEUR)));

		annonce.setActif(false);
		AnnonceManager.updateAnnonce(annonce);
		
		annonce.getVoiture().getContrats();
	}


	private void generateFacture() throws NumberFormatException, PropertyException {
		// on remplis le champ de la facture
		this.facture.setDateFacture(new Date());
		this.facture.setCommande(this.commande);
		FactureManager.createFacture(this.facture);
	}

	private void sendMailToCustomer() {

		//TODO
		//Envoyer un mail comme quoi son achat est valid� a l'acheteur
		//
	}

}
