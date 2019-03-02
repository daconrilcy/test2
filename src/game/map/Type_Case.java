package game.map;

public class Type_Case {
    String[] liste;

    public String[] getListe() {
        return liste;
    }

    public void setListe(String[] liste) {
        this.liste = liste;
    }

    Type_Case () {
        String[] liste = {"mer", "riviere", "bord de mer", "champs", "Montagne"};
        setListe(liste);
    }
}
