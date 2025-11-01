/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Autor: Milagros Pozzo
 */

/*
 * Problema 136 - Entradas múltiples con Scanner
 *
 * Enunciado:
 * ¿Cómo se pueden hacer entradas múltiples de datos en Java utilizando Scanner?
 *
 * Explicación general:
 * En Java usamos la clase Scanner para leer datos desde el teclado.
 * Con ella podemos leer varios valores seguidos: nombre (texto), edad (entero), altura (decimal).
 */

import java.util.Scanner; // Importamos la clase Scanner del paquete java.util para leer entradas desde consola

public class Problema_136 {

    public static void main(String[] args) {
        // Creamos un objeto Scanner que va a leer datos desde el teclado (System.in)
        // Scanner es una clase que se usa para capturar datos ingresados por el usuario
        Scanner scanner = new Scanner(System.in);

        // --- Entrada 1: nombre ---
        System.out.print("Ingrese su nombre: ");
        // Usamos String porque queremos guardar texto completo (el nombre puede tener espacios)
        String nombre = scanner.nextLine(); // nextLine() permite leer toda una línea de texto

        // --- Entrada 2: edad ---
        System.out.print("Ingrese su edad: ");
        // Usamos int porque la edad es un número entero (sin decimales)
        int edad = scanner.nextInt(); // nextInt() lee un número entero

        // --- Entrada 3: altura ---
        // Aclaramos que debe usarse punto y no coma, porque Java espera punto como separador decimal
        System.out.print("Ingrese su altura en metros (use coma, ej: 1,75): ");
        // Usamos double porque la altura puede tener decimales (como 1,65 o 1,80)
        double altura = scanner.nextDouble(); // nextDouble() lee un número decimal con punto (no acepta coma)

        // --- Salida de datos ---
        System.out.println("\nResumen:");
        // Mostramos en consola los datos ingresados por el usuario
        System.out.println("Nombre: " + nombre);           // Texto
        System.out.println("Edad: " + edad + " años");     // Entero con etiqueta "años"
        System.out.println("Altura: " + altura + " m");    // Decimal con etiqueta "m" (metros). 

        // Cerramos el Scanner para liberar el recurso del sistema
        // Es una buena práctica de programación
        scanner.close();
    }
}