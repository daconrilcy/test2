package game.stock;


import game.ressources.Types_Ressources;

public abstract class Stock_Factory implements Stock_Interface {
    private Stock_Abstract stock;
    private Types_Ressources listeTypeRessource;
    private int nTypeRessources;

    public Stock_Factory(Types_Ressources listeTypeRessource) {
        setListeTypeRessource(listeTypeRessource);
        setnTypeRessources(listeTypeRessource.getListe().length);
        setStock(new Stock_Abstract(listeTypeRessource) {
        });
    }

    public Stock_Abstract getStock() {
        return stock;
    }

    public void setStock(Stock_Abstract stock) {
        this.stock = stock;
    }

    @Override
    public void ajouterNouvelArticleEnStockParIndexType(int indexType) {
        if (indexType > 0 && indexType < nTypeRessources) {
            int nA = stock.getNbArticles();
            if (nA == 0) {
                int[] article = {indexType};
                int[] qte = {0};
                stock.setIndexRessources(article);
                stock.setQuantites(qte);
            } else {

            }
        }
    }

    @Override
    public void ajouterQteEnStock() {

    }

    @Override
    public void retirerQteEnStock() {

    }

    public Types_Ressources getListeTypeRessource() {
        return listeTypeRessource;
    }

    public void setListeTypeRessource(Types_Ressources listeTypeRessource) {
        this.listeTypeRessource = listeTypeRessource;
    }

    public int getnTypeRessources() {
        return nTypeRessources;
    }

    public void setnTypeRessources(int nTypeRessources) {
        this.nTypeRessources = nTypeRessources;
    }
}
