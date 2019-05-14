package com.wheeludrive.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "modeles_voiture")
public class Modele {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MODELE")
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@JoinColumn(name = "MARQUES", referencedColumnName = "ID_MARQUE")
	@Column(name = "ID_MARQUE")
	private int idMarque;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public int getIdMarque() {
		return idMarque;
	}
}
