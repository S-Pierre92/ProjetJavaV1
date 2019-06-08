package com.wheeludrive.entity;

import java.io.Serializable;
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
@Table(name="formules_assurance")
public class FormulesAssurance implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_FORMULE_ASSURANCE", unique=true, nullable=false)
	private int id;
	
	@Column
	private String description;

	@Column
	private String intitule;
	
	@OneToMany(mappedBy="formulesAssurance", fetch=FetchType.EAGER)
	private List<ContratFormuleAssurance> contratFormuleAssurances;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	public List<ContratFormuleAssurance> getContratFormuleAssurances() {
		return this.contratFormuleAssurances;
	}
	
	public void setContratFormuleAssurances(List<ContratFormuleAssurance> contratFormuleAssurances) {
		this.contratFormuleAssurances = contratFormuleAssurances;
	}

	public ContratFormuleAssurance addContratFormuleAssurance(ContratFormuleAssurance contratFormuleAssurance) {
		getContratFormuleAssurances().add(contratFormuleAssurance);
		contratFormuleAssurance.setFormulesAssurance(this);

		return contratFormuleAssurance;
	}

	public ContratFormuleAssurance removeContratFormuleAssurance(ContratFormuleAssurance contratFormuleAssurance) {
		getContratFormuleAssurances().remove(contratFormuleAssurance);
		contratFormuleAssurance.setFormulesAssurance(null);

		return contratFormuleAssurance;
	}
	
	
	

	
	

}
