/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * PROBLEMA: Suma de dos matrices ingresadas por el usuario
 *
 * Descripción:
 * Este programa solicita al usuario dos matrices del mismo tamaño y realiza su suma elemento por elemento.
 * La matriz resultante es mostrada en consola.
 */

// Importamos la clase Scanner para poder leer datos del usuario desde el teclado
import java.util.Scanner;

/**
 *
 * @author Milagros Pozzo
 */
public class Problema_388 {
    
    public static void main(String[] args) {
        // Creamos el objeto Scanner para leer datos desde la consola
        Scanner sc = new Scanner(System.in);
        
        // Paso 1: Ingresar dimensiones de las matrices
        System.out.print("Ingrese el número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas = sc.nextInt();
        
        // Declaramos tres matrices: A, B y suma
        int[][] matrizA = new int[filas][columnas];
        int[][] matrizB = new int[filas][columnas];
        int[][] suma = new int[filas][columnas];
        
        // Paso 2: Llenar la primera matriz con valores del usuario
        System.out.println("Ingrese los elementos de la primera matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                matrizA[i][j] = sc.nextInt();
            }
        }
        
        // Paso 3: Llenar la segunda matriz con valores del usuario
        System.out.println("Ingrese los elementos de la segunda matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                matrizB[i][j] = sc.nextInt();
            }
        }
        
        // Paso 4: Sumar las matrices elemento a elemento y guardar en la matriz suma
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        
        // Paso 5: Mostrar la matriz resultante (suma)
        System.out.println("\nMatriz suma:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(suma[i][j] + "\t"); // \t es para dar formato de tabla
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
        
        // Cerramos el Scanner al final para liberar recursos
        sc.close();
    }
}