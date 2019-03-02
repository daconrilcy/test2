package game.ressources;

import game.stock.Stock_Abstract;

public interface Ressources_Interface {

    void ajouterArbre();
    void ajouterRocher();
    void ajouterMines();
    void creerRessourceParNom(String nomRessource, Stock_Abstract stock);
    void creerRessourceParIndex(int indexRessource, Stock_Abstract stock);
    void supprimerRessourceParNom(String nomRessource, Stock_Abstract stock);
    void supprimerRessourceParIndex(int indexRessource, Stock_Abstract stock);
    void transformerRessources(Ressource[] ressourcesDepart, Ressource[] ressourcesArrivee , Stock_Abstract[] stocksDepart , Stock_Abstract[] stocksArrivee);

}
