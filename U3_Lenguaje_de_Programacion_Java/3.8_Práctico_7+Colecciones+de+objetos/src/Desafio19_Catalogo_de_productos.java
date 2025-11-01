/*
 * Desafio19_Catalogo_de_productos
* Usar un HashMap<Integer,String> donde la clave sea el código de producto y el valor su nombre. 
* Mostrar todos los productos con sus claves.
 */
import java.util.HashMap; // Importamos HashMap para crear estructura clave-valor eficiente
import java.util.Map;     // Importamos Map interface para usar Entry en la iteración
import java.util.Scanner; // Importamos Scanner para capturar entrada del usuario desde consola

public class Desafio19_Catalogo_de_productos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos objeto Scanner vinculado a entrada estándar
        
        System.out.print("¿Cuántos productos vas a ingresar? ");
        int n = Integer.parseInt(scanner.nextLine().trim()); // Leemos línea, eliminamos espacios y convertimos a entero
        
        HashMap<Integer, String> catalogo = new HashMap<>(); // Inicializamos HashMap: código(Integer) -> nombre(String)
        
        // Bucle para ingresar n productos al catálogo
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese código del producto #" + (i + 1) + ": "); // Mostramos número correlativo (+1 para mostrar desde 1)
            int codigo = Integer.parseInt(scanner.nextLine().trim()); // Convertimos entrada a entero para usar como clave
            
            System.out.print("Ingrese nombre del producto #" + (i + 1) + ": ");
            String nombre = scanner.nextLine(); // Leemos nombre como String sin conversión adicional
            
            catalogo.put(codigo, nombre); // Insertamos par clave-valor; si código existe, sobreescribe el nombre anterior
        }
        
        System.out.println("\nCatálogo de productos:"); // Salto de línea para separar entrada de salida
        
        // Iteramos usando entrySet() que devuelve Set<Map.Entry> con pares clave-valor
        for (Map.Entry<Integer, String> entrada : catalogo.entrySet()) {
            // getKey() obtiene la clave (código), getValue() obtiene el valor (nombre)
            System.out.println("Código: " + entrada.getKey() + " - Nombre: " + entrada.getValue());
        }
        
        scanner.close(); // Liberamos recursos del Scanner para evitar memory leaks
    }
}