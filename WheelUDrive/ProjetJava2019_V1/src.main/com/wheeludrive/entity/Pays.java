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
@Table(name = "pays")
public class Pays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAYS")
	private int id;
	
	@Column(name = "nom_complet")
	private String nomComplet;
	
	@Column(name = "nom_abreviation")
	private String nomAbreviation;
	
	@Column(name = "taux_TVA")
	private float tauxTVA;
	
	@Column(name = "ISO")
	private String iso;
	
	@Column(name = "NIS")
	private String nis;
	
	@OneToMany(mappedBy="pays", fetch=FetchType.EAGER)
	private List<CodePostal> codesPostaux;

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getNomAbreviation() {
		return nomAbreviation;
	}

	public void setNomAbreviation(String nomAbreviation) {
		this.nomAbreviation = nomAbreviation;
	}

	public float getTauxTVA() {
		return tauxTVA;
	}

	public void setTauxTVA(float tauxTVA) {
		this.tauxTVA = tauxTVA;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public int getId() {
		return id;
	}
	
	public List<CodePostal> getCodesPostaux() {
		return this.codesPostaux;
	}

	public void setCodesPostauxs(List<CodePostal> codesPostaux) {
		this.codesPostaux = codesPostaux;
	}

	public CodePostal addCodesPostaux(CodePostal codePostal) {
		getCodesPostaux().add(codePostal);
		codePostal.setPays(this);

		return codePostal;
	}

	public CodePostal removeCodesPostaux(CodePostal codePostal) {
		getCodesPostaux().remove(codePostal);
		codePostal.setPays(null);

		return codePostal;
	}
	
}
