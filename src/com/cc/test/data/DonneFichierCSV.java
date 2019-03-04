package com.cc.test.data;

import java.util.ArrayList;

public class DonneFichierCSV {
    private int nbColonne;
    private int nbLigne;
    private ArrayList<ArrayList<String>> donnees;
    private String[] entetes;

    public int getNbColonne() {
        return nbColonne;
    }

    public void setNbColonne(int nbColonne) {
        this.nbColonne = nbColonne;
    }

    public int getNbLigne() {
        return nbLigne;
    }

    public void setNbLigne(int nbLigne) {
        this.nbLigne = nbLigne;
    }

    public ArrayList<ArrayList<String>> getDonnees() {
        return donnees;
    }

    public void setDonnees(ArrayList<ArrayList<String>> donnees) {
        this.donnees = donnees;
    }

    public String[] getEntetes() {
        return entetes;
    }

    public void setEntetes(String[] entetes) {
        this.entetes = entetes;
    }

    public DonneFichierCSV() {
    }

    public DonneFichierCSV(int nbColonne, int nbLigne, ArrayList<ArrayList<String>> donnees, String[] entetes) {
        this.nbColonne = nbColonne;
        this.nbLigne = nbLigne;
        this.donnees = donnees;
        this.entetes = entetes;
    }
}
