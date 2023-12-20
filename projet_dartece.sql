-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 03 avr. 2022 à 20:06
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_dartece`
--

-- --------------------------------------------------------

--
-- Structure de la table `cartebancaire`
--

DROP TABLE IF EXISTS `cartebancaire`;
CREATE TABLE IF NOT EXISTS `cartebancaire` (
  `Numerocarte` text NOT NULL,
  `Cvc` int(11) NOT NULL,
  `Dateexpiration` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cartebancaire`
--

INSERT INTO `cartebancaire` (`Numerocarte`, `Cvc`, `Dateexpiration`) VALUES
('1234 5678 9012 3456', 123, '04/22'),
('2345 6789 0123 4567', 234, '04/22'),
('3456 7890 1234 5678', 345, '05/22'),
('4567 8901 2345 6789', 456, '06/22');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `Nom Client` text NOT NULL,
  `Articles` text NOT NULL,
  `Prix total` float NOT NULL,
  `Date` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`Nom Client`, `Articles`, `Prix total`, `Date`) VALUES
('tibo.travail@gmail.com', 'Sodastream Pack Eau Pétillante / Rowenta 160 Aspirateur / ', 649.99, '03/04/2022'),
('tibo.travail@gmail.com', 'NBA 2K22 (PS5) / Manette PS5 / ', 104.98, '03/04/2022');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL,
  `Nom` text NOT NULL,
  `Prix` float NOT NULL,
  `Prix vrac` float NOT NULL,
  `Categorie` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `Nom`, `Prix`, `Prix vrac`, `Categorie`) VALUES
(11, 'NBA 2K22 (XBOX SERIES X)', 34.99, 22.99, 'Jeux videos'),
(10, 'Fifa 22 (XBOX SERIES X)', 49.75, 39.99, 'Jeux videos'),
(9, 'Gran Turismo 7 (PS5)', 64.99, 56.99, 'Jeux videos'),
(8, 'NBA 2K22 (PS5)', 29.99, 22.99, 'Jeux videos'),
(6, 'Jabra Elite 75 Pro', 199.99, 169.99, 'Electronique'),
(7, 'Fifa 22 (PS5)', 49.75, 39.99, 'Jeux videos'),
(5, 'ThinkPad 15\"', 1487.25, 1200, 'Electronique'),
(1, 'iPhone 11', 589, 550, 'Electronique'),
(2, 'iPhone 12', 749, 699, 'Electronique'),
(3, 'iPhone 13', 859, 799, 'Electronique'),
(4, 'MacBook Air 13\"', 1129, 999, 'Electronique'),
(12, 'Rowenta 160 Aspirateur', 540, 499, 'Electromenager'),
(13, 'Aspirateur Balai', 135.99, 119.99, 'Electromenager'),
(14, 'Russell Hobbs Cuiseur Vapeur 9L', 35.15, 29.99, 'Electromenager'),
(15, 'Sodastream Pack Eau Pétillante', 109.99, 79.99, 'Electromenager'),
(16, 'Trisar Friteuse 3L', 41.99, 34.99, 'Electromenager'),
(17, 'Paradise - Hamza (Album)', 9.99, 7.99, 'Musique'),
(18, 'Jefe - Ninho (Album)', 9.99, 7.99, 'Musique'),
(19, 'No Crari - Oboy (Album)', 9.99, 7.99, 'Musique'),
(20, 'Avec Toi - Oboy (Single)', 1.99, 0.99, 'Musique'),
(21, 'Destinated 2 Win - Lil Tjay (Album Deluxe Edition)', 14.99, 11.99, 'Musique'),
(22, 'XBOX SERIE X', 499.99, 449.99, 'Jeux videos'),
(23, 'PS5', 549.99, 499.99, 'Jeux videos'),
(24, 'Manette PS5', 74.99, 69.99, 'Jeux videos'),
(25, 'Manette XBOX SERIES X', 59.99, 54.99, 'Jeux videos'),
(26, 'Nintendo Switch Lite - Gris', 266.09, 249.09, 'Jeux videos'),
(27, 'Just Dance 2022 (Switch)', 59.99, 44.14, 'Jeux videos'),
(28, 'BOSCH - Lave linge', 599.99, 419.99, 'Electromenager'),
(37, 'Caramelo - Ninho (Single)', 1.99, 0.99, 'Musique'),
(30, 'Toshiba Four à Micro-ondes 800W', 129, 109, 'Electromenager'),
(31, 'Bosch - Bouilloire 1,7L', 74.99, 64.99, 'Electromenager'),
(32, 'Klarstein Sèche Linge', 519.99, 479.99, 'Electromenager'),
(33, 'Enna boost - PLK (Album)', 9.99, 7.99, 'Musique'),
(34, '17% - Leto (Album)', 9.99, 7.99, 'Musique'),
(35, 'Deux frères - PNL (Album)', 10.99, 8.99, 'Musique'),
(36, 'Imperfections - Pop Smoke (Single)', 1.99, 0.99, 'Musique'),
(38, 'Always do - The Kid LAROI (Single)', 1.99, 0.99, 'Musique'),
(39, 'Ipséité - Damso (Album)', 9.99, 7.99, 'Musique'),
(40, 'Bosch Réfrigérateur 117L', 329.99, 280.99, 'Electromenager'),
(41, 'Tefal Balance Cuisine', 15.24, 12.4, 'Electromenager'),
(42, 'Machine à Pop Corn', 19.99, 14.99, 'Electromenager'),
(43, 'GTA VI (PS5)', 59.99, 49.99, 'Jeux videos'),
(44, 'GTA VI (XBOX SERIES X)', 59.99, 49.99, 'Jeux videos'),
(45, 'Samsung Galaxy S8', 329, 272.6, 'Electronique'),
(46, 'Apple iPad 128Go', 439.9, 399, 'Electronique'),
(47, 'Samsung Galaxy S8', 272.6, 195, 'Electronique');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL,
  `Prenom` text NOT NULL,
  `Nom` text NOT NULL,
  `NumeroCarte` text NOT NULL,
  `Ville` text NOT NULL,
  `Mail` text NOT NULL,
  `Mot de passe` text NOT NULL,
  `Categorie` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `Prenom`, `Nom`, `NumeroCarte`, `Ville`, `Mail`, `Mot de passe`, `Categorie`) VALUES
(1, 'Thibaut', 'Weibel', '1234 5678 9012 3456 ', 'Paris', 'tibo', '', 'Client'),
(2, 'Thibaut', 'Weibel', '1234 5678 9012 3457', 'Paris', 'tibo', '', 'Admin'),
(3, 'Manwa', 'Battah', '3456 7890 1234 5678', 'Suwon', 'manwa@gmail.com', 'manwaa2', 'Client'),
(5, 'Anis', 'Bouchakor', '2345 6789 0123 4567', 'Paris', 'anis@gmail.com', 'aniss', 'Client'),
(4, 'Emma', 'Schapira', '2345 6789 0123 4567', 'Paris', 'emma.schapi@gmail.com', 'schapi2', 'Admin');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
