/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
import java.util.Scanner;

/**
 * Problema 78 - MCM usando MCD (algoritmo de Euclides)
 Descripción: Calcula el Mínimo Común Múltiplo de dos números utilizando métodos y el MCD como base del cálculo.
 */
public class Problema_78 {

    // Método principal: punto de entrada del programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto para leer entradas del usuario

        // Pedimos los dos números al usuario
        System.out.print("Ingrese el primer número: ");
        int a = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int b = scanner.nextInt();

        // Calculamos el MCM usando el método mcm()
        int resultado = mcm(a, b);

        // Mostramos el resultado final al usuario
        System.out.println("El MCM de " + a + " y " + b + " es: " + resultado);
    }

    /**
     * Método para calcular el MCM usando la fórmula:
     * MCM(a, b) = (a * b) / MCD(a, b)
     */
    public static int mcm(int a, int b) {
        return (a * b) / mcd(a, b);
    }

    /**
     * Método para calcular el MCD (Máximo Común Divisor)
     * Usamos el algoritmo de Euclides:
     * Se repite a = b y b = a % b hasta que b sea 0.
     */
    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; // El MCD final cuando b es 0
    }
}