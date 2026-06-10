package es.ies.puerto.centroplus_connect.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ies.puerto.centroplus_connect.models.Incidencia;
import es.ies.puerto.centroplus_connect.repositories.IncidenciaRepository;

@Service
public class IncidenciaService {

    private final IncidenciaRepository incidenciaRepository;

    public IncidenciaService(IncidenciaRepository incidenciaRepository){
        this.incidenciaRepository = incidenciaRepository;
    }

    public List<Incidencia> listarTodas(){
        return incidenciaRepository.findAll();
    }

    // devuelve null si no existe
    public Incidencia buscarPorId (Long id){
        return incidenciaRepository.findById(id).orElse(null);
    }

    public Incidencia crear (Incidencia incidencia){
        return incidenciaRepository.save(incidencia);
    }

    public void eliminar (Long id){
        incidenciaRepository.deleteById(id);
    }

}
