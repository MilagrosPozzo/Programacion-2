/*
 * Crear un ArrayList<Integer> con números enteros. El programa debe calcular y mostrar el promedio de
/ los valores.
 */
import java.util.ArrayList; // Para la lista dinámica
import java.util.Scanner;   // Para entrada de usuario

public class Desafio19_Catalogo_de_productos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Para leer desde consola
        // Explicación: Scanner conecta con la entrada estándar (teclado)
        
        System.out.print("¿Cuántos números enteros vas a ingresar? ");
        int n = Integer.parseInt(scanner.nextLine().trim()); // Número de valores
        // Explicación: parseInt convierte texto a entero; trim() quita espacios extra
        
        ArrayList<Integer> numeros = new ArrayList<>(); // Lista para almacenar enteros
        // Explicación: Integer es la versión objeto de int, necesaria para ArrayList
        
        for (int i = 0; i < n; i++) { // Bucle para ingresar cada número
            System.out.print("Ingrese entero #" + (i + 1) + ": ");
            int valor = Integer.parseInt(scanner.nextLine().trim()); // Leemos un entero
            // Explicación: Convertimos la entrada de texto a número entero
            numeros.add(valor); // Lo agregamos a la lista
            // Explicación: add() coloca el elemento al final del ArrayList
        }
        
        if (numeros.isEmpty()) { // Comprobamos si la lista está vacía
            // Explicación: isEmpty() retorna true si no hay elementos en la lista
            System.out.println("No se ingresaron números. No se puede calcular promedio.");
        } else {
            int suma = 0; // Variable para sumar
            // Explicación: Inicializamos en 0 para empezar a acumular
            
            for (int v : numeros) { // Recorremos cada número con for-each
                // Explicación: for-each toma automáticamente cada elemento de la lista
                suma += v; // Acumulamos cada valor en suma
                // Explicación: += es lo mismo que escribir: suma = suma + v
            }
            
            // Calculamos promedio como double para no perder decimales
            double promedio = (double) suma / numeros.size();
            // Explicación: (double) convierte suma a decimal; size() cuenta elementos
            
            System.out.printf("El promedio es: %.2f%n", promedio); // Mostramos con 2 decimales
            // Explicación: printf permite formatear; %.2f muestra exactamente 2 decimales
        }
        
        scanner.close(); // Cerramos scanner
        // Explicación: close() libera los recursos del scanner (buena práctica)
    }
}