/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
package practico4; 
// El "package" define el paquete de clases. En NetBeans, normalmente coincide con la carpeta del proyecto.
// Aquí puse "practico4" pero puedes cambiarlo al nombre que elijas cuando crees el proyecto.
// Ejercicio 1 – Generar dos enteros al azar a y b, mostrar cociente y resto (controlando que b != 0).

import java.util.Random; 
// Importamos la clase Random para generar números aleatorios.

// Creamos una sola clase para guardar los tres ejercicios
public class Ejercicio1 {

    // ===================== EJERCICIO 1 =====================
    public static void ejercicio1() {
        // Creamos un objeto Random para generar enteros aleatorios
        Random rand = new Random();

        // Generamos dos enteros entre 0 y 100
       int a = rand.nextInt(101); // Genera un entero entre 0 y 100
        int b = rand.nextInt(101); // Genera un entero entre 0 y 100

        // Mostramos los valores generados
        System.out.println("Ejercicio 1:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Verificamos que b sea distinto de 0 antes de dividir
        if (b != 0) {
            int cociente = a / b;   // División entera
            int resto = a % b;      // Resto de la división
            System.out.println("Cociente: " + cociente);
            System.out.println("Resto: " + resto);
        } else {
            // Si b = 0 mostramos mensaje de error
            System.out.println("Error: no se puede dividir entre cero ❗");
        }

        System.out.println("-------------------------"); // Separador visual
        }
    } 