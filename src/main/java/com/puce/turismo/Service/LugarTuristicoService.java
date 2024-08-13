package com.puce.turismo.Service;

import com.puce.turismo.Model.LugarTuristico;
import com.puce.turismo.Repository.LugarTuristicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarTuristicoService {

    @Autowired
    private LugarTuristicoRepository ltRepository;

    public List<LugarTuristico> findAll() {
        return ltRepository.findAll();
    }

    public LugarTuristico findById(String id) {
        return ltRepository.findById(id).orElse(null);
    }

    public LugarTuristico save(LugarTuristico lugarTuristico) {
        return ltRepository.save(lugarTuristico);
    }

    public void delete(String id) {
        ltRepository.deleteById(id);
    }
    
}