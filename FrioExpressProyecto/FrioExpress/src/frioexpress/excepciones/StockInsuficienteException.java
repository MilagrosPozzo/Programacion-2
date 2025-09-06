/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
package frioexpress.excepciones; // Definimos que esta clase está dentro del paquete de excepciones

// Excepción personalizada que usamos cuando no hay stock suficiente
public class StockInsuficienteException extends Exception {
    // Constructor que recibe un mensaje para mostrar el error
    public StockInsuficienteException(String mensaje) {
        super(mensaje); // Llamamos al constructor de Exception para guardar el mensaje
    }
}