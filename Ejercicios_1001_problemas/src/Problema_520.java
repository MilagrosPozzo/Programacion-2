/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
public class Problema_520 {
    
// Problema_520: Crea una función que busque el índice de un número en una arreglo con tope.

    // Función para buscar el índice de un número en un arreglo con un límite (tope)
    public static int buscarIndiceConTope(int[] arreglo, int tope, int numero) {
        // Validamos que el arreglo no sea nulo y que el tope sea válido
        if (arreglo == null || tope > arreglo.length || tope < 0) {
            throw new IllegalArgumentException("Tope inválido o arreglo nulo");
        }

        // Recorremos el arreglo hasta el índice 'tope - 1'
        for (int i = 0; i < tope; i++) {
            // Si encontramos el número, retornamos su índice
            if (arreglo[i] == numero) {
                return i;
            }
        }

        // Si no se encuentra el número dentro del tope, devolvemos -1
        return -1;
    }

    public static void main(String[] args) {
        // Definimos el arreglo de ejemplo
        int[] arreglo = {4, 7, 2, 9, 5, 0, 3, 6};

        // Definimos el tope (hasta qué índice buscamos)
        int tope = 5;

        // Número a buscar
        int numero = 9;

        // Llamamos a la función y guardamos el resultado
        int indice = buscarIndiceConTope(arreglo, tope, numero);

        // Mostramos el resultado
        System.out.println("Índice encontrado: " + indice);
    }
}