/*
* Desafio20_Conjunto_de_ciudades
* Crear un HashSet<String> con nombres de ciudades. Mostrar las ciudades.
* Verificar si “Colonia” está presente.
*/
import java.util.HashSet; // HashSet: almacena elementos únicos, búsquedas O(1)
import java.util.Scanner; // Scanner: lectura de datos desde teclado

public class Desafio20_Conjunto_de_ciudades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Entrada estándar para capturar datos usuario
        
        /* HashSet<String>: conjunto que garantiza unicidad de elementos
         * - Sin duplicados: "Madrid" + "Madrid" = solo un "Madrid"  
         * - Sin orden: no preserva secuencia de inserción
         * - Eficiente: búsquedas/inserciones en tiempo constante promedio */
        HashSet<String> ciudades = new HashSet<>();
        
        System.out.println("Ingrese ciudades (escriba 'fin' para terminar):");
        
        while (true) { // Bucle infinito controlado por break interno
            String ciudad = sc.nextLine().trim(); // Lee línea completa, elimina espacios laterales
            
            if (ciudad.equalsIgnoreCase("fin")) { // Comparación insensible a mayúsculas
                break; // Rompe bucle y continúa con línea posterior al while
            }
            
            ciudades.add(ciudad); // add() ignora automáticamente duplicados en HashSet
        }
        
        // toString() de HashSet: formato [elemento1, elemento2, ...] en orden hash
        System.out.println("\nCiudades registradas: " + ciudades);
        
        /* Stream API + Lambda para búsqueda funcional:
         * - stream(): convierte colección en flujo procesable
         * - anyMatch(): operación terminal que retorna boolean
         * - c -> c.equalsIgnoreCase("Colonia"): lambda que define condición */
        boolean colonia = ciudades.stream().anyMatch(c -> c.equalsIgnoreCase("Colonia"));
        
        // Operador ternario: expresión concisa para if-else simple
        System.out.println("¿Está 'Colonia' presente? " + (colonia ? "Sí" : "No"));
        
        sc.close(); // Libera recursos del Scanner, previene resource leaks
    }
}