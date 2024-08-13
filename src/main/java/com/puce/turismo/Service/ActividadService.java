package com.puce.turismo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puce.turismo.Model.Actividad;
import com.puce.turismo.Repository.ActividadRepository;

@Service
public class ActividadService {
    
    @Autowired
    private ActividadRepository aRepository;

    public List<Actividad> findAll() {
        return aRepository.findAll();
    }

    public Actividad findById(String id) {
        return aRepository.findById(id).orElse(null);
    }

    public Actividad save(Actividad actividad) {
        return aRepository.save(actividad);
    }

    public void delete(String id) {
        aRepository.deleteById(id);
    }
}
