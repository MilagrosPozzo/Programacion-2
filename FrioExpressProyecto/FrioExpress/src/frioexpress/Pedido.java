/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
package frioexpress; // Paquete principal

import java.util.*; // Importamos utilidades para usar HashMap

public class Pedido {
    private static int contador = 1; // Contador para asignar IDs automáticos
    private int id;                  // ID único del pedido
    private Cliente cliente;         // Cliente que hace el pedido
    private Map<Integer, Double> items; // Productos solicitados (código -> kilos)
    private boolean procesado;       // Si ya fue procesado o no

    // Constructor: recibe un cliente y prepara un pedido vacío
    public Pedido(Cliente cliente) {
        this.id = contador++;        // Asignamos un ID único
        this.cliente = cliente;      // Guardamos el cliente
        this.items = new HashMap<>();// Inicializamos el mapa de productos
        this.procesado = false;      // Al inicio no está procesado
    }

    // Método para agregar productos al pedido
    public void agregarItem(int codigo, double kilos) {
        // Si el producto ya estaba en el pedido, sumamos kilos
        items.put(codigo, items.getOrDefault(codigo, 0.0) + kilos);
    }

    public Cliente getCliente() { return cliente; }
    public Map<Integer, Double> getItems() { return items; }
    public void marcarProcesado() { procesado = true; }

    @Override
    public String toString() {
        return "Pedido " + id + " de " + cliente.getRazonSocial() +
                " con " + items.size() + " items.";
    }
}
