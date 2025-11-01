/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
package frioexpress.excepciones; // Pertenece al paquete de excepciones

// Excepción personalizada que indica si el producto estuvo demasiado tiempo fuera de la temperatura
public class CadenaFrioRotaException extends Exception {
    public CadenaFrioRotaException(String mensaje) {
        super(mensaje); // Pasamos el mensaje a la clase padre Exception
    }
}