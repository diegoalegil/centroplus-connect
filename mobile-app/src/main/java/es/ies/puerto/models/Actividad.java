package es.ies.puerto.models;

/**
 * Modelo de actividad de la app
 * 
 * @author diegoalegil
 * @version 1.0.0
 */
public class Actividad {

    private int id;
    private String nombre;
    private String tipo;
    private int duracionMinutos;
    private double precio;
    private int plazasMaximas;
    private int plazasOcupadas;

    /**
     * Constructor con todos los campos
     * @param id identificador
     * @param nombre nombre
     * @param tipo tipo de actividad
     * @param duracionMinutos duracion en minutos
     * @param precio precio
     * @param plazasMaximas plazas maximas
     * @param plazasOcupadas plazas ocupadas
     */
    public Actividad(int id, String nombre, String tipo, int duracionMinutos, double precio, int plazasMaximas,
            int plazasOcupadas) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracionMinutos = duracionMinutos;
        this.precio = precio;
        this.plazasMaximas = plazasMaximas;
        this.plazasOcupadas = plazasOcupadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPlazasMaximas() {
        return plazasMaximas;
    }

    public void setPlazasMaximas(int plazasMaximas) {
        this.plazasMaximas = plazasMaximas;
    }

    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }

    public void setPlazasOcupadas(int plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    public int getPlazasDisponibles() {
        return plazasMaximas - plazasOcupadas;
    }

    public boolean hayPlazas() {
        return getPlazasDisponibles() > 0;
    }

    public void reservarPlaza() {
        plazasOcupadas++;
    }

    @Override
    public String toString() {
        return nombre + " - " + tipo + " - " + precio + " EUR (plazas libres: " + getPlazasDisponibles() + ")";
    }

}
