package com.cc.test.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CSV {

    public  DonneFichierCSV readFile(String chemin) throws Exception {
        int n = 0;
        int nbColonne =0;
        int nbLigne = 0;
        BufferedReader br = new BufferedReader(new FileReader(chemin));
        String ligne;
        ArrayList<ArrayList<String>> fileArray = new ArrayList<>();
        String[] entete = {};
        while ((ligne = br.readLine()) != null) {
            if (n == 0) {
                entete = ligne.split(";");
                nbColonne = entete.length;
                System.out.println("nb Colonne" + nbColonne);
                n++;
            } else {
                // Retourner la ligne dans un tableau
                ArrayList<String> datas = new ArrayList<>(Arrays.asList(ligne.split(";")));
                fileArray.add(datas);

                // Afficher le contenu du tableau
                for (String val : datas) {
                    System.out.println(val);
                }
                n++;
            }
        }
        nbLigne = n-1;
        System.out.println("-----");
        System.out.println("Nb ligne : " + nbLigne);
        br.close();
        return new DonneFichierCSV(nbColonne , nbLigne, fileArray, entete);
    }
}
