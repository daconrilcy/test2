package map;

abstract class Batiment_1x1 extends Batiment{

    public Batiment_1x1(){
       super();
       int i = getIndex() + 1;
       setIndex(i);
       setLargeur(1);
       setLongueur(1);
       setMatConstruct(new int[]{1});
       setNbMatConstruct(1);
       setType("Cabane de bucheron");
       System.out.println(getType() + " est construit");
    }

}
