/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico4;

// El "package" define el paquete de clases. En NetBeans, normalmente coincide con la carpeta del proyecto.
// Aquí puse "practico4" pero puedes cambiarlo al nombre que elijas cuando crees el proyecto.

// Ejercicio 3 - Generar enteros al azar entre 0 y 10, indicar si son pares o impares,
// sumar los impares y detenerse cuando la suma supere 25

import java.util.Random; // Necesario para generar números aleatorios

/**
 *
 * @author Milagros Pozzo
 */
public class Ejercicio3 {
    
    // ===================== EJERCICIO 3 =====================
    public static void main(String[] args) {
        Random rand = new Random();

        int sumaImpares = 0; // acumulador para la suma de impares

        System.out.println("Ejercicio 3:");

        // Mientras la suma de los impares no supere 25, seguimos generando números
        while (sumaImpares <= 25) {
            int num = rand.nextInt(11); // Generamos número entre 0 y 10

            // Verificamos si es par o impar
            if (num % 2 == 0) {
                System.out.println(num + " es par");
            } else {
                System.out.println(num + " es impar");
                sumaImpares += num; // Acumulamos los impares
            }
        }

        // Mostramos el resultado final
        System.out.println("La suma de los impares superó 25. Total acumulado = " + sumaImpares);

        System.out.println("-------------------------");
    }
}