package cgpi.vtec.control;

import cgpi.viw.enums.Scenes;
import javafx.scene.control.Button;

/**
 * @author vitor.alves
 */
public class SceneButton extends Button {

    private Scenes scene;

    public Scenes getScenes() {
        return scene;
    }

    public void setScenes(Scenes scene) {
        this.scene = scene;
    }
}