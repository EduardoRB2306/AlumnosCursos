package com.ejemplo.cursosalumnos.service;

import com.ejemplo.cursosalumnos.model.Alumno;
import com.ejemplo.cursosalumnos.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }
}
