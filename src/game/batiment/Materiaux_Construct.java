package game.batiment;

import game.ressources.Ressource;

abstract public class Materiaux_Construct {
    private Ressource[] listeMateriaux;
    private int[] quantiteMateriaux;
    private int nbMateriaux;
    private int nbMateriauxMax = 10;
    private int rgAjoutMateriaux;

    public Ressource[] getListeMateriaux() {
        return listeMateriaux;
    }

    public String getListeMateriauxToString(){
        String listeMat = "";
        for (int n = 0 ; n < listeMateriaux.length ; n++){
            listeMat += quantiteMateriaux[n] + "x";
           listeMat += listeMateriaux[n].getNom();
           if (n < listeMateriaux.length - 1 ){
               listeMat += ", ";
           }
           if (n == listeMateriaux.length - 1 ){
               listeMat += ".";
           }
        }

        return listeMat;
    };

    public void setListeMateriaux(Ressource[] listeMateriaux) {
        this.listeMateriaux = listeMateriaux;
    }

    public int[] getQuantiteMateriaux() {
        return quantiteMateriaux;
    }

    public void setQuantiteMateriaux(int[] quantiteMateriaux) {
        this.quantiteMateriaux = quantiteMateriaux;
    }

    public int getNbMateriaux() {
        return nbMateriaux;
    }

    public void ajouterMateriaux(Ressource materiaux , int quantite){
        if (rgAjoutMateriaux <= nbMateriaux){
            listeMateriaux[rgAjoutMateriaux] = materiaux;
            quantiteMateriaux[rgAjoutMateriaux] = quantite;
        }
        rgAjoutMateriaux++;
    }


    public Materiaux_Construct(int nbMateriaux) {
        if (nbMateriaux > nbMateriauxMax){
            nbMateriaux = nbMateriauxMax;
            System.out.println("Nb de matériaux limité à "+ nbMateriauxMax);
        }
        listeMateriaux = new Ressource[nbMateriaux];
        quantiteMateriaux = new int[nbMateriaux];
    }


    public Materiaux_Construct(Ressource[] listeMateriaux, int[] quantiteMateriaux) {
        this.listeMateriaux = listeMateriaux;
        this.quantiteMateriaux = quantiteMateriaux;
        nbMateriaux = listeMateriaux.length;

    }
}
