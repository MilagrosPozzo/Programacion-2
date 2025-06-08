/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// Problema_35: ¿Cómo depurar errores lógicos en un algoritmo implementado en Java a partir de una descripción en pseudocódigo?
public class Problema_35 {

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6}; // arreglo de ejemplo
        int suma = 0;

        // Ejemplo concreto: si el pseudocódigo indica "sumar solo los números pares de un arreglo",
        // el código en Java debería incluir una condición como:

        for (int num : arreglo) {
            if (num % 2 == 0) {
                suma += num;
            }
        }

        System.out.println("Suma de pares: " + suma);

        // Si falta esa condición, o se usa incorrectamente, el algoritmo sumará también los impares,
        // generando un error lógico.
    }
}