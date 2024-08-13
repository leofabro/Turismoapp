package com.puce.turismo.Controller;

import com.puce.turismo.Model.LugarTuristico;
import com.puce.turismo.Service.LugarTuristicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/v1/lugares")
public class LugarTuristicoController {

    @Autowired
    private LugarTuristicoService ltService;

    @GetMapping
    public List<LugarTuristico> getAll() {
        return ltService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LugarTuristico> getById(@PathVariable String id) {
        LugarTuristico lugar = ltService.findById(id);
        if (lugar != null) {
            return ResponseEntity.ok(lugar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public LugarTuristico create(@RequestBody LugarTuristico lugar) {
        return ltService.save(lugar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LugarTuristico> update(@PathVariable String id, @RequestBody LugarTuristico lugar) {
        if (ltService.findById(id) != null) {
            lugar.setId(id);
            return ResponseEntity.ok(ltService.save(lugar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (ltService.findById(id) != null) {
        ltService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/imagen")
    public ResponseEntity<String> uploadImage(@PathVariable String id, @RequestParam("file") MultipartFile file) {
        try {
            // Guardar archivo en el servidor (esto debe ser adaptado a tus necesidades)
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File imageFile = new File("/path/to/image/directory/" + fileName);
            file.transferTo(imageFile);

            // Actualizar la referencia de la imagen en la base de datos
            LugarTuristico lugar = ltService.findById(id);
            if (lugar != null) {
                lugar.setImagenes(fileName); // Asumimos que el campo 'imagenes' almacena el nombre del archivo
                ltService.save(lugar);
                return ResponseEntity.ok("Imagen subida con éxito");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen");
        }
    }
}