/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * PROBLEMA 90 – Escribir un programa en Java que recorra un rango de enteros y muestre los números primos encontrados.
 * Razonamiento:
 * 1. El usuario ingresa el inicio y el fin del rango.
 * 2. Recorremos todos los números en ese rango.
 * 3. Para cada número, verificamos si es primo:
 *    - Un número primo solo es divisible por 1 y por sí mismo.
 * 4. Mostramos los números primos en pantalla.
 *
 * @author Milagros Pozzo
 */

import java.util.Scanner; // Necesario para leer datos desde teclado

public class Problema_90 {
    public static void main(String[] args) {
        // Creamos el objeto Scanner para leer datos del usuario
        Scanner sc = new Scanner(System.in);

        // Pedimos el inicio del rango
        System.out.print("Ingrese el número inicial del rango: ");
        int inicio = sc.nextInt();

        // Pedimos el final del rango
        System.out.print("Ingrese el número final del rango: ");
        int fin = sc.nextInt();

        // Mensaje de inicio
        System.out.println("Números primos entre " + inicio + " y " + fin + ":");

        // Recorremos todos los números desde inicio hasta fin
        for (int num = inicio; num <= fin; num++) {
            if (esPrimo(num)) { // Usamos la función esPrimo para verificar
                System.out.print(num + " "); // Mostramos el número primo
            }
        }

        // Cerramos el Scanner para liberar recursos
        sc.close();
    }

    // Función que verifica si un número es primo
    public static boolean esPrimo(int n) {
        // Los números menores que 2 no son primos
        if (n < 2) {
            return false;
        }

        // Verificamos divisores desde 2 hasta n-1
        for (int i = 2; i < n; i++) {
            if (n % i == 0) { // Si tiene un divisor, no es primo
                return false;
            }
        }

        // Si no se encontró divisor, es primo
        return true;
    }
}