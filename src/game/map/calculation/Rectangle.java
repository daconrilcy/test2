package game.map.calculation;

/***************

 A ---------D
 |          |
 |          |
 |          |
 B----------C


****************/

public class Rectangle {
    private CoordonneesDbl A;
    private CoordonneesDbl B;
    private CoordonneesDbl C;
    private CoordonneesDbl D;
    private CoordonneesDbl center;
    private double longueur;
    private double hauteur;
    private double diagonale;
    private Angle angleBase;
    private double surface;

    public CoordonneesDbl getA() {
        return A;
    }

    private void setA(CoordonneesDbl a) {
        A = a;
    }
    private void setA(double x, double y){
        A = setCoordonneeXY(x,y);
    }

    public CoordonneesDbl getB() {
        return B;
    }

    private void setB(CoordonneesDbl b) {
        B = b;
    }

    private void setB(double x, double y){
        B = setCoordonneeXY(x,y);
    }

    public CoordonneesDbl getC() {
        return C;
    }

    private void setC(CoordonneesDbl c) {
        C = c;
    }
    private void setC(double x, double y){
        C = setCoordonneeXY(x,y);
    }

    public CoordonneesDbl getD() {
        return D;
    }

    private void setD(CoordonneesDbl d) {
        D = d;
    }
    private void setD(double x, double y){
        D = setCoordonneeXY(x,y);
    }

    public CoordonneesDbl getCenter() {
        return center;
    }

    private void setCenter(CoordonneesDbl center) {
        this.center = center;
    }

    private void setCenter(double x, double y){
        center = setCoordonneeXY(x,y);
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

    public double getDiagonale() {
        return diagonale;
    }

    private void setDiagonale(double diagonale) {
        this.diagonale = diagonale;
    }

    public void setDiagonale(){
        diagonale = Math.sqrt(Math.pow(longueur,2)+Math.pow(hauteur,2));
    }

    public Angle getAngleBase() {
        return angleBase;
    }

    public void setAngleBase(Angle angleBase) {
        this.angleBase = angleBase;
    }
    private void setAngleBase(){
        double sina,cosa,angl,anglP;
        if (diagonale == 0){
            setDiagonale();
        }
        if (longueur !=0){
            cosa = diagonale/longueur;
            angl = Math.acos(cosa);
        }else if (hauteur !=0){
            sina = diagonale/hauteur;
            angl = Math.asin(sina);
        }else {
            angl = 0;
        }
        anglP = new Angle(angl).anglePI2();
        setAngleBase(new Angle(anglP));
    }

    private CoordonneesDbl setCoordonneeXY(double x, double y){
        return new CoordonneesDbl(x,y);
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public Rectangle(){
        setLongueur(0);
        setHauteur(0);
        setDiagonale(0);
        setAngleBase(new Angle(0));
        setABCDCenterDefault();
        setSurface(0);
    }

    public Rectangle(double longueur , double hauteur){
        setLongueur(longueur);
        setHauteur(hauteur);
        setSurface(longueur*hauteur);
        setDiagonale();
        setABCDCenterDefault();
        setAngleBase();
    }

    private void setABCDCenterDefault(){
        setA(0,0);
        setB(0,hauteur);
        setC(longueur,hauteur);
        setD(longueur,0);
        setCenterFonctionABCD();
    }
    private void setCenterFonctionABCD(){
        double x,y;
        x = C.x - A.x;
        y = B.y - A.y;
        setCenter(x,y);
    }

    public void move(double x, double y){
        center.x += x;
        center.y += y;
        A.x +=x;
        A.y +=y;
        B.x +=x;
        B.y +=y;
        C.x +=x;
        C.y +=y;
        D.x +=x;
        D.y +=y;
    }
    public void moveAto(double x, double y){
        double difx,difY;
        difx = x-A.x;
        difY = y-A.y;
        move(difx,difY);
    }
    public void moveAto(CoordonneesDbl pointCible){
        double difx,difY;
        difx = pointCible.x-A.x;
        difY = pointCible.y-A.y;
        move(difx,difY);
    }
    public void moveBto(double x, double y){
        double difx,difY;
        difx = x-B.x;
        difY = y-B.y;
        move(difx,difY);
    }
    public void moveBto(CoordonneesDbl pointCible){
        double difx,difY;
        difx = pointCible.x-B.x;
        difY = pointCible.y-B.y;
        move(difx,difY);
    }
    public void moveCto(double x, double y){
        double difx,difY;
        difx = x-C.x;
        difY = y-C.y;
        move(difx,difY);
    }
    public void moveCto(CoordonneesDbl pointCible){
        double difx,difY;
        difx = pointCible.x-C.x;
        difY = pointCible.y-C.y;
        move(difx,difY);
    }
    public void moveDto(double x, double y){
        double difx,difY;
        difx = x-D.x;
        difY = y-D.y;
        move(difx,difY);
    }
    public void moveDto(CoordonneesDbl pointCible){
        double difx,difY;
        difx = pointCible.x-D.x;
        difY = pointCible.y-D.y;
        move(difx,difY);
    }
    public void moveCenterTo(double x, double y){
        double difx,difY;
        difx = x-center.x;
        difY = y-center.y;
        move(difx,difY);
    }
    public void moveCenterTo(CoordonneesDbl pointCible){
        double difx,difY;
        difx = pointCible.x-center.x;
        difY = pointCible.y-center.y;
        move(difx,difY);
    }
}