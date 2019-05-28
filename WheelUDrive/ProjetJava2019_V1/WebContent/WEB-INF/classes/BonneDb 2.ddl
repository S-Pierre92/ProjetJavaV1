-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.1              
-- * Generator date: Dec  4 2018              
-- * Generation date: Sat May 11 20:01:57 2019 
-- * LUN file: d:\Profiles\snkizamacumu\Documents\Java\ProjetAnalyse\ProjetAnalyse_1_MCD_ET_MLD.lun 
-- * Schema: MLD/SQL 
-- ********************************************* 


-- Database Section
-- ________________ 

create database wheeludrive;
use wheeludrive;


-- Tables Section
-- _____________ 

create table ABONNEMENTS (
     date_debut date null,
     date_fin date null,
     ID_FORMULE_ABONNEMENT int not null,
     ID_COMMANDE int not null);

create table ADRESSES (
     rue varchar(75) null,
     numero varchar(75) null,
     boite varchar(75) null,
     ville varchar(75) null,
     ID_ADRESSE int not null auto_increment,
     ID_CODEPOSTAL int null,
     constraint ID_ADRESSES_ID primary key (ID_ADRESSE));

create table ADRESSES_UTILISATEURS (
     alias varchar(75) null,
     complement_information varchar(75) null,
     ID_ADRESSE int not null,
     ID_UTILISATEUR int not null,
     constraint ID_ADRESSES_UTILISATEURS_ID primary key (ID_ADRESSE, ID_UTILISATEUR));

create table ANNONCES (
     nbre_vu int null,
     est_supprime tinyint(1) null,
     est_actif tinyint(1) null,
     top_deal tinyint(1) null,
     titre varchar(75) null,
     description varchar(75) null,
     tag__ varchar(75) null,
     montant float(1) null,
     date_publication date null,
     date_validite date null,
     ID_ANNONCE int not null auto_increment,
     ID_UTILISATEUR int not null,
     ID_VOITURE int not null,
     constraint ID_ANNONCES_ID primary key (ID_ANNONCE));

create table FAVORIS (
     date_enregistrement_favori date null,
     ID_ANNONCE int not null,
     ID_UTILISATEUR_ENREGISTREUR_FAVORI int not null,
     constraint ID_ANNONCES_UTILISATEURS_ID primary key (ID_ANNONCE, ID_UTILISATEUR_ENREGISTREUR_FAVORI));

create table CODES_POSTAUX (
     code varchar(75) null,
     intitule varchar(75) null,
     ID_CODEPOSTAL int not null auto_increment,
     ID_PAYS int null,
     constraint ID_CODES_POSTAUX_ID primary key (ID_CODEPOSTAL));

create table COMMANDES (
     tva_courante float(1) null,
     date_commande date null,
     montant_total_HTVA float(1) null,
     ID_COMMANDE int not null auto_increment,
     ID_UTILISATEUR int not null,
     constraint ID_COMMANDES_ID primary key (ID_COMMANDE));

create table CONTRATS (
     est_en_cours tinyint(1) null,
     ID_CONTRAT int not null auto_increment,
     ID_TYPE_CONTRAT int null,
     ID_COMMANDE int not null,
     ID_VOITURE int null,
     constraint ID_CONTRATS_ID primary key (ID_CONTRAT));

create table CONTRATS_FORMULES_ASSURANCE (
     ID_CONTRAT int not null,
     ID_FORMULE_ASSURANCE int not null,
     constraint ID_CONTRATS_FORMULES_ASSURANCE_ID primary key (ID_FORMULE_ASSURANCE, ID_CONTRAT));

create table COULEUR (
     nom varchar(75) null,
     ID_COULEUR int not null auto_increment,
     constraint ID_COULEUR_ID primary key (ID_COULEUR));

