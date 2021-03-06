package com.wheeludrive.entity;

import java.io.Serializable;
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
@Table(name = "contrats")

public class Contrat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTRAT")
	private int id;

	// bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name = "ID_COMMANDE", nullable = false)
	private Commande commande;

	// bi-directional many-to-one association to TypesContrat
	@ManyToOne
	@JoinColumn(name = "ID_TYPE_CONTRAT")
	private TypesContrat typesContrat;

	// bi-directional many-to-one association to Voiture
	@ManyToOne
	@JoinColumn(name = "ID_VOITURE")
	private Voiture voiture;

	@OneToMany(mappedBy="contrat",fetch=FetchType.EAGER)
	private List<ContratFormuleAssurance> contratFormuleAssurances;
	
	@Column(name="montant_ht")
	private float montantHT;
	
	@Column(name="montant_ttc")
	private float montantTTC;
	
	public float getMontantTTC() {
		return this.montantTTC;
	}
	
	public void setMontantTTC(float montantTTC) {
		this.montantTTC = montantTTC;
	}
	
	public float getMontantHT() {
		return montantHT;
	}
	
	public void setMontantHT(float montantHT) {
		this.montantHT = montantHT;
	}
	
	public int getId() {
		return id;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public TypesContrat getTypesContrat() {
		return typesContrat;
	}

	public void setTypesContrat(TypesContrat typesContrat) {
		this.typesContrat = typesContrat;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
	public List<ContratFormuleAssurance> getContratFormuleAssurances() {
		return this.contratFormuleAssurances;
	}

	public void setContratFormuleAssurances(List<ContratFormuleAssurance> contratFormuleAssurances) {
		this.contratFormuleAssurances = contratFormuleAssurances;
	}

	public ContratFormuleAssurance addContratFormuleAssurance(ContratFormuleAssurance contratFormuleAssurance) {
		getContratFormuleAssurances().add(contratFormuleAssurance);
		contratFormuleAssurance.setContrat(this);

		return contratFormuleAssurance;
	}

	public ContratFormuleAssurance removeContratFormuleAssurance(ContratFormuleAssurance contratFormuleAssurance) {
		getContratFormuleAssurances().remove(contratFormuleAssurance);
		contratFormuleAssurance.setContrat(null);

		return contratFormuleAssurance;
	}
}
