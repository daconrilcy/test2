package game.map.calculation;


/********

           A
           *
          **
        ** *
       *   *
     **    *
    *      *
 B ********* C

**********/
public class TriangleRectangle {
    private CoordonneesDbl A;
    private CoordonneesDbl B;
    private CoordonneesDbl C;
    private CoordonneesDbl Center;
    private double longueur;
    private double hauteur;
    private double hypothenuse;
    private double surface;
    private double angleA;
    private double angleB;
    private double angleC;
    private double rotation;
    private boolean isSymetrieH;
    private boolean isSymetrieV;

    public CoordonneesDbl getA() {
        return A;
    }


    public CoordonneesDbl getB() {
        return B;
    }


    public CoordonneesDbl getC() {
        return C;
    }

    public void setA(CoordonneesDbl a) {
        A = a;
    }

    public void setB(CoordonneesDbl b) {
        B = b;
    }

    public void setC(CoordonneesDbl c) {
        C = c;
    }

    public void setCenter(CoordonneesDbl center) {
        Center = center;
    }

    public CoordonneesDbl getCenter() {
        return Center;
    }


    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getHypothenuse() {
        return hypothenuse;
    }

    public void setHypothenuse(double hypothenuse) {
        this.hypothenuse = hypothenuse;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getAngleA() {
        return angleA;
    }

    public void setAngleA(double angleA) {
        this.angleA = angleA;
    }

    public double getAngleB() {
        return angleB;
    }
    public double getAngleBenDeg(){
        return angleB/Math.PI*180;
    }

    public void setAngleB(double angleB) {
        this.angleB = angleB;
    }

    public double getAngleC() {
        return angleC;
    }

    public void setAngleC(double angleC) {
        this.angleC = angleC;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public boolean isSymetrieH() {
        return isSymetrieH;
    }

    public void setSymetrieH(boolean symetrieH) {
        isSymetrieH = symetrieH;
    }

    public boolean isSymetrieV() {
        return isSymetrieV;
    }

    public void setSymetrieV(boolean symetrieV) {
        isSymetrieV = symetrieV;
    }

    public TriangleRectangle(){
        setLongueur(0);
        setHauteur(0);
        setHypothenuse(0);
        creerCoordonneeDefaultHL();
        setAngleA(0);
        setAngleB(0);
        setAngleC(Math.PI/2);
        setRotation(0);
        setSymetrieH(false);
        setSymetrieV(false);

    }
    public TriangleRectangle(double longueur, double hauteur){
        setLongueur(longueur);
        setHauteur(hauteur);
        setRotation(0);
        setSymetrieH(false);
        setSymetrieV(false);
        calculHypothenuseHL();
        defineAngleHL();
        creerCoordonneeDefaultHL();
    }

    public void setTriangleSurfaceLongueur(double surface, double longueur){
        if (longueur != 0){
            setLongueur(longueur);
            setSurface(surface);
            setHauteur(surface/longueur*2);
            calculHypothenuseHL();
            defineAngleHL();
            setCoordonneeDefaultHL();
        }
    }
    public void setTriangleSurfaceHauteur(double surface, double hauteur){
        if (hauteur != 0){
            setHauteur(hauteur);
            setSurface(surface);
            setLongueur(surface/hauteur*2);
            calculHypothenuseHL();
            defineAngleHL();
            setCoordonneeDefaultHL();
        }
    }
    public void setTriangleSurfaceAngleB(double surface , double angleB){
        setSurface(surface);
        redefineAngleB(angleB);
        double sinB = Math.sin(angleB);
        double cosB = Math.cos(angleB);
        if (cosB != 0 ){
          longueur = Math.sqrt(Math.abs(2*surface*cosB/sinB));
          hypothenuse = longueur/cosB;
          hauteur = hypothenuse*sinB;
        }
        angleA = Math.PI-angleB-angleC;
        setCoordonneeDefaultHL();
    }

    public void calculSurfaceHL(){
        surface = longueur*hauteur/2;
    }

    public void defineAngleHL(){
        double a;
        double sinB, cosB;
        calculHypothenuseHL();
        if (hypothenuse !=0){
            cosB = longueur/hypothenuse;
            angleB = Math.acos(cosB);
            angleA = Math.PI-angleB-angleC;
        }
    }

    public void calculHypothenuseHL(){
        hypothenuse = Math.sqrt(Math.pow(longueur,2)+ Math.pow (hauteur, 2));
    }

    public void creerCoordonneeDefaultHL(){
        A = new CoordonneesDbl(longueur,0);
        B = new CoordonneesDbl(0,hauteur);
        C = new CoordonneesDbl(longueur,hauteur);
        Center = new CoordonneesDbl(longueur/2,hauteur/2);
    }

    public void setCoordonneeDefaultHL(){
        A.x = longueur;
        A.y = 0;
        B.x = 0;
        B.y = hauteur;
        C.x = longueur;
        C.y = hauteur;
        Center.x = longueur/2;
        Center.y = hauteur/2;
    }

    public void transformerH(){
        A.transformH(Center.x);
        B.transformH(Center.x);
        C.transformH(Center.x);
        if (isSymetrieH) {
            isSymetrieH = false;
        }else {
            isSymetrieH = true;
        }
    }

    public void transformerV(){
        A.transformV(Center.y);
        B.transformV(Center.y);
        C.transformV(Center.y);
        if (isSymetrieV){
            isSymetrieV = false;
        }else{
            isSymetrieV = true;
        }
    }

    public void move(double x, double y){
        A.move(x,y);
        B.move(x,y);
        C.move(x,y);
        Center.move(x,y);
    }
    public void redefineAngleB(double angleB){
        double anglT;
        anglT = angleB;
        if (angleB > 2* Math.PI){
            while (anglT <= 2* Math.PI){
                anglT -= 2*Math.PI;
            }
        }
        if (anglT >= 0 && anglT < Math.PI/2){
            setAngleB(anglT);
        }
        if (anglT > Math.PI/2 && anglT <= Math.PI){
            anglT = Math.PI - anglT;
            transformerH();
        }
        if (anglT > Math.PI && anglT <= 3/2*Math.PI){
            anglT = anglT-Math.PI;
            transformerH();
            transformerV();
        }
        if (anglT > 3/2 * Math.PI && anglT <= 2 * Math.PI){
            anglT = 2*Math.PI-anglT;
            transformerV();
        }
        setAngleB(anglT);
    }
}
