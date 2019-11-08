package cgpi.vtec;

import cgpi.controller.AbstractController;
import cgpi.view.enums.Scenes;
import cgpi.vtec.annotation.OnMouseClick;
import cgpi.vtec.events.AbstractDesenhoEvent;
import cgpi.vtec.events.EventFactory;
import cgpi.vtec.exception.VFXMLLoaderException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

    public void setParentController(AbstractController parentController) {
        controllerEntity.setParentController(parentController);
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

    private void buildController() throws Exception {
        this.controllerEntity.buildController();
    }

    private class ControllerEntity {

        private static final String CONTROLLER_FIELD = "components";

        private static final String PARENT_FIELD = "parent";

        private AbstractController controller;

        private AbstractController parentController;

        private Field componentsField;

        private Field parentField;

        public void setController(AbstractController controller) {
            this.controller = controller;
        }

        public void setParentController(AbstractController parentController) {
            this.parentController = parentController;
        }

        void create(AbstractController controller) throws NoSuchFieldException, VFXMLLoaderException {
            this.controller = controller;
            this.create();
        }

        private void create() throws NoSuchFieldException, VFXMLLoaderException {
            this.componentsField = this.getField(CONTROLLER_FIELD);
            this.parentField = this.getField(PARENT_FIELD);
        }

        public void buildController() throws Exception {
            Map<String, Node> components = new HashMap<>();
            Object value;
            for (Map.Entry<String, Object> entry : entries) {
                value = entry.getValue();
                if (value instanceof Node) {
                    components.put(entry.getKey(), (Node) value);
                }
            }

            this.setField(componentsField, controller, components);
            if (parentController != null) {
                this.setField(parentField, controller, parentController);
            }
            this.setUpController();
        }

        private Field getField(String fieldName) throws NoSuchFieldException, VFXMLLoaderException {
            Class<?> aClass = this.controller.getClass();
            Field field = null;
            while (field == null && aClass != null) {
                aClass = aClass.getSuperclass();
                if (aClass != null && containsFieldComponents(aClass)) {
                    field = aClass.getDeclaredField(fieldName);
                }
            }
            if (aClass == null) {
                throw new VFXMLLoaderException("No AbstractController instance controller.");
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

        private void setField(Field field, Object object, Object value) throws IllegalAccessException {
            field.setAccessible(true);
            field.set(object, value);
        }

        private void setUpController() throws Exception {
            Object model = controller.getModel();
            if (model != null) {
                for (Method method : model.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(OnMouseClick.class)) {
                        this.createEvent(method.getAnnotation(OnMouseClick.class), method);
                    }
                }
            }

            if (controller instanceof Inicializavel) {
                ((Inicializavel) controller).inicialize();
            }
        }

        private void createEvent(OnMouseClick annotation, Method method) throws Exception {
            EventFactory factory = new EventFactory();
            factory.getOnMouseClickEvent(annotation);
            controller.get(value).setOnMouseClicked(eventHandler);
        }
    }
}
