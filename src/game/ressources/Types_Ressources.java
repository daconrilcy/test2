package game.ressources;

 public class Types_Ressources extends Ressource{
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
        listeParDefautl();
    }

    private void listeParDefautl(){
        String[] nom = {"Rien","Arbre" , "Rocher" , "Buche" , "Pierre" , "Planche" , "Brique"};
        int taille = 1;
        int[] rang = {0,0,0,1,1,2,2};
        int l = nom.length;


        Ressource[] list;

        list = new Ressource[l];

        for (int n=0; n < l ; n++){
            list[n] = new Ressource(nom[n] , taille , rang[n]) { };
        }

        for (int n = 0 ; n < l ; n++){
            list[n].setTypeId(n);
        }

        setListe(list);
    }

    public Types_Ressources(Ressource[] liste) {
        this.liste = liste;
    }
}
