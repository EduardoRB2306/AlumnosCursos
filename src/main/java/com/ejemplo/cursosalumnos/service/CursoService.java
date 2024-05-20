package com.ejemplo.cursosalumnos.service;

import com.ejemplo.cursosalumnos.dto.AlumnoDTO;
import com.ejemplo.cursosalumnos.dto.CursoDTO;
import com.ejemplo.cursosalumnos.model.Curso;
import com.ejemplo.cursosalumnos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
    public CursoDTO getCursoDetails(Long id) {
        Curso curso = findById(id);
        if (curso == null) {
            return null;
        }

        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setNombre(curso.getNombre());
        cursoDTO.setTipo(curso.getTipo());
        cursoDTO.setAlumnos(curso.getInscripciones().stream()
                .map(inscripcion -> {
                    AlumnoDTO alumnoDTO = new AlumnoDTO();
                    alumnoDTO.setNombre(inscripcion.getAlumno().getNombre());
                    alumnoDTO.setAprobado(inscripcion.getAprobado());
                    return alumnoDTO;
                })
                .collect(Collectors.toList())
        );

        return cursoDTO;
    }
}
