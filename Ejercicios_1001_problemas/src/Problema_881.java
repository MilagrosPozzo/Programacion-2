/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
/*
 * Problema 881 - Liberar una lista enlazada en Java
 * Enunciado:
 * Carlos intenta liberar una lista en Java, pero solo anula las referencias sin recorrer ni eliminar cada nodo adecuadamente.
 *
 * Código incorrecto:
 * while (head != null) {
 *     Node temp = head;
 *     temp = null; // No desvincula ni avanza en la lista
 * }
 */

public class Problema_881 {

    // Definimos clase Nodo para una lista enlazada simple
    static class Nodo {
        int valor;
        Nodo siguiente;

        Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public static void main(String[] args) {
        // Creamos manualmente una lista enlazada: 1 -> 2 -> 3
        Nodo head = new Nodo(1);
        head.siguiente = new Nodo(2);
        head.siguiente.siguiente = new Nodo(3);

        // Liberamos la lista correctamente
        head = liberarLista(head);

        // Verificamos si la lista está vacía
        if (head == null) {
            System.out.println("La lista ha sido liberada correctamente.");
        } else {
            System.out.println("La lista no se liberó correctamente.");
        }
    }

    /**
     * Método que libera correctamente cada nodo de la lista enlazada.
     * Recorre la lista nodo por nodo y desvincula la referencia al siguiente.
     */
    public static Nodo liberarLista(Nodo head) {
        while (head != null) {
            Nodo temp = head;        // Guardamos el nodo actual
            head = head.siguiente;   // Avanzamos al siguiente nodo
            temp.siguiente = null;   // Desvinculamos el nodo actual
        }
        return null; // Retornamos null indicando que la lista está vacía
    }
}