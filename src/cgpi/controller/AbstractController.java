package cgpi.controller;

import javafx.scene.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vitor.alves
 */
public abstract class AbstractController {

    private final Map<String, Node> components;

    private AbstractController parent;

    public AbstractController() {
        components = new HashMap<>();
    }

    protected Node get(String key) {
        return components.get(key);
    }

    public AbstractController getParent() {
        return parent;
    }
}
