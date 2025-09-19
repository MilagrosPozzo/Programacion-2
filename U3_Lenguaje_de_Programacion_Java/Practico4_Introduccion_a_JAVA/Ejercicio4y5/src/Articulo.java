/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// Archivo: Articulo.java
// Clase base para todos los artículos (no lleva acento en el nombre de la clase para evitar problemas con nombres de archivos)
public class Articulo {
    // Atributos básicos: nombre y precio de costo
    private String nombre;
    private double precioCosto;

    // Constructor
    public Articulo(String nombre, double precioCosto) {
        this.nombre = nombre;
        this.precioCosto = precioCosto;
    }

    /**
     * precioVentaInicial:
     * Según el enunciado, el precio de venta inicial = precio de costo + 20%
     * Matemáticamente: costo * 1.2
     * Lo dejamos en un método para poder reutilizarlo en subclases.
     */
    public double precioVentaInicial() {
        return precioCosto * 1.2;
    }

    /**
     * getPrecioVenta:
     * Método que devuelve el precio de venta final.
     * En la clase base devolvemos el precio inicial; las subclases (Nacional/Importado)
     * sobreescribirán este método para aplicar las reglas específicas.
     */
    public double getPrecioVenta() {
        return precioVentaInicial();
    }

    // Getters (útiles para mostrar datos desde la clase Prueba)
    public String getNombre() {
        return nombre;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    @Override
    public String toString() {
        return String.format("%s (costo: $%.2f)", nombre, precioCosto);
    }
}