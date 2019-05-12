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
@Table(name = "Utilisateurs")
public class Utilisateurs {
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "ID_UTILISATEUR" )
    private int  id;
	
	@Column( name = "nom" )
	private String nom;
	
	@Column( name = "prenom" )
	private String prenom;
	
	@Column( name = "date_naissance" )
	private Date dateNaissance;
	
	@Column( name = "email" )
	private String email;
	
	@Column( name = "mdp" )
	private String mdp;
	
	@Column( name = "est_actif" )
	private boolean estActif;
	
	@Column( name = "est_supprime" )
	private boolean estSupprime;
	
	@Column( name = "date_inscription" )
	private Date dateInscription;
	
	@Column( name = "dateNaissance" )
	private Date dateDerniereModification;
	
	public int getId() {
		return id;
	}

	@Column( name = "tel_mobile" )
	private String telMobile;
	
	@Column( name = "tel_fixe" )
	private String telFixe;
	
	@Column( name = "numero" )
	private String numero;
	
	@JoinColumn(name = "roles", referencedColumnName = "ID_ROLES")
	@Column( name = "ID_ROLE" )
	private String idRole;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean isEstActif() {
		return estActif;
	}

	public void setEstActif(boolean estActif) {
		this.estActif = estActif;
	}

	public boolean isEstSupprime() {
		return estSupprime;
	}

	public void setEstSupprime(boolean estSupprime) {
		this.estSupprime = estSupprime;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}

	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}

	public String getTelMobile() {
		return telMobile;
	}

	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}

	public String getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

}
