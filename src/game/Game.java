package game;

import game.batiment.Bat_Factory;
import game.map.Map_Factory;
import game.ressources.Types_Ressources;

public class Game implements game_factory{
    private Types_Ressources types_Ressources;
    private Bat_Factory GestionBatiments;
    private Map_Factory map_factory;

    public Types_Ressources getTypes_Ressources() {
        return types_Ressources;
    }

    public Bat_Factory getGestionBatiments() {
        return GestionBatiments;
    }


    public Map_Factory getMap_factory() {
        return map_factory;
    }

    @Override
    public void creerTypeRessource() {
        this.types_Ressources = new Types_Ressources(){};
    }

    @Override
    public void creerBatimentFactory() {
        GestionBatiments = new Bat_Factory(types_Ressources);
    }

    @Override
    public void creerMapFactory() {
        map_factory = new Map_Factory();
    }

    public Game() {
        creerTypeRessource();
        creerBatimentFactory();
        creerMapFactory();

    }
}
