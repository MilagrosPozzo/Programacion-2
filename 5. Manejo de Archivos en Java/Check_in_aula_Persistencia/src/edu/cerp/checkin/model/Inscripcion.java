// Paquete correcto: debe coincidir con la carpeta donde está este archivo
package edu.cerp.checkin.model;

import java.time.LocalDateTime;

/**
 * Representa una inscripción (check-in) de un estudiante al inicio de clase.
 * 
 * Esta clase es inmutable: todos los atributos son final y no hay setters.
 * Esto garantiza que una vez creada, la inscripción no puede modificarse.
 */
public class Inscripcion {
    // === ATRIBUTOS (todos final = inmutables) ===
    private final String nombre; // Nombre del estudiante
    private final String documento; // Cédula o documento de identidad
    private final String curso; // "Prog 1" | "Prog 2" | "Base de Datos"
    private final LocalDateTime fechaHora; // Fecha y hora exacta del check-in

    // === CONSTRUCTOR ===
    /**
     * Crea una nueva inscripción con los datos proporcionados.
     * 
     * @param nombre nombre del estudiante
     * @param documento documento de identidad (puede estar vacío)
     * @param curso curso al que asiste
     * @param fechaHora fecha y hora del registro (si es null, usa la hora actual)
     */
    public Inscripcion(String nombre, String documento, String curso, LocalDateTime fechaHora) {
        this.nombre = nombre;
        this.documento = documento;
        this.curso = curso;
        // Asignar fecha/hora: si viene null, usar la hora actual del sistema
        // Esto es útil al cargar datos desde archivo (usa la hora guardada)
        // vs. crear nuevas inscripciones (usa la hora actual)
        this.fechaHora = (fechaHora != null) ? fechaHora : LocalDateTime.now();
    }
    
    // === GETTERS (solo lectura, sin setters = inmutabilidad) ===
    
    /**
     * @return nombre del estudiante
     */
    public String getNombre() { return nombre; }
    /**
     * @return documento de identidad del estudiante
     */
    public String getDocumento() { return documento; }
    /**
     * @return nombre del curso ("Prog 1", "Prog 2", o "Base de Datos")
     */
    public String getCurso() { return curso; }
    /**
     * @return fecha y hora exacta en que se realizó el check-in
     */
    public LocalDateTime getFechaHora() { return fechaHora; }
}