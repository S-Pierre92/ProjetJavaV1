package com.wheeludrive.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "voitures")
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VOITURE")
	private int id;

	// bi-directional many-to-one association to Couleur
	@ManyToOne
	@JoinColumn(name = "ID_COULEUR_INTERIEURE")
	private Couleur couleurInt;

	// bi-directional many-to-one association to Couleur
	@ManyToOne
	@JoinColumn(name = "ID_COULEUR_EXTERIEURE")
	private Couleur couleurExt;

	// bi-directional many-to-one association to ModelesVoiture
	@ManyToOne
	@JoinColumn(name = "ID_MODELE_VOITURE")
	private Modele modele;

	// bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name = "ID_UTILISATEUR_PROPRIETAIRE", nullable = false)
	private Utilisateur utilisateur;

	@Column(name = "est_aux_encheres_")
	private boolean estAuxEncheres;

	@Column(name = "est_supprime")
	private boolean estSupprimee;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_ajout")
	private Date dateAjout;

	@Column(name = "carnet_entretien")
	private boolean carnetEntretien;

	@Column(name = "kilometre")
	private int kilometre;

	@Column(name = "type_carburant")
	private String typeCarburant;

	@Column(name = "cv")
	private int cv;

	@Column(name = "kw")
	private int kw;

	@Column(name = "cylindree")
	private int cylindree;

	@Column(name = "transmission")
	private String transmission;

	@Column(name = "vitesse")
	private int vitesse;

	@Column(name = "motorisation")
	private String motorisation;

	@Column(name = "emission_co2")
	private int emissionCO2;

	@Column(name = "carpasse_est_ok")
	private boolean carpassEstOk;

	@Column(name = "norme_europeenne")
	private int normeEuropeene;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_premiere_immatriculation")
	private Date datePremiereImmatriculation;

	@Column(name = "nombre_clefs")
	private int nombreClefs;

	@Column(name = "numero_chassis")
	private String numeroChassis;

	@Column(name = "type_siege")
	private String typeSiege;

	@Column(name = "type_peinture_")
	private String typePeinture;

	@Column(name = "nombre_portes")
	private int nombrePortes;

	@Column(name = "carroserie")
	private String carrosserie;

	@Column(name = "version")
	private String version;

	// bi-directional many-to-one association to Annonce
	@OneToMany(mappedBy = "voiture", fetch = FetchType.EAGER)
	private List<Annonce> annonces;

	// bi-directional many-to-one association to Contrat
	@OneToMany(mappedBy = "voiture", fetch = FetchType.EAGER)
	private List<Contrat> contrats;

	// bi-directional many-to-one association to Enchere
	@OneToMany(mappedBy = "voiture", fetch = FetchType.EAGER)
	private List<Enchere> encheres;

	// bi-directional many-to-one association to Enchere
	@OneToMany(mappedBy = "voiture", fetch = FetchType.EAGER)
	private List<Media> medias;

	public Couleur getCouleurInt() {
		return couleurInt;
	}

	public void setCouleurInt(Couleur couleurInt) {
		this.couleurInt = couleurInt;
	}

	public Couleur getCouleurExt() {
		return couleurExt;
	}

	public void setCouleurExt(Couleur couleurExt) {
		this.couleurExt = couleurExt;
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public boolean isEstAuxEncheres() {
		return estAuxEncheres;
	}

	public void setEstAuxEncheres(boolean estAuxEncheres) {
		this.estAuxEncheres = estAuxEncheres;
	}

	public boolean isEstSupprimee() {
		return estSupprimee;
	}

	public void setEstSupprimee(boolean estSupprimee) {
		this.estSupprimee = estSupprimee;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public boolean isCarnetEntretien() {
		return carnetEntretien;
	}

	public void setCarnetEntretien(boolean carnetEntretien) {
		this.carnetEntretien = carnetEntretien;
	}

	public int getKilometre() {
		return kilometre;
	}

	public void setKilometre(int kilometre) {
		this.kilometre = kilometre;
	}

	public String getTypeCarburant() {
		return typeCarburant;
	}

	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}

	public int getCv() {
		return cv;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}

	public int getKw() {
		return kw;
	}

	public void setKw(int kw) {
		this.kw = kw;
	}

	public int getCylindree() {
		return cylindree;
	}

	public void setCylindree(int cylindree) {
		this.cylindree = cylindree;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public String getMotorisation() {
		return motorisation;
	}

	public void setMotorisation(String motorisation) {
		this.motorisation = motorisation;
	}

	public int getEmissionCO2() {
		return emissionCO2;
	}

	public void setEmissionCO2(int emissionCO2) {
		this.emissionCO2 = emissionCO2;
	}

	public boolean isCarpassEstOk() {
		return carpassEstOk;
	}

	public void setCarpassEstOk(boolean carpassEstOk) {
		this.carpassEstOk = carpassEstOk;
	}

	public int getNormeEuropeene() {
		return normeEuropeene;
	}

	public void setNormeEuropeene(int normeEuropeene) {
		this.normeEuropeene = normeEuropeene;
	}

	public Date getDatePremiereImmatriculation() {
		return datePremiereImmatriculation;
	}

	public void setDatePremiereImmatriculation(Date datePremiereImmatriculation) {
		this.datePremiereImmatriculation = datePremiereImmatriculation;
	}

	public int getNombreClefs() {
		return nombreClefs;
	}

	public void setNombreClefs(int nombreClefs) {
		this.nombreClefs = nombreClefs;
	}

	public String getNumeroChassis() {
		return numeroChassis;
	}

	public void setNumeroChassis(String numeroChassis) {
		this.numeroChassis = numeroChassis;
	}

	public String getTypeSiege() {
		return typeSiege;
	}

	public void setTypeSiege(String typeSiege) {
		this.typeSiege = typeSiege;
	}

	public String getTypePeinture() {
		return typePeinture;
	}

	public void setTypePeinture(String typePeinture) {
		this.typePeinture = typePeinture;
	}

	public int getNombrePortes() {
		return nombrePortes;
	}

	public void setNombrePortes(int nombrePortes) {
		this.nombrePortes = nombrePortes;
	}

	public String getCarrosserie() {
		return carrosserie;
	}

	public void setCarrosserie(String carrosserie) {
		this.carrosserie = carrosserie;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public List<Annonce> getAnnonces() {
		return this.annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	public Annonce addAnnonce(Annonce annonce) {
		getAnnonces().add(annonce);
		annonce.setVoiture(this);

		return annonce;
	}

	public Annonce removeAnnonce(Annonce annonce) {
		getAnnonces().remove(annonce);
		annonce.setVoiture(null);

		return annonce;
	}

	public List<Contrat> getContrats() {
		return this.contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Contrat addContrat(Contrat contrat) {
		getContrats().add(contrat);
		contrat.setVoiture(this);

		return contrat;
	}

	public Contrat removeContrat(Contrat contrat) {
		getContrats().remove(contrat);
		contrat.setVoiture(null);

		return contrat;
	}

	public List<Enchere> getEncheres() {
		return this.encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	public Enchere addEnchere(Enchere enchere) {
		getEncheres().add(enchere);
		enchere.setVoiture(this);

		return enchere;
	}

	public Enchere removeEnchere(Enchere enchere) {
		getEncheres().remove(enchere);
		enchere.setVoiture(null);

		return enchere;
	}
	
	public List<Media> getMedias() {
		return this.medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	public Media addMedia(Media media) {
		getMedias().add(media);
		media.setVoiture(this);

		return media;
	}

	public Media removeMedia(Media media) {
		getMedias().remove(media);
		media.setVoiture(null);

		return media;
	}

}
