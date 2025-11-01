/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
/*
 * Problema 101 - Encontrar el valor más repetido en un arreglo
 * Enunciado:
 * Escribir un programa en Java que reciba un arreglo de enteros y encuentre
 * el valor que más veces se repite.
 */

import java.util.HashMap; // Importamos HashMap para contar ocurrencias
import java.util.Map;     // Para trabajar con pares clave-valor

public class Problema_101 {

    public static void main(String[] args) {
        // Definimos un arreglo de ejemplo
        int[] arreglo = {2, 3, 4, 2, 7, 2, 3, 4, 4, 4};

        /*
         * Creamos un mapa (diccionario) donde:
         * - La clave es el número del arreglo
         * - El valor es la cantidad de veces que aparece ese número
         */
        Map<Integer, Integer> frecuencia = new HashMap<>();

        // Recorremos el arreglo para contar la frecuencia de cada número
        for (int numero : arreglo) {
            // Si el número ya está en el mapa, aumentamos su contador
            if (frecuencia.containsKey(numero)) {
                frecuencia.put(numero, frecuencia.get(numero) + 1);
            } else {
                // Si es la primera vez que lo vemos, lo agregamos con valor 1
                frecuencia.put(numero, 1);
            }
        }

        // Variables para guardar el número más repetido y su frecuencia
        int maxNumero = arreglo[0]; // Inicializamos con el primer número del arreglo
        int maxFrecuencia = 1;

        // Recorremos el mapa para encontrar el número con mayor frecuencia
        for (Map.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
            int numero = entry.getKey();
            int cantidad = entry.getValue();

            // Si encontramos uno con mayor frecuencia, lo actualizamos
            if (cantidad > maxFrecuencia) {
                maxFrecuencia = cantidad;
                maxNumero = numero;
            }
        }

        // Mostramos el resultado final
        System.out.println("El número que más se repite es: " + maxNumero);
        System.out.println("Cantidad de veces: " + maxFrecuencia);
    }
}