/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author gameu
 */
public class Utilisateur {

    private int id;
    private String prénom;
    private String nom;
    private String numéro_carte;
    private String localisation;
    private String mail;
    private String mdp;
    private String catégorie;
    private ArrayList<Produit> panier = new ArrayList();

    public void AjouterPanier(Produit produit) {
        panier.add(produit);
    }

    public void SupprimerElemPanier(int i) {
        panier.remove(i);
    }

    public void ViderPanier() {
        panier.clear();
    }

    public String getNuméro_carte() {
        return numéro_carte;
    }

    public void setNuméro_carte(String numéro_carte) {
        this.numéro_carte = numéro_carte;
    }

    public ArrayList<Produit> getPanier() {
        return panier;
    }

    public void setPanier(ArrayList<Produit> panier) {
        this.panier = panier;
    }

    public Utilisateur(int id, String prénom, String nom, String numéro_carte, String localisation, String mail, String mdp, String catégorie) {
        this.id = id;
        this.prénom = prénom;
        this.nom = nom;
        this.numéro_carte = numéro_carte;
        this.localisation = localisation;
        this.mail = mail;
        this.mdp = mdp;
        this.catégorie = catégorie;
    }

    public Utilisateur() {
        this.id = 0;
        this.prénom = "";
        this.nom = "";
        this.numéro_carte = "";
        this.localisation = "";
        this.mail = "";
        this.mdp = "";
        this.catégorie = "";
    }

    public int getId() {
        return id;
    }

    public String getPrénom() {
        return prénom;
    }

    public String getNom() {
        return nom;
    }

    public String getNumCarte() {
        return numéro_carte;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getMail() {
        return mail;
    }

    public String getMdp() {
        return mdp;
    }

    public String getCatégorie() {
        return catégorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setCatégorie(String catégorie) {
        this.catégorie = catégorie;
    }
}
