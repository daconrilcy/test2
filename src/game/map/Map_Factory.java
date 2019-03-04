package game.map;

import com.cc.test.data.ChargementDonnees;
import game.ressources.Ressource;
import game.ressources.Types_Ressources;

import java.util.ArrayList;

public class Map_Factory {
    static Type_Case[] type_case;
    static Map map;
    static int indexCase;
    static int[] listeRessourceBaseCarte = {0,1,4,6,7};
    static ChargementDonnees chargementDonnees;
    private Ressource[] listeTypeRessource;
    private ArrayList<Ressource> listeRessourceDebase;
    private Case_Map_Factory_Abstract case_map_factory;

    public void creerMap(int longueur , int largeur){
        if (map == null){
            int t = largeur * longueur;
            Case_Map[] cases;
            cases = new Case_Map[t];
            map = new Map();
            map.setLargeurMap(largeur);
            map.setLongueurMap(longueur);
            map.setTailleCarte(t);
            map.setCases(cases);
            map.setNomMap("Carte "+ longueur+"X"+largeur);
            System.out.println(map.getNomMap() + " créee");
        } else{
            System.out.println("Map déjà existante");
        }
    }

    public void creerMapdeBaseAvecNom(int longueur , int largeur , String nom){
        creerMap(longueur ,largeur);
        map.setNomMap(nom);
        System.out.println("Nom de la carte : " + nom);
    }

    public void CreerMapAleatoire(int longueur , int largeur , double proportionMer){
        creerMap(longueur, largeur);
        map.setCases(case_map_factory.creerCaseViergeSelonDimension(largeur , longueur));
        int coupureMerAngle = (int)(Math.random()*360);

        for (int n = 0 ; n < map.getTailleCarte() ; n++){
            Ressource res = obtenirRessourceBaseAleatoire();

        }
    }

    private ArrayList<Ressource> listeResDeBase(){
        ArrayList<Ressource> resdeBase = new ArrayList<>();
        for (Ressource res: listeTypeRessource) {
            if (res.getRangFabric() == 0) {
                resdeBase.add(res);
            }
        }
        return resdeBase;
    }

    private Ressource obtenirRessourceBaseAleatoire(){
        int champ = listeRessourceDebase.size();
        int indexRes = (int)(Math.random() * champ);

        return listeRessourceDebase.get(indexRes);
    }

    public void creerCase(Coordonnees coordonnees , int indexType , Ressource[] ressources , int[] quantiteRessources , long altitude){
        Case_Map caseTemp;
        if (map != null){
            caseTemp = new Case_Map();
            caseTemp.setCoordonnees(coordonnees);
            caseTemp.setIndex(indexCase);
            caseTemp.setAltitude(altitude);
            caseTemp.setRessource(ressources);
            caseTemp.setQuantiteRessource(quantiteRessources);
            caseTemp.setType(indexType);
            map.ajouterCase(caseTemp ,indexCase);
            indexCase++;
            System.out.println("Case " + indexCase + " crée sur la carte " + map.getNomMap());
        } else {
            System.out.println("Map non créee => Case non créee");
        }
    }



    public Map_Factory(){
        chargementDonnees = new ChargementDonnees();
        type_case = chargementDonnees.getTypeCase();
        listeTypeRessource = chargementDonnees.getRessources();
        listeRessourceDebase = listeResDeBase();
        case_map_factory = new Case_Map_Factory();
        indexCase = 0;
    }
}
