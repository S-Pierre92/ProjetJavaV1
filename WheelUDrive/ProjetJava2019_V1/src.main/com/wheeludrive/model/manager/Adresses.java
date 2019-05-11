package com.wheeludrive.model.manager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "adresses")
public class Adresses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADRESSE")
	private int id;
	
	@Column(name = "rue")
	private String rue;
	
	@Column(name = "ville")
	private String ville;
	
	@Column(name = "boite")
	private String boite;
	
	@Column(name = "numero")
	private String numero;
	
	@JoinColumn(name = "CODES_POSTAUX", referencedColumnName = "ID_CODE_POSTAL")
	@Column(name = "ID_CODEPOSTAL")
	private int idCodePostal;

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getBoite() {
		return boite;
	}

	public void setBoite(String boite) {
		this.boite = boite;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getIdCodePostal() {
		return idCodePostal;
	}

	public void setIdCodePostal(int idCodePostal) {
		this.idCodePostal = idCodePostal;
	}

	public int getId() {
		return id;
	}
}
