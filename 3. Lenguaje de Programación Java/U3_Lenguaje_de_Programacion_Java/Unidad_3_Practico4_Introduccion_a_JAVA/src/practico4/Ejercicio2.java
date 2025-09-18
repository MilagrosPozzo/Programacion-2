/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico4;
// El "package" define el paquete de clases. En NetBeans, normalmente coincide con la carpeta del proyecto.
// Aquí puse "practico4" pero puedes cambiarlo al nombre que elijas cuando crees el proyecto.
// Ejercicio 2 – Generar un entero m al azar, mostrarlo y calcular la suma de 1 hasta m.

// Importamos la clase Random para generar números aleatorios
import java.util.Random;

/**
 *
 * @author Milagros Pozzo
 */
public class Ejercicio2 {
    
    // ===================== EJERCICIO 2 =====================
    public static void ejercicio2() {
        Random rand = new Random();

        // Generamos un entero al azar entre 1 y 50
        int m = rand.nextInt(50) + 1;

        System.out.println("Ejercicio 2:");
        System.out.println("Número generado: " + m);

        int suma = 0; // acumulador

        // Recorremos todos los números entre 1 y m y los vamos sumando
        for (int i = 1; i <= m; i++) {
            suma += i; // suma = suma + i
        }

        // Mostramos el resultado
        System.out.println("Suma de enteros entre 1 y " + m + " = " + suma);
        System.out.println("-------------------------");
    }
    
    // Método main para ejecutar directamente en NetBeans
    public static void main(String[] args) {
        ejercicio2(); // llamamos al método
    }
}