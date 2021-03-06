package com.wheeludrive.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "couleur")
public class Couleur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COULEUR")
	private int id;

	@Column(name = "nom")
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	// bi-directional many-to-one association to Voiture
	@OneToMany(mappedBy = "couleurInt", fetch = FetchType.EAGER)
	private List<Voiture> coulInt;

	// bi-directional many-to-one association to Voiture
	@OneToMany(mappedBy = "couleurExt", fetch = FetchType.EAGER)
	private List<Voiture> coulExt;

	public List<Voiture> getCoulInt() {
		return coulInt;
	}

	public void setCoulInt(List<Voiture> coulInt) {
		this.coulInt = coulInt;
	}

	public List<Voiture> getCoulExt() {
		return coulExt;
	}

	public void setCoulExt(List<Voiture> coulExt) {
		this.coulExt = coulExt;
	}

	
}
