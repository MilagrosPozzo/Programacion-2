package edu.cerp.checkin.model;

import java.time.LocalDateTime;

/**
 * Representa una inscripción al inicio de clase.
 */
public class Inscripcion {
    private final String nombre;
    private final String documento;
    private final String curso; // "Prog 1" | "Prog 2" | "Base de Datos"
    private final LocalDateTime fechaHora;

    public Inscripcion(String nombre, String documento, String curso, LocalDateTime fechaHora) {
        this.nombre = nombre;
        this.documento = documento;
        this.curso = curso;
        // Usa la hora actual si no se pasa ninguna
        this.fechaHora = (fechaHora != null) ? fechaHora : LocalDateTime.now();
    }

    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getCurso() { return curso; }
    public LocalDateTime getFechaHora() { return fechaHora; }
}