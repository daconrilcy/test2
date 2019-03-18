package game.map.calculation;

public class Angle {
    private double valRad;
    private double valOrigin;
    private double valDeg;
    private double anglePI2;
    private double cos;
    private double sin;
    private int compareToPi;
    private double angleQB,angleQC,angleQD;
    private boolean anglePI2isTransH;
    private boolean anglePI2isTransV;

    Angle(){
        valOrigin=0;
        valRad=0;
        valDeg =0;
        cos = 1;
        sin = 0;
        compareToPi =0;
        anglePI2 =0;
        angleQB =0;
        angleQC = 0;
        angleQD = 0;
    }

    Angle(double valRad){
       setValOrigin(valRad);
    }
    Angle(double val , boolean enDegres){
        if (enDegres){
            setValOrigin(Math.toRadians(val));
        }else{
            setValOrigin(valRad);
        }
    }

    public void setValRad(double valRad) {
        setValOrigin(valRad);
    }

    public void setValDeg(double valDeg) {
        setValOrigin(Math.toRadians(valDeg));
        this.valDeg = valDeg;
    }

    public double valRad(){
        return this.valRad;
    }

    public double valDeg(){
        return this.valDeg;
    }

    public double cos(){
        return this.cos;
    }
    public double sin(){
        return this.sin;
    }

    public double valOrigin() {
        return valOrigin;
    }

    public double anglePI2() {
        return anglePI2;
    }

    private void setCompareToPi(){
        comparaisonPI(valRad);
    }
    public int compareToPi(){
        return compareToPi;
    }

    public boolean AnglePI2isTransH() {
        return anglePI2isTransH;
    }

    public boolean AnglePI2isTransV() {
        return anglePI2isTransV;
    }

    public void setValOrigin(double valEnRad) {
        valOrigin = valEnRad;
        setValRad();
        setValDeg();
        this.cos = Math.cos(valRad);
        this.sin = Math.sin(valRad);
        setCompareToPi();
        setAnglePI2();
    }

    private void setValRad(){
        valRad = this.valOrigin % (2* Math.PI);
    }

    private void setValDeg(){
        valDeg = (valOrigin %(2*Math.PI))/Math.PI*180;
    }

    private int comparaisonPI(double angleEnRad){
        angleEnRad = angleEnRad % (2*Math.PI);
        if (angleEnRad == 0 || angleEnRad == Math.PI/2 || angleEnRad == Math.PI || angleEnRad == 3/2*Math.PI || angleEnRad == 2 * Math.PI){
            return 0;
        }else if (angleEnRad >0 && angleEnRad < Math.PI/2){
            return 1;
        }else if (angleEnRad >Math.PI/2 && angleEnRad < Math.PI){
            return 2;
        }else if (angleEnRad > Math.PI && angleEnRad < 3/2* Math.PI){
            return 3;
        }else if (angleEnRad >3/2 * Math.PI && angleEnRad < 2*Math.PI){
            return 4;
        }
        return 0;
    }

    public int comparaisonAngleQuadran(double angleEnRad){
        angleEnRad = angleEnRad % (2* Math.PI);

        if (angleEnRad == 0 || angleEnRad == Math.PI/2 || angleEnRad == Math.PI || angleEnRad == 3/2*Math.PI || angleEnRad == 2 * Math.PI){
            return 0;
        }else if (angleEnRad >0 || angleEnRad <=anglePI2){
            return 1;
        }else if (angleEnRad >anglePI2 || angleEnRad < Math.PI/2){
            return 2;
        }else if (angleEnRad > Math.PI/2 || angleEnRad <= angleQB){
            return 3;
        }else if (angleEnRad >angleQB || angleEnRad < Math.PI){
            return 4;
        }else if (angleEnRad >Math.PI || angleEnRad <= angleQC){
            return 5;
        }else if (angleEnRad >angleQC || angleEnRad < 3/2*Math.PI){
            return 6;
        }else if (angleEnRad >3/2*Math.PI || angleEnRad <= angleQD){
            return 7;
        }else if (angleEnRad >angleQD || angleEnRad < 2 * Math.PI){
            return 8;
        }
        return 99;
    }

    public int switchCasePI(){
        if (valRad == 0 || valRad == Math.PI/2 || valRad == Math.PI || valRad == 3/2 * Math.PI || valRad == 2* Math.PI){
            if (valRad == 0) {
                return 0;
            }else if(valRad == Math.PI/2){
                return 1;
            }else if(valRad == Math.PI){
                return 2;
            }else if(valRad == 3/2 * Math.PI){
                return 3;
            }else if (valRad == 2* Math.PI){
                return 4;
            }
        }
        return 99;
    }

    public int comparaisonAngleQuadran(Angle angle){
        return comparaisonAngleQuadran(angle.valRad());
    }

    public boolean isSup(double angleEnRad){
        angleEnRad = angleEnRad %(2 * Math.PI);
        if (angleEnRad < valRad){
            return true;
        }
        return false;
    }

    public boolean isSup(Angle angle){
        if (angle.valRad > valRad){
            return true;
        }
        return false;
    }

    private double setAnglePI2(double angleEnRad){
        angleEnRad = angleEnRad % (2 * Math.PI);
        int compToPi = comparaisonPI(angleEnRad);
        switch (compToPi){
            case 0:
                anglePI2isTransH = false;
                anglePI2isTransV = false;
                return angleEnRad;
            case 1:
                anglePI2isTransH = false;
                anglePI2isTransV = false;
                return angleEnRad;
            case 2:
                anglePI2isTransH = false;
                anglePI2isTransV = true;
                return Math.PI-angleEnRad;
            case 3:
                anglePI2isTransH = true;
                anglePI2isTransV = true;
                return angleEnRad-Math.PI;
            case 4:
                anglePI2isTransH = true;
                anglePI2isTransV = false;
                return 2*Math.PI - angleEnRad;
            default:
                anglePI2isTransH = false;
                anglePI2isTransV = false;
                return angleEnRad;
        }
    }

    private void setAnglePI2(){
        anglePI2 = setAnglePI2(valRad);
        angleQB = Math.PI-anglePI2;
        angleQC = Math.PI+anglePI2;
        angleQB = 2*Math.PI-anglePI2;
    }
}
