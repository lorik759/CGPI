package cgpi.figuras.model;

import javafx.scene.paint.Color;

import java.util.*;
import java.util.List;

/**
 * @author vitor.alves
 */
public class Retangulo extends Figura {

    private Map<String, Reta> retas;

    private static final String RETA_A = "A";

    private static final String RETA_B = "B";

    private static final String RETA_C = "C";

    private static final String RETA_D = "D";

    public Retangulo(Reta a, Reta b, Reta c, Reta d) {
        super(a.getColor());
        this.retas = new HashMap<String, Reta>();
        addReta(RETA_A, a);
        addReta(RETA_B, b);
        addReta(RETA_C, c);
        addReta(RETA_D, d);
    }

    public Retangulo(Reta a, Reta b, Reta c, Reta d, Color color) {
        super(color);
        this.retas = new HashMap<String, Reta>();
        addReta(RETA_A, a);
        addReta(RETA_B, b);
        addReta(RETA_C, c);
        addReta(RETA_D, d);
    }

    public Retangulo(List<Reta> retas) {
        super(retas.get(0).getColor());
        this.retas = new HashMap<String, Reta>();
        addReta(RETA_A, retas.get(0));
        addReta(RETA_B, retas.get(1));
        addReta(RETA_C, retas.get(2));
        addReta(RETA_D, retas.get(3));
    }

    public Retangulo(Ponto pontoA, Ponto pontoB) {
        this(new Reta(pontoA, new Ponto(pontoB.getX(), pontoA.getY())),
                new Reta(pontoA, new Ponto(pontoA.getX(), pontoB.getY())),
                new Reta(new Ponto(pontoB.getX(), pontoA.getY()), pontoB),
                new Reta(new Ponto(pontoA.getX(), pontoB.getY()), pontoB));
    }

    public Retangulo(Ponto pontoA, Ponto pontoB, Color color) {
        this(new Reta(pontoA, new Ponto(pontoB.getX(), pontoA.getY())),
                new Reta(pontoA, new Ponto(pontoA.getX(), pontoB.getY())),
                new Reta(new Ponto(pontoB.getX(), pontoA.getY()), pontoB),
                new Reta(new Ponto(pontoA.getX(), pontoB.getY()), pontoB), color);
    }

    public void addReta(String name, Reta reta) {
        retas.put(name, reta);
    }

    public List<Reta> getRetas() {
        return new ArrayList<>(retas.values());
    }

    public Ponto getPointA() {
        return retas.get(RETA_A).getPointA();
    }

    public Ponto getPointB() {
        return retas.get(RETA_B).getPointA();
    }
}
