package cgpi.figuras.model;

import javafx.geometry.Point2D;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vitor.alves
 */
public class Figura {

    private final Map<String, Point2D> points;

    public Figura() {
        points = new HashMap<String, Point2D>();
    }

    public void addPoint(String pointName, Point2D point) {
        points.put(pointName, point);
    }

    public Point2D getPoint(String pointName) {
        return points.get(pointName);
    }
}
