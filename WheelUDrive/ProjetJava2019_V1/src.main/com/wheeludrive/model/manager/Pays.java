package com.wheeludrive.model.manager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
