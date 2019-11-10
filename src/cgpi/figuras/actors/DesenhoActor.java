package cgpi.figuras.actors;

import cgpi.figuras.model.Circulo;
import cgpi.figuras.model.Desenho;
import cgpi.figuras.model.Ponto;
import cgpi.figuras.model.Reta;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * @author vitor.alves
 */
public class DesenhoActor implements Desenhe {

    private static final double WIDTH = 3.0;

    private final GraphicsContext graphicsContext;

    private final Color corReta = Color.RED;

    private final Color corPonto = Color.BLUE;

    public DesenhoActor(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }


    @Override
    public void desenhe(Desenho desenho) {
        this.desenhePontos(desenho.getPontos());
        this.desenheRetas(desenho.getRetas());
        this.desenheCirculos(desenho.getCirculos());
    }

    @Override
    public void clearCanvas() {
        graphicsContext.clearRect(0, 0, graphicsContext.getCanvas().getWidth(), graphicsContext.getCanvas().getHeight());
    }

    private void desenhePontos(List<Ponto> pontos) {
        for (Ponto ponto : pontos) {
            this.desenhePonto(ponto);
        }
    }

    private void desenhePonto(Ponto ponto) {
        if (ponto != null) {
            this.graphicsContext.setFill(corPonto);
            this.graphicsContext.fillOval((int) (ponto.getX() - (Ponto.DIAMETRO / 2)), (int) (ponto.getY() - (Ponto.DIAMETRO / 2)),
                    Ponto.DIAMETRO, Ponto.DIAMETRO);
        }
    }

    private void desenheRetas(List<Reta> retas) {
        for (Reta reta : retas) {
            this.desenheReta(reta);
        }
    }

    private void desenheReta(Reta reta) {
        if (reta != null) {
            this.graphicsContext.setFill(corReta);
            this.graphicsContext.setStroke(corReta);
            this.graphicsContext.setLineWidth(WIDTH);
            this.graphicsContext.strokeLine(reta.getPointACoordinates()[0], reta.getPointACoordinates()[1],
                    reta.getPointBCoordinates()[0], reta.getPointBCoordinates()[1]);
        }
    }

    private void desenheCirculos(List<Circulo> circulos) {
        for (Circulo circulo : circulos) {
            this.desenheCirculo(circulo);
        }
    }

    private void desenheCirculo(Circulo circulo) {
        this.graphicsContext.strokeOval(circulo.getCentro().getX(), circulo.getCentro().getY(),
                circulo.getRaio(), circulo.getRaio());
    }
}
