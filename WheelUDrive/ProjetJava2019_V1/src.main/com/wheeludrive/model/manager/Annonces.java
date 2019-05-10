package com.wheeludrive.model.manager;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "annonces")

public class Annonces {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ANNONCE")
	private int id;
	
	@JoinColumn(name = "utilisateurs", referencedColumnName = "ID_UTILISATEUR")
	@Column(name = "ID_UTILISATEUR")
	private int idUtilisateur;
	
	@JoinColumn(name = "voitures", referencedColumnName = "ID_VOITURE")
	@Column(name = "ID_VOITURE")
	private int idVoiture;
	
	@Column(name = "nbre_vu")
	private int nbre_vu;
	
	@Column(name = "est_supprime")
	private boolean supprime;
	
	@Column(name = "est_actif")
	private boolean actif;
	
	@Column(name = "top_deal")
	private boolean topDeal;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "tag")
	private String tag;
	
	@Column(name = "montant")
	private float montant;
	
	@Column(name = "date_publication")
	private Date datePublication;
	
	@Column(name = "date_validite")
	private Date dateValidite;

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public int getNbre_vu() {
		return nbre_vu;
	}

	public void setNbre_vu(int nbre_vu) {
		this.nbre_vu = nbre_vu;
	}

	public boolean isSupprime() {
		return supprime;
	}

	public void setSupprime(boolean supprime) {
		this.supprime = supprime;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public boolean isTopDeal() {
		return topDeal;
	}

	public void setTopDeal(boolean topDeal) {
		this.topDeal = topDeal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Date getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}

	public int getId() {
		return id;
	}

	
}
