package com.wheeludrive.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "contrats_formules_assurance")
public class ContratFormuleAssurance {
	
	@JoinColumn(name = "CONTRATS", referencedColumnName = "ID_CONTRAT")
	@Column(name = "ID_CONTRAT")
	private int idContrat;
	
	@JoinColumn(name = "FORMULES_ASSURANCE", referencedColumnName = "ID_FORMULE_ASSURANCE")
	@Column(name = "ID_FORMULE_ASSURANCE")
	private int idFormuleAssurance;

	public int getIdContrat() {
		return idContrat;
	}

	public int getIdFormuleAssurance() {
		return idFormuleAssurance;
	}
}