create table ENCHERES (
     ID_ENCHERE int(1) not null auto_increment,
     montant float(1)  null,
     montant_achat_direct float(1)  null,
     pas_minimal_surenchere float(1)  null,
     est_privee tinyint(1)  null,
     date_surenchere date  null,
     date_debut_enchere date  null,
     date_fin_enchere date  null,
     est_annulee tinyint(1)  null,
     date_annulation date  null,
     motif_annulation varchar(75)  null,
     ID_VOITURE int  null,
     ID_UTILISATEUR_ENCHERISSEUR int,
     ID_UTILISATEUR_DEPOSEUR int  null,
     constraint IDENCHERES_ID primary key (ID_ENCHERE));

create table FACTURES (
     ID_FACTURE int not null auto_increment,
     date_facture date null,
     ID_COMMANDE int not null,
     constraint IDFACTURES_ID primary key (ID_FACTURE));

create table FORMULES_ABONNEMENT (
     duree int null,
     intitule varchar(75) null,
     description varchar(75) null,
     tarif float(1) null,
     ID_FORMULE_ABONNEMENT int not null auto_increment,
     constraint ID_FORMULES_ABONNEMENT_ID primary key (ID_FORMULE_ABONNEMENT));

create table FORMULES_ASSURANCE (
     intitule varchar(75) null,
     description varchar(75) null,
     ID_FORMULE_ASSURANCE int not null auto_increment,
     constraint ID_FORMULES_ASSURANCE_ID primary key (ID_FORMULE_ASSURANCE));

create table MARQUES_VOITURE (
     nom varchar(75) null,
     ID_MARQUE int not null auto_increment,
     constraint ID_MARQUES_VOITURE_ID primary key (ID_MARQUE));

create table MEDIAS (
     ID_MEDIAS int not null auto_increment,
     fichier varchar(75)  null,
     type varchar(10)  null,
     nom_media varchar(75)  null,
     ID_VOITURE int not null,
     constraint IDMEDIAS_ID primary key (ID_MEDIAS));

create table MODELES_VOITURE (
     nom varchar(75) null,
     ID_MODELE_VOITURE int not null auto_increment,
     ID_MARQUE int null,
     constraint ID_MODELES_VOITURE_ID primary key (ID_MODELE_VOITURE));

create table PAYS (
     nom_complet varchar(75) null,
     nom_abreviation varchar(75) null,
     taux_TVA float(1) null,
     ISO varchar(75) null,
     NIS varchar(75) null,
     ID_PAYS int not null auto_increment,
     constraint ID_PAYS_ID primary key (ID_PAYS));

create table PERMISSIONS (
     intitule varchar(75) null,
     description varchar(75) null,
     ID_PERMISSION int not null auto_increment,
     constraint ID_PERMISSIONS_ID primary key (ID_PERMISSION));

create table PERMISSIONS_ROLES (
     ID_PERMISSION int not null,
     ID_ROLE int not null,
     constraint ID_PERMISSIONS_ROLES_ID primary key (ID_PERMISSION, ID_ROLE));

create table RAPPORTS (
     lien varchar(75) null,
     date_creation date null,
     ID_RAPPORT int not null auto_increment,
     ID_UTILISATEUR_CREATEUR int not null,
     constraint ID_RAPPORTS_ID primary key (ID_RAPPORT));

create table RAPPORTS_UTILISATEURS (
     date_consultation date null,
     annotation varchar(75) null,
     ID_RAPPORT int not null,
     ID_UTILISATEUR_LECTEUR int not null,
     constraint ID_RAPPORTS_UTILISATEURS_ID primary key (ID_RAPPORT, ID_UTILISATEUR_LECTEUR));

create table ROLES (
     intitule varchar(75) null,
     ID_ROLE int not null auto_increment,
     constraint ID_ROLES_ID primary key (ID_ROLE));

create table TYPES_CONTRAT (
     intitule varchar(75) null,
     ID_TYPE_CONTRAT int not null auto_increment,
     ID_UTILISATEUR int null,
     constraint ID_TYPES_CONTRAT_ID primary key (ID_TYPE_CONTRAT));

