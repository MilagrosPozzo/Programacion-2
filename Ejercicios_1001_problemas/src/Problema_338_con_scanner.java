/*
 * Problema 338 - Combinar clases, interfaces y arreglos en Java
 *
 * Enunciado:
 * ¿Cómo combinar clase o interfaces y arreglos en Java para representar estructuras más complejas?
 *
 *  Explicación general:
 * - Una clase define un "molde" para crear objetos (atributos + métodos).
 * - Una interfaz define comportamientos que una clase puede implementar.
 * - Los arreglos permiten almacenar múltiples elementos de un mismo tipo.
 * - En este ejemplo, usamos Scanner para que el usuario cargue la lista de estudiantes manualmente.
 */

/**
 * Autor: Milagros Pozzo
 */

import java.util.Scanner; // Necesario para leer datos desde teclado

public class Problema_338_con_scanner {

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

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto para leer desde teclado

        // Preguntamos al usuario cuántos estudiantes quiere ingresar
        System.out.print("¿Cuántos estudiantes desea ingresar? ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpieza del buffer (evita problemas con nextLine después de nextInt)

        // Creamos un arreglo de Estudiantes con el tamaño ingresado
        Estudiante[] lista = new Estudiante[cantidad];

        // Recorremos el arreglo para llenar los datos desde teclado
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEstudiante #" + (i + 1));

            // Pedimos el nombre
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine(); // Lee una línea de texto

            // Pedimos la edad
            System.out.print("Ingrese la edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Limpieza del buffer otra vez

            // Creamos un nuevo estudiante y lo guardamos en el arreglo
            lista[i] = new Estudiante(nombre, edad);
        }

        // Mostramos todos los estudiantes ingresados
        System.out.println("\n Lista de estudiantes ingresados:");
        for (Estudiante e : lista) {
            e.mostrarInformacion();
        }

        // Cerramos el Scanner 
        scanner.close();
    }
}