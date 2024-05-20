package com.ejemplo.cursosalumnos.repository;

import com.ejemplo.cursosalumnos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {}
