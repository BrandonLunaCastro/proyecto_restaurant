package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.PlatoView;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        PlatoView view = new PlatoView();
        Scene scene = new Scene(view.getRoot(), 700, 500);
        stage.setTitle("Gestión de Platos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}