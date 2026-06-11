package es.ies.puerto.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.ies.puerto.models.Incidencia;

public class CentroPlusServiceTest {

    @Test
    public void actividadesInicialesTest() {
        CentroPlusService service = new CentroPlusService();
        assertEquals(5, service.getActividades().size());
    }

    @Test
    public void crearIncidenciaTest() {
        CentroPlusService service = new CentroPlusService();
        service.crearIncidencia("Prueba", "descripcion", "2026-06-01");
        assertEquals(1, service.getIncidencias().size());
    }

    @Test
    public void idsConsecutivosTest() {
        CentroPlusService service = new CentroPlusService();
        service.crearIncidencia("Primera", "primera incidencia", "2026-06-19");
        service.crearIncidencia("Segunda", "segunda incidencia", "2026-06-19");

        Incidencia segunda = service.getIncidencias().get(1);
        assertEquals(2, segunda.getId());
    }

    @Test
    public void crearIncidenciaAsuntoNullTest() {
        CentroPlusService service = new CentroPlusService();
        service.crearIncidencia(null, "descripcion", "2026-06-19");
        assertEquals(0, service.getIncidencias().size());
    }

}
