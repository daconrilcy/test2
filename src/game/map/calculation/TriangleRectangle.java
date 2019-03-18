package game.map.calculation;

/********

 B*********C
   **      *
     *     *
      **   *
        *  *
         ***
           *
           A
**********/
public class TriangleRectangle {
    private CoordonneesDbl A;
    private CoordonneesDbl B;
    private CoordonneesDbl C;
    private CoordonneesDbl center;
    private double longueur;
    private double hauteur;
    private double hypothenuse;
    private double surface;
    private Angle angleA;
    private Angle angleB;
    private Angle angleBInitial;
    private Angle angleC;
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
        center = center;
    }
    public void setCenterSelonABCDefault(){
        double x,y;
        x = C.x-B.x;
        y = C.y-A.y;
        center = new CoordonneesDbl(x,y);
    }

    public CoordonneesDbl getCenter() {
        return center;
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

    public Angle getAngleA() {
        return angleA;
    }

    public void setAngleA(double angleEnRad) {
        this.angleA = new  Angle(angleEnRad);
    }

    public Angle getAngleB() {
        return angleB;
    }
    public double getAngleBenDeg(){
        return angleB.valDeg();
    }

    public void setAngleB(double angleEnRad) {
        this.angleBInitial = new Angle(angleEnRad);
        this.angleB = new Angle(angleBInitial.anglePI2());
        this.isSymetrieV = angleBInitial.AnglePI2isTransV();
        this.isSymetrieH = angleBInitial.AnglePI2isTransH();
    }
    public void setAngleB(Angle angle) {
        this.angleBInitial = angle;
        this.angleB = new Angle(angle.anglePI2());
        this.isSymetrieV = angle.AnglePI2isTransV();
        this.isSymetrieH = angle.AnglePI2isTransH();
    }

    public Angle getAngleC() {
        return angleC;
    }

    public void setAngleC() {
        this.angleC = new Angle(Math.PI/2);
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
        setAngleC();
        setRotation(0);
        setSymetrieH(false);
        setSymetrieV(false);
    }
    public TriangleRectangle(double longueur, double hauteur){
        setAngleC();
        setLongueur(longueur);
        setHauteur(hauteur);
        setRotation(0);
        setSymetrieH(false);
        setSymetrieV(false);
        calculHypothenuseHL();
        defineAngleHL();
        creerCoordonneeDefaultHL();
    }
    public TriangleRectangle(double surface , Angle angleEnRad){
        setAngleC();
        setAngleB(angleEnRad);
        setAngleA(Math.PI-angleC.valRad()-angleB.valRad());
        setSurface(surface);
        if (angleB.sin()!=0&& angleB.cos() != 0){
            longueur = Math.sqrt(Math.abs(2*surface*angleB.cos()/angleEnRad.sin()));
            hauteur = Math.abs(longueur/angleB.cos()*angleB.sin());
            calculHypothenuseHL();
            setCoordonneeDefaultHL();
        }
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
    public void setTriangleSurfaceValAngleB(double surface , double angleEnRad){
        setSurface(surface);
        setAngleB(angleEnRad);

        if (angleB.cos() != 0 ){
          longueur = Math.sqrt(Math.abs(2*surface*angleB.cos()/angleB.sin()));
          calculHypothenuseCosLongueur();
          hauteur = Math.abs(hypothenuse*angleB.sin());
        }else{
            setLongueur(0);
            setHauteur(surface);
            setSurface(0);
        }
        angleA = new Angle(Math.PI-angleB.valRad()-angleC.valRad());
        setCoordonneeDefaultHL();
    }
    public void setTriangleLongueurAngle(double longueur , double angleEnRad){
        setAngleB(angleEnRad);
        setAngleC();
        setRotation(0);
        if (angleB.cos() != 0){
            setLongueur(longueur);
            setHauteur(Math.abs(longueur/angleB.cos()*angleB.sin()));
            setAngleA(Math.PI-angleB.valRad()-angleC.valRad());
            calculHypothenuseHL();
            calculSurfaceHL();
            setCoordonneeDefaultHL();
        }
    }
    public void setTriangleHauteurAngle(double hauteur , double angleEnRad) {
        setAngleB(angleEnRad);
        setAngleC();
        setRotation(0);
        if (angleB.sin() != 0) {
            setHauteur(Math.abs(hauteur));
            setLongueur(Math.abs(hauteur / angleB.sin() * angleB.cos()));
            setAngleA(Math.PI - angleB.valRad() - angleC.valRad());
            calculHypothenuseHL();
            calculSurfaceHL();
            setCoordonneeDefaultHL();
        }
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
            setAngleC();
            setAngleB(Math.acos(cosB));
            setAngleA(Math.PI-angleB.valRad()-angleC.valRad());
        }
    }

    public void calculHypothenuseHL(){
        hypothenuse = Math.sqrt(Math.pow(longueur,2)+ Math.pow (hauteur, 2));
    }
    private void calculHypothenuseCosLongueur(){
        if (angleB.cos() !=0) {
            hypothenuse = Math.abs(longueur / angleB.cos());
        }else{
            hypothenuse = 0;
        }
    }
    private void calculHypothenuseSinHauteur(){
        if (angleB.sin() != 0) {
            hypothenuse = Math.abs(hauteur / angleB.sin());
        }else {
            hypothenuse = 0;
        }
    }

    public void creerCoordonneeDefaultHL(){
        A = new CoordonneesDbl(longueur,0);
        B = new CoordonneesDbl(0,hauteur);
        C = new CoordonneesDbl(longueur,hauteur);
        setCenterSelonABCDefault();
    }

    public void setCoordonneeDefaultHL(){
        A.x = longueur;
        A.y = hauteur;
        B.x = 0;
        B.y = 0;
        C.x = longueur;
        C.y = 0;
        setCenterSelonABCDefault();
    }

    public void transformerH(){
        A.transformH(center.x);
        B.transformH(center.x);
        C.transformH(center.x);
        if (isSymetrieH) {
            isSymetrieH = false;
        }else {
            isSymetrieH = true;
        }
        transfoHAngle();
    }
    private void transfoHAngle(){
        double pi = Math.PI;
        angleB = new Angle(pi-angleB.valRad());
        angleC = new Angle(pi-angleC.valRad());
        angleA = new Angle(pi-angleA.valRad());
    }

    public void transformerV(){
        A.transformV(center.y);
        B.transformV(center.y);
        C.transformV(center.y);
        isSymetrieV = !isSymetrieV;
        transfoVAngle();
    }
    private void transfoVAngle(){
        double pi2 = 2*Math.PI;
        double anglB = pi2-angleB.valRad();
        double anglC = pi2-angleC.valRad();
        double anglA = pi2-angleA.valRad();

        angleB = new Angle(anglB);
        angleC = new Angle(anglC);
        angleA = new Angle(anglA);
    }

    public void transformerHV(){
        transformerH();
        transformerV();
    }
    public void annulerTransfoHV(){
        if (isSymetrieH){
            transformerH();
        }
        if (isSymetrieV){
            transformerV();
        }
    }

    public void move(double x, double y){
        A.move(x,y);
        B.move(x,y);
        C.move(x,y);
        center.move(x,y);
    }

    public void moveCenterTo(double x , double y){
        double difx,dify;
        difx = x - center.x;
        dify = y - center.y;
        move(difx , dify);
    }
    public void moveBTo(double x , double y){
        double difx,dify;
        difx = x - B.x;
        dify = y - B.y;
        move(difx , dify);
    }
    public void moveBTo(CoordonneesDbl point){
        double difx,dify;
        difx = point.x - B.x;
        dify = point.y - B.y;
        move(difx , dify);
    }

    public void moveATo(double x, double y){
        double difx,dify;
        difx = x - A.x;
        dify = y - A.y;
        move(difx , dify);
    }
    public void moveCTo(double x , double y){
        double difx,dify;
        difx = x - C.x;
        dify = y - C.y;
        move(difx , dify);
    }
    public void moveCTo(CoordonneesDbl point){
        double difx,dify;
        difx = point.x - C.x;
        dify = point.y - C.y;
        move(difx , dify);
    }
}
