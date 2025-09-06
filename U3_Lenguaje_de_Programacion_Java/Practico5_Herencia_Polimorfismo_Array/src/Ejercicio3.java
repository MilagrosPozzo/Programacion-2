/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
import java.util.Random; // Importamos la clase Random para generar números aleatorios

class Desafio3 {
    public static void main(String[] args) {
        Random random = new Random();  // Creamos un generador de números aleatorios

        int sumaImpares = 0;           // Aquí vamos a guardar la suma de los impares
        int numero;                    // Variable para el número generado

        // Repetimos hasta que la suma de impares supere 25
        while (sumaImpares <= 25) {
            // Generamos un número entre 0 y 10 (inclusive)
            numero = random.nextInt(11); // nextInt(11) genera [0,10]

            // Verificamos si el número es par
            if (numero % 2 == 0) {
                System.out.println("Generado: " + numero + " -> par");
            } else {
                System.out.println("Generado: " + numero + " -> impar");
                sumaImpares = sumaImpares + numero; // Acumulamos los impares
            }
        }

        // Cuando salimos del bucle, mostramos la suma final
        System.out.println("Suma de impares = " + sumaImpares);
    }
}