create table UTILISATEURS (
     nom varchar(75) null,
     prenom varchar(75) null,
     date_naissance date null,
     email varchar(75) null,
     mdp varchar(75) null,
     est_actif tinyint(1) null,
     est_supprime tinyint(1) null,
     date_inscription date null,
     date_derniere_modification date null,
     tel_mobile varchar(75) null,
     tel_fixe varchar(75) null,
     numero_TVA varchar(75) null,
     ID_UTILISATEUR int not null auto_increment,
     ID_ROLE int null,
     constraint ID_UTILISATEURS_ID primary key (ID_UTILISATEUR));

create table COMMENTAIRES (
     titre varchar(75) null,
     contenu varchar(75) null,
     date_commentaire date null,
     notation float(1) null,
     est_visible tinyint(1) null,
     ID_UTILISATEUR_EMETTEUR_AVIS int not null,
     ID_UTILISATEUR_RECEPTEUR_AVIS int not null,
     constraint ID_UTILISATEURS_UTILISATEURS_ID primary key (ID_UTILISATEUR_RECEPTEUR_AVIS, ID_UTILISATEUR_EMETTEUR_AVIS));

create table VOITURES (
     version varchar(75) null,
     carroserie varchar(75) null,
     nombre_portes int null,
     type_peinture_ varchar(75) null,
     type_siege varchar(75) null,
     numero_chassis varchar(75) null,
     nombre_clefs int null,
     date_premiere_immatriculation date null,
     norme_europeenne int null,
     carpasse_est_ok tinyint(1) null,
     emission_co2 int null,
     motorisation varchar(75) null,
     vitesse int null,
     transmission varchar(75) null,
     cylindree int null,
     kw int null,
     cv int null,
     type_carburant varchar(75) null,
     kilometre int null,
     carnet_entretien tinyint(1) null,
     date_ajout date null,
     est_supprime tinyint(1) null,
     est_aux_encheres_ tinyint(1) null,
     ID_VOITURE int not null,
     ID_UTILISATEUR_PROPRIETAIRE int not null,
     ID_MODELE_VOITURE int null,
     ID_COULEUR_INTERIEURE int null,
     ID_COULEUR_EXTERIEURE int null,
     constraint ID_VOITURES_ID primary key (ID_VOITURE));


-- Constraints Section
-- ___________________ 

alter table ABONNEMENTS add constraint REF_ABONN_FORMU_FK
     foreign key (ID_FORMULE_ABONNEMENT)
     references FORMULES_ABONNEMENT (ID_FORMULE_ABONNEMENT);

alter table ABONNEMENTS add constraint REF_ABONN_COMMA_FK
     foreign key (ID_COMMANDE)
     references COMMANDES (ID_COMMANDE);

-- Not implemented
-- alter table ADRESSES add constraint ID_ADRESSES_CHK
--     check(exists(select * from ADRESSES_UTILISATEURS
--                  where ADRESSES_UTILISATEURS.ID_ADRESSE = ID_ADRESSE)); 

alter table ADRESSES add constraint REF_ADRES_CODES_FK
     foreign key (ID_CODEPOSTAL)
     references CODES_POSTAUX (ID_CODEPOSTAL);

alter table ADRESSES_UTILISATEURS add constraint REF_ADRES_Utilisateurs_FK
     foreign key (ID_UTILISATEUR)
     references UTILISATEURS (ID_UTILISATEUR);

alter table ADRESSES_UTILISATEURS add constraint EQU_ADRES_ADRES
     foreign key (ID_ADRESSE)
     references ADRESSES (ID_ADRESSE);

alter table ANNONCES add constraint REF_ANNON_Utilisateurs_1_FK
     foreign key (ID_UTILISATEUR)
     references UTILISATEURS (ID_UTILISATEUR);

alter table ANNONCES add constraint REF_ANNON_VOITU_FK
     foreign key (ID_VOITURE)
     references VOITURES (ID_VOITURE);

