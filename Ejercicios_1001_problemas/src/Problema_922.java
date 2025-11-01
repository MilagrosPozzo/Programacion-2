// Importamos las clases necesarias para trabajar con archivos
import java.io.FileInputStream;    // Para leer archivos secuencialmente
import java.io.RandomAccessFile;   // Para leer/escribir con acceso aleatorio
import java.io.IOException;        // Para manejar errores de entrada/salida

public class Problema_922 {
    public static void main(String[] args) {
        // Definimos la ruta del archivo que vamos a usar
        String ruta = "archivo.txt"; // coloca archivo.txt en la carpeta del proyecto o usa ruta absoluta
        
        // Iniciamos un bloque try-catch para manejar posibles errores
        try {
            // EJEMPLO 1: FileInputStream - solo lectura
            // try-with-resources: cierra automáticamente el archivo al terminar
            try (FileInputStream fis = new FileInputStream(ruta)) {
                System.out.println("Abierto con FileInputStream (solo lectura).");
            } // El archivo se cierra automáticamente aquí
            
            // EJEMPLO 2: RandomAccessFile modo "r" - solo lectura
            // "r" = read only (solo lectura)
            try (RandomAccessFile rafR = new RandomAccessFile(ruta, "r")) {
                System.out.println("Abierto con RandomAccessFile modo \"r\" (solo lectura).");
            } // Se cierra automáticamente
            
            // EJEMPLO 3: RandomAccessFile modo "rw" - lectura y escritura
            // "rw" = read-write (leer y escribir)
            try (RandomAccessFile rafRW = new RandomAccessFile(ruta, "rw")) {
                System.out.println("Abierto con RandomAccessFile modo \"rw\" (lectura/escritura).");
            } // Se cierra automáticamente
            
            // EJEMPLO 4: RandomAccessFile modo "rws" - lectura, escritura y sincronización completa
            // "rws" = read-write-sync: guarda inmediatamente contenido Y metadatos
            try (RandomAccessFile rafRWS = new RandomAccessFile(ruta, "rws")) {
                System.out.println("Abierto con RandomAccessFile modo \"rws\" (sync completa).");
            } // Se cierra automáticamente
            
            // EJEMPLO 5: RandomAccessFile modo "rwd" - lectura, escritura y sincronización de datos
            // "rwd" = read-write-data: guarda inmediatamente solo el contenido
            try (RandomAccessFile rafRWD = new RandomAccessFile(ruta, "rwd")) {
                System.out.println("Abierto con RandomAccessFile modo \"rwd\" (sync datos).");
            } // Se cierra automáticamente
            
        } catch (IOException e) {  // Captura cualquier error de entrada/salida
            // Si hay un error (archivo no existe, sin permisos, etc.), muestra el mensaje
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }
    }
}