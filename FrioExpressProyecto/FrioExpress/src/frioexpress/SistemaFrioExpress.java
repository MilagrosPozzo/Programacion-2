/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
package frioexpress; // Paquete principal

// Importamos las excepciones personalizadas
import frioexpress.excepciones.*;
import java.util.*;

public class SistemaFrioExpress {
    // Estructuras de datos principales
    private TreeMap<Integer, Producto> inventario; // Productos ordenados por código
    private List<Pedido> pedidosPendientes;        // Lista de pedidos procesados

    // Constructor: inicializa las colecciones
    public SistemaFrioExpress() {
        inventario = new TreeMap<>();
        pedidosPendientes = new ArrayList<>();
    }

    // Registrar un producto nuevo
    public void registrarProducto(Producto p) {
        inventario.put(p.getCodigo(), p);
    }

    // Buscar producto por código
    public Producto buscarProducto(int codigo) throws ProductoNoCongeladoException {
        Producto p = inventario.get(codigo);
        if (p == null) throw new ProductoNoCongeladoException("Código " + codigo + " no existe");
        return p;
    }

    // Procesar un pedido completo
    public void procesarPedido(Pedido pedido)
            throws ProductoNoCongeladoException, StockInsuficienteException,
                   StockMinimoAlcanzadoException, LimiteCreditoExcedidoException {
        double total = 0; // Total del pedido en dinero
        // Primero validamos cada producto
        for (Map.Entry<Integer, Double> e : pedido.getItems().entrySet()) {
            Producto p = buscarProducto(e.getKey());
            p.validarVenta(e.getValue());
            total += e.getValue() * p.getPrecioKg();
        }
        // Validamos crédito del cliente
        if (total > pedido.getCliente().getCreditoDisponible()) {
            throw new LimiteCreditoExcedidoException("Crédito insuficiente");
        }
        // Si todo bien, aplicamos venta y deuda
        for (Map.Entry<Integer, Double> e : pedido.getItems().entrySet()) {
            Producto p = buscarProducto(e.getKey());
            p.aplicarVenta(e.getValue());
        }
        pedido.getCliente().aumentarDeuda(total);
        pedido.marcarProcesado();
        pedidosPendientes.add(pedido);
    }

    // Mostrar inventario actual
    public void mostrarInventario() {
        for (Producto p : inventario.values()) {
            System.out.println(p);
        }
    }

    // Mostrar productos bajo stock mínimo
    public void productosBajoStockMinimo() {
        for (Producto p : inventario.values()) {
            if (p.getStockKg() <= p.getStockMinimo()) {
                System.out.println("Stock mínimo: " + p);
            }
        }
    }

    // Mostrar pedidos pendientes
    public void listarPedidosPendientes() {
        for (Pedido p : pedidosPendientes) {
            System.out.println(p);
        }
    }
}