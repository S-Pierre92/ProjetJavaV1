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
@Table(name = "marques_voiture")
public class Marque implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MARQUE")
	private int id;

	@Column(name = "nom")
	private String nom;

	// bi-directional many-to-one association to Modele
	@OneToMany(mappedBy = "marque", fetch = FetchType.EAGER)
	private List<Modele> modeles;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Modele> getModeles() {
		return modeles;
	}

	public void setModeles(List<Modele> modeles) {
		this.modeles = modeles;
	}

	public int getId() {
		return id;
	}

	public List<Modele> getModelesVoitures() {
		return this.modeles;
	}

	public void setModelesVoitures(List<Modele> modeles) {
		this.modeles = modeles;
	}

	public Modele addModelesVoiture(Modele modelesVoiture) {
		getModelesVoitures().add(modelesVoiture);
		modelesVoiture.setMarqueVoiture(this);

		return modelesVoiture;
	}

	public Modele removeModelesVoiture(Modele modelesVoiture) {
		getModelesVoitures().remove(modelesVoiture);
		modelesVoiture.setMarqueVoiture(null);

		return modelesVoiture;
	}

}