alter table FAVORIS add constraint REF_ANNON_Utilisateurs_FK
     foreign key (ID_UTILISATEUR_ENREGISTREUR_FAVORI)
     references UTILISATEURS (ID_UTILISATEUR);

alter table FAVORIS add constraint REF_ANNON_ANNON
     foreign key (ID_ANNONCE)
     references ANNONCES (ID_ANNONCE);

alter table CODES_POSTAUX add constraint REF_CODES_PAYS_FK
     foreign key (ID_PAYS)
     references PAYS (ID_PAYS);

alter table COMMANDES add constraint REF_COMMA_Utilisateurs_FK
     foreign key (ID_UTILISATEUR)
     references UTILISATEURS (ID_UTILISATEUR);

alter table CONTRATS add constraint REF_CONTR_TYPES_FK
     foreign key (ID_TYPE_CONTRAT)
     references TYPES_CONTRAT (ID_TYPE_CONTRAT);

alter table CONTRATS add constraint REF_CONTR_COMMA_FK
     foreign key (ID_COMMANDE)
     references COMMANDES (ID_COMMANDE);

alter table CONTRATS add constraint REF_CONTR_VOITU_FK
     foreign key (ID_VOITURE)
     references VOITURES (ID_VOITURE);

alter table CONTRATS_FORMULES_ASSURANCE add constraint REF_CONTR_FORMU
     foreign key (ID_FORMULE_ASSURANCE)
     references FORMULES_ASSURANCE (ID_FORMULE_ASSURANCE);

alter table CONTRATS_FORMULES_ASSURANCE add constraint REF_CONTR_CONTR_FK
     foreign key (ID_CONTRAT)
     references CONTRATS (ID_CONTRAT);

alter table ENCHERES add constraint REF_ENCHE_VOITU_FK
     foreign key (ID_VOITURE)
     references VOITURES (ID_VOITURE);

alter table ENCHERES add constraint REF_ENCHE_Utilisateurs_1_FK
     foreign key (ID_UTILISATEUR_ENCHERISSEUR)
     references UTILISATEURS (ID_UTILISATEUR);

alter table ENCHERES add constraint REF_ENCHE_Utilisateurs_FK
     foreign key (ID_UTILISATEUR_DEPOSEUR)
     references UTILISATEURS (ID_UTILISATEUR);

alter table FACTURES add constraint REF_FACTU_COMMA_FK
     foreign key (ID_COMMANDE)
     references COMMANDES (ID_COMMANDE);

alter table MEDIAS add constraint FK_STOCKE_FK
     foreign key (ID_VOITURE)
     references VOITURES (ID_VOITURE);

alter table MODELES_VOITURE add constraint REF_MODEL_MARQU_FK
     foreign key (ID_MARQUE)
     references MARQUES_VOITURE (ID_MARQUE);

alter table PERMISSIONS_ROLES add constraint REF_PERMI_ROLES_FK
     foreign key (ID_ROLE)
     references ROLES (ID_ROLE);

alter table PERMISSIONS_ROLES add constraint REF_PERMI_PERMI
     foreign key (ID_PERMISSION)
     references PERMISSIONS (ID_PERMISSION);

alter table RAPPORTS add constraint REF_RAPPO_Utilisateurs_1_FK
     foreign key (ID_UTILISATEUR_CREATEUR)
     references UTILISATEURS (ID_UTILISATEUR);

alter table RAPPORTS_UTILISATEURS add constraint REF_RAPPO_Utilisateurs_FK
     foreign key (ID_UTILISATEUR_LECTEUR)
     references UTILISATEURS (ID_UTILISATEUR);

alter table RAPPORTS_UTILISATEURS add constraint REF_RAPPO_RAPPO
     foreign key (ID_RAPPORT)
     references RAPPORTS (ID_RAPPORT);

