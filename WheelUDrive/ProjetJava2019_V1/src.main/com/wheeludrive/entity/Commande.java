package com.wheeludrive.entity;

import java.io.Serializable;
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
@Table(name = "commandes")

public class Commande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMMANDE")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ID_UTILISATEUR", nullable=false)
	private Utilisateur utilisateur;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_commande")
	private Date dateCommande;
	
	@Column(name = "montant_total_HTVA")
	private float montantTotalHtva;
	
	@Column(name="tva_courante")
	private float tvaCourante;
	
	@OneToMany(mappedBy="commande", fetch=FetchType.EAGER)
	private List<Abonnement> abonnements;
	
	//bi-directional many-to-one association to Contrat
	@OneToMany(mappedBy="commande", fetch=FetchType.EAGER)
	private List<Contrat> contrats;

	//bi-directional many-to-one association to Facture
	@OneToMany(mappedBy="commande", fetch=FetchType.EAGER)
	private List<Facture> factures;


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	public float getTvaCourante() {
		return tvaCourante;
	}

	public void setTvaCourante(float tvaCourante) {
		this.tvaCourante = tvaCourante;
	}


	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public float getMontantTotalHtva() {
		return montantTotalHtva;
	}

	public void setMontantTotalHtva(float montantTotalHtva) {
		this.montantTotalHtva = montantTotalHtva;
	}

	public int getId() {
		return id;
	}
	
	public List<Contrat> getContrats() {
		return this.contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Contrat addContrat(Contrat contrat) {
		getContrats().add(contrat);
		contrat.setCommande(this);

		return contrat;
	}

	public Contrat removeContrat(Contrat contrat) {
		getContrats().remove(contrat);
		contrat.setCommande(null);

		return contrat;
	}

	public List<Facture> getFactures() {
		return this.factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public Facture addFacture(Facture facture) {
		getFactures().add(facture);
		facture.setCommande(this);

		return facture;
	}

	public Facture removeFacture(Facture facture) {
		getFactures().remove(facture);
		facture.setCommande(null);

		return facture;
	}
	
	public List<Abonnement> getAbonnements() {
		return this.abonnements;
	}

	public void setAbonnements(List<Abonnement> abonnements) {
		this.abonnements = abonnements;
	}

	public Abonnement addAbonnement(Abonnement abonnement) {
		getAbonnements().add(abonnement);
		abonnement.setCommande(this);

		return abonnement;
	}

	public Abonnement removeAbonnement(Abonnement abonnement) {
		getAbonnements().remove(abonnement);
		abonnement.setCommande(null);

		return abonnement;
	}
}
