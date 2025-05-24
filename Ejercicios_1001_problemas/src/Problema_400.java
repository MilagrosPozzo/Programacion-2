/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
public class Problema_400 {
    
}
/*
 * PROBLEMA 440 - Explicación y razonamiento
 *
 * Descripción del problema:
 * Se intenta imprimir los elementos de un arreglo de enteros. 
 * Sin embargo, el bucle 'for' utilizado accede a posiciones fuera de los límites válidos del arreglo.
 *
 * Problemas detectados:
 * 1. El arreglo 'numeros' tiene solo 5 elementos, con índices válidos de 0 a 4.
 * 2. El bucle for usaba la condición 'i < 10', lo cual lleva a intentar acceder a índices inválidos como numeros[5], numeros[6], etc.
 * 3. Esto provoca un error en tiempo de ejecución: ArrayIndexOutOfBoundsException.
 * 4. La expresión System.out.print(numeros[i] + "" "") contiene una concatenación de cadenas mal formada, lo que genera un error de compilación.
 *
 * Solución aplicada:
 * - Se reemplazó 'i < 10' por 'i < numeros.length' para recorrer solo los índices válidos del arreglo.
 * - Se corrigió la cadena a imprimir, usando " " para separar los valores correctamente.
 *
 * Resultado:
 * El código ahora imprime los valores del arreglo sin errores:
 * Ejemplo de salida: 1 2 3 4 5
 */
import java.util.Arrays;

public class MedianaCalculator {

    // Función que calcula la mediana de un arreglo de enteros
    public static double calcularMediana(int[] arreglo) {
        // Clonamos el arreglo para no modificar el original
        int[] copia = arreglo.clone();

        // Ordenamos el arreglo
        Arrays.sort(copia);

        int n = copia.length;

        if (n == 0) {
            throw new IllegalArgumentException("El arreglo no debe estar vacío.");
        }

        // Si la cantidad de elementos es impar
        if (n % 2 != 0) {
            return copia[n / 2];
        } else {
            // Si es par, se promedian los dos valores del medio
            return (copia[n / 2 - 1] + copia[n / 2]) / 2.0;
        }
    }

    // Método principal para probar
    public static void main(String[] args) {
        int[] datos = {5, 2, 9, 1, 7};
        double mediana = calcularMediana(datos);
        System.out.println("La mediana es: " + mediana);
    }
}