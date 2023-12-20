/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author gameu
 */
public class Produit {

    private int id;
    private String nom_produit;
    private float prix;
    private float prix_vrac;
    private String catégorie;

    public Produit() {
        this.nom_produit = "";
        this.prix = 0;
        this.prix_vrac = 0;
        this.catégorie = "";
    }

    public Produit(int id, String nom_produit, float prix, float prix_vrac, String catégorie) {
        this.id = id;
        this.nom_produit = nom_produit;
        this.prix = prix;
        this.prix_vrac = prix_vrac;
        this.catégorie = catégorie;
    }

    public int getId() {
        return id;
    }

    public String getNomProduit() {
        return nom_produit;
    }

    public float getPrix() {
        return prix;
    }

    public float getPrixVrac() {
        return prix_vrac;
    }

    public String getCatégorie() {
        return catégorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomProduit(String nom_du_produit) {
        this.nom_produit = nom_du_produit;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setPrixVrac(float prix_vrac) {
        this.prix_vrac = prix_vrac;
    }

    public void setCatégorie(String categorie) {
        this.catégorie = categorie;
    }
}
