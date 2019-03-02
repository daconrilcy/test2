package game.map;

import game.ressources.Ressource;

public class Case_Map {
    int index;
    Coordonnees coordonnees;
    Ressource[] ressource;
    int[] quantiteRessource;
    int type;
    long Altitude;

    public Case_Map(){

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Ressource[] getRessource() {
        return ressource;
    }

    public void setRessource(Ressource[] ressource) {
        this.ressource = ressource;
    }

    public int[] getQuantiteRessource() {
        return quantiteRessource;
    }

    public void setQuantiteRessource(int[] quantiteRessource) {
        this.quantiteRessource = quantiteRessource;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getAltitude() {
        return Altitude;
    }

    public void setAltitude(long altitude) {
        Altitude = altitude;
    }
}
