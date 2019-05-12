package com.wheeludrive.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "medias")
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MEDIAS")
	private int id;
	
	@JoinColumn(name = "voitures", referencedColumnName = "ID_VOITURE")
	@Column(name = "ID_VOITURE")
	private int idVoiture;
	
	@Column(name = "fichier")
	private String fichier;
	 
	@Column(name = "type")
	private String type;
	
	@Column(name = "nom_media")
	private String nomMedia;

	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNomMedia() {
		return nomMedia;
	}

	public void setNomMedia(String nomMedia) {
		this.nomMedia = nomMedia;
	}

	public int getId() {
		return id;
	}
	
}
