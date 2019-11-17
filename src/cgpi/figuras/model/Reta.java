package cgpi.figuras.model;

import javafx.scene.paint.Color;

import java.util.List;

/**
 * @author vitor.alves
 */
public class Reta extends Figura {

    private static final String POINTO_A = "A";

    private static final String POINTO_B = "B";

    public Reta(Ponto pointA, Ponto pointB) {
        super(Color.RED);
        this.addPoint(POINTO_A, pointA);
        this.addPoint(POINTO_B, pointB);
    }

    public Reta(Ponto pointA, Ponto pointB, Color color) {
        super(color);
        this.addPoint(POINTO_A, pointA);
        this.addPoint(POINTO_B, pointB);
    }

    public Reta(List<Ponto> pontos) {
        this(pontos.get(0), pontos.get(1));
    }

    public Reta(List<Ponto> pontos, Color color) {
        this(pontos.get(0), pontos.get(1), color);
    }

    public Ponto getPointA() {
        return this.getPoint(POINTO_A);
    }

    public Ponto getPointB() {
        return this.getPoint(POINTO_B);
    }

    public double[] getPointACoordinates() {
        return new double[]{this.getPointA().getX(), this.getPointA().getY()};
    }

    public double[] getPointBCoordinates() {
        return new double[]{this.getPointB().getX(), this.getPointB().getY()};
    }
}
