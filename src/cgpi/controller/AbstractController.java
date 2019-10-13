package cgpi.controller;

import javafx.scene.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vitor.alves
 */
public abstract class AbstractController {

    private final Map<String, Node> components;

    public AbstractController() {
        components = new HashMap<>();
    }

    protected Node get(String key) {
        return components.get(key);
    }
}
