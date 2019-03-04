package view;

import game.Game;

public class Model {

    private Game game;

    public Model(Game game){
        this.game = game;
    }

    public void creerPetiteMapAleatoire(){
        game.getMap_factory().creerMap(50,50);
    }
    public void creerMoyenneMapAleatoire(){
        game.getMap_factory().creerMap(100,100);
    }

    public void creerGrandeMapAleatoire(){
        game.getMap_factory().creerMap(200,200);
    }

}
