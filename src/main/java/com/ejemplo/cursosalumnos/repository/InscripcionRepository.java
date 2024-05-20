package com.ejemplo.cursosalumnos.repository;

import com.ejemplo.cursosalumnos.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {}
