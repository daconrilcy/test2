package game.batiment;

public interface Bat_Interface {
    void creerBatiment(String type, int longueur, int largeur, Materiaux_Construct materiaux_construct);
    void creerCabaneBucheron();
    void creerCabaneCarriere();
    void messageCreation(int index);
}
