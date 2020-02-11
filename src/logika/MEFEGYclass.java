package logika;

public class MEFEGYclass {
    private double egyutthatoA;
    public double a, b, c, d, x1, x2;
    public int gyokokszama;

    public MEFEGYclass(String sor){
        String[] adatok = sor.replace(',', '.').split(" ");
        this.setA(Double.parseDouble(adatok[0]));
        this.setB(Double.parseDouble(adatok[1]));
        this.setC(Double.parseDouble(adatok[2]));
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public int getGyokokszama() {
        return gyokokszama;
    }
    public double D(){
        return Math.pow(b, 2) - 4 * a * c;
    }
    public int GyokokSzama(){
        if (D() < 0){
            return 0;
        }
        if (D() > 0){
            return 2;
        }
        else{
            return 1;
        }
    }
    public double X1(){
        if (GyokokSzama() == 0){
            return Double.NaN;
        }
        else {
            return -b + Math.sqrt(D()) / (2 * a);
        }
    }
    public double X2(){
        if (GyokokSzama() == 0 || GyokokSzama() == 1){
            return Double.NaN;
        }
        else {
            return -b - Math.sqrt(D()) / (2 * a);
        }
    }
}
