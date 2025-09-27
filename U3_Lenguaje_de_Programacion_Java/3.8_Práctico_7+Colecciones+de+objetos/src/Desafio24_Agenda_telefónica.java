/*
* Desafío 24 – Agenda telefónica
* Crear un HashMap<String,String> para representar una agenda donde la clave es el nombre y el valor el teléfono. 
* Mostrar todos los contactos.
*/
import java.util.HashMap; // Importamos HashMap que es una estructura de datos clave-valor

public class Desafio24_Agenda_telefónica {
    public static void main(String[] args) {
        
        // Creamos la agenda usando HashMap porque necesitamos asociar nombres (clave) con teléfonos (valor)
        // HashMap permite búsquedas rápidas O(1) y no permite claves duplicadas
        HashMap<String, String> agenda = new HashMap<>(); // String para nombre, String para teléfono
        
        // Agregamos contactos usando put() que inserta o actualiza pares clave-valor
        agenda.put("Ana", "091111111");     // put() asocia la clave "Ana" con el valor "091111111"
        agenda.put("Luis", "092222222");    // Si la clave ya existiera, put() reemplazaría el valor anterior
        agenda.put("Pedro", "093333333");   // Cada put() incrementa el tamaño del HashMap internamente
        
        // Mostramos los contactos recorriendo todas las claves
        System.out.println("Agenda telefónica:");
        
        // keySet() devuelve un Set con todas las claves del HashMap
        // for-each itera sobre cada clave sin necesidad de índices
        for (String nombre : agenda.keySet()) { // nombre toma cada clave una por vez
            
            // get(clave) busca y retorna el valor asociado a esa clave
            // Si la clave no existe, get() retornaría null
            System.out.println(nombre + " -> " + agenda.get(nombre)); // Concatenamos nombre y teléfono
        }
        
        /* RAZONAMIENTO DEL DISEÑO:
         * 1. Usamos HashMap porque necesitamos asociar nombres únicos con teléfonos
         * 2. String para ambos tipos porque nombres y teléfonos son texto
         * 3. keySet() + for-each es la forma más limpia de recorrer un HashMap
         * 4. get() nos permite acceder al valor (teléfono) usando la clave (nombre)
         * 5. HashMap mantiene internamente una tabla hash para acceso rápido
         */
    }
}
