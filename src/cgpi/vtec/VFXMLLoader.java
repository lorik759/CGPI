package cgpi.vtec;

import cgpi.controller.AbstractController;
import cgpi.viw.enums.Scenes;
import cgpi.vtec.exception.ControllerEntityException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.lang.reflect.Field;
import java.util.HashMap;
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

    private ControllerEntity controllerEntity = new ControllerEntity();

    private Set<Map.Entry<String, Object>> entries;

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
     * @throws Exception
     */
    public <T> T load() throws Exception {
        T parent = fxmlLoader.load();
        entries = this.fxmlLoader.getNamespace().entrySet();
        controller = this.fxmlLoader.getController();
        controllerEntity.create(controller);

        this.buildController();

        return parent;
    }

    private void buildController() throws IllegalAccessException {
        Map<String, Node> components = new HashMap<>();
        Object value;
        for (Map.Entry<String, Object> entry : entries) {
            value = entry.getValue();
            if (value instanceof Node) {
                components.put(entry.getKey(), (Node) value);
            }
        }
        this.controllerEntity.setComponents(components);

        if (controller instanceof Inicializavel) {
            ((Inicializavel) controller).inicialize();
        }
    }

    private class ControllerEntity {

        private static final String CONTROLLER_FIELD = "components";

        private AbstractController controller;

        private Field components;

        public void setController(AbstractController controller) {
            this.controller = controller;
        }

        public void create(AbstractController controller) throws NoSuchFieldException, ControllerEntityException {
            this.controller = controller;
            this.create();
        }

        public void create() throws NoSuchFieldException, ControllerEntityException {
            this.components = this.getComponentField();
        }

        private Field getComponentField() throws NoSuchFieldException, ControllerEntityException {
            Class<?> aClass = this.controller.getClass();
            Field field = null;
            while (field == null && aClass != null) {
                aClass = aClass.getSuperclass();
                if (aClass != null && containsFieldComponents(aClass)) {
                    field = aClass.getDeclaredField(CONTROLLER_FIELD);
                }
            }
            if (aClass == null) {
                throw new ControllerEntityException("No AbstractController instance controller.");
            }
            return field;
        }

        private boolean containsFieldComponents(Class<?> aClass) {
            try {
                aClass.getDeclaredField(CONTROLLER_FIELD);
            } catch (NoSuchFieldException e) {
                return false;
            }
            return true;
        }

        public void setComponents(Object components) throws IllegalAccessException {
            this.components.setAccessible(true);
            this.components.set(this.controller, components);
            this.components.setAccessible(false);
        }
    }
}
