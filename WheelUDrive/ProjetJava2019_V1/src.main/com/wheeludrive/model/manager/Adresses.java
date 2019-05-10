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
	
	
	
	

}
