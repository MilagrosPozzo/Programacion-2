/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
/*
 * Problema 214 - Adivinar un número
 * Autor: Milagros Pozzo
 *
 * Enunciado:
 * Escriba un programa en Java que genere un número aleatorio entre 1 y 100
 * y permita al usuario adivinarlo, indicando si el intento es mayor o menor.
 *
 * Ejemplo de ejecución:
 * Ingrese su suposición:
 * 50 → El número es mayor
 * 62 → El número es menor
 * 59 → ¡Acertaste!
 */

import java.util.Scanner;
import java.util.Random;

public class Problema_214 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Para leer entrada del usuario
        Random random = new Random();             // Para generar número aleatorio

        int numeroSecreto = random.nextInt(100) + 1; // Número aleatorio entre 1 y 100
        int intento;                                 // Variable para almacenar el número ingresado

        System.out.println("¡Adivina el número entre 1 y 100!");

        // Bucle que continúa hasta que el usuario acierte
        do {
            System.out.print("Ingrese su suposición: ");
            intento = scanner.nextInt(); // Leer intento del usuario

            if (intento < numeroSecreto) {
                System.out.println("El número es mayor.");
            } else if (intento > numeroSecreto) {
                System.out.println("El número es menor.");
            } else {
                System.out.println("¡Acertaste!");
            }

        } while (intento != numeroSecreto); // Se repite hasta acertar
    }
}