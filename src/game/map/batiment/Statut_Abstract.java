package game.map.batiment;

public class Statut_Abstract {
    private String[] liste = {"Null" , "Cree" , "En construction" , "En production" , "A l'arrêt" , "En destruction"};
    private String enCoursVal;
    private int enCoursIndex;

    public String[] getListe() {
        return liste;
    }

    public void setListe(String[] liste) {
        this.liste = liste;
    }

    public String getEnCoursVal() {
        return enCoursVal;
    }

    public void setEnCoursVal(String statut) {
        for (int n =0 ; n < liste.length ; n++){
            if (statut == liste[n]){
                enCoursIndex = n;
                enCoursVal = statut;
                break;
            }
        }
    }

    public int getEnCoursIndex() {
        return enCoursIndex;
    }

    public void setEnCoursIndex(int index) {
        if (index >= 0 && index < liste.length){
            enCoursIndex = index;
            enCoursVal = liste[index];
        }
    }

    public Statut_Abstract() {
        enCoursVal = liste[0];
        enCoursIndex = 0;
    }

}
