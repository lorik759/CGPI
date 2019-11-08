package cgpi.vtec.events;

import cgpi.controller.AbstractController;
import cgpi.vtec.annotation.OnMouseClick;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.lang.reflect.Constructor;

/**
 * @author vitor.alves
 */
public class EventFactory {

    public EventHandler<? extends MouseEvent> getOnMouseClickEvent(OnMouseClick annotation, AbstractController controller) throws Exception {
        String value = annotation.value();
        Class<? extends AbstractDesenhoEvent> event = annotation.event();
        Constructor constructor = event.getConstructor(AbstractController.class);
        AbstractDesenhoEvent eventHandler = (AbstractDesenhoEvent) constructor.newInstance(controller);
        method.invoke(controller.getModel(), eventHandler.getDesenho());
        return
    }

}
