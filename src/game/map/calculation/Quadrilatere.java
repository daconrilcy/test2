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
    private boolean isRectangleNull;
    private boolean isTriangleNull;
    private boolean isInverse;
    private CoordonneesDbl A;
    private CoordonneesDbl B;
    private CoordonneesDbl C;
    private CoordonneesDbl D;
    private CoordonneesDbl E;
    private CoordonneesDbl center;
    private int quadrantAngle;
    private boolean isCoteLongueur;
    private double surfRect;
    private double surfTriangle;
    private double surfMini, surfMaxi;
    private String forme;
    static final String[] typeForme = {"triangle","rectangle","quadrilatere","triangleInverse","indetermine"};

    public Quadrilatere(){
        triangle = new TriangleRectangle();
        rectangle = new Rectangle();
        conteneur = new Rectangle();
        surface = 0;
        angle = new Angle();
        surfMaxi = 0;
        surfMini = 0;
        isRectangleNull = true;
        isTriangleNull = true;
        isInverse = false;
        quadrantAngle = 0;
        forme = typeForme[4];
        isCoteLongueur = true;
        A = new CoordonneesDbl(0,0);
        B = new CoordonneesDbl(0,0);
        C = new CoordonneesDbl(0,0);
        D = new CoordonneesDbl(0,0);
        E = new CoordonneesDbl(0,0);
        center = new CoordonneesDbl(0,0);
    }
    public Quadrilatere(Rectangle conteneur){
        setConteneur(conteneur);
        triangle = new TriangleRectangle();
        rectangle = new Rectangle();
        surface = 0;
        angle = new Angle();
        surfMaxi = 0;
        surfMini = 0;
        isRectangleNull = true;
        isTriangleNull = true;
        isInverse = false;
        quadrantAngle = 0;
        forme = typeForme[4];
        isCoteLongueur = true;
        A = new CoordonneesDbl(0,0);
        B = new CoordonneesDbl(0,0);
        C = new CoordonneesDbl(0,0);
        D = new CoordonneesDbl(0,0);
        E = new CoordonneesDbl(0,0);
        center = new CoordonneesDbl(0,0);
    }
    public Quadrilatere(Rectangle conteneur , double surface , Angle angle){
        setConteneur(conteneur);
        setAngle(angle);
        this.surface = surface;
        setSurfaceMiniSurfaceMaxi();
        setFormeAttendue();
        setCoteDessin();
        setTriangleVsAngleSurface();
        setRectangleApresTriangle();
        setPositionRectangleDansConteneur();
        setPositionTriangleVsRectangle();
    }
    public Quadrilatere(Rectangle conteneur , Rectangle rectangle , TriangleRectangle triangle ){
        setTriangle(triangle);
        setRectangle(rectangle);
        setConteneur(conteneur);
        setPositionRectangleDansConteneur();
        setPositionTriangleVsRectangle();
        setSurfaceMiniSurfaceMaxi();
        setFormeAttendue();
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
            case 1:
                triangle.moveCTo(rectangle.getC());
                break;
            case 2:
                triangle.moveCTo(rectangle.getA());
                break;
            case 3:
                triangle.moveCTo(rectangle.getB());
                break;
            case 4:
                triangle.moveCTo(rectangle.getD());
                break;
            case 5:
                triangle.moveCTo(rectangle.getA());
                break;
            case 6:
                triangle.moveCTo(rectangle.getC());
                break;
            case 7:
                triangle.moveCTo(rectangle.getD());
                break;
            case 8:
                triangle.moveCTo(rectangle.getB());
                break;
        }
    }
    private void setSurfaceMiniSurfaceMaxi(){
        // Necessite que le conteneur soit declaré
        TriangleRectangle triangleMini = new TriangleRectangle();
        setCoteDessin();
        if (isCoteLongueur){
            triangleMini.setTriangleLongueurAngle(conteneur.getLongueur(), angle.valRad());
        }else{
            triangleMini.setTriangleHauteurAngle(conteneur.getHauteur(), angle.valRad());
        }
        this.surfMini = triangleMini.getSurface();
        this.surfMaxi = conteneur.getSurface()-this.surfMini;
    }
    private void setFormeAttendue(){
        //Necessite que les surfaces Mini & Maxi soient calculées
        if (angle.sin() == 0 || angle.cos() == 0){
            forme = typeForme[1];
            isTriangleNull = true;
            isRectangleNull = false;
            isInverse = false;
        }else if (surface <= surfMini){
            forme = typeForme[0];
            isTriangleNull = false;
            isRectangleNull = true;
            isInverse = false;
        }else if(surface > surfMini && surface < surfMaxi){
            forme = typeForme[2];
            isTriangleNull = false;
            isRectangleNull = false;
            isInverse = false;
        }else if(surface >= surfMaxi){
            forme = typeForme[3];
            isTriangleNull = false;
            isRectangleNull = true;
            isInverse = true;
        }else {
            forme = typeForme[4];
            isTriangleNull = false;
            isRectangleNull = false;
            isInverse = false;
        }
    }
    private void setCoteDessin(){
        int i = conteneur.getAngleBase().comparaisonAngleQuadran(this.angle);
        switch (i) {
            case 0:
                if (Math.abs(this.angle.cos()) == 1) {
                    isCoteLongueur = true;
                } else {
                    isCoteLongueur = false;
                }
                break;
            case 1: case 4: case 5: case 8:
                isCoteLongueur = true;
            default:
                isCoteLongueur =false;
        }
    }
    private void setTriangleVsAngleSurface(){
        TriangleRectangle t;
        if (forme == typeForme[0]){
            t = new TriangleRectangle(surface , angle);
        }else if (forme == typeForme[2]) {
            t = new TriangleRectangle();
            if (isCoteLongueur) {
                t.setTriangleLongueurAngle(conteneur.getLongueur(), angle.valRad());
            } else {
                t.setTriangleHauteurAngle(conteneur.getHauteur(), angle.valRad());
            }
        }else if (forme == typeForme[3]){
            double s = conteneur.getSurface()-surface;
            t = new TriangleRectangle(s , angle);
        }else {
            t = new TriangleRectangle(0,0);
        }
        setTriangle(t);
    }
    private void setRectangleApresTriangle(){
        double surf = surface- triangle.getSurface();
        if (!isRectangleNull){
            if (forme == typeForme[1]){
                if (isCoteLongueur){
                    if (conteneur.getLongueur() != 0) {
                        double h = surface / conteneur.getLongueur();
                        setRectangle(new Rectangle(conteneur.getLongueur(), h));
                    }else{
                        setRectangle(new Rectangle(0,0));
                    }
                }else{
                    if (conteneur.getHauteur() !=0 ){
                        double l = surface / conteneur.getHauteur();
                        setRectangle(new Rectangle(l , conteneur.getHauteur()));
                    }else{
                        setRectangle(new Rectangle(0,0));
                    }
                }
            }else if (forme == typeForme[2]){
                if (isCoteLongueur){
                    if (conteneur.getLongueur() != 0) {
                        double h = surf / conteneur.getLongueur();
                        setRectangle(new Rectangle(conteneur.getLongueur(), h));
                    }else{
                        setRectangle(new Rectangle(0,0));
                    }
                }else{
                    if (conteneur.getHauteur() !=0 ){
                        double l = surf / conteneur.getHauteur();
                        setRectangle(new Rectangle(l , conteneur.getHauteur()));
                    }else{
                        setRectangle(new Rectangle(0,0));
                    }
                }
            }else{
                setRectangle(new Rectangle(0,0));
            }
        }else{
            setRectangle(new Rectangle(0,0));
        }
    }
}
