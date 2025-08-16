/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
/*
 * Problema 117 - Dividir una cadena en partes usando split()
 *
 * Enunciado:
 * Escribir un programa en Java que divida una cadena en partes usando
 * el método split() de la clase String.
 *
 *Explicación general:
 * - La clase String en Java es la que usamos para manejar texto.
 * - El método split(String regex) divide la cadena en partes según un patrón
 *   que le pasemos (por ejemplo, un espacio " " o una coma ",").
 * - Devuelve un arreglo (array) de Strings con cada parte resultante.
 */

public class Problema_117 {

    public static void main(String[] args) {

        // Definimos una cadena de texto que vamos a dividir
        String texto = "Java es un lenguaje de programación poderoso";
        // La variable texto es de tipo String porque contiene caracteres y palabras.

        // Usamos el método split(" ") para dividir por espacios
        String[] partes = texto.split(" ");
        // split(" ") devuelve un arreglo (array) de Strings.
        // Cada elemento del arreglo es una palabra de la cadena original.

        // Recorremos el arreglo con un bucle for-each para mostrar cada parte
        System.out.println("Partes de la cadena:");
        for (String palabra : partes) {
            System.out.println(palabra);
        }
        // El for-each permite recorrer todos los elementos del arreglo sin índices.

        // También podemos dividir usando otro delimitador, por ejemplo, una coma
        String textoConComas = "Rojo,Verde,Azul,Amarillo";
        String[] colores = textoConComas.split(",");
        // Aquí el delimitador es la coma, así que se separarán las palabras entre comas.

        System.out.println("\nLista de colores:");
        for (String color : colores) {
            System.out.println(color);
        }
    }
}