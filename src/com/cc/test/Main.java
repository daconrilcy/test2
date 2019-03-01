package com.cc.test;

import game.Game;
import game.batiment.Bat_Factory;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Bat_Factory batFactory =  game.getGestionBatiments();
        batFactory.creerCabaneBucheron();
        batFactory.creerCabaneCarriere();
    }
}
