/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * PROBLEMA 418 –En Java. Escribe un programa que combine dos arreglos de enteros en orden ascendente.
 *
 * Descripción:
 * El programa toma dos arreglos de enteros, los combina en uno solo
 * y luego ordena el resultado en orden ascendente.
 *
 * Lógica:
 * 1. Crear dos arreglos de enteros.
 * 2. Combinar ambos en un solo arreglo.
 * 3. Ordenar el arreglo resultante usando Arrays.sort().
 * 4. Mostrar el arreglo combinado y ordenado.
 *
 * @author Milagros Pozzo
 */

import java.util.Arrays; // Importamos para usar Arrays.sort() y Arrays.toString()

public class Problema_418 {

    public static void main(String[] args) {
        // Paso 1: Definir los dos arreglos de enteros
        int[] arreglo1 = {5, 2, 9};
        int[] arreglo2 = {1, 7, 3};

        // Paso 2: Crear un nuevo arreglo con tamaño igual a la suma de los tamaños de ambos
        int[] combinado = new int[arreglo1.length + arreglo2.length];

        // Paso 3: Copiar los elementos del primer arreglo al nuevo
        for (int i = 0; i < arreglo1.length; i++) {
            combinado[i] = arreglo1[i];
        }

        // Paso 4: Copiar los elementos del segundo arreglo al nuevo (empezando donde terminó el primero)
        for (int i = 0; i < arreglo2.length; i++) {
            combinado[arreglo1.length + i] = arreglo2[i];
        }

        // Paso 5: Ordenar el arreglo combinado en orden ascendente
        Arrays.sort(combinado);

        // Paso 6: Mostrar el resultado
        System.out.println("Arreglo combinado y ordenado: " + Arrays.toString(combinado));
    }
}