alter table TYPES_CONTRAT add constraint REF_TYPES_Utilisateurs_FK
     foreign key (ID_UTILISATEUR)
     references UTILISATEURS (ID_UTILISATEUR);

alter table UTILISATEURS add constraint REF_Utilisateurs_ROLES_FK
     foreign key (ID_ROLE)
     references ROLES (ID_ROLE);

alter table COMMENTAIRES add constraint REF_UTILI_Utilisateurs_1
     foreign key (ID_UTILISATEUR_RECEPTEUR_AVIS)
     references UTILISATEURS (ID_UTILISATEUR);

alter table COMMENTAIRES add constraint REF_UTILI_Utilisateurs_FK
     foreign key (ID_UTILISATEUR_EMETTEUR_AVIS)
     references UTILISATEURS (ID_UTILISATEUR);

alter table VOITURES add constraint REF_VOITU_Utilisateurs_FK
     foreign key (ID_UTILISATEUR_PROPRIETAIRE)
     references UTILISATEURS (ID_UTILISATEUR);

alter table VOITURES add constraint REF_VOITU_MODEL_FK
     foreign key (ID_MODELE_VOITURE)
     references MODELES_VOITURE (ID_MODELE_VOITURE);

alter table VOITURES add constraint REF_VOITU_COULEUR_1_FK
     foreign key (ID_COULEUR_INTERIEURE)
     references COULEUR (ID_COULEUR);

alter table VOITURES add constraint REF_VOITU_COULEUR_FK
     foreign key (ID_COULEUR_EXTERIEURE)
     references COULEUR (ID_COULEUR);


-- Index Section
-- _____________ 

create index REF_ABONN_FORMU_IND
     on ABONNEMENTS (ID_FORMULE_ABONNEMENT);

create index REF_ABONN_COMMA_IND
     on ABONNEMENTS (ID_COMMANDE);

create unique index ID_ADRESSES_IND
     on ADRESSES (ID_ADRESSE);

create index REF_ADRES_CODES_IND
     on ADRESSES (ID_CODEPOSTAL);

create unique index ID_ADRESSES_UTILISATEURS_IND
     on ADRESSES_UTILISATEURS (ID_ADRESSE, ID_UTILISATEUR);

create index REF_ADRES_Utilisateurs_IND
     on ADRESSES_UTILISATEURS (ID_UTILISATEUR);

create unique index ID_ANNONCES_IND
     on ANNONCES (ID_ANNONCE);

create index REF_ANNON_Utilisateurs_1_IND
     on ANNONCES (ID_UTILISATEUR);

create index REF_ANNON_VOITU_IND
     on ANNONCES (ID_VOITURE);

create unique index ID_ANNONCES_UTILISATEURS_IND
     on FAVORIS (ID_ANNONCE, ID_UTILISATEUR_ENREGISTREUR_FAVORI);

create index REF_ANNON_Utilisateurs_IND
     on FAVORIS (ID_UTILISATEUR_ENREGISTREUR_FAVORI);

create unique index ID_CODES_POSTAUX_IND
     on CODES_POSTAUX (ID_CODEPOSTAL);

create index REF_CODES_PAYS_IND
     on CODES_POSTAUX (ID_PAYS);

create unique index ID_COMMANDES_IND
     on COMMANDES (ID_COMMANDE);

create index REF_COMMA_Utilisateurs_IND
     on COMMANDES (ID_UTILISATEUR);

create unique index ID_CONTRATS_IND
     on CONTRATS (ID_CONTRAT);

create index REF_CONTR_TYPES_IND
     on CONTRATS (ID_TYPE_CONTRAT);

create index REF_CONTR_COMMA_IND
     on CONTRATS (ID_COMMANDE);

create index REF_CONTR_VOITU_IND
     on CONTRATS (ID_VOITURE);

create unique index ID_CONTRATS_FORMULES_ASSURANCE_IND
     on CONTRATS_FORMULES_ASSURANCE (ID_FORMULE_ASSURANCE, ID_CONTRAT);

