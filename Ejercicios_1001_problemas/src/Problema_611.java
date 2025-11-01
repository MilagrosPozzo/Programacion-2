/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
/*
 * PROBLEMA 611 – Concatenar dos arreglos
 *
 * Descripción:
 * Se debe crear un método que reciba dos arreglos de tipo int[]
 * y devuelva un nuevo arreglo que contenga los elementos de ambos
 * arreglos unidos en un solo resultado.
 *
 * Estrategia:
 * 1. Crear un nuevo arreglo cuya longitud sea la suma de los dos arreglos.
 * 2. Copiar los elementos del primer arreglo en las primeras posiciones.
 * 3. Copiar los elementos del segundo arreglo en las posiciones restantes.
 * 4. Devolver el nuevo arreglo.
 */

// Importa la clase Arrays para usar el método toString() que convierte arreglos a texto
import java.util.Arrays; 

// Declaración de la clase principal
public class Problema_611 {
    
    // Método estático que concatena (une) dos arreglos de enteros
    // public: accesible desde cualquier lugar
    // static: pertenece a la clase, no necesita instancia para ser llamado
    // int[]: retorna un arreglo de enteros
    // Parámetros: arr1 y arr2 son los dos arreglos a concatenar
    public static int[] concatenar(int[] arr1, int[] arr2) {
        
        // Crea un nuevo arreglo cuyo tamaño es la suma de los tamaños de arr1 y arr2
        // Ejemplo: si arr1 tiene 3 elementos y arr2 tiene 4, resultado tendrá 7
        int[] resultado = new int[arr1.length + arr2.length];
        
        // PRIMER BUCLE: Copia todos los elementos de arr1 al inicio de resultado
        // i recorre desde 0 hasta el último índice de arr1
        for (int i = 0; i < arr1.length; i++) {
            // Coloca cada elemento de arr1 en la misma posición en resultado
            // resultado[0] = arr1[0], resultado[1] = arr1[1], etc.
            resultado[i] = arr1[i];
        }
        
        // SEGUNDO BUCLE: Copia todos los elementos de arr2 después de arr1
        // i recorre desde 0 hasta el último índice de arr2
        for (int i = 0; i < arr2.length; i++) {
            // Coloca cada elemento de arr2 en resultado, pero desplazado por arr1.length
            // Si arr1 tiene 3 elementos: resultado[3] = arr2[0], resultado[4] = arr2[1], etc.
            // La fórmula arr1.length + i calcula la posición correcta
            resultado[arr1.length + i] = arr2[i];
        }
        
        // Devuelve el nuevo arreglo que contiene ambos arreglos concatenados
        return resultado;
    }
    
    // Método principal para probar la funcionalidad
    public static void main(String[] args) {
        
        // Crea el primer arreglo con valores {1, 2, 3}
        int[] a = {1, 2, 3};
        
        // Crea el segundo arreglo con valores {4, 5, 6, 7}
        int[] b = {4, 5, 6, 7};
        
        // Llama al método concatenar() y guarda el resultado
        // combinado será un nuevo arreglo con {1, 2, 3, 4, 5, 6, 7}
        int[] combinado = concatenar(a, b);
        
        // Muestra el resultado en consola
        // Arrays.toString() convierte el arreglo a una representación legible
        // Sin esto, solo se mostraría la referencia de memoria del arreglo
        System.out.println("Arreglo resultante: " + Arrays.toString(combinado));
        
        // Salida esperada en consola: [1, 2, 3, 4, 5, 6, 7]
    }
}