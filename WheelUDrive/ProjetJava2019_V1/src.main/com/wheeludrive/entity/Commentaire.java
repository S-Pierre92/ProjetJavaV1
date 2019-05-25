package com.wheeludrive.entity;

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
@IdClass(CommentaireId.class)
@Table(name = "commentaires")
public class Commentaire {

	// bi-directional many-to-one association to Utilisateur
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_UTILISATEUR_RECEPTEUR_AVIS", nullable = false)
	private Utilisateur recepteur;

	// bi-directional many-to-one association to Utilisateur
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_UTILISATEUR_EMETTEUR_AVIS", nullable = false)
	private Utilisateur emmeteur;

	@Column(name = "titre")
	private String titre;

	@Column(name = "contenu")
	private String contenu;

	@Column(name = "notation")
	private float notation;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_commentaire")
	private Date dateCommentaire;

	@Column(name = "est_visible")
	private boolean visible;

	public Utilisateur getRecepteur() {
		return recepteur;
	}

	public void setRecepteur(Utilisateur recepteur) {
		this.recepteur = recepteur;
	}

	public Utilisateur getEmmeteur() {
		return emmeteur;
	}

	public void setEmmeteur(Utilisateur emmeteur) {
		this.emmeteur = emmeteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public float getNotation() {
		return notation;
	}

	public void setNotation(float notation) {
		this.notation = notation;
	}

	public Date getDateCommentaire() {
		return dateCommentaire;
	}

	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
