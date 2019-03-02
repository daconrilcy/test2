package com.cc.test;

import game.Game;
import game.batiment.Bat_Factory;
import game.map.Coordonnees;
import game.ressources.Ressource;
import view.View;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Bat_Factory batFactory =  game.getGestionBatiments();
        game.getMap_factory().creerMap(100,100);

        Ressource[] res;
        res = new Ressource[]{game.getTypes_Ressources().getRessource(1)};
        int[] qtRes;
        qtRes = new int[]{1};
        Coordonnees coordonnees;
        coordonnees = new Coordonnees(1,1);

        game.getMap_factory().creerCase(coordonnees,1,res,qtRes,0);

        View view = new View();

    }
}
