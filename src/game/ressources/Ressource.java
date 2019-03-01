package game.ressources;

import java.awt.*;

public abstract class Ressource {
    private Image pict;
    private String nom;
    private int taille;
    private int rangFabric;

    public Ressource() {

    }


    public Image getPict() {
        return pict;
    }

    public void setPict(Image pict) {
        this.pict = pict;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getRangFabric() {
        return rangFabric;
    }

    public void setRangFabric(int rangFabric) {
        this.rangFabric = rangFabric;
    }

    public Ressource(String nom) {
        this.nom = nom;
        setTaille(1);
        setRangFabric(0);
    }

    public Ressource(String nom, int taille) {
        this.nom = nom;
        this.taille = taille;
        setRangFabric(0);
    }

    public Ressource(String nom, int taille, int rangFabric) {
        this.nom = nom;
        this.taille = taille;
        this.rangFabric = rangFabric;
    }

    public Ressource(Image pict, String nom, int taille, int rangFabric) {
        this.pict = pict;
        this.nom = nom;
        this.taille = taille;
        this.rangFabric = rangFabric;
    }


}
