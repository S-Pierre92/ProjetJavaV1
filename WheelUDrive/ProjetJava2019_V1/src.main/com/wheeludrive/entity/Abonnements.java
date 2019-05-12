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
@Table(name = "abonnements")

public class Abonnements {

	
	@JoinColumn(name = "FORMULES_ABONNEMENT", referencedColumnName = "ID_FORMULE_ABONNEMENT")
	@Column(name = "ID_FORMULE_ABONNEMENT")
	private int idFormuleAbonnement;
	
	@JoinColumn(name = "COMMANDES", referencedColumnName = "ID_COMMANDE")
	@Column(name = "ID_COMMANDE")
	private int idCommande;
	
	@Column(name = "date_debut")
	private Date date_debut;
	
	@Column(name = "date_fin")
	private Date date_fin;

	public int getIdFormuleAbonnement() {
		return idFormuleAbonnement;
	}

	public void setIdFormuleAbonnement(int idFormuleAbonnement) {
		this.idFormuleAbonnement = idFormuleAbonnement;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
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
