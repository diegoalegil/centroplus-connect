package es.ies.puerto.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class ActividadTest {

    @Test
    public void getPlazasDisponiblesTest() {
        Actividad actividad = new Actividad(1, "Yoga", "DEPORTIVA", 60, 25.5, 15, 8);
        assertEquals(7, actividad.getPlazasDisponibles());
    }

    @Test
    public void hayPlazasTest() {
        Actividad llena = new Actividad(3, "Spinning", "DEPORTIVA", 45, 18.0, 12, 12);
        assertFalse(llena.hayPlazas());
    }

    @Test
    public void reservarPlazaTest() {
        Actividad actividad = new Actividad(1, "Yoga", "DEPORTIVA", 60, 25.5, 15, 8);
        actividad.reservarPlaza();
        assertEquals(9, actividad.getPlazasOcupadas());
    }

}
