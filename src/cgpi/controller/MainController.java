package cgpi.controller;

import cgpi.view.enums.Scenes;
import cgpi.vtec.Inicializavel;
import cgpi.vtec.SceneManager;
import cgpi.vtec.control.SceneButton;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

import static cgpi.view.enums.Scenes.RETA_COM_MOUSE;

/**
 * @author vitor.alves
 */
public class MainController extends AbstractController implements Inicializavel {

    private final SceneManager sceneManager;

    public MainController() {
        sceneManager = new SceneManager();
    }

    @Override
    protected Object createModel() {
        return null;
    }

    @Override
    public void inicialize() {
        ((BorderPane) this.get("borderPane")).setCenter(this.sceneManager.getScene(RETA_COM_MOUSE, this));
    }

    @FXML
    private void setScene(Event event) throws Exception {
        SceneButton source = (SceneButton) event.getSource();
        ((BorderPane) this.get("borderPane")).setCenter(this.sceneManager.getScene(source.getScenes(), this));
    }
}
