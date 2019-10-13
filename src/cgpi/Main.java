package cgpi;

import cgpi.vtec.VFXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static cgpi.viw.enums.Scenes.MAIN;

/**
 * @author vitor.alves
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VFXMLLoader loader = new VFXMLLoader(MAIN);
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
