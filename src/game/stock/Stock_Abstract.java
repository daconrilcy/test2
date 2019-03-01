package game.stock;


import game.ressources.Types_Ressources;

public abstract class Stock_Abstract {
    private int[] indexRessources;
    private int[] quantites;
    private Types_Ressources listeTypeRessources;
    private int nbArticles;


    public int[] getIndexRessources() {
        return indexRessources;
    }

    public void setIndexRessources(int[] indexRessources) {
        if (indexRessources.length >= 0 && indexRessources.length < listeTypeRessources.getListe().length)
        this.indexRessources = indexRessources;
        setNbArticles(indexRessources.length);
    }

    public int[] getQuantites() {
        return quantites;
    }

    public void setQuantites(int[] quantites) {
        this.quantites = quantites;
    }

    public Types_Ressources getListeTypeRessources() {
        return listeTypeRessources;
    }

    public void setListeTypeRessources(Types_Ressources listeTypeRessources) {
        this.listeTypeRessources = listeTypeRessources;
    }

    public int getNbArticles() {
        return nbArticles;
    }

    public void setNbArticles(int nbArticles) {
        this.nbArticles = nbArticles;
    }

    public Stock_Abstract(Types_Ressources listeTypeRessource) {
        setListeTypeRessources(listeTypeRessource);
        setNbArticles(0);
    }
}
