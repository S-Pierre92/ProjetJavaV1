package com.wheeludrive.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

@WebServlet(urlPatterns = { "/wheeludrive/commande" })
public class CommandeServlet extends AbstractWheelUDriveServlet {


	private static final long serialVersionUID = 1L;

	private final static Logger log = Logger.getLogger(CommandeServlet.class);

	private final String ID_ANNONCE = "annonce";

	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request = this.checkSession(request, log);
		HttpSession session = request.getSession();
		request.setAttribute("page", "home");
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
				 * Averti le client que son achat a ete valide
				 */
				try {
					this.generateCommand(request);

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

	private void generateCommand(HttpServletRequest request) throws NumberFormatException, PropertyException {

		Annonce anc = AnnonceManager.findAnnonce(Integer.parseInt(request.getParameter(ID_ANNONCE)));
		Utilisateur usr = UtilisateurManager.findUtilisateur((int)request.getSession().getAttribute("userId"));
		
		Commande commande = new Commande();
		Contrat contrat = new Contrat();

		float tva = usr.getAdressesUtilisateurs().get(0).getAdresse().getCodePostal().getPays().getTauxTVA();

		//s'il n'y a pas de tva, la prix htva est fixe
		if(tva <= 0) {
			tva = 0.21f;
		}

		// On rempli les differents champs afin de completer le contrat (detail commande)
		contrat.setVoiture(anc.getVoiture());
		
		// On rempli le bon selon si c'est un particulier ou un professionnel
		if(usr.getNumeroTVA() != null || usr.getNumeroTVA() =="") {
			contrat.setMontantTTC(anc.getMontant()*(1+tva));
		}else {
			contrat.setMontantHT(anc.getMontant());		
		}
		
		contrat.setTypesContrat(ContratCommandeManager.findTypesContrat(1));


		// on remplis les differents champ de la commande
		commande.setTvaCourante(tva);
		commande.setDateCommande((new Date()));
		commande.setMontantTotalHtva(anc.getMontant());
		commande.setUtilisateur(usr);

		ContratCommandeManager.createCommande(commande);

		contrat.setCommande(commande);

		ContratCommandeManager.createContrat(contrat);
	}
}
