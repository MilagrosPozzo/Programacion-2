/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner; // Importamos Scanner para poder leer datos desde teclado

/**
 *
 * @author Milagros Pozzo
 */
public class Problema_401 {

    /*
     * PROBLEMA 401 - Escribe un programa que sume los elementos diagonales de una matriz
     *
     * Descripción:
     * Este programa solicita al usuario una matriz.
     * Si la matriz es cuadrada, suma los elementos de su diagonal principal (posición i = j).
     * Si no es cuadrada, se suma hasta la longitud de la menor dimensión.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creamos el objeto Scanner para capturar entrada del usuario

        // Solicitamos al usuario la cantidad de filas de la matriz
        System.out.print("Ingrese el número de filas: ");
        int filas = sc.nextInt(); // Leemos el número de filas

        // Solicitamos la cantidad de columnas
        System.out.print("Ingrese el número de columnas: ");
        int columnas = sc.nextInt(); // Leemos el número de columnas

        // Creamos la matriz con las dimensiones dadas por el usuario
        int[][] matriz = new int[filas][columnas];

        // Pedimos al usuario que ingrese cada elemento de la matriz
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < filas; i++) { // Recorremos las filas
            for (int j = 0; j < columnas; j++) { // Recorremos las columnas
                System.out.print("Matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        // Calculamos la cantidad de elementos que pueden formar parte de la diagonal principal
        int limite = Math.min(filas, columnas);

        // Variable para acumular la suma de la diagonal principal
        int sumaDiagonal = 0;

        // Recorremos solo las posiciones donde fila = columna (i == j)
        for (int i = 0; i < limite; i++) {
            sumaDiagonal += matriz[i][i];
        }

        // Mostramos el resultado al usuario
        System.out.println("La suma de los elementos de la diagonal principal es: " + sumaDiagonal);

        sc.close(); // Cerramos el Scanner al final
    }
}