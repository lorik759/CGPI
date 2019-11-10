package cgpi.controller;

import javafx.scene.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vitor.alves
 */
public abstract class AbstractController<T> {

    private AbstractController parent;

    private final Map<String, Node> components;

    private T model;

    public AbstractController() {
        components = new HashMap<>();
        model = this.createModel();
    }

    protected abstract T createModel();

    public Node get(String key) {
        return components.get(key);
    }

    public T getModel() {
        return model;
    }

    public AbstractController getParent() {
        return parent;
    }
}
