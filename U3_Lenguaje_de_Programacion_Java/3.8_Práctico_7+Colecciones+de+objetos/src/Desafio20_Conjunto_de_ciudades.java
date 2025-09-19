// Desafio20_Conjunto_de_ciudades
// Crear un HashSet<String> con nombres de ciudades. Mostrar las ciudades.
// Verificar si “Colonia” está presente.

/// Importamos HashSet: estructura de datos que almacena elementos únicos (sin duplicados)
// y permite búsquedas muy rápidas O(1) en promedio
import java.util.HashSet;

// Importamos Scanner para leer datos del usuario desde el teclado
import java.util.Scanner;

public class Desafio20_Conjunto_de_ciudades {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para capturar la entrada del usuario
        // System.in representa la entrada estándar (teclado)
        Scanner sc = new Scanner(System.in);
        
        // Creamos un HashSet de String para almacenar nombres de ciudades
        // HashSet<String> significa: conjunto que solo acepta objetos String
        // Características del HashSet:
        // - No permite duplicados (si agregas "Madrid" dos veces, solo queda uno)
        // - No mantiene orden de inserción
        // - Búsquedas muy rápidas
        HashSet<String> ciudades = new HashSet<>();
        
        // Mostramos las instrucciones al usuario
        System.out.println("Ingrese ciudades (escriba 'fin' para terminar):");
        
        // Bucle infinito que se ejecuta hasta que el usuario escriba "fin"
        // while (true) crea un bucle que se repite indefinidamente
        // Solo se detiene cuando encuentra un "break"
        while (true) {
            // Leemos una línea completa del usuario
            // nextLine() captura todo el texto hasta presionar Enter
            // trim() elimina espacios en blanco al inicio y final
            String ciudad = sc.nextLine().trim();
            
            // Verificamos si el usuario quiere terminar
            // equalsIgnoreCase() compara strings sin importar mayúsculas/minúsculas
            // Así "FIN", "fin", "Fin" son todos válidos para salir
            if (ciudad.equalsIgnoreCase("fin")) {
                break; // break termina el bucle while inmediatamente
            }
            
            // Agregamos la ciudad al HashSet
            // add() intenta agregar el elemento al conjunto
            // Si la ciudad ya existe, HashSet automáticamente la ignora (no duplica)
            ciudades.add(ciudad);
        }
        
        // Mostramos todas las ciudades registradas
        // El método toString() de HashSet muestra los elementos entre corchetes []
        // Ejemplo: [Madrid, Barcelona, Sevilla]
        // NOTA: El orden mostrado puede ser diferente al orden de entrada
        System.out.println("\nCiudades registradas: " + ciudades);
        
        // Verificamos si "Colonia" está presente usando programación funcional (Streams)
        // ciudades.stream() convierte el HashSet en un Stream (flujo de datos)
        // anyMatch() verifica si ALGÚN elemento cumple la condición especificada
        // c -> c.equalsIgnoreCase("Colonia") es una expresión lambda (función anónima)
        // que dice: "para cada ciudad 'c', verifica si es igual a 'Colonia' ignorando mayúsculas"
        boolean colonia = ciudades.stream().anyMatch(c -> c.equalsIgnoreCase("Colonia"));
        
        // Mostramos el resultado usando el operador ternario
        // Sintaxis: condición ? valorSiVerdadero : valorSiFalso
        // Si colonia es true, imprime "Sí", si es false, imprime "No"
        System.out.println("¿Está 'Colonia' presente? " + (colonia ? "Sí" : "No"));
        
        // Cerramos el Scanner para liberar recursos del sistema
        // Buena práctica: siempre cerrar recursos cuando terminemos de usarlos
        sc.close();
    }
}