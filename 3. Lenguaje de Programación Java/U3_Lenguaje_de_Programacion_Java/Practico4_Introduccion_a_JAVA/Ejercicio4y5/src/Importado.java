/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// Archivo: Importado.java
// Clase que representa artículos importados y extiende Articulo
public class Importado extends Articulo {
    // impuesto: valor monetario del impuesto (según enunciado interpretamos "impuesto" como un monto)
    private double impuesto;
    // año de importación para decidir si se aplica 80% o 100% del impuesto
    private int anioImportacion;

    public Importado(String nombre, double precioCosto, double impuesto, int anioImportacion) {
        super(nombre, precioCosto);
        this.impuesto = impuesto;
        this.anioImportacion = anioImportacion;
    }

    /**
     * Reglas (según enunciado):
     * - Calcular precio inicial = costo + 20% (lo da precioVentaInicial())
     * - Luego:
     *     - si fue importado hasta el año 2008 (<= 2008): se suma al precio inicial el 80% del impuesto
     *     - si fue importado luego de 2008 (> 2008): se suma la totalidad del impuesto
     *
     * Implementamos esa lógica y devolvemos base + adicional.
     */
    @Override
    public double getPrecioVenta() {
        double base = precioVentaInicial();
        double adicional;

        if (anioImportacion <= 2008) {
            adicional = impuesto * 0.8; // 80% del impuesto
        } else {
            adicional = impuesto; // 100% del impuesto
        }
        return base + adicional;
    }

    // Getters para mostrar información en la prueba
    public double getImpuesto() {
        return impuesto;
    }

    public int getAnioImportacion() {
        return anioImportacion;
    }

    @Override
    public String toString() {
        return String.format("%s (Importado) - año: %d, impuesto: $%.2f",
                getNombre(), anioImportacion, impuesto);
    }
}