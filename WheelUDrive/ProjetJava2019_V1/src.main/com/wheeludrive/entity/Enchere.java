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
@Table(name = "encheres")
public class Enchere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENCHERE")
	private int id;
	
	@Column(name = "montant")
	private float montant;
	
	@Column(name = "montant_achat_direct")
	private float montantAchatDirect;
	
	@Column(name = "pas_minimal_surenchere")
	private float pasMinimalSurenchere;
	
	@Column(name = "est_privee")
	private boolean estPrivee;
	
	@Column(name = "date_surenchere")
	private Date dateSurenchere;
	
	@Column(name = "date_debut_enchere")
	private Date dateDebutEnchere;
	
	@Column(name = "date_fin_enchere")
	private Date dateFinEnchere;
	
	@Column(name = "est_annulee")
	private Boolean estAnnulee;
	
	@Column(name = "date_annulation")
	private Date dateAnnulation;
	
	@Column(name = "motif_annulation")
	private String motifAnnulation;
	
	@JoinColumn(name = "VOITURES", referencedColumnName = "ID_VOITURE")
	@Column(name = "ID_VOITURE")
	private int idVoiture;
	
	@JoinColumn(name = "UTILISATEURS", referencedColumnName = "ID_UTILISATEUR")
	@Column(name = "ID_UTILISATEUR_ENCHERISSEUR")
	private int idUtilisateurEncherisseur;
	
	@JoinColumn(name = "UTILISATEURS", referencedColumnName = "ID_UTILISATEUR")
	@Column(name = "ID_UTILISATEUR_DEPOSEUR")
	private int idUtilisateurDeposeur;

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public float getMontantAchatDirect() {
		return montantAchatDirect;
	}

	public void setMontantAchatDirect(float montantAchatDirect) {
		this.montantAchatDirect = montantAchatDirect;
	}

	public float getPasMinimalSurenchere() {
		return pasMinimalSurenchere;
	}

	public void setPasMinimalSurenchere(float pasMinimalSurenchere) {
		this.pasMinimalSurenchere = pasMinimalSurenchere;
	}

	public boolean isEstPrivee() {
		return estPrivee;
	}

	public void setEstPrivee(boolean estPrivee) {
		this.estPrivee = estPrivee;
	}

	public Date getDateSurenchere() {
		return dateSurenchere;
	}

	public void setDateSurenchere(Date dateSurenchere) {
		this.dateSurenchere = dateSurenchere;
	}

	public Date getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public Date getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(Date dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public Boolean getEstAnnulee() {
		return estAnnulee;
	}

	public void setEstAnnulee(Boolean estAnnulee) {
		this.estAnnulee = estAnnulee;
	}

	public Date getDateAnnulation() {
		return dateAnnulation;
	}

	public void setDateAnnulation(Date dateAnnulation) {
		this.dateAnnulation = dateAnnulation;
	}

	public String getMotifAnnulation() {
		return motifAnnulation;
	}

	public void setMotifAnnulation(String motifAnnulation) {
		this.motifAnnulation = motifAnnulation;
	}

	public int getId() {
		return id;
	}

	public int getIdVoiture() {
		return idVoiture;
	}

	public int getIdUtilisateurEncherisseur() {
		return idUtilisateurEncherisseur;
	}

	public int getIdUtilisateurDeposeur() {
		return idUtilisateurDeposeur;
	}
}