/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * PROBLEMA 400 - Explicación y razonamiento
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

/**
 *
 * @author Milagros Pozzo
 */
public class Problema_400 {
    
    // Función que calcula la mediana de un arreglo de enteros
    // Se declara que el tipo de valor que devuelve la función es 'double' para permitir valores con decimales
    public static double calcularMediana(int[] arreglo) {
        if (arreglo.length == 0) {
            throw new IllegalArgumentException("El arreglo no debe estar vacío.");
        }
        
        int[] copia = arreglo.clone();
        Arrays.sort(copia);
        int n = copia.length;
        
        // Si la cantidad de elementos es impar, se puede devolver el valor del medio directamente
        if (n % 2 != 0) {
            return copia[n / 2]; // Java convierte automáticamente el int a double si la función lo requiere
        } else {
            // Si es par, se promedian los dos valores centrales, por eso usamos división con decimal (/ 2.0)
            // Si usáramos solo enteros, perderíamos la parte decimal del resultado
            return (copia[n / 2 - 1] + copia[n / 2]) / 2.0; 
            // Ejemplo: (4 + 6) / 2.0 = 5.0 → Resultado correcto como double
        }
    }
    
    public static void main(String[] args) {
        // Ejemplo de prueba
        int[] numeros = {5, 2, 9, 1, 7};
        
        System.out.println("Arreglo original: " + Arrays.toString(numeros));
        
        double mediana = calcularMediana(numeros);
        
        System.out.println("La mediana es: " + mediana);
        
        // Prueba con arreglo par
        int[] numerosPares = {4, 1, 3, 2};
        System.out.println("\nArreglo par: " + Arrays.toString(numerosPares));
        System.out.println("La mediana es: " + calcularMediana(numerosPares));
    }
}