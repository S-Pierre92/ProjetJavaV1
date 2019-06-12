package com.wheeludrive.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.AdresseUtilisateur;
import com.wheeludrive.entity.Annonce;
import com.wheeludrive.entity.Commande;
import com.wheeludrive.entity.Contrat;
import com.wheeludrive.entity.Pays;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.manager.AnnonceManager;
import com.wheeludrive.entity.manager.ContratCommandeManager;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.tools.DateUtils;
import com.wheeludrive.exception.PropertyException;

@WebServlet(urlPatterns = { "/wheeludrive/commande" })
public class CommandeServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private Commande cmd = new Commande();
	private Contrat ctt = new Contrat();
	private final static Logger log = Logger.getLogger(CommandeServlet.class);
	private final String ID_UTILISATEUR = "id_utilisateur";
	private final String ID_ANNONCE = "id_annonce";

	public final String VUE = "/WEB-INF/wheeludrive/index.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Annonce anc = AnnonceManager.findAnnonce(Integer.parseInt(request.getParameter(ID_ANNONCE)));
			Utilisateur usr = UtilisateurManager.findUtilisateur(Integer.parseInt(request.getParameter(ID_UTILISATEUR)));

			float tva = usr.getAdressesUtilisateurs().get(0).getAdresse().getCodePostal().getPays().getTauxTVA();
			
			//s'il n'y a pas de tva, la prix htva est fixe
			if(tva == 0) {
				tva = 1;
			}
			log.debug( "ceci :" + anc.getDescription());
			this.ctt.setVoiture(anc.getVoiture());
			this.ctt.setMontantHT(anc.getMontant());
			this.ctt.setMontantTTC(anc.getMontant()*tva);
			this.ctt.setTypesContrat(ContratCommandeManager.findTypesContrat(1));
			

			
			this.cmd.setTvaCourante(tva);
			this.cmd.setDateCommande((new Date()));
			this.cmd.setMontantTotalHtva(anc.getMontant());
			this.cmd.setUtilisateur(anc.getUtilisateur());
			
			ContratCommandeManager.createCommande(this.cmd);
			
			this.ctt.setCommande(this.cmd);
			
			ContratCommandeManager.createContrat(this.ctt);
			//TO DO renvoyer vers la bonne vue.
			//this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		} catch (PropertyException e) {
			log.error("Probleme: ",e);
		}
	}

}
