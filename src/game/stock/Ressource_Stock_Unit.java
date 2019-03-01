package game.stock;
import game.ressources.Ressource;

import java.util.Arrays;


public abstract class Ressource_Stock_Unit {
    Ressource ressource;
    int quantite;
    int quantiteMax;

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;

    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantiteMax() {
        return quantiteMax;
    }

    public void setQuantiteMax(int quantiteMax) {
        this.quantiteMax = quantiteMax;
    }

    public Ressource_Stock_Unit(Ressource ressource){
        setRessource(ressource);
        setQuantite(0);
        setQuantiteMax(5);
    }

    public Ressource_Stock_Unit(Ressource ressource , int quantiteMax){
        setRessource(ressource);
        setQuantiteMax(quantiteMax);
    }

    @Override
    public String toString() {
        return "Type : " + ressource.getNom() + " - quantie : " + quantite + " - Max en Stock : " + quantiteMax;
    }

    public int ajouterUnite(){
        int q  = getQuantite();
        if (q < quantiteMax){
            setQuantite(q+1);
            return -1;
        }
        return 0;
    }
    public int ajouterPlusieursUnite(int quantite){
        int q = getQuantite();
        if (q <= quantiteMax-quantite){
            setQuantite(q + quantite);
            return -quantite;
        }else{
            setQuantite(quantiteMax);
            return -(quantiteMax-q);
        }
    }

    public int retirerUnite(){
        int q = getQuantite();
        if (q >=1 ){
            setQuantite(q-1);
            return 1;
        }
        return 0;
    }

    public int retirerPlusieursUnite(int quantite){
        int q = getQuantite();
        if (q-quantite >= 0){
            setQuantite(q-quantite);
            return quantite;
        }else {
            setQuantite(0);
            return quantite-q;
        }
    }
}