create index REF_CONTR_CONTR_IND
     on CONTRATS_FORMULES_ASSURANCE (ID_CONTRAT);

create unique index ID_COULEUR_IND
     on COULEUR (ID_COULEUR);

create index REF_ENCHE_VOITU_IND
     on ENCHERES (ID_VOITURE);

create index REF_ENCHE_Utilisateurs_1_IND
     on ENCHERES (ID_UTILISATEUR_ENCHERISSEUR);

create index REF_ENCHE_Utilisateurs_IND
     on ENCHERES (ID_UTILISATEUR_DEPOSEUR);

create index REF_FACTU_COMMA_IND
     on FACTURES (ID_COMMANDE);

create unique index IDFACTURES_IND
     on FACTURES (ID_FACTURE);

create unique index ID_FORMULES_ABONNEMENT_IND
     on FORMULES_ABONNEMENT (ID_FORMULE_ABONNEMENT);

create unique index ID_FORMULES_ASSURANCE_IND
     on FORMULES_ASSURANCE (ID_FORMULE_ASSURANCE);

create unique index ID_MARQUES_VOITURE_IND
     on MARQUES_VOITURE (ID_MARQUE);

create unique index ID_MODELES_VOITURE_IND
     on MODELES_VOITURE (ID_MODELE_VOITURE);

create index REF_MODEL_MARQU_IND
     on MODELES_VOITURE (ID_MARQUE);

create unique index ID_PAYS_IND
     on PAYS (ID_PAYS);

create unique index ID_PERMISSIONS_IND
     on PERMISSIONS (ID_PERMISSION);

create unique index ID_PERMISSIONS_ROLES_IND
     on PERMISSIONS_ROLES (ID_PERMISSION, ID_ROLE);

create index REF_PERMI_ROLES_IND
     on PERMISSIONS_ROLES (ID_ROLE);

create unique index ID_RAPPORTS_IND
     on RAPPORTS (ID_RAPPORT);

create index REF_RAPPO_Utilisateurs_1_IND
     on RAPPORTS (ID_UTILISATEUR_CREATEUR);

create unique index ID_RAPPORTS_UTILISATEURS_IND
     on RAPPORTS_UTILISATEURS (ID_RAPPORT, ID_UTILISATEUR_LECTEUR);

create index REF_RAPPO_Utilisateurs_IND
     on RAPPORTS_UTILISATEURS (ID_UTILISATEUR_LECTEUR);

create unique index ID_ROLES_IND
     on ROLES (ID_ROLE);

create unique index ID_TYPES_CONTRAT_IND
     on TYPES_CONTRAT (ID_TYPE_CONTRAT);

create index REF_TYPES_Utilisateurs_IND
     on TYPES_CONTRAT (ID_UTILISATEUR);

create unique index ID_UTILISATEURS_IND
     on UTILISATEURS (ID_UTILISATEUR);

create index REF_Utilisateurs_ROLES_IND
     on UTILISATEURS (ID_ROLE);

create unique index ID_UTILISATEURS_UTILISATEURS_IND
     on COMMENTAIRES (ID_UTILISATEUR_RECEPTEUR_AVIS, ID_UTILISATEUR_EMETTEUR_AVIS);

create index REF_UTILI_Utilisateurs_IND
     on COMMENTAIRES (ID_UTILISATEUR_EMETTEUR_AVIS);

create unique index ID_VOITURES_IND
     on VOITURES (ID_VOITURE);

create index REF_VOITU_Utilisateurs_IND
     on VOITURES (ID_UTILISATEUR_PROPRIETAIRE);

create index REF_VOITU_MODEL_IND
     on VOITURES (ID_MODELE_VOITURE);

create index REF_VOITU_COULEUR_1_IND
     on VOITURES (ID_COULEUR_INTERIEURE);

create index REF_VOITU_COULEUR_IND
     on VOITURES (ID_COULEUR_EXTERIEURE);

