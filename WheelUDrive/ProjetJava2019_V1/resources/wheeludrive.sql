-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 10 juin 2019 à 13:28
-- Version du serveur :  5.7.23
-- Version de PHP :  7.1.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `wheeludrive`
--
CREATE DATABASE IF NOT EXISTS `wheeludrive` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `wheeludrive`;

-- --------------------------------------------------------

--
-- Structure de la table `abonnements`
--

DROP TABLE IF EXISTS `abonnements`;
CREATE TABLE IF NOT EXISTS `abonnements` (
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `ID_FORMULE_ABONNEMENT` int(11) NOT NULL,
  `ID_COMMANDE` int(11) NOT NULL,
  KEY `REF_ABONN_FORMU_IND` (`ID_FORMULE_ABONNEMENT`),
  KEY `REF_ABONN_COMMA_IND` (`ID_COMMANDE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `adresses`
--

DROP TABLE IF EXISTS `adresses`;
CREATE TABLE IF NOT EXISTS `adresses` (
  `rue` varchar(75) DEFAULT NULL,
  `numero` varchar(75) DEFAULT NULL,
  `boite` varchar(75) DEFAULT NULL,
  `ville` varchar(75) DEFAULT NULL,
  `ID_ADRESSE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CODEPOSTAL` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ADRESSE`),
  UNIQUE KEY `ID_ADRESSES_IND` (`ID_ADRESSE`),
  KEY `REF_ADRES_CODES_IND` (`ID_CODEPOSTAL`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `adresses`
--

INSERT INTO `adresses` (`rue`, `numero`, `boite`, `ville`, `ID_ADRESSE`, `ID_CODEPOSTAL`) VALUES
('Place matteoti', '2', '1', 'Charleroi', 1, 1),
('Place matteoti', '2', '1', 'Charleroi', 2, 1),
('Place matteoti', '2', '1', 'Charleroi', 3, 1),
('Place matteoti', '2', '1', 'Charleroi', 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `adresses_utilisateurs`
--

DROP TABLE IF EXISTS `adresses_utilisateurs`;
CREATE TABLE IF NOT EXISTS `adresses_utilisateurs` (
  `alias` varchar(75) DEFAULT NULL,
  `complement_information` varchar(75) DEFAULT NULL,
  `ID_ADRESSE` int(11) NOT NULL,
  `ID_UTILISATEUR` int(11) NOT NULL,
  PRIMARY KEY (`ID_ADRESSE`,`ID_UTILISATEUR`),
  UNIQUE KEY `ID_ADRESSES_UTILISATEURS_IND` (`ID_ADRESSE`,`ID_UTILISATEUR`),
  KEY `REF_ADRES_Utilisateurs_IND` (`ID_UTILISATEUR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `adresses_utilisateurs`
--

INSERT INTO `adresses_utilisateurs` (`alias`, `complement_information`, `ID_ADRESSE`, `ID_UTILISATEUR`) VALUES
(NULL, NULL, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `annonces`
--

DROP TABLE IF EXISTS `annonces`;
CREATE TABLE IF NOT EXISTS `annonces` (
  `nbre_vu` int(11) DEFAULT NULL,
  `est_supprime` tinyint(1) DEFAULT NULL,
  `est_actif` tinyint(1) DEFAULT NULL,
  `top_deal` tinyint(1) DEFAULT NULL,
  `titre` varchar(75) DEFAULT NULL,
  `description` varchar(75) DEFAULT NULL,
  `tag__` varchar(75) DEFAULT NULL,
  `montant` float DEFAULT NULL,
  `date_publication` date DEFAULT NULL,
  `date_validite` date DEFAULT NULL,
  `ID_ANNONCE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_UTILISATEUR` int(11) NOT NULL,
  `ID_VOITURE` int(11) NOT NULL,
  PRIMARY KEY (`ID_ANNONCE`),
  UNIQUE KEY `ID_ANNONCES_IND` (`ID_ANNONCE`),
  KEY `REF_ANNON_Utilisateurs_1_IND` (`ID_UTILISATEUR`),
  KEY `REF_ANNON_VOITU_IND` (`ID_VOITURE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `codes_postaux`
--

DROP TABLE IF EXISTS `codes_postaux`;
CREATE TABLE IF NOT EXISTS `codes_postaux` (
  `code` varchar(75) DEFAULT NULL,
  `intitule` varchar(75) DEFAULT NULL,
  `ID_CODEPOSTAL` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PAYS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CODEPOSTAL`),
  UNIQUE KEY `ID_CODES_POSTAUX_IND` (`ID_CODEPOSTAL`),
  KEY `REF_CODES_PAYS_IND` (`ID_PAYS`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `codes_postaux`
--

INSERT INTO `codes_postaux` (`code`, `intitule`, `ID_CODEPOSTAL`, `ID_PAYS`) VALUES
('6040', 'Jumet', 1, NULL),
('6040', 'Jumet', 2, 1),
('6040', 'Jumet', 3, 1),
('6040', 'Jumet', 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

DROP TABLE IF EXISTS `commandes`;
CREATE TABLE IF NOT EXISTS `commandes` (
  `tva_courante` float DEFAULT NULL,
  `date_commande` date DEFAULT NULL,
  `montant_total_HTVA` float DEFAULT NULL,
  `ID_COMMANDE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_UTILISATEUR` int(11) NOT NULL,
  PRIMARY KEY (`ID_COMMANDE`),
  UNIQUE KEY `ID_COMMANDES_IND` (`ID_COMMANDE`),
  KEY `REF_COMMA_Utilisateurs_IND` (`ID_UTILISATEUR`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commandes`
--

INSERT INTO `commandes` (`tva_courante`, `date_commande`, `montant_total_HTVA`, `ID_COMMANDE`, `ID_UTILISATEUR`) VALUES
(0, NULL, 0, 1, 1),
(0, NULL, 0, 2, 1),
(0, NULL, 0, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `commentaires`
--

DROP TABLE IF EXISTS `commentaires`;
CREATE TABLE IF NOT EXISTS `commentaires` (
  `titre` varchar(75) DEFAULT NULL,
  `contenu` varchar(75) DEFAULT NULL,
  `date_commentaire` date DEFAULT NULL,
  `notation` float DEFAULT NULL,
  `est_visible` tinyint(1) DEFAULT NULL,
  `ID_UTILISATEUR_EMETTEUR_AVIS` int(11) NOT NULL,
  `ID_UTILISATEUR_RECEPTEUR_AVIS` int(11) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR_RECEPTEUR_AVIS`,`ID_UTILISATEUR_EMETTEUR_AVIS`),
  UNIQUE KEY `ID_UTILISATEURS_UTILISATEURS_IND` (`ID_UTILISATEUR_RECEPTEUR_AVIS`,`ID_UTILISATEUR_EMETTEUR_AVIS`),
  KEY `REF_UTILI_Utilisateurs_IND` (`ID_UTILISATEUR_EMETTEUR_AVIS`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `contrats`
--

DROP TABLE IF EXISTS `contrats`;
CREATE TABLE IF NOT EXISTS `contrats` (
  `est_en_cours` tinyint(1) DEFAULT NULL,
  `ID_CONTRAT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TYPE_CONTRAT` int(11) DEFAULT NULL,
  `ID_COMMANDE` int(11) NOT NULL,
  `ID_VOITURE` int(11) DEFAULT NULL,
  `montant` float DEFAULT NULL,
  PRIMARY KEY (`ID_CONTRAT`),
  UNIQUE KEY `ID_CONTRATS_IND` (`ID_CONTRAT`),
  KEY `REF_CONTR_TYPES_IND` (`ID_TYPE_CONTRAT`),
  KEY `REF_CONTR_COMMA_IND` (`ID_COMMANDE`),
  KEY `REF_CONTR_VOITU_IND` (`ID_VOITURE`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `contrats`
--

INSERT INTO `contrats` (`est_en_cours`, `ID_CONTRAT`, `ID_TYPE_CONTRAT`, `ID_COMMANDE`, `ID_VOITURE`, `montant`) VALUES
(NULL, 1, 1, 1, 1, 60),
(NULL, 2, 1, 1, 1, 5),
(NULL, 3, 1, 1, 1, 6);

-- --------------------------------------------------------

--
-- Structure de la table `contrats_formules_assurance`
--

DROP TABLE IF EXISTS `contrats_formules_assurance`;
CREATE TABLE IF NOT EXISTS `contrats_formules_assurance` (
  `ID_CONTRAT` int(11) NOT NULL,
  `ID_FORMULE_ASSURANCE` int(11) NOT NULL,
  PRIMARY KEY (`ID_FORMULE_ASSURANCE`,`ID_CONTRAT`),
  UNIQUE KEY `ID_CONTRATS_FORMULES_ASSURANCE_IND` (`ID_FORMULE_ASSURANCE`,`ID_CONTRAT`),
  KEY `REF_CONTR_CONTR_IND` (`ID_CONTRAT`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `couleur`
--

DROP TABLE IF EXISTS `couleur`;
CREATE TABLE IF NOT EXISTS `couleur` (
  `nom` varchar(75) DEFAULT NULL,
  `ID_COULEUR` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_COULEUR`),
  UNIQUE KEY `ID_COULEUR_IND` (`ID_COULEUR`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `couleur`
--

INSERT INTO `couleur` (`nom`, `ID_COULEUR`) VALUES
('Bleu', 1),
('Rouge', 2),
('Bleu', 3),
('Rouge', 4),
('Bleu', 5),
('Rouge', 6),
('Bleu', 7),
('Rouge', 8),
('Bleu', 9),
('Rouge', 10);

-- --------------------------------------------------------

--
-- Structure de la table `encheres`
--

DROP TABLE IF EXISTS `encheres`;
CREATE TABLE IF NOT EXISTS `encheres` (
  `ID_ENCHERE` int(1) NOT NULL AUTO_INCREMENT,
  `montant` float DEFAULT NULL,
  `montant_achat_direct` float DEFAULT NULL,
  `pas_minimal_surenchere` float DEFAULT NULL,
  `est_privee` tinyint(1) DEFAULT NULL,
  `date_surenchere` date DEFAULT NULL,
  `date_debut_enchere` date DEFAULT NULL,
  `date_fin_enchere` date DEFAULT NULL,
  `est_annulee` tinyint(1) DEFAULT NULL,
  `date_annulation` date DEFAULT NULL,
  `motif_annulation` varchar(75) DEFAULT NULL,
  `ID_VOITURE` int(11) DEFAULT NULL,
  `ID_UTILISATEUR_ENCHERISSEUR` int(11) DEFAULT NULL,
  `ID_UTILISATEUR_DEPOSEUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ENCHERE`),
  KEY `REF_ENCHE_VOITU_IND` (`ID_VOITURE`),
  KEY `REF_ENCHE_Utilisateurs_1_IND` (`ID_UTILISATEUR_ENCHERISSEUR`),
  KEY `REF_ENCHE_Utilisateurs_IND` (`ID_UTILISATEUR_DEPOSEUR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `factures`
--

DROP TABLE IF EXISTS `factures`;
CREATE TABLE IF NOT EXISTS `factures` (
  `ID_FACTURE` int(11) NOT NULL AUTO_INCREMENT,
  `date_facture` date DEFAULT NULL,
  `ID_COMMANDE` int(11) NOT NULL,
  PRIMARY KEY (`ID_FACTURE`),
  UNIQUE KEY `IDFACTURES_IND` (`ID_FACTURE`),
  KEY `REF_FACTU_COMMA_IND` (`ID_COMMANDE`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `factures`
--

INSERT INTO `factures` (`ID_FACTURE`, `date_facture`, `ID_COMMANDE`) VALUES
(1, '1970-01-01', 1),
(2, '1970-01-01', 1),
(3, '1970-01-01', 1);

-- --------------------------------------------------------

--
-- Structure de la table `favoris`
--

DROP TABLE IF EXISTS `favoris`;
CREATE TABLE IF NOT EXISTS `favoris` (
  `date_enregistrement_favori` date DEFAULT NULL,
  `ID_ANNONCE` int(11) NOT NULL,
  `ID_UTILISATEUR_ENREGISTREUR_FAVORI` int(11) NOT NULL,
  PRIMARY KEY (`ID_ANNONCE`,`ID_UTILISATEUR_ENREGISTREUR_FAVORI`),
  UNIQUE KEY `ID_ANNONCES_UTILISATEURS_IND` (`ID_ANNONCE`,`ID_UTILISATEUR_ENREGISTREUR_FAVORI`),
  KEY `REF_ANNON_Utilisateurs_IND` (`ID_UTILISATEUR_ENREGISTREUR_FAVORI`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `formules_abonnement`
--

DROP TABLE IF EXISTS `formules_abonnement`;
CREATE TABLE IF NOT EXISTS `formules_abonnement` (
  `duree` int(11) DEFAULT NULL,
  `intitule` varchar(75) DEFAULT NULL,
  `description` varchar(75) DEFAULT NULL,
  `tarif` float DEFAULT NULL,
  `ID_FORMULE_ABONNEMENT` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_FORMULE_ABONNEMENT`),
  UNIQUE KEY `ID_FORMULES_ABONNEMENT_IND` (`ID_FORMULE_ABONNEMENT`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `formules_assurance`
--

DROP TABLE IF EXISTS `formules_assurance`;
CREATE TABLE IF NOT EXISTS `formules_assurance` (
  `intitule` varchar(75) DEFAULT NULL,
  `description` varchar(75) DEFAULT NULL,
  `ID_FORMULE_ASSURANCE` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_FORMULE_ASSURANCE`),
  UNIQUE KEY `ID_FORMULES_ASSURANCE_IND` (`ID_FORMULE_ASSURANCE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `marques_voiture`
--

DROP TABLE IF EXISTS `marques_voiture`;
CREATE TABLE IF NOT EXISTS `marques_voiture` (
  `nom` varchar(75) DEFAULT NULL,
  `ID_MARQUE` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_MARQUE`),
  UNIQUE KEY `ID_MARQUES_VOITURE_IND` (`ID_MARQUE`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `marques_voiture`
--

INSERT INTO `marques_voiture` (`nom`, `ID_MARQUE`) VALUES
('Opel', 1),
('Opel', 2),
('Opel', 3),
('Opel', 4),
('Opel', 5),
('Opel', 6);

-- --------------------------------------------------------

--
-- Structure de la table `medias`
--

DROP TABLE IF EXISTS `medias`;
CREATE TABLE IF NOT EXISTS `medias` (
  `ID_MEDIAS` int(11) NOT NULL AUTO_INCREMENT,
  `fichier` varchar(75) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `nom_media` varchar(75) DEFAULT NULL,
  `ID_VOITURE` int(11) NOT NULL,
  PRIMARY KEY (`ID_MEDIAS`),
  KEY `FK_STOCKE_FK` (`ID_VOITURE`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medias`
--

INSERT INTO `medias` (`ID_MEDIAS`, `fichier`, `type`, `nom_media`, `ID_VOITURE`) VALUES
(1, 'Photo/photoVoitureTest.png', 'Photo', 'Porte gauche Opel Astra', 1),
(2, 'Photo/photoVoitureTest.png', 'Photo', 'Porte gauche Opel Astra', 1),
(3, 'Photo/photoVoitureTest.png', 'Photo', 'Porte gauche Opel Astra', 1);

-- --------------------------------------------------------

--
-- Structure de la table `modeles_voiture`
--

DROP TABLE IF EXISTS `modeles_voiture`;
CREATE TABLE IF NOT EXISTS `modeles_voiture` (
  `nom` varchar(75) DEFAULT NULL,
  `ID_MODELE_VOITURE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_MARQUE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_MODELE_VOITURE`),
  UNIQUE KEY `ID_MODELES_VOITURE_IND` (`ID_MODELE_VOITURE`),
  KEY `REF_MODEL_MARQU_IND` (`ID_MARQUE`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `modeles_voiture`
--

INSERT INTO `modeles_voiture` (`nom`, `ID_MODELE_VOITURE`, `ID_MARQUE`) VALUES
('Astra', 1, 1),
('Astra', 2, 1),
('Astra', 3, 1),
('Crossland X', 4, 1),
('Crossland X', 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

DROP TABLE IF EXISTS `pays`;
CREATE TABLE IF NOT EXISTS `pays` (
  `nom_complet` varchar(75) DEFAULT NULL,
  `nom_abreviation` varchar(75) DEFAULT NULL,
  `taux_TVA` float DEFAULT NULL,
  `ISO` varchar(75) DEFAULT NULL,
  `NIS` varchar(75) DEFAULT NULL,
  `ID_PAYS` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_PAYS`),
  UNIQUE KEY `ID_PAYS_IND` (`ID_PAYS`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pays`
--

INSERT INTO `pays` (`nom_complet`, `nom_abreviation`, `taux_TVA`, `ISO`, `NIS`, `ID_PAYS`) VALUES
('Belgique', 'bel', 0.21, 'BE', NULL, 1),
('Belgique', 'bel', 0.21, 'BE', NULL, 2),
('Belgique', 'bel', 0.21, 'BE', NULL, 3),
('Belgique', 'bel', 0.21, 'BE', NULL, 4);

-- --------------------------------------------------------

--
-- Structure de la table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE IF NOT EXISTS `permissions` (
  `intitule` varchar(75) DEFAULT NULL,
  `description` varchar(75) DEFAULT NULL,
  `ID_PERMISSION` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_PERMISSION`),
  UNIQUE KEY `ID_PERMISSIONS_IND` (`ID_PERMISSION`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `permissions`
--

INSERT INTO `permissions` (`intitule`, `description`, `ID_PERMISSION`) VALUES
('VendeurBase', 'Permet d\'acheter, de vendre (achat direct) sur notre belle appli', 1),
('VendeurBase', 'Permet d\'acheter, de vendre (achat direct) sur notre belle appli', 2),
('VendeurBase', 'Permet d\'acheter, de vendre (achat direct) sur notre belle appli', 3);

-- --------------------------------------------------------

--
-- Structure de la table `permissions_roles`
--

DROP TABLE IF EXISTS `permissions_roles`;
CREATE TABLE IF NOT EXISTS `permissions_roles` (
  `ID_PERMISSION` int(11) NOT NULL,
  `ID_ROLE` int(11) NOT NULL,
  PRIMARY KEY (`ID_PERMISSION`,`ID_ROLE`),
  UNIQUE KEY `ID_PERMISSIONS_ROLES_IND` (`ID_PERMISSION`,`ID_ROLE`),
  KEY `REF_PERMI_ROLES_IND` (`ID_ROLE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `permissions_roles`
--

INSERT INTO `permissions_roles` (`ID_PERMISSION`, `ID_ROLE`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `rapports`
--

DROP TABLE IF EXISTS `rapports`;
CREATE TABLE IF NOT EXISTS `rapports` (
  `lien` varchar(75) DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  `ID_RAPPORT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_UTILISATEUR_CREATEUR` int(11) NOT NULL,
  PRIMARY KEY (`ID_RAPPORT`),
  UNIQUE KEY `ID_RAPPORTS_IND` (`ID_RAPPORT`),
  KEY `REF_RAPPO_Utilisateurs_1_IND` (`ID_UTILISATEUR_CREATEUR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `rapports_utilisateurs`
--

DROP TABLE IF EXISTS `rapports_utilisateurs`;
CREATE TABLE IF NOT EXISTS `rapports_utilisateurs` (
  `date_consultation` date DEFAULT NULL,
  `annotation` varchar(75) DEFAULT NULL,
  `ID_RAPPORT` int(11) NOT NULL,
  `ID_UTILISATEUR_LECTEUR` int(11) NOT NULL,
  PRIMARY KEY (`ID_RAPPORT`,`ID_UTILISATEUR_LECTEUR`),
  UNIQUE KEY `ID_RAPPORTS_UTILISATEURS_IND` (`ID_RAPPORT`,`ID_UTILISATEUR_LECTEUR`),
  KEY `REF_RAPPO_Utilisateurs_IND` (`ID_UTILISATEUR_LECTEUR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `intitule` varchar(75) DEFAULT NULL,
  `ID_ROLE` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_ROLE`),
  UNIQUE KEY `ID_ROLES_IND` (`ID_ROLE`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`intitule`, `ID_ROLE`) VALUES
('Client_niveau_1', 1),
('Client_niveau_1', 2),
('Client_niveau_1', 3);

-- --------------------------------------------------------

--
-- Structure de la table `types_contrat`
--

DROP TABLE IF EXISTS `types_contrat`;
CREATE TABLE IF NOT EXISTS `types_contrat` (
  `intitule` varchar(75) DEFAULT NULL,
  `ID_TYPE_CONTRAT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_UTILISATEUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_TYPE_CONTRAT`),
  UNIQUE KEY `ID_TYPES_CONTRAT_IND` (`ID_TYPE_CONTRAT`),
  KEY `REF_TYPES_Utilisateurs_IND` (`ID_UTILISATEUR`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `types_contrat`
--

INSERT INTO `types_contrat` (`intitule`, `ID_TYPE_CONTRAT`, `ID_UTILISATEUR`) VALUES
('Basic', 1, NULL),
('Basic', 2, 1),
('Basic', 3, 1),
('Basic', 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `nom` varchar(75) DEFAULT NULL,
  `prenom` varchar(75) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `email` varchar(75) DEFAULT NULL,
  `mdp` varchar(75) DEFAULT NULL,
  `est_actif` tinyint(1) DEFAULT NULL,
  `est_supprime` tinyint(1) DEFAULT NULL,
  `date_inscription` date DEFAULT NULL,
  `date_derniere_modification` date DEFAULT NULL,
  `tel_mobile` varchar(75) DEFAULT NULL,
  `tel_fixe` varchar(75) DEFAULT NULL,
  `numero_TVA` varchar(75) DEFAULT NULL,
  `ID_UTILISATEUR` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ROLE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`),
  UNIQUE KEY `ID_UTILISATEURS_IND` (`ID_UTILISATEUR`),
  KEY `REF_Utilisateurs_ROLES_IND` (`ID_ROLE`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`nom`, `prenom`, `date_naissance`, `email`, `mdp`, `est_actif`, `est_supprime`, `date_inscription`, `date_derniere_modification`, `tel_mobile`, `tel_fixe`, `numero_TVA`, `ID_UTILISATEUR`, `ID_ROLE`) VALUES
('Cesar', 'Jules', NULL, 'Jules.Cesar@mail.com', 'pikachu', 1, 0, '2019-06-07', '2019-06-07', NULL, NULL, NULL, 1, 1),
('Cesar', 'Jules', NULL, 'Jules.Cesar@mail.com', 'pikachu', 1, 0, '2019-06-09', '2019-06-09', NULL, NULL, NULL, 2, 1),
('Cesar', 'Jules', NULL, 'Jules.Cesar@mail.com', 'pikachu', 1, 0, '2019-06-09', '2019-06-09', NULL, NULL, NULL, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `voitures`
--

DROP TABLE IF EXISTS `voitures`;
CREATE TABLE IF NOT EXISTS `voitures` (
  `version` varchar(75) DEFAULT NULL,
  `carroserie` varchar(75) DEFAULT NULL,
  `nombre_portes` int(11) DEFAULT NULL,
  `type_peinture_` varchar(75) DEFAULT NULL,
  `type_siege` varchar(75) DEFAULT NULL,
  `numero_chassis` varchar(75) DEFAULT NULL,
  `nombre_clefs` int(11) DEFAULT NULL,
  `date_premiere_immatriculation` date DEFAULT NULL,
  `norme_europeenne` int(11) DEFAULT NULL,
  `carpasse_est_ok` tinyint(1) DEFAULT NULL,
  `emission_co2` int(11) DEFAULT NULL,
  `motorisation` varchar(75) DEFAULT NULL,
  `vitesse` int(11) DEFAULT NULL,
  `transmission` varchar(75) DEFAULT NULL,
  `cylindree` int(11) DEFAULT NULL,
  `kw` int(11) DEFAULT NULL,
  `cv` int(11) DEFAULT NULL,
  `type_carburant` varchar(75) DEFAULT NULL,
  `kilometre` int(11) DEFAULT NULL,
  `carnet_entretien` tinyint(1) DEFAULT NULL,
  `date_ajout` date DEFAULT NULL,
  `est_supprime` tinyint(1) DEFAULT NULL,
  `est_aux_encheres_` tinyint(1) DEFAULT NULL,
  `ID_VOITURE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_UTILISATEUR_PROPRIETAIRE` int(11) NOT NULL,
  `ID_MODELE_VOITURE` int(11) DEFAULT NULL,
  `ID_COULEUR_INTERIEURE` int(11) DEFAULT NULL,
  `ID_COULEUR_EXTERIEURE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_VOITURE`),
  UNIQUE KEY `ID_VOITURES_IND` (`ID_VOITURE`),
  KEY `REF_VOITU_Utilisateurs_IND` (`ID_UTILISATEUR_PROPRIETAIRE`),
  KEY `REF_VOITU_MODEL_IND` (`ID_MODELE_VOITURE`),
  KEY `REF_VOITU_COULEUR_1_IND` (`ID_COULEUR_INTERIEURE`),
  KEY `REF_VOITU_COULEUR_IND` (`ID_COULEUR_EXTERIEURE`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `voitures`
--

INSERT INTO `voitures` (`version`, `carroserie`, `nombre_portes`, `type_peinture_`, `type_siege`, `numero_chassis`, `nombre_clefs`, `date_premiere_immatriculation`, `norme_europeenne`, `carpasse_est_ok`, `emission_co2`, `motorisation`, `vitesse`, `transmission`, `cylindree`, `kw`, `cv`, `type_carburant`, `kilometre`, `carnet_entretien`, `date_ajout`, `est_supprime`, `est_aux_encheres_`, `ID_VOITURE`, `ID_UTILISATEUR_PROPRIETAIRE`, `ID_MODELE_VOITURE`, `ID_COULEUR_INTERIEURE`, `ID_COULEUR_EXTERIEURE`) VALUES
(NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 0, 0, 0, NULL, 0, NULL, 0, 0, 0, NULL, 0, 0, '2019-06-08', 0, 0, 1, 1, 1, 2, 1),
(NULL, NULL, 5, NULL, NULL, NULL, 7, '2005-11-05', 0, 0, 0, NULL, 0, 'MANUEL', 0, 45000, 0, 'ESSENCE', 0, 0, '2019-06-09', 0, 0, 2, 1, 4, 2, 1),
(NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 0, 0, 0, NULL, 0, NULL, 0, 0, 0, NULL, 0, 0, '2019-06-09', 0, 0, 3, 1, 4, 2, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
