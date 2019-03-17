package game.map.calculation;

import javax.security.auth.login.AccountNotFoundException;

/****************
 *
 *           --E
 *       ---   |
 *    ---      |
 * A-----------D
 * |           |
 * |           |
 * |           |
 * |           |
 * B-----------C
 *
 *
 *
 *
 */



public class Quadrilatere {
    private TriangleRectangle triangle;
    private Rectangle rectangle;
    private Rectangle conteneur;
    private double surface;
    private Angle angle;
    private double sufaceMin, surfaceMax;
    private boolean isRectangleNull;
    private boolean isTriangleNull;
    private CoordonneesDbl A;
    private CoordonneesDbl B;
    private CoordonneesDbl C;
    private CoordonneesDbl D;
    private CoordonneesDbl E;
    private CoordonneesDbl center;
    private int quadrantAngle;
    private double BC;
    private double surfRect;
    private double surfTriangle;
    private double surfMini, surfMaxi;

    public Quadrilatere(){
        triangle = new TriangleRectangle();
        rectangle = new Rectangle();
        conteneur = new Rectangle();
        surface = 0;
        angle = new Angle();
        sufaceMin = 0;
        surfaceMax = 0;
        isRectangleNull = true;
        isTriangleNull = true;
        quadrantAngle = 0;
        A = new CoordonneesDbl(0,0);
        B = new CoordonneesDbl(0,0);
        C = new CoordonneesDbl(0,0);
        D = new CoordonneesDbl(0,0);
        E = new CoordonneesDbl(0,0);
        center = new CoordonneesDbl(0,0);
        BC = 0;
    }

    public void setRectangle(Rectangle rectangle){
        this.rectangle = rectangle;
        rectangle.moveCenterTo(0,0);
        if (rectangle.getSurface() == 0){
            isRectangleNull = true;
            surfRect = 0;
        }else{
            isRectangleNull = false;
            surfRect = rectangle.getSurface();
        }
        surface = surfRect+ surfTriangle;
    }
    public void setTriangle(TriangleRectangle triangle){
        this.triangle = triangle;
        triangle.moveCenterTo(0,0);
        if (triangle.getSurface() == 0) {
            this.surfTriangle =0;
            isTriangleNull = true;
        }else{
            isTriangleNull = false;
            surfTriangle = triangle.getSurface();
        }
        this.surface = this.surfRect+this.surfTriangle;
        setAngle(new Angle(triangle.getAngleB().valOrigin()));
    }
    public void setConteneur(Rectangle conteneur){
        this.conteneur = conteneur;
        this.conteneur.moveCenterTo(0,0);
        this.center = new CoordonneesDbl(0,0);
    }

    public void setAngle(Angle angleEnRad){
        this.angle = angleEnRad;
        if (conteneur.getSurface() == 0){
            this.quadrantAngle =0;
        }else{
            this.quadrantAngle = conteneur.getAngleBase().comparaisonAngleQuadran(angleEnRad);
        }
    }

    public Quadrilatere( Rectangle conteneur , Rectangle rectangle , TriangleRectangle triangle ){
        setTriangle(triangle);
        setRectangle(rectangle);
        setConteneur(conteneur);
        setPositionRectangleDansConteneur();
    }

    private void setPositionRectangleDansConteneur(){
        switch (this.quadrantAngle){
            case 0:
                int i = this.angle.switchCasePI();
                switch (i){
                    case 0: case 1: case 4:
                        rectangle.moveDto(conteneur.getD());
                        break;
                    case 2: case 3:
                        rectangle.moveBto(conteneur.getB());
                        break;
                    default:
                        rectangle.moveCenterTo(conteneur.getCenter());
                }
            case 1: case 8: case 2: case3:
                rectangle.moveDto(conteneur.getD());
                break;
            case 4: case 5: case 6: case 7:
                rectangle.moveBto(conteneur.getB());
                break;
            default:
                rectangle.moveCenterTo(conteneur.getCenter());
        }

    }

    private void setPositionTriangleVsRectangle(){
        triangle.annulerTransfoHV();
        switch (quadrantAngle){
            case 0:
                setTriangle(new TriangleRectangle(0,0));
                break;
            case 1: case 8:
                triangle.moveCTo(rectangle.getC());
                break;
            case 2:
                triangle.moveBTo(rectangle.getD());
                break;
            case 3:
                triangle.moveCTo(rectangle.getD());
                break;
            case 4:


        }


    }

    private void setSurfaceMiniSurfaceMaxi(){

    }

}
