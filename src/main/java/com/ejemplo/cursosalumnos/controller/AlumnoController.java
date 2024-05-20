package com.ejemplo.cursosalumnos.controller;

import com.ejemplo.cursosalumnos.model.Alumno;
import com.ejemplo.cursosalumnos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @GetMapping
    public List<Alumno> obtenerAlumnos() {
        return alumnoService.findAll();
    }

    @GetMapping("/{id}")
    public Alumno obtenerAlumno(@PathVariable Long id) {
        return alumnoService.findById(id);
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetalles) {
        Alumno alumno = alumnoService.findById(id);
        if (alumno != null) {
            alumno.setNombre(alumnoDetalles.getNombre());
            return alumnoService.save(alumno);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Long id) {
        alumnoService.deleteById(id);
    }
}
