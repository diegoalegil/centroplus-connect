package es.ies.puerto.models;

public class Incidencia {

    private int id;
    private String asunto;
    private String descripcion;
    private String fecha;

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

    



}
