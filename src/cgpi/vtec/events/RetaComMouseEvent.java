package cgpi.vtec.events;

import cgpi.controller.AbstractController;
import cgpi.figuras.model.Ponto;
import cgpi.figuras.model.Reta;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * @author vitor.alves
 */
public class RetaComMouseEvent extends AbstractDesenhoEvent<MouseEvent> {

    private boolean primeiraVez = true;

    private Ponto pontoA;

    private Ponto pontoB;

    public RetaComMouseEvent(AbstractController controller) {
        super(controller);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        MouseButton button = mouseEvent.getButton();
        if (button.equals(MouseButton.PRIMARY)) {
            onPrimaryClick(mouseEvent);
        }
        desenhoActor.desenhe(this.desenho);
    }

    private void onPrimaryClick(MouseEvent mouseEvent) {
        if (primeiraVez) {
            pontoA = new Ponto((int) mouseEvent.getX(), (int) mouseEvent.getY());
            desenho.addPonto(pontoA);
            primeiraVez = false;
        } else {
            pontoB = new Ponto((int) mouseEvent.getX(), (int) mouseEvent.getY());
            desenho.addPonto(pontoB);
            Reta reta = new Reta(pontoA, pontoB);
            this.desenho.addReta(reta);
            primeiraVez = true;
        }
    }

    private void onSecondaryClick(MouseEvent mouseEvent) {
//        if (primeiraVez == true) {
//            x1 = (int) mouseEvent.getX();
//            y1 = (int) mouseEvent.getY();
//            new PontoGr(x1, y1, Color.BLUE, "", 6).desenharPonto(this.getGraphicsContext());
//            primeiraVez = false;
//        } else {
//            x2 = (int) mouseEvent.getX();
//            y2 = (int) mouseEvent.getY();
//            double raio = new PontoGr(x1, y1).distance(x2, y2);
//            CirculoGr.desenhar(this.getGraphicsContext(), x1, y1, raio, Color.GREEN, "", 2, AlgoritmosCirculos.STROKELINE);
//            new PontoGr(x2, y2, Color.BLUE, "", 6).desenharPonto(this.getGraphicsContext());
//            primeiraVez = true;
//        }
    }
}
