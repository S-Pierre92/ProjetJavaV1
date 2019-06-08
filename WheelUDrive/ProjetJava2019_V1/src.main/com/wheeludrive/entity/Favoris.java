package com.wheeludrive.entity;

import java.io.Serializable;
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
@IdClass(FavorisId.class)
@Table(name = "favoris")
public class Favoris implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="date_enregistrement_favori")
	private Date dateEnregistrementFavori;

	//bi-directional many-to-one association to Annonce
	@Id
	@ManyToOne
	@JoinColumn(name="ID_ANNONCE", nullable=false)
	private Annonce annonce;

	//bi-directional many-to-one association to Utilisateur
	@Id
	@ManyToOne
	@JoinColumn(name="ID_UTILISATEUR_ENREGISTREUR_FAVORI", nullable=false)
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
