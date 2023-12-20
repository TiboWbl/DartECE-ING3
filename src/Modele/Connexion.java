/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gameu
 */
public class Connexion {

    public Connection conn;

    public void connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/projet_dartece?";
            conn = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void AjouterUtilisateur(String prenom, String nom, String numero_carte, String ville, String mail, String mdp, String categorie) throws SQLException {

        this.connect();
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT * FROM utilisateur WHERE 1");
        r.last();
        int id = r.getRow();
        r.beforeFirst();
        id++;

        try {
            String q = "INSERT INTO `utilisateur`(`id`,`Prenom`, `Nom`, `NumeroCarte`, `Ville`, `Mail`, `Mot de passe`, `Categorie`) VALUES ('" + id + "','" + prenom + "','" + nom + "','" + numero_carte + "','" + ville + "','" + mail + "','" + mdp + "','" + categorie + "')";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void AjouterProduit(String nom, float prix, float prix_vrac, String catégorie) throws SQLException {
        this.connect();
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT * FROM produit WHERE 1");
        r.last();
        int id = r.getRow();
        r.beforeFirst();
        id=id+2;
        try {
            String q = "INSERT INTO `produit`(`id`,`Nom`, `Prix`, `Prix vrac`, `Categorie`) VALUES ('" + id + "','" + nom + "','" + prix + "','" + prix_vrac + "','" + catégorie + "')";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void AjouterCommande(String nom, String articles, float prix) throws SQLException {
        this.connect();
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        java.util.Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);

        try {
            String q = "INSERT INTO `commande`(`Nom Client`, `Articles`, `Prix total`, `Date`) VALUES ('" + nom + "','" + articles + "','" + prix + "','" + formattedDate + "')";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SupprimerUtilisateur(int id) {
        this.connect();
        try {
            String q = "DELETE FROM `utilisateur` WHERE `id` = '" + id + "'";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void SupprimerUtilisateur2(String mail) {
        this.connect();
        try {
            String q = "DELETE FROM `utilisateur` WHERE `Mail` = '" + mail + "'";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SupprimerProduit(String nom) {
        this.connect();
        try {
            String q = "DELETE FROM `produit` WHERE `Nom` = '" + nom + "'";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SeConnecter(String mail, String mdp, String catégorie) {
        this.connect();
        try {
            if (mail != null && mdp != null) {
                String q = "SELECT * FROM `utilisateur` WHERE `Mail` = '" + mail + "' AND `Mot de passe` = '" + mdp + "' AND `Categorie` = '" + catégorie + "'";
                PreparedStatement pst = conn.prepareStatement(q);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    //in this case enter when at least one result comes it means user is valid
                    JOptionPane.showMessageDialog(null, "Vous êtes connecté");
                } else {
                    //in this case enter when  result size is zero  it means user is invalid
                    JOptionPane.showMessageDialog(null, "Votre compte n'existe pas, créez en un ou réessayez de vous connecter");
                }
            }
            //You can also validate user by result size if its comes zero user is invalid else user is valid
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    public Utilisateur SeConnecter2(String mail, String mdp, String catégorie) throws SQLException {
        this.connect();
        Utilisateur Tibo = null;
        ResultSet rs = null;

        try {
            if (mail != null && mdp != null) {
                String q = "SELECT * FROM `utilisateur` WHERE `Mail` = '" + mail + "' AND `Mot de passe` = '" + mdp + "' AND `Categorie` = '" + catégorie + "'";
                PreparedStatement pst = conn.prepareStatement(q);
                rs = pst.executeQuery();
                if (rs.next()) {
                    //in this case enter when at least one result comes it means user is valid
                    Tibo = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                } else {
                    //in this case enter when  result size is zero  it means user is invalid
                    JOptionPane.showMessageDialog(null, "Votre compte n'existe pas, créez en un ou réessayez de vous connecter");
                    Tibo = null;
                }
            } else {
                Tibo = null;
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return Tibo;
    }

    public void ActualiserUtilisateur(int id, String prenom, String nom, String numero_carte, String ville, String mail, String mdp, String categorie) {
        this.connect();
        try {
            String q = "UPDATE `utilisateur` SET `id`='" + id + "',`Prenom`='" + prenom + "',`Nom`='" + nom + "',`NumeroCarte`='" + numero_carte + "',`Ville`='" + ville + "',`Mail`='" + mail + "',`Mot de passe`='" + mdp + "',`Categorie`='" + categorie + "' WHERE `id` = '" + id + "'";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void ActualiserProduit(int id, String nom, float prix, float prix_vrac, String categorie) {
        this.connect();
        try {
            String q = "UPDATE `produit` SET `Nom`='" + nom + "',`Prix`='" + prix + "',`Prix vrac`='" + prix_vrac + "',`Categorie`='" + categorie + "' WHERE `id` = '" + id + "'";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.execute();
        } catch (Exception e) {
        }
    }

    public ResultSet AjoutButton() {
        connect();
        ResultSet rs = null;
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * from Produit");
            rs = stm.executeQuery();
        } catch (Exception e) {

        }
        return rs;
    }

    public Produit RechercherProduit(int id) throws SQLException {
        this.connect();

        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT * FROM produit WHERE `id` = '" + id + "'");
        String idd = r.getString("id");
        String nom = r.getString("Nom");
        String prix_vrac = r.getString("Prix vrac");
        String prix = r.getString("Prix");
        String categorie = r.getString("categorie");

        Produit prod = new Produit(parseInt(idd), nom, parseFloat(prix), parseFloat(prix_vrac), categorie);

        return prod;
    }

    public Produit RechercherProduit(String nom) throws SQLException {
        this.connect();

        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT * FROM produit WHERE `Nom` = '" + nom + "'");
        r.next();
        String id = r.getString("id");
        String nomm = r.getString("Nom");
        String prix = r.getString("Prix");
        String prix_vrac = r.getString("Prix vrac");
        String categorie = r.getString("Categorie");

        Produit prod = new Produit(parseInt(id), nomm, parseFloat(prix), parseFloat(prix_vrac), categorie);

        return prod;
    }

    public ArrayList<Float> RechercherPrix() {
        this.connect();
        ArrayList<Float> stat = new ArrayList();

        Statement s;
        try {
            s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet r = s.executeQuery("SELECT `Prix` FROM produit WHERE 1");
            while (r.next()) {
                String prix = r.getString("Prix");
                stat.add(parseFloat(prix));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stat;
    }

    public Utilisateur RechercherUtilisateur(int id) throws SQLException {
        this.connect();

        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT * FROM utilisateur WHERE `id` = '" + id + "'");
        r.next();
        String idd = r.getString("id");
        String prenom = r.getString("Prenom");
        String nomm = r.getString("Nom");
        String numero_carte = r.getString("NumeroCarte");
        String ville = r.getString("Ville");
        String maile = r.getString("Mail");
        String mdp = r.getString("Mot de passe");
        String categorie = r.getString("Categorie");

        Utilisateur uti = new Utilisateur(parseInt(idd), prenom, nomm, numero_carte, ville, maile, mdp, categorie);

        return uti;
    }
    
    public boolean RechercheCarte(String numero_carte, String cvc, String date_expi) throws SQLException{
        
        boolean bool = false;
        this.connect();

        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT `Cvc`, `Dateexpiration` FROM utilisateur INNER JOIN cartebancaire WHERE cartebancaire.Numerocarte = '" + numero_carte + "' AND cartebancaire.Numerocarte = utilisateur.NumeroCarte AND `Cvc` = '" + cvc + "' AND `Dateexpiration` = '" + date_expi + "'");
        if(r.next()){
            bool=true;
        }else{
            
        }
        return bool;
    }

}
