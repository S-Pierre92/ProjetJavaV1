package com.wheeludrive.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contrats_formules_assurance")
public class ContratFormuleAssurance {
	
	@ManyToOne
	@JoinColumn(name = "ID_CONTRAT")
	private Contrat contrat;
	
	@ManyToOne
	@JoinColumn(name = "ID_FORMULE_ASSURANCE")
	private FormulesAssurance formulesAssurance;

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public FormulesAssurance getFormulesAssurance() {
		return formulesAssurance;
	}

	public void setFormulesAssurance(FormulesAssurance formulesAssurance) {
		this.formulesAssurance = formulesAssurance;
	}

	
}
