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
    // Esta clase representa un nodo de la lista enlazada
    static class Nodo {
        int dato;              // El valor que guarda el nodo
        Nodo siguiente;        // Puntero al siguiente nodo

        Nodo(int dato) {
            this.dato = dato;  // Guardamos el valor recibido
            this.siguiente = null; // Inicialmente no apunta a ningún nodo
        }
    }

    // Clase que maneja la lista enlazada
    static class ListaEnlazada {
        Nodo cabeza; // Nodo principal o inicio de la lista

        // Método para agregar un nuevo número al final de la lista
        public void agregar(int dato) {
            Nodo nuevo = new Nodo(dato); // Creamos un nuevo nodo con el dato

            // Si la lista está vacía, el nuevo nodo será la cabeza
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                // Recorremos la lista hasta el último nodo
                Nodo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                // Agregamos el nuevo nodo al final
                actual.siguiente = nuevo;
            }
        }

        // Método que inicia la ordenación recursiva
        public void ordenar() {
            cabeza = ordenarRecursivo(cabeza); // Llamamos al método recursivo y actualizamos la cabeza
        }

        // Método recursivo que ordena la lista enlazada
        private Nodo ordenarRecursivo(Nodo inicio) {
            // Caso base: si la lista está vacía o tiene un solo nodo, ya está ordenada
            if (inicio == null || inicio.siguiente == null) {
                return inicio;
            }

            // Dividimos la lista en dos mitades
            Nodo mitad = obtenerMitad(inicio); // Obtenemos el nodo del medio
            Nodo siguienteMitad = mitad.siguiente; // Guardamos la segunda mitad
            mitad.siguiente = null; // Cortamos la lista en dos partes

            // Ordenamos recursivamente cada mitad
            Nodo izquierda = ordenarRecursivo(inicio);       // Ordenamos la primera mitad
            Nodo derecha = ordenarRecursivo(siguienteMitad); // Ordenamos la segunda mitad

            // Mezclamos las dos mitades ya ordenadas
            return mezclarListas(izquierda, derecha);
        }

        // Método para encontrar el nodo de la mitad de la lista
        private Nodo obtenerMitad(Nodo inicio) {
            if (inicio == null) return null;

            Nodo lento = inicio;         // Se mueve de uno en uno
            Nodo rapido = inicio.siguiente; // Se mueve de dos en dos

            // Avanzamos los punteros hasta que rápido llegue al final
            while (rapido != null && rapido.siguiente != null) {
                lento = lento.siguiente;
                rapido = rapido.siguiente.siguiente;
            }

            return lento; // Lento estará en la mitad
        }

        // Mezcla dos listas ordenadas en una sola lista ordenada
        private Nodo mezclarListas(Nodo a, Nodo b) {
            // Si una lista está vacía, devolvemos la otra
            if (a == null) return b;
            if (b == null) return a;

            Nodo resultado;

            // Comparamos los valores y elegimos el menor para agregar al resultado
            if (a.dato <= b.dato) {
                resultado = a;
                resultado.siguiente = mezclarListas(a.siguiente, b); // Llamada recursiva
            } else {
                resultado = b;
                resultado.siguiente = mezclarListas(a, b.siguiente); // Llamada recursiva
            }

            return resultado;
        }

        // Método para imprimir los valores de la lista
        public void imprimir() {
            Nodo actual = cabeza; // Empezamos desde la cabeza
            while (actual != null) {
                System.out.print(actual.dato + " "); // Imprimimos el valor
                actual = actual.siguiente; // Avanzamos al siguiente nodo
            }
            System.out.println(); // Salto de línea al final
        }
    }

    // Método principal: punto de entrada del programa
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada(); // Creamos una lista nueva

        // Agregamos números a la lista (puedes cambiar estos valores)
        lista.agregar(4);
        lista.agregar(2);
        lista.agregar(5);
        lista.agregar(1);
        lista.agregar(3);

        System.out.println("Lista original:");
        lista.imprimir(); // Mostramos la lista antes de ordenar

        lista.ordenar(); // Llamamos al método que ordena la lista

        System.out.println("Lista ordenada:");
        lista.imprimir(); // Mostramos la lista ya ordenada
    }
}