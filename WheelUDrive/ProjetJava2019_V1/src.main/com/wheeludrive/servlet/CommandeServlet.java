package com.wheeludrive.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class CommandeServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private Commande commande = new Commande();
	private Contrat contrat = new Contrat();
	private Facture facture = new Facture();
	private final static Logger log = Logger.getLogger(CommandeServlet.class);
	private final String ID_UTILISATEUR = "id_utilisateur";
	private final String ID_ANNONCE = "id_annonce";

	public final String VUE = "/WEB-INF/wheeludrive/home.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "commande");
		try {
			Annonce anc = AnnonceManager.findAnnonce(Integer.parseInt(request.getParameter(ID_ANNONCE)));
			Utilisateur usr = UtilisateurManager.findUtilisateur(Integer.parseInt(request.getParameter(ID_UTILISATEUR)));

			
			float tva = usr.getAdressesUtilisateurs().get(0).getAdresse().getCodePostal().getPays().getTauxTVA();
			
			//s'il n'y a pas de tva, la prix htva est fixe
			if(tva == 0) {
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
			
			//On retire l'annonce de la vente
			anc.setActif(false);
			AnnonceManager.updateAnnonce(anc);
			
			// on remplis le champ de la facture
			this.facture.setDateFacture(new Date());
			this.facture.setCommande(this.commande);
			FactureManager.createFacture(this.facture);
			
			
			//TO DO
			//Envoyer un mail comme quoi son achat est valid� a l'acheteur
			//renvoyer vers la bonne vue.
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		} catch (PropertyException e) {
			log.error("Probleme: ",e);
		}
	}

}