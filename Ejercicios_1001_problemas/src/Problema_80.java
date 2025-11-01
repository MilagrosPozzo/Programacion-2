/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * PROBLEMA 80 – Escribir un programa en Java que lea el radio de un círculo y calcule su área utilizando
 * la clase Math para obtener π.
 * Calcular el área de un círculo a partir de su radio.
 *
 * Descripción:
 * Se solicita al usuario que ingrese el radio de un círculo. Luego, usando la fórmula:
 *   área = π * radio^2
 * Se calcula e imprime el área.
 *
 * Este programa usa la clase Math de Java para obtener el valor de PI y elevar el radio al cuadrado.
 * Es un ejemplo de uso básico de variables, entrada de datos y operaciones matemáticas.
 *
 * @author Milagros Pozzo
 */

import java.util.Scanner; // Importamos Scanner para leer datos desde teclado

public class Problema_80 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creamos el objeto Scanner para capturar el radio

        // Paso 1: Solicitar el radio al usuario
        System.out.print("Ingrese el radio del círculo: ");
        double radio = sc.nextDouble(); // Guardamos el valor ingresado como número decimal

        // Paso 2: Calcular el área usando la fórmula: área = π * radio^2
        // Math.PI es una constante con el valor aproximado de π (3.141592...)
        // Math.pow(radio, 2) eleva el radio al cuadrado
        double area = Math.PI * Math.pow(radio, 2);

        // Paso 3: Mostrar el resultado en consola
        System.out.println("El área del círculo es: " + area);

        sc.close(); // Cerramos el Scanner para liberar recursos
    }
}