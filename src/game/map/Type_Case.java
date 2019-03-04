package game.map;

public class Type_Case {
    String nom;
    String couleur;
    int index;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    Type_Case () {
    }

    public Type_Case(String nom, String couleur, int index) {
        this.nom = nom;
        this.couleur = couleur;
        this.index = index;
    }
}
