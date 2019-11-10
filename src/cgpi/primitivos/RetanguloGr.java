package cgpi.primitivos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static cgpi.primitivos.AlgoritmosRetas.MIDPOINT;

public class RetanguloGr extends Retangulo {
    private Color color;
    private String name;
    private int esp;

    public RetanguloGr(int x1, int y1, int x2, int y2, String name ,Color color, int esp){
        super(x1, y1, x2, y2);
        setName(name);
        setColor(color);
        setEsp(esp);
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public void setEsp(int esp) {
        this.esp = esp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public int getEsp() {
        return this.esp;
    }

    public String getName() {
        return this.name;
    }

    //public void DesenharRetangulo(int x1, int y1, int x2, int y2, GraphicsContext g){
    public void DesenharRetangulo(GraphicsContext g){

        double x1,x2,y1,y2;

        x1 = getCatetoEsq().getx();
        y1 = getCatetoEsq().gety();
        x2 = getCatetoDir().getx();
        y2 = getCatetoDir().gety();

        RetaGr.desenhar(g, x1, y1, x1, y2, getName(), getColor(), getEsp(), MIDPOINT);
        RetaGr.desenhar(g, x1, y1, x2, y1, getName(), getColor(), getEsp(), MIDPOINT);
        RetaGr.desenhar(g, x2, y1, x2, y2, getName(), getColor(), getEsp(), MIDPOINT);
        RetaGr.desenhar(g, x1, y2, x2, y2, getName(), getColor(), getEsp(), MIDPOINT);
    }
}
