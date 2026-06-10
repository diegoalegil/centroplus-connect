package es.ies.puerto.centroplus_connect.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ies.puerto.centroplus_connect.models.Actividad;
import es.ies.puerto.centroplus_connect.repositories.ActividadRepository;

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService(ActividadRepository actividadRepository){
        this.actividadRepository = actividadRepository;
    }

    public List<Actividad> listarTodas(){
        return actividadRepository.findAll();
    }

    public Actividad buscarPorId (Long id){
        return actividadRepository.findById(id).orElse(null);
    }

    public Actividad crear (Actividad actividad){
        return actividadRepository.save(actividad);
    }

    public void eliminar (Long id){
        actividadRepository.deleteById(id);
    }

}
