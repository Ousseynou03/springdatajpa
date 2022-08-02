-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mar. 02 août 2022 à 14:44
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `carlib`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `categorie_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`categorie_id`, `nom`) VALUES
(1, 'Standard'),
(2, 'Special'),
(3, 'JeunesConducteurs'),
(4, 'Promotion'),
(5, 'Promotion'),
(6, 'Promotion'),
(7, 'Promotion'),
(8, 'Promotion'),
(9, 'Promotion');

-- --------------------------------------------------------

--
-- Structure de la table `categorie_produit`
--

CREATE TABLE `categorie_produit` (
  `categorie_id` int(11) NOT NULL,
  `produit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie_produit`
--

INSERT INTO `categorie_produit` (`categorie_id`, `produit_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(3, 4),
(5, 6),
(6, 7),
(7, 8),
(8, 9),
(9, 10);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `commentaire_id` int(11) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `produit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`commentaire_id`, `contenu`, `produit_id`) VALUES
(1, 'Assurance avec un bon rapport qualité prix', 2),
(2, 'Minimum du minimum, un peu deçu', 1),
(3, 'Ce qu\'on peut attendre d\'une assurance au tiers, ni plus, ni moins', 1),
(4, 'Excellente assurance tous risques ! Prix compétitif vis à vis des autres assureurs', 3),
(5, 'L\'assurance est bien, mais les délais de traitement ne me conviennent pas, trop d\'attente!', 3),
(6, 'Assurance extraordinaire!', 7),
(7, 'Assurance extraordinaire!', 8),
(8, 'Assurance extraordinaire!', 9),
(9, 'Assurance extraordinaire!', 10);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `produit_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `cout` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`produit_id`, `nom`, `description`, `cout`) VALUES
(1, 'AssuranceAuTiersSimple', 'Assurance couvrant uniquement les dégats matériels et corporels que vous êtes susceptible de causer à autrui avec votre véhicule.', 3000),
(2, 'AssuranceAuTiersEtendue', 'Assurance couvrant le minimum de la garantie responsabilité civile et le bris de glace, le vol, l\'attentat, les catastrophes naturelles et technologiques', 800),
(3, 'AssuranceTousRisques', 'Assurance qui reprend les garanties de l\'assurance au tiers étendue et auxquelles on ajoute la garantie dommage tous accidents (responsable ou non).', 1500),
(4, 'AssuranceTousRisquesJeunes', 'L\'assurance tous risques pour les jeunes conducteurs (- 2 ans de permis de conduire)', 2200),
(5, 'AssuranceAuTiersFidelite', 'Les garanties de l\'assurance au tiers à un prix moindre grâce à votre fidélité!', 1100),
(6, 'AssuranceAuTiersFidelite', 'Les garanties de l\'assurance au tiers à un prix moindre grâce à votre fidélité!', 1100),
(7, 'AssuranceAuTiersFidelite', 'Les garanties de l\'assurance au tiers à un prix moindre grâce à votre fidélité!', 1100),
(8, 'AssuranceAuTiersFidelite', 'Les garanties de l\'assurance au tiers à un prix moindre grâce à votre fidélité!', 1100),
(9, 'AssuranceAuTiersFidelite', 'Les garanties de l\'assurance au tiers à un prix moindre grâce à votre fidélité!', 1100),
(10, 'AssuranceAuTiersFidelite', 'Les garanties de l\'assurance au tiers à un prix moindre grâce à votre fidélité!', 1100);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`categorie_id`);

--
-- Index pour la table `categorie_produit`
--
ALTER TABLE `categorie_produit`
  ADD PRIMARY KEY (`categorie_id`,`produit_id`),
  ADD KEY `produitid_idx` (`produit_id`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`commentaire_id`),
  ADD KEY `produitid_idx` (`produit_id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`produit_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `categorie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `commentaire_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `produit_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `categorie_produit`
--
ALTER TABLE `categorie_produit`
  ADD CONSTRAINT `categorieid` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`categorie_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `produit_id` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`produit_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `produitid` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`produit_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
