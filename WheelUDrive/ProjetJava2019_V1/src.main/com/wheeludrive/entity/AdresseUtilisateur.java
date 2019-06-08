package com.wheeludrive.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@IdClass(AdresseUtilisateurId.class)
@Table(name = "adresses_utilisateurs")
public class AdresseUtilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "alias")
	private String alias;

	@Column(name = "complement_information")
	private String complementInformation;

	// bi-directional many-to-one association to Adress
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_ADRESSE", nullable = false)
	private Adresse adresse;

	// bi-directional many-to-one association to Utilisateur
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_UTILISATEUR", nullable = false)
	private Utilisateur utilisateur;

	public String getAlias() {
		return alias;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getComplementInformation() {
		return complementInformation;
	}

	public void setComplementInformation(String complementInformation) {
		this.complementInformation = complementInformation;
	}

}
