package com.wheeludrive.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "encheres")
public class Enchere implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private boolean privee;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_surenchere")
	private Date dateSurenchere;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut_enchere")
	private Date dateDebutEnchere;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin_enchere")
	private Date dateFinEnchere;
	
	@Column(name = "est_annulee")
	private Boolean estAnnulee;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_annulation")
	private Date dateAnnulation;
	
	@Column(name = "motif_annulation")
	private String motifAnnulation;
	
	@ManyToOne
	@JoinColumn(name="ID_UTILISATEUR_ENCHERISSEUR")
	private Utilisateur encherisseur;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="ID_UTILISATEUR_DEPOSEUR")
	private Utilisateur deposeur;

	//bi-directional many-to-one association to Voiture
	@ManyToOne
	@JoinColumn(name="ID_VOITURE")
	private Voiture voiture;

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
	
	public boolean isPrivee() {
		return privee;
	}

	public void setPrivee(boolean privee) {
		this.privee = privee;
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

	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}

	public Utilisateur getDeposeur() {
		return deposeur;
	}

	public void setDeposeur(Utilisateur deposeur) {
		this.deposeur = deposeur;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
	

}