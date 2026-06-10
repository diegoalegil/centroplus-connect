package es.ies.puerto.controllers;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.services.CentroPlusService;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MainController {

    private final CentroPlusService service;
    private final BorderPane root;

    public MainController() {
        service = new CentroPlusService();
        root = new BorderPane();
        root.getStyleClass().add("app-root");
        root.setTop(crearHeader());
        root.setBottom(crearNavBar());
        mostrarActividades();
    }

    private VBox crearHeader() {
        Label titulo = new Label("CentroPlus");
        titulo.getStyleClass().add("app-title");
        Label subtitulo = new Label("Centro de actividades");
        subtitulo.getStyleClass().add("app-subtitle");
        VBox header = new VBox(titulo, subtitulo);
        header.getStyleClass().add("header");
        header.setPadding(new Insets(20));
        return header;
    }

    private HBox crearNavBar() {
        Button btnActividades = new Button("Actividades");
        btnActividades.setOnAction(e -> mostrarActividades());
        Button btnIncidencias = new Button("Incidencias");
        btnIncidencias.setOnAction(e -> mostrarIncidencias());

        HBox navBar = new HBox(btnActividades, btnIncidencias);
        navBar.getStyleClass().add("nav-bar");
        navBar.setSpacing(10);
        navBar.setPadding(new Insets(10));
        navBar.setAlignment(Pos.CENTER);
        return navBar;
    }

    private void mostrarActividades() {
        Label seccion = new Label("Actividades");
        seccion.getStyleClass().add("section-title");

        ListView<Actividad> lista = new ListView<>(service.getActividades());

        Button reservar = new Button("Reservar plaza");
        reservar.getStyleClass().add("primary-button");
        reservar.setMaxWidth(Double.MAX_VALUE);
        reservar.setOnAction(e -> {
            Actividad seleccionada = lista.getSelectionModel().getSelectedItem();
            if (seleccionada == null) {
                mostrarAviso("Selecciona una actividad de la lista.");
            } else if (!seleccionada.hayPlazas()) {
                mostrarAviso("No quedan plazas en " + seleccionada.getNombre() + ".");
            } else {
                seleccionada.reservarPlaza();
                lista.refresh();
                mostrarAviso("Plaza reservada en " + seleccionada.getNombre() + ".");
            }
        });

        VBox vista = new VBox(seccion, lista, reservar);
        vista.setSpacing(10);
        vista.setPadding(new Insets(15));
        VBox.setVgrow(lista, Priority.ALWAYS);
        root.setCenter(vista);
    }

    private void mostrarIncidencias() {
        Label seccion = new Label("Incidencias");
        seccion.getStyleClass().add("section-title");
        Label texto = new Label("Aquí irá el formulario de incidencias.");
        VBox vista = new VBox(seccion, texto);
        vista.setSpacing(10);
        vista.setPadding(new Insets(15));
        root.setCenter(vista);
    }

    private void mostrarAviso(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public Parent getRoot() {
        return root;
    }
}