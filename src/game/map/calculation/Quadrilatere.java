package game.map.calculation;

public class Quadrilatere {
    TriangleRectangle triangle;
    Rectangle rectangle;
    double surface;
    double angle;
    double sufaceMin, surfaceMax;
    CoordonneesDbl pointA;
    CoordonneesDbl pointB;
    CoordonneesDbl pointC;
    CoordonneesDbl pointD;


    public TriangleRectangle getTriangle() {
        return triangle;
    }

    public void setTriangle(TriangleRectangle triangle) {
        this.triangle = triangle;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getSufaceMin() {
        return sufaceMin;
    }

    public void setSufaceMin(double sufaceMin) {
        this.sufaceMin = sufaceMin;
    }

    public double getSurfaceMax() {
        return surfaceMax;
    }

    public void setSurfaceMax(double surfaceMax) {
        this.surfaceMax = surfaceMax;
    }

    public CoordonneesDbl getPointA() {
        return pointA;
    }

    public void setPointA(CoordonneesDbl pointA) {
        this.pointA = pointA;
    }

    public CoordonneesDbl getPointB() {
        return pointB;
    }

    public void setPointB(CoordonneesDbl pointB) {
        this.pointB = pointB;
    }

    public CoordonneesDbl getPointC() {
        return pointC;
    }

    public void setPointC(CoordonneesDbl pointC) {
        this.pointC = pointC;
    }

    public CoordonneesDbl getPointD() {
        return pointD;
    }

    public void setPointD(CoordonneesDbl pointD) {
        this.pointD = pointD;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Quadrilatere(){
        triangle = new TriangleRectangle();
        rectangle = new Rectangle();
    }

    public Quadrilatere(double angle , double surface){
        triangle = new TriangleRectangle();
        rectangle = new Rectangle();
        setAngle(angle);
        setSurface(surface);
    }



}
