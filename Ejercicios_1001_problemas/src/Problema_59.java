/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
/*
 * PROBLEMA 59 – ¿Se puede aprender Java sin saber matemáticas avanzadas?
 *
 * Este ejemplo demuestra que se puede escribir un programa funcional en Java
 * usando solo lógica básica, sin operaciones matemáticas complicadas.
 *
 * El programa pregunta la edad y responde con un mensaje simple.
 * Sí, es totalmente posible comenzar a aprender Java sin saber matemáticas complejas.
 * Para empezar a programar en Java, lo más importante es entender la lógica básica:
 * cómo usar condiciones (if), bucles (for, while), y cómo crear funciones y clases.
 *
 * Aunque algunas áreas avanzadas de la programación pueden requerir más matemáticas
 * (como inteligencia artificial o gráficos 3D), la gran mayoría de los ejercicios de nivel inicial
 * solo requieren operaciones sencillas como sumar, restar o comparar números.
 *
 * Lo ideal es comenzar paso a paso, con ejemplos prácticos. La lógica de programación se puede
 * aprender con la práctica, ¡no hace falta ser experta en matemáticas!
 *
 * Así que sí, Ana puede comenzar sin miedo. Aprender Java también puede ayudarle a mejorar
 * su razonamiento lógico con el tiempo.
 */

import java.util.Scanner;

public class Problema_59 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos al usuario que ingrese su nombre
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        // Pedimos al usuario que ingrese su edad
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();

        // Lógica simple con una condición
        if (edad >= 18) {
            System.out.println("Hola " + nombre + ", sos mayor de edad. ¡Bienvenida a Java!");
        } else {
            System.out.println("Hola " + nombre + ", sos menor de edad. ¡También podés aprender Java!");
        }

        sc.close(); // Cerramos el Scanner
    }
}