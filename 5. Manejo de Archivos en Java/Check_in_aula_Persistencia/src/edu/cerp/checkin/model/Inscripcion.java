package edu.cerp.checkin.model;

public class Inscripcion {
    private String nombre;
    private String documento;
    private String curso;
    private String hora;

    // Constructor usado al cargar desde archivo (hora ya dada)
    public Inscripcion(String nombre, String documento, String curso, String hora) {
        this.nombre = nombre;
        this.documento = documento;
        this.curso = curso;
        this.hora = hora;
    }

    // Constructor para nuevo registro (hora automática)
    public Inscripcion(String nombre, String documento, String curso) {
        this(nombre, documento, curso, java.time.LocalTime.now().toString());
    }

    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getCurso() { return curso; }
    public String getHora() { return hora; }

    @Override
    public String toString() {
        return nombre + " | " + documento + " | " + curso + " | " + hora;
    }
}