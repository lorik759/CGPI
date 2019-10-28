package cgpi.controller;

import cgpi.figuras.actors.DesenhoActor;
import cgpi.figuras.model.Desenho;
import cgpi.figuras.model.Reta;
import cgpi.vtec.Inicializavel;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;

/**
 * @author vitor.alves
 */
public class KochSnowFlakeController extends AbstractController implements Inicializavel {

    private DesenhoActor desenhoActor;

    @Override
    public void inicialize() {
        desenhoActor = new DesenhoActor(((Canvas) this.get("canvas")).getGraphicsContext2D());
        Desenho desenho = new Desenho();
        desenho.addReta(new Reta(new Point2D(200, 300), new Point2D(400, 500)));
        desenhoActor.desenhe(desenho);
    }
}
