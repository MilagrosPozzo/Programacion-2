/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Autor: Milagros Pozzo
 */

import java.util.Scanner; // Importamos Scanner para leer datos desde el teclado

/*
 * Problema 89 - Calcular potencia con Math.pow
 *
 * Enunciado:
 * Escribir un programa en Java que calcule una potencia (base^exponente)
 * usando métodos de la clase Math.
 */

public class Problema_89 {

    public static void main(String[] args) {

        // Creamos un objeto Scanner para capturar entradas del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitamos al usuario la base
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble(); // Usamos double para permitir números decimales

        // Solicitamos al usuario el exponente
        System.out.print("Ingrese el exponente: ");
        double exponente = scanner.nextDouble(); // También puede ser decimal (por ejemplo, raíz cuadrada con exponente 0.5)

        // Calculamos la potencia utilizando Math.pow
        // Math.pow(base, exponente) devuelve base^exponente
        double resultado = Math.pow(base, exponente);

        // Mostramos el resultado en consola
        System.out.println("Resultado: " + resultado);

        // Cerramos el Scanner (buena práctica)
        scanner.close();
    }
}