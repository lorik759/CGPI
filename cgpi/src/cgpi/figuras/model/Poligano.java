package cgpi.figuras.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vitor.alves
 */
public class Poligano extends Figura {

    private List<Reta> retas;

    public Poligano(List<Reta> retas) {
        super(Color.RED);
        this.retas = new ArrayList<>(retas);
    }

    public List<Reta> getRetas() {
        return retas;
    }
}
