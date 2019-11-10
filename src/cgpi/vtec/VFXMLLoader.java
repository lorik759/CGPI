package cgpi.vtec;

import cgpi.controller.AbstractController;
import cgpi.view.enums.Scenes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Inicializa e configura o controller de um xml
 *
 * @author vitor.alves
 */
public class VFXMLLoader {

    private FXMLLoader fxmlLoader;

    private AbstractController controller;

    private AbstractController parentController;

    private ControllerBuilder controllerBuilder;

    public VFXMLLoader(String name) {
        this.fxmlLoader = new FXMLLoader(getClass().getResource(name));
    }

    public VFXMLLoader(Scenes scene) {
        this(scene.getLocation());
    }

    public AbstractController getController() {
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
        this.controllerBuilder = new ControllerBuilder(this.controller, this.fxmlLoader.getNamespace().entrySet());

        this.build();

        return parent;
    }

    private void build() {
        if (this.parentController != null) {
            this.controllerBuilder.setParentController(this.parentController);
        }
        this.controller = this.controllerBuilder.build();
    }

    public void setParentController(AbstractController parent) {
        this.parentController = parent;
    }
}
