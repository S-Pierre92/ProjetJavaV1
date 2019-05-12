package com.wheeludrive.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "favoris")
public class Favoris {

	
	@JoinColumn(name = "Utilisateurs", referencedColumnName = "ID_UTILISATEUR")
	@Column(name = "ID_ENREGISTREUR_FAVORI")
	private int idUtilisateur;
	
	@JoinColumn(name = "Annonces", referencedColumnName = "ID_ANNONCE")
	@Column(name = "ID_ANNONCE")
	private int ID_ANNONCE;
	
	@Column(name = "date_enregistrement_favori")
	private Date dateEnregistrement;

}
