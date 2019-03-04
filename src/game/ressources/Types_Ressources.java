package game.ressources;

import com.cc.test.data.CSV;
import com.cc.test.data.ChargementDonnees;
import com.cc.test.data.DonneFichierCSV;

import java.util.ArrayList;

public class Types_Ressources extends Ressource{
    private Ressource[] liste;
    private ChargementDonnees chargementDonnees;

    public Ressource[] getListe() {
        return liste;
    }

    public void setListe(Ressource[] liste) {
        this.liste = liste;
    }
    public Ressource getRessource(int index){
        return liste[index];
    }

    public Ressource getRessourceByName(String nomRessource){
        for (int n=0; n < liste.length ; n++){
            if (liste[n].getNom() == nomRessource){
                return liste[n];
            }
        }
        return null;
    }

    public Types_Ressources() {
        chargementDonnees = new ChargementDonnees();
        listeParDefautl();
    }

    private void listeParDefautl(){
        try {
          setListe(chargementDonnees.getRessources());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("array non lu");
        }
    }

    public Types_Ressources(Ressource[] liste) {
        this.liste = liste;
    }
}
