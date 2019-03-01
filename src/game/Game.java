package game;

import game.batiment.Bat_Factory;
import game.ressources.Types_Ressources;

public class Game implements game_factory{
    private Types_Ressources types_Ressources;
    private Bat_Factory GestionBatiments;

    public Types_Ressources getTypes_Ressources() {
        return types_Ressources;
    }

    public Bat_Factory getGestionBatiments() {
        return GestionBatiments;
    }

    @Override
    public void creerTypeRessource() {
        this.types_Ressources = new Types_Ressources(){};
    }

    @Override
    public void creerBatimentFactory() {
        GestionBatiments = new Bat_Factory(types_Ressources);
    }

    public Game() {
        creerTypeRessource();
        creerBatimentFactory();

    }
}
