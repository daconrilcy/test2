package game.map;

public class Case_Map_Factory extends Case_Map_Factory_Abstract {
    @Override
    Case_Map[] creerCaseViergeSelonDimension(int largeur, int longueur) {
        Case_Map[] case_maps = new Case_Map[largeur * longueur];
        int index=0;
        for (int h=0;h<largeur ; h++){
            index = h*longueur;
            for (int l=0;l<largeur ;l++){
                Coordonnees coord = new Coordonnees(l,h);
                case_maps[index] = new Case_Map();
                case_maps[index].setCoordonnees(coord);
                case_maps[index].setIndex(index);
            }
        }
        return case_maps;
    }

    @Override
    void setTypeMerChampsCaseSelonCoupureProporition(Case_Map[] case_maps, int AngleDegresCoupure, long partMer , int longueur , int largeur) {
        if ((AngleDegresCoupure >= 0 && AngleDegresCoupure < 45) || (AngleDegresCoupure >= 135 && AngleDegresCoupure < 215) || (AngleDegresCoupure >= 315 && AngleDegresCoupure < 360)){
            int columnHautDemarquation = (int)((long)longueur * partMer);
            int columnBasseDemarquation = longueur - columnHautDemarquation;
            int coefDecalParLigne;
        }
    }
}
