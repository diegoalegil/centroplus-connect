package es.ies.puerto.models;

/**
 * Modelo de incidencia de la app
 * 
 * @author diegoalegil
 * @version 1.0.0
 */
public class Incidencia {

    private int id;
    private String asunto;
    private String descripcion;
    private String fecha;

    /**
     * Constructor con todos los campos
     * @param id identificador
     * @param asunto asunto corto
     * @param descripcion descripcion larga
     * @param fecha fecha como texto
     */
    public Incidencia(int id, String asunto, String descripcion, String fecha) {
        this.id = id;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return asunto + " - " + descripcion + " (" + fecha + ")";
    }

}
