package game.map.batiment;

import game.map.ressources.Types_Ressources;

public class Bat_Factory implements Bat_Interface {
    Batiment[] listeBatiments;
    Statut_Abstract statut;
    Types_Ressources listeRessources;
    int nBat;
    int nbBatimentMax = 10000;

    public Bat_Factory(Types_Ressources listeRessources){
        listeBatiments = new Batiment[nbBatimentMax];
        statut = new Statut_Abstract();
        listeRessources = listeRessources;
        nBat = 0;
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
        mc.ajouterMateriaux(listeRessources.getRessource(4),2);
        creerBatiment("Cabane de Bucherons" , 1 , 1, mc);

        messageCreation(nBat -1);
    }

    @Override
    public void creerCabaneCarriere() {
        int i = 0;
        messageCreation(i);
    }

    @Override
    public void messageCreation(int i) {
        Statut_Abstract stat = listeBatiments[i].getStatut();
        Materiaux_Construct mc = listeBatiments[i].getMatConstruct();
        System.out.println("Le Batiment "+ listeBatiments[i].getType() + " a été créé. Son statut est " + statut.enCoursVal +"\n");
        System.out.println("Il necessite : " + mc.toString());
    }
}
