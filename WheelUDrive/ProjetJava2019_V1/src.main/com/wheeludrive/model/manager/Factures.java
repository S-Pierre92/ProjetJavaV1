package com.wheeludrive.model.manager;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "factures")
public class Factures {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FACTURE")
	private int id;
	
	@JoinColumn(name = "commandes", referencedColumnName = "ID_COMMANDE")
	@Column(name = "ID_COMMANDE")
	private int idCommande;
	
	@Column(name = "date_facture")
	private Date dateFacture;

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public int getId() {
		return id;
	}
	
	 
}
