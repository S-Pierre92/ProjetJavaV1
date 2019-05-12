package com.wheeludrive.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")

public class Commandes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMMANDE")
	private int id;
	
	@JoinColumn(name = "utilisateurs", referencedColumnName = "ID_UTILISATEUR")
	@Column(name = "ID_UTILISATEUR")
	private int idUtilisateur;
	
	@Column(name = "montant_total_HTVA")
	private float montantTotalHtva;

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
}
