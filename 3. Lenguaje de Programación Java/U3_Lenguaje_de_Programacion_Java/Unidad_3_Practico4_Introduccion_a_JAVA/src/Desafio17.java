// Desafío 17
// Implementar un programa que use un ArrayList<String> para almacenar nombres
// ingresados manualmente y luego mostrarlos en pantalla.

import java.util.ArrayList; // Para usar listas dinámicas
import java.util.Scanner;   // Para leer entrada de usuario

public class Desafio17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);          // Objeto para leer desde teclado
        ArrayList<String> nombres = new ArrayList<>(); // Lista dinámica de cadenas

        System.out.println("=== Programa Lista de Nombres ===");

        // Pedimos nombres hasta que el usuario escriba "fin"
        while (true) {
            System.out.print("Ingrese un nombre (o 'fin' para terminar): ");
            String nombre = sc.nextLine(); // Leer entrada del usuario

            if (nombre.equalsIgnoreCase("fin")) { // Condición de salida
                break;
            }
            nombres.add(nombre); // Agregamos el nombre a la lista
        }

        // Mostramos la lista de nombres ingresados
        System.out.println("\n=== Nombres ingresados ===");
        for (String n : nombres) {
            System.out.println(n);
        }

        sc.close(); // Cerramos el scanner (buena práctica)
    }
}