// Paquete correcto: debe coincidir con la carpeta donde está este archivo
package edu.cerp.checkin.persistencia;

import edu.cerp.checkin.model.Inscripcion;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Maneja la persistencia de inscripciones usando un archivo CSV simple.
 * 
 * Formato de cada línea del archivo:
 * nombre|documento|curso|fechaHora
 * 
 * Ejemplo:
 * Ana Pérez|51234567|Prog 2|2025-11-10T14:30:00
 */
public class ArchivoManager {
    // === CONFIGURACIÓN ===
    // Ruta relativa al archivo CSV (se crea automáticamente si no existe)
    // La carpeta "data" debe estar en la raíz del proyecto
    private static final String RUTA_ARCHIVO = "data/inscripciones.csv";

    // === GUARDAR INSCRIPCIONES ===
    /**
     * Guarda una lista completa de inscripciones en el archivo CSV.
     * IMPORTANTE: Sobrescribe el archivo completo (no agrega, reemplaza).
     * 
     * @param inscripciones lista de inscripciones a guardar
     */
    public static void guardar(List<Inscripcion> inscripciones) {
        // try-with-resources: cierra automáticamente el PrintWriter al terminar
        try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            // Recorrer cada inscripción y escribir una línea en el archivo
            for (Inscripcion i : inscripciones) {
                // Formato CSV usando "|" como separador (pipe)
                pw.println(i.getNombre() + "|" +
                           i.getDocumento() + "|" +
                           i.getCurso() + "|" +
                           i.getFechaHora()); // LocalDateTime se convierte automáticamente a String ISO-8601
            }
        } catch (IOException e) {
            // Manejo de errores: mostrar mensaje pero no detener el programa
            System.err.println("Error al guardar inscripciones: " + e.getMessage());
        }
    }

    // === CARGAR INSCRIPCIONES ===
    /**
     * Carga las inscripciones previamente guardadas desde el archivo CSV.
     * Si el archivo no existe, retorna una lista vacía (sin error).
     * 
     * @return lista de inscripciones cargadas (vacía si no hay archivo)
     */
    public static List<Inscripcion> cargar() {
        List<Inscripcion> lista = new ArrayList<>();
        File archivo = new File(RUTA_ARCHIVO);
        // Verificar si el archivo existe antes de intentar leerlo
        if (!archivo.exists()) {
            System.out.println("(ℹ) No se encontró archivo previo, se creará uno nuevo al guardar.");
            return lista; // Retornar lista vacía (no es un error)
        }
        
        // try-with-resources: cierra automáticamente el BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Dividir la línea usando "|" como separador
                String[] partes = linea.split("\\|"); // \\ escape necesario para regex
                
                // Validar que la línea tenga exactamente 4 campos
                if (partes.length == 4) {
                    // Extraer cada campo
                    String nombre = partes[0];
                    String documento = partes[1];
                    String curso = partes[2];
                    // Parsear la fecha/hora desde formato ISO-8601
                    LocalDateTime fechaHora = LocalDateTime.parse(partes[3]);
                    // Crear y agregar la inscripción reconstruida
                    lista.add(new Inscripcion(nombre, documento, curso, fechaHora));
                }
                // Si una línea está mal formateada, simplemente se ignora (no rompe la carga)
            }
        } catch (IOException e) {
            // Manejo de errores de lectura
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
        return lista; // Retornar la lista cargada (puede estar vacía si hubo errores)
    }
}