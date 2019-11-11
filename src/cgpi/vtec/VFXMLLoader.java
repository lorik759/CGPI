package cgpi.vtec;

import cgpi.vtec.controllers.AbstractDesenhoController;
import cgpi.view.enums.Scenes;
import cgpi.vtec.controllers.ControllerBuilder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author vitor.alves
 */
public class VFXMLLoader {

    private final Stage stage;

    private FXMLLoader fxmlLoader;

    private AbstractDesenhoController controller;

    private AbstractDesenhoController parentController;

    private ControllerBuilder controllerBuilder;

    public VFXMLLoader(String name, Stage stage) {
        this.fxmlLoader = new FXMLLoader(getClass().getResource(name));
        this.stage = stage;
    }

    public VFXMLLoader(Scenes scene, Stage stage) {
        this(scene.getLocation(), stage);
    }

    public AbstractDesenhoController getController() {
        return controller;
    }

    public Node getRoot() {
        return fxmlLoader.getRoot();
    }

    /**
     * Carrega um arquivo xml e constroi o controller
     *
     */
    public <T> T load() {
        T parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.controller = this.fxmlLoader.getController();
        this.controllerBuilder = new ControllerBuilder(this.controller, this.fxmlLoader.getNamespace().entrySet(), stage);

        this.build();

        return parent;
    }

    private void build() {
        if (this.parentController != null) {
            this.controllerBuilder.setParentController(this.parentController);
        }
        this.controller = this.controllerBuilder.build();
    }

    public void setParentController(AbstractDesenhoController parent) {
        this.parentController = parent;
    }
}
