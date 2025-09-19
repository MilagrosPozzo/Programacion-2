/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// Archivo: Nacional.java
// Clase que representa artículos nacionales y extiende Articulo
public class Nacional extends Articulo {
    // ¿El artículo es subsidiado?
    private boolean subsidiado;
    // ¿Es de Montevideo? (si no, consideramos "interior")
    private boolean esMontevideo;

    /**
     * Constructor:
     * nombre, precioCosto: heredados
     * subsidiado: true si mantiene el precio inicial
     * esMontevideo: true si se aplica el recargo del 15%, false -> recargo 10%
     */
    public Nacional(String nombre, double precioCosto, boolean subsidiado, boolean esMontevideo) {
        super(nombre, precioCosto);
        this.subsidiado = subsidiado;
        this.esMontevideo = esMontevideo;
    }

    /**
     * Reglas (según enunciado):
     * - Si subsidiado: mantiene precio inicial (sin cambios)
     * - Si NO subsidiado:
     *     - si es del interior -> +10% sobre el precio inicial
     *     - si es de Montevideo -> +15% sobre el precio inicial
     *
     * Implementación:
     * Usamos precioVentaInicial() de la clase base y luego aplicamos multiplicadores:
     *  +10% -> multiplicar por 1.10
     *  +15% -> multiplicar por 1.15
     */
    @Override
    public double getPrecioVenta() {
        double base = precioVentaInicial();

        if (subsidiado) {
            // mantiene precio inicial
            return base;
        } else {
            // aplica recargo según ubicación
            if (esMontevideo) {
                return base * 1.15; // +15%
            } else {
                return base * 1.10; // +10%
            }
        }
    }

    // Getters para usar en la clase de prueba
    public boolean isSubsidiado() {
        return subsidiado;
    }

    public boolean isEsMontevideo() {
        return esMontevideo;
    }

    @Override
    public String toString() {
        return String.format("%s (Nacional) - subsidiado: %s, Montevideo: %s",
                getNombre(), (subsidiado ? "sí" : "no"), (esMontevideo ? "sí" : "no"));
    }
}
