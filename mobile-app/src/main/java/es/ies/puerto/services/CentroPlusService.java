package es.ies.puerto.services;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.models.Incidencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Servicio con los datos en memoria de la app
 * 
 * @author diegoalegil
 * @version 1.0.0
 */
public class CentroPlusService {

    private final ObservableList<Actividad> actividades;
    private final ObservableList<Incidencia> incidencias;
    private int siguienteIdIncidencia;

    public CentroPlusService() {
        actividades = FXCollections.observableArrayList();
        incidencias = FXCollections.observableArrayList();
        siguienteIdIncidencia = 1;
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        actividades.add(new Actividad(1, "Yoga", "DEPORTIVA", 60, 25.5, 15, 8));
        actividades.add(new Actividad(2, "Programación Java", "ACADEMICA", 90, 40.0, 20, 12));
        actividades.add(new Actividad(3, "Spinning", "DEPORTIVA", 45, 18.0, 12, 12));
        actividades.add(new Actividad(4, "Inglés técnico", "ACADEMICA", 60, 30.0, 18, 6));
        actividades.add(new Actividad(5, "Sistemas Linux", "ACADEMICA", 120, 45.0, 16, 10));
    }

    public ObservableList<Actividad> getActividades() {
        return actividades;
    }

    public ObservableList<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void crearIncidencia(String asunto, String descripcion, String fecha) {

        if (asunto == null || asunto.isBlank() || descripcion == null || descripcion.isBlank()) {
            return;
        }
        Incidencia incidencia = new Incidencia(siguienteIdIncidencia, asunto, descripcion, fecha);
        incidencias.add(incidencia);
        siguienteIdIncidencia++;
    }

}
