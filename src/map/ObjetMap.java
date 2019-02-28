package map;

public abstract class ObjetMap {

    static int index;
    private int largeur;
    private int longueur;
    private int resistance;

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        ObjetMap.index = index;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public ObjetMap() {
    }

}
