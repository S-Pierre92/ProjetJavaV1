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
@Table(name = "types_contrat")

public class TypesContrat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TYPE_CONTRAT")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ID_UTILISATEUR")
	private Utilisateur utilisateur;

	@Column(name = "intitule")
	private String intitule;

	// bi-directional many-to-one association to Contrat
	@OneToMany(mappedBy = "typesContrat", fetch = FetchType.EAGER)
	private List<Contrat> contrats;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getId() {
		return id;
	}
	
	public List<Contrat> getContrats() {
		return this.contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Contrat addContrat(Contrat contrat) {
		getContrats().add(contrat);
		contrat.setTypesContrat(this);

		return contrat;
	}

	public Contrat removeContrat(Contrat contrat) {
		getContrats().remove(contrat);
		contrat.setTypesContrat(null);

		return contrat;
	}

}
