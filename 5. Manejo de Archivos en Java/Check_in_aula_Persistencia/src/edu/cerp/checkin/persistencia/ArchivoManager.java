package edu.cerp.checkin.persistencia;

import edu.cerp.checkin.model.Inscripcion;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Maneja el guardado y la carga de inscripciones desde un archivo CSV.
 * Formato de cada línea:
 * nombre|documento|curso|fechaHora
 */
public class ArchivoManager {
    // 📂 Ruta relativa (usa la carpeta "data" del proyecto)
    private static final String RUTA_ARCHIVO = "data/inscripciones.csv";

    /**
     * Guarda una lista completa de inscripciones en el archivo CSV.
     */
    public static void guardar(List<Inscripcion> inscripciones) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (Inscripcion i : inscripciones) {
                pw.println(i.getNombre() + "|" +
                           i.getDocumento() + "|" +
                           i.getCurso() + "|" +
                           i.getFechaHora());
            }
        } catch (IOException e) {
            System.err.println("⚠ Error al guardar inscripciones: " + e.getMessage());
        }
    }

    /**
     * Carga las inscripciones previamente guardadas desde el archivo CSV.
     */
    public static List<Inscripcion> cargar() {
        List<Inscripcion> lista = new ArrayList<>();
        File archivo = new File(RUTA_ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("(ℹ) No se encontró archivo previo, se creará uno nuevo al guardar.");
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 4) {
                    String nombre = partes[0];
                    String documento = partes[1];
                    String curso = partes[2];
                    LocalDateTime fechaHora = LocalDateTime.parse(partes[3]);
                    lista.add(new Inscripcion(nombre, documento, curso, fechaHora));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
        return lista;
    }
}