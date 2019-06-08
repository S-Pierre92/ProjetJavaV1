package com.wheeludrive.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "annonces")
public class Annonce implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ANNONCE")
	private int id;
	
	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="ID_UTILISATEUR", nullable=false)
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to Voiture
	@ManyToOne
	@JoinColumn(name="ID_VOITURE", nullable=false)
	private Voiture voiture;
	
	@Column(name = "nbre_vu")
	private int nbreVu;
	
	@Column(name = "est_supprime")
	private boolean supprime;
	
	@Column(name = "est_actif")
	private boolean actif;
	
	@Column(name = "top_deal")
	private boolean topDeal;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "tag__")
	private String tag;
	
	@Column(name = "montant")
	private float montant;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_publication")
	private Date datePublication;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_validite")
	private Date dateValidite;

	@OneToMany(mappedBy="annonce", fetch=FetchType.EAGER)
	private List<Favoris> favoris;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public int getNbreVu() {
		return nbreVu;
	}

	public void setNbreVu(int nbreVu) {
		this.nbreVu = nbreVu;
	}

	public int getNbre_vu() {
		return nbreVu;
	}

	public void setNbre_vu(int nbre_vu) {
		this.nbreVu = nbre_vu;
	}

	public boolean isSupprime() {
		return supprime;
	}

	public void setSupprime(boolean supprime) {
		this.supprime = supprime;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public boolean isTopDeal() {
		return topDeal;
	}

	public void setTopDeal(boolean topDeal) {
		this.topDeal = topDeal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Date getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}

	public int getId() {
		return id;
	}
	
	public List<Favoris> getFavoris() {
		return this.favoris;
	}

	public void setFavoris(List<Favoris> favoris) {
		this.favoris = favoris;
	}

	public Favoris addFavoris(Favoris favori) {
		getFavoris().add(favori);
		favori.setAnnonce(this);

		return favori;
	}

	public Favoris removeFavoris(Favoris favori) {
		getFavoris().remove(favori);
		favori.setAnnonce(null);

		return favori;
	}

	
}
