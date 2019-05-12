package com.wheeludrive.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "voitures")
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VOITURE")
	private int id;
	
	@JoinColumn(name = "utilisateurs", referencedColumnName = "ID_UTILISATEUR")
	@Column(name = "ID_UTILISATEUR_PROPRIETAIRE")
	private int idProprietaire;
	
	@JoinColumn(name = "modeles_voiture", referencedColumnName = "ID_MODELE_VOITURE")
	@Column(name = "ID_MODELE_VOITURE")
	private int idModele;
	
	@JoinColumn(name = "couleur", referencedColumnName = "ID_COULEUR")
	@Column(name = "ID_COULEUR_INTERIEURE")
	private int idCouleurInterieure;
	
	@JoinColumn(name = "couleur", referencedColumnName = "ID_COULEUR")
	@Column(name = "ID_COULEUR_EXTERIEURE")
	private int idCouleurExterieure;
	
	@Column(name = "est_aux_encheres")
	private boolean estAuxEncheres;
	
	@Column(name = "est_supprime")
	private boolean estSupprimee;
	
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
	
	@Column(name = "norme_europeene")
	private int normeEuropeene;
	
	@Column(name = "date_premiere_immatriculation")
	private Date datePremiereImmatriculation;
	
	@Column(name = "nombre_clefs")
	private int nombreClefs;
	
	@Column(name = "numero_chassis")
	private String numeroChassis;
	
	@Column(name = "type_siege")
	private String typeSiege;
	
	@Column(name = "type_peinture")
	private String typePeinture;
	
	@Column(name = "nombre_portes")
	private int nombrePortes;
	
	@Column(name = "carrosserie")
	private String carrosserie;
	
	@Column(name = "version")
	private String version;
}
