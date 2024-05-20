package com.ejemplo.cursosalumnos.controller;

import com.ejemplo.cursosalumnos.dto.CursoDTO;
import com.ejemplo.cursosalumnos.model.Curso;
import com.ejemplo.cursosalumnos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @GetMapping
    public List<Curso> obtenerCursos() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerCurso(@PathVariable Long id) {
        CursoDTO curso = cursoService.getCursoDetails(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso cursoDetalles) {
        Curso curso = cursoService.findById(id);
        if (curso != null) {
            curso.setNombre(cursoDetalles.getNombre());
            curso.setTipo(cursoDetalles.getTipo());
            return cursoService.save(curso);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable Long id) {
        cursoService.deleteById(id);
    }

}
