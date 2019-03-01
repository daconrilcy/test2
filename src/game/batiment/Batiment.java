package game.batiment;

import game.map.ObjetMap;

abstract class Batiment extends ObjetMap {
    private String type;
    private int nbMatConstruct;
    private Materiaux_Construct matConstruct;
    private Statut_Abstract statut;


    public String getType() {
        return type;
    }

    public int getNbMatConstruct() {
        return nbMatConstruct;
    }

    public Materiaux_Construct getMatConstruct() {
        return matConstruct;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNbMatConstruct(int nbMatConstruct) {
        this.nbMatConstruct = nbMatConstruct;
    }

    public void setMatConstruct(Materiaux_Construct matConstruct) {
        this.matConstruct = matConstruct;
    }


    public Batiment() {
        super();
    }

    public Statut_Abstract getStatut() {
        return statut;
    }

    public void setStatut(Statut_Abstract statut) {
        this.statut = statut;
    }
}
