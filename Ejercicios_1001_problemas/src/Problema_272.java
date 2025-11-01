/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */

// Problema_272: Escribir una función en Java que calcule la suma de los números pares de una lista

public class Problema_272 {

    // Función que recibe un arreglo de enteros y retorna la suma de los valores pares
    public static int sumarPares(int[] lista) {
        int suma = 0; // Variable acumuladora para los números pares

        // Recorremos el arreglo 'lista' usando un bucle for-each
        for (int numero : lista) {
            // Verificamos si el número actual es par (divisible por 2 sin residuo)
            if (numero % 2 == 0) {
                suma += numero; // Si es par, lo sumamos a la variable acumuladora
            }
        }

        // Retornamos la suma total de los números pares encontrados
        return suma;
    }

    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {

        // Declaramos e inicializamos un arreglo de enteros llamado 'numeros'
        // Este arreglo simula una lista de valores de entrada, representando un caso de prueba
        // Elegimos valores mixtos (pares e impares) para probar correctamente el filtro
        int[] numeros = {3, 4, 7, 10, 2, 5, 8};

        // Llamamos a la función 'sumarPares' pasando el arreglo como argumento
        // Así se evalúa el funcionamiento con datos reales
        int resultado = sumarPares(numeros);

        // Mostramos el resultado de la suma de los pares por consola
        System.out.println("La suma de los números pares es: " + resultado);
    }
}