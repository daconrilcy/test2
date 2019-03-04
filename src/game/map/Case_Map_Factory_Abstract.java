package game.map;

public abstract class Case_Map_Factory_Abstract {

    abstract Case_Map[] creerCaseViergeSelonDimension(int largeur, int longueur);
    abstract void setTypeMerChampsCaseSelonCoupureProporition(Case_Map[] case_maps , int AngleDegresCoupure , long partMer , int longueur , int largeur);

}
