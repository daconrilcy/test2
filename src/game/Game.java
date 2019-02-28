package game;

import game.map.batiment.Bat_Factory;
import game.map.ressources.Types_Ressources;

public class Game implements game_factory{
    private Types_Ressources types_Ressources;
    private Bat_Factory batiments;
    @Override
    public void creerTypeRessource() {
        this.types_Ressources = new Types_Ressources(){};
    }

    @Override
    public void creerBatimentFactory() {
        batiments = new Bat_Factory(types_Ressources);
    }

    public Game() {
        creerTypeRessource();
        creerBatimentFactory();

    }
}
