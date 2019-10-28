package cgpi.controller;

import cgpi.figuras.actors.DesenhoActor;
import cgpi.figuras.model.Desenho;
import cgpi.figuras.model.Reta;
import cgpi.vtec.Inicializavel;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;

/**
 * @author vitor.alves
 */
public class KochSnowFlakeController extends AbstractController implements Inicializavel {

    private DesenhoActor desenhoActor;

    @FXML
    private Canvas canvas;

    @Override
    public void inicialize() {
        this.desenhoActor = new DesenhoActor(canvas.getGraphicsContext2D());
//        canvas.getProperties().addListener();
    }
}
