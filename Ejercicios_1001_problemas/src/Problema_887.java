/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class Problema_887 {
    
}
// Clase Nodo: estructura básica de un árbol binario
    static class Nodo {
        int valor;              // Valor que guarda el nodo
        Nodo izquierda, derecha; // Referencias a sus hijos izquierdo y derecho

        // Constructor para crear un nodo con un valor
        Nodo(int valor) {
            this.valor = valor;
        }
    }

    //  Método principal para ejecutar el programa
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

        //  Eliminamos un nodo (en este caso, 70)
        root = eliminarNodo(root, 70);

        // Imprimimos el árbol luego de eliminar el nodo
        System.out.println("\nÁrbol en orden (después de eliminar 70):");
        imprimirEnOrden(root);
    }

    //  Método recursivo para eliminar un nodo de un árbol binario de búsqueda
    public static Nodo eliminarNodo(Nodo root, int valor) {
        // Si el árbol está vacío, retornamos null
        if (root == null) return null;

        // Si el valor a eliminar es menor, buscar en la subrama izquierda
        if (valor < root.valor) {
            root.izquierda = eliminarNodo(root.izquierda, valor);
        }

        // Si el valor a eliminar es mayor, buscar en la subrama derecha
        else if (valor > root.valor) {
            root.derecha = eliminarNodo(root.derecha, valor);
        }

        //  Si encontramos el nodo que contiene el valor a eliminar
        else {
            // CASO 1: El nodo no tiene hijo izquierdo → lo reemplazamos por su hijo derecho
            if (root.izquierda == null) {
                return root.derecha;
            }

            // CASO 2: El nodo no tiene hijo derecho → lo reemplazamos por su hijo izquierdo
            else if (root.derecha == null) {
                return root.izquierda;
            }

            // CASO 3: El nodo tiene dos hijos
            // Buscamos el sucesor in-order (el menor valor del subárbol derecho)
            Nodo temp = buscarMinimo(root.derecha);

            // Copiamos ese valor en el nodo actual
            root.valor = temp.valor;

            // Eliminamos el nodo que fue copiado, desde el subárbol derecho
            // IMPORTANTE: Reasignamos la rama derecha
            root.derecha = eliminarNodo(root.derecha, temp.valor);
        }

        // Devolvemos la nueva raíz (puede ser la misma si no se reemplazó)
        return root;
    }

    // Método para encontrar el valor mínimo en un subárbol (el más a la izquierda)
    public static Nodo buscarMinimo(Nodo nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }

    // Método para imprimir el árbol en orden (in-order)
    // Esto imprime los valores de menor a mayor
    public static void imprimirEnOrden(Nodo nodo) {
        if (nodo != null) {
            imprimirEnOrden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            imprimirEnOrden(nodo.derecha);
        }
    }
}
