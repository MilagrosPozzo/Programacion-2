/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Milagros Pozzo
 */
package frioexpress.excepciones; // Paquete de excepciones

// Excepción personalizada que usamos cuando un cliente supera su límite de crédito
public class LimiteCreditoExcedidoException extends Exception {
    public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje); // Guardamos el mensaje explicativo
    }
}