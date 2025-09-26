/*
* Desafío 24 – Agenda telefónica
* Crear un HashMap<String,String> para representar una agenda donde la clave es el nombre y el valor el teléfono. 
* Mostrar todos los contactos.
*/
import java.util.HashMap; // Para la estructura clave-valor
import java.util.Map;     // Para iterar las entradas
import java.util.Scanner; // Para leer valores

public class Desafio24_Agenda_telefónica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner para leer desde consola

        System.out.print("¿Cuántos contactos vas a ingresar? ");
        int n = Integer.parseInt(scanner.nextLine().trim()); // Cantidad de contactos

        HashMap<String, String> agenda = new HashMap<>(); // Mapa nombre -> teléfono

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese nombre del contacto #" + (i + 1) + ": ");
            String nombre = scanner.nextLine().trim(); // Leemos nombre
            System.out.print("Ingrese teléfono de " + nombre + ": ");
            String telefono = scanner.nextLine().trim(); // Leemos teléfono (string para aceptar guiones)
            agenda.put(nombre, telefono); // Guardamos en el HashMap
        }

        System.out.println("\nContactos en la agenda:");
        for (Map.Entry<String, String> e : agenda.entrySet()) {
            // Recorremos y mostramos cada par nombre -> teléfono
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        scanner.close(); // Cerramos scanner
    }
}
