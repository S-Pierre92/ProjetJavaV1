package com.wheeludrive.model.manager;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "commentaires")
public class Commentaires {
	
	@JoinColumn(name = "Utilisateurs", referencedColumnName = "ID_UTILISATEUR")
	@Column(name = "ID_ENREGISTREUR_RECEPTEUR_AVIS")
	private int idRecepteur;
	
	@JoinColumn(name = "Utilisateurs", referencedColumnName = "ID_UTILISATEUR")
	@Column(name = "ID_ENREGISTREUR_EMETTEUR_AVIS")
	private int idEmetteur;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "contenu")
	private String contenu;
	
	@Column(name = "notation")
	private float notation;
	
	@Column(name = "date_commentaire")
	private Date dateCommentaire;
	
	@Column(name = "est_visible")
	private boolean visible;
	
	

}
