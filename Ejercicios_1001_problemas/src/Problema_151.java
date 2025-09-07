/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */

// Importa la clase Scanner del paquete java.util
// Scanner permite leer datos desde diferentes fuentes (teclado, archivos, etc.)
import java.util.Scanner;

// Declaración de la clase pública llamada "Problema_151"
// En Java, el nombre del archivo debe coincidir con el nombre de la clase pública
public class Problema_151 {
    
    // Método principal (main) - punto de entrada del programa
    // public: accesible desde cualquier lugar
    // static: pertenece a la clase, no a una instancia específica
    // void: no retorna ningún valor
    // String[] args: parámetros de comandos desde consola
    public static void main(String[] args) {
        
        // Crea un objeto Scanner llamado "sc" para leer desde System.in (teclado)
        // System.in es el flujo de entrada estándar (normalmente el teclado)
        Scanner sc = new Scanner(System.in);
        
        // Comentario que explica el siguiente paso
        // Ejemplo: primero leemos un número
        
        // Muestra un mensaje al usuario pidiendo que ingrese su edad
        // print() muestra el texto sin salto de código al final
        System.out.print("Ingrese su edad: ");
        
        // Lee el siguiente entero (número) que el usuario escriba
        // nextInt() solo lee el número, pero deja el salto de código (\n) en el buffer
        int edad = sc.nextInt();
        
        // Comentario explicativo sobre la limpieza del buffer
        // Limpiamos el buffer antes de leer la cadena
        
        // ¡MUY IMPORTANTE! Limpia el buffer de entrada
        // Consume el salto de código (\n) que quedó después de nextInt()
        // Sin este código, nextLine() leería una cadena vacía
        sc.nextLine(); 
        
        // Comentario sobre la lectura de cadena
        // Ahora sí leemos una cadena completa
        
        // Muestra mensaje pidiendo el nombre del usuario
        System.out.print("Ingrese su nombre: ");
        
        // Lee una cadena completa de texto (incluyendo espacios)
        // nextLine() lee toda la entrada hasta encontrar un salto de código
        String nombre = sc.nextLine();
        
        // Comentario sobre mostrar los datos
        // Mostramos los datos
        
        // Imprime un mensaje personalizado usando los datos ingresados
        // println() imprime el texto y agrega un salto de código al final
        // Se usa concatenación de strings con el operador +
        System.out.println("Hola " + nombre + ", tienes " + edad + " años.");
        
        // Cierra el objeto Scanner para liberar recursos
        // Es una buena práctica cerrar los recursos cuando ya no se necesitan
        sc.close();
    }
}