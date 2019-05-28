package com.wheeludrive.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "modeles_voiture")
public class Modele {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MODELE_VOITURE")
	private int id;

	@Column(name = "nom")
	private String nom;

	// bi-directional many-to-one association to MarquesVoiture
	@ManyToOne
	@JoinColumn(name = "ID_MARQUE")
	private Marque marque;

	// bi-directional many-to-one association to Voiture
	@OneToMany(mappedBy = "modele", fetch = FetchType.EAGER)
	private List<Voiture> voitures;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public Marque getMarqueVoiture() {
		return marque;
	}

	public void setMarqueVoiture(Marque marqueVoiture) {
		this.marque = marqueVoiture;
	}
	
	

	public List<Voiture> getVoitures() {
		return this.voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public Voiture addVoiture(Voiture voiture) {
		getVoitures().add(voiture);
		voiture.setModele(this);

		return voiture;
	}

	public Voiture removeVoiture(Voiture voiture) {
		getVoitures().remove(voiture);
		voiture.setModele(null);

		return voiture;
	}
}
