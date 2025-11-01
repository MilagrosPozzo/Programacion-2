/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
package frioexpress; // Este archivo pertenece al paquete frioexpress

// Importamos nuestras excepciones personalizadas que puede usar Producto
import frioexpress.excepciones.*;

public class Producto {
    // Atributos del producto: información básica que necesitamos
    private int codigo;          // Código único del producto
    private String nombre;       // Nombre del producto
    private String categoria;    // Categoría (Carnes, Pescados, etc.)
    private double temperatura;  // Temperatura de conservación
    private double stockKg;      // Stock actual en kilos
    private double stockMinimo;  // Stock mínimo permitido
    private double precioKg;     // Precio por kilo

    // Constructor: nos permite crear un producto con todos sus datos
    public Producto(int codigo, String nombre, String categoria,
                    double temperatura, double stockKg,
                    double stockMinimo, double precioKg) {
        this.codigo = codigo;         // Asignamos el código
        this.nombre = nombre;         // Asignamos el nombre
        this.categoria = categoria;   // Asignamos la categoría
        this.temperatura = temperatura; // Asignamos la temperatura de conservación
        this.stockKg = stockKg;       // Asignamos el stock inicial
        this.stockMinimo = stockMinimo; // Asignamos el stock mínimo
        this.precioKg = precioKg;     // Asignamos el precio por kilo
    }

    // Métodos para leer datos (getters)
    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getStockKg() { return stockKg; }
    public double getStockMinimo() { return stockMinimo; }
    public double getPrecioKg() { return precioKg; }

    // Método para ingresar más mercadería al stock
    public void ingresarMercaderia(double cantidad) {
        stockKg += cantidad; // Sumamos la cantidad al stock actual
    }

    // Validamos si una venta se puede hacer sin problemas
    public void validarVenta(double cantidad)
            throws StockInsuficienteException, StockMinimoAlcanzadoException {
        if (cantidad > stockKg) { // Si el cliente pide más de lo que hay
            throw new StockInsuficienteException("No hay suficiente stock de " + nombre);
        }
        if (stockKg - cantidad <= stockMinimo) { // Si al vender quedamos en el mínimo
            throw new StockMinimoAlcanzadoException("Stock mínimo alcanzado para " + nombre);
        }
    }

    // Aplicamos la venta (ya validada)
    public void aplicarVenta(double cantidad) {
        stockKg -= cantidad; // Restamos la cantidad vendida
    }

    // Representación en texto del producto
    @Override
    public String toString() {
        return codigo + " - " + nombre + " | " + categoria +
                " | Stock: " + stockKg + "kg | Min: " + stockMinimo + "kg | $" + precioKg;
    }
}