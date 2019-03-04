package game;

import game.batiment.Bat_Factory;
import game.map.Map_Factory;
import game.ressources.Types_Ressources;
import view.View_Factory;

public class Game implements game_factory{
    private Types_Ressources types_Ressources;
    private Bat_Factory GestionBatiments;
    private Map_Factory map_factory;
    private View_Factory view_factory;

    public Types_Ressources getTypes_Ressources() {
        return types_Ressources;
    }

    public Bat_Factory getGestionBatiments() {
        return GestionBatiments;
    }


    public Map_Factory getMap_factory() {
        return map_factory;
    }

    public View_Factory getView_factory() {
        return view_factory;
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

    @Override
    public void creerViewFactory() {
        view_factory = new View_Factory(this);
    }

    public Game() {
        creerTypeRessource();
        creerBatimentFactory();
        creerMapFactory();
        creerViewFactory();
    }
}
