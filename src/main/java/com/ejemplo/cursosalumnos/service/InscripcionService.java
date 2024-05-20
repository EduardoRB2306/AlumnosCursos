package com.ejemplo.cursosalumnos.service;

import com.ejemplo.cursosalumnos.model.Alumno;
import com.ejemplo.cursosalumnos.model.Curso;
import com.ejemplo.cursosalumnos.model.Inscripcion;
import com.ejemplo.cursosalumnos.repository.AlumnoRepository;
import com.ejemplo.cursosalumnos.repository.CursoRepository;
import com.ejemplo.cursosalumnos.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Inscripcion save(Inscripcion inscripcion) {
        if (inscripcion.getAlumno() == null || inscripcion.getCurso() == null) {
            throw new IllegalArgumentException("Alumno y Curso no debe estar vacio");
        }

        Alumno alumno = alumnoRepository.findById(inscripcion.getAlumno().getId())
                .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));

        Curso curso = cursoRepository.findById(inscripcion.getCurso().getId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        inscripcion.setAlumno(alumno);
        inscripcion.setCurso(curso);

        evaluarAprobacion(inscripcion);

        return inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> findAll() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion findById(Long id) {
        return inscripcionRepository.findById(id).orElse(null);
    }

    public Inscripcion update(Long id, Inscripcion inscripcionDetalles) {
        Inscripcion inscripcion = findById(id);
        if (inscripcion != null) {
            inscripcion.setAsistencia(inscripcionDetalles.getAsistencia());
            inscripcion.setCalificacion(inscripcionDetalles.getCalificacion());
            evaluarAprobacion(inscripcion);
            return inscripcionRepository.save(inscripcion);
        }
        return null;
    }

    public void deleteById(Long id) {
        inscripcionRepository.deleteById(id);
    }

    public void evaluarAprobacion(Inscripcion inscripcion) {
        String tipoCurso = inscripcion.getCurso().getTipo();
        boolean aprobado = false;
        if (tipoCurso.equals("asistencia")) {
            aprobado = inscripcion.getAsistencia() >= 80;
        } else if (tipoCurso.equals("calificacion")) {
            aprobado = inscripcion.getCalificacion() >= 7;
        } else if (tipoCurso.equals("mixto")) {
            aprobado = inscripcion.getAsistencia() >= 80 && inscripcion.getCalificacion() >= 7;
        }
        inscripcion.setAprobado(aprobado);
        inscripcionRepository.save(inscripcion);
    }
}
