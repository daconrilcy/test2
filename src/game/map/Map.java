package game.map;

import game.stock.Stock_Abstract;

public class Map {
    private int LongueurMap;
    private int largeurMap;
    private int tailleCarte;
    private String nomMap;
    private Stock_Abstract stockMap;
    private Case_Map[] cases;

    public int getLongueurMap() {
        return LongueurMap;
    }

    public void setLongueurMap(int longueurMap) {
        LongueurMap = longueurMap;
    }

    public int getLargeurMap() {
        return largeurMap;
    }

    public void setLargeurMap(int largeurMap) {
        this.largeurMap = largeurMap;
    }

    public String getNomMap() {
        return nomMap;
    }

    public void setNomMap(String nomMap) {
        this.nomMap = nomMap;
    }

    public Stock_Abstract getStockMap() {
        return stockMap;
    }

    public void setStockMap(Stock_Abstract stockMap) {
        this.stockMap = stockMap;
    }

    public int getTailleCarte() {
        return tailleCarte;
    }

    public void setTailleCarte(int tailleCarte) {
        this.tailleCarte = tailleCarte;
    }

    public Case_Map[] getCases() {
        return cases;
    }

    public void setCases(Case_Map[] cases) {
        this.cases = cases;
    }

    public void ajouterCase(Case_Map caseUniq , int index){
        if (index >= 0 && index < cases.length){
            cases[index] = caseUniq;
        }
    }
}
