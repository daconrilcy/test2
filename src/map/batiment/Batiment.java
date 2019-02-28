package map.batiment;

import map.ObjetMap;

abstract class Batiment extends ObjetMap {
    private String type;
    private int nbMatConstruct;
    private int[] matConstruct;
    private String[] statut;
    private String statutEncours;

    public String[] getStatut() {
        return statut;
    }

    public void setStatut(String[] statut) {
        this.statut = statut;
    }



    public String getType() {
        return type;
    }

    public int getNbMatConstruct() {
        return nbMatConstruct;
    }

    public int[] getMatConstruct() {
        return matConstruct;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNbMatConstruct(int nbMatConstruct) {
        this.nbMatConstruct = nbMatConstruct;
    }

    public void setMatConstruct(int[] matConstruct) {
        this.matConstruct = matConstruct;
    }

    public String getStatutEncours() {
        return statutEncours;
    }

    public void setStatutEncours(String statutEncours) {
        this.statutEncours = statutEncours;
    }

    public Batiment() {
        super();
        setStatut(new String[] {"Crée", "En cours de fabrication","Operationnel", "Probleme" , "Detruit"});
        setStatutEncours(statut[0]);
    }
}
