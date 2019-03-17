package game.map.calculation;

public class CoordonneesDbl {
    public double x;
    public double y;

    public CoordonneesDbl(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void move(double x, double y){
        this.x += x;
        this.y += y;
    }

    public void transform(double centerX, double centerY){
        this.x = 2 * centerX-this.x;
        this.y = 2 * centerY-this.y;
    }
    public void transformH(double centerX){
        this.x = 2 * centerX-this.x;
    }
    public void transformV(double centerY){
        this.y = 2 * centerY-this.y;
    }
}
