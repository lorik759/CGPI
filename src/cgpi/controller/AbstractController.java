package cgpi.controller;

import javafx.scene.Node;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractController {

    private Map<String, Node> components = new HashMap<>();

    protected Node get(String key) {
        return components.get(key);
    }
}
