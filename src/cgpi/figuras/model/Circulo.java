package cgpi.figuras.model;

import javafx.geometry.Point2D;

/**
 * @author vitor.alves
 */
public class Circulo extends Figura {

    private static final String CENTRO = "centro";

    private final double raio;

    public Circulo(Point2D centro, double raio) {
        this.addPoint(CENTRO, centro);
        this.raio = raio;
    }

    public Point2D getCentro() {
        return this.getPoint(CENTRO);
    }

    public double getRaio() {
        return raio;
    }
}
