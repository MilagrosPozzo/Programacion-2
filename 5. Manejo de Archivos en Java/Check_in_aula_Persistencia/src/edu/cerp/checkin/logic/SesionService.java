package edu.cerp.checkin.logic;

import edu.cerp.checkin.model.Inscripcion;

import java.util.*;
import java.util.stream.Collectors;

/** Lógica mínima en memoria (sin validaciones complejas). */
public class SesionService {
    private final List<Inscripcion> inscripciones = new ArrayList<>();

    // === Constructor ===
    public SesionService() {
        // Al iniciar, podrías cargar datos desde archivo si tenés persistencia (versión futura)
    }

    // === Registrar una nueva inscripción ===
    public void registrar(String nombre, String documento, String curso) {
        if (nombre == null || nombre.isBlank()) nombre = "(sin nombre)";
        if (documento == null) documento = "";
        if (curso == null || curso.isBlank()) curso = "Prog 1";

        // Crea una nueva inscripción con hora automática
        inscripciones.add(new Inscripcion(nombre.trim(), documento.trim(), curso.trim()));
    }

    // === Listar todas las inscripciones ===
    public List<Inscripcion> listar() {
        return Collections.unmodifiableList(inscripciones);
    }

    // === Buscar por texto (en nombre o documento) ===
    public List<Inscripcion> buscar(String q) {
        if (q == null || q.isBlank()) return listar();
        String s = q.toLowerCase();
        return inscripciones.stream()
                .filter(i -> i.getNombre().toLowerCase().contains(s) 
                          || i.getDocumento().toLowerCase().contains(s))
                .collect(Collectors.toList());
    }

    // === Mostrar resumen por curso ===
    public String resumen() {
        Map<String, Long> porCurso = inscripciones.stream()
                .collect(Collectors.groupingBy(Inscripcion::getCurso, LinkedHashMap::new, Collectors.counting()));
        StringBuilder sb = new StringBuilder();
        sb.append("Total: ").append(inscripciones.size()).append("\nPor curso:\n");
        for (var e : porCurso.entrySet()) {
            sb.append(" - ").append(e.getKey()).append(": ").append(e.getValue()).append("\n");
        }
        return sb.toString();
    }

    // === Cargar datos de prueba ===
    public void cargarDatosDemo() {
        registrar("Ana Pérez", "51234567", "Prog 2");
        registrar("Luis Gómez", "49887766", "Prog 1");
        registrar("Camila Díaz", "53422110", "Base de Datos");
    }
}