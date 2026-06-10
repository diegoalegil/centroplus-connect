package es.ies.puerto.centroplus_connect.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.centroplus_connect.models.Incidencia;
import es.ies.puerto.centroplus_connect.services.IncidenciaService;

@RestController
@RequestMapping("/api/v1/incidencias")
public class IncidenciaController {

    private final IncidenciaService incidenciaService;

    public IncidenciaController(IncidenciaService incidenciaService) {
        this.incidenciaService = incidenciaService;
    }

    @GetMapping
    public List<Incidencia> listarTodas() {
        return incidenciaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Incidencia buscarPorId(@PathVariable Long id){
        return incidenciaService.buscarPorId(id);
    }

    @PostMapping
    public Incidencia crear (@RequestBody Incidencia incidencia){
        return incidenciaService.crear(incidencia);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable Long id){
        incidenciaService.eliminar(id);
    }

}
