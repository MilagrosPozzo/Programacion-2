/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
public class Ejercicio17 {
    
}
// Importamos ArrayList desde el paquete java.util para poder usar estructuras de datos dinámicas
// ArrayList nos permite crear listas que pueden crecer y reducirse automáticamente según necesitemos
import java.util.ArrayList;

// Importamos Scanner desde java.util para poder leer datos desde el teclado
// Scanner es la clase más común para capturar entrada del usuario en aplicaciones de consola
import java.util.Scanner;

// Declaramos nuestra clase principal que contendrá toda la lógica del programa
// El nombre de la clase debe coincidir exactamente con el nombre del archivo .java
public class ListaNombres {
    
    // Método main: punto de entrada de cualquier programa Java
    // Es el primer método que se ejecuta cuando corremos el programa
    public static void main(String[] args) {
        
        // Creamos un objeto Scanner conectado a System.in (entrada estándar del sistema)
        // System.in representa el teclado, por lo que sc podrá leer lo que el usuario escriba
        Scanner sc = new Scanner(System.in);
        
        // Creamos un ArrayList de tipo String para almacenar los nombres
        // ArrayList<String> significa: lista dinámica que solo puede contener cadenas de texto
        // La ventaja de ArrayList sobre arrays normales es que no necesitamos definir un tamaño fijo
        ArrayList<String> nombres = new ArrayList<>();
        
        // Mostramos un título llamativo para que el usuario sepa qué hace nuestro programa
        // Los símbolos === son puramente decorativos para hacer más visual la salida
        System.out.println("=== Programa Lista de Nombres ===");
        
        // Iniciamos un bucle infinito para recopilar nombres de manera continua
        // while(true) significa "repetir para siempre" hasta que encontremos un break
        // Esta es una técnica común cuando no sabemos exactamente cuántas veces se repetirá algo
        while (true) {
            
            // Mostramos las instrucciones al usuario de manera clara
            // Le explicamos qué puede hacer y cómo terminar el programa
            System.out.print("Ingrese un nombre (o 'fin' para terminar): ");
            
            // Leemos una línea completa de texto que escriba el usuario
            // nextLine() captura todo lo que escriba hasta que presione Enter
            // Esto nos permite manejar nombres con espacios como "María José"
            String nombre = sc.nextLine();
            
            // Verificamos si el usuario quiere terminar el programa
            // equalsIgnoreCase() compara textos sin importar mayúsculas o minúsculas
            // Esto significa que "fin", "FIN", "Fin", "fIn" todos funcionarán para terminar
            if (nombre.equalsIgnoreCase("fin")) {
                // break nos saca inmediatamente del bucle while
                // El programa continuará con la siguiente línea después del while
                break;
            }
            
            // Si llegamos aquí, significa que el usuario NO escribió "fin"
            // Entonces agregamos el nombre a nuestra lista usando el método add()
            // add() siempre coloca el nuevo elemento al final de la lista
            nombres.add(nombre);
            
            // El bucle while se repite automáticamente, pidiendo otro nombre
        }
        
        // Una vez que salimos del bucle, mostramos todos los nombres recopilados
        // \n crea una línea en blanco para separar visualmente las secciones del programa
        System.out.println("\n=== Nombres ingresados ===");
        
        // Usamos un bucle for-each (también llamado "enhanced for loop")
        // La sintaxis es: for(TipoDato variable : coleccion)
        // Esto significa: "para cada String n que esté dentro de nombres"
        // Es la forma más elegante de recorrer todos los elementos de una lista
        for (String n : nombres) {
            // Imprimimos cada nombre en una línea separada
            // n toma automáticamente el valor de cada elemento de la lista, uno por uno
            System.out.println(n);
        }
        
        // IMPORTANTE: Cerramos el Scanner para liberar los recursos del sistema
        // Si no hacemos esto, el programa podría causar "memory leaks" (fugas de memoria)
        // Es una buena práctica siempre cerrar los recursos que abrimos
        sc.close();
        
        // El programa termina aquí automáticamente
        // Java se encarga de limpiar la memoria y finalizar la ejecución
    }
}