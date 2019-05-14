package com.wheeludrive.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "adresses_utilisateurs")
public class AdresseUtilisateur {
	
	@Column(name = "alias")
	private String alias;
	
	@Column(name = "complement_information")
	private String complementInformation;
	
	@JoinColumn(name = "ADRESSES", referencedColumnName = "ID_ADRESSE")
	@Column(name = "ID_ADRESSE")
	private int idAdresse;
	
	@JoinColumn(name = "UTILISATEURS", referencedColumnName = "ID_UTILISATEUR")
	@Column(name = "ID_UTILISATEUR")
	private int idUtilisateur;

	public String getAlias() {
		return alias;
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

	public int getIdAdresse() {
		return idAdresse;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	
}
