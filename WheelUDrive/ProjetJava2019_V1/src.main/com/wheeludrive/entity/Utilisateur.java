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
@Table(name = "Utilisateurs")
public class Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UTILISATEUR")
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance")
	private Date dateNaissance;

	@Column(name = "email")
	private String email;

	@Column(name = "mdp")
	private String mdp;

	@Column(name = "est_actif")
	private boolean actif;

	@Column(name = "est_supprime")
	private boolean supprime;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_inscription")
	private Date dateInscription;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_derniere_modification")
	private Date dateDerniereModification;

	public int getId() {
		return id;
	}

	@Column(name = "tel_mobile")
	private String telMobile;

	@Column(name = "tel_fixe")
	private String telFixe;

	@Column(name = "numero_TVA")
	private String numeroTVA;

	// bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "ID_ROLE")
	private Role role;

	// bi-directional many-to-one association to Voiture
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER)
	private List<Voiture> voitures;

	// bi-directional many-to-one association to AdresseUtilisateur
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER)
	private List<AdresseUtilisateur> adressesUtilisateurs;

	// bi-directional many-to-one association to Annonce
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER)
	private List<Annonce> annonces;

	// bi-directional many-to-one association to Commande
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER)
	private List<Commande> commandes;

	// bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy = "recepteur", fetch = FetchType.EAGER)
	private List<Commentaire> commentairesRecu;

	// bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy = "emmeteur", fetch = FetchType.EAGER)
	private List<Commentaire> commentairesEmis;

	// bi-directional many-to-one association to Enchere
	@OneToMany(mappedBy = "deposeur", fetch = FetchType.EAGER)
	private List<Enchere> encheres1;

	// bi-directional many-to-one association to Enchere
	@OneToMany(mappedBy = "encherisseur", fetch = FetchType.EAGER)
	private List<Enchere> encheres2;

	// bi-directional many-to-one association to Favori
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER)
	private List<Favoris> favoris;

	// bi-directional many-to-one association to TypesContrat
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER)
	private List<TypesContrat> typesContrats;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public boolean isSupprime() {
		return supprime;
	}

	public void setSupprime(boolean supprime) {
		this.supprime = supprime;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}

	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}

	public String getTelMobile() {
		return telMobile;
	}

	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}

	public String getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public String getNumeroTVA() {
		return numeroTVA;
	}

	public void setNumeroTVA(String numero) {
		this.numeroTVA = numero;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Voiture> getVoitures() {
		return this.voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public List<AdresseUtilisateur> getAdressesUtilisateurs() {
		return this.adressesUtilisateurs;
	}

	public void setAdressesUtilisateurs(List<AdresseUtilisateur> adressesUtilisateurs) {
		this.adressesUtilisateurs = adressesUtilisateurs;
	}

	public AdresseUtilisateur addAdressesUtilisateur(AdresseUtilisateur adressesUtilisateur) {
		getAdressesUtilisateurs().add(adressesUtilisateur);
		adressesUtilisateur.setUtilisateur(this);

		return adressesUtilisateur;
	}

	public AdresseUtilisateur removeAdressesUtilisateur(AdresseUtilisateur adressesUtilisateur) {
		getAdressesUtilisateurs().remove(adressesUtilisateur);
		adressesUtilisateur.setUtilisateur(null);

		return adressesUtilisateur;
	}

	public List<Annonce> getAnnonces() {
		return this.annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	public Annonce addAnnonce(Annonce annonce) {
		getAnnonces().add(annonce);
		annonce.setUtilisateur(this);

		return annonce;
	}

	public Annonce removeAnnonce(Annonce annonce) {
		getAnnonces().remove(annonce);
		annonce.setUtilisateur(null);

		return annonce;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setUtilisateur(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setUtilisateur(null);

		return commande;
	}

	public List<Commentaire> getCommentairesRecu() {
		return this.commentairesRecu;
	}

	public void setCommentairesRecu(List<Commentaire> commentaires1) {
		this.commentairesRecu = commentaires1;
	}

	public Commentaire addCommentairesRecu(Commentaire commentaires1) {
		getCommentairesRecu().add(commentaires1);
		commentaires1.setRecepteur(this);

		return commentaires1;
	}

	public Commentaire removeCommentairesRecu(Commentaire commentaires1) {
		getCommentairesRecu().remove(commentaires1);
		commentaires1.setRecepteur(null);

		return commentaires1;
	}

	public List<Commentaire> getCommentairesEmis() {
		return this.commentairesEmis;
	}

	public void setCommentairesEmis(List<Commentaire> commentaires2) {
		this.commentairesEmis = commentaires2;
	}

	public Commentaire addCommentaires2(Commentaire commentaires2) {
		getCommentairesEmis().add(commentaires2);
		commentaires2.setEmmeteur(this);

		return commentaires2;
	}

	public Commentaire removeCommentaires2(Commentaire commentaires2) {
		getCommentairesEmis().remove(commentaires2);
		commentaires2.setEmmeteur(null);

		return commentaires2;
	}

	public List<Enchere> getEncheres1() {
		return this.encheres1;
	}

	public void setEncheres1(List<Enchere> encheres1) {
		this.encheres1 = encheres1;
	}

	public Enchere addEncheres1(Enchere encheres1) {
		getEncheres1().add(encheres1);
		encheres1.setDeposeur(this);

		return encheres1;
	}

	public Enchere removeEncheres1(Enchere encheres1) {
		getEncheres1().remove(encheres1);
		encheres1.setDeposeur(null);

		return encheres1;
	}

	public List<Enchere> getEncheres2() {
		return this.encheres2;
	}

	public void setEncheres2(List<Enchere> encheres2) {
		this.encheres2 = encheres2;
	}

	public Enchere addEncheres2(Enchere encheres2) {
		getEncheres2().add(encheres2);
		encheres2.setEncherisseur(this);

		return encheres2;
	}

	public Enchere removeEncheres2(Enchere encheres2) {
		getEncheres2().remove(encheres2);
		encheres2.setEncherisseur(null);

		return encheres2;
	}

	public List<Favoris> getFavoris() {
		return this.favoris;
	}

	public void setFavoris(List<Favoris> favoris) {
		this.favoris = favoris;
	}

	public Favoris addFavori(Favoris favoris) {
		getFavoris().add(favoris);
		favoris.setUtilisateur(this);

		return favoris;
	}

	public Favoris removeFavori(Favoris favori) {
		getFavoris().remove(favori);
		favori.setUtilisateur(null);

		return favori;
	}


	public List<TypesContrat> getTypesContrats() {
		return this.typesContrats;
	}

	public void setTypesContrats(List<TypesContrat> typesContrats) {
		this.typesContrats = typesContrats;
	}

	public TypesContrat addTypesContrat(TypesContrat typesContrat) {
		getTypesContrats().add(typesContrat);
		typesContrat.setUtilisateur(this);

		return typesContrat;
	}

	public TypesContrat removeTypesContrat(TypesContrat typesContrat) {
		getTypesContrats().remove(typesContrat);
		typesContrat.setUtilisateur(null);

		return typesContrat;
	}
	public Voiture addVoiture(Voiture voiture) {
		getVoitures().add(voiture);
		voiture.setUtilisateur(this);

		return voiture;
	}

	public Voiture removeVoiture(Voiture voiture) {
		getVoitures().remove(voiture);
		voiture.setUtilisateur(null);

		return voiture;
	}

}
