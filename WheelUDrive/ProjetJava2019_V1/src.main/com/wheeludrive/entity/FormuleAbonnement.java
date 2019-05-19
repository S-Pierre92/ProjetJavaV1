package com.wheeludrive.entity;

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
@Table(name = "formules_abonnement")
public class FormuleAbonnement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FORMULE_ABONNEMENT")
	private int id;
	
	@Column(name = "duree")
	private int duree;
	
	@Column(name = "intitule")
	private String intitule;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "tarif")
	private float tarif;
	
	@OneToMany(mappedBy="formulesAbonnement", fetch=FetchType.EAGER)
	private List<Abonnement> abonnements;

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	public int getId() {
		return id;
	}
	
	public List<Abonnement> getAbonnements() {
		return this.abonnements;
	}

	public void setAbonnements(List<Abonnement> abonnements) {
		this.abonnements = abonnements;
	}

	public Abonnement addAbonnement(Abonnement abonnement) {
		getAbonnements().add(abonnement);
		abonnement.setFormulesAbonnement(this);

		return abonnement;
	}

	public Abonnement removeAbonnement(Abonnement abonnement) {
		getAbonnements().remove(abonnement);
		abonnement.setFormulesAbonnement(null);

		return abonnement;
	}
	
}