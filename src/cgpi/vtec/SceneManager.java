package cgpi.vtec;

import cgpi.controller.AbstractController;
import cgpi.view.enums.Scenes;
import javafx.scene.Node;

/**
 * @author vitor.alves
 */
public class SceneManager {

    public Node getScene(Scenes scene) {
        VFXMLLoader loader = new VFXMLLoader(scene);
        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loader.getRoot();
    }

    public Node getScene(Scenes scene, AbstractController parent) {
        VFXMLLoader loader = new VFXMLLoader(scene);
        loader.setParentController(parent);
        loader.load();
        return loader.getRoot();
    }
}
