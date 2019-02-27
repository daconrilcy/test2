package map;

public class Bat_Implement implements Bat_Interface {
    Batiment[] bats;

    int nbBatiment = 10000;
    public Bat_Implement(){
        bats = new Batiment[nbBatiment];
    }

    @Override
    public Batiment creerBatiment(String type, int longueur, int largeur, int[] materiaux) {

        Batiment bat = new Batiment() {};
        bat.setType(type);
        bat.setLongueur(longueur);
        bat.setLargeur(largeur);
        bat.setMatConstruct(materiaux);
        bat.setNbMatConstruct(materiaux.length);

        return bat;
    }

    @Override
    public Integer creerBatiment1x1x1x1(String type) {
        int[] materiaux = {1};
        Batiment bat = creerBatiment(type , 1 , 1, materiaux);
        return Batiment.getIndex();
    }

    @Override
    public Integer creerBatiment2x1x1x1(String type) {
        int[] materiaux = {1,2};
        Batiment bat = creerBatiment(type , 1 , 1, materiaux);
        return Batiment.getIndex();
    };

    @Override
    public void creerCabaneBucheron() {
        int i = creerBatiment1x1x1x1("Cabane de Bucherons");
        messageCreation(i);
    }

    @Override
    public void creerCabaneCarriere() {
        int i = creerBatiment2x1x1x1("Carrière");
        messageCreation(i);
    }

    @Override
    public void messageCreation(int i) {
        System.out.println("Le Batiment "+ bats[i].getType() + " a été créé. Son statut est " + bats[i].getStatutEncours());
    }
}
