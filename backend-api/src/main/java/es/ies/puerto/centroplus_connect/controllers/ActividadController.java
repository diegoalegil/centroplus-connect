package es.ies.puerto.centroplus_connect.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.centroplus_connect.models.Actividad;
import es.ies.puerto.centroplus_connect.services.ActividadService;

@RestController
@RequestMapping("/api/v1/actividades")
public class ActividadController {


    private final ActividadService actividadService;

    public ActividadController(ActividadService actividadService){
        this.actividadService = actividadService;
    }

    @GetMapping
    public List<Actividad> listarTodas(){
        return actividadService.listarTodas();
    }

    @GetMapping("/{id}")
    public Actividad buscarPorId (@PathVariable Long id){
        return actividadService.buscarPorId(id);
    }

    @PostMapping
    public Actividad crear (@RequestBody Actividad actividad){
        return actividadService.crear(actividad);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable Long id){
        actividadService.eliminar(id);
    }
}
