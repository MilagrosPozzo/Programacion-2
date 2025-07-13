/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer

/*
 * Problema 254 - Ejecutar comandos del sistema con ProcessBuilder
 * Enunciado:
 * ¿Cómo se puede usar `ProcessBuilder` en Java para ejecutar comandos del sistema desde un método?
 *
 * ¿Qué es ProcessBuilder?
 * La clase `ProcessBuilder` permite ejecutar comandos del sistema operativo desde un programa Java.
 * Por ejemplo: se puede ejecutar 'echo', 'dir', 'notepad', o cualquier comando que se usaría en la terminal o consola.
 * Es útil para automatizar tareas, lanzar programas externos o ejecutar scripts.
 */

import java.io.BufferedReader;         // Permite leer líneas de texto desde una entrada (InputStream)
import java.io.InputStreamReader;      // Convierte el flujo de bytes del proceso a caracteres legibles
import java.io.IOException;            // Necesario para manejar errores al ejecutar comandos

public class Problema_254 {

    public static void main(String[] args) {
        // Ejecutamos un comando del sistema usando nuestro método personalizado
        // Este comando muestra un mensaje en consola: funciona en Windows, Linux y Mac
        ejecutarComando("echo Hola desde Java");
    }

    /**
     * Método que ejecuta un comando del sistema usando ProcessBuilder.
     * @param comando Es un String que contiene el comando a ejecutar completo (ej: "echo Hola mundo")
     */
    public static void ejecutarComando(String comando) {
        try {
            /*
             * Usamos el método split() para dividir el String en un arreglo de Strings.
             * Ejemplo: "echo Hola desde Java" se convierte en: {"echo", "Hola", "desde", "Java"}
             * Esto es necesario porque ProcessBuilder espera una lista separada por espacios.
             */
            String[] partes = comando.split(" "); // ← arreglo que contiene cada palabra del comando

            // Creamos una instancia de ProcessBuilder pasándole el arreglo del comando
            ProcessBuilder pb = new ProcessBuilder(partes);

            // Iniciamos el proceso (como si lo ejecutáramos en consola)
            Process proceso = pb.start();

            // Creamos un lector para leer la salida del proceso (lo que imprimiría el comando en terminal)
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea; // Variable temporal para almacenar cada línea de salida del proceso

            System.out.println("Salida del comando:");

            // Leemos la salida del proceso línea por línea hasta que no haya más
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            // Esperamos que el proceso termine y obtenemos el código de salida (0 = éxito)
            int estado = proceso.waitFor();
            System.out.println("Proceso finalizado con código: " + estado);

        } catch (IOException | InterruptedException e) {
            // Capturamos posibles errores al iniciar o ejecutar el proceso
            System.out.println("Error al ejecutar el comando: " + e.getMessage());
        }
    }
}