/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 *
 * @author Milagros Pozzo

/*
 * Problema 214 - Manejo de Arreglos
 *
 * Enunciado:
 * El siguiente código intenta imprimir los elementos de un arreglo de enteros, pero accede a posiciones inválidas.
 *
 * Código original:
 * int[] numeros = {1, 2, 3, 4, 5};
 * for (int i = 0; i < 10; i++) {
 *     System.out.print(numeros[i] + "" "");
 * }
 *
 * Error:
 * El arreglo tiene solo 5 elementos, con índices válidos del 0 al 4.
 * Al intentar acceder hasta el índice 9 (i < 10), el programa genera un
 * error en tiempo de ejecución: ArrayIndexOutOfBoundsException.
 *
 * Solución:
 * Usar `numeros.length` como condición del for, para recorrer solo las posiciones válidas.
 */

public class Problema_214 {
    public static void main(String[] args) {
        // Definimos un arreglo de enteros con 5 elementos
        int[] numeros = {1, 2, 3, 4, 5};

        // Recorremos el arreglo desde el índice 0 hasta el índice máximo permitido
        // que es numeros.length - 1 (en este caso, 4)
        for (int i = 0; i < numeros.length; i++) {
            // Imprimimos cada número seguido de un espacio
            System.out.print(numeros[i] + " ");
        }

        // Al usar numeros.length, evitamos acceder a posiciones inexistentes
    }
}