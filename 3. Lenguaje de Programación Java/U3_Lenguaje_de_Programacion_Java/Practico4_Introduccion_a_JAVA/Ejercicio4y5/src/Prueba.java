/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// Archivo: Prueba.java
// Clase con main para crear y probar distintos artículos (Ejercicio 5)
import java.util.ArrayList;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {
        // Creamos una lista para agregar varios artículos de prueba
        List<Articulo> articulos = new ArrayList<>();

        // 3 artículos nacionales:
        //  - subsidiado (debe mantener precio inicial)
        //  - no subsidiado del interior (+10%)
        //  - no subsidiado Montevideo (+15%)
        articulos.add(new Nacional("Pan de campo", 100.00, true, false));   // subsidiado
        articulos.add(new Nacional("Queso", 200.00, false, false));         // interior (no subsidiado)
        articulos.add(new Nacional("Mate", 150.00, false, true));           // Montevideo (no subsidiado)

        // 2 artículos importados:
        //  - importado en 2005 -> se suma 80% del impuesto
        //  - importado en 2015 -> se suma 100% del impuesto
        articulos.add(new Importado("TV 42\"", 1000.00, 200.00, 2005));
        articulos.add(new Importado("Smartphone X", 600.00, 150.00, 2015));

        // Recorremos y mostramos desglosado para entender los cálculos
        System.out.println("=== RESULTADOS DE PRUEBA ===");
        for (Articulo a : articulos) {
            System.out.println("-------------------------------");
            System.out.println("Nombre: " + a.getNombre());
            System.out.printf("Precio de costo: $%.2f%n", a.getPrecioCosto());

            // precio inicial = costo + 20%
            System.out.printf("Precio de venta inicial (costo + 20%%): $%.2f%n", a.precioVentaInicial());

            // Si es Nacional mostramos detalles de subsidio/ubicación
            if (a instanceof Nacional) {
                Nacional n = (Nacional) a;
                System.out.println("Tipo: Nacional");
                System.out.println("Subsidiado: " + (n.isSubsidiado() ? "Sí" : "No"));
                System.out.println("Ubicación: " + (n.isEsMontevideo() ? "Montevideo" : "Interior"));

                // mostramos el precio final calculado
                System.out.printf("Precio de venta final: $%.2f%n", n.getPrecioVenta());
            }
            // Si es Importado mostramos impuesto y año
            else if (a instanceof Importado) {
                Importado imp = (Importado) a;
                System.out.println("Tipo: Importado");
                System.out.printf("Año de importación: %d%n", imp.getAnioImportacion());
                System.out.printf("Impuesto (monto): $%.2f%n", imp.getImpuesto());

                // calculamos y mostramos el monto adicional (80% o 100%)
                double adicional = (imp.getAnioImportacion() <= 2008) ? imp.getImpuesto() * 0.8 : imp.getImpuesto();
                System.out.printf("Adicional aplicado al precio (según año): $%.2f%n", adicional);

                // precio final
                System.out.printf("Precio de venta final: $%.2f%n", imp.getPrecioVenta());
            }
            // Caso genérico (si se crea cualquier otro Articulo en el futuro)
            else {
                System.out.println("Tipo: Artículo genérico");
                System.out.printf("Precio de venta final: $%.2f%n", a.getPrecioVenta());
            }
        }
        System.out.println("=============================");
    }
}