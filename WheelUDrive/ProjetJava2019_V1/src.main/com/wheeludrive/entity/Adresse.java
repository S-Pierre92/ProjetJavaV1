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
@Table(name = "adresses")
public class Adresse {
	
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
	
	@OneToMany(mappedBy="adresse", fetch=FetchType.EAGER)
	private List<AdresseUtilisateur> adressesUtilisateurs;

	
	@ManyToOne
	@JoinColumn(name="ID_CODEPOSTAL")
	private CodePostal codePostal;

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

	public CodePostal getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(CodePostal codePostal) {
		this.codePostal = codePostal;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public int getId() {
		return id;
	}
	
	public List<AdresseUtilisateur> getAdresseUtilisateurs() {
		return this.adressesUtilisateurs;
	}

	public void setAdresseUtilisateurs(List<AdresseUtilisateur> adressesUtilisateurs) {
		this.adressesUtilisateurs = adressesUtilisateurs;
	}

	public AdresseUtilisateur addAdresseUtilisateur(AdresseUtilisateur adressesUtilisateur) {
		getAdresseUtilisateurs().add(adressesUtilisateur);
		adressesUtilisateur.setAdresse(this);

		return adressesUtilisateur;
	}

	public AdresseUtilisateur removeAdresseUtilisateur(AdresseUtilisateur adressesUtilisateur) {
		getAdresseUtilisateurs().remove(adressesUtilisateur);
		adressesUtilisateur.setAdresse(null);

		return adressesUtilisateur;
	}

}
