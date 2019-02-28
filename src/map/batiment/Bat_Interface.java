package map.batiment;

public interface Bat_Interface {
    public Batiment creerBatiment(String type , int longueur , int largeur , int[] nbMateriaux );
    public Integer creerBatiment1x1x1x1(String type);
    public Integer creerBatiment2x1x1x1(String type);
    public void creerCabaneBucheron();
    public void creerCabaneCarriere();
    public void messageCreation(int index);
}
