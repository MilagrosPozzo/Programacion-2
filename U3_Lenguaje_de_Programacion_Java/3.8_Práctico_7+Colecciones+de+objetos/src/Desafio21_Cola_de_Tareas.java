/*
 * Desafío 21 – Cola de Tareas 
* Implementar una LinkedList<String> para simular una cola de tareas pendientes. 
* Extraer la primera tarea y mostrar la siguiente en orden.
 */

import java.util.LinkedList; // Importa LinkedList: lista doblemente enlazada, eficiente para operaciones FIFO
import java.util.Scanner;    // Importa Scanner: clase para leer entrada desde teclado

public class Desafio21_Cola_de_Tareas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crea objeto Scanner conectado a entrada estándar (teclado)
        
        LinkedList<String> cola = new LinkedList<>(); // Crea cola vacía usando LinkedList como implementación
        
        System.out.println("Ingrese tareas (escriba 'fin' para terminar):"); // Instrucciones para el usuario
        
        while (true) { // Bucle infinito que solo termina con break interno
            String tarea = sc.nextLine().trim(); // Lee línea completa y elimina espacios laterales
            
            if (tarea.equalsIgnoreCase("fin")) break; // Si usuario escribe "fin" (sin importar mayúsculas), sale del bucle
            
            cola.add(tarea); // Agrega tarea al final de la cola (comportamiento FIFO)
        }
        
        System.out.println("\nCola de tareas: " + cola); // Muestra todas las tareas en formato [tarea1, tarea2, ...]
        
        if (!cola.isEmpty()) { // Verifica que la cola tenga al menos un elemento antes de extraer
            String primera = cola.poll(); // Extrae Y remueve la primera tarea de la cola (null-safe)
            System.out.println("Tarea extraída: " + primera); // Muestra la tarea que se procesó
            
            if (!cola.isEmpty()) { // Verifica si aún quedan tareas después de la extracción
                System.out.println("Siguiente en cola: " + cola.peek()); // Muestra primera tarea restante SIN removerla
            } else {
                System.out.println("No hay más tareas en la cola."); // Cola quedó vacía después de poll()
            }
        } else {
            System.out.println("La cola está vacía."); // Usuario no ingresó ninguna tarea válida
        }
        
        sc.close(); // Libera recursos del Scanner y cierra conexión con System.in
    }
}