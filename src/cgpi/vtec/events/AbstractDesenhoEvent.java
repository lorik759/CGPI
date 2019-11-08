package cgpi.vtec.events;

import cgpi.controller.AbstractController;
import cgpi.figuras.actors.Desenhe;
import cgpi.figuras.actors.DesenhoActor;
import cgpi.figuras.model.Desenho;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * @author vitor.alves
 */
public abstract class AbstractDesenhoEvent<T extends Event> implements EventHandler<T> {

    private final AbstractController controller;

    private GraphicsContext graphicsContext;

    private Canvas canvas;

    protected final Desenhe desenhoActor;

    protected final Desenho desenho;

    public AbstractDesenhoEvent(AbstractController controller) {
        this.controller = controller;
        this.canvas = (Canvas) controller.get("canvas");
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        desenhoActor = new DesenhoActor(this.getGraphicsContext());
        desenho = new Desenho();
    }

    public AbstractController getController() {
        return controller;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Desenho getDesenho() {
        return desenho;
    }

    public abstract void handle(T event);
}
