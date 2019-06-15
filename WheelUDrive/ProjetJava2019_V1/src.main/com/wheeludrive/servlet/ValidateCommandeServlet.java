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
	List<Utilisateur> acheteurs = new ArrayList<Utilisateur>();

	private final static Logger log = Logger.getLogger(CommandeServlet.class);

	private final String ID_ANNONCE = "id_annonce";

	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request = this.checkSession(request, log);
		HttpSession session = request.getSession();
		request.setAttribute("page", "home");
		if (null != session.getAttribute("isLogged")) {

			int isLogged = (int) session.getAttribute("isLogged");
			if (isLogged == 1) {
				request.setAttribute("navFormLog", HTML_LOGGED);
				try {
					log.info("=======BEFORE LIST ACHETEUR SERVLET VALIDATE COMMANDE==========");
					listAcheteurs();
					log.info("=======AFTER LIST ACHETEUR SERVLET VALIDATE COMMANDE==========");
					request.setAttribute("acheteurs", acheteurs);
				} catch (NumberFormatException |PropertyException e) {
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

		Annonce anc = AnnonceManager.findAnnonce(Integer.parseInt(request.getParameter(ID_ANNONCE)));
		Utilisateur usr = UtilisateurManager.findUtilisateur((int)request.getSession().getAttribute("userId"));

		float tva = usr.getAdressesUtilisateurs().get(0).getAdresse().getCodePostal().getPays().getTauxTVA();

		//s'il n'y a pas de tva, la prix htva est fixe
		if(tva <= 0) {
			tva = 0.21f;
		}

		// On rempli les differents champs afin de completer le contrat (detail commande)
		this.contrat.setVoiture(anc.getVoiture());
		this.contrat.setMontantHT(anc.getMontant());
		this.contrat.setMontantTTC(anc.getMontant()*(1+tva));
		this.contrat.setTypesContrat(ContratCommandeManager.findTypesContrat(1));


		// on remplis les differents champ de la commande
		this.commande.setTvaCourante(tva);
		this.commande.setDateCommande((new Date()));
		this.commande.setMontantTotalHtva(anc.getMontant());
		this.commande.setUtilisateur(usr);

		ContratCommandeManager.createCommande(this.commande);

		this.contrat.setCommande(this.commande);

		ContratCommandeManager.createContrat(this.contrat);

		anc.setActif(false);
		AnnonceManager.updateAnnonce(anc);
	}
	
	private void listAcheteurs() throws NumberFormatException, PropertyException {

		log.info("=======IN LIST ACHETEUR SERVLET VALIDATE COMMANDE==========");
		Annonce annonce = AnnonceManager.findAnnonce(1);
		
		//recupere tout le contrat avec le meme car id de l'annonce
		List<Contrat> contrats = ContratCommandeManager.findAllContratForSpecificCar(annonce.getVoiture().getId());
		
		//ensuite recuperer tout les commande lie a ces contrat
		//puis liste les user de ces commande
		for(Contrat contrat : contrats) {
			this.acheteurs.add(contrat.getCommande().getUtilisateur());
		}
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
