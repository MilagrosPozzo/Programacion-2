/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
public class Problema_887 {
/*
Problema 887 - Árbol Binario de Búsqueda

Enunciado:
Andrea escribió una función en Java para eliminar un nodo en un árbol binario,
pero no devuelve correctamente la nueva raíz ni actualiza las referencias al eliminar.

Código con error (versión de Andrea):
if (root.izquierda == null)
    root = root.derecha;
else if (root.derecha == null)
    root = root.izquierda;
else {
    Nodo temp = buscarMinimo(root.derecha);
    root.valor = temp.valor;
    eliminarNodo(root.derecha, temp.valor); //  No reasigna root.derecha
}

Explicación del error:
Al eliminar un nodo con dos hijos, Andrea reemplaza el valor del nodo actual con su
sucesor (el menor valor del subárbol derecho), pero olvida actualizar la referencia:
root.derecha = eliminarNodo(root.derecha, temp.valor);

Solución:
Se corrige la llamada recursiva y se reestructura el método para devolver correctamente
la nueva raíz en todos los casos.
*/
    //Clase Nodo representa cada elemento del árbol binario
    static class Nodo {
        int valor;              // Número entero almacenado en el nodo
        Nodo izquierda, derecha; // Enlaces hacia los nodos hijo izquierdo y derecho

        // Constructor: inicializa el nodo con un valor
        Nodo(int valor) {
            this.valor = valor;
        }
    }

    // Método principal: punto de inicio del programa
    public static void main(String[] args) {
        // Se crea manualmente un árbol binario de búsqueda con varios nodos
        Nodo root = new Nodo(50);
        root.izquierda = new Nodo(30);
        root.derecha = new Nodo(70);
        root.izquierda.izquierda = new Nodo(20);
        root.izquierda.derecha = new Nodo(40);
        root.derecha.izquierda = new Nodo(60);
        root.derecha.derecha = new Nodo(80);

        // Se muestra el árbol en orden (de menor a mayor)
        System.out.println("Árbol en orden (antes de eliminar):");
        imprimirEnOrden(root);

        // Se elimina el nodo con valor 70 del árbol
        root = eliminarNodo(root, 70);

        // Se muestra el árbol nuevamente después de la eliminación
        System.out.println("\nÁrbol en orden (después de eliminar 70):");
        imprimirEnOrden(root);
    }

    /**
     * Método recursivo para eliminar un nodo del árbol binario de búsqueda.
     * @param root La raíz del subárbol actual.
     * @param valor El valor del nodo que se desea eliminar.
     * @return La nueva raíz del subárbol luego de eliminar el nodo.
     */
    public static Nodo eliminarNodo(Nodo root, int valor) {
        if (root == null) return null; // Si el árbol está vacío, no hay nada que eliminar

        if (valor < root.valor) {
            // El valor a eliminar está en la subrama izquierda
            root.izquierda = eliminarNodo(root.izquierda, valor);
        } else if (valor > root.valor) {
            // El valor a eliminar está en la subrama derecha
            root.derecha = eliminarNodo(root.derecha, valor);
        } else {
            //  Se encontró el nodo con el valor buscado

            // Caso 1: el nodo no tiene hijo izquierdo
            if (root.izquierda == null) {
                return root.derecha; // Se reemplaza por el hijo derecho
            }

            // Caso 2: el nodo no tiene hijo derecho
            else if (root.derecha == null) {
                return root.izquierda; // Se reemplaza por el hijo izquierdo
            }

            // Caso 3: el nodo tiene dos hijos
            // Se busca el nodo con menor valor en el subárbol derecho
            Nodo temp = buscarMinimo(root.derecha);

            // Se reemplaza el valor actual con el del sucesor
            root.valor = temp.valor;

            // Se elimina el nodo duplicado en el subárbol derecho
            root.derecha = eliminarNodo(root.derecha, temp.valor);
        }

        return root; // Se retorna la nueva raíz (puede ser la misma o modificada)
    }

    /**
     * Método auxiliar para encontrar el nodo con el valor mínimo.
     * En un ABB, es el nodo más a la izquierda.
     */
    public static Nodo buscarMinimo(Nodo nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda; // Avanza hasta llegar al último nodo izquierdo
        }
        return nodo; // Este es el nodo con el menor valor
    }

    /**
     *  Método que imprime los valores del árbol en orden (in-order traversal)
     * Imprime primero la rama izquierda, luego el nodo actual, y luego la derecha.
     */
    public static void imprimirEnOrden(Nodo nodo) {
        if (nodo != null) {
            imprimirEnOrden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            imprimirEnOrden(nodo.derecha);
        }
    }
}