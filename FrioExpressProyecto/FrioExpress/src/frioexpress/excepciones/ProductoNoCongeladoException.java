/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
package frioexpress.excepciones; // Paquete de excepciones

// Excepción personalizada que se lanza cuando buscamos un producto que no existe
public class ProductoNoCongeladoException extends Exception {
    public ProductoNoCongeladoException(String mensaje) {
        super(mensaje); // El mensaje dirá qué código no fue encontrado
    }
}