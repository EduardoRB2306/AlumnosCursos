package com.ejemplo.cursosalumnos.controller;

import com.ejemplo.cursosalumnos.model.Inscripcion;
import com.ejemplo.cursosalumnos.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping
    public Inscripcion crearInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.save(inscripcion);
    }

    @GetMapping
    public List<Inscripcion> obtenerInscripciones() {
        return inscripcionService.findAll();
    }

    @GetMapping("/{id}")
    public Inscripcion obtenerInscripcion(@PathVariable Long id) {
        return inscripcionService.findById(id);
    }

    @PutMapping("/{id}")
    public Inscripcion actualizarInscripcion(@PathVariable Long id, @RequestBody Inscripcion inscripcionDetalles) {
        Inscripcion inscripcion = inscripcionService.findById(id);
        if (inscripcion != null) {
            inscripcion.setAsistencia(inscripcionDetalles.getAsistencia());
            inscripcion.setCalificacion(inscripcionDetalles.getCalificacion());
            inscripcionService.evaluarAprobacion(inscripcion);
            return inscripcionService.save(inscripcion);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarInscripcion(@PathVariable Long id) {
        inscripcionService.deleteById(id);
    }
}