/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
package frioexpress; // Paquete principal

import frioexpress.excepciones.LimiteCreditoExcedidoException; // Importamos excepción necesaria

public class Cliente {
    // Datos básicos del cliente
    private String rut;           // Identificación del cliente
    private String razonSocial;   // Nombre del cliente
    private String direccion;     // Dirección
    private double limiteCredito; // Límite de crédito total
    private double deudaActual;   // Deuda actual

    // Constructor: inicializamos todos los datos
    public Cliente(String rut, String razonSocial, String direccion,
                   double limiteCredito, double deudaActual) {
        this.rut = rut;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.limiteCredito = limiteCredito;
        this.deudaActual = deudaActual;
    }

    public String getRut() { return rut; }
    public String getRazonSocial() { return razonSocial; }
    public double getCreditoDisponible() { return limiteCredito - deudaActual; }

    // Método para aumentar la deuda si aún hay crédito disponible
    public void aumentarDeuda(double monto) throws LimiteCreditoExcedidoException {
        if (monto > getCreditoDisponible()) {
            throw new LimiteCreditoExcedidoException("Crédito insuficiente para " + razonSocial);
        }
        deudaActual += monto; // Sumamos el monto a la deuda
    }

    @Override
    public String toString() {
        return "Cliente: " + razonSocial + " (RUT: " + rut + ") | Crédito: " + limiteCredito + " | Deuda: " + deudaActual;
    }
}