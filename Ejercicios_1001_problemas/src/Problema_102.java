/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */

//// Problema_102: Escribir un programa en Java que calcule la suma de todos los elementos de un arreglo de enteros.

public class Problema_102 {

    // Método principal, punto de entrada del programa
    public static void main(String[] args) {

        // Se declara e inicializa un arreglo de enteros con valores predeterminados
        int[] numeros = {5, 8, 12, 20, 7};

        // Variable para almacenar la suma acumulada de los elementos del arreglo
        int suma = 0;

        // Bucle for-each: recorre cada elemento del arreglo 'numeros'
        for (int numero : numeros) {
            // Se añade el valor actual de 'numero' a la variable 'suma'
            suma += numero;
        }

        // Se imprime el resultado final de la suma por consola
        System.out.println("La suma de los elementos del arreglo es: " + suma);
    }
}