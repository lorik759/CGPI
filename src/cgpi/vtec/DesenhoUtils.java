package cgpi.vtec;

import cgpi.figuras.model.Circulo;
import cgpi.figuras.model.Desenho;
import cgpi.figuras.model.Ponto;
import cgpi.figuras.model.Reta;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vitor.alves
 */
public class DesenhoUtils {

    public static Desenho convertDesenho(Canvas from, Canvas to, Desenho desenho) {
        Desenho newDesenho = new Desenho();

        newDesenho.addPontos(convertPontos(from, to, desenho.getPontos()));
        newDesenho.addRetas(convertRetas(from, to, desenho.getRetas()));
        newDesenho.addCirculos(convertCirculos(from, to, desenho.getCirculos()));

        return newDesenho;
    }

    private static List<Circulo> convertCirculos(Canvas from, Canvas to, List<Circulo> circulos) {
        List<Circulo> newCirculos = new ArrayList<>();
        for (Circulo circulo : circulos) {
            newCirculos.add(new Circulo(circulo.getPontos()));
        }
        return newCirculos;
    }

    private static List<Reta> convertRetas(Canvas from, Canvas to, List<Reta> retas) {
        List<Reta> newRetas = new ArrayList<>();

        for (Reta reta : retas) {
            newRetas.add(new Reta(convertPontos(from, to, reta.getPontos())));
        }

        return newRetas;
    }

    private static List<Ponto> convertPontos(Canvas from, Canvas to, List<Ponto> pontos) {
        double p1x, p1y;

        List<Ponto> newPontos = new ArrayList<>();
        for (Ponto ponto : pontos) {

            p1x = (to.getWidth() / from.getWidth()) * ponto.getX();
            p1y = (to.getHeight() / from.getHeight()) * ponto.getY();

            newPontos.add(new Ponto(p1x, p1y));
        }

        return newPontos;
    }
}
