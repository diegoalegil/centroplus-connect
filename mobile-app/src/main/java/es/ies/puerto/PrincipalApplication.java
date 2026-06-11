package es.ies.puerto;

import es.ies.puerto.controllers.MainController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase que crea la ventana de la aplicacion
 * 
 * @author diegoalegil
 * @version 1.0.0
 */
public class PrincipalApplication extends Application {

    @Override
    public void start(Stage stage) {
        MainController mainController = new MainController();
        Scene scene = new Scene(mainController.getRoot(), 390, 760);
        scene.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
        stage.setTitle("CentroPlus Mobile");
        stage.setScene(scene);
        stage.setMinWidth(360);
        stage.setMinHeight(640);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
