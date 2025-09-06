/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
package frioexpress.excepciones; // Paquete de excepciones

// Excepción personalizada que usamos cuando una venta deja el stock en o debajo del mínimo
public class StockMinimoAlcanzadoException extends Exception {
    public StockMinimoAlcanzadoException(String mensaje) {
        super(mensaje); // Guardamos el mensaje que describe el problema
    }
}