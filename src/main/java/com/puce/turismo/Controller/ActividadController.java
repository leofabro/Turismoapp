package com.puce.turismo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puce.turismo.Model.Actividad;
import com.puce.turismo.Service.ActividadService;

@RestController
@RequestMapping("/v1/actividad")
public class ActividadController {

    @Autowired
    private ActividadService aService;

    @GetMapping
    public List<Actividad> getAll() {
        return aService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> getById(@PathVariable String id) {
        Actividad actividad = aService.findById(id);
        if (actividad != null) {
            return ResponseEntity.ok(actividad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Actividad create(@RequestBody Actividad actividad) {
        return aService.save(actividad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actividad> update(@PathVariable String id, @RequestBody Actividad actividad) {
        if (aService.findById(id) != null) {
            actividad.setIdA(id);
            return ResponseEntity.ok(aService.save(actividad));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (aService.findById(id) != null) {
            aService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
