package com.wheeludrive.model.manager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "code_postaux")
public class CodePostal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CODEPOSTAL")
	private int id;
	
	@JoinColumn(name = "pays", referencedColumnName = "ID_PAYS")
	@Column(name = "ID_PAYS")
	private int idPays;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "intitule")
	private String intitule;
}
