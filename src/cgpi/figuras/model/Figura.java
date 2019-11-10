package cgpi.figuras.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vitor.alves
 */
public class Figura {

    private final Map<String, Ponto> points;

    public Figura() {
        points = new HashMap<String, Ponto>();
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
}
