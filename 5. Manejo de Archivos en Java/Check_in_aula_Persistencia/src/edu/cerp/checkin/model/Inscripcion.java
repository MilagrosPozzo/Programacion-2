package edu.cerp.checkin.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Inscripcion {
    private String nombre;
    private String documento;
    private String curso;
    private String hora;

    // === Constructor usado al cargar desde archivo (hora ya dada) ===
    public Inscripcion(String nombre, String documento, String curso, String hora) {
        this.nombre = nombre;
        this.documento = documento;
        this.curso = curso;
        this.hora = hora;
    }

    // === Constructor para nuevo registro (hora automática) ===
    public Inscripcion(String nombre, String documento, String curso) {
        this(nombre, documento, curso, 
             LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))); 
        // Guarda solo hora, minutos y segundos
    }

    // === Getters ===
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getCurso() { return curso; }
    public String getHora() { return hora; }

    // === Representación en texto (para mostrar en consola o guardar) ===
    @Override
    public String toString() {
        return nombre + " | " + documento + " | " + curso + " | " + hora;
    }
}