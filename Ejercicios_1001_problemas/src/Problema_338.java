/*
 * Problema 338 - Combinar clases, interfaces y arreglos en Java
 *
 * Enunciado:
 * ¿Cómo combinar clase o interfaces y arreglos en Java para representar estructuras más complejas?
 *
 *  Explicación general:
 * - Una clase en Java define un "molde" para crear objetos (atributos + métodos).
 * - Una interfaz define comportamientos que una clase puede implementar.
 * - Los arreglos permiten almacenar múltiples elementos de un mismo tipo.
 * - Si combinamos estas tres cosas, podemos crear estructuras más completas.
 *
 * En este ejemplo:
 * - Definimos una interfaz SerVivo.
 * - Creamos una clase Estudiante que implementa la interfaz.
 * - Creamos un arreglo de Estudiantes para representar una lista.
 */

/**
 * Autor: Milagros Pozzo
 */
public class Problema_338 {

    // Definimos una interfaz con un método común
    interface SerVivo {
        void mostrarInformacion();
    }

    // Creamos una clase que implementa la interfaz
    static class Estudiante implements SerVivo {
        String nombre;   // Atributo: nombre del estudiante
        int edad;        // Atributo: edad del estudiante

        // Constructor: inicializa los atributos
        Estudiante(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        // Implementación del método de la interfaz
        @Override
        public void mostrarInformacion() {
            System.out.println("Nombre: " + nombre + ", Edad: " + edad);
        }
    }

    // Método principal: punto de entrada del programa
    public static void main(String[] args) {

        // Creamos un arreglo de Estudiantes con tamaño fijo
        Estudiante[] lista = new Estudiante[3];
        // Un arreglo de objetos permite guardar varios estudiantes en la misma estructura.

        // Asignamos valores al arreglo (cada posición es un Estudiante)
        lista[0] = new Estudiante("Ana", 20);
        lista[1] = new Estudiante("Luis", 22);
        lista[2] = new Estudiante("Marta", 19);

        // Recorremos el arreglo y mostramos la información
        System.out.println("Lista de estudiantes:");
        for (Estudiante e : lista) {
            e.mostrarInformacion();
        }
    }
}