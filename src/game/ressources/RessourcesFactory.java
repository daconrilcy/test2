package game.ressources;

import game.stock.Stock_Abstract;

public class RessourcesFactory implements Ressources_Interface{

    static Types_Ressources listeRessources;
    static Ressource[] ressources;


    @Override
    public void ajouterArbre() {

    }

    @Override
    public void ajouterRocher() {

    }

    @Override
    public void ajouterMines() {

    }


    @Override
    public void creerRessourceParNom(String nomRessource, Stock_Abstract stock) {

    }

    @Override
    public void creerRessourceParIndex(int indexRessource, Stock_Abstract stock) {

    }

    @Override
    public void supprimerRessourceParNom(String nomRessource, Stock_Abstract stock) {

    }

    @Override
    public void supprimerRessourceParIndex(int indexRessource, Stock_Abstract stock) {

    }

    @Override
    public void transformerRessources(Ressource[] ressourcesDepart, Ressource[] ressourcesArrivee, Stock_Abstract[] stocksDepart, Stock_Abstract[] stocksArrivee) {

    }
}
