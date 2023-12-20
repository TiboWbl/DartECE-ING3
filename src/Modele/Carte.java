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
public class Carte {

    private String nom;
    private String numéro_carte;
    private int cvc;
    private String date_expiration;

    public Carte(String nom, String numéro_carte, int cvc, String date_expiration) {
        this.nom = nom;
        this.numéro_carte = numéro_carte;
        this.cvc = cvc;
        this.date_expiration = date_expiration;
    }

    public String getNom() {
        return nom;
    }

    public String getNuméroCarte() {
        return numéro_carte;
    }

    public int getCvc() {
        return cvc;
    }

    public String getDateExpiration() {
        return date_expiration;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNuméroCarte(String numéro_carte) {
        this.numéro_carte = numéro_carte;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public void setDateExpiration(String date_expiration) {
        this.date_expiration = date_expiration;
    }
}
