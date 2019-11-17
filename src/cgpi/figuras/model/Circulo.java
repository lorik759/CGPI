package cgpi.figuras.model;

import javafx.scene.paint.Color;

import java.util.List;

/**
 * @author vitor.alves
 */
public class Circulo extends Figura {

    private static final String CENTRO = "centro";

    private static final String BORDA = "borda";

    private final double raio;

    public Circulo(Ponto centro, Ponto borda, double raio) {
        super(Color.GREEN);
        this.addPoint(CENTRO, centro);
        this.addPoint(BORDA, borda);
        this.raio = raio;
    }

    public Circulo(Ponto centro, double raio) {
        super(Color.GREEN);
        this.addPoint(CENTRO, centro);
        this.addPoint(BORDA, new Ponto(centro.getX() + raio, centro.getY()));
        this.raio = raio;
    }

    public Circulo(Ponto centro, double raio, Color color) {
        super(color);
        this.addPoint(CENTRO, centro);
        this.addPoint(BORDA, new Ponto(centro.getX() + raio, centro.getY()));
        this.raio = raio;
    }

    public Circulo(List<Ponto> pontos) {
        super(Color.GREEN);
        this.addPoint(CENTRO, pontos.get(0));
        this.addPoint(BORDA, pontos.get(1));
        this.raio = getCentro().distance(getBorda().getX(), getBorda().getY());
    }

    public Circulo(List<Ponto> pontos, Color color) {
        super(color);
        this.addPoint(CENTRO, pontos.get(0));
        this.addPoint(BORDA, pontos.get(1));
        this.raio = getCentro().distance(getBorda().getX(), getBorda().getY());
    }

    public Ponto getCentro() {
        return this.getPoint(CENTRO);
    }

    public Ponto getBorda() {
        return this.getPoint(BORDA);
    }

    public double getRaio() {
        return raio;
    }
}
