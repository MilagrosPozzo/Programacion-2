/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * PROBLEMA 37 – ¿Cómo asegurar que el algoritmo en Java sigue el pseudocódigo?
 *
 * Este ejemplo muestra cómo convertir paso a paso un pseudocódigo básico
 * a un programa funcional en Java. Se agregan comentarios para demostrar
 * que la lógica se mantiene fiel.
 *
 * Pseudocódigo:
 * Inicio
 *   Leer número
 *   Si número es par
 *     Mostrar "Es par"
 *   Sino
 *     Mostrar "Es impar"
 * Fin
 *
 * @author Milagros Pozzo
 */

import java.util.Scanner; // Importamos Scanner para leer datos del usuario

public class Problema_37 {

    public static void main(String[] args) {
        // Creamos un objeto Scanner para capturar la entrada del usuario por consola
        Scanner sc = new Scanner(System.in);

        // Paso 1 del pseudocódigo: Leer un número
        System.out.print("Ingrese un número: ");
        int numero = sc.nextInt(); // Leemos y guardamos el número en una variable

        // Paso 2: Verificamos si el número es par (si es divisible entre 2)
        if (numero % 2 == 0) {
            // Paso 3: Si es par, mostramos el mensaje correspondiente
            System.out.println("Es par");
        } else {
            // Paso 4: Si no es par, mostramos que es impar
            System.out.println("Es impar");
        }

        sc.close(); // Cerramos el Scanner para liberar recursos
    }
}