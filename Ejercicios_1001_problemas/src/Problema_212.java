/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
/*
 * Problema 212 - Cálculo de precio con descuento
 * Enunciado:
 * Desarrolle un programa en Java que lea el precio de un producto y un porcentaje de descuento.
 * El programa debe calcular y mostrar el precio final con descuento aplicado.
 * Ingrese el precio del producto: 250
 * Ingrese el descuento: 20
 * Precio final: 200.00
 */

import java.util.Scanner; // Importamos la clase Scanner para leer datos del usuario

public class Problema_212 { // Declaramos la clase pública que contiene todo el programa

    public static void main(String[] args) { // Método principal: punto de entrada del programa

        // Creamos un objeto Scanner para capturar la entrada desde teclado
        Scanner scanner = new Scanner(System.in);

        // Solicitamos el precio del producto al usuario
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble(); // Leemos el número como tipo decimal (double)

        // Solicitamos el porcentaje de descuento
        System.out.print("Ingrese el descuento (%): ");
        double descuento = scanner.nextDouble(); // Leemos el porcentaje como número

        // Calculamos el valor del descuento con la fórmula: (precio * porcentaje) / 100
        double montoDescuento = (precio * descuento) / 100;

        // Restamos el monto del descuento al precio original para obtener el precio final
        double precioFinal = precio - montoDescuento;

        // Mostramos el precio final al usuario, con dos decimales
        System.out.printf("Precio final: %.2f\n", precioFinal);

        // Cerramos el objeto scanner para liberar recursos
        scanner.close();
    }
}