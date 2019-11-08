package cgpi.vtec;

import cgpi.controller.AbstractController;
import cgpi.figuras.actors.Desenhe;
import cgpi.figuras.actors.DesenhoActor;
import cgpi.figuras.model.Desenho;
import cgpi.vtec.events.AbstractDesenhoEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;

/**
 * @author vitor.alves
 */
public class MainCanvasListener implements ChangeListener {

    private final AbstractController mainController;

    private final Desenhe desenheActor;

    public MainCanvasListener(AbstractController mainController) {
        this.mainController = mainController;
        desenheActor = new DesenhoActor(((Canvas) mainController.get("canvas")).getGraphicsContext2D());
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        AbstractDesenhoEvent event = (AbstractDesenhoEvent) newValue;
//        Desenho desenho = DesenhoUtills.converter(event.getDesenho(), mainController.get("canvas"), );
        desenheActor.clearCanvas();
    }
}
