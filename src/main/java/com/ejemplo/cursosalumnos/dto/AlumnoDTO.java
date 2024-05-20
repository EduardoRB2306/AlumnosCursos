package com.ejemplo.cursosalumnos.dto;

public class AlumnoDTO {
    private String nombre;
    private boolean aprobado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }
}
