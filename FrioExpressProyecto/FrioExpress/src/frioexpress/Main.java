/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Milagros Pozzo
 */
package frioexpress; // Indicamos que esta clase está en el paquete frioexpress

// Importamos todas las excepciones que vamos a usar en las pruebas
import frioexpress.excepciones.*;

public class Main {
    // Método principal: el punto de entrada cuando ejecutamos el programa
    public static void main(String[] args) {
        // Creamos el sistema FrioExpress, que manejará productos y pedidos
        SistemaFrioExpress sistema = new SistemaFrioExpress();

        // ================================
        // 1) REGISTRAMOS PRODUCTOS DE PRUEBA
        // ================================
        sistema.registrarProducto(new Producto(101, "Pollo", "Carnes", -18, 50, 10, 2000));
        sistema.registrarProducto(new Producto(102, "Salmón", "Pescados", -18, 30, 5, 5000));
        sistema.registrarProducto(new Producto(103, "Verduras", "Vegetales", -18, 8, 8, 1500));

        // ================================
        // 2) REGISTRAMOS CLIENTES DE PRUEBA
        // ================================
        Cliente c1 = new Cliente("111-1", "Supermercado A", "Av. Central", 100000, 0);
        Cliente c2 = new Cliente("222-2", "Restaurante B", "Calle Larga", 20000, 0);

        // ================================
        // 3) CASO DE PRUEBA: PEDIDO VÁLIDO
        // ================================
        try {
            Pedido p1 = new Pedido(c1);       // Creamos un pedido para cliente 1
            p1.agregarItem(101, 5);           // Pide 5kg de pollo (hay suficiente stock)
            sistema.procesarPedido(p1);       // Procesamos el pedido
            System.out.println("✅ Pedido válido procesado correctamente.");
        } catch (Exception e) {
            // Si algo falla mostramos el mensaje de error
            System.out.println("Error en pedido válido: " + e.getMessage());
        }

        // ================================
        // 4) CASO DE PRUEBA: STOCK INSUFICIENTE
        // ================================
        try {
            Pedido p2 = new Pedido(c1);       // Pedido para el mismo cliente
            p2.agregarItem(102, 100);         // Pide 100kg de salmón (solo hay 30)
            sistema.procesarPedido(p2);       // Esto debería lanzar excepción
        } catch (StockInsuficienteException e) {
            System.out.println(" Stock insuficiente detectado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Otro error: " + e.getMessage());
        }

        // ================================
        // 5) CASO DE PRUEBA: CRÉDITO INSUFICIENTE
        // ================================
        try {
            Pedido p3 = new Pedido(c2);       // Pedido para cliente 2
            p3.agregarItem(101, 20);          // 20kg de pollo * $2000 = $40.000
                                              // Cliente 2 tiene crédito solo de $20.000
            sistema.procesarPedido(p3);       // Esto debería lanzar excepción
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println(" Crédito excedido: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Otro error: " + e.getMessage());
        }

        // ================================
        // 6) REPORTES DEL SISTEMA
        // ================================
        System.out.println("\nInventario actual:");
        sistema.mostrarInventario(); // Muestra todos los productos con sus stocks

        System.out.println("\nProductos bajo stock mínimo:");
        sistema.productosBajoStockMinimo(); // Muestra los productos que llegaron al mínimo

        System.out.println("\nPedidos pendientes:");
        sistema.listarPedidosPendientes(); // Muestra los pedidos procesados con éxito
    }
}