package cgpi.controller;

import cgpi.vtec.Inicializavel;
import cgpi.vtec.SceneManager;
import cgpi.vtec.control.SceneButton;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

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
    }

    @FXML
    private void setScene(Event event) throws Exception {
        SceneButton source = (SceneButton) event.getSource();
        ((BorderPane) this.get("borderPane")).setCenter(this.sceneManager.getScene(source.getScenes()));
    }
}
