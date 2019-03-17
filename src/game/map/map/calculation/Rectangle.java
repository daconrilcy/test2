package game.map.map.calculation;

public class Rectangle {
    private double xG;
    private double yH;
    private double xD;
    private double yB;
    private double longueur;
    private double hauteur;
    private double angleBaseA;
    private double angleBaseB;
    private double angleBaseC;
    private double angleBaseD;
    private double centerX;
    private double centerY;
    private double surface;
    private double diagonale;
    private double cosA;
    private double sinA;

    public double getxG() {
        return xG;
    }

    public void setxG(double xG) {
        this.xG = xG;
    }

    public double getyH() {
        return yH;
    }

    public void setyH(double yH) {
        this.yH = yH;
    }

    public double getxD() {
        return xD;
    }

    public void setxD(double xD) {
        this.xD = xD;
    }

    public double getyB() {
        return yB;
    }

    public void setyB(double yB) {
        this.yB = yB;
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

    public void setAngleBaseA(double angleBaseA) {
        this.angleBaseA = angleBaseA;
        angleBaseB = Math.PI - angleBaseA;
        angleBaseC = Math.PI+ angleBaseA;
        angleBaseD = 2*Math.PI - angleBaseA;
    }

    public double getAngleBaseA() {
        return angleBaseA;
    }


    public double getAngleBaseB() {
        return angleBaseB;
    }

    public double getAngleBaseC() {
        return angleBaseC;
    }

    public double getAngleBaseD() {
        return angleBaseD;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getDiagonale() {
        return diagonale;
    }

    public void setDiagonale(double diagonale) {
        this.diagonale = diagonale;
    }

    public double getCosA() {
        return cosA;
    }

    public double getSinA() {
        return sinA;
    }

    Rectangle(){
        setLongueur(0);
        setHauteur(0);
        setDiagonale(0);
        setCoinHautGauche(0,0);
    }

    Rectangle(double longueur , double hauteur){
        setLongueur(longueur);
        setHauteur(hauteur);
        setSurface(longueur*hauteur);
        calculTailleDiagonaleLH();
        calculAngleBaseLH();
        setCoinHautGauche(0,0);
    }

    public void calculTailleDiagonaleLH(){
        this.diagonale = Math.sqrt(Math.pow(longueur,2)+Math.pow(hauteur,2));
    }

    public void calculAngleBaseLH(){
        if (hauteur !=0 && longueur !=0){
            if (diagonale == 0){
                calculTailleDiagonaleLH();
            }
            cosA = longueur/diagonale;
            sinA = hauteur/diagonale;
            setAngleBaseA(Math.acos(cosA));
        }
    }

    public void setSurfaceHauteur(double surface , double hauteur){
        setSurface(surface);
        setHauteur(hauteur);
        if (hauteur !=0) {
            setLongueur(surface / hauteur);
            calculTailleDiagonaleLH();
            calculAngleBaseLH();
        }
    }

    public void setSurfaceLongueur(double surface , double longueur){
        setSurface(surface);
        setLongueur(longueur);
        if (longueur != 0 ){
            setHauteur(surface/longueur);
            calculTailleDiagonaleLH();
            calculAngleBaseLH();
        }
    }

    public void setCenter(double x, double y){
        double halfLongueur, halfHauteur;
        setCenterX(x);
        setCenterY(y);
        halfLongueur = longueur/2;
        halfHauteur = hauteur/2;
        setxG(x-halfLongueur);
        setxD(x+halfLongueur);
        setyB(y+halfHauteur);
        setyH(y-halfHauteur);

    }
    public void setCoinHautGauche(double x , double y){
        double halfLongueur, halfHauteur;
        halfLongueur = longueur/2;
        halfHauteur = hauteur/2;
        setxG(x);
        setyH(y);
        setyB(y+hauteur);
        setxD(x+longueur);
        setCenterX(x+halfLongueur);
        setCenterY(y+halfHauteur);

    }
    public void setCoinHautDroit(double x , double y){
        double halfLongueur, halfHauteur;
        halfLongueur = longueur/2;
        halfHauteur = hauteur/2;
        setxD(x);
        setyH(y);
        setyB(y+hauteur);
        setxG(x-longueur);
        setCenterX(x-halfLongueur);
        setCenterY(y+halfHauteur);
    }
    public void setCoinBasGauche(double x , double y){
        double halfLongueur, halfHauteur;
        halfLongueur = longueur/2;
        halfHauteur = hauteur/2;
        setxG(x);
        setyB(y);
        setyH(y-hauteur);
        setxD(x+longueur);
        setCenterX(x+halfLongueur);
        setCenterY(y-halfHauteur);
    }
    public void setCoinBasDroit(double x , double y){
        double halfLongueur, halfHauteur;
        halfLongueur = longueur/2;
        halfHauteur = hauteur/2;
        setxD(x);
        setyB(y);
        setyH(y-hauteur);
        setxG(x-longueur);
        setCenterX(x-halfLongueur);
        setCenterY(y-halfHauteur);
    }
    public boolean estDanslaSurface(double x, double y){
        if (x >= xG && x<= xD && y <= yB && y >= yH){
            return true;
        } else {
            return false;
        }
    }
}