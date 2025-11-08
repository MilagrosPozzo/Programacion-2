package edu.cerp.checkin.persistencia;

import edu.cerp.checkin.model.Inscripcion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoManager {

    private static final String RUTA_ARCHIVO = "data/inscripciones.csv";

    // Guarda todas las inscripciones (sobrescribe el archivo)
    public static void guardar(List<Inscripcion> inscripciones) {
        File carpeta = new File("data");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (Inscripcion i : inscripciones) {
                // separador ';' para evitar problemas con comas
                pw.println(i.getNombre() + ";" + i.getDocumento() + ";" + i.getCurso() + ";" + i.getHora());
            }
        } catch (IOException e) {
            System.err.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    // Carga inscripciones desde archivo
    public static List<Inscripcion> cargar() {
        List<Inscripcion> lista = new ArrayList<>();
        File archivo = new File(RUTA_ARCHIVO);
        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    Inscripcion i = new Inscripcion(partes[0], partes[1], partes[2], partes[3]);
                    lista.add(i);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar archivo: " + e.getMessage());
        }
        return lista;
    }
}