package javaapplication6;

/**
 *
 * @author Milagros Pozzo
 */
public class Problema_441 {

    public static void main(String[] args) {
        /*
        Descripción: El siguiente código intenta imprimir los elementos de un arreglo de enteros, pero accede a posiciones inválidas.
int[] numeros = {1, 2, 3, 4, 5};
for (int i = 0; i < 10; i++) { System.out.print(numeros[i] + "" ""); } [/code]
         * PROBLEMAS EN EL CÓDIGO ORIGINAL:
         * - El arreglo 'numeros' tiene solo 5 elementos (índices válidos: 0 a 4).
         * - El bucle for usaba 'i < 10', lo que lleva a intentar acceder a índices inválidos como numeros[5], numeros[6], etc.
         * - Esto genera una excepción ArrayIndexOutOfBoundsException en tiempo de ejecución.
         * - También, la cadena "" "" en el System.out.print es inválida (doble comilla seguida de espacio y otra doble comilla).
         *
         * SOLUCIÓN:
         * - Cambiar la condición del for a 'i < numeros.length' para limitarse a los índices válidos del arreglo.
         * - Corregir la cadena para que tenga un espacio adecuado: " " en vez de "" "".
         */

        int[] numeros = {1, 2, 3, 4, 5};

        // Recorremos el arreglo usando la longitud del mismo
        for (int i = 0; i < numeros.length; i++) {
            // Imprime cada número seguido de un espacio
            System.out.print(numeros[i] + " ");
        }
    }
}