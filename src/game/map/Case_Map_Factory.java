package game.map;

public class Case_Map_Factory extends Case_Map_Factory_Abstract {
    @Override
    Case_Map[] creerCaseViergeSelonDimension(int largeur, int longueur) {
        Case_Map[] case_maps = new Case_Map[largeur * longueur];
        int index=0;
        for (int h=0;h<largeur ; h++){
            for (int l=0;l<largeur ;l++){
                Coordonnees coord = new Coordonnees(l,h);
                case_maps[index] = new Case_Map();
                case_maps[index].setCoordonnees(coord);
                case_maps[index].setIndex(index);
                index += 1;
            }
        }
        return case_maps;
    }
}
