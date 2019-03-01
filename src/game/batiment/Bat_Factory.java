package game.batiment;

import game.ressources.Ressource;
import game.ressources.Types_Ressources;

public class Bat_Factory implements Bat_Interface {
    private Batiment[] listeBatiments;
    private Statut_Abstract statut;
    private Types_Ressources listeRessources;
    private int nBat;
    private int nbBatimentMax = 10000;

    public Batiment[] getListeBatiments() {
        return listeBatiments;
    }

    public void setListeBatiments(Batiment[] listeBatiments) {
        this.listeBatiments = listeBatiments;
    }

    public Statut_Abstract getStatut() {
        return statut;
    }

    public void setStatut(Statut_Abstract statut) {
        this.statut = statut;
    }

    public Types_Ressources getListeRessources() {
        return listeRessources;
    }

    public void setListeRessources(Types_Ressources listeRessources) {
        this.listeRessources = listeRessources;
    }

    public int getnBat() {
        return nBat;
    }

    public void setnBat(int nBat) {
        this.nBat = nBat;
    }

    public int getNbBatimentMax() {
        return nbBatimentMax;
    }

    public void setNbBatimentMax(int nbBatimentMax) {
        this.nbBatimentMax = nbBatimentMax;
    }

    public Bat_Factory(Types_Ressources listeRessources){
        setListeBatiments(new Batiment[nbBatimentMax]);
        setStatut(new Statut_Abstract());
        setListeRessources(listeRessources);
        setnBat(0);
    }


    @Override
    public void creerBatiment(String type, int longueur, int largeur , Materiaux_Construct materiaux_construct) {
        if (nBat <= nbBatimentMax) {
            statut.setEnCoursIndex(1);
            Batiment bat = new Batiment() {
            };
            bat.setType(type);
            bat.setLongueur(longueur);
            bat.setLargeur(largeur);
            bat.setStatut(statut);
            bat.setMatConstruct(materiaux_construct);
            listeBatiments[nBat] = bat;
            nBat++;
        }else{
            System.out.println("Le nombre maximum ("+ nbBatimentMax + ") de batiment cree est atteint ");
        }
    }

    @Override
    public void creerCabaneBucheron() {
        Materiaux_Construct mc = new Materiaux_Construct(1) {
        };
        Ressource res = listeRessources.getRessource(4);
        mc.ajouterMateriaux(res,3);
        creerBatiment("Cabane de Bucherons" , 1 , 1, mc);

        messageCreation(nBat -1);
    }

    @Override
    public void creerCabaneCarriere() {

        Ressource[] res = {listeRessources.getRessource(4) , listeRessources.getRessource(5)};
        int[] qte = {2,2};
        Materiaux_Construct mc = new Materiaux_Construct(res , qte){};

        creerBatiment("Cabane du casseur de pierres" , 1 , 1 , mc );
        messageCreation(nBat -1);
    }

    @Override
    public void messageCreation(int i) {
        Statut_Abstract stat = listeBatiments[i].getStatut();
        Materiaux_Construct mc = listeBatiments[i].getMatConstruct();
        System.out.println("Le Batiment "+ listeBatiments[i].getType() + " a été créé. Son statut est " + statut.getEnCoursVal());
        System.out.println("Il necessite : " + mc.getListeMateriauxToString() + "\n");
    }
}
