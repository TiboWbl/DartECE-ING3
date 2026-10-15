# DartECE

Application de bureau de e-commerce développée en Java (Swing) dans le cadre d'un projet ING3 à l'ECE Paris. Elle simule une boutique en ligne avec un espace **client** (catalogue, panier, paiement, historique) et un espace **employé/admin** (gestion des articles, des clients, des commandes et statistiques de ventes).

## Fonctionnalités

### Espace client
- Inscription et connexion (compte de type `Client` ou `Admin`)
- Catalogue par catégorie : **Électroménager**, **Électronique**, **Musique / Albums**, **Jeux vidéo**
- Panier : ajout/suppression d'articles, calcul du prix total
- **Prix en promotion** : chaque produit a un prix « vrac » appliqué dès que le même produit est acheté plus de 2 fois
- Paiement par carte bancaire (vérification du numéro, du CVC et de la date d'expiration en base)
- Historique des commandes
- Gestion du compte : modification des informations, suppression du compte

### Espace employé (admin)
- Ajout, modification et suppression d'articles
- Consultation de la liste des clients
- Consultation des commandes
- Statistiques des ventes : camembert (JFreeChart) des commandes par tranche de prix

## Architecture

Le projet suit le modèle **MVC** :

```
src/
├── Controller/
│   └── Controle.java        # Point d'entrée (main) et navigation entre les fenêtres
├── Modele/
│   ├── Connexion.java       # Accès à la base MySQL via JDBC (toutes les requêtes)
│   ├── Utilisateur.java
│   ├── Produit.java
│   └── Carte.java
└── View/                    # Fenêtres Swing (conçues avec l'éditeur NetBeans, fichiers .form)
    ├── Login, Inscription, Menu, Compte
    ├── Electromenager, Electronique, Musique, Jeuxvideo
    ├── Panier, Paiement, Promo, Historique
    └── Admin, AjoutProduit, ModifierProduit, Modif, Clients
```

Autres éléments du dépôt :

| Chemin | Contenu |
|---|---|
| `projet_dartece.sql` | Dump de la base de données (schéma + données de test) |
| `*.png`, `*.jpg`, `*.jpeg` | Images utilisées par l'interface |
| `lib/` | Driver MySQL et `rs2xml.jar` |
| `dist/` | JAR exécutable compilé (`Projet_Java.jar`) et ses bibliothèques |
| `jfreechart-1.0.1/` | Bibliothèque JFreeChart (graphiques) |
| `JDBC2020/` | Projet d'exemple JDBC fourni en cours (non utilisé par l'application) |
| `nbproject/`, `build.xml` | Configuration du projet NetBeans / Ant |

## Prérequis

- **Java 8** ou supérieur
- **MySQL 5.7** (ou MariaDB), par exemple via WAMP / MAMP / XAMPP
- **NetBeans** (recommandé pour ouvrir et modifier le projet)

Bibliothèques (incluses dans le dépôt, dans `lib/` et `jfreechart-1.0.1/`) :
- `mysql-connector-java` (driver JDBC)
- `jfreechart-1.0.1.jar` et `jcommon-1.0.0.jar` (graphiques)
- `rs2xml.jar` (affichage des `ResultSet` dans les `JTable`)

## Installation

### 1. Base de données

Créer la base et importer le dump :

```bash
mysql -u root -e "CREATE DATABASE projet_dartece"
mysql -u root projet_dartece < projet_dartece.sql
```

(ou via phpMyAdmin : créer la base `projet_dartece` puis importer `projet_dartece.sql`).

L'application se connecte avec les paramètres codés en dur dans [`src/Modele/Connexion.java`](src/Modele/Connexion.java) :

```java
String url = "jdbc:mysql://localhost:3306/projet_dartece?";
conn = DriverManager.getConnection(url, "root", "");
```

Adapter l'URL, l'utilisateur ou le mot de passe si votre configuration MySQL est différente.

### 2. Lancer l'application

**Avec NetBeans (recommandé) :**

1. `File > Open Project` et sélectionner ce dossier
2. Lancer le projet (classe principale : `Controller.Controle`)

Les bibliothèques sont référencées par des chemins relatifs, aucune configuration n'est nécessaire.

**En ligne de commande (avec Ant) :**

```bash
ant jar
java -jar dist/Projet_Java.jar
```

Lancer l'application depuis la racine du projet : les images de l'interface sont chargées par des chemins relatifs à ce dossier.

## Comptes de test

Le plus simple est de créer un compte depuis l'écran d'inscription : choisir le type `Client` pour l'espace boutique, ou `Admin` pour accéder à l'espace employé.

Pour le paiement, le numéro de carte du compte doit correspondre à une carte de la table `cartebancaire`, par exemple `3456 7890 1234 5678`, CVC `345`, expiration `05/22`.

## Base de données

| Table | Description |
|---|---|
| `utilisateur` | Comptes clients et admins (nom, ville, e-mail, mot de passe, numéro de carte, catégorie) |
| `produit` | Articles (nom, prix, prix vrac/promo, catégorie) |
| `commande` | Commandes passées (client, articles, prix total, date) |
| `cartebancaire` | Cartes bancaires fictives utilisées pour valider les paiements |

## Limites connues

Projet pédagogique, non destiné à la production :
- Mots de passe stockés en clair
- Requêtes SQL construites par concaténation (vulnérables aux injections SQL)
- Identifiants de connexion MySQL codés en dur
