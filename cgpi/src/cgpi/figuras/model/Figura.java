package cgpi.figuras.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vitor.alves
 */
public class Figura {

    private final Map<String, Ponto> points;

    private final List<String> colors;

    private final Color color;

    public Figura(Color color) {
        points = new HashMap<String, Ponto>();
        colors = new ArrayList<String>();
        this.color = color;
    }

    public void addPoint(String pointName, Ponto point) {
        points.put(pointName, point);
    }

    public Ponto getPoint(String pointName) {
        return points.get(pointName);
    }

    public List<Ponto> getPontos() {
        return new ArrayList<Ponto>(points.values());
    }

    public Color getColor() {
        return color;
    }
}
