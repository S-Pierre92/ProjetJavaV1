package com.wheeludrive.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "favoris")
public class Favoris {

	
	@Temporal(TemporalType.DATE)
	@Column(name="date_enregistrement_favori")
	private Date dateEnregistrementFavori;

	//bi-directional many-to-one association to Annonce
	@ManyToOne
	@JoinColumn(name="ID_ANNONCE", nullable=false, insertable=false, updatable=false)
	private Annonce annonce;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="ID_UTILISATEUR_ENREGISTREUR_FAVORI", nullable=false, insertable=false, updatable=false)
	private Utilisateur utilisateur;

	public Date getDateEnregistrementFavori() {
		return dateEnregistrementFavori;
	}

	public void setDateEnregistrementFavori(Date dateEnregistrementFavori) {
		this.dateEnregistrementFavori = dateEnregistrementFavori;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
