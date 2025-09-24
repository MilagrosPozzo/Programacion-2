/*
* Desafío 22 – Diccionario de palabras
*Crear un TreeMap<String,String> que almacene palabras en inglés como clave y su traducción al español como valor. 
*Mostrar en orden alfabético.
*/
import java.util.Map;     // Interfaz Map, necesaria para usar Map.Entry en iteración
import java.util.Scanner; // Scanner para capturar entrada del usuario desde teclado
import java.util.TreeMap; // TreeMap: mapa que mantiene claves ordenadas automáticamente

public class Desafio22_Diccionario_de_palabras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto Scanner vinculado a entrada estándar
        
        System.out.print("¿Cuántas palabras vas a agregar al diccionario? ");
        int n = Integer.parseInt(scanner.nextLine().trim()); // Convierte entrada a entero, elimina espacios
        
        /* TreeMap<String, String>: Mapa ordenado que usa árbol rojo-negro internamente
         * Características clave:
         * - Claves ordenadas automáticamente (orden natural de String = alfabético)
         * - Operaciones put/get: O(log n) debido a estructura de árbol
         * - Mantiene orden incluso después de inserciones/eliminaciones
         * - No permite claves null, pero sí valores null */
        TreeMap<String, String> diccionario = new TreeMap<>();
        
        // Bucle para capturar n pares clave-valor (inglés-español)
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese palabra en inglés #" + (i + 1) + ": "); // Numeración desde 1 para usuario
            String ingles = scanner.nextLine().trim(); // Lee palabra clave, elimina espacios laterales
            
            System.out.print("Ingrese su traducción al español: ");
            String espanol = scanner.nextLine().trim(); // Lee traducción, elimina espacios laterales
            
            /* put(clave, valor): inserta o actualiza entrada en el TreeMap
             * - Si clave no existe: crea nueva entrada
             * - Si clave ya existe: reemplaza valor anterior
             * - TreeMap reordena automáticamente después de cada inserción
             * - Retorna valor anterior asociado a la clave (null si era nueva) */
            diccionario.put(ingles, espanol);
        }
        
        System.out.println("\nDiccionario (ordenado por palabra en inglés):");
        
        /* Iteración usando entrySet(): devuelve Set<Map.Entry<String, String>>
         * - entrySet(): conjunto de pares clave-valor del mapa
         * - Map.Entry<String, String>: objeto que encapsula un par clave-valor
         * - TreeMap garantiza que entrySet() devuelve elementos en orden alfabético de claves
         * - Iteración es O(n) donde n es número de elementos */
        for (Map.Entry<String, String> e : diccionario.entrySet()) {
            /* getKey(): obtiene la clave (palabra en inglés) del par actual
             * getValue(): obtiene el valor (traducción al español) del par actual
             * Formato de salida: "clave -> valor" para claridad visual */
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        
        scanner.close(); // Libera recursos del Scanner y cierra System.in
        }
   }