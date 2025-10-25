/*
 * PROBLEMA 945 – Borrar registros de un archivo en Java
 *
 * Descripción:
 * En Java, no se pueden eliminar bytes directamente del medio de un archivo.
 * La forma más simple de “borrar registros” es:
 *  Leer todo el contenido del archivo.
 *  Filtrar (ignorar) los registros que se quieren eliminar.
 *  Reescribir el archivo solo con los registros que se desean conservar.
 *
 * Este ejemplo trabaja con un archivo de texto simple llamado "registros.txt"
 * donde cada línea representa un registro.
 */
// Esto trae las herramientas necesarias para trabajar con archivos
import java.io.*;

// Esto trae las herramientas para usar listas (ArrayList)
import java.util.*;

// Aquí empieza nuestra clase principal
public class Problema_945 {
    
    // Aquí empieza el método main, donde comienza a ejecutarse el programa
    public static void main(String[] args) {
        
        // Guardamos el nombre del archivo con el que vamos a trabajar
        String nombreArchivo = "registros.txt";
        
        // Guardamos el texto que queremos eliminar del archivo
        String registroAEliminar = "BorrarEste";
        
        // try significa "intenta hacer esto", se usa porque trabajar con archivos puede dar errores
        try {
            
            // Creamos una lista vacía donde guardaremos las líneas que queremos conservar
            List<String> lineas = new ArrayList<>();
            
            // BufferedReader es una herramienta que lee el archivo línea por línea
            // FileReader abre el archivo
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            
            // Creamos una variable donde guardaremos cada línea que leamos
            String linea;
            
            // Este while lee el archivo línea por línea hasta que se termina
            // readLine() lee una línea y cuando se acaba el archivo devuelve null
            while ((linea = lector.readLine()) != null) {
                
                // Preguntamos: ¿esta línea es diferente a la que queremos eliminar?
                // equalsIgnoreCase compara textos sin importar mayúsculas o minúsculas
                if (!linea.equalsIgnoreCase(registroAEliminar)) {
                    // Si es diferente, la agregamos a nuestra lista
                    lineas.add(linea);
                }
                // Si la línea SÍ es igual a "BorrarEste", no hace nada, la ignora
            }
            
            // Cerramos el lector porque ya terminamos de leer
            lector.close();
            
            // Ahora vamos a escribir de nuevo en el archivo, pero solo con las líneas que guardamos
            // BufferedWriter es una herramienta para escribir en archivos
            // FileWriter abre el archivo, el "false" significa que va a borrar lo que había antes
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, false));
            
            // Recorremos todas las líneas que guardamos en la lista
            for (String nuevaLinea : lineas) {
                // Escribimos cada línea en el archivo
                escritor.write(nuevaLinea);
                // Agregamos un salto de línea para que cada registro quede en su propia línea
                escritor.newLine();
            }
            
            // Cerramos el escritor para guardar los cambios
            escritor.close();
            
            // Mostramos un mensaje de que todo salió bien
            System.out.println("Archivo actualizado correctamente.");
            System.out.println("Se eliminaron las líneas que contenían: " + registroAEliminar);
            
        // catch atrapa los errores que puedan ocurrir
        } catch (IOException e) {
            // Si hay un error (archivo no existe, no hay permisos, etc.), mostramos el mensaje
            System.out.println("Ocurrió un error al procesar el archivo: " + e.getMessage());
        }
    }
}