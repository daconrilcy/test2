package com.cc.test.data;

import game.map.Type_Case;
import game.ressources.Ressource;

import java.util.ArrayList;

public class ChargementDonnees {

    private String fileRessources = "C:\\Users\\dacon\\IdeaProjects\\test2\\src\\com\\cc\\test\\data\\ressources.csv" ;
    private String fileTypeCase = "C:\\Users\\dacon\\IdeaProjects\\test2\\src\\com\\cc\\test\\data\\typesCase.csv";
    private CSV csv;


    public Ressource[] getRessources() {


        try {
            DonneFichierCSV donnees;
            Ressource[] ressources;
            int li = 0;
            donnees = csv.readFile(fileRessources);
            ressources = new Ressource[donnees.getNbLigne()];
            for (ArrayList<String> ligne: donnees.getDonnees()){
                Ressource res = new Ressource(){};
                res.setTypeId(li);
                res.setNom(ligne.get(0));
                res.setTaille(Integer.parseInt(ligne.get(1)));
                res.setRangFabric(Integer.parseInt(ligne.get(2)));
                ressources[li] = res;
                li++;
            }
            return ressources;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public Type_Case[] getTypeCase(){
        try {
            DonneFichierCSV donnees;
            donnees = csv.readFile(fileTypeCase);
            Type_Case[] type_case;
            type_case = new Type_Case[donnees.getNbLigne()];
            int n = 0;
            for (ArrayList<String>ligne:donnees.getDonnees()){
                type_case[n] = new Type_Case(ligne.get(0) , ligne.get(1) , n);
                n++;
            }

            return type_case;

        }catch (Exception e){
            System.out.println("Type case non chargé");
            return null;
        }
    }

    public ChargementDonnees(){
        csv = new CSV();
    }
}
