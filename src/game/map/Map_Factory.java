package game.map;

import game.ressources.Ressource;

public class Map_Factory {
    static Type_Case type_case;
    static Map map;
    static int indexCase;

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
            map.setNomMap("Carte de base");
            System.out.println("Map "+map.getNomMap() + " de taille : "+ map.getTailleCarte() + " créee");
        } else{
            System.out.println("Map déjà existante");
        }
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
        type_case = new Type_Case();
        indexCase = 0;
    }
}
