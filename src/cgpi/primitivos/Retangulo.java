package cgpi.primitivos;

import static java.lang.Math.*;


public class Retangulo {
    private double altura;
    private double base;
    private Ponto catetoEsq, catetoDir;

    public Retangulo(int x1, int y1, int x2, int y2){
        setCatetoDir(new Ponto(x1,y1));
        setCatetoEsq(new Ponto(x2,y2));
        setAltura(CalculateAltura());
        setBase(CalculateBase());
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setCatetoEsq(Ponto catetoEsq) {
        this.catetoEsq = catetoEsq;
    }

    public void setCatetoDir(Ponto catetoDir) {
        this.catetoDir = catetoDir;
    }

    public double getAltura() {
        return altura;
    }

    public double getBase() {
        return base;
    }

    public Ponto getCatetoDir() {
        return this.catetoDir;
    }

    public Ponto getCatetoEsq() {
        return this.catetoEsq;
    }


    public double CalculateAltura(){
        return abs(catetoEsq.gety() - catetoDir.gety());
    }

    public double CalculateBase(){
        return abs(catetoEsq.getx() - catetoDir.getx());
    }

    public double Diagonal() {
        return sqrt(pow(getBase(), 2)+ pow(getAltura(),2));
    }

    public double Area(){
        return getAltura() * getBase();
    }
}
