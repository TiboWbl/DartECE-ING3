package Controller;

import Modele.Produit;
import Modele.Utilisateur;
import View.Admin;
import View.AjoutProduit;
import View.Clients;
import View.Compte;
import View.Electromenager;
import View.Electronique;
import View.Historique;
import View.Login;
import View.Inscription;
import View.Jeuxvideo;
import View.Menu;
import View.Modif;
import View.ModifierProduit;
import View.Musique;
import View.Paiement;
import View.Panier;
import View.Promo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gameu
 */
public class Controle {

    private Admin adm;
    private AjoutProduit ajt;
    private Compte cmp;
    private Inscription insc;
    private Login log;
    private Modif mod;
    private ModifierProduit modifProd;
    private Utilisateur uti;
    private Utilisateur admin;
    private Menu menu;
    private Jeuxvideo jv;
    private Musique music;
    private Electromenager elecmenag;
    private Electronique electronique;
    private Panier panier;
    private Clients client;
    private Paiement paiement;
    private Historique historique;
    private Promo promo;

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public Historique getHistorique() {
        return historique;
    }

    public void setHistorique(Historique historique) {
        this.historique = historique;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Musique getMusic() {
        return music;
    }

    public void setMusic(Musique music) {
        this.music = music;
    }

    public Electromenager getElecmenag() {
        return elecmenag;
    }

    public void setElecmenag(Electromenager elecmenag) {
        this.elecmenag = elecmenag;
    }

    public Electronique getElectronique() {
        return electronique;
    }

    public void setElectronique(Electronique electronique) {
        this.electronique = electronique;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Jeuxvideo getJv() {
        return jv;
    }

    public void setJv(Jeuxvideo jv) {
        this.jv = jv;
    }

    public Utilisateur getUti() {
        return uti;
    }

    public void setUti(Utilisateur uti) {
        this.uti = uti;
    }

    public Utilisateur getAdmin() {
        return admin;
    }

    public void setAdmin(Utilisateur admin) {
        this.admin = admin;
    }

    public Admin getAdm() {
        return adm;
    }

    public AjoutProduit getAjt() {
        return ajt;
    }

    public Compte getCmp() {
        return cmp;
    }

    public Inscription getInsc() {
        return insc;
    }

    public Login getLog() {
        return log;
    }

    public Modif getMod() {
        return mod;
    }

    public ModifierProduit getModifProd() {
        return modifProd;
    }

    public void setAdm(Admin adm) {
        this.adm = adm;
    }

    public void setAjt(AjoutProduit ajt) {
        this.ajt = ajt;
    }

    public void setCmp(Compte cmp) {
        this.cmp = cmp;
    }

    public void setInsc(Inscription insc) {
        this.insc = insc;
    }

    public void setLog(Login log) {
        this.log = log;
    }

    public void setMod(Modif mod) {
        this.mod = mod;
    }

    public void setModifProd(ModifierProduit modifProd) {
        this.modifProd = modifProd;
    }

    public void AfficheAdmin() {
        adm = new Admin(this);
        adm.setVisible(true);
    }

    public void AfficheAjoutProd() {
        ajt = new AjoutProduit(this);
        ajt.setVisible(true);
    }

    public void AfficheCompte() throws SQLException {
        cmp = new Compte(this);
        cmp.setVisible(true);
    }

    public void AfficheInscription() {
        insc = new Inscription(this);
        insc.setVisible(true);
    }

    public void AfficheLogin() {
        log = new Login(this);
        log.setVisible(true);
    }

    public void AfficheModif() throws SQLException {
        mod = new Modif(this);
        mod.setVisible(true);
    }

    public void AfficheModifProduit(String a) throws SQLException {
        modifProd = new ModifierProduit(a, this);
        modifProd.setVisible(true);
    }

    public void AfficheMenu() {
        menu = new Menu(this);
        menu.setVisible(true);
    }

    public void AfficheJv() {
        jv = new Jeuxvideo(this);
        jv.setVisible(true);
    }

    public void AfficheJv(String nom) {
        jv = new Jeuxvideo(this, nom);
        jv.setVisible(true);
    }

    public void AfficheMusique() {
        music = new Musique(this);
        music.setVisible(true);
    }

    public void AfficheMusique(String nom) {
        music = new Musique(this, nom);
        music.setVisible(true);
    }

    public void AfficheElectromenager() {
        elecmenag = new Electromenager(this);
        elecmenag.setVisible(true);
    }

    public void AfficheElectromenager(String nom) {
        elecmenag = new Electromenager(this, nom);
        elecmenag.setVisible(true);
    }

    public void AfficheElectronique() {
        electronique = new Electronique(this);
        electronique.setVisible(true);
    }

    public void AfficheElectronique(String nom) {
        electronique = new Electronique(this, nom);
        electronique.setVisible(true);
    }

    public void AffichePanier(ArrayList<Produit> liste) {
        panier = new Panier(this, liste);
        panier.setVisible(true);
    }

    public void AfficheClients() {
        client = new Clients(this);
        client.setVisible(true);
    }

    public void AfficheClients(String mail) {
        client = new Clients(this, mail);
        client.setVisible(true);
    }
    
    public void AffichePaiement(String mail, String articles, float prix){
        paiement = new Paiement(this,mail,articles,prix);
        paiement.setVisible(true);
    }
    
    public void AfficheHistorique(){
        historique = new Historique(this);
        historique.setVisible(true);
    }
    
    public void AfficherPromo(){
        promo = new Promo(this);
        promo.setVisible(true);
    }

    public void Admin() {
        adm = new Admin(this);
        adm.setVisible(true);
    }

    public void AjoutProduit() {
        ajt = new AjoutProduit(this);
        ajt.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {

        Controle application = new Controle();
        application.AfficheLogin();
    }

    public Object getValueAt(int index, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
