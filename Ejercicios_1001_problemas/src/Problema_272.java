/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// Problema_272 
    
public class Problema_272 {

    // Función que calcula la suma de los números pares de un arreglo
    public static int sumarPares(int[] lista) {
        int suma = 0;
        for (int numero : lista) {
            if (numero % 2 == 0) {
                suma += numero;
            }
        }
        return suma;
    }

    // Método principal para probar la función
    public static void main(String[] args) {
        int[] numeros = {3, 4, 7, 10, 2, 5, 8};
        int resultado = sumarPares(numeros);
        System.out.println("La suma de los números pares es: " + resultado);
    }
}