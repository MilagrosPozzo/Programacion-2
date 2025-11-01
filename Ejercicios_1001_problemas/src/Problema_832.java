/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
public class Problema_832 {
    
// Problema_832: Crea un método recursivo que ordene una lista enlazada de enteros en orden ascendente.
    
    // Clase Nodo que representa cada elemento de la lista enlazada
    static class Nodo {
        int valor;
        Nodo siguiente;

        Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Creamos manualmente una lista enlazada desordenada: 4 → 2 → 5 → 1 → 3
        Nodo cabeza = new Nodo(4);
        cabeza.siguiente = new Nodo(2);
        cabeza.siguiente.siguiente = new Nodo(5);
        cabeza.siguiente.siguiente.siguiente = new Nodo(1);
        cabeza.siguiente.siguiente.siguiente.siguiente = new Nodo(3);

        System.out.println("Lista original:");
        imprimirLista(cabeza);

        // Ordenamos la lista usando Merge Sort recursivo
        cabeza = mergeSort(cabeza);

        System.out.println("Lista ordenada:");
        imprimirLista(cabeza);
    }

    // Método para imprimir todos los elementos de la lista
    public static void imprimirLista(Nodo nodo) {
        while (nodo != null) {
            System.out.print(nodo.valor + " ");
            nodo = nodo.siguiente;
        }
        System.out.println();
    }

    // Método principal de Merge Sort (recursivo)
    public static Nodo mergeSort(Nodo cabeza) {
        // Caso base: si la lista está vacía o tiene solo un nodo, está ordenada
        if (cabeza == null || cabeza.siguiente == null) {
            return cabeza;
        }

        // Dividimos la lista en dos mitades
        Nodo medio = encontrarMitad(cabeza);
        Nodo siguienteMitad = medio.siguiente;
        medio.siguiente = null; // Cortamos la lista en dos

        // Ordenamos recursivamente ambas mitades
        Nodo izquierda = mergeSort(cabeza);
        Nodo derecha = mergeSort(siguienteMitad);

        // Mezclamos (merge) las mitades ordenadas
        return mezclarListas(izquierda, derecha);
    }

    // Método para encontrar el nodo en la mitad de la lista (técnica slow/fast)
    public static Nodo encontrarMitad(Nodo cabeza) {
        Nodo lento = cabeza;
        Nodo rapido = cabeza.siguiente;

        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;
        }
        return lento;
    }

    // Método para mezclar dos listas ordenadas
    public static Nodo mezclarListas(Nodo l1, Nodo l2) {
        // Nodo temporal para construir la lista ordenada
        Nodo resultado;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.valor <= l2.valor) {
            resultado = l1;
            resultado.siguiente = mezclarListas(l1.siguiente, l2);
        } else {
            resultado = l2;
            resultado.siguiente = mezclarListas(l1, l2.siguiente);
        }

        return resultado;
    }
}