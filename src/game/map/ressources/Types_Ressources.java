package game.map.ressources;

public abstract class Types_Ressources {
    private Ressource[] liste;

    public Ressource[] getListe() {
        return liste;
    }

    public void setListe(Ressource[] liste) {
        this.liste = liste;
    }
    public Ressource getRessource(int index){
        return liste[index];
    }

    public Ressource getRessourceByName(String nomRessource){
        for (int n=0; n < liste.length ; n++){
            if (liste[n].getNom() == nomRessource){
                return liste[n];
            }
        }
        return null;
    }


    public Types_Ressources() {
        String[] nom = {"Arbre" , "Rocher" , "Buche" , "Pierre" , "Planche" , "Brique"};
        int taille = 1;
        int[] rang = {0,0,1,1,2,2};
        int l = nom.length;

        Ressource[] list;

        liste = new Ressource[6];

        for (int n=0; n < l ; n++){
            liste[n] = new Ressource(nom[n] , taille , rang[n]) { };
        }

    }

    public Types_Ressources(Ressource[] liste) {
        this.liste = liste;
    }
}
