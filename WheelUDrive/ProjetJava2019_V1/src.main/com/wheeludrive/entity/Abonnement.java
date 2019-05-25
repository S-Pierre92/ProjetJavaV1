package com.wheeludrive.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@IdClass(AbonnementId.class)
@Table(name = "abonnements")
public class Abonnement {

	@Id
	@ManyToOne
	@JoinColumn(name="ID_COMMANDE", nullable=false)
	private Commande commande;

	//bi-directional many-to-one association to FormulesAbonnement
	@Id
	@ManyToOne
	@JoinColumn(name="ID_FORMULE_ABONNEMENT", nullable=false)
	private FormuleAbonnement formulesAbonnement;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut")
	private Date date_debut;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin")
	private Date date_fin;



	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public FormuleAbonnement getFormulesAbonnement() {
		return formulesAbonnement;
	}

	public void setFormulesAbonnement(FormuleAbonnement formulesAbonnement) {
		this.formulesAbonnement = formulesAbonnement;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
	
}
