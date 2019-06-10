package com.wheeludrive.tools;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.wheeludrive.entity.Adresse;
import com.wheeludrive.entity.AdresseUtilisateur;
import com.wheeludrive.entity.Commande;
import com.wheeludrive.entity.Contrat;
import com.wheeludrive.entity.Facture;
import com.wheeludrive.entity.Utilisateur;
import com.wheeludrive.entity.Voiture;
import com.wheeludrive.entity.manager.UtilisateurManager;
import com.wheeludrive.exception.PropertyException;

public class PDF {
	private static PDF _instance = null;

	private Facture facture;
	private Commande commande;
	private Utilisateur utilisateur;
	private AdresseUtilisateur adresseUtilisateur;
	private Adresse adresse;
	private List<Contrat> contrats;
	private List<Voiture> voitures;
	private List<Utilisateur> vendeurs;

	private PDF() {

	}

	public Facture getFacture() {
		return this.facture;
	}

	private void setFacture(Facture facture) {
		this.facture = facture;
	}

	public List<Utilisateur> getVendeurs() {
		return this.vendeurs;
	}

	private void setVendeurs(List<Utilisateur> vendeurs) {
		this.vendeurs = vendeurs;
	}

	public List<Voiture> getVoitures() {
		return this.voitures;
	}

	private void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public List<Contrat> getContrats() {
		return this.contrats;
	}

	private void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	private void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public AdresseUtilisateur getAdresseUtilisateur() {
		return this.adresseUtilisateur;
	}

	private void setAdresseUtilisateur(AdresseUtilisateur adresseUtilisateur) {
		this.adresseUtilisateur = adresseUtilisateur;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	private void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Commande getCommande() {
		return this.commande;
	}

	private void setCommande(Commande commande) {
		this.commande = commande;
	}

	public static PDF getInstance() {
		if (PDF._instance == null) {
			PDF._instance = new PDF();
		}

		return PDF._instance;
	}

	public Map<String, Object> getPDFValues() throws PropertyException {
		HashMap<String, Object> values = new HashMap<String, Object>();

		Utilisateur user = UtilisateurManager.findUtilisateur(1);
		values.put("user", (Object) user);

		return values;
	}

	public boolean generateInvoicePDF(Facture facture, ByteArrayOutputStream output) throws DocumentException {
		this.facture = facture;

		// get all needed data to create the pdf, if something is missing, generation
		// must fail
		if (!this.initPDFData()) {
			return false;
		}

		for (Utilisateur vendeur : this.getVendeurs()) {
			// pour chaque, générer pdf (/!\ avec voitures et contrats concernés)
			Document document = new Document();
			PdfWriter.getInstance(document, output);
			document.open();
			document.add(new Paragraph("salut lol"));
			document.close();

			XMLWorkerHelper x = XMLWorkerHelper.getInstance();

		}
		return true;
	}

	public boolean initPDFData() {
		// déjà get toutes les infos pui on verra pour le reste
		Commande commande = facture.getCommande();
		if (commande == null) {
			return false;
		}
		this.setCommande(commande);

		Utilisateur user = commande.getUtilisateur();
		if (user == null) {
			return false;
		}
		this.setUtilisateur(utilisateur);

		// on récup la premiere adresse du client
		List<AdresseUtilisateur> userAddresses = user.getAdressesUtilisateurs();
		if (userAddresses.size() <= 0) {
			System.out.println("useraddress list");
			return false;
		}
		AdresseUtilisateur userAddress = userAddresses.get(0);
		if (userAddress == null) {
			System.out.println("useradress");
			return false;
		}
		this.setAdresseUtilisateur(userAddress);

		Adresse address = userAddress.getAdresse();
		if (address == null) {
			System.out.println("adress");
			return false;
		}
		this.setAdresse(address);

		// get les items qu'il a commandé
		List<Contrat> contrats = commande.getContrats();
		if (contrats.size() <= 0) {
			System.out.println("liste contrats");
			return false;
		}
		this.setContrats(contrats);

		// donc dans le pdf genre mettre,
		// voiture concernée : (on peut la récup dans les contrats, donc au pire faire
		// genre une liste avec les voitures concernées par les contrats
		// et puis dans le détail de la row voiture, mettre les contrats concernés
		List<Utilisateur> vendeurs = new ArrayList<>();
		List<Voiture> concernedCars = new ArrayList<>();
		for (Contrat c : contrats) {
			Voiture v = c.getVoiture();
			if (v != null) {
				concernedCars.add(v);
				vendeurs.add(v.getUtilisateur());
			}
		}
		this.setVoitures(concernedCars);
		this.setVendeurs(vendeurs);

		return true;
	}

	private Adresse getVendeurAdresse(Utilisateur vendeur) {
		return vendeur.getAdressesUtilisateurs().get(0).getAdresse();
	}
}
