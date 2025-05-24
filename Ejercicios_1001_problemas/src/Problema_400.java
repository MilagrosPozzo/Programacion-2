/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */

 /*
  * PROBLEMA 440 - Explicación y razonamiento
  *
  * Descripción del problema:
  * Se solicita crear una función que calcule la mediana de un arreglo de enteros.
  *
  * La mediana es:
  * - el número central en un arreglo ordenado con cantidad impar de elementos;
  * - o el promedio de los dos valores centrales si la cantidad de elementos es par.
  *
  * Desarrollo de la solución:
  * 1. Se crea una función que recibe un arreglo de enteros.
  * 2. Se clona el arreglo original para no modificarlo directamente.
  * 3. Se ordena el arreglo usando Arrays.sort().
  * 4. Se determina si la cantidad de elementos es par o impar.
  * 5. Se devuelve la mediana como un valor tipo double.
  *
  * Resultado esperado:
  * Si el arreglo es: {5, 2, 9, 1, 7}
  * Ordenado: {1, 2, 5, 7, 9}
  * La mediana es: 5.0
  */

import java.util.Arrays;

public class Problema_400 {

    // Función que calcula la mediana de un arreglo de enteros
    public static double calcularMediana(int[] arreglo) {
        if (arreglo.length == 0) {
            throw new IllegalArgumentException("El arreglo no debe estar vacío.");
        }

        // Clonamos el arreglo para no modificar el original
        int[] copia = arreglo.clone();

        // Ordenamos el arreglo
        Arrays.sort(copia);

        int n = copia.length;

        // Si la cantidad de elementos es impar
        if (n % 2 != 0) {
            return copia[n / 2];
        } else {
            // Si es par, se promedian los dos valores del medio
            return (copia[n / 2 - 1] + copia[n / 2]) / 2.0;
        }
    }

    // Método principal para probar la función
    public static void main(String[] args) {
        int[] datos = {5, 2, 9, 1, 7};
        double mediana = calcularMediana(datos);

        // Imprime el texto "La mediana es: " seguido del valor de la variable mediana en la consola
        System.out.println("La mediana es: " + mediana);
    }
}