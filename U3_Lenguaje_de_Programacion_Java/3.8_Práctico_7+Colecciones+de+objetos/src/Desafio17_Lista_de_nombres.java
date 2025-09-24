/*
* Desafio17_Lista_de_nombres
* Programa que lee nombres y los almacena en un ArrayList, mostrando luego el contenido. 
*/
import java.util.ArrayList; // Importamos la clase ArrayList
import java.util.Scanner;   // Importamos Scanner para leer desde teclado

public class Desafio17_Lista_de_nombres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos scanner para leer la entrada del usuario
        // Explicación: Scanner nos permite leer texto que el usuario escriba por consola.
        
        System.out.print("¿Cuántos nombres vas a ingresar? ");
        int n = Integer.parseInt(scanner.nextLine().trim()); // Leemos la cantidad de nombres a ingresar
        // Explicación: parseInt convierte la cadena a entero; usamos nextLine() para evitar saltos de línea.
        
        ArrayList<String> nombres = new ArrayList<>(); // Creamos la lista donde guardaremos los nombres
        // Explicación: ArrayList es una lista dinámica que crece según agregamos elementos.
        
        for (int i = 0; i < n; i++) { // Bucle para leer cada nombre
            System.out.print("Ingrese el nombre #" + (i + 1) + ": ");
            String nombre = scanner.nextLine(); // Leemos el nombre completo (puede tener espacios)
            // Explicación: nextLine() lee toda la línea hasta encontrar Enter
            
            nombres.add(nombre); // Añadimos el nombre a la lista
            // Explicación: add() inserta un elemento al final del ArrayList.
        }
        
        System.out.println("\nNombres ingresados:"); // Título de la lista de salida
        for (String nombre : nombres) { // Recorremos la lista con for-each
            // Explicación: for-each recorre automáticamente todos los elementos
            System.out.println("- " + nombre); // Mostramos cada nombre
        }
        
        System.out.println("\nTotal de nombres: " + nombres.size()); // Mostramos cantidad total
        // Explicación: size() devuelve cuántos elementos tiene el ArrayList
        
        scanner.close(); // Cerramos el scanner 
        // Explicación: close() libera los recursos del scanner
    }
}