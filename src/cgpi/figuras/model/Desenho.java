package cgpi.figuras.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vitor.alves
 */
public class Desenho {

    private final List<Reta> retas;

    private final List<Circulo> circulos;


    public Desenho() {
        this.retas = new ArrayList<>();
        this.circulos = new ArrayList<>();
    }

    public List<Reta> getRetas() {
        return retas;
    }

    public List<Circulo> getCirculos() {
        return circulos;
    }

    public void addReta(Reta reta) {
        this.retas.add(reta);
    }

    public void addCirculos(Circulo circulo) {
        this.circulos.add(circulo);
    }
}
