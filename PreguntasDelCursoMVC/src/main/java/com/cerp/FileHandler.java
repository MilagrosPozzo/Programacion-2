/**
 * @file FileHandler.java
 * @brief Clase para manejar archivos de preguntas.
 * @date 20/03/2023
 * @version 1.1
 * @author Domingo Pérez
 */

package com.cerp;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @class FileHandler
 * @brief Clase genérica para manejar archivos de objetos serializados.
 * @param <T> Tipo de datos que se almacenará en el archivo.
 */
public class FileHandler<T> {

    private final String filename; // Se usa final ya que no cambia después de inicializarse.

    /**
     * Constructor de la clase FileHandler.
     * @param filename Nombre del archivo a manejar.
     */
    public FileHandler(String filename) {
        // Si la ruta es absoluta, se usa tal cual; si es relativa, se añade la carpeta "resources".
        Path path = Paths.get(filename);
        if (path.isAbsolute()) {
            this.filename = filename;
        } else {
            this.filename = Paths.get("src", "main", "resources", filename).toString();
        }
        // 🔍 Imprime la ruta exacta para verificar
    System.out.println("Ruta del archivo: " + new File(this.filename).getAbsolutePath());
}
   

    /**
     * Lee los objetos almacenados en el archivo.
     * @return Una lista de objetos de tipo T.
     * @throws IOException Si ocurre un error de entrada/salida.
     * @throws ClassNotFoundException Si la clase de algún objeto serializado no puede ser encontrada.
     */
    @SuppressWarnings("unchecked")
    public List<T> fileToList() throws IOException, ClassNotFoundException {
        File file = new File(filename);
        
        // Si el archivo no existe, se retorna una lista vacía en lugar de lanzar error.
        if (!file.exists()) {
            return new ArrayList<>();
        }

        // Se usa try-with-resources para evitar fugas de memoria.
        try (FileInputStream fileInputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            return (List<T>) objectInputStream.readObject();
        }
    }

    /**
     * Escribe una lista de objetos en el archivo.
     * @param miLista La lista de objetos a escribir.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void listToFile(List<T> miLista) throws IOException {
        // try-with-resources para evitar fugas de memoria
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(miLista);
        }
    }

    /**
     * Limpia el contenido del archivo, dejándolo vacío.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void limpiarArchivo() throws IOException {
        // Se abre en modo de sobrescritura sin escribir nada.
        try (FileWriter fileWriter = new FileWriter(filename, false)) {
              fileWriter.write(""); // Deja el archivo vacío
            // No se escribe nada para que el archivo quede vacío.
        }
    }
}