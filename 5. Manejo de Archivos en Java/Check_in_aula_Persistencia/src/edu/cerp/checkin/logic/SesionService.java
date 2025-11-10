// Paquete correcto: debe coincidir con la carpeta donde está este archivo
package edu.cerp.checkin.logic;

import edu.cerp.checkin.model.Inscripcion;
import edu.cerp.checkin.persistencia.ArchivoManager;  // Maneja la lectura/escritura del archivo

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/** Lógica mínima con persistencia integrada. */
/**
 * Servicio central que gestiona la lógica de negocio del sistema Check-in Aula.
 * Mantiene la lista de inscripciones en memoria y sincroniza con archivo.
 */
public class SesionService {
    // === ATRIBUTO PRINCIPAL ===
    private final List<Inscripcion> inscripciones = new ArrayList<>();

    // === CONSTRUCTOR ===
    // Carga automáticamente los datos guardados al iniciar el servicio
    public SesionService() {
        inscripciones.addAll(ArchivoManager.cargar());
    }
    // === REGISTRAR NUEVA INSCRIPCIÓN ===
    /**
     * Registra una nueva inscripción con validaciones básicas.
     * Guarda automáticamente los cambios en el archivo.
     */
    public void registrar(String nombre, String documento, String curso) {
        // Validación: si nombre está vacío o es null, usar valor por defecto
        if (nombre == null || nombre.isBlank()) nombre = "(sin nombre)";
        // Validación: si documento es null, usar string vacío
        if (documento == null) documento = "";
        // Validación: si curso está vacío o es null, asignar "Prog 1" por defecto
        if (curso == null || curso.isBlank()) curso = "Prog 1";
        // Crear y agregar la nueva inscripción con la fecha/hora actual
        inscripciones.add(new Inscripcion(nombre.trim(), documento.trim(), curso.trim(), LocalDateTime.now()));

        // Persistir cambios: guarda toda la lista actualizada en el archivo
        ArchivoManager.guardar(inscripciones);
    }

    // === LISTAR TODAS LAS INSCRIPCIONES ===
    /**
     * Retorna una lista inmutable de todas las inscripciones.
     * Usar lista inmutable previene modificaciones accidentales desde fuera del servicio.
     */
    public List<Inscripcion> listar() { return Collections.unmodifiableList(inscripciones); }

    // === BUSCAR INSCRIPCIONES ===
    /**
     * Busca inscripciones por nombre o documento (búsqueda parcial, case-insensitive).
     * @param q texto a buscar
     * @return lista filtrada de inscripciones que coinciden con la búsqueda
     */
    public List<Inscripcion> buscar(String q) {
        // Si no hay texto de búsqueda, retornar todas las inscripciones
        if (q == null || q.isBlank()) return listar();
        // Convertir a minúsculas para búsqueda case-insensitive
        String s = q.toLowerCase();
        // Filtrar usando Streams: busca en nombre Y documento
        return inscripciones.stream()
                .filter(i -> i.getNombre().toLowerCase().contains(s) || i.getDocumento().toLowerCase().contains(s))
                .collect(Collectors.toList());
    }
    // === GENERAR RESUMEN POR CURSO ===
    /**
     * Genera un resumen estadístico agrupando inscripciones por curso.
     * @return string formateado con total general y cantidad por cada curso
     */
    public String resumen() {
        // Agrupar por curso y contar inscripciones de cada uno
        // LinkedHashMap mantiene el orden de inserción
        Map<String, Long> porCurso = inscripciones.stream()
                .collect(Collectors.groupingBy(
                        Inscripcion::getCurso, // agrupa por curso
                        LinkedHashMap::new, // mantiene orden
                        Collectors.counting())); // cuenta elementos
        // Construir el texto del resumen
        StringBuilder sb = new StringBuilder();
        sb.append("Total: ").append(inscripciones.size()).append("\nPor curso:\n");
        // Agregar cada curso con su cantidad
        for (var e : porCurso.entrySet()) sb.append(" - ").append(e.getKey()).append(": ").append(e.getValue()).append("\n");
        return sb.toString();
    }

    // === CARGAR DATOS DE DEMOSTRACIÓN ===
    /**
     * Carga datos de prueba SOLO si no existen inscripciones guardadas.
     * Útil para demostrar el sistema sin necesidad de ingresar datos manualmente.
     */
    public void cargarDatosDemo() {
        if (inscripciones.isEmpty()) {  // solo si no hay datos guardados
            registrar("Ana Pérez", "51234567", "Prog 2");
            registrar("Luis Gómez", "49887766", "Prog 1");
            registrar("Camila Díaz", "53422110", "Base de Datos");
        }
    }
}