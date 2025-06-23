/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class Problema_887 {

    // Clase Nodo: estructura básica de un árbol binario
    static class Nodo {
        int valor;              // Valor que guarda el nodo
        Nodo izquierda, derecha; // Referencias a sus hijos izquierdo y derecho

        // Constructor para crear un nodo con un valor
        Nodo(int valor) {
            this.valor = valor;
        }
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        // Creamos un árbol binario de búsqueda manualmente
        Nodo root = new Nodo(50);
        root.izquierda = new Nodo(30);
        root.derecha = new Nodo(70);
        root.izquierda.izquierda = new Nodo(20);
        root.izquierda.derecha = new Nodo(40);
        root.derecha.izquierda = new Nodo(60);
        root.derecha.derecha = new Nodo(80);

        // Imprimimos el árbol original en orden (de menor a mayor)
        System.out.println("Árbol en orden (antes de eliminar):");
        imprimirEnOrden(root);

        // Eliminamos un nodo (en este caso, 70)
        root = eliminarNodo(root, 70);

        // Imprimimos el árbol luego de eliminar el nodo
        System.out.println("\nÁrbol en orden (después de eliminar 70):");
        imprimirEnOrden(root);
    }

    // Método recursivo para eliminar un nodo de un árbol binario de búsqueda
    public static Nodo eliminarNodo(Nodo root, int valor) {
        if (root == null) return null;

        if (valor < root.valor) {
            root.izquierda = eliminarNodo(root.izquierda, valor);
        } else if (valor > root.valor) {
            root.derecha = eliminarNodo(root.derecha, valor);
        } else {
            if (root.izquierda == null) {
                return root.derecha;
            } else if (root.derecha == null) {
                return root.izquierda;
            }

            Nodo temp = buscarMinimo(root.derecha);
            root.valor = temp.valor;
            root.derecha = eliminarNodo(root.derecha, temp.valor);
        }

        return root;
    }

    // Método para encontrar el valor mínimo en un subárbol
    public static Nodo buscarMinimo(Nodo nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }

    // Método para imprimir el árbol en orden (in-order)
    public static void imprimirEnOrden(Nodo nodo) {
        if (nodo != null) {
            imprimirEnOrden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            imprimirEnOrden(nodo.derecha);
        }
    }
}
