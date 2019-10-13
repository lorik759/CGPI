package cgpi.vtec;

import cgpi.viw.enums.Scenes;
import javafx.scene.Node;

/**
 * @author vitor.alves
 */
public class SceneManager {

    public Node getScene(Scenes scene) throws Exception {
        VFXMLLoader loader = new VFXMLLoader(scene);
        loader.load();
        return loader.getRoot();
    }
}
