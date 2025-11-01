/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 /*
 * Problema 854 - Sumar todos los nodos de un Binary Tree
 *
 * Enunciado:
 * Implementa un método `void` o `int` que recorra recursivamente un BinaryTree
 * y calcule la suma total de sus nodos.
 */

public class Problema_854 {

    // Clase Nodo: representa un nodo del árbol binario
    static class Nodo {
        int valor;           // Valor numérico del nodo
        Nodo izquierda;      // Referencia al hijo izquierdo
        Nodo derecha;        // Referencia al hijo derecho

        // Constructor: inicializa el nodo con un valor
        Nodo(int valor) {
            this.valor = valor;
            this.izquierda = null;
            this.derecha = null;
        }
    }

    // Método principal que crea el árbol y llama a la función de suma
    public static void main(String[] args) {
        // Creamos un árbol binario manualmente:
        /*
                    10
                   /  \
                  5    15
                 / \     \
                3   7     20
        */
        Nodo raiz = new Nodo(10);
        raiz.izquierda = new Nodo(5);
        raiz.derecha = new Nodo(15);
        raiz.izquierda.izquierda = new Nodo(3);
        raiz.izquierda.derecha = new Nodo(7);
        raiz.derecha.derecha = new Nodo(20);

        // Llamamos al método recursivo para calcular la suma total
        int suma = sumarArbol(raiz);

        // Mostramos el resultado por consola
        System.out.println("La suma total de los nodos es: " + suma);
    }

    /**
     * Método recursivo que calcula la suma total de los nodos de un árbol binario.
     *
     * Caso base: si el nodo es null, retorna 0.
     * Paso recursivo: suma el valor del nodo actual con las sumas de los subárboles izquierdo y derecho.
     */
    public static int sumarArbol(Nodo nodo) {
        if (nodo == null) {
            return 0; // Árbol vacío o rama terminada
        }

        // Línea más importante: se suman el nodo actual y las sumas de ambos subárboles
        return nodo.valor + sumarArbol(nodo.izquierda) + sumarArbol(nodo.derecha);
    }
}