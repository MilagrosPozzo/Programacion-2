/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */

/*
 * Problema 115:
 * Escribir un programa en Java que elimine un valor específico de un arreglo,
 * usando bucle y copia a uno nuevo sin ese elemento.
 */

public class Problema_115 {

    public static void main(String[] args) {

        // Arreglo original con valores predeterminados
        // Incluye el número 30 dos veces para verificar que se eliminen todas las ocurrencias
        int[] numeros = {10, 20, 30, 40, 50, 30, 60};

        // Valor que queremos eliminar del arreglo
        int valorAEliminar = 30;

        // Contamos cuántos elementos no son iguales al valor a eliminar
        // Esto nos permite determinar el tamaño exacto del nuevo arreglo
        int contador = 0;
        for (int numero : numeros) {
            if (numero != valorAEliminar) {
                contador++; // Solo se cuentan los elementos distintos al que se quiere eliminar
            }
        }

        // Creamos un nuevo arreglo con espacio suficiente para los elementos que quedan
        int[] resultado = new int[contador];

        // Copiamos al nuevo arreglo los elementos que no deben eliminarse
        int indice = 0; // Controla la posición de inserción en el nuevo arreglo
        for (int numero : numeros) {
            if (numero != valorAEliminar) {
                resultado[indice] = numero; // Se copia solo si es distinto del valor a eliminar
                indice++;
            }
        }

        // Imprimimos el contenido del nuevo arreglo
        System.out.print("Arreglo resultante sin el valor " + valorAEliminar + ": ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
        System.out.println(); // Salto de línea final
    }
}
